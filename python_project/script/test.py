

with open ("requirements.txt", "r") as f:
    file_data = f.read().replace(' ','')
    print(file_data)
    f.close()

with open ("requirements.txt", "w") as f:
    f.write(file_data)
    f.close()
