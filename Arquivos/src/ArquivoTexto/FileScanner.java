package ArquivoTexto;

// Define o pacote em que a classe está localizada

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Importa as classes necessárias para manipulação de arquivos, tratamento de exceções e leitura de entrada

public class FileScanner {
    
    // Define a classe pública FileScanner

    public static void main(String[] args) {
        
        // Método principal que será executado quando o programa iniciar

        File file = new File("C:\\temp\\in.txt");
        // Cria um objeto File com o caminho do arquivo a ser lido

        Scanner sc = null;
        // Declara a variável Scanner, inicialmente nula

        try {
            sc = new Scanner(file);
            // Inicializa o Scanner com o arquivo para leitura

            while (sc.hasNextLine()) {
                // Loop enquanto houver uma próxima linha no arquivo

                System.out.println(sc.nextLine());
                // Lê e imprime a próxima linha do arquivo
            }
        } 
        catch (IOException e) {
            // Captura e trata exceções de entrada/saída

            System.out.println("Error: " + e.getMessage());
            // Imprime a mensagem de erro no console
        } 
        finally {
            if (sc != null) {
                // Se o Scanner foi inicializado (não é nulo)

                sc.close();
                // Fecha o Scanner
            }
        }
    }
}