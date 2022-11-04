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

