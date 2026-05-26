public class Produto {

    int id;
    String nome;
    int quantidade;
    double preco;
    String categoria;
    String status;

    public Produto(
        int id,
        String nome,
        int quantidade,
        double preco,
        String categoria,
        String status
    ){

        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
        this.status = status;
    }

    public void mostrarProduto(){
        System.out.println(
            "\nID: " + id +
            "\nNome: " + nome +
            "\nQuantidade: " + quantidade +
            "\nPreço: R$" + preco +
            "\nCategoria: " + categoria +
            "\nStatus: " + status
        );
    }

}