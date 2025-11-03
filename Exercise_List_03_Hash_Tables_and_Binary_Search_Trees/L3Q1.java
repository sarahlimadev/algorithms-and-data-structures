package Exercise_List_03_Hash_Tables_and_Binary_Search_Trees;

class No {
    int chave;
    No esquerda;
    No direita;

    public No(int valor) {
        this.chave = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinariaBusca {
    private No raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No atual, int valor) {
        if (atual == null) {
            return false;
        }
        if (valor == atual.chave) {
            return true;
        }
        if (valor < atual.chave) {
            return buscarRecursivo(atual.esquerda, valor);
        } else {
            return buscarRecursivo(atual.direita, valor);
        }
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }
        if (valor < atual.chave) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.chave) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        }
        return atual;
    }

    public No sucessor(No no) {
        if (no == null) {
            return null;
        }
        if (no.direita != null) {
            return encontrarMinimo(no.direita);
        }
        return null;
    }

    private No encontrarMinimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No atual, int valor) {
        if (atual == null) {
            return null;
        }
        if (valor < atual.chave) {
            atual.esquerda = removerRecursivo(atual.esquerda, valor);
        } else if (valor > atual.chave) {
            atual.direita = removerRecursivo(atual.direita, valor);
        } else {
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }
            if (atual.esquerda == null) {
                return atual.direita;
            }
            if (atual.direita == null) {
                return atual.esquerda;
            }
            No sucessorNo = sucessor(atual);
            atual.chave = sucessorNo.chave;
            atual.direita = removerRecursivo(atual.direita, sucessorNo.chave);
        }
        return atual;
    }
}