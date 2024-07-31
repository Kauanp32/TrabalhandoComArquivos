package ArquivoTexto;

// Define o pacote em que a classe está localizada

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

// Importa as classes necessárias para manipulação de arquivos, tratamento de exceções, formatação, listas, localização e entrada do usuário
// Importa a classe Product, que deve estar definida no pacote entities

public class Produtos {
    
    // Define a classe pública Produtos

    public static void main(String[] args) throws ParseException {
        
        // Método principal que será executado quando o programa iniciar

        Locale.setDefault(Locale.US);
        // Define o padrão de localidade para os EUA (para usar ponto como separador decimal)

        Scanner sc = new Scanner(System.in);
        // Cria um Scanner para leitura de entrada do usuário

        List<Product> list = new ArrayList<>();
        // Cria uma lista para armazenar objetos do tipo Product

        System.out.println("Enter file path: ");
        // Solicita ao usuário que informe o caminho do arquivo

        String sourceFileStr = sc.nextLine();
        // Lê o caminho do arquivo informado pelo usuário

        File sourceFile = new File(sourceFileStr);
        // Cria um objeto File com o caminho do arquivo informado

        String sourceFolderStr = sourceFile.getParent();
        // Obtém o diretório pai do arquivo informado

        boolean success = new File(sourceFolderStr + "\\out").mkdir();
        // Cria um novo diretório "out" no diretório pai do arquivo

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
        // Define o caminho do arquivo de saída "summary.csv" dentro do diretório "out"

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
            // Bloco try-with-resources para garantir que o BufferedReader seja fechado após o uso
            // Inicializa o BufferedReader com o FileReader para ler o arquivo de entrada

            String itemCsv = br.readLine();
            // Lê a primeira linha do arquivo

            while (itemCsv != null) {
                // Loop enquanto a linha lida não for nula (ou seja, enquanto não atingir o final do arquivo)

                String[] fields = itemCsv.split(",");
                // Divide a linha lida em campos separados por vírgula

                String name = fields[0];
                // Obtém o nome do produto

                double price = Double.parseDouble(fields[1]);
                // Obtém o preço do produto e converte para double

                int quantity = Integer.parseInt(fields[2]);
                // Obtém a quantidade do produto e converte para int

                list.add(new Product(name, price, quantity));
                // Adiciona um novo objeto Product à lista

                itemCsv = br.readLine();
                // Lê a próxima linha do arquivo
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
                // Bloco try-with-resources para garantir que o BufferedWriter seja fechado após o uso
                // Inicializa o BufferedWriter com o FileWriter para escrever no arquivo de saída

                for (Product item : list) {
                    // Itera sobre cada produto na lista

                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    // Escreve o nome do produto e o total formatado com duas casas decimais no arquivo de saída

                    bw.newLine();
                    // Insere uma nova linha no arquivo de saída
                }

                System.out.println(targetFileStr + " CREATED!");
                // Imprime uma mensagem indicando que o arquivo de saída foi criado

            } catch (IOException e) {
                // Captura e trata exceções de entrada/saída ao escrever o arquivo

                System.out.println("Error writing file: " + e.getMessage());
                // Imprime a mensagem de erro no console
            }

        } catch (IOException e) {
            // Captura e trata exceções de entrada/saída ao ler o arquivo

            System.out.println("Error reading file: " + e.getMessage());
            // Imprime a mensagem de erro no console
        }

        sc.close();
        // Fecha o Scanner
    }
}