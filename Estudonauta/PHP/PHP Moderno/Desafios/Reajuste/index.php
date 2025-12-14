<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../../../style.css">
    <title>Reajuste</title>
</head>
<body>

    <?php 
        $preço = $_REQUEST["preço"] ?? 1;
        $reajuste = 0;
        @$reajuste = $_REQUEST["porcentagem"];
        $novoPreço = $preço + ($preço*($reajuste/100));
    ?>

    <main>      
        <form action="<?=$_SERVER['PHP_SELF']?>" method="get">
            <fieldset>
                <legend>Reajustador de preços</legend>
                <label for="ipreco">Preço do Produto (R$)</label>
                <input type="number" name="preço" id="ipreco" step="0.01" value="<?=$preço?>">
                <label for="ireajuste">Qual será o percentual de reajuste? (<strong><span id="P">?</span>%</strong>)</label>
                <input type="range" name="porcentagem" id="ireajuste" min="0" max="100" step="1" value="25" oninput="mudaValor()"> <!-- Quando eu estiver mudando o valor do range ele vai chamar a função javascript -->
                <input type="submit" value="Reajustar">
            </fieldset>
        </form>
    </main>
    <section>
        <h2>Resultado do reajuste</h2>
        <?=
            "<p>O produto que custava R\$" .number_format($preço, 2, ",", ".") ." com <strong>$reajuste% de aumento</strong> vai passar a custar R\$". number_format($novoPreço, 2, ",", ".") ." a partir de agora</p>"
        ?>
    </section>
    <script>
        P.innerText = ireajuste.value
        function mudaValor(){
           /* id do span */ P.innerText = ireajuste.value // Usando o 'id'
        }
    </script>
</body>
</html>