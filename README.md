# 💹 X-Profit

Sistema de gerenciamento de **Usuários**, **Clientes** e **Investimentos**, desenvolvido em **Spring Boot**.  
O projeto expõe serviços REST que permitem cadastrar, autenticar, atualizar, consultar e excluir tanto clientes quanto seus investimentos, com autenticação JWT e documentação automática via Swagger.

---

## 👥 Integrantes do Grupo

- Allan Von Ivanov — RM 98705
- João Rodrigo — RM 551319
- Bianca Carvalho Dancs Firsoff — RM 551645
- Giuliano Romaneto Marques — RM 99694
- Arthur Candido de Abreu — RM 98283

---

## 📌 Descrição do Projeto

O objetivo do sistema é oferecer um **CRUD completo** para três entidades principais:

- **Usuário** → autenticação e autorização via **JWT**, com senhas criptografadas em **BCrypt**.
- **Cliente** → nome, e-mail, CPF, saldo.
- **Investimento** → tipo, valor e vínculo com um cliente.

Cada cliente pode possuir vários investimentos, garantindo um relacionamento **1:N**.

A **Sprint 2** teve como foco:
- Implementar autenticação segura (**JWT**) e criptografia de senha (**BCryptPasswordEncoder**).
- Aplicar arquitetura em camadas (controller, service, repository) e princípios **SOLID**.
- Configurar **Swagger/OpenAPI** para documentação automática.
- Criar **testes automatizados** para serviços e endpoints.

---

## ⚙️ Passos de Configuração e Execução

### 🔹 Pré-requisitos
- **Java 17+**
- **Maven 3.8+**
- **Banco H2** (embutido, configurado em `application.properties`)

### 🔹 Como executar

```bash
# Clonar o repositório
https://github.com/joaors10/Sprint-4_SOA

# Entrar no diretório
cd x-profit

# Compilar o projeto
mvn clean install

# Executar a aplicação
mvn spring-boot:run

📬 Endpoints Principais
🧍 Usuários

POST /usuarios/registrar → Cria um novo usuário com senha criptografada.

POST /usuarios/login → Autentica o usuário e retorna o token JWT.

👥 Clientes

POST /clientes → Criar cliente

GET /clientes → Listar clientes

GET /clientes/{id} → Buscar cliente por ID

PUT /clientes/{id} → Atualizar cliente

DELETE /clientes/{id} → Remover cliente

💰 Investimentos

POST /investimentos → Criar investimento

GET /investimentos → Listar investimentos

GET /investimentos/{id} → Buscar investimento por ID

PUT /investimentos/{id} → Atualizar investimento

DELETE /investimentos/{id} → Remover investimento

🔐 Autenticação

A autenticação utiliza JWT (JSON Web Token).
Após o login, o token deve ser enviado no header Authorization em endpoints protegidos.

Exemplo de uso no Swagger

Acesse: http://localhost:8080/swagger-ui/index.html

Clique em Authorize.

Insira o token no formato:

Bearer SEU_TOKEN_AQUI


Clique em Authorize e depois em Close.

📊 Documentação Automática

O projeto utiliza SpringDoc OpenAPI para gerar a documentação interativa.
Acesse pelos links abaixo:

Swagger UI → http://localhost:8080/swagger-ui/index.html

API Docs (JSON) → http://localhost:8080/v3/api-docs

