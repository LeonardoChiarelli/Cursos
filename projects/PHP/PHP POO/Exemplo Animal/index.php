<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../style.css">
        <title>Animais</title>
    </head>
    <body>
        <main>
            <?php 
                require_once "Class/mamifero.php"; require_once "Class/reptil.php"; require_once "Class/peixe.php"; require_once "Class/ave.php"; require_once "Class/cachorro.php"; require_once "Class/canguru.php"; require_once "Class/cobra.php"; require_once "Class/tartaruga.php"; require_once "Class/goldfish.php"; require_once "Class/arara.php"; require_once "Class/lobo.php";

                $m1 = new Mamífero(12.5, 18, 4, "Preto");
                var_dump($m1);
                $m1->locomover();
                $m1->emitirSom();
                echo "<hr>";
                $r1 = new Réptil(2, 38, 4, "Verde");
                var_dump($r1);
                $r1->alimentar();
                echo "<hr>";
                $p1 = new Peixe(5, 10, 0, "Prata");
                var_dump($p1);
                $p1->soltarBolha();
                echo "<hr>";
                $a1 = new Ave(0.600, 4, 4, "Branca");
                var_dump($a1);
                $a1->fazerNinho();
                echo "<hr>";
                $cang = new Canguru(52, 17, 4, "Bege");
                var_dump($cang);
                $cang->usarBolsa();
                echo "<hr>";
                $cob = new Cobra(82, 17, 0, "Preto");
                var_dump($cob);
                $cob->locomover();
                echo "<hr>";
                $tart = new Tartaruga(20, 172, 4, "Verde");
                var_dump($tart);
                $tart->locomover();
                echo "<hr>";
                $gold = new Goldfish(0.2, 1, 0, "Gold");
                var_dump($gold);
                echo "<hr>";
                $ar = new Arara(1.2, 2, 4, "Azul");
                var_dump($ar);
                echo "<hr>";
                $lob = new Lobo(72.4, 10, 4, "Cinza");
                var_dump($lob);
                $lob->emitirSom();
                echo "<hr>";
                $cacho = new Cachorro(11, 4, 4, "Blue");
                var_dump($cacho);
                $cacho->reagirFrase("Olá");
                $cacho->reagirFrase("Safado");
                $cacho->reagirHora(11, 45);
                $cacho->reagirHora(21, 00);
                $cacho->reagirDono(true);
                $cacho->reagirDono(false);
                $cacho->reagirIP(2, 12.5);
                $cacho->reagirIP(17, 4.5);
                echo "<hr>";
            ?>
        </main>
    </body>
</html>