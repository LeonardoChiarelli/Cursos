<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="../../../style.css">
        <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
        <title>Antecessor e Sucessor</title>
    </head>
    <body>
        <main>
            <?php 
                $num = $_REQUEST["num"] ?? "Número não informado";
                echo "<p>O número escolhido foi $num <br> o Seu <em>antecessor</em> é " .$num-1 ."<br> O seu <em>sucessor</em> é " .$num+1 ."</p>";
            ?>
            <button onclick="history.go(-1)">&#x2B05;Voltar</button>
        </main>
    </body>
</html>