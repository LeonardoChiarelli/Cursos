#! /bin/bash

diretorio_comp="/mnt/c/Users/lrchi/Documents/[R] Cursos/Alura/DevOps/DevOps explorando conceitos"
read -p "Entre com a operação desejada: compactar ou descompactar: " operacao
case "$operacao" in
	"compactar")
		read -p "Informe o nome do arquivo final (.tar.gz) da compactação: " arquivo_final
		read -p "Quais serão os arquivos que serão compactados, separados por espaços: " -a arquivos

		(cd "$diretorio_comp" && tar -czf "$arquivo_final" "${arquivos[@]}")
		echo "Arquivos compactados com sucesso em $arquivo_final"
	;;
	"descompactar")
		read -p "Informe o nome do arquivo que deseja descompactar (.tar.gz): " arquivo_compactado
		read -p "Informe o diretório de destino: " diretorio

		mkdir -p "$diretorio"
		tar -xzf "$arquivo_compactado" -C "$diretorio"
		echo "Arquivos descompactados em $diretorio"
	;;
	*)
	echo "Operação inválida"
	echo "Selecione compactar ou descompactar"
	exit 1
	;;
esac
