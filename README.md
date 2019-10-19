# **Desafio do Estacionamento de Carros**

# Motivação
Avaliar o desempenho de desenvolvedores ao desenvolver uma API RESTful documentada e testada e/ou um front-end para acesso à API.

# Introdução 
Você foi procurado para implementar uma API que gerencie um estacionamento privado de veículos.

O cliente não se importa com a tecnologia utilizada, desde que seja produtiva, eficiente, multi-plataforma e de fácil manutenção.

# Descrição do sistema
Criar uma API para gerenciamento de carros em um estacionamento, que deve ter pelo menos 15 vagas.
Através dos métodos da API será possível ver quantas vagas estão disponíveis, estacionar um carro, realizar o pagamento do ticket e emitir um relatório de recebimentos.
|Permanência|Valor (R$)|
|-----------|---------:|
|Até 3 horas|7,00      |
|Hora extra |3,00      |

Métodos a serem criados:
- Consultar quantidade de vagas disponíveis
- Listar posição das vagas disponíveis
- Estacionar um carro numa vaga
- Pagar ticket
- Relatório com ocupação atual do estacionamento
- Relatório com valor arrecadado por período

**Caso algum aspecto do problema não tenha sido detalhado, solucione da forma que achar melhor, e justifique sua decisão.**

# Tecnologias
- Back-end numa linguagem orientada a objetos de sua escolha rodando em Windows ou Linux, em máquina física, virtual ou container.
- Banco de dados à sua escolha (relacional ou não)
- Testes unitários
- Documentação dos métodos com Swagger/OpenAPI
- CI/CD
- Monitoramento da API
- Front-end em um framework à sua escolha

# Detalhe da Solução
Repositório do projeto: https://github.com/andrelsouto/rentacar-challeng-genreal
Rodando no heroku link: https://rentacar-challenge-general.herokuapp.com/#/cadastro/setor
Projeto maven multi-modular, um módulo encontra-se o front-end feito em Angular 8 e o outro módulo a api feita em Java com Spring.

O link da documentação encontra-se no menu da aplicação.

API - Feita em Java com Spring, projeto usa os Profiles do Spring para não precisar mudar configuração quando rodar local ou subir no servidor.
Front-end - feito em Angular 8, projeto usa os envrionments para configurar urls e não precisar mudar ao subir no servidor.

Rodar a API local basta, resolver as dependencias através do maven, e rodar a Classe principal do projeto.

    -Requisitos:
      Java 8
      Maven
    Este projeto usa banco de dados PostgreSQL 9.x, está apontando para um banco do heroku, caso queira apontar localmente, basta mudar o arquivo
    db.properties localizado na pasta resources, as credenciais do banco precisam ter permissao para criar as tabelas no caso de querer apontar para
    um banco local. 

Rodar o Front - instalar as dependencias através do comando 'npm install' e executar o comando 'ng serve' na raiz do projeto rentacar-view

    -Requisitos
        Node 10
        Angular/cli
