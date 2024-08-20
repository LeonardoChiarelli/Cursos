<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../../style.css">
        <title>???</title>
    </head>
    <body>
        <main>
            <?php
    require_once "Class/aluno.php"; require_once "Class/bolsista.php"; require_once "Class/visitante.php"; require_once "Class/pessoa.php"; 
                $v1 = new Visitante("Pedro", 18, "M");
                var_dump($v1);
                echo "<hr>";
                $a1 = new Aluno("Pedro", 18, "M", 800, "ADS");
                var_dump($a1);
                $a1->pagarMensalidade(1992);
                echo "<hr>";
                $b1 = new Bolsista("José", 8, "M", 111, "ADS", 500);
                var_dump($b1);
                $b1->pagarMensalidade(1992);
            ?>
        </main>
    </body>
</html>