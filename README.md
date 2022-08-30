# Gerenciador de Pessoas



# Descrição



A api gerenciador de pessoas como  o próprio nome sugere, e uma api para gerenciar o cadastro de pessoas,
nela podemos cadastrar pessoas e seus respectivos endereços, onde uma pessoa pode ter mais de um endereço,
este projeto é basicamente um CRUD, mas não apenas, pois como uma pessoa pode ter muitos endereços, foi necessária, 
alguma logica de programação para garantir que apenas um endereço de pessoa seja 
o principal.
Como desafio me foi proposto este projeto de backend usando as seguintes tecnologias:


- Java
- Spring Boot 
- H2

Para evoluir no aprendizado no back inclui as seguintes tecnologias:


- Docker
- JasperReport


No front crie uma aplicação simples em angular para consumir os meus serviços (O foco neste projeto é o backend, mas aprender nunca é demais)


Link do front :  https://rogerfreitas27.github.io/gerenciador-frontend/


Link do código do front: 

Nesta api pude trabalhar com o banco H2 pela primeira vez, como utilizo para os meus estudos SGBDS "tradicionais"
(Postgres e Mysql), num primeiro momento senti a diferença, pois com os SGBDS utilizo muito querys nativa,
pela flexibilidade e por uma maior documentação de uso, com o H2 vi a necessidade do JPQL pois ele abstrai algumas 
particularidades dos bancos, trazendo mais transparência.
Gostei da experiência de utilizar o h2, por  ser leve e poder ser integrado muito facilmente no ambiente de desenvolvimento.





# Instalação e execução
Para este projeto eu criei um script com uma boa quantidade de registros para teste

O arquivo está em:


src/main/resources/ 


 data.sql




Obs: Altere  a JDBC URL  para : jdbc:h2:file:~/gerenciador;AUTO_SERVER=TRUE

Caso deseje baixar ou clonar o projeto para teste, ou aprendizado, em: src/main/resources/application.properties


Altere a variável :  ${USUARIO}  para  :   

um nome de sua escolha


Altere a variável : ${URL_BANCO} para  :   

jdbc:h2:file:~/gerenciador;AUTO_SERVER=TRUE




Para acessar o banco  após carregar o projeto

Para acessar o banco  digite as informações abaixo no navegador :

http://localhost:8080/h2-ui/


insira as informações de usuario ( a que você escolheu) e insiria a url do banco (jdbc:h2:file:~/gerenciador;AUTO_SERVER=TRUE)
Entre no banco , clicando em connect



Abaixo está o script 



