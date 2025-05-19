import os
from time import sleep

estabelecimento = ["Cozinha da Villa", "Belisco", "Rabo de Galo", "Tia da Pinga"] # Indica a criação de uma nova lista

# Criação de um dicionário ≥ [] indica a criação de uma lista ≥ {} vão ser todas as informações referentes a um estabelecimento
estabelecimentos_dicionario = [{"nome":"Cozinha da Villa", "categoria":"Bar", "ativo":True},
                            {"nome":"Belisco", "categoria":"Restaurante", "ativo":False},
                            {"nome":"Rabo de Galo", "categoria":"Bar", "ativo":False},
                            {"nome":"Tia da Pinga", "categoria":"Boteco", "ativo":False}]

def exibir_nome_do_programa():
    """ Esta função é responsável por exibir o nome do programa """
    print("Sabor Express \n") # Comando "def 'nome da função'(): -> Para criar funções

def limpar_a_tela_e_exibir_subtitulo(subtitulo):
    """ Esta função é responsável por limpar a tela e exibir o subtitulo

    Parâmetros:
        - subtítulo: subtítulo do programa
    """
    os.system('cls')
    linha = "*" * (len(subtitulo) + 4) # Colocando * para a quantidade de letras no parametro passado + 4
    print(linha)
    print(subtitulo)
    print(linha, "\n")

def exibir_linha_final(texto):
    """ Esta função é responsável por exibir a linha final do código

    Parâmetros:
        - texto: texto que será exibido
    ‘Input’:
        - Opção
    """
    try:
        opcao = int(input(texto))
        if opcao == 1:
            main()
        elif opcao == 2:
            cadastrar_estabelecimento()
        elif opcao == 3:
            finalizar_o_programa()
        elif opcao == 4:
            ativar_desativar_estabelecimento()
        else:
            opcao_invalida()
    except ValueError:
        opcao_invalida()

def exibir_opcoes():
    """ Esta função é responsável por exibir as opções do programa """
    print("1. Cadastrar Estabelecimento")
    print("2. Listar Estabelecimentos")
    print("3. Ativar/Desativar Estabelecimento")
    print("4. Sair\n")

def cadastrar_estabelecimento():
    """ Esta função é responsável por cadastrar um novo estabelecimento 
    
    'Inputs':
        - Nome do estabelecimento
        - Categoria do estabelecimento
    
    'Output':
        - Adiciona o novo estabelecimento a lista de estabelecimentos
    
    """ # Docstring ≥ Geralmente usada na primeira linha do código
    limpar_a_tela_e_exibir_subtitulo("Cadastro de novos estabelecimentos")

    nome_estabelecimento = input("Insira o nome do estabelecimento: ")
    categoria_estabelecimento = input(f"Insira a categoria do estabelecimento '{nome_estabelecimento}': ")

    novo_estabelecimento = {"nome":nome_estabelecimento, "categoria":categoria_estabelecimento, "ativo":False}
    estabelecimentos_dicionario.append(novo_estabelecimento)

    print(f"Estabelecimento '{nome_estabelecimento}' cadastrado com sucesso.")
    sleep(0.5)
    print("Vá ao menu principal para ativa-lo")
    sleep(0.5)

    exibir_linha_final("""Digite 1 para voltar ao menu de opções
Digite 2 para cadastrar outro estabelecimento: """)

def listar_estabelecimento():
    """ Esta função é responsável por listar os estabelecimentos cadastrados """
    limpar_a_tela_e_exibir_subtitulo("Lista de Estabelecimentos:")
    tamanho = 40

    print(f"{"Nome".ljust(42)} | {"Categoria".ljust(tamanho)} | {"Status"}")
    for item in estabelecimentos_dicionario: # Para cada 'item' na lista 'estabelecimentos'
        status = "Ativo" if item["ativo"] else "Inativo"
        print(f"- {item["nome"].ljust(tamanho)} | {item["categoria"].ljust(tamanho)} | {status}") # Função 'ljust()' serve para indicar quantos espaçamentos queremos

    exibir_linha_final("""Digite 1 para voltar ao menu de opções
Digite 3 para finalizar o programa: """)

