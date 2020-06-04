#include <stdio.h>
#include "tad-lista-dupl-enc.h"

int main(void) {
  int c = 1;
  TipoListaDuplEnc lista; TipoItem item; int i; 
  TipoChave chave;

  FLVazia(&lista, 5);

  while (c != 0) {

    printf("LISTA DUPLAMENTE ENCADEADA\n\n");
    printf("====================================");

    printf("1: Esvaziar lista\n");
    printf("2: Imprime lista\n");
    printf("3: Imprime lista invertida\n");
    printf("4: Insere item na lista\n");
    printf("5: Retira item da lista\n");
    printf("6: Retira item específico da lista\n");
    printf("7: Inserir item ordenado\n");
    printf("0: Sair\n\n");

    printf("Digite sua opção: ");
    scanf("%i", &c);

    switch(c) {
      case 1:
        // criar a lista
        FLVazia(&lista, 5);
      break;
      case 2:
        // imprimir a lista
        ImprimeLista(lista);
      break;
      case 3:
        ImprimeListaInvertida(lista);
      break;
      case 4:
        printf("Digite o valor desejado para inserção: ");
        scanf("%i", &item.Chave);
        // adicionar um item
        InsereLista(item, &lista);
      break;
      case 5:
        RetiraLista(&lista, &item);
      break;
      case 6:
        printf("Digite o valor desejado para retirada: ");
        scanf("%i", &chave);
        RetiraListaItemChave(&lista, &item, chave);
      break;
      case 7:
        printf("Digite o valor desejado para inserção: ");
        scanf("%i", &item.Chave);
        InsereListaOrdenado(item, &lista);
      break;
    }
  }
  return 0;
}