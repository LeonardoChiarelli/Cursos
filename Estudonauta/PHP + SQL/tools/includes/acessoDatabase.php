<?php 
    /* CRIAÇÃO DO OBJETO */

    $banco = new mysqli("localhost", "root", "", "bd_games"); # (HOST, USUÁRIO, SENHA, BANCO) - informações dentro dos ()
    
    /* FIM */

    /* CRIAÇÃO DE UMA MENSAGEM MAIS FÁCIL DE ENTENDER CASO HAJA ALGUM ERRO */

    if($banco -> connect_errno){
        echo "<p>Encontrei um erro $banco->error --> $banco->connect_error</p>";
        die(); # Forçando o programa a parar cajo haja algum erro   
    }
    
    /* FIM */

/*  COMANDOS PARA CASO HAJA INCOMPATIBILIDADE COM CARACTERES ESPECIAIS */

$banco->query("SET NAMES 'utf8'");
$banco->query("SET character_set_connection=utf8");
$banco->query("SET character_set_client=utf8");
$banco->query("SET character_set_results=utf8"); 

/* FIM */

/* COLOCANDO UM COMANDO MYSQL DENTRO DE 'QUERY' PARA PODERMOS JOGAR O RESULTADO DENTRO DE UMA VARIÁVEL */

    $busca = $banco->query("select * from gênero");

/* FIM */
