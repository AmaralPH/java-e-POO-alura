## Aula 1 - Trabalhando com ArrayList [tempo: 33min]

- **Minhas notas**
    - Relembramos os métodos básicos de **`ArrayList`**
    - Código:
        
        ```java
        		// criando um ArrayList
        ArrayList<String> aulas = new ArrayList();
        
        		// inserção de elementos
        aulas.add("Trabalhando com ArrayList");
        aulas.add("Percorrendo ArrayList");
        aulas.add("Removendo itens de uma ArrayList");
        
        		// remoção de elementos
        aulas.remove(1); // remove o elemento do indice 1
        
        		// recuperando elementos
        aulas.get(0) // retorna o elemento no indice 0
        
        		// percorrendo o ArrayList
        // forma 1:
        for (String aula : aulas) {
        	System.out.println(aula);
        }
        
        // forma 2:
        aulas.forEach(aula -> {
        	System.out.println(aula);
        });
        
        ```
        
    - Desde o Java 8, a forma mais elegante de percorrer um array é usando o método **`.forEach(lambda)`**

## Aula 2 - Listas de objetos [tempo: 30min]

- **Minhas notas**
    - Podemos ordenar listas de objetos desde que a classe desses objetos tenha implementada a interface **`Comparable`** e definido o método **`compareTo`**
    - Através desse método, ao chamarmos o **`sort`** sobre a lista, ele terá um critério de comparação entre os objetos
    - Podemos também definir dentro da chamada do **`sort`** esse comparator, passando como segundo parametro o critério a ser usádo
    - Código:
        
        ```java
        // dentro da classe Aula:
        @Override
        public int compareTo(Aula outraAula) {
            return this.titulo.compareTo(outraAula.titulo);
        }
        
        // dentro do main
        Aula a1 = new Aula("Revistando as ArrayLists", 21);
        Aula a2 = new Aula("Listas de objetos", 20);
        Aula a3 = new Aula("Relacionamento de listas e objetos", 15);
        
        ArrayList<Aula> aulas = new ArrayList<>();
        aulas.add(a1);
        aulas.add(a2);
        aulas.add(a3);
        
        Collections.sort(aulas);
        
        // usando um critério de comparação direto no sort:
        Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
        
        // ou ainda:
        aulas.sort(Comparator.comparing(Aula::getTempo));
        ```
        

## Aula 3 - Relacionamentos com coleções [tempo: 42min]

- **Minhas notas**
    - Quando um objeto encapsula uma lista como atributos, é uma boa prática criamos a referencia com o tipo mais genérico:
    
    ```java
    // boa pratica:
    List<Conta> contas = new ArrayList<>();
    
    // má pratica:
    ArrayList<Conta> contas = new ArrayList<>();
    ```
    
    - Isso se deve ao fato de que, se desejarmos mudar a implementação da classe e definir que agora usaremos **`LinkedList`** não iremos criar problemas nos pontos em que aquela classe foi usada
    - O acesso ao atributo do tipo **`List`** deve ser feito através de métodos e não diretamente, além disso é uma boa pratica só permitir interações com aquele atributo através de métodos
    - Para isso podemos usar o método da classe Collections chamado unmodifiableList no método de acesso a lista, além de deixar o atributo privado:
    
    ```java
    private List<Aula> = new ArrayList<>();
    
    public List<Aula> getAulas() {
            return Collections.unmodifiableList(aulas);
    }
    
    public void adiciona(Aula aula) {
            this.aulas.add(aula);
    }
    ```
    
    - Assim, para modificar a lista seguimos o padrão definido no método da classe, além de não ser possivel atribuir a lista a uma variavel e modifica-la através da variavel
    
    ```java
    List<Aula> listaDeAulas = javaCurso.getAulas();
    
    // não funciona
    listaDeAulas.add(new Aula("titulo", 22);
    
    // funciona
    javaCurso.adiciona(new Aula("titulo", 22);
    ```
    
    - **`LinkedList`** é uma implementação de lista com remoção de elementos mais eficiente, mas com acesso mais lento
    - **`ArrayList`** é uma implementação de lista com acesso a elementos eficiente, mas remoção de elementos anteriores ao ultimo lenta
    

## Aula 4 - Mais prática com relacionamentos [tempo: 40min]

- **Minhas notas**
    - Podemos utilizar o método **`stream()`** e os matodos de **`map()`** das listas para simplificarmos operações nas listas
    - Exemplo:
        
        ```java
        public int getTempoTotal() {
            return this.aulas.stream().mapToInt(Aula::getTempo).sum();
        }
        ```
        
    - Podemos replicar uma lista que é *unmodifiable list* em uma variavel para realizarmos modificações diretamente nela. Assim respeitamos o encapsulamento da classe que tem a lista, mas conseguimos interagir com a lista de forma mais livre
    - Exemplo:
        
        ```java
        List<Aula> aulasImutaveis = javaColecoes.getAulas();
        System.out.println(aulasImutaveis);
        
        List<Aula> aulas = new ArrayList<>(aulasImutaveis);
        ```
        
    - O melhor jeito de ordenar uma *unmodifiable list* seguindo algum critério é nos aproveitarmos da possibilidade de poder **passar a* unmodifiable list *no construtor de uma* `ArrayList` tradicional* , podendo assim utilizar o método `.sort()` de Collections.
    - Outros métodos de **`Collections`**:
    - 
    - Exemplo:
        
        ```java
        Collections.reverse(); // inverte lista
        Collections.shuffle(); // embaralha lista
        Collections.singletonList(); // retorna um item de uma lisca como collection
        Collections.nCopies(); // adiciona n copias de um item na lista
        ```
        
    

