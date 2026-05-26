import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        ArrayList<Produto> estoque = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n=== SISTEMA DE ESTOQUE ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Ver estoque");
            System.out.println("3 - Remover produto");
            System.out.println("4 - Atualizar quantidade");
            System.out.println("5 - Relatorio");
            System.out.println("6 - Buscar produto");
            System.out.println("7 - Estoque baixo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = ler.nextInt();
            ler.nextLine();

            switch(opcao){

                case 1:

                    System.out.print("ID: ");
                    int id = ler.nextInt();
                    ler.nextLine();

                    System.out.print("Nome: ");
                    String nome = ler.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = ler.nextInt();

                    System.out.print("Preço: ");
                    double preco = ler.nextDouble();
                    ler.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = ler.nextLine();

                    Produto novoProduto =
                    new Produto(
                            id,
                            nome,
                            quantidade,
                            preco,
                            categoria,
                            "Disponível"
                    );

                    estoque.add(novoProduto);

                    System.out.println("Produto cadastrado!");
                    break;


                case 2:

                    if(estoque.isEmpty()){
                        System.out.println("Estoque vazio.");
                    }

                    for(Produto p : estoque){
                        p.mostrarProduto();
                    }

                    break;

                case 3:

                    System.out.print("Digite o ID do produto para remover: ");
                    int idRemover = ler.nextInt();

                    boolean removido = false;

                    for(int i = 0; i < estoque.size(); i++){

                        if(estoque.get(i).id == idRemover){

                            estoque.remove(i);

                            System.out.println("Produto removido com sucesso!");
                            removido = true;
                            break;

                        }

                    }

                    if(!removido){
                        System.out.println("Produto não encontrado.");
                    }

                    break; 
                    
                case 4:

                    System.out.print("Digite o ID do produto: ");
                    int idAtualizar = ler.nextInt();

                    boolean encontrado = false;

                    for(Produto p : estoque){

                        if(p.id == idAtualizar){

                            System.out.print(
                                "Nova quantidade: "
                            );

                            p.quantidade =
                            ler.nextInt();

                            System.out.println(
                                "Quantidade atualizada!"
                            );

                            encontrado = true;

                            break;
                        }

                    }

                    if(!encontrado){

                        System.out.println(
                            "Produto não encontrado."
                        );

                    }

                    break;

                case 5:

                    int totalProdutos = estoque.size();
                    int totalQuantidade = 0;
                    double valorTotal = 0;

                    for(Produto p : estoque){

                        totalQuantidade += p.quantidade;

                        valorTotal +=
                        p.quantidade * p.preco;

                    }

                    System.out.println(
                        "\n=== RELATORIO ==="
                    );

                    System.out.println(
                        "Produtos cadastrados: "
                        + totalProdutos
                    );

                    System.out.println(
                        "Quantidade total: "
                        + totalQuantidade
                    );

                    System.out.println(
                        "Valor total estoque: R$ "
                        + valorTotal
                    );

                    break;  
                    
                case 6:

                    System.out.print(
                        "Digite o ID do produto: "
                    );

                    int idBusca =
                    ler.nextInt();

                    boolean achou =
                    false;

                    for(Produto p : estoque){

                        if(p.id == idBusca){

                            p.mostrarProduto();

                            achou = true;

                            break;
                        }

                    }

                    if(!achou){

                        System.out.println(
                            "Produto não encontrado."
                        );

                    }

                    break;
                    
                case 7:

                    boolean baixo =
                    false;

                    System.out.println(
                        "\n=== ESTOQUE BAIXO ==="
                    );

                    for(Produto p : estoque){

                        if(p.quantidade < 5){

                            p.mostrarProduto();

                            baixo = true;

                        }

                    }

                    if(!baixo){

                        System.out.println(
                            "Nenhum produto com estoque baixo."
                        );

                    }

                    break;    


                case 0:
                    System.out.println("Encerrando...");
                    break;


                default:
                    System.out.println("Opção inválida");

            }

        }while(opcao != 0);

        ler.close();

    }

}