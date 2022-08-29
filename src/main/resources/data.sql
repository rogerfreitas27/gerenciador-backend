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


--  Estes endereços são de pessoas que tem dois endereços 


INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('24804668','Itaboraí','Travessa Rosa Novaes',756,0,1);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('50741260','Recife','Rua Mendanha',259,0,2);
INSERT INTO ENDERECO (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('79064245','Campo Grande','Avenida Gury Marques',244,0,3);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('64480970','Arraial','Avenida Cândido Muniz, s/n',676,0,4);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('57080120','Maceió','Rua Anadia',598,0,5);
INSERT INTO ENDERECO   (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('77825430','Araguaína','Rua Pavão',539,0,6);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('68904620','Macapá','Avenida Dezoito de Julho',209,0,7);



--  Estes endereços são de pessoas que tem três endereços 

INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)  VALUES('78730710','Rondonópolis','Rua Emanoel Araújo Carvalho',124,0,1);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('04963010','São Paulo','Avenida dos Funcionários Públicos',552,0,2);
INSERT INTO ENDERECO  (cep,cidade,logradouro,numero,principal,pessoa_id)   VALUES('78700426','Rondonópolis','Rua Dom Pedro II',252,0,3);

		
		
		
		
		
		
		

