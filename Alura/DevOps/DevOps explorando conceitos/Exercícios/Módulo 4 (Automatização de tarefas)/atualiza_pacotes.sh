#! /bin/bash

sudo apt update -y
echo "Pacotes atualizados com sucesso"

read -p "Há pacotes para disponíveis para upgrade? sim ou não: " operacao
case "$operacao" in
	"sim")
		sudo apt upgrade -y
		echo "Todos os pacotes foram melhorados"
	;;
	"não")
		echo "Fechando script"
		exit 0
	;;
	*)
	echo "Operação inválida"
	echo "Selecione sim ou não"
	exit 1
	;;
esac
