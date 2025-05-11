#! /bin/bash

diretorio_backup="/mnt/c/Users/lrchi/Documents/[R] Cursos/Alura/DevOps/DevOps explorando conceitos/Exercícios"
nome_arquivo_zip="backup_$(date +%Y%m%d_%H%M%S).tar.gz"

tar -czf "$nome_arquivo_zip" "$diretorio_backup"

echo "Arquvivos no backup:"
tar -tf "$nome_arquivo_zip"

echo "Arquivo .tar.gz salvo como: $nome_arquivo_zip"
