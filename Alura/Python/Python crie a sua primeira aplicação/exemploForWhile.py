import random
print("Jogos Mortais")

numero_certo = random.randint(0,100)
tentativas = 0
chances = 5
for _ in range(chances): # Estamos dando 5 tentativas para o usuário
    print("Utilizando 'for'")
    numero = int(input("Tente acertar o número (0-100): "))
    tentativas += 1

    if numero > 100 or numero < 0:
        print("ERRO -> Número escolhido é maior que 100 ou menor que 0.")
    elif numero == numero_certo:
        print(f"Parabéns você acertou o número com {tentativas} tentativas.")
        break
    elif numero > numero_certo:
        print(f"O número escolhido é maior que o 'alvo', você ainda tem {chances - 1} tentativas.")
        chances -= 1
    elif numero < numero_certo:
        print(f"O número escolhido é menor que o 'alvo', você ainda tem {chances - 1} tentativas.")
        chances -= 1
    if chances == 0:
        print(f"Você não acertou, o número aleatório foi o {numero_certo}")

numero_while = 0
tentativas = 0
chances = 5
while numero_while != numero_certo:
    print("Utilizando 'while'")
    numero_while = int(input("Tente acertar o número (0-100): "))
    tentativas += 1

    if numero_while > 100 or numero_while < 0:
        print("ERRO -> Número escolhido é maior que 100 ou menor que 0.")
    elif numero_while == numero_certo:
        print(f"Parabéns você acertou o número com {tentativas} tentativas.")
        break
    elif numero_while > numero_certo:
        print(f"O número escolhido é maior que o 'alvo', você ainda tem {chances - 1} tentativas.")
        chances -= 1
    elif numero_while < numero_certo:
        print(f"O número escolhido é menor que o 'alvo', você ainda tem {chances - 1} tentativas.")
        chances -= 1
    if chances == 0:
        print(f"Você não acertou, o número aleatório foi o {numero_certo}")