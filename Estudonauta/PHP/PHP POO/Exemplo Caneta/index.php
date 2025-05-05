<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Comptible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../style.css">
    </head>
    <body>
        <main>
            <?php
                require_once "../Class/Caneta.php";
                $c1 = new Caneta("NIC", "Verde", 0.7); // Parâmetros do construct
                $c1->setModelo("BIC Cristal");
                $c1->setPonta(0.5);
                echo "<p>Modelo: {$c1->getModelo()} <br> Cor: {$c1->getCor()} <br>Ponta: {$c1->getPonta()} </p>"; // Colocando os métodos entre {} para facilitar a intetpolação

                $c2 = new Caneta("BIC Cristal", "Azul", 0.7);
                var_dump($c2);
            ?>
        </main>
    </body>
</html>