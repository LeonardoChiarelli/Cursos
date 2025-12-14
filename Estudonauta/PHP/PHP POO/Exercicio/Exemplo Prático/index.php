<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <?php 
            require_once "Class/contaBanco.php";
        ?>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../style.css">
        <title>Exemplo Prático</title>
    </head>
    <body>
        <main>
            <?php
                $p1 = new Banco();
                $p2 = new Banco();
                $p1->abrirConta("CC");
                $p1->setNumConta(1);
                $p1->setPessoa("Leonardo");
                $p2->setNumConta(2);
                $p2->abrirConta("CP");
                $p2->setPessoa("Ribeiro");

                $p1->depositar(300);
                $p2->depositar(500);
                $p2->sacar(1000);

                $p1->pagarMensal();
                $p2->pagarMensal();

                $p1->sacar(338);
                $p2->sacar(630);

                $p1->fecharConta();
                $p2->fecharConta();

                var_dump($p1);
                var_dump($p2);
            ?>
        </main>
    </body>
</html>