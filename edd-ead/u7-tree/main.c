#include <stdio.h>
#include "tad-arvore.h"

int main(void) {
  TipoApontador busca;
  TipoApontador raiz;

  // criar raiz
  raiz = novoNo(1);   
  /* arvore criada
  
         1 
      /     \ 
     NULL   NULL   
  */

  raiz->esq = novoNo(2); 
  raiz->dir = novoNo(3); 
  /* 2 e 3 filhos de 1 
           1 
         /  \ 
        2     3 
     /    \   /  \ 
    NULL NULL NULL NULL 
  */

  raiz->esq->esq  = novoNo(4); 
  /* 4 filho de 2 
           1 
       /       \ 
      2          3 
    /   \       /  \ 
   4    NULL  NULL  NULL 
  /  \ 
NULL NULL 
*/

  printf("\n\nImprimindo árvore: \n");
  imprimirNo(*raiz, -1);
  printf("\n\n");
  imprimirNo2(*raiz);
  printf("\n\nImprimindo árvore por nivel:\n");
  levelOrderTraversal(raiz);
  printf("\n\n");

  // busca
  busca = pesquisarNo(raiz, 4);
  printf("Busca: %d\n", busca->chave);
  busca = pesquisarNo(raiz, 7);
  printf("Busca: %d\n", busca->chave);

  raiz->dir->dir = novoNo(7);
  imprimirNo(*raiz, -1);

  return 0;
}