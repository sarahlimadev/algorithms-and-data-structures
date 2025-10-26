package Exercise_List_02_Linear_Lists_and_Ordering;

import java.util.Scanner;

public class L2Q4 {
    private static int contadorTrocar = 0;
    private static int contadorMaxHeapify = 0;
    
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
    
    public static void maxHeapify(int[] vetor, int tamanho, int i) {
        System.out.println("maxheapfy " + i);
        contadorMaxHeapify++;
        
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        int maior = i;
        
        if (esquerda < tamanho && vetor[esquerda] > vetor[maior]) {
            maior = esquerda;
        }
        
        if (direita < tamanho && vetor[direita] > vetor[maior]) {
            maior = direita;
        }
        
        if (maior != i) {
            trocar(vetor, i, maior);
            imprimirVetor(vetor);
            maxHeapify(vetor, tamanho, maior);
        } else {
            imprimirVetor(vetor);
        }
    }
    
    public static void construirMaxHeap(int[] vetor, int tamanho) {
        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            maxHeapify(vetor, tamanho, i);
        }
    }
    
    public static void heapsort(int[] vetor) {
        int tamanho = vetor.length;
        
        construirMaxHeap(vetor, tamanho);
        
        System.out.println("\nVetor apos construirMaxHeap:");
        imprimirVetor(vetor);
        
        for (int i = tamanho - 1; i > 0; i--) {
            trocar(vetor, 0, i);
            maxHeapify(vetor, i, 0);
        }
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
        
        System.out.println("\nExecutando Heapsort...\n");
        heapsort(vetor);
        
        System.out.println("\nNumero total de vezes que o procedimento trocar foi utilizado: " + contadorTrocar);
        System.out.println("Numero total de vezes que o procedimento maxHeapfy foi utilizado: " + contadorMaxHeapify);
        
        scanner.close();
    }
}