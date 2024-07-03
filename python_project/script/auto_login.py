from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from datetime import datetime
import time, os, subprocess, logging

USR_TENTEN = os.getenv("USR_TENTEN")
PWD_TENTEN = os.getenv("PWD_TENTEN")
IP_TENTEN = os.getenv("IP_TENTEN")
GET_IP_PUB = subprocess.run(["curl", "icanhazip.com"],capture_output=True, text=True)

# Create a logger
logger = logging.getLogger(__name__)

# Set the log level
logger.setLevel(logging.DEBUG)

# Create a file handler
file_handler = logging.FileHandler('/home/otis_wsl/update_DNS.log')
# file_handler.setFormatter(logging.Formatter('[{datetime.datetime.now()}] {message}'))

# Add the file handler to the logger
logger.addHandler(file_handler)

# Define a function to print a message with a timestamp
def log_message(message):
    logger.info(f"[{datetime.now()}] {message}")

def log_error(message):
    logger.error(f"[{datetime.now()}] {message}")

def check_ip_public():
    if IP_TENTEN.find(GET_IP_PUB.stdout):
        return True
    else:
        with open("my_var.sh", "w") as file:
            file.write(f'#!/bin/bash\nexport IP_TENTEN="{GET_IP_PUB}"\n')
        return False

def change_dns_tenten():
    # Configure Chrome Options (Optional)
    options = Options()

    # Start the Chrome WebDriver (Automatic download if needed)
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=options)

    # Open a Website
    url = 'https://domain.tenten.vn/ApiDnsSetting'

    try:
        logger.info("-------Starting change DNS IP---------")
        log_message("Step 1: Access to tenten domain website")
        driver.get(url)
        time.sleep(1)
        log_message("Step 2: Starting login to tenten domain website")
        username = driver.find_element(By.NAME, "username")
        username.send_keys(USR_TENTEN)
        passwd = driver.find_element(By.NAME, "password")
        passwd.send_keys(PWD_TENTEN)
        driver.find_element(By.NAME, "submit").click()
        time.sleep(10)
        page_title = driver.title
        if page_title.find("DNS"):
            log_message("Step 3: Login success -> Staring change DNS")
            driver.find_element(By.CLASS_NAME, "e_edit_record").click()
            time.sleep(2)
            driver.find_element(By.CLASS_NAME, "w_res_input").clear()
            ip_tenten = driver.find_element(By.CLASS_NAME, "w_res_input")
            ip_tenten.send_keys(GET_IP_PUB.stdout)
            time.sleep(2)
            driver.find_element(By.CLASS_NAME, "save_changed ").click()
            log_message("Step 4: Change success!")
            time.sleep(60)
        else:
            log_error("Login failed")
   
    except Exception as E:
        log_error(E)
    finally:
        log_message("Step 5: All done. Close browser")
        driver.quit() 
    
if __name__ == "__main__":
    if check_ip_public():
        log_message("IP not change")
    else:
        log_message("IP changed -> Starting update DNS")
        change_dns_tenten()
        