#include <stdio.h>
#include <stdlib.h>

#define VAZIO -1

typedef int TipoChave;

typedef struct node * TipoApontador;

typedef struct node  
{ 
    TipoChave chave; 
    TipoApontador esq; 
    TipoApontador dir;
}TipoNo; 

// caminhamento central
void imprimirNo(TipoNo no, TipoChave raiz);

// caminhamento central
void imprimirNo2(TipoNo no);

// criar um novo nó
TipoApontador novoNo(TipoChave chave);

// pesquisar por mu no
TipoApontador pesquisarNo(TipoApontador no, TipoChave chave);

// imprime o nivel de um no
int imprimirNivel(TipoApontador raiz, int nivel);

// caminhamento em ordem de nivel
void levelOrderTraversal(TipoApontador raiz);

