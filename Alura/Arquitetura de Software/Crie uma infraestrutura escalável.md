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

&nbsp;	- Ao tentarmos acessar a aplicação diretamente pelo painel da AWS tanto pelo DNS quanto pelo IP público vamos obter um erro, pois dentro do servidor de produção não configuramos qual porta está sendo exposta.

&nbsp;		-  Podemos expor a porta que vamos utilizar para acessar a aplicação -> Mas não é a opção ideal

&nbsp;		-  Vamos fazer um proxy reverso, que vai funcionar como um intermediário entre o cliente e o servidor

&nbsp;	- Há várias ferramentas para fazer um proxy reverso, como o Apache, HAProxy, NGINX -> Vamos utilizar o NGINX



6\. Adicionando o NGINX

&nbsp;	- Primeiro paramos a aplicação em produção (dentro do terminal da instância)

&nbsp;	- Vamos no arquivo "docker-compose.yml" e adicionar o container do NGINX (podemos modificar direto do terminal da instância, com o vim)

&nbsp;		- Dentro da sessão de services, vamos adicionar as seguintes linhas:

&nbsp;			- nginx:

&nbsp;				image: nginx:stable-alpine

&nbsp;				ports:

&nbsp;					- "80:80"

&nbsp;	- Subimos o container novamente



7\. Configurando o NGINX

&nbsp;	- Dentro do terminal da aplicação vamos criar um diretório para as configurações do nginx

&nbsp;		- Dentro da pasta vamos criar um arquivo \*.conf

&nbsp;			- server {

&nbsp;				listen 80;

&nbsp;				server\_name app;



&nbsp;				location / {

&nbsp;					proxy\_pass http://app:8080;

&nbsp;					proxy\_set\_header Host $host;

&nbsp;					proxy\_set\_header X-Real-IP $remote\_addr;

&nbsp;					proxy\_set\_header X-Forwarded-For $proxy\_add\_x\_forwarded\_for;

&nbsp;					proxy\_set\_header X-Forwarded-Proto $scheme;

&nbsp;				}

&nbsp;		}

