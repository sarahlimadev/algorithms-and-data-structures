# Algoritmos e Estruturas de Dados

Repositório contendo implementações de algoritmos fundamentais e estruturas de dados em Java, desenvolvido como parte de exercícios acadêmicos.

## 📋 Conteúdo

### Lista de Exercícios 02 - Listas Lineares e Algoritmos de Ordenação

Esta lista contém implementações de listas ordenadas e algoritmos clássicos de ordenação com rastreamento detalhado de execução.

#### **L2Q1** - Implementação de Lista Ordenada
Implementação de uma lista ordenada com expansão dinâmica contendo as seguintes operações:
- **Inserir**: Adiciona elementos mantendo a ordem crescente
- **Buscar**: Busca em lista ordenada
- **Remover**: Remove elementos por valor
- **Visualizar**: Exibe o estado atual da lista
- **Expansão Dinâmica**: Dobra automaticamente a capacidade quando cheia

**Características Principais:**
- Inserção eficiente mantendo a ordenação
- Gerenciamento automático de capacidade
- Menu interativo para operações

#### **L2Q2** - Mergesort com Rastreamento de Execução
Implementação completa do algoritmo Mergesort com registro detalhado:
- Imprime cada chamada recursiva (empilhamento/desempilhamento)
- Mostra operações de merge passo a passo
- Conta o número total de chamadas recursivas
- Exibe estados intermediários do vetor

**Complexidade:** O(n log n) em todos os casos

#### **L2Q3** - Quicksort com Rastreamento de Execução
Implementação do algoritmo Quicksort usando o último elemento como pivô:
- Rastreia operações de particionamento
- Conta trocas de elementos
- Mostra a pilha de chamadas recursivas
- Exibe o estado do vetor após cada partição

**Complexidade:** 
- Média: O(n log n)
- Pior caso: O(n²)

#### **L2Q4** - Heapsort com Rastreamento de Execução
Implementação do Heapsort usando max-heap:
- Constrói max-heap a partir de vetor desordenado
- Rastreia operações de maxHeapify
- Conta trocas e chamadas ao heapify
- Mostra os passos de transformação

**Complexidade:** O(n log n) em todos os casos

## 🚀 Como Executar

### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior
- Terminal/Prompt de Comando

### Compilação e Execução

```bash
# Navegue até o diretório dos exercícios
cd Exercise_List_02_Linear_Lists_and_Ordering

# Compile o programa desejado
javac L2Q1.java  # ou L2Q2.java, L2Q3.java, L2Q4.java

# Execute o programa
java L2Q1  # ou L2Q2, L2Q3, L2Q4
```

### Exemplos de Uso

**L2Q1 - Lista Ordenada:**
```
Informe a capacidade inicial da lista (M): 5
=== MENU ===
1 - Visualizar
2 - Buscar
3 - Inserir
4 - Remover
5 - Sair
```

**L2Q2, L2Q3, L2Q4 - Algoritmos de Ordenação:**
```
Informe o tamanho do vetor (M): 6
Informe os 6 elementos do vetor:
Elemento 0: 5
Elemento 1: 2
Elemento 2: 8
...
```

## 📊 Comparação de Algoritmos

| Algoritmo | Complexidade de Tempo | Complexidade de Espaço | Estável | In-place |
|-----------|----------------------|------------------------|---------|----------|
| Mergesort | O(n log n) | O(n) | Sim | Não |
| Quicksort | O(n log n)* | O(log n) | Não | Sim |
| Heapsort | O(n log n) | O(1) | Não | Sim |

*Caso médio. Pior caso: O(n²)

## 🎯 Objetivos de Aprendizado

- Compreensão de estruturas de dados ordenadas
- Estratégias de divisão e conquista (Mergesort, Quicksort)
- Estrutura de dados Heap e suas propriedades
- Análise de complexidade de algoritmos
- Recursão e visualização da pilha de chamadas
- Trade-offs entre diferentes abordagens de ordenação

## 📝 Observações

- Todas as implementações incluem rastreamento detalhado de execução para fins educacionais
- A validação de entrada poderia ser aprimorada para uso em produção
- O código prioriza clareza e valor educacional sobre otimização
- Cada programa inclui contadores de operações para analisar o comportamento do algoritmo

## 🔧 Melhorias Futuras

- [ ] Adicionar testes unitários
- [ ] Implementar algoritmos de ordenação adicionais (Insertion Sort, Selection Sort)
- [ ] Adicionar utilitários de benchmark de desempenho
- [ ] Criar ferramentas de visualização para execução de algoritmos
- [ ] Implementar versões iterativas dos algoritmos recursivos
- [ ] Adicionar validação de entrada e tratamento de erros

## 📚 Referências

- Cormen, T. H., et al. "Introduction to Algorithms" (CLRS)
- Sedgewick, R. "Algorithms"
- Literatura clássica sobre algoritmos e estruturas de dados

---

**Autora:** Sarah Lima
**Disciplina:** Algoritmos e Estruturas de Dados  
**Linguagem:** Java
