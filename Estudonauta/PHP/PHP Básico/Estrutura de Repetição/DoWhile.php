<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible"content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <title>Do While</title>
        <style>

        </style>
    </head>
    <body>
        
    <?php 
        $c = 1;

        do{
            echo "$c ";
            $c++;
        } while($c<=10);

        $i =10;

        do{
            echo "<br>$i ";
            $i--;
        } while($i >=1);

    ?>
    </body>
</html>