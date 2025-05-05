<?php 
    if(empty($_SESSION['user'])){
        echo "
            <header>
                <nav>
                    <a href='php/login.php' class='linkLoginLogout'>Entrar</a>
                </nav>
            </header>
        ";
    } else{
        echo "
            <header>
                <nav>
                    Olá, <strong>" .$_SESSION['nome'] ."</strong> | <a href='php/user-editData' class='linkHeader'>Meus Dados</a> ";
                    if(is_admin()){
                        echo "| <a href='php/user-new.php' class='linkHeader'>Novo Usuário</a> | <a href='php/game-new.php' class='linkHeader'>Novo Jogo</a> ";
                    }
                    echo "| <a href='php/logout.php' class='linkLoginLogout'>Sair</a>
                </nav>
            </header>
        ";
    }
?>