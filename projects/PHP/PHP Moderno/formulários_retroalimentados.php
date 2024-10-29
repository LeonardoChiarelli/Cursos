<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../style.css">
        <title>Formuários Retroalimentados</title>
    </head>
    <body>

        <?php
            # Por padrão vamos capturar os dados do formulário logo após o body
            $n1 = $_REQUEST["num1"] ?? 0;
            $n2 = $_REQUEST["num2"] ?? 0;
        ?>

        <main>
            <form action=" <?=$_SERVER['PHP_SELF']?> " method="get"> <!-- Usar o "$_SERVER['PHP_SELF']" para indicar o caminho para o formulário mandar o arquivo -->
                <fieldset>
                    <legend>1º Formulário Retroalimentado</legend>
                    <label for="inum1">Número: </label>
                    <input type="number" name="num1" id="inum1" step="0.01" value="<?=$n1?>"> <!-- Aqui estamos colocando o valor padrão do input a própria variável colocada, para não deixar o espaço vazio -->
                    <label for="inum2">Número: </label>
                    <input type="number" name="num2" id="inum2" step="0.01" value="<?=$n2?>"> <!-- Vamos fazer a mesma coisa aqui -->                    <input type="submit" value="Somar">
                </fieldset>
            </form>
        </main>

        <section>
            <h2>
                <?="<p>$n1+$n2 = <strong>". $n1+$n2 ."</strong></p>";?> <!-- E aqui vamos utilizar apenas para mostrar os dados na tela -->
            </h2>
        </section>
    </body>
</html>