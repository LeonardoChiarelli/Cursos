<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../style.css">
        <title>Super Globais</title>
    </head>
    <body>
        <main>
            <pre>
                <?php 
                    setcookie("dia-da-semana", "SEGUNDA", time() + 3600); # NOME DO COOKIE, VALOR DO COOKIE E DURAÇÃO

                    session_start(); # INICIAR SESSÃO
                    $_SESSION["teste"] = "FUNCIONOU!"; # VARIÁVEL E DADOS DA SESSÃO

                    echo "<h1>SuperGlobal GET</h1>";
                    var_dump($_GET);

                    echo "<h1>SuperGlobal POST</h1>";
                    var_dump($_POST);

                    echo "<h1>SuperGlobal REQUEST</h1>";
                    var_dump($_REQUEST);

                    echo "<h1>SuperGlobal COOKIE</h1>";
                    var_dump($_COOKIE);

                    echo "<h1>SuperGlobal SESSION</h1>";
                    var_dump($_SESSION);

                    echo "<h1>SuperGlobal ENV</h1>";
                    var_dump($_ENV);
                    // foreach(getenv() as $c => $v){ # Para mostrar as variáveis e o valor, isso foi necessário porque estamo utilizando um servidor local
                    //     echo "<br> $c -> $v";
                    // }

                    echo "<h1>SuperGlobal SERVER</h1>";
                    var_dump($_SERVER);

                    echo "<h1>SuperGlobal GLOBALS</h1>";
                    var_dump($GLOBALS);
                ?>
            </pre>
            <button onclick="history.go(-1)">Voltar</button>
        </main>
    </body>
</html>