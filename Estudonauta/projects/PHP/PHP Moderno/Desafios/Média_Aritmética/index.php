<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../../../style.css">
    <title>Média Aritmética</title>
</head>
<body>

    <?php 
        $n1 = $_REQUEST["num1"] ?? 1;
        $n2 = $_REQUEST["num2"] ?? 1;
        $peso1 = $_REQUEST["peso1"] ?? 1;
        $peso2 = $_REQUEST["peso2"] ?? 1;
        $mediaSimples = ($n1+$n2)/2;
        $mediaPonderada = ($n1*$peso1 + $n2*$peso2) / ($peso1+$peso2);
    ?>

    <main>
        <form action="<?=$_SERVER['PHP_SELF']?>" method="get">
            <fieldset>
                <legend>Médias Aritméticas</legend>
                <label for="inum1">1º Número: </label>
                <input type="number" name="num1" id="inum1" step="0.01" value="<?=$n1?>">
                <label for="ipeso1">1º Peso: </label>
                <input type="number" name="peso1" id="ipeso1" value="<?=$peso1?>">
                <label for="inum2">2º Número</label>
                <input type="number" name="num2" id="inum2" step="0.01" value="<?=$n2?>">
                <label for="ipeso2">2º Peso: </label>
                <input type="number" name="peso2" id="ipeso2" value="<?=$peso2?>">
                <input type="submit" value="Calcular Médias">
            </fieldset>
        </form>
    </main>
    <section>
        <h2>Cálculo das Médias</h2>
        <?=
            "<p>Analisando os números $n1 e $n2: <br> <ul><li>A <strong>Média Aritmética Simples</strong> entre os valores é igual a ". number_format($mediaSimples, 2, ",") .".</li> <li>A <strong>Média Aritmética Ponderada</strong> com pesos $peso1 e $peso2 é igual a ". number_format($mediaPonderada, 2, ",") .".</li></ul>"
        ?>
    </section>
</body>
</html>