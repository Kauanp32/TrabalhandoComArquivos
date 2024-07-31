package ArquivoTexto;

// Define o pacote em que a classe está localizada

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Importa as classes necessárias para escrita em arquivos e tratamento de exceções

public class FileWriterExample {
    
    // Define a classe pública FileWriterExample

    public static void main(String[] args) {
        
        // Método principal que será executado quando o programa iniciar

        String[] lines = new String[] { "Good morning", "Good afternoon", "Good night" };
        // Cria um array de Strings com as mensagens a serem escritas no arquivo

        String path = "C:\\temp\\out.txt";
        // Define o caminho do arquivo onde as mensagens serão escritas

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            // Bloco try-with-resources para garantir que o BufferedWriter seja fechado após o uso
            // Inicializa o BufferedWriter com o FileWriter para escrever no arquivo de saída

            for (String line : lines) {
                // Itera sobre cada linha no array de Strings

                bw.write(line);
                // Escreve a linha no arquivo

                bw.newLine();
                // Insere uma nova linha no arquivo
            }
        } 
        catch (IOException e) {
            // Captura e trata exceções de entrada/saída ao escrever o arquivo

            e.printStackTrace();
            // Imprime a pilha de erros no console
        }
    }
}