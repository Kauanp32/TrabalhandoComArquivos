package ArquivoTexto;

// Define o pacote em que a classe está localizada

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Importa as classes necessárias para ler o arquivo e tratar exceções

public class TextFileReader {

    // Define a classe pública TextFileReader

    public static void main(String[] args) {

        // Método principal que será executado quando o programa iniciar

        String path = "C:\\temp\\in.txt";
        // Define o caminho do arquivo que será lido

        FileReader fr = null;
        // Declara a variável FileReader, inicialmente nula

        BufferedReader br = null;
        // Declara a variável BufferedReader, inicialmente nula

        try {
            // Bloco try para tentar executar o código que pode gerar exceções

            fr = new FileReader(path);
            // Inicializa o FileReader com o caminho do arquivo

            br = new BufferedReader(fr);
            // Inicializa o BufferedReader com o FileReader para ler o arquivo de forma eficiente

            String line = br.readLine();
            // Lê a primeira linha do arquivo

            while (line != null) {
                // Loop enquanto a linha lida não for nula (ou seja, enquanto não atingir o final do arquivo)

                System.out.println(line);
                // Imprime a linha lida no console

                line = br.readLine();
                // Lê a próxima linha do arquivo
            }
        } catch (IOException e) {
            // Captura e trata exceções de entrada/saída

            System.out.println("Error: " + e.getMessage());
            // Imprime a mensagem de erro no console
        } finally {
            // Bloco finally para garantir que os recursos sejam fechados, mesmo se ocorrer uma exceção

            try {
                if (br != null)
                    br.close();
                // Fecha o BufferedReader se ele não for nulo

                if (fr != null)
                    fr.close();
                // Fecha o FileReader se ele não for nulo
            } catch (IOException e) {
                // Captura e trata exceções de entrada/saída ao fechar os recursos

                e.printStackTrace();
                // Imprime a pilha de erros no console
            }
        }
    }
}