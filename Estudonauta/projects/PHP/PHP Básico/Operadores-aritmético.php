<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
        <title>Operadores aritméticos</title>
        <style>
            *{
                font-family: Arial;
            }
            main{
                margin:auto;
                padding: 10px;
                width:75vw;
                text-align: center;
            }
            ul, li{
                line-height: 1.5em;
            }
        </style>
    </head>
    <body>
        <main>
                <?php
                    $n1 = 3;
                    $n2 = 2;
                    $s = $n1 + $n2;
                    $sub = $n1 - $n2;
                    $mult = $n1 * $n2;
                    $d = $n1 / $n2;
                    $m = $n1 % $n2;
                    $media = ($n1 + $n2) / 2;
                    $num = $_GET["a"];
                    $num2 = $_GET["b"];
                    $vabs1 = $_GET["x"];
                    $vabs2 = $_GET["y"];
                    echo "O resultado de $n1 + $n2 é igual a $s <br> O resultado de $n1 - $n2 é igual a $sub <br> O resultado de $n1 * $n2 é igual a $mult <br> O resultado de $n1 / $n2 é igual a $d <br> O resultado de $n1 % $n2 é igual a $m <br> A média entre $n1 e $n2 é $media <br>";
                    echo "<h3>Aqui pegamos os valores da URL, onde a = $num e b = $num2 <br> X = $vabs1 e Y = $vabs2 <br> O valor absoluto de $vabs2 é ". abs($vabs2) ."<br> $vabs1<sup>". abs($vabs2)."</sup> é igual a ". pow($vabs1, abs($vabs2)) . "<br> A raiz quadrada de $vabs1 é igual a ". sqrt($vabs1). "<br> Arredondando $vabs1 temos ". round($vabs1). "<br>O valor inteiro da variável $vabs1 é ". intval($vabs1). "<br> O valor $vabs2 em moeda ficaria R$". number_format($vabs2, 2, ",", "."). "</h3>";
                    /* podemos fazer por concatenação, exemplo do primeiro:
                        echo "O resultado da soma é". (n1+n2);
                        podemos substituir o "round" por 'ceil' (arredondamento para cima) ou por 'floor' (arredondamento para baixo)
                    */
                ?>
        </main> 
        <ul>
            <li>Para passarmos valores de variáveis direto da URL basta seguir o exemplo:</li>
            <ul>
                <li>localhost/projects/PHP%20Básico/operadores-aritméticos.php?a=5&b=7</li>
                <ul>
                    <li>Para receber esses valores de 'a' e 'b' e jogar eles dentro de variáveis temos que usar o parâmetro <strong> $_GET["a"]; </strong> dentro de uma varíavel</li>
                </ul>
            </ul>
            <li>Funções matemáticas</li>
            <ul>
                <li>abs() - Valor Absoluto</li>
                <li>pow() - Potenciação</li>
                <li>sqrt() - Raiz Quadrada</li>
                <li>round() - Arredondamento</li>
                <li>intval() - Valor inteiro da variável</li>
                <li>number_format() - Formatação</li>  
            </ul>
        </ul>
    </body>
</html>