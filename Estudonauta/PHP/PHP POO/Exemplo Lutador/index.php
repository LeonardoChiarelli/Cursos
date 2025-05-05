<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../style.css">
        <title>Lutadores</title>
    </head>
    <body>
        <main>
            <?php 
                require_once "Class/lutador.php";
                require_once "Class/luta.php";
                $L = [];
                $L[0] = new Lutador("Pretty Boy", "França", 31, 1.75, 68.9, 11, 2, 1);
                $L[1] = new Lutador("Putscript", "Brasil", 29, 1.68, 57.8, 14, 2 , 3);
                $L[2] = new Lutador("Snapshadow", "EUA", 35, 1.65, 80.9, 12, 2, 1);
                $L[3] = new Lutador("Dead Code", "Austrália", 28, 1.93, 81.6, 13, 0, 2);
                $L[4] = new Lutador("Ufocobol", "Brasil", 37, 1.70, 119.3, 5, 4, 3);
                $L[5] = new Lutador("Nerdaard", "EUA", 30, 1.81, 105.7, 12, 2, 4);
                
                $Luta = [];
                $Luta[0] = new Luta;
                $Luta[0]->marcarLuta($L[0], $L[1]);
                $Luta[0]->lutar();
            ?>
        </main>
    </body>
</html>