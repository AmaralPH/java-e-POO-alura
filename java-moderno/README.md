## Aula 1 - Default Methods [tempo: 30min]

- **Minhas notas**
    - No Java 8 não precisamos mais utilizar a classe **`Collections`** para ordenação, todas as Listas já possuem nativo o método **`.sort()`**
    - O método **`sort`** recebe como parametro um objeto **`Comparator`** que define o critério de comparação ou então uma função **`lambda`**
    - É também uma inovação do Java 8 o método **`.forEach(lambda)`** nativo das Listas,
    - Podemos também ao invés da função lambda passar um objeto que implementa a interface **`Consumer`** nesse objeto devemos sobrescrever o método **`accept`** que definirá a operação a ser feita a cada iteração
    - As funções lambda só abstraem a lógica, já que o Java vai criar um objeto **`Comparator`** ou **`Consumer`** com a estrutura da **função** **`lambda`**
    

## Aula 2 - Que venham os lambdas! [tempo: 37min]

- **Minhas notas**
    - Podemos criar **classes anonimas** quando precisamos passar uma classe como parâmetro pra algum método
    - Fazemos isso quando não iremos reutilizar aquela classe e ela é curta, de outro modo o ideal é criar a classe e uma instancia dela pra ser passada como parâmetro
    - O problema disso é que fica pouco legivel, ainda mais se utilizamos muitas classes anonimas
    - O Java 8 trouxe uma implementação mais moderna, quando a classe recebida por parâmetro pelo método é sempre a mesma e ela possui um unico método, podemos umar um **`lambda`**
    - **`Lambda`** sempre funciona quando precisamos de uma interface que só tem um **`método abstrato`**
    - Uma interface que só tem um método abstrato é chama de **Interface Funcional**
    - A **expressão lambda** é convertida para uma **interface funcional**
    - Para isso funcionar a **interface funcional** deve ser compativel com o a **expressão lambda**, ou seja, ter o mesmo numero de parametros e o mesmo tipo de retorno
    - A **interface funcional** só pode ter **UM UNICO MÉTODO ABSTRADO**, porém pode ver metodos **`default`** ou **`static`,**  isso ocorre porque o unico método que será sobrescrito será o método abstrato
    - Se tentamos declarar um Object atribuindo como valor uma expressão lambda, recebemos o seguinte erro: **“**`The target type of this expression must be a functional interface`**"**
    

## Aula 3 - Código mais sucinto com Method references [tempo: 48min]

- **Minhas notas**
    - Um método reference é uma alternativa para a expressão lambda, a sintaxe dela é algo como: `**String::length**`
    - Isso seria equivalente ao lambda **`s -> s.length()`**
    - Podemos declarar uma interface que receba como valor o method reference, como em **`Consumer<String> consumidor = String::length`**
    - Por baixo dos panos ele está implementando o método abstrato **`accept`** que irá retornar o método **`length()`** para cada **`String`** da lista que estiver sendo percorrida
    - **`.sort()`** é um método default de **`List`**
    - Metodos default são os métodos padrões de classes que implementam algum procedimento, como **`sort`**, **`forEach`** e afins
    - As interfaces como Comparator possuem metodos default que funcionam como factory da propria interface, assim, elas recebem expressões lambda ou uma method references e constroem um objeto que implemente o único método abstrato daquela interface, a partir da expressão passada como parametro
    - `palavras.sort(Comparator.comparing(s -> s.length()));`
    - Usamos o método default sort da lista palavras e usamos o método estatico default da interface Comparator para criar um objeto Comparator com o método abstrato compare usando como regra a expressão lambda (ou method reference) passada como parametro
    - Estamos dizendo: "palavras ordene comparando s.length"
    - Dizemos que Comparator.comparing recebe um lambda, mas na verdade ela recebe uma instância de uma interface funcional.
    - O nome dessa interface funcional é **`Function`** que tem apenas o método apply
    - Código
        
        ```java
        Function<String, Integer> funcao = s -> s.length();
        Comparator<String> comparador = Comparator.comparing(funcao);
        palavras.sort(comparador);
        
        // da no mesmo que:
        palavras.sort(Comparator.comparing(s -> s.length();
        // ou ainda:
        palavras.sort(Comparator.comparing(String::length);
        ```
        
    - É possivel encurtar ainda mais o código com o **`import static`**
    
    ```java
    import static java.util.Comparator.*;
    palavras.sort(comparing(String::length));
    ```
    
    - Podemos usar method references praticamente em qualquer lugar que usariamos um lambda, por exemplo:
    
    ```java
    // com lambda
    palavras.forEach(s -> System.out.println(s));
    // com method reference
    palavras.forEach(System.out::println);
    ```
    
    - Porém nem sempre é possivel usar method references no lugar de lambdas, por exemplo:
    
    ```java
    palavras.forEach(s -> s.substring(0, 5);
    ```
    
    - Nesse caso não seria possivel, pois não iriamos realizar uma operação somente sobre o valor de cada elemento, seria necessário um parâmetro adicional indicando os indices retornados da **`String`**
    - Ou seja, o method reference só pode ser usado quando o método chamado sobre o valor iterado não tiver parametros. **`s.length()`** executa uma operação simples sobre aquela String, **`s.substring(0, 5)`** executa uma operação que pede parametros adicionais, o que o method reference não suporta.
    - 
    

