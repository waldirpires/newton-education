#include <stdio.h>

#define NAO_ENCONTRADO -1
#define SIZE 6

// pesquisa binaria recursiva
int buscaBinaria(int arr[], int l, int r, int x){
   if (r >= l) {
        // calculo do EPM
        int mid = l + (r - l)/2; 
        if (arr[mid] == x) // se for no meio  
            return mid; 
        // se for menor, ir para a esquerda
        if (arr[mid] > x) 
            return buscaBinaria(arr, l, mid-1, x);
        // senão é maior, ir para a direita
        return buscaBinaria(arr, mid+1, r, x);
   }
   return -1;
}


int main(void) {
  // declaracao
  int a[] = {1, 2, 3, 4, 7, 9};
  int k, r;

  // exibe o vetor
  for (int i = 0; i < SIZE; i++) {
    printf("a[%d] = %d\n", i, a[i]);
  }
  printf("\n");

  // entrada
  printf("Digite um número inteiro: ");
  scanf("%d", &k);
  // processamento
  // vetor, lado esquerdo (0), lado direito (tam-1), chave de busca
  r = buscaBinaria(a, 0, SIZE-1, k);
  // saída
  printf("\nResultado: %d\n", r);

  if (r == NAO_ENCONTRADO) {
    printf("Chave informada não encontrada");
  } else {
    printf("Chave informada encontrada na posição %d", r);
  }
  return 0;
}