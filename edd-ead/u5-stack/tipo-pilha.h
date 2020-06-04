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

typedef struct {
  TipoApontador Fundo, Topo;
  int tamanho;
  int capacidade;
} TipoPilha;

void FPVazia(TipoPilha *Pilha, int capacidade);

int Vazia(TipoPilha Pilha);

void Empilha(TipoItem x, TipoPilha *Pilha);

void Desempilha(TipoPilha *Pilha, TipoItem *Item);

int Tamanho(TipoPilha Pilha);

int CheiaPilha(TipoPilha Pilha);

void TopoPilha(TipoPilha pilha, TipoItem *item);

void ImprimePilha(TipoPilha pilha);
