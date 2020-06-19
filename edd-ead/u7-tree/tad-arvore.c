#include <stdio.h>
#include <stdlib.h>
#include "tad-arvore.h"

void imprimirNo(TipoNo no, TipoChave raiz) {
  if (raiz == VAZIO) {
    printf("RAIZ: %d\n", no.chave);  
  } else {
    printf("%d->%d\n", raiz, no.chave);
  }

  if (no.esq != NULL) {
    imprimirNo(*no.esq, no.chave);
  }

  if (no.dir != NULL) {
    imprimirNo(*no.dir, no.chave);
  }
}

// pre-ordem: I-E-D
void imprimirNo2(TipoNo no) {
  printf("[%d] ", no.chave);

  if (no.esq != NULL) {
    imprimirNo2(*no.esq);
  }

  if (no.dir != NULL) {
    imprimirNo2(*no.dir);
  }
}

/* newNode() allocates a new node with the given data and NULL left and  
   right pointers. */
TipoApontador novoNo(TipoChave chave) 
{ 
  // Allocate memory for new node  
  TipoApontador no = (TipoApontador) malloc(sizeof(TipoNo)); 
  
  // Assign data to this node 
  no->chave = chave; 
  
  // Initialize left and right children as NULL 
  no->esq = NULL; 
  no->dir = NULL; 

  return(no); 
} 

TipoApontador pesquisarNo(TipoApontador no, TipoChave chave) {
  if (no->chave == chave) {
    printf("Achou: %d\n", no->chave);
    return no;
  } else if (no->esq != NULL) {
    printf("Pesquisa: %d esq -> %d\n", no->chave, no->esq->chave);
    return pesquisarNo(no->esq, chave);
  } else if (no->dir != NULL) {
    printf("Pesquisa: %d dir -> %d\n", no->chave, no->dir->chave);
    return pesquisarNo(no->dir, chave);
  } else {
    printf("Não Achou\n");
    return novoNo(VAZIO);
  }
}

// Function to print all nodes of a given level from left to right
int imprimirNivel(TipoApontador raiz, int nivel)
{
	if (raiz == NULL)
		return 0;

	if (nivel == 1)
	{
		printf(" %d ", raiz->chave);

		return 1;
	}

	int left = imprimirNivel(raiz->esq, nivel - 1);
	int right = imprimirNivel(raiz->dir, nivel - 1);

	return left || right;
}

// Function to print level order traversal of given binary tree
void levelOrderTraversal(TipoApontador raiz)
{
	// start from level 1 -- till height of the tree
	int nivel = 1;

	// run till printLevel() returns false
	while (imprimirNivel(raiz, nivel))
		nivel++;
}