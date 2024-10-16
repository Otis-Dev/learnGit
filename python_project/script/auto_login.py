import os, time, subprocess, logging
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.common.exceptions import WebDriverException


# Environment variables
USR_TENTEN = os.environ.get("USR_TENTEN")
PWD_TENTEN = os.environ.get("PWD_TENTEN")
IP_TENTEN = os.environ.get("IP_TENTEN")

# Logging setup
logging.basicConfig(filename='/home/otis_wsl/update_DNS.log', level=logging.DEBUG,
                    format="%(asctime)s - %(levelname)s - %(message)s")

# Website URLs
url = 'https://domain.tenten.vn/ApiDnsSetting'

def get_public_ip():
    """Fetches the current public IP address."""
    result = subprocess.run(["curl", "icanhazip.com"], capture_output=True, text=True)
    return result.stdout.strip()

def check_ip_changed(new_ip):
    """Compares the new IP with the stored IP and updates if different."""
    if new_ip != IP_TENTEN:
        with open("/home/otis_wsl/myRepo/python_project/script/my_var.sh", "w") as file:
            file.write(f'#!/bin/bash\nexport IP_TENTEN="{new_ip}"\n')
        return True
    return False

def change_dns_tenten(new_ip):
    """Logs into the DNS provider's website and updates the DNS record."""
    try:
        # Initialize webdriver
        options = Options()
        service = Service(ChromeDriverManager().install())
        driver = webdriver.Chrome(service=service, options=options)
        driver.get(url)
        time.sleep(1)
        driver.find_element(By.NAME, "username").send_keys(USR_TENTEN)
        driver.find_element(By.NAME, "password").send_keys(PWD_TENTEN)
        driver.find_element(By.NAME, "submit").click()
        time.sleep(10)

        # Wait for the page to load (better to use explicit waits here)
        if "DNS" in driver.title:
            logging.info("Login successful. Changing DNS...")
            driver.find_element(By.CLASS_NAME, "e_edit_record").click()
            time.sleep(1)
            driver.find_element(By.CLASS_NAME, "w_res_input").clear()
            driver.find_element(By.CLASS_NAME, "w_res_input").send_keys(new_ip)
            driver.find_element(By.CLASS_NAME, "save_changed").click()
            logging.info("DNS change successful!")
            time.sleep(10)
        else:
            logging.error("Login failed.")

    except WebDriverException as e:
        logging.error(f"Error during DNS change: {e}")
    finally:
        driver.quit()

def main():
    """Main function to orchestrate the script."""

    new_ip = get_public_ip()
    if check_ip_changed(new_ip):
        logging.info("IP changed. Updating DNS...")
        change_dns_tenten(new_ip)
    else:
        logging.info("IP not changed.")

if __name__ == "__main__":
    main()