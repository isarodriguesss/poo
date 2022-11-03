# ProjetoSoftware

## Disciplina Programação 2 / Projeto de Software em Java

Sistema funcional (primeira versão).

Aplicado conceitos de O.O (segunda versão).

Aplicado conceitos de exceptions (terceira versão).

Analisado os code smells (apenas análise).

# Design patterns e soluções de smells

Smells simples resolvidos:

Generative especulation -> construtores feitos em várias classes, inclusive na nossa classe principal Account, e os mesmos nunca foram utilizados. Todos foram removidos.

Inverted booleans -> métodos que sempre tinham que vir com um operador de '!' nas nossas condicionais, esses métodos tiveram seus retornos refeitos, principalmente a função checkRegex que possuia mais de 4 condicionais para retorno, o que deixava o código contra-intuitivo, agora temos algo legível e de simples entendimento.

Middleman -> métodos que aumentam a complexidade do código e eram usados apenas 1 vez ou 2, além desses métodos tinhamos alguns métodos com apenas uma linha, como no caso do método containsSpaces, que poderia ser simplesmente re-escrito quando fosse ser usado no lugar de ser um método. Solucionamos removendo o método containsSpaces e removendo métodos como o seeMsg que era utilizado apenas uma vez em todo o programa, também foi re-escrito para simplicar e ajudar na legibilidade.

Move Method -> métodos de busca que se relacionam de forma fraca com suas classes foram movidos para nossa nova classe GeneralOps (que inclui as nossas operações generalizadas para que as diversas classes (Account, Community, Feed) possam utilizá-las).

