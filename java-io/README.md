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
