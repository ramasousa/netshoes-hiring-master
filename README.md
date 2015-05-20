# Avaliação Técnica Netshoes

Projetos desenvolvidos para avaliação técnica da Netshoes. Os seguintes módulos foram desenvolvidos:

  - CepService - Projeto Rest que permite a obtenção de um endereço
  - CrudCepService - Projeto desenvolvido para efetuar o CRUD de um endereço
  - HiringJStream - Projeto de Stream implementando a interface proposta no cenário 

Instruções de Instalação:

## CepService
Efetuar o build com o Maven (clean install), deployar no servidor de preferência (eg. Tomcat) e após isso executá-lo conforme abaixo:

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{"id":"06807060"}' http://host:port/cepservice/api/
```

## CrudService
Efetuar o build com o Maven (clean install), deployar no servidor de aplicação de preferência (eg. Tomcat) e após isso executá-lo conforme exemplos abaixo:

#### Create Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{"rua":"Rua Netshoes","numero":"2015","cep":"06015015","cidade":"Netshoes","estado":"SP"}' http://host:port/crudservice/api/
```
#### Update Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X PUT -d '{"id":"1f743aa3-1df3-4a79-8666-7e820fb4a3c6","rua":"Rua 20","numero":"02","cep":"06753163","bairro":null,"cidade":"aaaaa","estado":"BA","complemento":null}' http://host:port/crudservice/api/
```

#### Get Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X GET http://host:port/crudservice/api/id
```

#### Delete Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X DELETE http://host:port/crudservice/api/id
```

## JStream
### Instalação
Para efetuar a instalação basta executar o comando abaixo com o Maven na pasta do projeto:
```sh
cd project/folder
mvn clean install
```

### Execução

Após o build do Maven, para executar basta executar o comando abaixo na pasta do target gerado:
```sh
java -jar jstream-1.0.0-SNAPSHOT.jar CHAR_SEQUENCE
```
onde CHAR_SEQUENCE será substituído pela lista de chars, exemplo:
```sh
java -jar jstream-1.0.0-SNAPSHOT.jar aaAAbbBB
```


## Misc

Acelerado por:

* [MAVEN] - Simplify the build processes

License
----
GNU PUBLIC LICENSE

**Raul Sousa**

[MAVEN]:https://maven.apache.org/

