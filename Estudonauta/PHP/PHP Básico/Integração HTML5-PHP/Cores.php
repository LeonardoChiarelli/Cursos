<!DOCTYPE html>
<html lang="pt-br">
<head>
    <?php

        $texto = $_GET["texto"];    
        $tamanho = $_GET["tamanho"];
        $cor = $_GET["cor"];

        echo "<span class='texto'>$texto</span>";

    ?>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
    <title>Cores</title>
    <style>
        span.texto{ /* no código PHP precisamos especificar  o item da classe */
            font-size: <?php echo $tamanho; ?>;
            color: <?php echo $cor; ?>; 
        }
    </style>
</head>
<body>

<br> <a href="Cores.html">Voltar</a>

</body>
</html>