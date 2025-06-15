# Sistema de Estacionamento com Interface Gráfica (Java + Swing)

Este projeto é uma aplicação simples desenvolvida em **Java**, utilizando **Swing** para a interface gráfica. Ele simula o controle de entrada e saída de veículos em um estacionamento, calculando o tempo de permanência e o valor a ser pago.


## Funcionalidades

- Registrar entrada de veículos (placa, modelo e proprietário)
- Registrar saída de veículos e calcular o tempo de permanência
- Calcular o valor a pagar com base no tempo (R$ 10/hora, mínimo R$ 15)
- Listar todos os veículos registrados
- Calcular a média de tempo dos veículos que já saíram

---

## Interface

A interface gráfica foi construída com Swing e contém:

- Campos para placa, modelo e proprietário
- Botões de:
    - Registrar Entrada
    - Registrar Saída
    - Listar Carros
    - Calcular Média de Tempo
    - CAlculo do valor a pagar
- Área de texto para exibir os resultados

---

Lógica de Cálculo

- Tempo de permanência é contado em minutos
- O tempo é arredondado para cima a cada hora
- Valor da hora: **R$ 10,00**

---

## Tecnologias Usadas

- Java 
- Java Swing 
- IDE: IntelliJ IDEA

---

## Como executar

1. Clone ou baixe o projeto.
2. Abra no IntelliJ IDEA.
3. Execute a classe `Main.java`.

---

## Autor

- Nome: Giovane Rodrigues
- Curso: Analise e Desenvolvimento de Sistemas
- Data: 15/06/25

---



