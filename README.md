# Aplicação de consulta ao Banco Mundial
## Consulta índice de pobreza por país

**Cleuton Sampaio, M.sc**

### Histórias

1) Selecionar o país de uma lista:

Ao abrir a aplicação deverá aparecer uma lista dos países que possuem o índice referido. Esta lista pode ser obtida a partir da URL: http://api.worldbank.org/v2/country e retorna um XML contendo os dados: 

```
wb:countries xmlns:wb="http://www.worldbank.org" page="1" pages="6" per_page="50" total="299">
<wb:country id="ABW">
<wb:iso2Code>AW</wb:iso2Code>
<wb:name>Aruba</wb:name>
<wb:region id="LCN" iso2code="ZJ">Latin America & Caribbean </wb:region>
<wb:adminregion id="" iso2code=""/>
<wb:incomeLevel id="HIC" iso2code="XD">High income</wb:incomeLevel>
<wb:lendingType id="LNX" iso2code="XX">Not classified</wb:lendingType>
<wb:capitalCity>Oranjestad</wb:capitalCity>
<wb:longitude>-70.0167</wb:longitude>
<wb:latitude>12.5167</wb:latitude>
</wb:country>
<wb:country id="AFE">
<wb:iso2Code>ZH</wb:iso2Code>
<wb:name>Africa Eastern and Southern</wb:name>
<wb:region id="NA" iso2code="NA">Aggregates</wb:region>
<wb:adminregion id="" iso2code=""/>
<wb:incomeLevel id="NA" iso2code="NA">Aggregates</wb:incomeLevel>
<wb:lendingType id="" iso2code="">Aggregates</wb:lendingType>
<wb:capitalCity/>
<wb:longitude/>
<wb:latitude/>
</wb:country>
...
```
O código de 3 letras do país, que aparece como atributo "id" do tag "wb:country" é a chave para obter os índices. 
Note que há uma paginação possível nessa lista, embora o esquema de API do Banco não mencione isso. 

O usuário deverá clicar sobre o nome do país para ver os índices.

2) Visualizar os índices por ano: 

Ao selecionar um país, como descrito na história 1, será feita uma consulta a outra API do Banco Mundial, através da URL: 

```
http://api.worldbank.org/v2/country/{CÓDIGO DO PAÍS}/indicator/SI.POV.DDAY?format=json
```

Deve-se substituir o texto "{CÓDIGO DO PAÍS}" pelo código de 3 letras do país, obtido na consulta da história 1.

O resultado será uma lista em JSON como esta: 

```
[
   {
      "page":1,
      "pages":2,
      "per_page":50,
      "total":61,
      "sourceid":"2",
      "sourcename":"World Development Indicators",
      "lastupdated":"2021-12-16"
   },
   [
      {
         "indicator":{
            "id":"SI.POV.DDAY",
            "value":"Poverty headcount ratio at $1.90 a day (2011 PPP) (% of population)"
         },
         "country":{
            "id":"CN",
            "value":"China"
         },
         "countryiso3code":"CHN",
         "date":"2020",
         "value":null,
         "unit":"",
         "obs_status":"",
         "decimal":1
      },
...
```

Desta lista deve ser montada uma tabela com o ano e o valor do índice (campo "value" logo apos o "date").

### Critérios de aceitação

1) Ao entrar na página inicial, a lista de países deve ser exibida com o nome de cada país;
2) Quando o usuário clicar em um país, os índices correspondentes a ele devem ser exibidos;
3) Deve ser possível retornar à lista de países (botão "voltar");
4) A aplicação não deve acessar diretamente a API do Banco Mundial;

### Cenários de teste

1) Ao entrar na página principal, a lista de países deve ser exibida;
2) Os nomes dos países devem ser hyperlinks;
3) Ao clicar sobre o nome de um país, a página de índices descrita na história 2 deve ser exibida;
4) Deve aparecer um botão "voltar";
5) Ao clicar no botão "voltar" a aplicação deve exibir novamente a lista de países;

### Plataforma

A aplicação foi desenvolvida utilizando: 
- Backend: Linguagem **Java**, versão 11, com framework **Quarkus** e **Maven**;
- Frontend: **Angular** versão 9;

O **deploy** é feito a partir do **docker-compose**, existindo um arquivo "docker-compose.yml" na raiz do projeto. A recompilação da aplicação pode ser feita: 
- Backend: mvn clean package (vai gerar um uber-jar);
- Frontend: ng build;

Para gerar as imagens: 
```
docker-compose build
```

Para subir os contêineres: 
```
docker-compose up
```

### Testes

A aplicação possui testes do **Quarkus** e do **Protractor**.





