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
            main#v1{
                margin: auto;
                padding: 10px;
                width: 85vw;
                text-align: center;
                font-size: 1.4em;
            }
            main#v2{
                margin: auto;
                padding: 10px;
                width: 85vw;
                text-align: justify;
            }
        </style>
    </head>
    <body>
        <main id="v1">
            <?php
                $v = phpversion();
                echo "<p>Olá Mundo! \u{1F30E}<br> Está é a primeira aula de PHP Moderno usando a versão $v do PHP</p>";
            ?>
        </main>
        <main id="v2">
            <h1>DADOS DO SERVIDOR:</h1>
            <?php 
                phpinfo();    
            ?>
        </main>
    </body>
</html>