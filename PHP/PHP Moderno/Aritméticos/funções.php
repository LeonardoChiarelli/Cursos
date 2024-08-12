<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../../style.css">
    <title>Resultado</title>
</head>
<body>

    <main>
        <?php
            $num1 = $_REQUEST["num1"] ?? "Valor não informado";
            $num2 = $_REQUEST["num2"] ?? "Valor não informado";
            $op = $_REQUEST["operador"] ?? "Operador não informado";

            switch($op){
                case 1:
                    echo "<p>O valor absoluto de $num1 é " .abs($num1) ."</p>";

                    echo "<p>O valor absoluto de $num2 é " .abs($num2) ."</p>";
                break;
                case 2:
                    $n1 = base_convert($num1, 10, 8);
                    $n11 = base_convert($num1, 10, 16);
                    $n111 = base_convert($num1, 10, 2);
                    echo "<p>O valor <strong>$num1</strong> na base octal é \"$n1\", em hexadecimal é \"$n11\", em binário \"$n111\"</p>";

                    $n2 = base_convert($num2, 10, 8);
                    $n22 = base_convert($num2, 10, 16);
                    $n222 = base_convert($num2, 10, 2);
                    echo "<p>O valor <strong>$num2</strong> na base octal é \"$n2\", em hexadecimal é \"$n22\", em binário \"$n222\"</p>";
                break;
                case 3:
                    echo "<p>Com os catetos $num1 e $num2, o valor da hipotenusa é " .hypot($num1, $num2) ."</p>";
                break;
                case 4:
                    $n1 = ceil($num1);
                    $n11 = floor($num1);
                    $n111 = round($num1);
                    echo "<p>O valor $num1 arredondado para cima é $n1, já arredondado para baixo é $n11 e com o arredondamento aritmético é $n111</p>";

                    $n2 = ceil($num2);
                    $n22 = floor($num2);
                    $n222 = round($num2);
                    echo "<p>O valor $num2 arredondado para cima é $n2, já arredondado para baixo é $n22 e com o arredondamento aritmético é $n222</p>";
                break;
                case 5:
                    echo "<p>O resultado inteiro da divisão entre $num1 e $num2 é " .intdiv($num1, $num2) ."</p>";
                break;
                case 6:
                    $min = min($num1, $num2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                    $max = max($num1, $num2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                    echo "<p>O menor valor é $min e o maior valor é $max</p>";
                break;  
                case 7:
                    $n1 = sin($num1);
                    $n11 = cos($num1);
                    $n111 = tan($num1);
                    echo "<p>O seno de $num1 é $n1 (aproximadamente " .round($n1) .") o cosseno é $n11 (aproximadamente " .round($n11) . ") e a tangente é $n111 (aproximadamente " .round($n111) .")</p>";

                    $n2 = sin($num2);
                    $n22 = cos($num2);
                    $n222 = tan($num2);
                    echo "<p>O seno de $num2 é $n2 (aproximadamente " .round($n2) .") o cosseno é $n22 (aproximadamente " .round($n2) .") e a tangente é $n222 (aproximadamente " .round($n2) .")</p>";
                break;
                case 8:
                    $n1 = sqrt($num1);
                    $n2 = sqrt($num2);
                    echo "<p>A raiz quadrada de $num1 é $n1</p>";
                    echo "<p>A raiz quadrade de $num2 é $n2</p>";
                };
        ?>
        <a href="javascript:history.go(-1)">Voltar</a>
    </main>

</body>
</html>