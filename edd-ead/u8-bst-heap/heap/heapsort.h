#include <stdio.h>

void swap(int*a, int* b){
  int aux = *a;
  *a = *b;
  *b = aux;
}

// imprime o vetor
void printArray(int arr[], int n)
{
    for (int i=0; i<n; ++i)
        printf("%d ", arr[i]);
    printf("\n");
}

// imprime o vetor
void printArrayInterval(int arr[], int from, int n)
{
    for (int i=from; i<n; ++i)
        printf("%d ", arr[i]);
    printf("\n");
}

//Realizar a heapificação
void heapify(int arr[], int n, int i)
{
    int largest = i;  // maior nó sendo a raiz
    int l = 2*i + 1;  // left = 2*i + 1
    int r = 2*i + 2;  // right = 2*i + 2
 
    // Se filho da esquerda for maior que pai
    if (l < n && arr[l] > arr[largest])
        largest = l; // esquerda é o maior
 
    // Se filho da direita é maior que o maior até o momento
    if (r < n && arr[r] > arr[largest])
        largest = r; // ele será o maior
 
    // Se maior não for o nó pai, ele tem que ser trocado
    if (largest != i)
    {
        swap(&arr[i], &arr[largest]);
 
        // Recursivamente, heapificar as subárvores do nó pai
        heapify(arr, n, largest);
    }
}
 
// executa o heapsort
void heapSort(int arr[], int n)
{
    // Constroi o heap 
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
 
    // Extrai elemento por elemento do heap
    for (int i=n-1; i>=0; i--)
    {
        // Move o atual pai para o fim
        swap(&arr[0], &arr[i]);
        printArrayInterval(arr, i, n);
        printf("\t Selecionou: %d\n\n", arr[i]);
        // executa o max heapify no restante da árvore
        heapify(arr, i, 0);
    }
}
 
