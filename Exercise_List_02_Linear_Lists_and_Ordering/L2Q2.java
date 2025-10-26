import java.util.Scanner;

public class L2Q2 {
    private static int contadorMergesort = 0;
    
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
    
    public static void merge(int[] vetor, int p, int q, int r) {
        System.out.println("merge " + p + " " + q + " " + r);
        
        int n1 = q - p + 1;
        int n2 = r - q;
        
        int[] esquerda = new int[n1];
        int[] direita = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            esquerda[i] = vetor[p + i];
        }
        
        for (int j = 0; j < n2; j++) {
            direita[j] = vetor[q + 1 + j];
        }
        
        int i = 0;
        int j = 0;
        int k = p;
        
        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            vetor[k] = esquerda[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            vetor[k] = direita[j];
            j++;
            k++;
        }
        
        imprimirVetor(vetor);
    }
    
    public static void mergesort(int[] vetor, int p, int r) {
        System.out.println("mergesort " + p + " " + r + ": empilhado!");
        contadorMergesort++;
        
        if (p < r) {
            int q = (p + r) / 2;
            mergesort(vetor, p, q);
            mergesort(vetor, q + 1, r);
            merge(vetor, p, q, r);
        }
        
        System.out.println("mergesort " + p + " " + r + ": dsempilhado!");
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
        
        System.out.println("\nExecutando Mergesort...\n");
        mergesort(vetor, 0, m - 1);
        
        System.out.println("\nNumero total de chamadas ao mergesort: " + contadorMergesort);
        
        scanner.close();
    }
}