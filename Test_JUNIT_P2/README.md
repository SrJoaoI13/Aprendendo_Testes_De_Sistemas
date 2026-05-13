# Calculadora Web - Projeto Multi-Módulo

Este projeto consiste em uma aplicação de Calculadora Web desenvolvida com **Spring Boot** no BackEnd e **React (Vite)** no FrontEnd. A aplicação permite realizar operações matemáticas básicas, armazena o histórico em um banco de dados H2 e exibe o status de cada operação (Passou/Falha).

## 🚀 Tecnologias Utilizadas

- **BackEnd:** Java 17+, Spring Boot, Spring Data JPA, H2 Database (Banco em memória).
- **FrontEnd:** React, Vite, Axios, CSS3.

---

## 🛠️ Como Rodar o Projeto

O projeto está dividido em duas pastas principais: `BackEnd` e `FrontEnd`. Você precisará de dois terminais abertos para rodar ambos simultaneamente.

### 1. Rodando o BackEnd (Spring Boot)

Navegue até a pasta do BackEnd e utilize o Maven Wrapper incluído no projeto:

```bash
cd BackEnd
./mvnw spring-boot:run
```

- **API:** O servidor iniciará em `http://localhost:8080`
- **Console H2:** Pode ser acessado em `http://localhost:8080/h2-console`
  - **JDBC URL:** `jdbc:h2:mem:calculadoradb`
  - **User:** `sa`
  - **Password:** (em branco)

### 2. Rodando o FrontEnd (React)

Em um novo terminal, navegue até a pasta do FrontEnd, instale as dependências e inicie o servidor de desenvolvimento:

```bash
cd FrontEnd
npm install
npm run dev
```

- **Interface:** O React estará disponível em `http://localhost:3000`

---

## 🧪 Casos de Teste (Caixa Preta)

A aplicação foi validada conforme os requisitos funcionais:

| ID | Requisito | Entrada | Resultado Esperado | Status na Tabela |
| :--- | :--- | :--- | :--- | :--- |
| **CT01** | Soma | 5 + 5 | 10 | Passou |
| **CT02** | Subtração | 10 - 2 | 8 | Passou |
| **CT03** | Multiplicação | 2 * 5 | 10 | Passou |
| **CT04** | Divisão | 20 / 4 | 5 | Passou |
| **CT05** | Divisão por Zero | 10 / 0 | Mensagem de Erro | Falha (Tratada) |
| **CT06** | Entrada Inválida | abc + 5 | Erro de validação | Falha (Tratada) |
| **CT07** | Negativos | -5 + 2 | -3 | Passou |
| **CT08** | Decimais | 2.5 * 2 | 5.0 | Passou |

---

## 📂 Estrutura de Pastas

```text
/
├── BackEnd/           # Projeto Spring Boot
│   ├── src/           # Código fonte Java
│   └── pom.xml        # Dependências Maven
└── FrontEnd/          # Projeto React + Vite
    ├── src/           # Componentes e lógica React
    └── vite.config.js # Configuração de Proxy para API
```
