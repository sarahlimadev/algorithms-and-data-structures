package Exercise_List_03_Hash_Tables_and_Binary_Search_Trees;

class No {
    int chave;
    No proximo;
    
    public No(int chave) {
        this.chave = chave;
        this.proximo = null;
    }
}

class Celula {
    int chave;
    boolean ocupada;
    No lista;
    
    public Celula() {
        this.chave = -1;
        this.ocupada = false;
        this.lista = null;
    }
}

class TabelaHash {
    Celula[] tabela;
    int tamanho;
    int elementos;
    
    public TabelaHash(int m) {
        this.tamanho = m;
        this.elementos = 0;
        this.tabela = new Celula[m];
        
        for (int i = 0; i < m; i++) {
            this.tabela[i] = new Celula();
        }
    }
    
    private int funcaoHash(int chave) {
        return chave % this.tamanho;
    }
    
    private boolean tabelaCheia() {
        return this.elementos == this.tamanho;
    }
    
    private void inserirNaLista(int indice, int chave) {
        No novo = new No(chave);
        novo.proximo = this.tabela[indice].lista;
        this.tabela[indice].lista = novo;
    }
    
    public void inserir(int chave) {
        int indice = funcaoHash(chave);
        
        if (!tabelaCheia()) {
            int i = 0;
            int posicao;
            
            while (i < this.tamanho) {
                posicao = (indice + i) % this.tamanho;
                
                if (!this.tabela[posicao].ocupada) {
                    this.tabela[posicao].chave = chave;
                    this.tabela[posicao].ocupada = true;
                    this.elementos++;
                    System.out.println("Chave " + chave + " inserida na posicao " + posicao + " (Linear Probing)");
                    return;
                }
                i++;
            }
        }
        
        System.out.println("Tabela cheia! Usando Closed Address Hashing para chave " + chave);
        inserirNaLista(indice, chave);
        System.out.println("Chave " + chave + " inserida na lista da posicao " + indice + " (Chaining)");
    }
    
    public int buscar(int chave) {
        int indice = funcaoHash(chave);
        int i = 0;
        int posicao;
      
        while (i < this.tamanho) {
            posicao = (indice + i) % this.tamanho;
            
            if (this.tabela[posicao].ocupada && this.tabela[posicao].chave == chave) {
                return posicao;
            }
            i++;
        }
        
        No atual = this.tabela[indice].lista;
        while (atual != null) {
            if (atual.chave == chave) {
                return indice;
            }
            atual = atual.proximo;
        }
        
        return -1; 
    }
    
    public void imprimirTabela() {
        System.out.println("\n=== Tabela Hash ===");
        System.out.println("Tamanho: " + this.tamanho + ", Elementos: " + this.elementos + "\n");
        
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print("Posicao " + i + ": ");
            
            if (this.tabela[i].ocupada) {
                System.out.print("[" + this.tabela[i].chave + "]");
            } else {
                System.out.print("[vazia]");
            }
            
            if (this.tabela[i].lista != null) {
                System.out.print(" -> Lista: ");
                No atual = this.tabela[i].lista;
                while (atual != null) {
                    System.out.print(atual.chave + " ");
                    atual = atual.proximo;
                }
            }
            
            System.out.println();
        }
        System.out.println();
    }
}