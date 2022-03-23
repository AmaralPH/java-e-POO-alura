## Aula 1 - Testes automatizados [tempo: 27min]

- **Minahs notas**
    - Testes são necessários para garantir que a aplicação funciona de forma desejada, intuitivamente realizamos testes manuais desde que começamos a programar, já que ao escrever o código rodamos ele pra resolver um problema e ve-lo funcionando em diferentes cenários
    - O problema é que com o aumento da complexidade do código, começa a ficar pouco prático testar todos os cenários daquele código e começa a ficar frequente deixar de lado o teste de alguns cenários
    - Como solução foram criados os testes automatizado, criamos código que testa os cenários e não precisamos repetir manualmente os testes de cada caso específico sempre que houver uma mudança minima no código
    - Com os testes automatizados também ganhamos agilidade, já que eles rodam muito mais rapido do que fazer na mão um teste pra cada caso
    - Além da agilidade e confiabilidade, também ganhamos um estimulo pra refatorar o código antigo, já que se existem testes que atestam o funcionamento de todos os cenários, caso uma modificação impacte a aplicação, somos avisados de imediato e podemos corrigir o problema
    - A aula foi composta de exemplos de teste automatizados para um método de soma sem JUnit. Com ela foi possivel exemplificar o conceito de testagem de forma simples e apontar o problema de escalabilidade dessa abordagem.

## Aula 2 - JUnit [tempo: 56min]

- **Minhas notas**
    - JUnit foi criada em 1995 por Kent Beck e Erich Gamma
    - Ela é a biblioteca padrão de testes pro Java, sem muitas concorrentes
    - Foca em testes de unidade
    - A ideia dele é simplificar a testagem automatizada e simplificar sua compreenção
    - O padrão de nomeação de classes testes é: NomeDaClasseTestada**Test**
    - Não utiliza o método main e sim um método pra cada cenario de teste
    - Nome do método descreve a intenção do teste
    - Uma forma de transformar o metodo em um teste JUnit é adicionar sobre ela uma anotação **`@Test`**
    - O Eclipse já indica a importação do JUnit
    - Usamos a classe do JUnit chamada Assert e como método o critério de asserção
    - **`Assert.assertEquals(valor_desejado, retorno_do_metodo_testado)`**
    - O Eclipse abre um plugin JUnit informando o retorno dos testes
    - 

## Aula 3 - TDD: Test-Driven Development [tempo: 1h4min]

- **Minhas notas**
    - TDD é um padrão de projeto no qual escrevemos os testes antes do código
    - O fluxo é: escreve os testes > falha > escreve as funções > passa > refatora as funções > passa novamente
    - A ideia por trás dele é orientar o desenvolvimento a partir da segurança dos testes
    - Após os testes terem passado devemos refatorar o código
    - A vantagem de o código ter sido testado é que não é perigoso realizar a refatoração, caso algo quebre com a mudança, percebemos de imediato e podemos voltar ao código e corrigir aquele erro.
    - Usamos o padrão de projeto ***strategy*** como exemplo de refatoração na aula. O que fizemos foi passar acabar com a lógica de if-else da classe ReajusteService fazendo com que o Enum Desempenho retornasse o percentual de reajuste para cada cenário de desempenho ao invés de utiliza-lo em ReajusteService como condicional para decidir o percentual aplicado.
    - Vantagens do TDD: você já sai com o código testado, evita viciar os testes (criar eles de acordo com a implementação e não comportamento), a refatoração faz parte do processo, ajuda a manter o foco em cada ponto do código, fazendo TDD  temos a tendencia de simplificar o código.
    - Quando usar TDD: quando vamos implementar uma funcionalidade complexa que ainda não está muito clara, porque ele ajuda a rascunhar o código

## Aula 4 - Lidando com exceptions [tempo: 25min]

- **Minhas notas**
    - Para indicar para o JUnit que aquele caso receberá um exception utilizamos o **`assertThrows`** ele recebe por parametro o tipo da exceção (com o método .class) e uma função lambda sem parametros que executa o código que irá gerar a exceção
    - Também podemos fazer o mesmo com um **try-catch** no teste, na primeira linha do **try** executamos o código e na segunda forçamos a falha com o método **`fail()`**, o **catch** não precisa retornar nada
    - Esse segundo método é util quando queremos testar a mensagem da exceção, nesse caso o **catch** faz um **`assertEquals`** recebendo no primeiro parametro a mensagem esperada e no segundo **`e.getMessage()`**

## Aula 5 - Mais recursos [tempo: 30min]

- **Minhas notas**
    - Também deveremos refatorar o código dos testes
    - O JUnit nos dá ferramentas para simplificar o código
    - Devemos criar variaveis de classe na nossa classe de testes para objetos que serão repetidamente usados nos métodos de teste
    - Devemos criar um método de inicialização que será executado em cada teste
    - O JUnit permite automatizar essa tarefa para que não seja necessário chamar esse método dentro de cada teste
    - Para isso utilizamos a anotação **`@BeforeEach`**
    - Existem outras anotações para esse fim como **`@AfterEach`** **`@BeforeAll`** **`@AfterAll`**
    - Não se deve testar métodos privados de uma classe, pois ele implicitamente está sendo testado a partir dos outros testes da classe. Não devemos torna-lo publico para realizar o teste.
    - Não precisamos testar todas as classes
    - Não faz sentido testar métodos do tipo getter e setter
    - Só devemos testar classes que possuem regras de negócio implementando lógicas e classes que provavelmente sofrerão muitas alterações
    -
