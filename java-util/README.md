## Aula 1 - Conhecendo Arrays

- Minhas notas
    - A forma de declarar um array é **`int[] lista = new int[5]`** ou **`int lista[] = new int[5]`**
    - Do lado direito da expressão de declaração de um novo array precisa receber entre chaves o numero de elementos que aquele array terá.
    - O array inicializado é preenchido por elemento com um valor padrão que varia de acordo com o tipo de referencia (no exemplo aqui, int)
    - Do lado esquerdo da declaração, ou o tipo de referencia ou o nome da variavel deve ser seguido de colchetes.
    - Ao criar um array você está criando uma lista que pode guardar um numero x de instancias de um tipo de objeto
    - O valor padrão de uma referencia a um objeto é null
    - Ao colocar um objeto numa lista, você não está efetivamente colocando o objeto lá, mas sim a referencia para aquele objeto (mesmo principio para atribuição de objetos a variaveis)
- Notas da Alura
    - Um array é uma estrutura de dados e serve para guardar elementos (valores primitivos ou referências)
    - Arrays usam colchetes (`[]`) sintaticamente
    - Arrays têm um tamanho fixo!
    - Um array também é um objeto!
    - Arrays são *zero-based* (o primeiro elemento se encontra na posição `0`)
    - Um array é sempre inicializado com os valores padrões.
    - Ao acessar uma posição inválida recebemos a exceção `ArrayIndexOutOfBoundException`
    - Arrays possuem um atributo `length` para saber o tamanho
    - A forma literal de criar uma Array, com o uso de chaves {}.

## Aula 2 - Guardando qualquer referência

- Minhas notas
    - Caso se crie um array de um tipo genérico e populemos ele com um tipo específico, podemos ter situações em que o compilador do Eclipse aponta um erro. ex:
    
    1.`Conta[] contas = new Conta[5];`
    2.`contas[1] = new ContaCorrente(123, 321);`
    3.`ContaCorrente cc = contas[1];` // compilador apresenta um erro
    
    Na terceira linha, o compilador vai esperar que a referencia seja do tipo Conta e não ContaCorrente, já que o array tem definido o tipo Conta.
    Para corrigir isso, precisamos escrever um `**type cast**` que informa ao compilador que sabemos que os tipos são diferentes, mas que eles são compativeis, fazemos isso com a seguinte sintaxe:
    
    `**ContaCorrente cc = (ContaCorrente) contas[1];`**
    
    Dessa forma o compilador sabe que queremos que a variavel faça referencia a um tipo mais específico. Garantimos que sabemos que esse elemento do array contas é do tipo ContaCorrente e não de um tipo ContaPoupanca por exemplo (o que é o que o compilador tenta previnir)
    - Quando queremos fazer uma referencia de tipo mais generico recebendo uma mais especifica, o cast acontece forma implicita. Quando a referencia é mais especifica e recebe uma mais generia, o cast é necessário, ex:
    
    **Referencia mais generica recebe endereço de referencia específica:
    `ContaCorrente cc1 = new ContaCorrente(123, 321);
    Conta conta = cc1;`
    
    Referencia mais especifica recebe endereço de referencia mais generica:
    `Conta conta = new Conta(123, 321);
    ContaCorrente cc1 = (ContaCorrente) conta;`**
    
    O que estamos fazendo é converter o tipo atribuido para o tipo da referencia.
    - O **cast** pode ser impossível, no caso de tentarmos aplica-lo a um objeto de uma classe não relacionada a classe da referencia.
    - Um cast pode ter 4 classificações:
    1. **possível**
    2. **impossível**
    3. **explícito**
    4. **implícito**
    - Esse tema é muito perguntado na certificação Java - **ESTUDAR COM ATENÇÃO**
    - O parametro `**String[] args**` passado por padrão para o método main define que ele receberá uma lista de argumentos. Quando executamos pela linha de comando a classe que possui esse medodo, podemos passar na mesma linha varios argumentos do tipo String separados por espaço.
    - Pelo Eclipse podemos definir quais serão esses argumentos indo no nas opções do botão que roda o código, selecionando configurações, selecionando a classe e na aba “arguments” passando esses argumentos. Agora quando rodarmos o código da classe, ela irá rodar passando os argumentos.
