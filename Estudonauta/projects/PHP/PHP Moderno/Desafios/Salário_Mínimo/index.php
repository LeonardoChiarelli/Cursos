<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../../style.css">
        <title>Salário Mínimo</title>
    </head>
    <body>

        <?php
            $salarioMin = 1412; 
            $salario = $_REQUEST["salario"] ?? $salarioMin;
            $qntSalarioMin = (int) ($salario/$salarioMin);
            $diferença = $salario - ($qntSalarioMin*$salarioMin);
        ?>

        <main>
            <form action= "<?=$_SERVER['PHP_SELF']?>" method="get">
                <fieldset>
                    <legend>Informe seu salário</legend>
                    <label for="isalario">Salário (R$): </label>
                    <input type="number" name="salario" id="isalario" step="0.01" value="<?=$salario?>">
                    <?="<small>* Considerando o salário mínimo de <strong>R\$" .number_format($salarioMin, 2, ",", ".") ."</strong></small>"?>
                    <input type="submit" value="Calcular">
                </fieldset>
            </form>
        </main>
        <section>
            <h2>Resultado Final</h2>
            <?="<p>Quem recebe um salário de " .number_format($salario, 2, ",", ".") ." ganha <strong>$qntSalarioMin salário(s) mínimo(s) + R\$". number_format($diferença, 2, ",", ".")."</strong></p>" ?>
        </section>
    </body>
</html>