import java.util.Scanner;

public class L2Q3 {
    private static int contadorTrocar = 0;
    
    public static void imprimirVetor(int[] vetor) {
        System.out.print("[");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]);
            if (i < vetor.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
        contadorTrocar++;
    }
    
    public static int particionar(int[] vetor, int p, int r) {
        System.out.println("particionar " + p + " " + r);
        
        int pivo = vetor[r];
        int i = p - 1;
        
        for (int j = p; j < r; j++) {
            if (vetor[j] <= pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }
        
        trocar(vetor, i + 1, r);
        
        imprimirVetor(vetor);
        
        return i + 1;
    }
    
    public static void quicksort(int[] vetor, int p, int r) {
        System.out.println("quicksort " + p + " " + r + ": empilhado!");
        
        if (p < r) {
            int q = particionar(vetor, p, r);
            quicksort(vetor, p, q - 1);
            quicksort(vetor, q + 1, r);
        }
        
        System.out.println("quicksort " + p + " " + r + ": dsempilhado!");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe o tamanho do vetor (M): ");
        int m = scanner.nextInt();
        
        int[] vetor = new int[m];
        
        System.out.println("Informe os " + m + " elementos do vetor:");
        for (int i = 0; i < m; i++) {
            System.out.print("Elemento " + i + ": ");
            vetor[i] = scanner.nextInt();
        }
        
        System.out.println("\nVetor original:");
        imprimirVetor(vetor);
        
        System.out.println("\nExecutando Quicksort...\n");
        quicksort(vetor, 0, m - 1);
        
        System.out.println("\nNumero total de vezes que o procedimento trocar foi utilizado: " + contadorTrocar);
        
        scanner.close();
    }
}