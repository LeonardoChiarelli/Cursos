<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../../style.css">
        <title>Sorteador de Números</title>
    </head>
    <body>
        <main>
            <h1>Trabalhando com números aleatórios</h1>
            <p>Gerando um número entre 0 e 1000...</p>
            <?php 
                echo "<p>O valor gerado foi " .rand(0, 1000) ."</p>";
            ?>
            <button onclick="location.reload()"> &#x1F504;Gerar outro</button>
        </main>
    </body>
</html>