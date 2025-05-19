#! /bin/bash

output_file="/mnt/c/Users/lrchi/Documents/[R] Cursos/Alura/DevOps/DevOps explorando conceitos/saida_processos.txt"

ps -e -o pid,user,%mem --sort=-%mem | head -n 16 > "$output_file"
