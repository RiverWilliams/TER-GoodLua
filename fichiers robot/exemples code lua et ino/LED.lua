#!/usr/bin/lua

local lib = require("library")

nameFile = "./sh.sh"
file = io.open(nameFile, "w")
io.output(file)
io.write("echo 1 | sudo tee /sys/class/gpio/export\n")
io.close(file)
lib.sensGPIO(1,1)
lib.valeurGPIO(1,1)
lib.sleep(2)
lib.valeurGPIO(1,0)

os.execute("./sh.sh")