```mysql




INSERT INTO PESSOA (data_nascimento,nome) VALUES('1950-06-25','Filipe Samuel');
INSERT INTO PESSOA  (data_nascimento,nome) VALUES('1948-06-07','Clarice Amanda Bianca Nunes');
INSERT INTO PESSOA (data_nascimento,nome)  VALUES('1951-02-19','Miguel Felipe Caio Cavalcanti');
INSERT INTO PESSOA (data_nascimento,nome)  VALUES('1993-05-08','Sarah Flávia Ramos');
INSERT INTO PESSOA (data_nascimento,nome)  VALUES('1954-07-15','Luciana Jéssica Peixoto');
INSERT INTO PESSOA  (data_nascimento,nome) VALUES('1994-04-27','Raquel Louise Almada');
INSERT INTO PESSOA  (data_nascimento,nome) VALUES('1995-04-17','Joaquim Murilo Baptista');
INSERT INTO PESSOA  (data_nascimento,nome) VALUES('2003-06-22','Fabiana Carla Adriana de Paula');
INSERT INTO PESSOA (data_nascimento,nome) VALUES('1957-05-25','Renata Lara Cecília');
INSERT INTO PESSOA  (data_nascimento,nome) VALUES('1994-03-08','Fernando Thomas Nascimento');
INSERT INTO PESSOA (data_nascimento,nome)  VALUES('2003-06-05','Mirella Brenda Tereza');
INSERT INTO PESSOA (data_nascimento,nome) VALUES('1957-07-14','Breno Osvaldo Mário');
INSERT INTO PESSOA  (data_nascimento,nome) VALUES('1988-04-06','Maria Fatima Joana');
INSERT INTO PESSOA (data_nascimento,nome)  VALUES('1955-06-01','Raimunda Gabrela Costa');
INSERT INTO PESSOA (data_nascimento,nome)  VALUES('2002-05-24','Augusto Marcos Duarte');
INSERT INTO PESSOA (data_nascimento,nome)  VALUES('1978-07-15','Patricia  Luiza da Cunha');
INSERT INTO PESSOA  (data_nascimento,nome) VALUES('1963-03-01','Sophia Stella da Rocha');
INSERT INTO PESSOA  (data_nascimento,nome) VALUES('1982-04-13','Mariah Giovana dos Santos');
INSERT INTO PESSOA  (data_nascimento,nome) VALUES('1981-01-24','Lorenzo Martins Tomás');
INSERT INTO PESSOA (data_nascimento,nome)  VALUES('2001-04-14','Miguel Claudio Anthony Martins');
INSERT INTO PESSOA  (data_nascimento,nome) VALUES('1960-03-09','Oliver Diego Luan Almada');







-- Cada endereço esta relacionado com uma pessoa especifica 





INSERT INTO ENDERECO (cep,cidade,logradouro,numero,principal,pessoa_id) VALUES('03950005','São Paulo','Praça  Maria do Carmo Campos Paula',625,1,1);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('08752580','Mogi das Cruzes','Rua Paulo Alves Cassola',448,1,2);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('49040630','Aracaju','Rua Vênus',175,1,3);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('29714110','Colatina','Comunidade São Domingues',304,1,4);
INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('69097321','Manaus','Rua Morávia',865,1,5);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('68906806','Macapá','Via Local Oito',995,1,6);
INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)    VALUES('69316775','Boa Vista','Rua Calebe',367,1,7);
INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('35040090','Governador Valadares','Rua Campos Sales',257,1,8);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('74555190','Goiânia','Rua 7',306,1,9);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('40720426','Salvador','Travessa Paulo Cesar',956,1,10);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('69317542','Boa Vista','Rua Tenente Azevedo Cruz',827,1,11);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('65072390','São Luis','Rua Quatro',944,1,12);
INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('77405170','Gurupi','Rua Quatro',642,1,13);
INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('77405170','Gurupi','Avenida Goias',642,1,14);
INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('35500341','Divinópolis','Rua Engenheiro Teófilo Ribeiro',381,1,15);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('68900050','Macapá','Avenida General Gurjão',906,1,16);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('11703700','Praia Grande','Rua Rafael Farisco',210,1,17);
INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('68903381','Macapá','Ramal Mururema',580,1,18);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('96508540','Cachoeira do Sul','Rua Ignácio Adolfo Charão',600,1,19);
INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('98909173','Macapá','Avenida das Nações',234,1,20);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('98909173','Brasília','Quadra QNN 2 Conjunto A',173,1,21);


--  Este script é para pessoa ter dois endereços 


INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('24804668','Itaboraí','Travessa Rosa Novaes',756,0,1);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('50741260','Recife','Rua Mendanha',259,0,2);
INSERT INTO ENDERECO (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('79064245','Campo Grande','Avenida Gury Marques',244,0,3);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('64480970','Arraial','Avenida Cândido Muniz, s/n',676,0,4);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('57080120','Maceió','Rua Anadia',598,0,5);
INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('77825430','Araguaína','Rua Pavão',539,0,6);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('68904620','Macapá','Avenida Dezoito de Julho',209,0,7);



--   Este script é para pessoa ter três endereços 

INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('78730710','Rondonópolis','Rua Emanoel Araújo Carvalho',124,0,1);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('04963010','São Paulo','Avenida dos Funcionários Públicos',552,0,2);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('78700426','Rondonópolis','Rua Dom Pedro II',252,0,3);

		
		
	
	

```



