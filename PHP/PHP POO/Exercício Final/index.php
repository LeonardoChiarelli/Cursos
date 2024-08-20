<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../style.css">
        <title>Assistir Vídeo</title>
    </head>
    <body>
        <main>
            <?php
            require_once "Class/video.php"; require_once "Class/gafanhoto.php"; require_once "Class/visualizacao.php";
            $v[0] = new Vídeo("Aula1");
            $v[1] = new Vídeo("Aula2");
            $v[2] = new Vídeo("Aula3");

            $g[0] = new Gafanhoto("Cláudio", 22, "M", "claud");
            $g[1] = new Gafanhoto("Clauda", 243, "F", "clauda");
            $g[2] = new Gafanhoto("Mario", 12, "M", "armario");

            $vis[0] = new Visualizacao($g[0], $v[0]);
            $vis[0]->avaliar();
            $vis[1] = new Visualizacao($g[1], $v[2]);
            $vis[1]->avaliarNota(8);
            $vis[2] = new Visualizacao($g[2], $v[1]);
            $vis[2]->avaliarPorcent(100);
            var_dump($vis[0]);
            echo "<hr>";
            var_dump($vis[1]);
            echo "<hr>";
            var_dump($vis[2]);
            ?>
        </main>
    </body>
</html>