pessoa = {"nome":"Leonardo",
          "idade":18,
          "cidade":"São Paulo"}

print(f"Dicionário pessoa antes das alterações: {pessoa}")

pessoa.update({"idade":19})
print(f"Dicionário pessoa depois da primeira alteração: {pessoa}")

profissao = {"profissão":"Desenvolvedor Back-end"}
pessoa.update(profissao)
print(f"Dicionário pessoa depois da segunda alteração: {pessoa}")

pessoa.pop("cidade")
print(f"Dicionário pessoa depois da terceira alteração: {pessoa}")

numero_quadrado = {x: x**2 for x in range(1,6)}
print(numero_quadrado)

usuarios = {
    "Leonardo" : {"usuario":"devleochiarelli", "senha":"Leo1234"},
    "Marcelo" : {"usuario":"marcelo", "senha":"mar0202"},
}

chave_consulta = input("Insira a chave que deseja consultar: ")
print(f"A chave '{chave_consulta}' está presente no dicionário usuários, as credencias são essas: {usuarios[chave_consulta]}" if chave_consulta in usuarios else f"A chave '{chave_consulta}' não está presente no dicionário usuários")

frase = "O tempo passa, o tempo voa, e o tempo não espera por ninguém; o tempo ensina, o tempo cura, o tempo mostra quem realmente somos quando o tempo é difícil."
contagem_palavra = {}
palavras = frase.split()
for palavra in palavras:
    contagem_palavra[palavra] = contagem_palavra.get(palavra, 0) + 1
print(f"Análise da frase '{frase}': \n{contagem_palavra}")