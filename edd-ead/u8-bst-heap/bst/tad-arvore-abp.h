#include <stdio.h>
#include <stdlib.h>

#define MAX 100
#define CHAVE_NAO_EXISTE -1

// definicao da TAD
typedef int TipoChave;

// apontador para o nó da árvore
typedef struct TipoNo * TipoApontador;
// registro para o no
struct TipoNo{
  TipoChave chave;
  TipoApontador dir, esq;       
};

typedef struct TipoNo TipoNo;

// cabecalho para as funcoes
void inicializar(TipoApontador * a);

TipoChave pesquisar(TipoApontador a, TipoChave c);

void inserir(TipoApontador *a, TipoChave c);

void preOrdem(TipoApontador a);

void central(TipoApontador a);

void posOrdem(TipoApontador a);

void retira(TipoChave x, TipoApontador *p);