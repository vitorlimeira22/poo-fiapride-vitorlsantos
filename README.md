# Projeto FiapRide - Vitor Limeira dos Santos

## Informações do Aluno

- **Nome:** Vitor Limeira dos Santos
- **RM:** 565280
- **Turma:** 2CCPX
- **Curso:** Ciência da Computação
- **GitHub:** [@vitorlimeira22](https://github.com/vitorlimeira22)

---

## Descrição do Projeto

Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos o sistema **FiapRide** (aplicativo de mobilidade urbana). Ao longo das aulas, evoluímos o sistema incrementalmente, aplicando cada novo conceito de POO diretamente no código.

---

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main?

**Resposta:**
Criar variáveis soltas no main funciona para um ou dois usuários, mas se o FiapRide tiver 1 milhão de usuários, precisaríamos de 1 milhão de variáveis separadas para cada atributo — nomeAna, nomeBruno, nomeCarlos... isso seria impossível de gerenciar. A classe funciona como um molde: ela define a estrutura uma única vez e nos permite criar quantos objetos precisarmos a partir dela, cada um com seu próprio estado (nome, saldo, cpf). Além disso, a classe mantém os dados relacionados juntos, tornando o código organizado e legível. Sem classes, o sistema seria um amontoado de variáveis sem nenhuma coesão. A abstração também nos ajuda a modelar apenas o que o negócio realmente precisa — no FiapRide, o passageiro tem nome e saldo, não cor dos olhos.

---

### Aula 2 - Métodos

**Pergunta:** Se podemos fazer `passageiro.saldo = passageiro.saldo + 100` diretamente, por que criar o método `adicionarSaldo(valor)`?

**Resposta:**
Alterar o saldo diretamente no código principal significa que qualquer programador pode colocar qualquer valor, inclusive negativos ou zero, sem nenhuma validação. Em uma startup de mobilidade, isso seria catastrófico: um bug poderia permitir que usuários carregassem saldo gratuitamente ou que o sistema aceitasse pagamentos inválidos. O método `adicionarSaldo(valor)` centraliza a regra de negócio em um único lugar: se o valor for inválido, o método rejeita antes de alterar qualquer dado. Se a regra mudar, alteramos só o método, não precisamos caçar todos os pontos do código onde o saldo é modificado. Métodos são os guardiões do estado do objeto.

---

### Aula 3 - Encapsulamento

**Pergunta:** Por que é seguro deixar o `get` público, mas perigoso deixar o atributo original público?

**Resposta:**
O `getSaldo()` retorna uma cópia do valor do atributo — quem recebe esse valor pode lê-lo, mas não consegue alterar o original dentro do objeto. É como dar a alguém uma fotocópia de um documento: ela pode ler, mas qualquer rasura que fizer não afeta o original. Já deixar o atributo `saldo` como público é como entregar o documento original: qualquer um pode escrever por cima, sem passar por nenhuma validação. No contexto do FiapRide, isso significa que qualquer parte do código poderia setar `passageiro.saldo = -999` diretamente, corrompendo o estado do objeto. O encapsulamento garante que o objeto sempre controla seu próprio estado.

---

### Aula 4 - Construtores

**Pergunta:** Por que é um erro grave gerar getters e setters para tudo automaticamente? Como as decisões de não criar `setModelo()` e tornar `setPlaca()` privado protegem o sistema?

**Resposta:**
Gerar getters e setters para tudo automaticamente ignora completamente as regras de negócio do sistema. No mundo real, o modelo de um carro não muda depois que ele foi fabricado — não faz sentido ter um `setModelo()`. Criar esse método abriria a possibilidade de alguém alterar o modelo de um veículo já cadastrado, corrompendo os dados. Já a placa pode mudar, mas trocar uma placa é um processo burocrático no Detran, não uma simples atualização de campo. Por isso o `setPlaca()` é privado e existe um método público `atualizarPlaca()`, que pode conter validações e registros do processo real. A IDE gera código, mas não conhece as regras do negócio — essa responsabilidade é do desenvolvedor.

---

### Aula 5 - Associação

**Pergunta:** Por que passar o objeto `Passageiro` inteiro no construtor da `Viagem` em vez de apenas a `String` do nome?

**Resposta:**
Se a `Viagem` armazenasse apenas a String "Ana Silva", ela teria somente um texto — não uma referência real ao objeto `Passageiro`. Quando a viagem termina e o sistema precisa descontar o valor do saldo, seria impossível: a String não tem método `pagarViagem()`, não tem saldo, não tem CPF. Ao passar o objeto inteiro, a `Viagem` mantém uma referência viva ao `Passageiro` real, podendo interagir com ele durante todo o ciclo da corrida. Além disso, como é uma referência e não uma cópia, qualquer atualização feita no objeto `Passageiro` depois que a viagem foi criada é automaticamente visível dentro dela — os dois apontam para o mesmo espaço na memória.

---

### Aula 6 - Herança

**Pergunta:** Por que o Java não deixa a classe filha alterar diretamente as variáveis `private` da classe mãe?

**Resposta:**
O modificador `private` garante que apenas a própria classe pode acessar e modificar seus atributos — nem as filhas escapam dessa regra. Isso é o princípio do encapsulamento aplicado dentro da herança. Se `Carro` pudesse fazer `this.placa = "ABC"` diretamente, o setter privado com suas validações seria completamente ignorado, anulando toda a proteção construída na classe `Veiculo`. A classe filha é obrigada a usar `super()` no construtor ou os métodos públicos/protegidos da mãe, garantindo que as regras de negócio definidas na superclasse sejam sempre respeitadas, independente de quem está herdando.

---

### Aula 7 - Polimorfismo

**Pergunta:** Se esquecer de criar `calcularAutonomia()` na classe mãe `Veiculo`, conseguiríamos chamá-lo no loop mesmo ele existindo em `Carro` e `Moto`?

**Resposta:**
Não. No loop `for (Veiculo veiculo : frota)`, a variável `veiculo` é do tipo `Veiculo` para o compilador Java. Em tempo de compilação, Java verifica se o método existe no tipo declarado da variável — não no tipo real do objeto. Se `calcularAutonomia()` não existir em `Veiculo`, o compilador recusa o código, mesmo sabendo que `Carro` e `Moto` o implementam. A classe mãe precisa definir o contrato (a assinatura do método) para que o polimorfismo funcione: em tempo de execução, Java então chama a versão correta de cada subclasse. Sem o contrato na base da hierarquia, não há polimorfismo — há apenas erro de compilação.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Por que precisamos explicitamente declarar `Veiculo` como `abstract`? Por que o Java não deduz isso sozinho?

**Resposta:**
Java não faz suposições sobre a intenção do desenvolvedor — ele exige que tudo seja explícito. Sem o `abstract`, `Veiculo` é uma classe normal e qualquer parte do código pode fazer `new Veiculo()`, criando um objeto genérico sem modelo, sem placa, sem tipo definido. Isso quebraria a lógica do sistema: uma frota com um "veículo" sem tipo específico não faz sentido, assim como uma concessionária que vende "um veículo" sem ser carro, moto ou caminhão. O `abstract` é um contrato que diz ao compilador: "ninguém pode instanciar esta classe diretamente". Esquecer o `abstract` é abrir uma brecha silenciosa que pode gerar objetos inválidos sem lançar nenhum erro óbvio.

---

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite herança simples mas múltipla implementação de interfaces?

**Resposta:**
A herança múltipla de classes causa o "Problema do Diamante": se `CarroEletrico` herdasse de `Veiculo` e de `Bateria` ao mesmo tempo, e ambas tivessem um método `ligar()`, o Java não saberia qual versão chamar — seria ambíguo e geraria conflito. Interfaces resolvem isso porque definem apenas o contrato (a assinatura do método), sem implementação. Cada classe que implementa a interface é obrigada a escrever sua própria versão do método, então não existe conflito: `CarroEletrico` implementa `ligar()` do jeito que faz sentido para ele. Assim, uma classe pode assinar múltiplos contratos (interfaces) sem ambiguidade, ganhando flexibilidade sem os riscos da herança múltipla.

---

## Desafios Técnicos Implementados

### Desafio Pessoal — Sistema de Gavetas

**Qual foi o domínio que você escolheu para seu projeto pessoal?**
Sistema de organização doméstica baseado em gavetas. O conceito de gaveta foi escolhido por ser um objeto do cotidiano que naturalmente tem especializações por ambiente.

**Quais classes você criou?**
- `Gaveta` — superclasse com os atributos e comportamentos comuns a qualquer gaveta
- `GavetaEscritorio` — especialização com características de uma gaveta de escritório
- `GavetaCozinha` — especialização com características de uma gaveta de cozinha
- `Caixa` — classe sem correlação com a hierarquia de Gaveta, usada para demonstrar associação com um objeto independente

**Qual foi o maior desafio técnico que você enfrentou?**
O maior desafio foi organizar e entender a herança entre as classes. No início, não ficava claro o que pertencia exclusivamente à superclasse `Gaveta` e o que deveria ser específico de cada subclasse. Era tentador repetir atributos e métodos nas filhas que já existiam na mãe, ou ao contrário, colocar na mãe coisas que só faziam sentido em um contexto específico. Com o tempo, ficou claro que a superclasse deve conter apenas o que é comum a todas as gavetas — independente de onde estejam — e cada subclasse adiciona somente o que a diferencia. Outro ponto de dificuldade foi o acesso aos atributos privados da mãe dentro das filhas, que exigiu o uso de `super()` e dos métodos herdados em vez de acesso direto.

---

## Conclusão

**O que você aprendeu nestas 9 aulas?**
Aprendi que Programação Orientada a Objetos é uma forma de pensar antes de ser uma forma de escrever código. Cada conceito — encapsulamento, herança, polimorfismo, interfaces — existe para resolver um problema real de organização, segurança e manutenção de sistemas. Comecei achando que era sobre sintaxe e terminei entendendo que é sobre modelar o mundo de forma que o código reflita as regras do negócio.

**Qual conceito foi mais difícil de entender?**
Herança foi o conceito mais desafiador, especialmente entender o que pertence à superclasse e o que pertence às subclasses, e por que os atributos privados da mãe não podem ser acessados diretamente pela filha. Superei a dificuldade praticando com o projeto pessoal e associando sempre ao mundo real.

**O que você melhoraria no seu projeto se pudesse refazer?**
Escolheria um domínio diferente para o projeto pessoal — um objeto com mais comportamentos naturais tornaria a aplicação dos conceitos de polimorfismo e interfaces mais rica e interessante de implementar.

---

*"A melhor forma de aprender programação é PROGRAMANDO."*
