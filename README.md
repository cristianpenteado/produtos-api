# API REST para CRUD de Produtos

> API REST para um CRUD completo de Produtos e Marcas, desenvolvida com Spring Boot 3 e Java 21.

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-4.0-red.svg)](https://maven.apache.org/)
[![Database](https://img.shields.io/badge/Database-H2-blue.svg)]()

## Descrição

Este projeto consiste em uma API RESTful para gerenciamento de produtos, permitindo operações de Criar, Ler, Atualizar e Deletar (CRUD). Cada produto está associado a uma marca, que também pode ser gerenciada pela API. O projeto foi construído utilizando as melhores práticas de desenvolvimento, incluindo arquitetura em camadas, DTOs (Data Transfer Objects) para desacoplamento e segurança, e tratamento de exceções centralizado.

##  Funcionalidades

- [x] CRUD completo para Produtos.
- [x] CRUD completo para Marcas.
- [x] Paginação de resultados na listagem de produtos e marcas.
- [x] Validação de dados de entrada na camada de DTOs.
- [x] Tratamento de exceções centralizado para respostas de erro padronizadas.
- [x] Separação de responsabilidades entre as camadas de Controller, Service e Repository.

## Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3.5
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** H2 (Banco de dados em memória)
* **Gerenciador de Dependências:** Maven
* **Validação:** Jakarta Bean Validation

## 📚 Endpoints da API

A URL base para todos os endpoints é `http://localhost:8080`.

---

### Produtos (`/api/produtos`)

| Método   | Endpoint             | Descrição                                        |
| :------- | :------------------- | :----------------------------------------------- |
| `POST`   | `/api/produtos`      | Cria um novo produto.                            |
| `GET`    | `/api/produtos`      | Lista todos os produtos com suporte a paginação. |
| `PUT`    | `/api/produtos/{id}` | Atualiza um produto existente pelo seu ID.       |
| `DELETE` | `/api/produtos/{id}` | Deleta um produto pelo seu ID.                   |

#### Exemplo de Body para `POST /api/produtos`

```json
{
  "nome": "Notebook Gamer Pro",
  "descricao": "Notebook com placa de vídeo dedicada e 16GB de RAM.",
  "preco": 6500.50,
  "marcaId": "f47ac10b-58cc-4372-a567-0e02b2c3d479"
}

```
### Marcas (`/api/marcas`)

| Método | Endpoint              | Descrição                              |
|--------|-----------------------|----------------------------------------|
| `POST`   | `/api/marcas`           | Cria uma nova marca.                   |
| `GET`    | `/api/marcas`           | Lista todas as marcas com suporte a paginação. |
| `PUT`    | `/api/marcas/{id}`      | Atualiza uma marca existente pelo seu ID. |
| `DELETE` | `/api/marcas/{id}`      | Deleta uma marca pelo seu ID.          |

#### Exemplo de Body para POST `/api/marcas`

```json
{
  "nome": "Marca Famosa",
  "descricao": "Líder de mercado em eletrônicos."
}
```

### 🚀 Como Executar o Projeto

#### ✅ Pré-requisitos
- Java JDK 21 ou superior instalado.

#### 🔧 Opção 1: Executando pelo Terminal (fora de uma IDE)
O projeto foi criado com o Spring Initializr e inclui o Maven Wrapper, que facilita a execução sem precisar ter o Maven instalado globalmente.

1. Clone o repositório:
   ```bash
   git clone https://github.com/cristianpenteado/produtos-api.git
   cd produtos-api/
   ```

2. Execute o comando:
    - No Linux ou macOS:
      ```bash
      ./mvnw spring-boot:run
      ```
    - No Windows (Prompt de Comando ou PowerShell):
      ```bash
      mvnw.cmd spring-boot:run
      ```

#### 💻 Opção 2: Executando pelo IntelliJ IDEA

1. Abra o projeto:
    - Vá em `File > Open...`
    - Navegue até a pasta onde você clonou o projeto.
    - Selecione o arquivo `pom.xml`.
    - Escolha "Open as Project".
    - O IntelliJ irá carregar e indexar o projeto, baixando as dependências do Maven automaticamente.

2. Execute a aplicação:
    - Encontre a classe principal da aplicação (geralmente chamada `CrudProdutosApplication.java`), que contém a anotação `@SpringBootApplication`.
    - Clique com o botão direito sobre a classe e selecione `Run 'CrudProdutosApplication'`.
    - Ou clique na seta verde de "play" ao lado da declaração da classe ou do método `main`.