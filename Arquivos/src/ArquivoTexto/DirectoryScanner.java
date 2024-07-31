package ArquivoTexto;

// Define o pacote em que a classe está localizada

import java.io.File;
import java.util.Scanner;

// Importa as classes necessárias para manipulação de arquivos e leitura de entrada

public class DirectoryScanner {
    
    // Define a classe pública DirectoryScanner

    public static void main(String[] args) {
        
        // Método principal que será executado quando o programa iniciar

        Scanner sc = new Scanner(System.in);
        // Cria um Scanner para leitura de entrada do usuário

        System.out.println("Enter a folder path: ");
        // Solicita ao usuário que informe o caminho de uma pasta

        String strPath = sc.nextLine();
        // Lê o caminho da pasta informado pelo usuário

        File path = new File(strPath);
        // Cria um objeto File com o caminho da pasta informado

        File[] folders = path.listFiles(File::isDirectory);
        // Lista todos os diretórios dentro da pasta informada

        System.out.println("FOLDERS:");
        // Imprime "FOLDERS:" no console

        for (File folder : folders) {
            // Itera sobre cada diretório encontrado

            System.out.println(folder);
            // Imprime o diretório no console
        }

        File[] files = path.listFiles(File::isFile);
        // Lista todos os arquivos dentro da pasta informada

        System.out.println("FILES:");
        // Imprime "FILES:" no console

        for (File file : files) {
            // Itera sobre cada arquivo encontrado

            System.out.println(file);
            // Imprime o arquivo no console
        }

        boolean success = new File(strPath + "\\subdir").mkdir();
        // Cria um novo diretório "subdir" dentro da pasta informada

        System.out.println("Directory created successfully: " + success);
        // Imprime se o diretório foi criado com sucesso

        sc.close();
        // Fecha o Scanner
    }
}