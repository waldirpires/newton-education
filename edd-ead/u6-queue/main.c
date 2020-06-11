#include <stdio.h>
#include "tad-fila.h"

int main(void) {
  TipoFila fila; 
  TipoItem item; 
  int i; 
  int chaves[] = {10, 11, 12, 45, 1};

  FFVazia(&fila, 5); // Inicializa a fila
  printf("Fila vazia?: %d\n", VaziaFila(fila)); // fila vazia?
  item = FrenteFila(&fila); // elemento na frente da fila

  printf("Elemento na frente da fila: %d\n", item.Chave);

  for (i = 0; i < 5; i++){ /*Enfileira cada chave */
    item.Chave = chaves[i]; Enfileira(item, &fila);
    printf("Enfileirou: %3d \n", item.Chave);
    ImprimeFila(fila);
  }
  
  int tam = TamanhoFila(fila); // tamanho da fila

  printf("Tamanho da fila: %d \n", tam);

  printf("Fila vazia?: %d\n", VaziaFila(fila)); // fila vazia?
  
  item = FrenteFila(&fila); // elemento na frente da fila
  printf("Elemento na frente da fila: %d\n", item.Chave);
  
  for (i = 0; i < tam; i++) { /*Desenfileira cada chave */
    Desenfileira(&fila, &item);
    printf("Desenfileirou: %3d \n", item.Chave);
    ImprimeFila(fila);
  }
  
  printf("Tamanho da fila: %d\n", TamanhoFila(fila)); // tamanho da pilha
  
  printf("Fila vazia?: %d\n", VaziaFila(fila)); // fila vazia?

  return 0;
}