def ativar_desativar_estabelecimento():
    """ Esta função é responsável por ativar ou desativar um estabelecimento

    'Inputs':
        - Nome estabelecimento

    'Output':
        - Troca o status do estabelecimento conforme o seu status atual
    """
    limpar_a_tela_e_exibir_subtitulo("Ativar/Desativar Estabelecimento")
    nome_estabelecimento = input("Insira o nome do estabelecimento que deseja ativar/desativar: ")

    for estabelecimento in estabelecimentos_dicionario:
        if nome_estabelecimento == estabelecimento["nome"]:
            estabelecimento["ativo"] = not estabelecimento["ativo"] # Caso seja True > False, caso seja False > True

            print(f"Estabelecimento '{estabelecimento["nome"]}' foi ativado com sucesso" if estabelecimento["ativo"] # Escreve essa mensagem se for True
                  else f"Estabelecimento '{estabelecimento["nome"]}' foi desativado com sucesso") # Escreve essa caso seja False
            sleep(0.3)

            exibir_linha_final("""Digite 1 para voltar ao menu principal
Digite 3 para finalizar o programa
Digite 4 para ativar/desativar outro estabelecimento
-> """)
        else:
            print(f"Estabelecimento '{nome_estabelecimento}' ainda não foi cadastrado")
            exibir_linha_final("""Digite 1 para cadastrar o restaurante
Digite 3 para finalizar o programa
-> """)

def finalizar_o_programa():
    """ Esta função é responsável por finalizar o programa """
    print("Finalizando...")
    # os.system("clear") -> Para MacOS
    sleep(0.5)
    exit()

def opcao_invalida():
    """ Esta função é responsável por indicar que a opção digitada é inválida

    'Input':
        - Tecla para voltar ao menu de opções
    """
    print("Opção inválida!\n")
    input("Digite uma tecla para voltar ao menu de opções: ")
    main()

def escolher_opcao():
    """ Esta função é responsável por verificar a escolha do usuário

    'Input':
        - Número da opção
    """
    try:
        resposta_usuario = int(input("Qual ação você deseja?: ")) # Variável como int
        if resposta_usuario == 1:
            cadastrar_estabelecimento()
        elif resposta_usuario == 2:
            listar_estabelecimento()
        elif resposta_usuario == 3:
            ativar_desativar_estabelecimento()
        elif resposta_usuario == 4:
            finalizar_o_programa()
        else:
            opcao_invalida()
    except ValueError:
        opcao_invalida()

def escolher_opcao_match(): # switch-case do python
    """ Versão com match-case da função anterior """
    try:
        resposta_usuario = int(input("Qual ação você deseja?: "))  # Variável como int
        match resposta_usuario:
            case 1:
                cadastrar_estabelecimento()
            case 2:
                listar_estabelecimento()
            case 3:
                ativar_desativar_estabelecimento()
            case 4:
                finalizar_o_programa()
            case _:
                opcao_invalida()
    except ValueError:
        opcao_invalida()

def main(): # Dentro desta função vamos definir todos os passos para que a nossa aplicação funcione, o programa vai seguir a ordem em que as funções aparecem
    """ Esta função é responsável por definir os passos da aplicação"""
    os.system("cls")
    exibir_nome_do_programa()
    exibir_opcoes()
    escolher_opcao()

if __name__ == "__main__":
    main()# Caso o 'name' do programa seja 'main', significa que ele não será importado por outros programas e que ele é o código principal da aplicação

# resposta_usuario = ‘input’("Qual ação você deseja?: ") ≥ Variável como string
# resposta_usuario = int(resposta_usuario) -> Outra maneira de se converter string para int

# print(f"Tipo da variável resposta_usuario: {type(resposta_usuario)}") -> Para verificar o tipo da variável, função 'type()'

# print("Você escolheu a opção: ", resposta_usuario) -> Imprimindo uma variável
# print(f"Formatação por F-String, a resposta do usuário foi: {resposta_usuario} \n") -> Formatação com print(f"")
