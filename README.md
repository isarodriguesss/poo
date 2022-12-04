# ProjetoSoftware

## Disciplina Programação 2 / Projeto de Software em Java

Sistema funcional (primeira versão).

Aplicado conceitos de O.O (segunda versão).

Aplicado conceitos de exceptions (terceira versão).

Analisado os code smells (apenas análise).

## Design patterns e soluções de smells

Smells simples resolvidos:

Speculative Generality -> construtores feitos em várias classes, inclusive na nossa classe principal Account, e os mesmos nunca foram utilizados. Todos foram removidos.

Duplicated Code -> classes abstratas com métodos que sofrem override e corrige a duplicidade de código.

Long Method -> corrigido com uso de exceptions.

Large Class -> classe Utils com grande quantidade de métodos, isso foi subdividido e resolvido.

Data Class -> quantidade numerosa de métodos na classe App; | Corrigido com as classes utils.

## Refactoring

Padrão Bridge:

Resolvendo nosso problema da large class de operações com mais de 700 linhas, resolvemos utilizar subclasses que se relacionariam mais com as funções de cada tipo, conta, comunidade e feed, e não deixando essas funções numa única classe gerenciando todas as operações do projeto.

O padrão de projeto Bridge divide a lógica de negócio ou uma enorme classe (nosso caso) em hierarquias de classe separadas que podem ser desenvolvidas independentemente. Uma dessas (as subclasses com as operações) obterá uma referência a um objeto da segunda hierarquia, agora nossas funções estão dentro das novas classes:

Professor,
Profissional,
Researcher,
Student;
Facilitando manutenção, legibilidade e resolvendo o nosso code smell. O foco foi separar nossa large class em classes menores que se relacionam mais entre si. Foi criado também uma nova classe GeneralOps, que será nossa "Ponte (Bridge)", com funções gerais de busca e checagens que serviram pra todas as nossas classes filhas de operações que herdam as operações gerais.