- Notas da Alura
    - uma array do tipo `Object` pode guardar qualquer tipo de referência
    - quando convertemos uma referência genérica para uma referência mais específica é preciso usar um *type cast*
    - o cast só compila quando é possível, mesmo assim pode falhar na hora de rodar
    - quando o *type cast* falha podemos receber uma `ClassCastException`
    - para receber valores ao chamar o programa Java na linha de comando podemos usar o array `String[]` no método main

## Aula 3 - ArrayList e Generics

- Minhas notas
    - Listas não guardam objetos, guardam referencias de objetos.
    - ArrayList é uma implementação que utiliza o objeto Array pra armazenar dados de forma sintaticamente mais elegante
    - Podemos restringir o tipo de referencias armazenadas num ArrayList passando <Tipo> quando formos declarar a lista. ex: `**ArrayList<int> lista = new ArrayList<int>();**`
- Notas da Alura
    - que a classe `java.util.ArrayList` encapsula o uso do array e oferece vários métodos de mais alto nível
    - que uma lista guarda referencias
    - como usar métodos `size`, `get`, `remove`
    - como usar o `foreach` para iterar a `ArrayList`
    - que os generics parametrizam classes
    - que no caso da `ArrayList` podemos definir o tipo dos elementos através de generics

## Aula 4 - Equals e mais listas [tempo: 48min]

- Minhas notas
    - A classe Object define o método **`equals()`** ele faz uma comparação entre o objeto sobre o qual foi chamado e um outro objeto. A definição padrão do método compara as referencias de cada um dos objetos, da mesma forma que o operador ==.
    - Podemos redefinir o comportamento do método dentro de uma classe fazendo um **`@Override`** e definindo o método com a assinatura: 
    
    **`public boolean equals(Object ref)` `{ // código };`** 
    
    No bloco de código iremos especificar a comparação que devemos fazer entre esses objetos, assim ao invés de verificar se as referencias são iguais, verificaremos o conteudo dos objetos para os quais as referencias apontam.
    - **LinkedList** é uma implementação mais eficiente da estrutura de listas, ela não usa o Array para armazenar as informações, porque no array o custo de processamento para remover um elemento no meio da lista é O(n), ela resolve esse problema fazendo com que cada novo elemento indique o próximo e o anterior, assim se você remove um elemento, só precisa mudar a indicação nos dois elementos adjacentes ao item removido ao invés de reposicionar todos os elementos dali em diante.
    - A sintaxe é a mesma de um ArrayList, ou seja:
    
    **`LinkedList<tipo_da_referencia> lista = new LinkedList<tipo_da_referencia>()`**
    - A **`LinkedList`** também possui os métodos `.size()`, `.add()` e `.remove()`, isso acontece porque tanto a **LinkedList** quanto a **ArrayList** usam a **interface** **`List`**
    - A desvantagem da LinkedList acontece no acesso pelo indice, já que ela precisa pesquisar pelos elementos, o que não ocorre no ArrayList
    - Na duvida, usar ArrayList
    - Podemos converter o Array de argumentos (**args**) do método padrão **main** para um formato de Lista. Para isso usamos uma função estatica da classe Arrays:
    
    **`List<String> argumentos = Arrays.asList(args);`**
    
- Notas da Alura
    - como implementar o método `equals` para definir a igualdade
    - que o método `equals` é utilizado pelas listas
    - que existe mais uma lista, a `java.util.LinkedList`
    - a diferença entre `ArrayList` e `LinkedList`
    - a interface `java.util.List` que define os métodos da lista

## Aula 5 - Vector e a interface Collection [tempo: 21min]

