#!/bin/bash

while [[ true ]]; do

	if [[ -f $HOME/codeTablette.txt ]]; then
		lua $HOME/codeTablette.txt;
		cat $HOME/codeTablette.txt > $HOME/arduino/src/sketch.ino;
		cd $HOME/arduino;
		ino build -m leonardo;
		ino upload -m leonardo;
		echo "code executed";
		cat $HOME/codeTablette.txt;
		rm $HOME/codeTablette.txt;
		echo "codeTablette.txt deleted";
		cd $HOME;

	else 
		echo "no new code found";
		sleep 1;
	fi

done
