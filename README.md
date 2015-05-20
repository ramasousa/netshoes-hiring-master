# Avaliação Técnica Netshoes

Projetos desenvolvidos para avaliação técnica da Netshoes. Os seguintes módulos foram desenvolvidos:

  <b>CepService</b> - Projeto Rest com objetivo de expor um serviço que permite a obtenção de um endereço a partir de um CEP                       informado.</br>
  
  <b>HiringJStream</b> - Projeto de Stream implementando a interface proposta no cenário, ou seja, identifica o primeiro                              caracter que não se repete em uma determinada Stream.</br>
  
<b>CadastroCepService</b> Projeto desenvolvido para efetuar o CRUD de um endereço

## HiringJStream
### Instalação
Para efetuar a instalação executar o comando abaixo com o Maven na pasta do projeto:
```sh
cd project/folder
mvn clean install
```

### Execução

Após o build do Maven, para executar basta executar o comando abaixo na pasta do target gerado:
```sh
java -jar jstream-1.0.0.jar CHAR_SEQUENCE
```
onde CHAR_SEQUENCE será substituído pela lista de chars, exemplo:
```sh
java -jar jstream-1.0.0.jar aaAAbbBB
```


## CepService
Efetuar o build com o Maven (clean install), deployar no servidor e após isso executá-lo:

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{"id":"06807060"}' http://host-netshoes:port-netshoes/cepservice/api/
```

## CadastroCepService
Efetuar o build com o Maven (clean install), deployar no servidor de aplicação e após isso executá-lo:

#### Create Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{"street":"Rua Netshoes","number":"2015","cep":"06015015","city":"Netshoes","state":"SP"}' http://host:port/crudcepservice/api/
```
#### Select Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X GET http://host:port/crudcepservice/api/id
```

#### Update Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X PUT -d '{"id":"1f753ab3-1df3-4a99-8556-7e820fb9c3x7","street":"Rua Netshoes","number":"2015","cep":"06753163","district":Netshoes,"city":"Netshoes","state":"SP","otherInformation":null}' http://host:port/crudcepservice/api/
```


#### Delete Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X DELETE http://host:port/crudcepservice/api/id
```



License
----
GNU PUBLIC LICENSE

**Raul Sousa**