- Minhas notas
    - **`Vector`** é uma outra implementação da interface **List**, ela foi a primeira implementação desse tipo no Java e é muito parecida com a **`ArrayList`** (**tem os mesmo métodos e armazena os dados num Array**), a principal diferença é que **ela pode executar mais de uma pilha em paralelo**
    - Todas as classes de estruturas de dados estudas aqui tem a interface basica **Collection**, dessa interface seguem dois galhos, o de **List** e o de **Set**. As classes filhas da classe List tem a caracteristica de permitir duplicação, além de ter os elementos ordenados.
    - A classes herdeiras de **Set** replicam o funcionamento dos conjuntos da matematica.
    - A implementação de Collection não tem os métodos comuns às listas, como o size, remove e get. Esses métodos são implementações de List.
    - **`Collections > [List, Set]`**;
    **`List > [ArrayList, LinkedList, Vector]`**;
    **`Set > [HashSet]`;**
    - Os metodos exclusivos da interface List são aqueles que usam posição. A classe Collections não possui esse atributo.
    - **O pacote java.util é a API de Collections**
- Notas da Alura
    - o `java.util.Vector`, que é uma *ArrayList* thread safe
    - a interface `java.util.Collection` que é a interface de todas as coleções
    - as listas são sequencias que aceitam elementos duplicados
    - os conjuntos (`java.util.Set`) também são coleções, mas não aceitam duplicados nem são listas

## Aula 6 - As classes Wrappers [tempo: 45min]

- Minhas notas
    - Tipos primitivos não são Object. Primitivos não são referencias.
    - Quando adicionamos um primitivo a um objeto com a interface List, o Java instancia um objeto que representa aquele primitivo e adiciona à lista a referencia e não o primitivo em si
    - Se quisermos criar uma List passando o “generics” de um tipo primitivo, como **`List<int>`** temos um erro de compilação, porque a lista não vai guardar primitivos. Para instanciarmos uma lista dessa forma a sintaxe seria **`List<Integer>`**
    - Porém, se adicionamos numa lista criada com o generics Integer um valor primitivo, o Java realiza a conversão para Integer, assim:
    **`List<Integer> lista = new ArrayList<Integer>();
    lista.add(29);`**
    Esse código está sintaticamente correto, já que a transformação está implicita.
    - O nome disso é **Autoboxing**
    - No java existe um classe pra cada tipo de primitivo
    - Transformação de primitivo para objeto → **Autoboxing**
    Transformação de objeto para primitivo → **Unboxing**
    - As classes dos tipos primitivos vem na biblioteca java.lang, elas são Wrappers
    - Se formos instanciar manualmente um Wrapper a sintaxe é:
    **`Integer numero = Integer.valueOf(29);`**
    - Se quisermos **converter uma String contendo um numero para o formato Integer**, precisamos usar o método estatico da classe Integer, **`Integer.valueOf(”26”)`**
    - Podemos converter uma String numerica ou Integer para o primitivo **`int`** através do método estatico **`Integer.parseInt(s);`**
    - Métodos > [.valueOf(), .doubleValue(), .parseInt()]
    - Atributos de classe > [.MAX_VALUE, .MIN_VALUE, .SIZE]
- Notas da Alura
    - para cada primitivo existe uma classe chamada *Wrapper*
    - para guardar um primitivo numa coleção é preciso criar um objeto que embrulha o valor
    - a criação do objeto Wrapper é chamada de *autoboxing*
    - a retirada do valor primitivo do objeto Wrapper é chamada de *unboxing*
    - *autoboxing* e *unboxing* acontecem automaticamente.
    - as classes wrapper possuem vários métodos auxiliares, por exemplo para o parsing
    - todas as classes wrappers que representam um valor numérico possuem a classe `java.lang.Number` como mãe

## Aula 7 - Ordenação de Listas [tempo: 1h 1min]

