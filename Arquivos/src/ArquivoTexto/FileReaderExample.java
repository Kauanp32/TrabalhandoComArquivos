package ArquivoTexto;

// Define o pacote em que a classe está localizada

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Importa as classes necessárias para leitura de arquivos e tratamento de exceções

public class FileReaderExample {
    
    // Define a classe pública FileReaderExample

    public static void main(String[] args) {
        
        // Método principal que será executado quando o programa iniciar

        String path = "C:\\temp\\in.txt";
        // Define o caminho do arquivo a ser lido

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Bloco try-with-resources para garantir que o BufferedReader seja fechado após o uso
            // Inicializa o BufferedReader com o FileReader para ler o arquivo

            String line = br.readLine();
            // Lê a primeira linha do arquivo

            while (line != null) {
                // Loop enquanto a linha lida não for nula (ou seja, enquanto não atingir o final do arquivo)

                System.out.println(line);
                // Imprime a linha lida no console

                line = br.readLine();
                // Lê a próxima linha do arquivo
            }
        } 
        catch (IOException e) {
            // Captura e trata exceções de entrada/saída

            System.out.println("Error: " + e.getMessage());
            // Imprime a mensagem de erro no console
        }
    }
}