# 🚗 API de Consertos de Carros

Este é um projeto de **API RESTful** desenvolvido em **Java** com **Spring**, que implementa um CRUD completo para gerenciar **consertos de carros**.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Web**
- **Spring JPA**
- **Spring Validation**
- **Spring Security**
- **JWT Auth**
- **Flyway**
- **H2 Database (em arquivo)**
- **Maven**

___

## 📌 Objetivo do Projeto

Esta aplicação tem como finalidade permitir o cadastro, listagem, atualização e exclusão de registros relacionados a consertos de veículos. A estrutura do projeto foi pensada para aplicar boas práticas de desenvolvimento backend utilizando **Spring** e **JPA**.

> ℹ️ *Este projeto foi desenvolvido como parte de uma avaliação da disciplina de Programação Web na faculdade. Algumas funcionalidades têm foco didático e podem não refletir a complexidade de um sistema real.*

___

## 🧩 Arquitetura e Boas Práticas

- Utilização do **padrão DTO (Data Transfer Object)** para separação entre as camadas de domínio e apresentação.
- Aplicação dos princípios **SOLID** para garantir um código mais limpo, coeso e de fácil manutenção.
- Migrations controladas com o **Flyway**, garantindo versionamento do banco de dados desde a criação das tabelas.

___

## 🛠️ Como Executar

Para executar o projeto é necessário ter [java 21](https://www.oracle.com/br/java/technologies/downloads/#java21) e [maven](https://maven.apache.org/download.cgi) instalados.

1. Clone o repositório:
   ```sh
   git clone git@github.com:gusmaomatheus/car-repair-api.git
   cd car-repair-api
   ```

2. Compile e execute o projeto com Maven:
   ```sh
   mvn clean install
   ./mvnw spring-boot:run
   ```
___

## 📄 Acessando a aplicação:

- Utilizar o seguinte corpo na requisição `POST api/auth`:
```
{
  // Login padrão, utilizar ele. 
  "login": "usuario",
  "senha": "senha"
}
```

## 📫 Endpoints Principais

A API segue os princípios REST e expõe os seguintes endpoints:

- `POST api/auth` — Login (TODOS os endpoints abaixo necessitam que o usuário esteja logado).
- `GET api/conserto` — Lista todos os consertos de maneira detalhada.
- `GET api/conserto/resumo` — Lista todos os consertos de maneira resumida (apenas os consertos ativos).
- `GET api/conserto/{id}` — Detalha um conserto específico.
- `POST api/conserto` — Cadastra um novo conserto.
- `PATCH api/conserto/{id}` — Atualiza algumas das informações de um conserto.
- `DELETE api/conserto/inativar/{id}` — Inativa um conserto cadastrado.


#### 📄 JSON's de exemplo para as requisições:

- `POST api/conserto`
  ```json
  {
      "dataEntrada": "19/04/2025", // obrigatório
      "dataSaida": "20/04/2025", // obrigatório
      "dadosMecanico": {
        "nome": "Mecanico 1", // obrigatório
        "anosDeExperiencia": 5
      },
      "dadosVeiculo": {
        "marca": "bmw", // obrigatório
        "modelo": "320i", // obrigatório
        "ano": "2025", // obrigatório
        "cor": "Vermelho"
      }
  }
  ```

- `PATCH api/conserto/{id}`
  ```json
   {
      "dataSaida": "20/04/2025",
      "nomeMecanico": "Mecanico",
      "anosDeExperiencia": 0
   }
  ```  
___

## 📝 Licença
Este projeto tem finalidade educacional e não possui licença de uso específica.
