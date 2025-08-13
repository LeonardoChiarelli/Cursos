 													 Arquitetura Java: crie uma infraestrutura escalável



1. Build do projeto

 	- Vamos gerar o package da aplicação

 		-  Ou diretamente pela IDE ou via terminal



2\.  Adicionar o Docker no projeto

 	- Primeiramente vamos criar o Dockerfile



3\.  Adicionando o Docker Compose

 	- Vamos criar um outro profile -> outro arquivo .yml específico para ambiente de produção

 	- Criar o arquivo docker-compose.yml

 	- Vamos criar a pasta .env para colocar as variáveis de ambiente que serão usadas no docker-compose

 	- Vamos colocar a pasta .env e a pasta onde vamos salvar os dados do mysql (mysql-data) dentro do gitignore



4\. Deploy em um servidor

 	- Dentro do servidor de Cloud vamos criar uma instância, acessar o servidor via SSH e instalar o docker e o docker compose dentro da instância

 		- Allow SSH traffic from Anywhere

 		- Allow HTTPS traffic from the internet

 		- Allow HTTP traffic from the internet

 			- sudo yum update -y \&\& sudo yum install docker -y \&\& sudo usermod -a -G docker ec2-user \&\& sudo service docker start \&\& newgrp docker \&\& sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose \&\& sudo chmod +x /usr/local/bin/docker-compose

 	- Vamos copiar o docker-compose.yml e a pasta .env para dentro da instância

 		- scp -i ~/key-pair.pem docker-compose.yml ec2-user@3.82.57.80:/home/ec2-user

 		- scp -i ~/key-pair.pem -r env ec2-user@3.82.57.80:/home/ec2-user

 	- Agora vamos fazer login via SSH

 		- ssh -i ~/key-pair.pem ec2-user@3.82.57.80

 	- Vamos subir o container

 	- E vamos apagar a pasta .env do nosso ambiente local



5\. Acessando a aplicação

 	- Ao tentarmos acessar a aplicação diretamente pelo painel da AWS tanto pelo DNS quanto pelo IP público vamos obter um erro, pois dentro do servidor de produção não configuramos qual porta está sendo exposta.

 		-  Podemos expor a porta que vamos utilizar para acessar a aplicação -> Mas não é a opção ideal

 		-  Vamos fazer um proxy reverso, que vai funcionar como um intermediário entre o cliente e o servidor

 	- Há várias ferramentas para fazer um proxy reverso, como o Apache, HAProxy, NGINX -> Vamos utilizar o NGINX



6\. Adicionando o NGINX

 	- Primeiro paramos a aplicação em produção (dentro do terminal da instância)

 	- Vamos no arquivo "docker-compose.yml" e adicionar o container do NGINX (podemos modificar direto do terminal da instância, com o vim)

 		- Dentro da sessão de services, vamos adicionar as seguintes linhas:

 			- nginx:

 				image: nginx:stable-alpine

 				ports:

 					- "80:80"

 	- Subimos o container novamente



7\. Configurando o NGINX

 	- Dentro do terminal da aplicação vamos criar um diretório para as configurações do nginx

 		- Dentro da pasta vamos criar um arquivo \*.conf

 			- server {

 				listen 80;

 				server\_name app;



 				location / {

 					proxy\_pass http://app:8080;

 					proxy\_set\_header Host $host;

 					proxy\_set\_header X-Real-IP $remote\_addr;

 					proxy\_set\_header X-Forwarded-For $proxy\_add\_x\_forwarded\_for;

 					proxy\_set\_header X-Forwarded-Proto $scheme;

 				}

 		}



8\. Pool de conexões

&nbsp;	- Como estamos utilizando o Spring, há uma biblioteca padrão que já inicializa esse pool de conexões, por padrão o Spring quando usa essa biblioteca mantém 15 conexões abertas

&nbsp;	- Para aumentar esse número de conexões, vamos até a classe 'application.yml'  e adicionar o seguinte código:

&nbsp;		spring:

&nbsp;			datasource:

&nbsp;				hikari:

&nbsp;					minimum-idle: 15

&nbsp;					maximum-pool-size: 40

&nbsp;					connectionTimeout: 10000

&nbsp;					idleTimeout: 600000

&nbsp;					maxLifetime: 1800000



9\. Índice em tabelas

&nbsp;	- Vamos nas classes repository e verificar métodos de busca com parâmetros e ver se faz sentido criar índices para estes métodos

&nbsp;		- Geralmente adiciona-se indices em tabelas com um grande volume de dados

&nbsp;	- Vamos criar uma nova migration para criar as tabelas de índice 



10\. ORM e SQL

&nbsp;	- Vamos tentar minimizar o número de consultas no banco de dados para cada requisição que é disparada

