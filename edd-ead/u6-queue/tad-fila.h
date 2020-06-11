#include <stdio.h>
#include <stdlib.h>

#define MAX 100

typedef int TipoChave;

typedef struct {
  TipoChave Chave;
} TipoItem;

typedef struct TipoCelula *TipoApontador;

typedef struct TipoCelula {
  TipoItem Item;
  TipoApontador Prox;
} TipoCelula;

// definição do tipo fila
typedef struct{
  TipoApontador Frente, Tras;
  int tamanho;
  int capacidade;
} TipoFila;

// função que inicializa a fila
void FFVazia(TipoFila *Fila, int capacidade);
// função que verifica se a fila está vazia
int VaziaFila(TipoFila Fila);
// função que verifica se a fila está cheia
int CheiaFila(TipoFila Fila);
// função que enfileira um item na fila (TRÁS)
void Enfileira(TipoItem x, TipoFila *Fila);
// função que desenfileira um item da fila (FRENTE)
void Desenfileira(TipoFila *Fila,  TipoItem *Item);
// função que retorna o tamanho da fila
int TamanhoFila(TipoFila Fila);
// função que informa o elemento na frente da fila
TipoItem FrenteFila(TipoFila *Fila);
// função que informa o elemento atrás na fila
TipoItem TrasFila(TipoFila *Fila);
// função que imprime o estado atual da fila
void ImprimeFila(TipoFila Fila);
