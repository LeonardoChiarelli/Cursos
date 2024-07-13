<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
    <title>É primo?</title>
    <style>
        body{
            background-color: antiquewhite;
        }
    </style>
</head>
<body>
    
    <?php 
        $num = $_POST["num"];
        $contPrim = 0;

        echo "Analisando número $num...";
        echo "<br>Números múltiplos:";
        for($i=1; $i<=$num; $i++){
            if($num%$i==0){
                echo "$i ";
                $contPrim++;
            }
        }
        echo "<br>Total de múltiplos: $contPrim <br>";
        if($contPrim>2){
            echo "O número escolhido <strong style='color:red';>NÃO É PRIMO<strong>";
        } elseif($contPrim==2){
            echo "O número escolhido <strong style='color: red';>É PRIMO</strong>";
        }

    ?>
<br> <a href="javascript:history.go(-1)">Voltar</a>
</body>
</html>