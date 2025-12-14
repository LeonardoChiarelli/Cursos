<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
        <title>Variáveis e constantes</title>
        <style>
            body{
                background-color: antiquewhite;
            }
            main{
                margin: auto;
                padding: 10px;
                width: 65vw;
                font-size: 1.3em;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <main>
            <?php
                $nome = "Leonardo";
                $sobrenome = "Chiarelli";
                const PAIS = "Brasil";
                const CURSO = "Análise e Desenvolvimento de Sistemas";
                echo "<p>Prazer, $nome $sobrenome! Você mora no " .PAIS . " e atualmente está cursando " .CURSO .".</p>"; # ao escrever uma constante sempre usar concatenação, pois ela não tem o '$' na frente para fazer a interpolação; podemos escrever 'PAÍS' por mais que no mundo não seja usada a acenteuação, o PHP suporta

                $nomeCompleto = [ # Para métodos e atributos usar o 'camelCase'
                    "Nome" => "Leonardo",
                    "Sobrenome" => "Chiarelli"
                ];
                const CONTATO_FORNECEDOR = "(11) 97651-6376"; # Para nomear constantes usar o 'SNAKE_CASE'
            ?>
        </main>
    </body>
</html>