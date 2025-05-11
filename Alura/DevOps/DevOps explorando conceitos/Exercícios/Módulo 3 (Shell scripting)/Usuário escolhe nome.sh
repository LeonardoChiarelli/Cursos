#! /bin/bash

if [ "$#" -lt 1 ]; then
	echo "O programa $0 requer o nome do diretório a ser criado"
	exit 1
fi

nome_diretorio="$1"
mkdir "$nome_diretorio"
echo "O diretório $nome_diretório foi criado com sucesso!"
