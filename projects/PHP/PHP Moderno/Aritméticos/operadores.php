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
                    echo "<p>O resultado de $num1 + $num2 é " .$num1+$num2 ."</p>";
                break;
                case 2:
                    echo "<p>O resultado de $num1 - $num2 é " .$num1-$num2 ."</p>";
                break;
                case 3:
                    echo "<p>O resultado de $num1 * $num2 é " .$num1*$num2 ."</p>";
                break;
                case 4:
                    echo "<p>O resultado de $num1 / $num2 é " .$num1/$num2 ."</p>";
                break;
                case 5:
                    echo "<p>O resultado de $num1 % $num2 é " .$num1%$num2 ."</p>";
                break;
                case 6:
                    echo "<p>O resultado de $num1 ** $num2 é " .$num1**$num2 ."</p>";
                };
        ?>
        <a href="javascript:history.go(-1)">Voltar</a>
    </main>

</body>
</html>