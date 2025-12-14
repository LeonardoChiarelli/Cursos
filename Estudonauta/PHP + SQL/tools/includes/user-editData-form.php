<?php 
    require_once "acessoDatabase.php";
    $query = "SELECT usuário, nome, senha, tipo from usuários where usuário='" .$_SESSION['user'] ."'";
    $busca = $banco->query($query);
    $registro = $busca->fetch_object();
?>
<form action="<?=$_SERVER['PHP_SELF']?>" method="post" id="altDados">
    <fieldset>
        <legend>Alteração de dados</legend>
        <label for="iusuário">Usuário: </label>
        <input type="text" name="usuário" id="iusuário" size="10" maxlength="80" readonly value="<?=$registro->usuário?>"> <br>
        <label for="inome">Nome: </label>
        <input type="text" name="nome" id="inome" size="30" maxlength="30" value="<?=$registro->nome?>"> <br>
        <label for="itipo">Tipo: </label> 
        <input type="text" name="tipo" id="itipo" readonly value="<?=$registro->tipo?>"> <br>
        <label for="isenha1">Senha: </label>
        <input type="password" name="senha1" id="isenha1" size="10" minlength="4" maxlength="10"> <br>
        <label for="isenha2">Confirme a senha: </label>
        <input type="password" name="senha2" id="isenha2" size="10" maxlength="10"> <br>
        <input type="submit" value="Salvar">
    </fieldset>
</form>