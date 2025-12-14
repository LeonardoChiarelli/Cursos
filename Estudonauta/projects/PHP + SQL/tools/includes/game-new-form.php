<form action="" method="post" id="novoJogo">
    <fieldset id="setJogo">
        <legend>Cadastre seu jogo</legend>
        <label for="iNome">Nome: </label>
        <input type="text" name="nome" id="iNome" required> <br>
        <label for="iGenero">Gênero: </label>
        <input type="text" name="genero" id="iGenero" required> <br>
        <label for="iProdutora">Produtora: </label>
        <input type="text" name="produtora" id="iProdutora" required> <br>
        <label for="iDesc">Descrição: </label>
        <textarea name="descricao" id="iDesc" required></textarea> <br>
        <label for="iNota">Nota: </label>
        <input type="number" id="iNota" name="nota" min="0" max="10" placeholder="x/10" required> <br>
        <label for="iCapa">URL da capa: </label>
        <input type="url" name="capa" id="iCapa" required> <br>
        <input type="submit" value="Criar">
    </fieldset>
</form>