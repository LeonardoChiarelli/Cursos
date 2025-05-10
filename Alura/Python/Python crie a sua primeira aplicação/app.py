import os

restaurantes = ["Cozinha da Villa", "Belisco", "Rabo de Galo", "Tia da Pinga"] # Indica a criação de uma nova lista

def exibir_nome_do_programa():
    print("Sabor Express \n") # Comando "def 'nome da função'(): -> Para criar funções

def limpar_a_tela_e_exibir_subtitulo(subtitulo):
    os.system('cls')
    print(subtitulo)

def exibir_linha_final(texto):
    try:
        opcao = int(input(texto))
        if opcao == 1:
            main()
        elif opcao == 2:
            cadastrar_restaurante()
        elif opcao == 3:
            finalizar_o_programa()
        else:
            opcao_invalida()
    except ValueError:
        opcao_invalida()

def exibir_opcoes():
    print("1. Cadastrar Restaurante")
    print("2. Listar Restaurantes")
    print("3. Ativar Restaurante")
    print("4. Sair\n")

def cadastrar_restaurante():
    limpar_a_tela_e_exibir_subtitulo("Cadastro de novos restaurantes")

    nome_restaurante = input("Insira o nome do restaurante: ")
    restaurantes.append(nome_restaurante) # A função 'append()' é usada para adicionar novos elementos a uma lista
    print(f"Restaurante '{nome_restaurante}' cadastrado com sucesso.")

    exibir_linha_final("""Digite 1 para voltar ao menu de opções
Digite 2 para cadastrar outro restaurante: """)

def listar_restaurantes():
    limpar_a_tela_e_exibir_subtitulo("Lista de Restaurantes:")

    for item in restaurantes: # Para cada 'item' na lista 'restaurantes'
        print(f"- {item}")

    exibir_linha_final("""Digite 1 para voltar ao menu de opções
Digite 3 para finalizar o programa: """)

def ativar_restaurante():
    print("Ativar Restaurante")

def finalizar_o_programa():
    exibir_linha_final("Finalizando...")
    # os.system("clear") -> Para MacOS

def opcao_invalida():
    print("Opção inválida!\n")
    input("Digite uma tecla para voltar ao menu de opções: ")
    main()

def escolher_opcao():
    try:
        resposta_usuario = int(input("Qual ação você deseja?: ")) # Variável como int
        if resposta_usuario == 1:
            cadastrar_restaurante()
        elif resposta_usuario == 2:
            listar_restaurantes()
        elif resposta_usuario == 3:
            ativar_restaurante()
        elif resposta_usuario == 4:
            finalizar_o_programa()
        else:
            opcao_invalida()
    except ValueError:
        opcao_invalida()

def escolher_opcao_match(): # switch-case do python
    try:
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
                opcao_invalida()
    except ValueError:
        opcao_invalida()


def main(): # Dentro desta função vamos definir todos os passos para que a nossa aplicação funcione, o programa vai seguir a ordem em que as funções aparecem
    os.system("cls")
    exibir_nome_do_programa()
    exibir_opcoes()
    escolher_opcao() # Caso o 'name' do programa seja 'main', significa que ele não será importado por outros programas e que ele é o código principal da aplicação

if __name__ == "__main__":
    main()

# resposta_usuario = input("Qual ação você deseja?: ") -> Variável como string
# resposta_usuario = int(resposta_usuario) -> Outra maneira de se converter string para int

# print(f"Tipo da variável resposta_usuario: {type(resposta_usuario)}") -> Para verificar o tipo da variável, função 'type()'

# print("Você escolheu a opção: ", resposta_usuario) -> Imprimindo uma variável
# print(f"Formatação por F-String, a resposta do usuário foi: {resposta_usuario} \n") -> Formatação com print(f"")
