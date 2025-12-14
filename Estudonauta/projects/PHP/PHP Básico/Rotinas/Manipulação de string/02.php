<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Comatible" content="ie=edge">
        <link rel="shortcut-icon" href="../../../favicon.ico" type="image/x-icon">
        <title>Manipulação de String</title>
    </head>
    <body>
        <?php 

            $nome = "Leonardo Chiarelli";
            $novo = strtolower($nome); # Transforma todas as letras em minúsculo
            echo "<p>$novo</p>";
            $novo = strtoupper($nome); # Transforma todas as letras em maiúsculo
            echo "<p>$novo</p>";

            $nome = "leonardo chiarelli";
            $novo = ucfirst($nome); # Transforma a primeira letra da frase em maiúsculo
            echo "<p>$novo</p>";
            $novo = ucwords($nome);
            echo "<p>$novo</p>"; # Transforma a primeira letra de cada palavra em maiúsculo

            $nome = "Leonardo Chiarelli";
            $novo = strrev($nome);
            echo "<p>$novo</p>"; # Coloca as letras em ordem reversa

            $frase = "Estou aprendendo PHP";
            $pos = strpos($frase, "PHP"); # Basicamente da a posição da string desejada
            echo "<p>$frase <br> A string 'PHP' foi encontrada na posição $pos</p>";
            $pos = stripos($frase, "php"); # Basicamente a mesma coisa da anterior, mas permite buscar a string em minúsculo mesmo ela estando em maiúsculo na frase
            echo "<p>$frase <br> A string 'php' foi encontrada na posição $pos</p>";

            $frase = "Estou aprendendo PHP com o Gustavo Guanabara do Curso em Vídeo no curso de PHP";
            $novo = substr_count($frase, "PHP"); # Conta quantas vezes a mesma palavra foi escrita
            echo "Na frase '$frase' a palavra 'PHP' aparece $novo vezes";
            $site = "Estudonauta e Curso em Vídeo";
            $novo = substr($site, 1, 9); # Fatiamento da string principal, o primeiro número é a posição inicial e o segundo número significa quantas letras vão ser "andadas"
            echo "<p>$novo</p>";

            $nome = "Leonardo";
            $novo = str_pad($nome, 30, "*", STR_PAD_BOTH); # Faz uma string caber em um determinado espaço
            echo "<p>$novo</p>";
            $novo = str_pad($nome, 30, "*", STR_PAD_RIGHT); 
            echo "<p>$novo</p>";
            $novo = str_pad($nome, 30, "*", STR_PAD_LEFT); 
            echo "<p>$novo</p>";

            $txt = str_repeat("PHP ", 5); # Repete determinada string x número de vezes
            echo "<p>$txt" ."<br>" .str_repeat("-", 20) ."</p>";
            
            $frase = "Gosto de estudar Matemática!!!";
            $novo = str_replace("Matemática", "Programação", $frase); # Troca uma palavra por outra, podemos utilizar o 'str_ireplace' para ignorar letras maiúsculas e minúsculas
            echo "<p>$novo</p>";            

        ?>
    </body>
</html>