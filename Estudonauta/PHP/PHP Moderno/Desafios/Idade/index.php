<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../../../style.css">
    <title>Qual será sua idade?</title>
</head>
<body>
    <?php 
        $anoNasc = $_REQUEST["anoNasc"] ?? 2000;
        $ano = $_REQUEST["ano"] ?? date('Y');
        $idadeFutura = $ano - $anoNasc;
    ?>
    <main>
        <form action="<?=$_SERVER['PHP_SELF']?>" method="get">
            <fieldset>
                <legend>Qual será sua idade?</legend>
                <label for="ianoNasc">Em que ano você nasceu?</label>
                <input type="number" name="anoNasc" id="ianoNasc" value="<?=$anoNasc?>">
                <label for="iano">Quer saber sua idade em qual ano? <small>(Atualmente estamos em <?="<strong>". date('Y') ."</strong>"?></small>)</label>
                <input type="number" name="ano" id="iano" value="<?=$ano?>">
                <input type="submit" value="Qual será minha idade?">
            </fieldset>
        </form>
    </main>
    <section>
        <h2>Resultado</h2>
        <?=
            "Quem nasceu em $anoNasc vai ter <strong>$idadeFutura anos</strong> em $ano"
        ?>
    </section>
</body>
</html>