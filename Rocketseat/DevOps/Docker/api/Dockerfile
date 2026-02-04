# Arquivo onde vamos declara o que nossa aplicação precisa

# Instalar o node
FROM node:lts-alpine3.23

# Definir o diretório de trabalho
WORKDIR "/usr/src/app"

# Para conseguir rodar o yarn || npm -> Precisamos do arquivo package.json ; ./ para indicar o workdir anterior
COPY package.json ./

# Instalar a aplicação
    # rodar um yarn || npm install
    RUN npm install

# Copiando tudo que esta no ambiente local para o container
COPY . .

# Build da aplicação
    # rodar yarn run build || npm run build
    RUN npm install build

# Expor alguma porta como boa prática, vamos usar a porta do main.ts
EXPOSE 3000

# Subir a aplicação
    # Por CMD -> Passando o executávele os parâmetros -> Mútavel a nível de CLI
    CMD ["npm", "run", "start"]

    # Por ENTRYPOINT -> Imútavel a nível de CLI

# docker run:
    # --rm -> Cada container tem um ciclo de vida, esse parâmetro indica que, ao final da vida desse container, ele deve ser removido
    # -p -> mapeamento de portas: <Portal_Local>:<Porta_No_Container>
    # -d -> Para não travar o terminal

# docker logs <ID_Do_Container> -> Para verificar os logs