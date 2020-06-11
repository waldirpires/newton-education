#include <stdio.h>
#include <stdlib.h>
#include "tad-lista-dupl-enc.h"

#define TRUE 1
#define FALSE 0

void retiraCelulaLista(TipoListaDuplEnc *lista,  TipoApontador a, TipoItem *item)
{
  TipoApontador q, ant;

  printf("INFO: Retirando item %d: \n", a->Prox->Item.Chave);
  q = a->Prox;
  ant = q->Ant;
  ant->Prox = q->Prox;
  *item = q->Item;
  a->Prox = q->Prox;
  if (q->Prox != NULL) {
    q->Prox->Ant = ant;
  }

  lista->Tamanho--;
  free(q);

  if (VaziaLista(*lista)){
    FLVazia(lista, lista->Capacidade);
  }
}

// função que cria uma nova lista
void FLVazia(TipoListaDuplEnc *lista, int capacidade)
{ // cria a célula cabeça
  // P-> []
  lista->Primeiro = (TipoApontador) malloc(sizeof(TipoCelula));
  // inicializa o primeiro e ultimo
  // P-> [] <-U
  lista->Ultimo = lista->Primeiro;
  // inicializa os apontadores da célula cabeça
  lista->Primeiro->Prox = NULL;
  lista->Primeiro->Ant = NULL;
  // inicializa tamanho e capacidade
  lista->Tamanho = 0;
  lista->Capacidade = capacidade;
}

// função que verifica se a
//lista está vazia
int VaziaLista(TipoListaDuplEnc lista)
{ // se a célula na frente for igual
  // a célula atrás, ela está
  // vazia
  return (lista.Primeiro == lista.Ultimo);
}

// funcao que verifica se a lista estah cheia
int CheiaLista(TipoListaDuplEnc lista)
{
  return lista.Tamanho == lista.Capacidade;
}

void LigarCelulas(TipoApontador celula1, TipoApontador celula2)
{
  // []-> []
  celula1->Prox = celula2;
  // [] <-[]
  celula2->Ant = celula1;
}

// função que insere um item na lista
void InsereLista(TipoItem x, TipoListaDuplEnc *lista)
{
  if (CheiaLista(*lista)) {
    printf("Erro: lista está cheia\n\n");
    return;
  }
  // []
  printf("Inserindo item [%d]\n", x.Chave);

  TipoApontador celula = (TipoApontador) malloc(sizeof(TipoCelula)); 

  lista->Ultimo->Prox = celula;
  celula->Ant = lista->Ultimo;
  lista->Ultimo = celula;
  celula->Item = x;
  celula->Prox = NULL;

  lista->Tamanho++;
}

// função que insere um item na lista
void InsereListaOrdenado(TipoItem x, TipoListaDuplEnc *lista)
{
  if (CheiaLista(*lista)) {
    printf("Erro: lista está cheia\n\n");
    return;
  }
  printf("Inserindo item [%d]\n", x.Chave);

  TipoApontador celula = (TipoApontador) malloc(sizeof(TipoCelula)); 
  celula->Item.Chave = x.Chave;

  TipoApontador Aux = lista->Primeiro->Prox;
  
  while (Aux != NULL && Aux->Item.Chave < x.Chave)
  { 
    printf("[%d ] <-> ", Aux->Item.Chave);
    Aux = Aux->Prox;
  }

  // Elemento no fim
  if (Aux == NULL){
    lista->Ultimo->Prox = celula;
    celula->Ant = lista->Ultimo;
    lista->Ultimo = celula;
  } else { 
    celula->Prox = Aux;
    celula->Ant = Aux->Ant;
    Aux->Ant = celula;
  }
  
  // 1o Elemento

  // Elemento no meio

  lista->Tamanho++;
}

// função que retire um item da lista (primeiro)
void RetiraLista(TipoListaDuplEnc *lista,
                 TipoItem *Item)
{ 
  TipoApontador q, ant;

  if (VaziaLista(*lista)) {
    printf("Erro: lista esta vazia\n\n");
    return;
  }

  retiraCelulaLista(lista, lista->Primeiro, Item);

  if (lista->Tamanho == 0) // atualizando o ultimo apontador
    FLVazia(lista, lista->Capacidade);
}

// função para obter Tamanho da fila
int TamanhoLista(TipoListaDuplEnc lista)
{ 
  return (lista.Tamanho); 
}

void ImprimeListaInfo(TipoListaDuplEnc lista) {
  printf("TAD Lista\t tam: %d | cap: %d | size: %lu bytes\n", lista.Tamanho, lista.Capacidade, sizeof(lista));
}

void ImprimeLista(TipoListaDuplEnc lista)
{ 
  TipoApontador Aux;
  Aux = lista.Primeiro->Prox;
  ImprimeListaInfo(lista);
  printf("Primeiro -> ");

  while (Aux != NULL)
  { 
    printf("[%d ] <-> ", Aux->Item.Chave);
    Aux = Aux->Prox;
  }

  printf(" Ultimo\n\n");
}

void ImprimeListaInvertida(TipoListaDuplEnc lista)
{ 
  TipoApontador Aux;
  Aux = lista.Ultimo;
  ImprimeListaInfo(lista);
  printf("Ultimo: [");
  while (Aux != lista.Primeiro)
  { 
    printf("%d  ", Aux->Item.Chave);
    Aux = Aux->Ant;
  }
  printf("]: Primeiro\n\n");
}

// função que remove um item específico da lista
void RetiraListaItemChave(TipoListaDuplEnc *lista,  TipoItem *Item, TipoChave chave)
{
  if (VaziaLista(*lista)) {
    printf("Erro: lista esta vazia\n\n");
    return;
  }

  TipoApontador Aux, q, ant;
  Aux = lista->Primeiro;
  int achou = FALSE;
  while (Aux->Prox != NULL)
  { 
    if (Aux->Prox->Item.Chave == chave)
    {
      achou = TRUE;
      retiraCelulaLista(lista, Aux, Item);
      return;
    }
    Aux = Aux->Prox;
  }

  if (!achou) {
    printf("Elemento [%d] não foi encontrado na lista.\n", Item->Chave);
  }
}

