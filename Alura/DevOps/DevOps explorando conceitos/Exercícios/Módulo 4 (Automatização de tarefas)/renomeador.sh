#! /bin/bash

read -p "Informe a operação desejada, prefixo, sufixo ou conversor: " operacao

if [[ "$operacao" == "prefixo" || "$operacao" == "sufixo" || "$operacao" == "converor" ]]; then
	if ! command -v rename &> /dev/null; then
		echo "'rename' não encontrado. Instalando..."
		sudo apt install rename -y
	fi
fi

case "$operacao" in
	"prefixo")
		read -p "Informe o prefixo que você deseja adicionar: " prefixo
		rename "s/^/${prefixo}/" *.txt
		echo "Arquivos renomeados com o prefixo '$prefixo'"
		exit 0
	;;
	"sufixo")
		read -p "Informe o sufixo que você deseja adicionar: " sufixo
		rename "s/(.*)\.txt\$/\1${sufixo}.txt/" *.txt
		echo "Arquivos renomeados com o sufixo '$sufixo'"
		exit 0
	;;
	"conversor")
		read -p "Informe a extensão dos arquivo que dejesa modificar: " extensao_entrada
		read -p "Informe a extensão que deseja: " extensao_final
		rename "s#\.${extensao_entrada}#.${extensao_final}#" *."${extensao_entrada}"
		echo "Arquivos .$extensao_entrada foram convertidos para .$extensao_final"
		exit 0
	;;
	*)
	echo "Opção inválida"
	echo "Selecione prefixo, sufixo ou conversor"
	exit 1
	;;
esac
