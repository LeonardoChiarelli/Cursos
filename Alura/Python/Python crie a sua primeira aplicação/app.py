import os

def exibir_nome_do_programa():
    print("Sabor Express \n")

def exibir_opcoes():
    print("1. Cadastrar Restaurante")
    print("2. Listar Restaurantes")
    print("3. Ativar Restaurante")
    print("4. Sair\n")

def cadastrar_restaurante():
    print("Cadastrar Restaurante")

def listar_restaurantes():
    print("Listar Restaurantes")

def ativar_restaurante():
    print("Ativar Restaurante")

def finalizar_o_programa():
    os.system("cls")
    # os.system("clear") -> Para MacOS
    print("Finalizando...")

def escolher_opcao():
    resposta_usuario = int(input("Qual ação você deseja?: ")) # Variável como int

    if resposta_usuario == 1:
        cadastrar_restaurante()
    elif resposta_usuario == 2:
        listar_restaurantes()
    elif resposta_usuario == 3:
        ativar_restaurante()
    else:
        finalizar_o_programa()

def escolher_opcao_match(): # switch-case do python
    resposta_usuario = int(input("Qual ação você deseja?: "))  # Variável como int

    match resposta_usuario:
        case 1:
            cadastrar_restaurante()
        case 2:
            listar_restaurantes()
        case 3:
            ativar_restaurante()
        case 4:
            finalizar_o_programa()
        case _:
            print("Opção inválida!")

def main(): # Dentro desta função vamos definir todos os passos para que a nossa aplicação funcione, o programa vai seguir a ordem em que as funções aparecem
    exibir_nome_do_programa()
    exibir_opcoes()
    escolher_opcao()

if __name__ == "__main__":
    main()

# resposta_usuario = input("Qual ação você deseja?: ") -> Variável como string
# resposta_usuario = int(resposta_usuario) -> Outra maneira de se converter string para int

# print(f"Tipo da variável resposta_usuario: {type(resposta_usuario)}") -> Para verificar o tipo da variável, função 'type()'

# print("Você escolheu a opção: ", resposta_usuario) -> Imprimindo uma variável
# print(f"Formatação por F-String, a resposta do usuário foi: {resposta_usuario} \n") -> Formatação com print(f"")

# Comando "def 'nome da função'(): -> Para criar funções

# Caso o 'name' do programa seja 'main', significa que ele não será importado por outros programas e que ele é o código principal da aplicação