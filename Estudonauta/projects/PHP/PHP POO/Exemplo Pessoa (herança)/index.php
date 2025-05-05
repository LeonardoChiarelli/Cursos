<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../../style.css">
        <title>Pessoa</title>
    </head>
    <body>
        <main>
            <?php
            require_once "Class/pessoa.php";
            require_once "Class/aluno.php";
            require_once "Class/professor.php";
            require_once "Class/funcionario.php";
                $pes1 = new Pessoa("Mário", 12, "Masculino");
                $alu1 = new Aluno("Leonardo" ,18, "Masculino", 4, "Ciência da Computação");
                $prof1 = new Professor("Marcos Aurélio", 43, "Masculino", "Lógica de Programação", 7932.4);
                $fun1 = new Funcionario("Carlos", 56, "Maculino", "Logistica", true);

                $prof1->receberAumento(25);
                var_dump($pes1);
                var_dump($alu1);
                var_dump($prof1);
                var_dump($fun1);
            ?>
        </main>
    </body>
</html>