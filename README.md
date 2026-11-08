# 🏦 Banco Java

Sistema bancário simples no console, feito em Java, com foco em **tratamento de exceções**.

## Funcionalidades

- Abrir conta
- Depositar
- Sacar
- Transferir entre contas
- Ver extrato
- Listar contas

## Conceitos praticados

- Exceções personalizadas (`BancoException` e suas filhas)
- `throw` e `throws`
- `try`, `catch` e `finally`
- Orientação a objetos (classes, encapsulamento, herança)
- `ArrayList`
- Organização do código em pacotes

## Estrutura do projeto

```
src/
├── app/        → Main (menu e interação com o usuário)
├── modelo/     → Conta
├── servico/    → Banco
└── excecoes/   → exceções personalizadas
```

## Como executar

Requer Java 17 ou superior.

```bash
javac -d out src/app/Main.java src/modelo/*.java src/servico/*.java src/excecoes/*.java
java -cp out app.Main
```


## O que aprendi

Neste projeto aprendi a criar exceções personalizadas e a usar throw, throws
e try/catch/finally para tratar erros sem o programa quebrar. Também aprendi a
separar as responsabilidades: a Conta cuida das regras, o Banco gerencia as
contas e o Main só conversa com o usuário. Um erro que me ensinou muito foi o Scanner deixar
o Enter no buffer ao usar nextInt(). 

## Autor

[Michael Douglas Teixeira Barbosa](michaeldouglas0911@gmail.com)