# 📬 Exemplos de Requisições e Respostas

Este documento contém exemplos completos de uso da API **X-Profit**, cobrindo todos os endpoints de **Clientes** e **Investimentos**.

---

## 👤 Clientes

### 🔹 Criar Cliente
**POST** `/clientes`

📥 Request
```json
{
  "nome": "João Silva",
  "email": "joao.silva@example.com",
  "cpf": "12345678901",
  "saldo": 5000.0
}
```

📤 Response
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@example.com",
  "cpf": "12345678901",
  "saldo": 5000.0
}
```

---

### 🔹 Listar Clientes
**GET** `/clientes`

📤 Response
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao.silva@example.com",
    "cpf": "12345678901",
    "saldo": 5000.0
  }
]
```

---

### 🔹 Atualizar Cliente
**PUT** `/clientes/1`

📥 Request
```json
{
  "nome": "João Silva Atualizado",
  "email": "joao.novo@example.com",
  "cpf": "12345678901",
  "saldo": 7000.0
}
```

📤 Response
```json
{
  "id": 1,
  "nome": "João Silva Atualizado",
  "email": "joao.novo@example.com",
  "cpf": "12345678901",
  "saldo": 7000.0
}
```

---

### 🔹 Deletar Cliente
**DELETE** `/clientes/1`

📤 Response
```
204 No Content
```

---

## 💰 Investimentos

### 🔹 Criar Investimento
**POST** `/investimentos`

📥 Request
```json
{
  "valor": 2000.0,
  "tipo": "RENDA_FIXA",
  "clienteId": 1
}
```

📤 Response
```json
{
  "id": 1,
  "valor": 2000.0,
  "tipo": "RENDA_FIXA",
  "clienteId": 1
}
```

---

### 🔹 Listar Investimentos
**GET** `/investimentos`

📤 Response
```json
[
  {
    "id": 1,
    "valor": 2000.0,
    "tipo": "RENDA_FIXA",
    "clienteId": 1
  }
]
```

---

### 🔹 Buscar Investimento por ID
**GET** `/investimentos/1`

📤 Response
```json
{
  "id": 1,
  "valor": 2000.0,
  "tipo": "RENDA_FIXA",
  "clienteId": 1
}
```

---

### 🔹 Atualizar Investimento
**PUT** `/investimentos/1`

📥 Request
```json
{
  "valor": 3000.0,
  "tipo": "RENDA_FIXA",
  "clienteId": 1
}
```

📤 Response
```json
{
  "id": 1,
  "valor": 3000.0,
  "tipo": "RENDA_FIXA",
  "clienteId": 1
}
```

---

### 🔹 Deletar Investimento
**DELETE** `/investimentos/1`

📤 Response
```
204 No Content
```
