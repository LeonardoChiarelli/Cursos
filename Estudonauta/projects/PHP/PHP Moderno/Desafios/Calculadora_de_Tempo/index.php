<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../../../style.css">
    <title>Calculadora de tempo</title>
</head>
<body>
    <?php 
        $total = $_REQUEST["seg"] ?? 1;
        $sobra = $total;

        $semana = (int) ($sobra / 604800);
        $sobra %= 604800;

        $dia = (int) ($sobra / 86400);
        $sobra %= 86400;

        $hora = (int) ($sobra / 3600);
        $sobra %= 3600;

        $min = (int) ($sobra / 60);
        $sobra %= 60;

        $seg = $sobra;
        
    ?>
    <main>
        <form action="<?=$_SERVER['PHP_SELF']?>" method="get">
            <fieldset>
                <legend>Calculadora de Tempo</legend>
                <label for="iseg">Informe o tempo em segundos</label>
                <input type="number" name="seg" id="iseg" step="0.01" value="<?=$total?>">
                <input type="submit" value="Calcular">
            </fieldset>
        </form>
    </main>
    <section>
        <h2>Totalizando tudo</h2>
        <p>Analisando o valor que você digitou, <?=number_format($total, 0, ",", ".")?> segundos, equivalem a um total de:</p>
        <ul>
            <li><?=$semana?> semana(s)</li>
            <li><?=$dia?> dia(s)</li>
            <li><?=$hora?> hora(s)</li>
            <li><?=$min?> minutos(s)</li>
            <li><?=$seg?> segundo(s)</li>
        </ul>
    </section>
</body>
</html>

<!-- 
    1min -> 60seg
    1h -> 3600seg
    1d -> 86.400seg
    1s -> 604.800seg
-->
