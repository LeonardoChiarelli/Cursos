import random

lista_numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
lista_nomes = ["Leonardo", "Thais", "Marcelo", "Camilla"]
lista_anoNasc_anoAtu = [2006, 2025]

for numero in lista_numeros:
    print(f"Número {numero}")

soma = 0
for numero_impar in lista_numeros:
    if numero_impar % 2 != 0:
        soma += numero_impar
print(f"A soma entre os números ímpares da lista {lista_numeros} é igual a {soma}")

for numero in range(lista_numeros[len(lista_numeros)-1], lista_numeros[0], -1):
    print(f"{numero}")

numero_usuario = int(input("Informe um número para ver sua tabuáda: "))
for i in range(1, 11, 1):
    resultado = numero_usuario * i
    print(f"{numero_usuario} x {i} = {resultado}")

soma = 0
lista_numeros_aleatorios = [random.randint(1,100), random.randint(1,100), random.randint(1,100), random.randint(1,100)]
try:
    for numero_aleatorio in lista_numeros_aleatorios:
        soma += numero_aleatorio
    print(f"A soma de todos os itens da lista {lista_numeros_aleatorios} é igual a {soma}")
except Exception as e:
    print(f"Erro: {e}")

soma = 0
for numero in lista_numeros_aleatorios:
    soma += numero
print(f"A valor médio da lista {lista_numeros_aleatorios} igual a {soma/len(lista_numeros_aleatorios)}")