# Instruçoes para uso da api


Para documentar e realizar os testes da api, eu usei o Swagger, link para testar os endpoints:

http://localhost:8080/swagger-ui/index.html#/


Caso prefira o postman segue as orinetações abaixo:


- criar uma pessoa


verbo http: Post


url : localhost:8080/api/pessoa


```json

{"id":"",
    "nome":"Nome da pessoa",
    "dataNascimento":"1950-06-25",
    "enderecos":[
{"id":"","logradouro":"Praça  Maria do Carmo Campos Paula","cep":"03950005","numero":625,"cidade":"São Paulo","principal":true},
{"id":"","logradouro":"Travessa Rosa Novaes","cep":"24804668","numero":756,"cidade":"Itaboraí","principal":false},
{"id":"","logradouro":"Rua Emanoel Araújo Carvalho","cep":"78730710","numero":124,"cidade":"Rondonópolis","principal":false}]
    }
```


Obs : A api permite o cadastro de uma lista de endereços, onde pelo menos 1 precisa ser principal.
Também é possível cadastrar um endereço, mas a estrutura do json precisa ser mantida (Como pessoa pode ter mais
de um endereço, eu fiz desta forma, o exemplo de cima e de baixo funcionam)


Formato do json esperado pela Api


``` json
{"id":"",
    "nome":"Nome da pessoa",
    "dataNascimento":"1950-06-25",
    "enderecos":[
{"id":"","logradouro":"Praça  Maria do Carmo Campos Paula","cep":"03950005","numero":625,"cidade":"São Paulo","principal":true}
               ]
    }

```




- Editar uma pessoa


  verbo http: Put
  
  
url : localhost:8080/api/pessoa



Formato do json esperado pela Api


``` json
{
  "id": 22,
  "nome": "Roger Samuel",
  "dataNascimento": "1950-06-25",
  "enderecos": [
    {
      "id": 32,
      "logradouro": "Praça  Maria do Carmo Campos Paula",
      "cep": "03950005",
      "numero": 625,
      "cidade": "São Paulo",
      "principal": true
    },
    {
      "id": 33,
      "logradouro": "Travessa Rosa Novaes",
      "cep": "24804668",
      "numero": 756,
      "cidade": "Itaboraí",
      "principal": false
    },
    {
      "id": 34,
      "logradouro": "Rua Emanoel Araújo Carvalho",
      "cep": "78730710",
      "numero": 124,
      "cidade": "Rondonópolis",
      "principal": false
    }
  ]
}


```


Obs : A api permite a edição de uma lista de endereços, onde pelo menos 1 precisa ser principal.
Também é possível editar um endereço, mas a estrutura do json precisa ser mantida (Como pessoa pode ter mais
de um endereço, eu fiz desta forma, o exemplo de cima e de baixo funcionam)

Formato do json esperado.


``` json

{
  "id": 22,
  "nome": "Roger Samuel",
  "dataNascimento": "1950-06-25",
  "enderecos": [
    {
      "id": 32,
      "logradouro": "Praça  Maria do Carmo Campos Paula",
      "cep": "03950005",
      "numero": 625,
      "cidade": "São Paulo",
      "principal": true
    }
      ]
}
```



- Consultar uma pessoa


  verbo http: Get
  
  
url : localhost:8080/api/pessoa/1


Onde 1 representa um numero de id, previamente cadastrado no banco de dados.



Resposta da Api


``` json
{
  "id": 1,
  "nome": "Filipe Samuel",
  "dataNascimento": "1950-06-25",
  "enderecos": [
    {
      "id": 1,
      "logradouro": "Praça  Maria do Carmo Campos Paula",
      "cep": "03950005",
      "numero": 625,
      "cidade": "São Paulo",
      "principal": true
    },
    {
      "id": 22,
      "logradouro": "Travessa Rosa Novaes",
      "cep": "24804668",
      "numero": 756,
      "cidade": "Itaboraí",
      "principal": false
    },
    {
      "id": 29,
      "logradouro": "Rua Emanoel Araújo Carvalho",
      "cep": "78730710",
      "numero": 124,
      "cidade": "Rondonópolis",
      "principal": false
    }
  ]
}
```



