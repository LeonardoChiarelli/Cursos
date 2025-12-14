<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../../../style.css">
    <title>Caixa Eletrônico</title>
    <style>
        .nota{
            height: 65px;
            margin: 10px;
        }
    </style>
</head>
<body>

    <?php 
        $n = $_REQUEST["num"] ?? 1;
        $sobra = $n;

        $n100 = (int)($n/100);
        $sobra %= 100;

        $n50 = (int)($sobra/50);
        $sobra %= 50;

        $n20 = (int)($sobra/20);
        $sobra %= 20;

        $n10 = (int)($sobra/10);
        $sobra %= 10;

        $n5 = (int)($sobra/5);
        $sobra %= 5;

        $n2 = (int)($sobra/2);
        $sobra %= 2;

    ?>

    <main>
        <h2>Caixa Eletrônico</h2>
        <form action="<?=$_SERVER['PHP_SELF']?>" method="get">
            <fieldset>
                <label for="inum">Qual valor você deseja sacar? (R$)*</label>
                <input type="number" name="num" id="inum" step="0.01" value="<?=$n?>">
                <p><small>* Notas disponíveis: R$100 | R$50 | R$20 | R$10 | R$5 | R$2</small></p>
                <input type="submit" value="Sacar">
            </fieldset>
        </form>
    </main>
    <section>
        <h2>Saque de R$<?=number_format($n, 2, "," , ".")?> realizado</h2>
        <p>O caixa eletrônico te entregará as seguintes motas: </p>
        <ul>
            <li><img src="100-reais.jpg" alt="Nota de 100" class="nota"> x<?=$n100?></li>
            <li><img src="50-reais.jpg" alt="Nota de 50" class="nota"> x<?=$n50?></li>
            <li><img src="20-reais.jpg" alt="Nota de 20" class="nota"> x<?=$n20?></li>
            <li><img src="10-reais.jpg" alt="Nota de 10" class="nota"> x<?=$n10?></li>
            <li><img src="5-reais.jpg" alt="Nota de 5" class="nota"> x<?=$n5?></li>
            <li><img src="2-reais.jpg" alt="Nota de 2" class="nota"> x<?=$n2?></li>
        </ul>
        <p>E ainda ficará com <strong>R$<?=number_format($sobra, 2, ",", ".")?></strong> de troco</p>
    </section>
</body>
</html>