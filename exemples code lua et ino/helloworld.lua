#!/usr/bin/lua
function sensGPIO(numFichier, sens)
	nameFile = "./sh.sh"
	file = io.open(nameFile, "a")
	io.output(file)
	if sens==1
	then io.write("echo out | sudo tee /sys/class/gpio/gpio" .. numFichier .."/direction\n")
	else io.write("echo in | sudo tee /sys/class/gpio/gpio" .. numFicher .."/direction\n")
	end
	io.close(file)
end

function valeurGPIO(numFichier, valeur)
	nameFile = "./sh.sh"
	file = io.open(nameFile, "a")
	io.output(file)
	io.write("echo " .. valeur .." | sudo tee /sys/class/gpio/gpio" .. numFichier .."/value\n")
	io.close(file)
end

function sleep(time)
	nameFile = "./sh.sh"
	file = io.open(nameFile, "a")
	io.output(file)
	io.write("sleep " .. time .."\n")
	io.close(file)	
end

nameFile = "./sh.sh"
file = io.open(nameFile, "w")
io.output(file)
io.write("echo 1 | sudo tee /sys/class/gpio/export\n")
io.close(file)
sensGPIO(1,1)
valeurGPIO(1,1)
sleep(2)
valeurGPIO(1,0)

os.execute("./sh.sh")


