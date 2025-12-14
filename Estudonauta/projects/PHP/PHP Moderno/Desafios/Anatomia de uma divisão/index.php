<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../../style.css">
        <title>Anatomia de uma Divisão</title>
        <style>
            
        </style>
    </head>
    <body>
        <?php 
        # Pegando os valores das variáveis
            $dividendo = $_REQUEST["dividendo"] ?? 1;
            $divisor = $_REQUEST["divisor"] ?? 1;
        ?>
        <main>
            <form action=" <?=$_SERVER['PHP_SELF']?> " method="get">
                <fieldset>
                    <legend>Anatomia de uma Divisão</legend>
                    <label for="idividendo">Dividendo</label>
                    <input type="number" name="dividendo" id="idividendo" step="0.01" value="<?=$dividendo?>">
                    <label for="idivisor">Divisor</label>
                    <input type="number" name="divisor" id="idivisor" step="0.01" value="<?=$divisor?>">
                    <input type="submit" value="Analisar">
                </fieldset>
            </form>
        </main>
        
        <?php 
            $resultado = intdiv($dividendo, $divisor) ?? "";
            $resto = (int) $dividendo%$divisor ?? "";
        ?>
        <section>
            <h3>Estrutura da divisão</h3>
            <table class="divisao">
                <tr>
                    <td><?=$dividendo?></td>
                    <td><?=$divisor?></td>
                </tr>
                <tr>
                    <td><?=$resto?></td>
                    <td><?=$resultado?></td>
                </tr>
            </table>
        </section>
    </body>
</html>