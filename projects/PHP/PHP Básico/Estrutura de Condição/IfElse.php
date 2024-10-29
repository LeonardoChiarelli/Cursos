<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content ="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible"content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <title>If Else</title>
    </head>
    <body>
        <form action="IfElse.php" method="post">
            <fieldset>
                <legend>Você já pode votar?</legend>
                <label for="iAnoNascimento">Informe seu ano de Nascimento: </label>
                <input type="number" name="anoNascimento" id="iAnoNascimento" placeholder="4 dígitos"> <br>
                <input type="submit" value="Verificar">
            </fieldset>
            <fieldset>
                <legend>Confira sua média: </legend>
                <label for="iN1">Valor da N1: </label>
                <input type="number" name="n1" id="iN1"> <br>
                <label for="iN2">Valor da N2: </label>
                <input type="number" name="n2" id="iN2"> <br>
                <input type="submit" value="Verificar">
            </fieldset>
        </form>

        <?php
            $a = isset($a) ? $_GET["a"] : "Variável não informada";
            $b = isset($b) ? $_GET["b"] : "Variável não informada";

            if($a>$b){
                echo "<p>$a</p>";
            } else{
                echo "<p>$b</p>";
            };

            $anoNascimento = isset($_POST["anoNascimento"]) ? $_POST["anoNascimento"] : "Ano de nascimento não informado";
            $idade = date("Y") - $anoNascimento; 

            if($idade >=18 and $idade <=70){
                echo "<p>Como você já tem $idade anos, seu voto é <strong>obrigatório</strong></p>";
            } elseif($idade >=16){ # em PHP se escreve elseif (tudo junto), porém separado também resultará na mesma coisa
                echo "<p>Como você tem $idade anos, seu voto é <strong>opcional</strong></p>";
            } else{
                echo "<p>Como você tem $idade anos, você ainda <strong>não</strong> pode votar</p>";
            };

            $nota1 = $_POST["n1"];
            $nota2 = $_POST["n2"];
            $media = ($nota1 + $nota2) / 2;

            if($media >=6){
                echo "<p>Parabéns você está <strong>aprovado</strong> com média " .number_format($media,2)."</p>";
            } elseif($media >=2 or $media == 5){
                echo "Com média " .number_format($media,2) ." você <strong>não</strong> atingiu o valor necessário, porém ainda consiguirá recuperar</p>";
            } else{
                echo "Com média " .number_format($media,2) ." você está <strong>reprovado</strong></p>";
            };
        ?> 

    </body>
</html>