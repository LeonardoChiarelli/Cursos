<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
        <title>Tipos de String</title>
        <style>
            body{
                background-color: antiquewhite;
            }
            main{
                margin: auto;
                width: 65vw;
                font-size: 1.3em;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <main>
            <?php 
                $nom = "Rodrigo";
                $snom = "Nogueira";
                echo "$nom \"Minotauro\" $snom"; # Usar \" \" (sequência de escape) para colocar algo dentro de "" em uma string

/* 
            SEQUÊNCIAS DE ESCAPE
            \n - Nova linha
            \t - Tabulação horizontal (apertar o Tab)
            \\ - Exibição da \
            \$ - Exibição do $
            \u{} - Exibição de emojis, ou caracteres unicode
*/
            ?>
        </main>
    </body>
</html>