#include <stdio.h>
#include <stdlib.h>
#include "tad-lista.h"

#define CAPACIDADE 10

int main(void) {
  // declaracao de variáveis
  TipoLista lista; 
  TipoItem item;

  // criar uma lista vazia
  FLVazia(&lista, CAPACIDADE);

  RetiraLista(&lista, &item);

  // verificar se está vazia
  printf("Vazia: %d\n", VaziaLista(lista));

  // verificar se está cheia
  printf("Cheia: %d\n", CheiaLista(lista));

  // obter o tamanho
  printf("Tamanho: %d\n", TamanhoLista(lista));

  // imprimir a lista
  ImprimirLista(lista);

  // inseir alguns itens
  for (int i = 1; i <= 5; i++) {
    item.Chave = i;
    InsereLista(item, &lista);
    printf("Inseriu: %d\n", i);
  }
  printf("\n");

  // obter o tamanho
  printf("Tamanho: %d\n", TamanhoLista(lista));

  // imprimir a lista
  ImprimirLista(lista);

  RetiraLista(&lista, &item);

  // imprimir a lista
  ImprimirLista(lista);
  return 0;
}