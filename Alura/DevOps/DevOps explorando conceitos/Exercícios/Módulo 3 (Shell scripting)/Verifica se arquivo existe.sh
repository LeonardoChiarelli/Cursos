#! /bin/bash

if [ "$#" -lt 1 ]; then
	echo "O programa $0 requer o nome de um arquivo para verificar sua existência"
	exit 1
fi
diretorio="/mnt/c/Users/lrchi/Documents/[R] Cursos/Alura/DevOps/DevOps explorando conceitos"
nome_arquivo="$1"
if [ -e "$diretorio/$nome_arquivo" ]; then
	echo "O arquivo $nome_arquivo existe e está no seguinte caminho $diretorio"
	exit 0
else
	echo "O arquivo $nome_arquivo não existe no diretório: $diretorio"
	exit 1
fi
