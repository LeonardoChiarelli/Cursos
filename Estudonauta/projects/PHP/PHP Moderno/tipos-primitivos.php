<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
        <title>Tipos Primitivos em PHP</title>
        <style>
            body{
                background-color: antiquewhite;
            }
            main{
                margin: auto;
                width: 65vw;
                padding: 10px;
                font-size: 1.3em;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>Teste de tipos primitivos:</h1>
        <main>
            <?php
                $num = 0x1A; # Todo número começado em '0x' representa a base hexadecimal
                echo "'0x1A' na base decimal equivale ao número $num <br>";

                $num = 0b1010; # Todo número começado em '0b' representa a base binária
                echo "'0b1010' na base decimal equivale ao número $num <br>";

                $num = 010; # Todo número começado em '0' representa a base octal
                echo "'010' na base decimal equivale ao número $num <br>";

                $num = (int) 3e2;  # Utilizando a coerção para forçar que p número seja caracterizado como inteiro
                echo "'3e2' para o PHP significa 3x10^2, ou seja, $num";

                # OBJETO

                class Pessoa {
                    private string $nome;
                }
                $p = new Pessoa;
                var_dump($p);
            ?>
        </main>
    </body>
</html>

<!-- 
    usando 'ctrl + ;'
    o windows transforma tudo que foi selecionado
    em comentário em qualquer linguagem 
-->