<form action="" method="post" id="novoJogo">
    <fieldset>
        <legend>Cadastre seu jogo</legend>
        <label for="iNome">Nome: </label>
        <input type="text" name="nome" id="iNome" required>
        <label for="iGenero">Gênero: </label>
        <input type="text" name="genero" id="iGenero" required>
        <label for="iProdutora">Produtora: </label>
        <input type="text" name="produtora" id="iProdutora" required>
        <label for="iDesc">Descrição: </label>
        <textarea name="descricao" id="iDesc" required></textarea>
        <label for="iNota">Nota: </label>
        <input type="number" min="0" max="10" placeholder="x/10" required>
        <label for="iCapa">URL da capa: </label>
        <input type="url" name="capa" id="iCapa" required>
        <input type="submit" value="Criar">
    </fieldset>
</form>