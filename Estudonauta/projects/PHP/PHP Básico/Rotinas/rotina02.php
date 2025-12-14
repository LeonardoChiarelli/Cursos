<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
    <title>Rotinas (Funções)</title>
</head>
<body>
    <?php 
        function testeV($x){ #Passagem por valor
            $x += 2;
            echo "<p>O valor de x é $x";
        }
        $a = 3;
        testeV($a);
        echo " e o valor de a é $a</p>";

        function testeR(&$y){ #Passagem por referência
            $y += 2;
            echo "<p>O valor de y é $y";
        }
        $b = 3;
        testeR($b);
        echo " e o valor de b é $b</p>";

        include "funções.php"; # Rotinas externas, ou seja, usando funções que estão em outro arquivo, pode ser utilizado várias vezes no mesmo programa, diferentemente do 'include_once' que só sera utilizado uma vez
        echo "<h1>Testando novas funções</h1>";
        ola();
        mostraValor(6);

        # require "funções.php"; mesma coisa do 'include', mas caso o arquivo não seja encontrado o programa irá parar justamente no arquivo não encontrado, valendo a mesma coisa para o 'require_once'
    ?>
</body>
</html>