#! /bin/bash

read -p "Informe o limite de espaço limite: " limite
espaco=$(df -h | awk 'NR==2 {print $5}' | sed 's/%//')

if [ "$espaco" -gt "$limite" ]; then
	echo "Alerta: Espaço em disco excedeu $limite%."
else
	echo "Espaço abaixo do limite"
fi
