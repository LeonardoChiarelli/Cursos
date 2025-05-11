#! /bin/bash

diretorio_backup="/mnt/c/Users/lrchi/Documents/[R] Cursos/Alura/DevOps"
nome_arquivo="backup_curso_devops_$(date +%Y%m%d_%H%M%S).tar.gz"
tar -czf "$nome_arquivo" "$diretorio_backup"
echo "Backup concluído em $nome_arquivo"
