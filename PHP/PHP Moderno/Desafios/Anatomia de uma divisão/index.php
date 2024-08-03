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
            *{
                border-collapse: collapse;
            }
            p{
                display: inline-block;
                padding: 20px 70px;
                font-size: 2em;
                text-align: center;
                margin: 0px;
            }
            #divisor{
                border-left: 3px solid black;
                border-bottom: 3px solid black;
            }
            #resutado, #resto{
                margin: 0px 10px;
                padding-top: 0px;
            }
            #resultado{
                border-left: 3px solid black; 
            }
        </style>
    </head>
    <body>
        <?php 
        # Pegando os valores das variáveis
            $dividendo = $_REQUEST["dividendo"] ?? 0;
            $divisor = $_REQUEST["divisor"] ?? 0;
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
            <p id="dividendo"><?=$dividendo?></p> 
            <p id="divisor"><?=$divisor?></p>
            <br>
            <p id="resto"><?=$resto?></p>
            <p id="resultado"><?=$resultado?></p>
        </section>
    </body>
</html>