- Minhas notas
    - Para executar ordenar objetos dentro de uma lista utilizamos o metodo **`.sort()`**
    - O metodo **`.sort()`** exige como parametro um objeto que herde a interface **`Comparator`** que sobrescreva o método **`compare(arg1, arg2)`.** Ao definirmos essa classe comparadora, precisamos definir qual o tipo a ser comparado na implementação da interface **Comparator** e internamente, definir qual o criterio de comparação. Se o primeiro parametro for maior retornando um numero **positivo**, se o segundo for maior um numero **negativo** e se forem iguais, retornando 0
    - Todo objeto pode encapsular uma **Ordem Natural** que permite a ordenação sem uma classe comparadora usando a classe **`Collections.sort(list)`**
    - Para que isso funcione, precisamos implementar a interface **Comparable** e sobrescrever o método **`compareTo()`**
    - Inverter ordem da lista: **`Collections.reverse(lista);`**
    - Embaralhar todos os elementos de uma lista: **`Collections.shuffle(lista);`**
    - Rotacionar os elementos de uma lista: **`Collections.rotate(lista, distancia);`**
    - Extendendo **`Comparator`** criamos uma classe que define um método de comparação
    - Implementando a interface **`Comparable`** sobrescrevemos o método **`compareTo()`** dentro da classe que será comparada, nesse método definimos o critério de comparação que será a **ordem natural**. (o critério de comparação padrão)
- Notas da Alura
    - para ordenar uma lista é preciso definir um critério de ordenação
    - há duas formas de definir esse critério
        - pela interface `Comparator`
        - pela interface `Comparable` (*ordem natural*)
    - o algoritmo de ordenação já foi implementado
        - na lista no método `sort`
        - na classe `Collections` pelo método `sort`
    - a classe `Collections` é uma fachada com vários métodos auxiliares para trabalhar com as coleções, principalmente listas

## Aula 8 - Classes anônimas e Lambdas

- Minhas notas
    - Podemos definir **classes anônimas**, criamos classes dessa forma quando iremos passar um objeto como parâmetro, mas não desejamos reutilizar a classe;
    
    ```java
    Collections.sort(nomes, new Comparator<String>() {
    
        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    });
    ```
    
    - **Podemos também criá-la enquanto instanciamos a classe**. Assim não definimos a classe, apenas instanciamos uma classe com a implementação desejada.
    
    ```java
    Comparator<String> comp = new Comparator<String>() {
    
        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    };
    ```
    
    - Classes anônimas geralmente são Function Objects.
    - Uma **Function Object** é uma classe que só encapsula uma função/método/procedimento.
    - Podemos escrever as função de um Function Object através de **lambdas**, que é o mesmo que uma Arrow Function no JavaScript, com um detalhe diferente na sintaxe. Um exemplo de uso seria criar uma **lambda function** como parâmetro para o método **`sort()`** exemplo:
    
    **`lista.sort((Conta c1, Conta c2) -> Integer.compare(c1.getNumero(), c2.getNumero());`**
    
    Seria possível criar uma referencia pra essa função lambda:
    
    **`Comparator<Conta> comp = (Conta c1, Conta c2) -> {
      String nomeC1 = c1.getTitulat().getNome();
      String nomeC2 = c2.getTitulat().getNome();
      return nomeC1.compareTo(nomeC2);
    };`**
    
    A diferença pra sintaxe da arrow function é que no Java indicamos com → e não com ⇒
    - Objetos do tipo **List** tem o método **`.forEach(lambda)`**, a função lambda vai entrar como parâmetro da mesma forma que a arrow function faria no JS
    
- Notas da Alura
- Dúvidas
    - Porque nos exemplos ao criar uma lista as referencias são do tipo mais genérico e não do mais expecífico? Ex:
    
    ```java
    List<String> nomes = new ArrayList<>();
    ```
    
    - Não seria melhor se a referência também fosse do tipo ArrayList? E por que na instanciação não é informado o **generics**, só na referencia?