## Aula 4 - Streams: trabalhando melhor com coleções [tempo: 25min]

- **Minhas notas**
    - O metodo **`stream()`** devolve um fluxo de objetos que servem para trabalhar com metodos mais especificos, como o **`filter`**
    - O **`stream`** não altera a coleção original, caso queiramos guardar o retorno de um metodo feito através do stream, precisamos atribuir uma variavel
    - O **`stream`** faz a coleção se comportar muito parecido com um Array no JavaScript
    - Os **`Streams`** recebem **expressões lambda** ou **method references**
    - Podemos encadear metodos a partir do **`.stream()`** como fariamos no JS
    - Métodos citados: **`.stream()` `.filter()`** **`.map()`** **`.mapToInt()`** **`.sum()`**
    - Outros metodos: **`.collect()`** **`.findFirst()`** **`.findAny()`**
    

## Aula 5 - Mais Streams, Collectors e APIs [tempo: 30min]

- **Minhas notas**
    - A classe Optional serve pra criar uma referencia que aceita null
    - Ela é util para quando fazemos uma busca numa coleção usando stream e existe a possibilidade de o valor não ser encontrado, assim não é lançada uma exceção
    - Ao final de uma busca desse tipo podemos incluir o método **`.ifPresent(lambda)`** que define uma operação caso um valor seja encontrado e que não faz nada no caso contrario
    - Quando retornamos uma busca feita através do metodo stream, o retorno será um objeto Stream
    - Caso queiramos salvar a coleção retornada em uma lista, precisamos utilizar o método **`.collect(Collectors.toList()`**
    - **`Collectors`** é uma classe que implementa vários métodos para realizar esse tipo de operação, converter de **`Stream`** para **`Collection`**
    - A classe Collectors possui um método .toMap que retorna a coleção em um map, precisamos passar como parametro DUAS expressões lambda, a primeira definindo a chave e a segunda o valor
    
    ```java
    Map<String, Integer> mapa = cursos.stream()
    			.filter(c -> c.getAlunos() > 100)
    			.collect(Collectors.toMap(
    							c -> getNome(), // pega a chave
    							c -> getAlunos())); // pega o valor
    ```
    
    - 
    

## Aula 6 - A nova API de datas [tempo: 25min]

- **Minhas notas**
    - **`LocalDate`**, **`LocalTime`**, **`DateTimeFormatter`**, **`LocalDateTime`**
    - **`.now()`** **`.year()`** **`.month()`** **`.ofPattern()`**
    - A API de datas introduz novas classes para operar datas, eles representam datas, horarios, datas e horarios, além de servirem de interface para formatação de datas
    - Os métodos das classes permitem obter a data atual, horario, formatação e afins
    - Enums são os atributos de classe em maiusculo que representam uma informação que a classe pode dar
    - `**Month.JANUARY**` é um Enum
