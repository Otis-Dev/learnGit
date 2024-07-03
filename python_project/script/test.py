from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
import time
from os import getenv

USR_TENTEN = getenv('USR_TENTEN')
PWD_TENTEN = getenv('PWD_TENTEN')
ip = "10.10.1.20"
# Configure Chrome Options (Optional)
options = Options()

# -- Headless Mode (Uncomment to run Chrome without a visible window)
# options.add_argument('--headless')
# options.add_argument('--disable-gpu') 

# -- Disable Sandboxing (For special environments)
# options.add_argument('--no-sandbox')
# options.add_argument('--disable-dev-shm-usage')

# -- Set User Agent (Mimic a specific browser)
# user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36'
# options.add_argument(f'user-agent={user_agent}')

# Start the Chrome WebDriver (Automatic download if needed)
service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service, options=options)

# Open a Website
url = 'https://domain.tenten.vn/ApiDnsSetting'  # Replace with the desired URL
driver.get(url)

# Perform Actions (Example: Get the title of the page)
page_title = driver.title
print(f"Page title: {page_title}")
time.sleep(1)
username = driver.find_element(By.NAME, "username")
username.send_keys(USR_TENTEN)
passwd = driver.find_element(By.NAME, "password")
passwd.send_keys(PWD_TENTEN)
driver.find_element(By.NAME, "submit").click()
time.sleep(10)
print("Success")

driver.find_element(By.CLASS_NAME, "e_edit_record").click()
time.sleep(2)
driver.find_element(By.CLASS_NAME, "w_res_input").clear()
ip_tenten = driver.find_element(By.CLASS_NAME, "w_res_input")
ip_tenten.send_keys(ip)
time.sleep(2)
driver.find_element(By.CLASS_NAME, "save_changed").click()
time.sleep(60)
# Close the Browser
driver.quit()   

