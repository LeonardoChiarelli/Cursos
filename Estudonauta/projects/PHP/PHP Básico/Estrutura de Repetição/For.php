<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
        <title>For</title>
        <style>
            body{
                background-color: antiquewhite;
            }
        </style>
    </head>
    <body>
        
        <?php 

            for($c=10; $c>=1; $c--){
                echo "$c ";
            }
            for($c=1;$c<=10; $c++){
                echo "<br> $c";
            }
            for($c=100;$c>=0; $c-=5){
                echo " $c ";
            }
        ?>
    </body>
</html>