## Aula 5 - O poder dos sets [tempo: 30min]

- **Minhas notas**
    - A primeira diferença entre um **`Set`** e uma **`List`** é que o **`Set`** não é hordenado, por isso não é possivel recuperar um elemento pelo indice, visto que eles não possuem indices
    - **`Sets`** não guardam valores repetidos
    - Podemos utilizar um **`Set`** como parametro na instanciação de uma **`List`**, criando uma **lista ordenada** com os elementos contidos no **`Set`**
    - Quando precisamos acessar os elementos de um **`Set`** precisamos iterar sobre ele já que não é possivel fazer um **`.get()`**
    - Podemos pensar num **`Set`** como um saco com itens, podemos pega-los, mas não é possivel saber em que ordem
    

## Aula 6 - Aplicando o Set no modelo [tempo: 30min]

- **Minhas notas**
    - De forma semelhante ao que fazemos com **`Lists`** podemos usar **`Sets`** para armazenar dados dentro de um atributo de uma classe
    - Continua sendo uma boa pratica criar **`guetters`** e **`setters`** para acessar e modificar os dados desse **`Set`**
    - Podemos criar um **`Set`** vazio através do método **`Collections.emptySet()`** esse Set sera unmodifiable

## Aula 7 - Equals e hashcode [tempo: 30min]

- **Minhas notas**
    - Chegar se um elemento está contido num **`Set`** é muito mais eficiente que numa **`List`**
    - Quando buscamos um item num Set, ele por padrão irá buscar a referencia e não o conteudo desse elemento.
    - Caso queiramos checar se um Set contem um elemento com o atributo nome == “Pedro” por exemplo, precisamos sobrescrever o método equals() para que a comparação seja feita pelo nome e não pela referencia
    - Além de sobrescrever a função equals, como o set usa o mapeamento Hash, precisamos também sobrescrever o método hashCode() que irá fazer a definição da chave do elemento
    - Podemos fazer essa implementação usando o Eclipse. Para isso digitamos CTRL + 3, depois “equals”, enter e selecionamos qual atributo da classe vai ser usado para a comparação e para o hashCode
    

## Aula 8 - Outros sets e iterators [tempo: 47min]

- **Minhas notas**
    - Existem outras implementações de **`Set`** além do **`hashSet`** como o **`LinkedHashSet`**, essa implementação é ordenada, por exemplo.
    - Existe ainda a implementação **`TreeSet`** mas essa implementação precisa que os itens passados como generics tenham implementada a interface **`Comparable`**
    - O **`Iterator`** é um um objeto antigo usado para percorrer coleções. Todas as coleções dão acesso a ele, ele é criado chamando o método **`.iterator()`** a partir de qualquer coleção
    - Esse objeto tem dois métodos: **`.hasNext()`** e **`.next()`**
    - Ele é usado dentro de um loop while, após percorrida a lista, se precisarmos percorre-la de novo, precisamos criar um novo iterador
    - Código:
        
        ```java
        Set<Aluno> alunos = javaColecoes.getAlunos();
        Iterator<Aluno> iterador = alunos.iterator();
        
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
        ```
        
    - Podemos passar uma classe que implemente a interface **`Comparator`** como parametro na instanciação de um **`TreeSet`**, se fizermos isso, mesmo que a classe dos elementos não possua a interface **`Comparable`**, a **`TreeSet`** vai usar o criterio de ordenação do **`Comparator`**
    

## Aula 9 - Qual Collection usar [tempo: 15min]

- **Minhas notas**
    - É uma boa prática declarar uma Collection usando a referencia **`Collection`**, pois com ela será possivel utilizar os métodos básicos: **`size`**, **`contains`**, **`add`** e **`remove`**.
    - Caso o código passe a utilizar um método mais especifico como get ou se beneficie de performance na busca com contais, ai sim fará sentido voltar na declaração e trocar a referencia **`Collection`** para **`Set`** ou **`List`**, sem que isso impacte o código já escrito
    - Declarar sempre com a classe mais genérica

## Aula 10 - Mapas [tempo: 40min]

- **Minahs notas**
    - A classe **`Map`** não é filha de **`Collection`**
    - O tipo de **`Map`** mais utilizado é o **`HashMap`**
    - O método de inserção de um objeto ao **`Map`** é o **`.put(chave, valor)`**
    - Se declara um Map com a seguinte sintaxe: **`Map<Integer, Aluno> = new HashMap(aluno.getMatricula(), aluno)`**
    - O primeiro valor no generics é o tipo da chave e o segundo é o tipo do valor
    - Buscamos um valor em um **`HashMap`** com o método **`.get()`**
    - Caso a chave passada para o **`get`** não exista no **`HashMap`** ele retorna **`null`**
    - Podemos criar um **`Map`** que recebe como valor um **`Set`** caso queiramos que uma mesma chave dê acesso a uma coleção de valores
    - Podemos criar um **`Map`** ordenado através da classe **`LinkedHashMap`**
    - A interface **`Map`** pode ser vista como 3 coleções diferentes, ela é um `**Set` de chaves**, uma **`Collection` de valores** e um `**Set` de mapeamento chave-valor**