- Listar pessoas


  verbo http: Get
  
  
  http://localhost:8080/api/pessoa?page=0&sort=id,asc
  

A api lista os dados paginados, como default , é retornado em cada pagina 10 registros,onde page=0 
(Zero representa o numero da pagina).



Resposta da Api


``` json
{"content":[{"id":1,"nome":"Filipe Samuel","dataNascimento":"1950-06-25","enderecos":[{"id":1,"logradouro":"Praça  Maria do Carmo Campos Paula","cep":"03950005","numero":625,"cidade":"São Paulo","principal":true},{"id":22,"logradouro":"Travessa Rosa Novaes","cep":"24804668","numero":756,"cidade":"Itaboraí","principal":false},{"id":29,"logradouro":"Rua Emanoel Araújo Carvalho","cep":"78730710","numero":124,"cidade":"Rondonópolis","principal":false}]},
{"id":2,"nome":"Clarice Amanda Bianca Nunes","dataNascimento":"1948-06-07","enderecos":[{"id":2,"logradouro":"Rua Paulo Alves Cassola","cep":"08752580","numero":448,"cidade":"Mogi das Cruzes","principal":true},{"id":23,"logradouro":"Rua Mendanha","cep":"50741260","numero":259,"cidade":"Recife","principal":false},{"id":30,"logradouro":"Avenida dos Funcionários Públicos","cep":"04963010","numero":552,"cidade":"São Paulo","principal":false}]},
{"id":3,"nome":"Miguel Felipe Caio Cavalcanti","dataNascimento":"1951-02-19","enderecos":[{"id":3,"logradouro":"Rua Vênus","cep":"49040630","numero":175,"cidade":"Aracaju","principal":true},{"id":24,"logradouro":"Avenida Gury Marques","cep":"79064245","numero":244,"cidade":"Campo Grande","principal":false},{"id":31,"logradouro":"Rua Dom Pedro II","cep":"78700426","numero":252,"cidade":"Rondonópolis","principal":false}]},
{"id":4,"nome":"Sarah Flávia Ramos","dataNascimento":"1993-05-08","enderecos":[{"id":4,"logradouro":"Comunidade São Domingues","cep":"29714110","numero":304,"cidade":"Colatina","principal":true},{"id":25,"logradouro":"Avenida Cândido Muniz, s/n","cep":"64480970","numero":676,"cidade":"Arraial","principal":false}]},
{"id":5,"nome":"Luciana Jéssica Peixoto","dataNascimento":"1954-07-15","enderecos":[{"id":5,"logradouro":"Rua Morávia","cep":"69097321","numero":865,"cidade":"Manaus","principal":true},{"id":26,"logradouro":"Rua Anadia","cep":"57080120","numero":598,"cidade":"Maceió","principal":false}]},
{"id":6,"nome":"Raquel Louise Almada","dataNascimento":"1994-04-27","enderecos":[{"id":6,"logradouro":"Via Local Oito","cep":"68906806","numero":995,"cidade":"Macapá","principal":true},{"id":27,"logradouro":"Rua Pavão","cep":"77825430","numero":539,"cidade":"Araguaína","principal":false}]},
{"id":7,"nome":"Joaquim Murilo Baptista","dataNascimento":"1995-04-17","enderecos":[{"id":7,"logradouro":"Rua Calebe","cep":"69316775","numero":367,"cidade":"Boa Vista","principal":true},{"id":28,"logradouro":"Avenida Dezoito de Julho","cep":"68904620","numero":209,"cidade":"Macapá","principal":false}]},
{"id":8,"nome":"Fabiana Carla Adriana de Paula","dataNascimento":"2003-06-22","enderecos":[{"id":8,"logradouro":"Rua Campos Sales","cep":"35040090","numero":257,"cidade":"Governador Valadares","principal":true}]},
{"id":9,"nome":"Renata Lara Cecília","dataNascimento":"1957-05-25","enderecos":[{"id":9,"logradouro":"Rua 7","cep":"74555190","numero":306,"cidade":"Goiânia","principal":true}]},
{"id":10,"nome":"Fernando Thomas Nascimento","dataNascimento":"1994-03-08","enderecos":[{"id":10,"logradouro":"Travessa Paulo Cesar","cep":"40720426","numero":956,"cidade":"Salvador","principal":true}]}],
"pageable":{"sort":{"empty":false,"sorted":true,"unsorted":false},"offset":0,"pageNumber":0,"pageSize":10,"unpaged":false,"paged":true},"last":false,"totalElements":21,"totalPages":3,"size":10,"number":0,"sort":{"empty":false,"sorted":true,"unsorted":false},"first":true,"numberOfElements":10,"empty":false}


```




