<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
    <title>Contando...</title>
</head>
<body>
    
<?php
    $inicio = isset($_POST["inicio"]) ? $_POST["inicio"] : "Valor não informado";
    $final = isset($_POST["final"]) ? $_POST["final"] : "Valor não informado";
    $incremento = $_POST["incremento"];

    while($inicio <= $final){
        switch($incremento){
            case 1:
                echo "$inicio ";
                $inicio++;
            break;
            case 2:
                echo "$inicio ";
                $inicio+=2;
            break;
            case 3:
                echo "$inicio ";
                $inicio+=3;
            break;
            case 4:
                echo "$inicio ";
                $inicio+=4;
            break;
            case 5:
                echo "$inicio ";
                $inicio+=5;
        }
    }
?>

<br> <a href="javascript:history.go(-1)">Voltar</a>
</body>
</html>