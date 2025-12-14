<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
    <title>Valores</title>
</head>
<body>
    
<?php 
    $valor1 = $_POST["v1"]; # Caso formulário seja do tipo 'get', usar $_GET[""]
    $valor2 = $_POST["v2"];
    $soma = $valor1 + $valor2;
    $rq = sqrt($soma);    
    echo "<p>A soma dos valores é " .$soma ." e a raiz quadrada desse valor é " .number_format($rq, 2). "</p>";
?>
<a href="Valores.html">Voltar</a>
</body>
</html>

