<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
    <title>Fatorial</title>
    <style>
        
    </style>
</head>
<body>
    
    <?php 
        $num = $_POST["num"];
        $c = $num;
        $fat = 1;
        $tab = 0; 

        do{
            $fat *= $c;
            $c--;
        } while ($c>=1);
        echo "$num! = $fat<br>";

        do{
            $res = $num * $tab;
            echo "$num * $tab = $res<br>";
            $tab++;
        } while ($tab<=10);

    ?>

<br> <a href="javascript:history.go(-1)">Voltar</a>
</body>
</html>