<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
        <title>Primeira aula de PHP Moderno</title>
        <style>
            body{
                background-color: antiquewhite;
            }
            main.v1{
                margin: auto;
                padding: 10px;
                width: 85vw;
                text-align: center;
                font-size: 1.4em;
            }
            main.v2{
                margin: auto;
                padding: 10px;
                width: 85vw;
                text-align: justify;
            }
        </style>
    </head>
    <body>
        <main class="v1">
            <?php
                $v = phpversion();
                echo "<p>Olá Mundo! \u{1F30E}<br> Está é a primeira aula de PHP Moderno usando a versão $v do PHP</p>";

                echo "<p>Hoje é dia " .date("d/M.Y"); # 'D' -> dia da semana ; 'd' -> dia numérico ; 'M' -> mês ; 'm' -> mês numérico ;'Y' -> ano completo ; 'y' -> ano com apneas os 2 últimos dígitos

                date_default_timezone_set("America/Sao_Paulo"); # Para configurar a área padrão da data, no nosso caso para 'UTC'
                echo " e o horário atual é " .date("G:i:s") . "</p>"; # 'G' representa as horas, 'i' representa os minutos e 's' representa os segundos
            ?>
        </main>
        <main class="v2">
            <h1>DADOS DO SERVIDOR:</h1>
            <?php 
                phpinfo();    
            ?>
        </main>
    </body>
</html>
<!-- 
            1. "<script language='php'> </script>" -> já foi uma forma de iniciar um código PHP em versões antigas, abaixo da 5.6.40
            2. "<?php ?>" -> super tag PHP, maneira aceita nos dias atuais
            3. "<? ?>" -> mais uma maneira de delimitar códigos PHP, mas com uma sintaxe mais reduzida (short open tag)
            4. "<% %>" -> forma de delimitação da linguagem 'concorrente' do PHP (ASP tag), PHP por muitos anos utilizou essa forma, mas hoje em dia não é mais aceita
            5. <?= "" ?> ->(short tag PHP) Para casos onde existe apenas um comando dentro da super tag (comando esse que seja um 'echo' ou um 'print') pode-se usar esta simplificação  
-->
<!-- 
            Caso futuramente queira habilitar a short open tag, basta ir no arquivo 'php.ini' e modificar o código 'short_open_tag=Off' para 'On'
-->