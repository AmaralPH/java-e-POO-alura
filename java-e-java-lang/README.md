## Aula 1 - Organizando as classes com Pacotes

- Package é o nome de diretórios que agrupam classes dentro do código fonte de um projeto Java.
- Quando dentro de um package a classe deve declarar na primeira linha a keyword “package” e o nome do package.
- Quando essa classe é invocada por outra classe que não faz parte do mesmo package, é preciso chamar a função atravez do Full Qualified Name (FQN)
- A estrutura adotada pela comunidade java organiza os packages dentro de uma arquitetura de pastas como: br > com > alura > (aqui ficam os pacotes). Essa arquitetura serve pra evitar que existam conflitos entre nome de pacotes de empresas diferentes.
- No exemplo **`br > com > alura > [modelo, teste]`** passariamos a ter um problema, o FQN de uma classe ficticia`**Conta” seria br.com.alura.modelo.Conta()` (enderaço do site ao contrário)** para evitar esse problema nós importamos o pacote com a linha **`import br.com.alura.modelo.*`** assim teriamos acesso a todas as classes contidas em modelo, sem precisar utilizar o FQN.
- O comando do Eclipse **`CTRL + SHIFT + O`** importa todos os pacotes usados no código de forma automatica.

## Aula 4 - O pacote java.lang

- O unico pacote que não precisa ser importado em Java é o java.lang, ele já esta importado por padrão.
- As classes de exceção “Exception”, “RuntimeException”, “NullPointerException” e “ArithmeticException” não precisam ser importadas, pois já vem como padrão pelo java.lang
- String é a classe mais importante
- Ao instanciar um objeto String, a instanciação é implicita, mas poderiamos fazer o seguinte código **`String nome = new String(”Pedro”)`**
- Uma String inicializada não pode ser alterada, para alterarmos a variavel que aponte para uma String, devemos reatribuir a variavel com uma nova String.
- Esse conceito se chama IMUTABILIDADE.
    
    ### Resumo da aula
    

• qualquer método de alteração da classe `String` devolve uma nova `String` que representa a alteração

• a classe `String` é uma `CharSequence`

• se precisamos concatenar muitos `String` devemos usar a classe `StringBuilder`

• vimos vários métodos da classe String como `trim`, `charAt`, `contains`, `isEmpty`, `length`, `indexOf`, `replace`

## Aula 5 - A classe Object

- “System.out.println()” é composto pela classe publico `**System**`, o atributo out é **`static`** e **`println`** é um método publico com sobrecarga e não joga exceções do tipo checked.
- **`out`** é um atributo do tipo static pois sua chamada é feita usando a referencia System e não uma instancia de System. Se não fosse esse o caso, precisariamos instanciar um objeto System e usar o atributo que aponta para essa instancia para acessar o atributo out;
- A referencia mais generica que existe é **`Object`**, **todas as classes herdam essa classe de forma implicita**. Caso queiramos permitir que um metodo aceite qualquer tipo como parametro, definimos o tipo do parametro como **`Object`**
- A classe Object implementa o método **`toString()`** que é o metodo chamado quando printamos um objeto instanciado. Ele informa o FQN daquela classe + um hexadecimal que não sei pra que serve (achei que era o endereço na memoria HEAP, mas parece que não)
- Podemos sobrescrever (**Overriding**) o método **`toString`** para alterar o comportamento do **`println()`** quando recebe aquela classe como parametro.
- Sobrescrever as classes basicas herdados de Object parece ser algo semelhante a definir os metodos **`__????__`** em Python, sobrescrever **`toString()`** seria o equivalente a definir numa classe uma implementação para **`__str__`**
