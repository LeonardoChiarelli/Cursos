#! /bin/bash

if pgrep nginx &> /dev/null
then
	echo "O nginx está operando $( date +"%Y-%m-%d%H:%M:%S")"
else
	echo "O nginx está fora de operação $( date +"%Y-%m-%d%H:%M:%S")"
fi
