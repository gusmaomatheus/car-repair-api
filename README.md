# 🚗 API de Consertos de Carros

Este é um projeto de **API RESTful** desenvolvido em **Java** com **Spring**, que implementa um CRUD completo para gerenciar **consertos de carros**.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Web**
- **Spring JPA**
- **Spring Validation**
- **Flyway**
- **H2 Database (em memória)**
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

## 🔍 Acessando o Banco de Dados

O banco de dados H2 está configurado em memória. Para visualizá-lo:

  1. Acesse [localhost](http://localhost:8080/api/h2-console) (com o programa rodando);
  2. Faça login utilizando as credenciais no arquivo `application.properties`.
     
___

## 📫 Endpoints Principais

A API saegue os princípios REST e expõe os seguintes endpoints:

- `GET api/conserto` — Lista todos os consertos de maneira detalhada.
- `GET api/conserto/resumo` — Lista todos os consertos de maneira resumida (apenas os consertos ativos).
- `GET api/conserto/{id}` — Detalha um conserto específico.
- `POST api/conserto` — Cadastra um novo conserto.
- `PUT api/conserto/{id}` — Atualiza as informações de um conserto.
- `DELETE /api/conserto/inativar/{id}` — Inativa um conserto cadastrado.


#### 📄 JSON exemplo para realizar o cadastro de um novo conserto:

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
  
___

## 📝 Licença
Este projeto tem finalidade educacional e não possui licença de uso específica.
