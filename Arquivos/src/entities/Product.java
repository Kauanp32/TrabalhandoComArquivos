package entities;

// Define o pacote em que a classe está localizada

public class Product {
    
    // Define a classe pública Product

    private String name;
    // Declaração do campo privado name (nome do produto)

    private Double price;
    // Declaração do campo privado price (preço do produto)

    private Integer quantity;
    // Declaração do campo privado quantity (quantidade do produto)

    public Product(String name, Double price, Integer quantity) {
        // Construtor da classe Product que inicializa os campos name, price e quantity

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        // Método getter para o campo name

        return name;
    }

    public void setName(String name) {
        // Método setter para o campo name

        this.name = name;
    }

    public Double getPrice() {
        // Método getter para o campo price

        return price;
    }

    public void setPrice(Double price) {
        // Método setter para o campo price

        this.price = price;
    }

    public Integer getQuantity() {
        // Método getter para o campo quantity

        return quantity;
    }

    public void setQuantity(Integer quantity) {
        // Método setter para o campo quantity

        this.quantity = quantity;
    }
    
    public double total() {
        // Método que calcula o total (preço multiplicado pela quantidade)

        return price * quantity;
    }
}