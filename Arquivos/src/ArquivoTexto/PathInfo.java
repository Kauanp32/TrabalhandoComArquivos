package ArquivoTexto;

// Define o pacote em que a classe está localizada

import java.io.File;
import java.util.Scanner;

// Importa as classes necessárias para manipulação de arquivos e entrada do usuário

public class PathInfo {
    
    // Define a classe pública PathInfo

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

        System.out.println("getPath: " + path.getPath());
        // Imprime o caminho completo do arquivo ou pasta

        System.out.println("getParent: " + path.getParent());
        // Imprime o diretório pai do arquivo ou pasta

        System.out.println("getName: " + path.getName());
        // Imprime o nome do arquivo ou pasta

        sc.close();
        // Fecha o Scanner
    }
}