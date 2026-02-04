# Otimizações e boas práticas nas imagens

FROM node:lts-alpine3.23

WORKDIR "/usr/src/app"

# Como estamos trabalhando com npm, passamos o * ao lado do package, para copiarmos também o package.lock
    # Caso estivessemos trabalhando com yarn, adicionariamos o yarn.lock, .yarnrc.yml, 
COPY package*.json ./

# Para copiarmos a pasta .yarn (Caso estivessemos usando) -> Adicionaríamos a linha
# COPY .yarn ./.yarn

RUN npm install

# criaremos o .dockerignore -> Para nâo copiarmos o node_modules, nem dist (caso exista) + algumas boas práticas
COPY . .

RUN npm install build

EXPOSE 3000

CMD ["npm", "run", "start"]

# Ao fazer o build da imagens, vamos passar a usar as tags
    # docker build -t <image>:<version/tag> -> Enquanto não subimos para o git