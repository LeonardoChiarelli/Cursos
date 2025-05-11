#! /bin/bash

read -p "Entre com a operação desejada: converter, redimensionar ou conveter e redimensionar: " operacao
case "$operacao" in
	"converter")
		read -p "Informe o arquivo que deseja converter e sua extensão: " arquivo_entrada
		read -p "Informe o nome do arquivo de saída e sua extensão: " arquivo_saida
		convert "$arquivo_entrada" "$arquivo_saida"
		if [ "$?" -eq 0 ]; then
			echo "Conversão concluida com sucesso"
		else
			echo "Erro ao conveter sua imagem. Verifique se o arquivo existe e se o formato é suportado"
		fi
	;;
	"redimensionar")
		read -p "Informe o arquivo que deseja converter e sua extensão: " arquivo_entrada
		read -p "Informe o nome do arquivo de saída e sua extensão: " arquivo_saida
		read -p "Informe a largura: " largura
		read -p "Informe a altura: " altura
		convert "$arquivo_entrada" -resize "$largura"x"$altura" "$arquivo_saida"
		if [ "$?" -eq 0 ]; then
			echo "Imagem redimensionada para o tamanho $largura x $altura com sucesso"
		else
			echo "Erro ao conveter sua imagem. Verifique se o arquivo existe e se o formato é suportado"
		fi
	;;
	"converter e redimensionar")
		read -p "Informe o arquivo que deseja converter e sua extensão: " arquivo_entrada
		read -p "Informe o nome do arquivo de saída e sua extensão: " arquivo_saida
		read -p "Informe a largura: " largura
		read -p "Informe a altura: " altura
		convert "$arquivo_entrada" -resize "$largura"x"$altura" "$arquivo_saida"
		if [ "$?" -eq 0 ]; then
			echo "Imagem redimensionada para o tamanho $largura x $altura com sucesso e convertida para $arquivo_saida"
		else
			echo "Erro ao conveter sua imagem. Verifique se o arquivo existe e se o formato é suportado"
		fi
	;;
	*)
	echo "Opção inválida"
	echo "Selecione converter, redimensionar ou converter e redimensionar"
	exit 1
	;;
esac

