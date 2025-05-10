numero = int(input("Insira um número: "))
if numero % 2 == 0:
    print("O número digitado é par!")
else:
    print("O número digitado é ímpar!")

idade = int(input("Informe sua idade: "))
if 0 < idade <= 12:
    print(f"Você é uma criança de {idade} anos")
elif idade < 18:
    print(f"Você é um adolescente de {idade} anos")
else:
    print(f"Você é um adulto de {idade} anos")

usuario = input("Insira o nome do usuário: ")
senha = input("Insira sua senha: ")
if usuario == "devleochiarelli" and senha == "Leo160306":
    print(f"Usuário '{usuario}' logado com sucesso!")
else:
    print("Falha na autenticação.")

x = int(input("Informe o valor de x: "))
y = int(input("Informe o valor de y: "))
if x > 0 and y > 0:
    print(f"Para x = {x} e y = {y} em um plano cartesiano estariam no primeiro quadrante.")
elif x < 0 < y:
    print(f"Para x = {x} e y = {y} em um plano cartesiano estariam no segundo quadrante.")
elif x < 0 and y < 0:
    print(f"Para x = {x} e y = {y} em um plano cartesiano estariam no terceiro quadrante.")
elif x > 0 > y:
    print(f"Para x = {x} e y = {y} em um plano cartesiano estariam no quarto quadrante.")
else:
    print(f"Para x = {x} e y = {y} em um plano cartesiano estariam no eixo ou origem1")