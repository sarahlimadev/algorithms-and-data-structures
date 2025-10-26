import java.util.Scanner;

class ListaOrdenada {
    private int[] dados;
    private int elementos; 
    private int capacidade; 
    
    public ListaOrdenada(int capacidadeInicial) {
        this.dados = new int[capacidadeInicial];
        this.elementos = 0;
        this.capacidade = capacidadeInicial;
    }

    public void visualizar() {

        System.out.print("Lista: [");

        for (int i = 0; i < capacidade; i++) {
            if (i < elementos) {
                System.out.print(dados[i]);
            }
            else {
                System.out.print("NIL");
            }
            if (i < capacidade - 1) {
                System.out.print(", ");
            }
        }

        System.out.print("]");

    }

    public int buscar(int valor) {
        for (int i = 0; i < elementos; i++) {
            if (dados[i] == valor) {
                return i;
            }
            if (dados[i] > valor) {
                return -1;
            }
        }
        return -1;
    }

    public void inserir(int valor) {
        if (elementos == capacidade) {
            expandir();
        }

        int posicao = 0;

        for (int i = 0; i < elementos; i++) {
            if (dados[i] < valor) {
                posicao = i + 1;
            } else {
                break;
            }
        }

        for (int i = elementos; i > posicao; i--) {
            dados[i] = dados[i - 1];
        }

        dados[posicao] = valor;
        elementos++;

        System.out.print(" Elemento " + valor + " inserido na posicao " + posicao);

    }

    private void expandir() {

        int novaCapacidade = capacidade * 2;
        int[] novoArray = new int[novaCapacidade];

        for (int i = 0; i < elementos; i++) {
                novoArray[i] = dados[i];
        }

        dados = novoArray;
        capacidade = novaCapacidade;

        System.out.print("Lista expandida! Nova capacidade: ." + capacidade);

    }

    public void remover(int valor) {
    
        int posicao = buscar(valor);
    
        if (posicao == -1) {
            System.out.println("ERRO: Elemento " + valor + " não encontrado na lista!");
            return; 
        }
    
        for (int i = posicao; i < elementos; i++) {
            dados[i] = dados[i + 1];
        }
    
        elementos--;
    
        System.out.println("Elemento " + valor + " removido com sucesso da posição " + posicao);

    }

}

public class L2Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe a capacidade inicial da lista (M): ");
        int m = scanner.nextInt();
        
        ListaOrdenada lista = new ListaOrdenada(m);
        
        int opcao = 0;
        
        while (opcao != 5) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Visualizar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Inserir");
            System.out.println("4 - Remover");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            
            if (opcao == 1) {
                lista.visualizar();
                
            } else if (opcao == 2) {
                System.out.print("Informe o valor a buscar: ");
                int valor = scanner.nextInt();
                int posicao = lista.buscar(valor);
                
                if (posicao != -1) {
                    System.out.println("Elemento " + valor + " encontrado na posicao " + posicao);
                } else {
                    System.out.println("Elemento " + valor + " nao encontrado na lista");
                }
                
            } else if (opcao == 3) {
                System.out.print("Informe o valor a inserir: ");
                int valor = scanner.nextInt();
                lista.inserir(valor);
                
            } else if (opcao == 4) {
                System.out.print("Informe o valor a remover: ");
                int valor = scanner.nextInt();
                lista.remover(valor);
                
            } else if (opcao == 5) {
                System.out.println("Encerrando programa...");
                
            } else {
                System.out.println("Opcao invalida!");
            }
        }
        
        scanner.close();
    }
}