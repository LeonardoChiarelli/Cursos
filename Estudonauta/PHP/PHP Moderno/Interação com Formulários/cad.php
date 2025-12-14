<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../style.css">
        <title>Resultado</title>
    </head>
    <body>
        <header>
            <h1>Resultado do processamento:</h1>
        </header>
        <main>
            <?php
                $nome = $_REQUEST["nNome"] ?? "Dado não fornecido"; # Super-Global: $_REQUEST pode ser usada tanto para GET, POST ou COOKIES

                $sobrenome = $_REQUEST["nSobrenome"] ?? "Dado não fornecido"; # '??' é um operador de coalecência nula, ou seja, se os valores não forem passados, ele mostrará a mensagem padrão que virá a ser configurada
                
                echo "<p>Boas Vindas, é um prazer te conhecer, <strong>$nome $sobrenome</strong>! Este é p meu site</p>";
            ?>
            <p><a href="javascript:history.go(-1)">Voltar</a></p>
        </main>
    </body>
</html>