- Criar Endereco


  verbo http: Post
  
  
  http://localhost:8080/api/endereco
  

Formato do json esperado.


``` json

{"id":"","logradouro":"Av. Brasil","cep":"23078002","numero":4500,"cidade":"João Pessoa","principal":true,"idPessoa" :1}
 ```
 
 
Resposta da Api


``` json
{"id":"","logradouro":"Av. Brasil","cep":"23078002","numero":4500,"cidade":"João Pessoa","principal":true,"idPessoa" :1}           
```
    

- Listar endereços da pessoa


  verbo http: get
  
  
  http://localhost:8080/api/endereco/1
  
  

Onde 1 representa o id de uma pessoa(registro) previamente cadastrado

Resposta da Api


``` json
[{"id":1,"logradouro":"Praça  Maria do Carmo Campos Paula","cep":"03950005","numero":625,"cidade":"São Paulo","principal":false},
{"id":22,"logradouro":"Travessa Rosa Novaes","cep":"24804668","numero":756,"cidade":"Itaboraí","principal":false},
{"id":29,"logradouro":"Rua Emanoel Araújo Carvalho","cep":"78730710","numero":124,"cidade":"Rondonópolis","principal":false},
{"id":32,"logradouro":"Av. Brasil","cep":"23078002","numero":4500,"cidade":"João Pessoa","principal":true}]
```

- Poder informar qual endereço é o principal


  verbo http: Post
  
  
  http://localhost:8080/api/endereco/update/1
  
  

Onde 1 representa o id de uma pessoa(registro) previamente cadastrado



Resposta da Api



``` json
{
  "id": 1,
  "logradouro": "Praça  Maria do Carmo Campos Paula",
  "cep": "03950005",
  "numero": 625,
  "cidade": "São Paulo",
  "principal": true
}
```


# Funcionamento da  a api no Heroku


Documentação


https://gerenciador-backend.herokuapp.com/swagger-ui/index.html#/




# Funcionamento da  a api com docker


Caso prefira rodar a aplicação localmente pelo docker para teste:


Baixe  e descompacte o repositorio ou clone:

 

1 - Na raiz do projeto onde contém o Dockerfile

```docker
docker build --tag backend .
```

Para verificar se a imagem foi gerado digite:

```docker
docker images
```

2-Para rodar o container 

```docker
docker run -d -p 8080:8080 backend
```


Se tudo correr bem será impresso o id do container no terminal


Depois de alguns segundos digite a seguinte url de teste
(Este procedimento foi realizado na minha maquina local):
http://localhost:8080/api/pessoa


Url banco  : http://localhost:8080/h2-ui


Altere  a JDBC URL  para : jdbc:h2:file:~/gerenciador;AUTO_SERVER=TRUE


Altere  User Name para :  USUARIO senha_bd


Obs: O dockerfile está configurado para rodar com as configurações acima 

Url Swagger : http://localhost:8080/swagger-ui/index.html#/



O postaman agora pode ser testado localmente.












