## Aula 1 - Leitura com [java.io](http://java.io) [tempo: 1h]

- Minhas notas
    - **io** é um acronimo para input/output, a biblioteca **[java.io](http://java.io)** existe pra lidar com fluxo de dados
    - Podemos criar um objeto que captura um input de dados como bytecode através da classe **`FileInputStream`** com a sintaxe:
    
    ```java
    import java.io.FileInputStream
    
    FileInputStream fis = new FileInputStream("nome_do_arquivo.txt");
    ```
    
    - Se criamos abrimos um arquivo dessa forma, precisamos fazer o tratamento de exceção
    - Podemos fazer isso colocando na assinatura do método que irá importar o arquivo um **`throws`** para a exceção **`FileNotFoundException`** importada de **`[java.io](http://java.io)`**, ou envolve-lo num bloco try-catch
    - Na sequencia devemos converter para String aquela informação obtida como bytecode, já que o arquivo bruto será em bytecode e precisa desse tratamento adicional. Para isso utilizamos a classe **`InputStreamReader`** que será instanciada recebendo como parâmetro a referencia que contem o objeto que contem o bytecode.
    - Aqui precisamos de mais um tratamento de exceção, para simplificar o processo passamos a usar a **checked exception** **`IOException`** que é herdada por todas as exceções da biblioteca java.io
    - Além disso precisamor de uma classe que consiga ler as informações organizadas em linhas, para isso instanciamos um objeto **`BufferedReader`** passando a referencia para o objeto **`InputStreamReader`**
    - Agora poderemos ler as linhas como Strings a partir do objeto **`BufferedReader`**
    - Por fim devemos fechar o buffer de dados
        - Código
            
            ```java
            import java.io.BufferedStream;
            import java.io.FileInputStream;
            // import java.io.FileNotFoundException;
            import java.io.IOException;
            import java.io.InputStreamReader;
            
            public class TesteLeitura {
            	public static void main(String[] args) throws IOException {
            			// retorna arquivo em bytecode
            		FileInputStream fis = new FileInputStream("nome_do_arquivo.txt");
            			// transforema bytes em caracteres
            		InputStreamReader isr = new InputStreamReader(fis);
            			// junta os caracteres em linhas e agora pode ser lido linha a linha
            		BufferedReader br = new BufferedReader(isr);
            	
            			// aqui extraimos uma String do objeto BufferedReader
            		String linha = br.readline();
            		
            	while (linha != null) {
            			System.out.println(linha);
            			 linha = br.readLine();
            		}
            		
            		// fecha o buffer
            		br.close();
            	}
            }
            ```
            
    - Esse é o padrão de projeto se chama **decorator**
    - Para ler todas as linhas podemos fazer um loop que percorre todas as linhas do buffer
    - Um arquivo pode ser lido como **Stream** ou **Reader**, o primeiro para bytes e o segundo para caracteres
    - Esses dois tipos de classes precisam ser compreendidos para se trabalhar bem com input de dados
- Dúvidas
- Notas da Alura
    1. Abertura de arquivos;
    2. Leitura linha a linha do arquivo e detecção de seu fim;
    3. Utilização de *exceptions* pelo Java IO caso a operação de leitura não saia como esperado;
    4. Classes abstratas e concretas para leitura.

## Aula 2 - Escrita com [java.io](http://java.io) [tempo: 50min]

- Minhas notas
    - A lógica da escrita de dados é muito semelhante a lógica da leitura, mas utilizando classes que servem para escritas
    - Precisamos criar um **`FileOutputStream`** que recebe o nome do arquivo, passamos ele para um **`OutputStreamWriter`** que vai lidar com caracteres e não bytecode, em seguida passamos ele para um **`BufferedWriter`** que terá as funções necessárias para escrever no arquivo.
    - Ao final o Buffer precisa ser fechado
    - Exemplo de código:
        
        ```java
        //Código omitido
        
        public class TesteEscrita {
        
                public static void main(String[] args) throws IOException {
        
                        //Fluxo de Entrada com Arquivo
                        OutputStream fos = new FileOutputStream("lorem2.txt");
                        Writer osw = new OutputStreamWriter(fos);
                        BufferedWriter bw = new BufferedWriter(osw);
        
                        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
                        bw.newLine();
                        bw.newLine();
                        bw.write("asfasdfsafdas dfs sdf asf assdß");
        
                        bw.close();
        
                }
        }
        ```
        
    - Podemos utilizar o teclado como fonte de dados ao passar para a referencia **`InputString`**  a o atributo estatico **`[System.in](http://System.in)`**
    - Podemos analogamente fazer com que a entrada seja retornada na tela, passando para a referencia **`OutputString`** o valor **`System.out`**
    - Podemos usar as referencias **`InputStream`** e **`OutputStream`** para passar e receber dados via rede através de Sockets (que tem uma classe em Java)
    - Esse exemplo serve pra motrar que muitas bibliotecas usam as classes **`InputStream`** e **`OutputStream`** para fazer leitura e registro de dados, elas são a base pra todas as lógicas de **input/output**
    - Existem 4 classes abstratas básicas pra tratamento de dados:
    
    **`InputStream`** trabalha com **entrada** de dados **binarios**
    **`OutputStream`** trabalha com **saida** de dados **binários**
    **`Reader`** trabalha com **entrada** de dados no formato de **caracteres**
    **`Writer`** trabalha com **saida** de dados no formato de **caracteres**
    - Existem classes como **`InputStreamReader`** e **`OutputStreamWriter`** que fazem a conversão das classes de tipos binários para caracteres
- Tópicos aprendidos
    - escrever em arquivos;
    - escrever usando outputs diferentes;
    - Ler e escrever dados abstraindo implementação;
    - Classes abstratas e concretas para escrita e leitura.

## Aula 3 - FileWriter e PrintStream [tempo: 56min]

- Minhas notas
    
    [1/8]
    
    - Podemos simplificar a escrita de código ao importar um arquivo para escrita usando a classe **`FileWriter`** ao invés das classes **`FileOutputStream`** > **`OutputStreamWriter`** > **`BufferedWriter`**
    - Apesar disso, para podermos usar o método **`newLine()`** precisamos criar um **`BufferedWriter`** que receba o **`FileWriter`**, ainda assim podemos não fazer isso e substituir o método por **`write(””)`**
    - Código
        
        ```java
        					// CÓDIGO OMITIDO //
        
        FileWriter fw = new FileWriter("lorem.txt");
        
        fw.write("primeira linha a ser inserida");
        fw.write(System.lineSeparator()); // fw.write(""); // fw.write("\n");
        fw.write("segunda linha a ser inserida");
        ```
        
        ```java
        					// CÓDIGO OMITIDO //
        
        // agora instanciando um BufferedWriter:
        FileWriter fw = new FileWriter("lorem.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write("primeira linha a ser inserida");
        bw.newLine();
        bw.write("segunda linha a ser inserida");
        ```
        
        ```java
        					// CÓDIGO OMITIDO //
        
        // ou ainda:
        BufferedWriter bw = new BufferedWriter(new FileWriter("lorem.txt"));
        
        bw.write("primeira linha a ser inserida");
        bw.newLine();
        bw.write("segunda linha a ser inserida");
        ```
        
    
    [3/8]
    
    - Também é possível utilizar o **`PrintStream`** para escrever em arquivos.
    - Essa classe era a padrão na versão 1.0 do Java e é anterior as outras implementações de Writers. Inclusive atributo **`System.out`** utiliza sua essa classe para retornar Strings.
    - Código
        
        ```java
        			// CÓDIGO OMITODO
        
        PrintStream ps = new PrintStream("arquivo.txt");
        
        ps.println("primeira linha")
        ps.println();
        ps.println("terceira linha");
        ```
        
    - Essa alternativa permitia escrever numa **`Stream`** de dados abstraindo a conversão do objeto para o tipo **`Writer`**.
    - Existe ainda uma classe chamada **`PrintWriter`** que possui vários métodos para imprimir varios tipos de dados, ele funciona de forma semelhante ao **`PrintStream`**
    
    [7/8]
    
    - Podemos medir o tempo de execução de um código utilizando um método da classe **`System`** chamado **`currentTimeMillis()`**
    - Código
        
        ```java
        public class TesteEscritaFileWriter {
        
            public static void main(String[] args) throws IOException {
        
                long ini = System.currentTimeMillis(); // inicia a contagem
        
                BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
        
                bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
                bw.newLine();
                bw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");
        
                bw.close();
        
                long fim = System.currentTimeMillis(); // finaliza contagem
        
                System.out.println("Passaram " + (fim - ini) + " milissegundos");
        
            }
        }
        ```
        
    
- Tópicos aprendidos
    - Várias alternativas para estabelecer uma saída para um arquivo de texto, como:
        - A classe `FileWriter`
        - A classe `PrintStream`
        - A classe `PrintWriter`
    - Alguns detalhes da classe `System`, como :
        - O atributo `System.out` é do tipo `PrintStream`
        - O método `System.lineSeparator()` devolve os caracteres que representam uma nova linha
        - O método `System.currentTimeMillis()` devolve os milissegundos que passaram desde 1 de janeiro de 1970

## Aula 4 - Usando java.util.Scanner [tempo: 1h35min]

- Minhas notas
    - [1/9] Leitura com Scanner
        - Podemos ler arquivos **CSV** com uma classe da biblioteca [**`java.io`](http://java.io)** chamada **`Scanner`**. Ela recebe no construtor um aquivo do tipo **`File`** e possui varios métodos para interagir com ele.
        - Código
            
            ```java
            		// CÓDIGO OMITIDO
            public static void main(String[] args) {
            
                            Scanner scanner = new Scanner(new File("contas.csv"));
            
                            String linha = scanner.nextLine();
                            System.out.println(linha);
            
                            scanner.close();
            
                    }
            ```
            
    - [3/9] Parseando arquivo
        - Depois de criarmos um objeto de leitura para nosso arquivo CSV, provavelmente iremos utilizar as linhas como listas, onde iremos acessar os valores pelo indice.
        - Para fazermos isso podemos criar uma referencia do tipo array e passar como valor o método estatico **`.split(regex)`**
        - O valor retornado será o um código que identifica a referencia criada para aquele array daquela linha e não sei conteudo, para corrigir isso e imprimir o conteudo do array, precisamos utilizar o método **`Arrays.toString(array)`** como no exemplo a seguir:
        - Código
            
            ```java
            Scanner sc = new Scanner("arquivo.csv");
            while (sc.hasNextLine()) {
            	String linha = sc.nextLine();
            	String[] valores = linha.split(",");
            
            	// printa o conteudo do array como uma String
            	System.out.println(Arrays.toString(valores));
            	
            }
            ```
            
        - Podemos evitar a sintaxe do **`Array`** podemos utilizar uma nova instancia **`Scanner`** que dessa vez recebe a **`String`** da linha que desejamos converter para **`Lista`**
        - Precisamos definir qual é a localidade que queremos para os dados, visto que um **`double`** no Brasil é representado como 2,1 e nos US é representado como 2.1
        - Precisamos também definir o delimitador que separa os valores no CSV
        - Em seguida, para acessar cada um dos itens no **`Scanner`** da **`String`** precisamos usar o método **`.next()`**
        - Código
            
            ```java
            Scanner sc = new Scanner("arquivo.csv");
            while (sc.hasNextLine()) {
            	// captura o valor da linha como String
            	String linha = sc.nextLine();
            	// instancia a String num objeto Scanner que funcionará como lista
            	Scanner linhaScanner = new Scanner(linha);
            	// define o padrão local de dados
            	linhaScanner.useLocale(Locale.US);
            	// define qual é o limitador dos elementos no arquivo
            	linhaScanner.useDelimiter(",");
            
            	while (linhaScanner.hasNext()) {
            		String atual = linhaSanner.next();
            		System.out.println(atual);
            	}
            }
            ```
            
        - Essa lógica ainda gera outro problema, caso queiramos extrair os dados do arquivo com um tipo diferente de String, precisariamos usar metodos como **`.nextInt()`** ou **`.nextDouble()`**
        - Eu espero sinceramente que existam classes que abstraiam essa lógica, to achando caótico.
    - [5/9] Formatação de valores
        - Podemos formatar valores de uma **`String`** atravś do método estático **`.format()`** ele recebe por parametros a formatação (”%s %d %f”, etc.) e os argumentos a serem formatados. Isso ajuda a “simplificar” a concatenação de **`Strings`**
        - Alternativamente o método pode ser chamado com um objeto Locale antes do parametro que define a formatação algo como:
        - Código
            
            ```java
            **String linha = String.format(new Locale("pt", "BR"),
            														"%s - %04d-%05d - %s: %10.2f",
            														tipoConta, agencia, numero, titular, saldo);
            
            System.out.println(linha);**
            ```
            
        - Esse código imprimiria uma String semelhante a: 
        Conta Corrente - 0022-00333 - Pedro Amaral: 257,33
        - Esse tipo de sintaxe existia no JavaScript e no Python, mas acho que já foi abstraida, espero que tenha rolado o mesmo com o Java. Se não for o caso, **recorrer sempre a documentação**.
    - [8/9] Para saber mais: java.util.Properties
        - Existe uma classe no jáva útil que permite salvar arquivos de texto com formato chave-valor e consumir esses arquivos da mesma forma.
        - Parece ser uma forma rudimentar de criar um banco de dados
        - Esses valores passam a poder ser acessados com a referencia da classe instanciada (que recebeu o arquivo no construtor), chamando o método **`.getPropertie(chave)`**
        - Código
            
            ```java
            Properties props = new Properties();        
            props.load(new FileReader("conf.properties"));
            
            String login = props.getProperty("login");
            String senha = props.getProperty("senha");
            String endereco = props.getProperty("endereco");
            
            System.out.println(login + ", " + senha  + ", " +  endereco);
            ```
            
- Tópicos estudados
    1. Leitura de arquivos com Scanner
    2. Uso de delimitador com Scanner
    3. Formatação de texto e também de números
    4. Definição de Localização para formatar o texto.
