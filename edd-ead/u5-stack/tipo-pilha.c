#include "tipo-pilha.h"

// função que inicializa uma pilha
void FPVazia(TipoPilha *pilha, int capacidade)
{ 
  pilha->Topo = (TipoApontador) malloc(sizeof(TipoCelula));
  pilha->Fundo = pilha->Topo;
  pilha->Topo->Prox = NULL;
  pilha->tamanho = 0;
  pilha->capacidade = capacidade;
} 

// funçãp que verifica se a pilha está vazia
int Vazia(TipoPilha pilha)
{ 
  return (pilha.Topo == pilha.Fundo); 
} 

// função que verifica se a pilha está cheia
int CheiaPilha(TipoPilha pilha)
{ 
  return (pilha.tamanho == pilha.capacidade); 
} 

int PilhaInicializada(TipoPilha pilha) {
  return pilha.Topo != NULL;
}

// função que realiza o empilhamento de uma chave
void Empilha(TipoItem x, TipoPilha *pilha)
{ 

if (!PilhaInicializada(*pilha)) {
    printf("ERRO: pilha ainda não inicializada.");
    return;
  } else if (CheiaPilha(*pilha)){
    printf("ERRO: pilha já está cheia.");
    return;
  }

  TipoApontador Aux;
  Aux = (TipoApontador) malloc(sizeof(TipoCelula));

  pilha->Topo->Item = x;
  Aux->Prox = pilha->Topo;
  pilha->Topo = Aux;
  pilha->tamanho++;
} 

// função que realiza o desempilhamento de uma chave
void Desempilha(TipoPilha *pilha, TipoItem *item)
{ 
  TipoApontador q;
  if (!PilhaInicializada(*pilha)) {
    printf("ERRO: pilha ainda não inicializada.");
    return;
  } else if (Vazia(*pilha)) { 
    printf("ERRO: pilha vazia\n"); 
    return; 
  }

  q = pilha->Topo;
  pilha->Topo = q->Prox;
  *item = q->Prox->Item;
  
  free(q);  
  pilha->tamanho--;
} 

// função que imprime o estado atual da pilha
void ImprimePilha(TipoPilha pilha) {

  if (!PilhaInicializada(pilha)) {
    printf("ERRO: pilha ainda não inicializada.");
    return;
  }

  TipoApontador Aux;
  Aux = pilha.Topo->Prox;
  printf("TAD Pilha: %d | %d\n", pilha.tamanho, pilha.capacidade);
  printf("Topo: ");
  while (Aux != NULL)
  { printf("[%d]-> ", Aux->Item.Chave);
    Aux = Aux->Prox;
  }
  printf(": Fundo\n\n");
}

// função que retorna o tamanho da pilha
int Tamanho(TipoPilha pilha) { 
  if (!PilhaInicializada(pilha)) {
    printf("ERRO: pilha ainda não inicializada.");
    return -1;
  }

  return (pilha.tamanho); 
} 

void TopoPilha(TipoPilha pilha, TipoItem *item) {
  item = &pilha.Topo->Prox->Item;
}