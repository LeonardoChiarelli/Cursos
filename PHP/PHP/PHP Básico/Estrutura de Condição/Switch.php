<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
    <title>Switch</title>
    <style>
        form{
            padding: 10px;
        }
        input, select{
            margin: 10px;
        }
    </style>
</head>
<body>

    <form action="Switch.php" method="post">
        <fieldset>
            <legend>Calculadora simples: </legend>
            <label for="iN1">Número: </label>
            <input type="number" name="n1" id="iN1"> <br>
            <label for="iN2">Número: </label>
            <input type="number" name="n2" id="iN2"> <br>
            <label for="iOp">Operação: </label>
            <select name="op" id="iOp">
                <option value="1">+</option>
                <option value="2">-</option>
                <option value="3">*</option>
                <option value="4">/</option>
                </select> <br>
            <input type="submit" value="Calcular"> <br>
        </fieldset>

            <fieldset>
                <legend>Operações: </legend>
                <label for="iNum">Número: </label>
                <input type="number" name="num" id="iNum">
                <label for="iRes"></label>
                <select name="res" id="iRes">
                    <option value="1">Dobro</option>
                    <option value="2">Cubo</option>
                    <option value="3">Raiz Quadrada</option>
                </select> <br>
                <input type="submit" value="Calcular">
            </fieldset>
            <fieldset>
                <legend>Preciso ir para a escola?</legend>
                <label for="iDiaSemana">Que dia é hoje?</label>
                <select name="diaSemana" id="iDiaSemana">
                    <option value="1">Domingo</option>
                    <option value="2" selected>Segunda-Feira</option>
                    <option value="3">Terça-Feira</option>
                    <option value="4">Quarta-Feira</option>
                    <option value="5">Quinta-Feira</option>
                    <option value="6">Sexta-Feira</option>
                    <option value="7">Sábado</option>
                </select>
                <input type="submit" value="Verificar">
            </fieldset>
    </form>

    <?php   
        $n1 = $_POST["n1"];
        $n2 = $_POST["n2"];
        $op = $_POST["op"];

        switch($op){
            case 1:
                echo "<p>O resultado entre $n1 + $n2 é igual a " .$n1+$n2 ."</p>";
            break;
            case 2:
                echo "<p>O resultado entre $n1 - $n2 é igual a " .$n1-$n2 ."</p>";
            break;
            case 3:
                echo "<p>O resultado entre $n1 * $n2 é igual a " .$n1*$n2 ."</p>";
            break;
            case 4:
                echo "<p>O resultado entre $n1 / $n2 é igual a " .$n1/$n2 ."</p>";
            break;
            default: echo "Operação inválida";
        }

        $num = $_POST["num"];
        $res = $_POST["res"];

        switch($res){
            case 1:
                echo "<p>O dobro de $num é " .$num *2 ."</p>";
            break;
            case 2:
                echo "<p>$num<sup>3</sup> é " .pow($num, 3) ."</p>";
            break;
            case 3:
                echo "<p>A raiz quadrada de $num é " .number_format(sqrt($num), 2) ."</p>";
            break;
            default: echo "Operação inválida";
        }

        $diaSemana = $_POST["diaSemana"];

        switch($diaSemana){
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                echo "Hoje é dia de estudar, vai para escola";
            break;
            case 1:
            case 7:
                echo "Hoje é dia de relaxar, sem escola";
            default: echo "";
        }
    ?>
</body>
</html>