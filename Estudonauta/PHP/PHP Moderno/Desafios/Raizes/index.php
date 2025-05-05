<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../../../style.css">
    <title>Raizes</title>
</head>
<body>
    <?php 
        $num = $_REQUEST["num"] ?? 1;
        $rq = sqrt($num);
        $rc = pow($num, 1/3);
    ?>
    <main>
        <form action="<?=$_SERVER['PHP_SELF']?>" method="get">
            <fieldset>
                <legend>Informe um número</legend>
                <label for="inum">Número: </label>
                <input type="number" name="num" id="inum" placeholder="Apenas números inteiros" value="<?=$num?>">
                <input type="submit" value="Calcular raizes">
            </fieldset>
        </form>
    </main>
    <section>
        <h2>Resultado Final</h2>
        <?=
            "<p>Analisando o <strong>número $num</strong>, temos: <br> <ul><li>A sua raiz quadrada é <strong>". number_format($rq, 3, ",") ."</strong></li> <li>A sua raiz cúbica é <strong>". number_format($rc, 3, ",") ."</strong></li></ul>" 
        ?>
    </section>
</body>
</html>