<form action="" method="post" id="novoUser">
    <fieldset>
        <legend>Novo Usuário</legend>
        <label for="iusuário">Usuário: </label>
        <input type="text" name="usuário" id="iusuário" size="10" maxlength="80" required> <br>
        <label for="inome">Nome: </label>
        <input type="text" name="nome" id="inome" size="30" maxlength="30" required> <br>
        <label for="itipo">Tipo:</label>
        <select id="itipo" name="tipo">
            <option value="admin">Administrador do Sistema</option>
            <option value="editor">Editor Autorizado</option>
            <option value="leitor" selected>Leitor</option>
        </select> <br>
        <label for="isenha1">Senha: </label>
        <input type="password" name="senha1" id="isenha1" size="10" minlength="4" maxlength="10" required> <br>
        <label for="isenha2">Confirme a senha: </label>
        <input type="password" name="senha2" id="isenha2" size="10" maxlength="10" required> <br>
        <input type="submit" value="Criar">
    </fieldset>
</form>