# Avaliação Técnica Netshoes

Projetos desenvolvidos para avaliação técnica da Netshoes. Os seguintes módulos foram desenvolvidos:

  <b>CepRestfull</b> - Projeto Rest com objetivo de expor um serviço que permite a obtenção de um endereço a partir de um CEP                       informado.</br>
  
  <b>StreamReader</b> - Projeto de Stream implementando a interface proposta no cenário, ou seja, identifica o primeiro                              caracter que não se repete em uma determinada Stream.</br>
  
<b>AddressRestfull</b> Projeto desenvolvido para efetuar o CRUD de um endereço

## StreamReader
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


## CepRestfull
Efetuar o build com o Maven (clean install), deployar no servidor e após isso executá-lo:

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{\"id\":\"06807060\"}' http://netshoes_host:port/ceprestfull/api/
```

## Available IDs to POST in CepRestfull
```sh
06823240
06807050
06807040
```

## AddressRestfull
Efetuar o build com o Maven (clean install), deployar no servidor de aplicação e após isso executá-lo:

#### Create Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{\"street\":\"Rua Netshoes\",\"number\":\"2015\",\"cep\":\"06807060\",\"city\":\"Netshoes\",\"state\":\"SP\"}' http://netshoes_host:port/adressrestfull/api/
```
#### Read Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X GET http://netshoes_host:port/adressrestfull/api/id
```

#### Update Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X PUT -d '{\"id\":\"06807040\",\"street\":\"Rua Netshoes\",\"number\":\"2015\",\"cep\":\"06807040\",\"district\":\"Netshoes\",\"city\":\"Netshoes\",\"state\":\"SP\",\"otherInformation\":null}' http://netshoes_host:port/adressrestfull/api/
```


#### Delete Address

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X DELETE http://netshoes_host:port/adressrestfull/api/id
```



License
----
GNU PUBLIC LICENSE

**Raul Sousa**

