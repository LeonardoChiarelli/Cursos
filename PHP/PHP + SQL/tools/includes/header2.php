<?php 
    if(empty($_SESSION['user'])){
        echo "
            <header>
                <nav>
                    <a href='login.php' class='linkLoginLogout'>Entrar</a>
                </nav>
            </header>
        ";
    } else{
        echo "
            <header>
                <nav>
                    Olá, <strong>" .$_SESSION['nome'] ."</strong>! | Meus Dados ";
                    if(is_admin()){
                        echo "| <a href='' class='linkNovoUserJogo'>Novo Usuário</a> | <a href='' class='linkNovoUserJogo'>Novo Jogo</a> ";
                    }
                    echo "| <a href='logout.php' class='linkLoginLogout'>Sair</a>
                </nav>
            </header>
        ";
    }
?>