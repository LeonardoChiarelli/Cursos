<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Variáveis em PHP</title>
    </head>
    <body>
    <?php 
        $num = 3; // variáveis em PHP, toda variável começa com $ e são em letras minúsculas pois o PHP é case sensitive
        $salario = 1824.56; // variáveis não recebem acentuação
        $nome = "Leonardo"; // string sempre entre ""
        $casado = true; // booleanos

        echo "O valor da variável num é $num <br> A variável salario recebeu o valor de $salario <br> O nome inserido foi $nome <br> E a variável casado recebeu o valor $casado (true)";

        /* 
            O PHP já coloca o tipo da variável automaticamente, porém caso você queira forçar um tipo de variável basta usar (int) ou (integer) para inteiros ; (real), (float) ou (double) para números com vírgula; (string) para caractere.

            Booleans - verdadeiro = 1 e falso = vazio
        */
    ?>
    </body>
</html>