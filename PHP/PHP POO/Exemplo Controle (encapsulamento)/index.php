<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../style.css">
        <title>Controle Remoto</title>
    </head>
    <body>
        <main>
            <h1>Projeto Controle Remoto</h1>
            <?php 
            require_once "Class/controleRemoto.php";
                $c = new ControleRemoto;
                $c->ligar();
                $c->maisVolume();
                $c->abrirMenu();
            ?>
        </main>
    </body>
</html>