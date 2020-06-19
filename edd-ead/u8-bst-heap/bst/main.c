#include <stdio.h>
#include "tad-arvore-abp.h"

void pausar() {
  int c;

  fflush(stdin);
  printf("\nAperte 1 para continuar . . .");
  scanf("%d", &c);
}

void exibirMenu() {
    // limpando a tela
    printf("\033[0;0H\033[2J");
    printf("EdD TipoArvore BST: \n");
    printf("=============================\n");
    printf("1. Inicializar\n");
    printf("2. Inserir\n");
    printf("3. Remover\n");
    printf("4. Pesquisar\n");
    printf("5. Pŕe-Ordem\n");
    printf("6. Central\n");
    printf("7. Pós-Ordem\n");
    // Minimo
    // Máximo
    // Grau da árvore
    // Grau de um nó
    // Distância entre dois nós
    // Quantidade de filhos de um nó
    // Largura da árvore
    // Profundidade da árvore
    printf("-1. Sair\n\n");

    printf("Digite sua opção: ");
}

int main(void) {
  TipoApontador a;
  TipoChave c;
  int op = 0, i;

  while (op != -1) {
    exibirMenu();
    scanf("%d", &op);

    switch(op) {
      case 1: // inicializar
        printf("Inicialização da árvore:\n");

        inicializar(&a); 
      break;
      case 2: // inserir
        printf("Digite a chave desejada para inserção: ");
        scanf("%d", &c);

        inserir(&a, c);
      break;
      case 3: // remover
        printf("Digite a chave desejada para remoção: ");
        scanf("%d", &c);

        retira(c, &a);
      break;
      case 4: // Pesquisar
        printf("Digite a chave desejada para pesquisa: ");
        scanf("%d", &c);

        i = pesquisar(a, c);

        if (i == CHAVE_NAO_EXISTE) {
          printf("Chave solicitada não existe.");
        } else {
          printf("Chave solicitada encontrada com sucesso.");
        }
      break;
      case 5: // pre-ordem
        preOrdem(a);
      break;
      case 6: // central
        central(a);
      break;
      case 7: // pos-ordem
        posOrdem(a);
      break;
    }

    pausar();
  }

  return 0;
}