#!/usr/bin/lua

local M = {}

-- donne la valeur IN ou OUT au fichier correspondant au sens d'un pin
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

-- donne la valeur 1 (HIGH) ou 0 (LOW) au fichier correspondant à un pin
function valeurGPIO(numFichier, valeur)
	nameFile = "./sh.sh"
	file = io.open(nameFile, "a")
	io.output(file)
	io.write("echo " .. valeur .." | sudo tee /sys/class/gpio/gpio" .. numFichier .."/value\n")
	io.close(file)
end

--met le programme en pause pendant x secondes
function sleep(time)
	nameFile = "./sh.sh"
	file = io.open(nameFile, "a")
	io.output(file)
	io.write("sleep " .. time .."\n")
	io.close(file)	
end

M.sensGPIO = sensGPIO
M.valeurGPIO = valeurGPIO
M.sleep = sleep

return M



