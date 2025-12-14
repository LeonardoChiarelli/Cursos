<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../../style.css">
        <title>Pessoa</title>
    </head>
    <body>
        <main>
            <?php 
            require_once "Class/pessoa.php";
            require_once "Class/livro.php";
                $pessoa[0] = new Pessoa ("Leonardo", 18, "Masculino");
                $pessoa[1] = new Pessoa("Carla", 31, "Feminino");

                $livro[0] = new Livro("PHP OO", "Jóse Machado de Andrade", 300, $pessoa[0]);
                $livro[1] = new Livro("Java OO", "Carlos Drummond Assis", 400, $pessoa[1]);
                $livro[2] = new Livro("Android Studio", "Dom Pedro II", 630, $pessoa[0]);
                $livro[3] = new Livro("HTML5", "Rei João VI", 260, $pessoa[1]);

                $livro[0]->abrir();
                $livro[0]->folhear(283);
                $livro[0]->detalhes();

                $livro[1]->abrir();
                $livro[1]->folhear(283);
                $livro[1]->detalhes();

                $livro[2]->abrir();
                $livro[2]->folhear(283);
                $livro[2]->detalhes();

                $livro[3]->abrir();
                $livro[3]->folhear(213);
                $livro[3]->detalhes();
            ?>
        </main>
    </body>
</html>