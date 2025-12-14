<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale-1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <title>While</title>
        <style>
            div{
                margin: auto;
                width: 200px;
                height: 100px;
                background-color: gray;
                text-align: center;
                border: 1px solid black;
                padding: 10px;
            }
        </style>
    </head>
    <body>

    <?php 
        $c =1;
        while($c<=10){
            echo "$c ";
            $c++;
        }

        $i = 10;
        while($i>=1){
            echo "<br>$i ";
            $i--;
        }

        $p = 10;
        while($p>=0){
            echo "$p ";
            $p -= 2;
        }

        $cC = 1;
        $caixaTexto = "<div><br>
        <label for='iCaixaTexto'>Digite seu texto</label>
        <input type:'text' name: 'caixaTexto' id='iCaixaTexto' class='caixaTexto'>
        </div>";
        while($cC<=5){
            echo "$caixaTexto <br>";
            $cC ++;
        }
    ?>

    </body>
</html>