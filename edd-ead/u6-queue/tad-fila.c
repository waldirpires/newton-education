#include <stdlib.h>
#include "tad-fila.h"

// 1) Criar a célulca cabeça
// 2) Inicializar a frente e trás da file
// 3) Inicializar o tamanho e capacidade da fila
// função que cria uma nova fila
void FFVazia(TipoFila *fila, int capacidade)
{ // cria a célula cabeça
  fila->Frente = (TipoApontador) 
    malloc(sizeof(TipoCelula));
  // inicializa a frente e trás
  fila->Tras = fila->Frente;
  fila->Frente->Prox = NULL;
  fila->tamanho = 0;
  fila->capacidade = capacidade;
}

// função que verifica se a fila está vazia
int VaziaFila(TipoFila fila)
{ // se a célula na frente for igual a célula atrás, ela está vazia
  return (fila.Frente == fila.Tras); 
}

// função que verifica se a fila está cheia
int CheiaFila(TipoFila fila)
{ 
  return (fila.tamanho == fila.capacidade); 
}

// função que Enfileira um item na fila
void Enfileira(TipoItem x, TipoFila *fila)
{ 
  if (CheiaFila(*fila)){
    printf("ERRO: Fila já está cheia!"); 
    return;
  }
  // cria a nova célula
  fila->Tras->Prox = (TipoApontador) 
    malloc(sizeof(TipoCelula));
  // faz TRAS apontar para a nova célula
  fila->Tras = fila->Tras->Prox;
  // Adiciona o novo item
  fila->Tras->Item = x;
  // Inicializa o PROX da nova célula
  fila->Tras->Prox = NULL;
  // Incrementa o tamanho da Fila
  fila->tamanho++;
}

// função que desenfileira o item na frente da fila
void Desenfileira(TipoFila *fila, 
                  TipoItem *item)
{ TipoApontador q;
  // se a FILA estiver vazia
  if (VaziaFila(*fila)) {
    printf("Erro fila esta vazia\n"); return; }
  // obtem a célula que está na FRENTE
  q = fila->Frente;
  // atualiza a FRENTE para a próxima celula
  fila->Frente = fila->Frente->Prox;
  // obtem o item a ser desenfileirado da FILA
  *item = fila->Frente->Item;
  // Decrementa o tamanho da FILA
  fila->tamanho--;
  // libera o espaço em memória da célula desenf.
  free(q);
}

// função para obter Tamanho da fila
int TamanhoFila(TipoFila fila)
{ 
  return (fila.tamanho); 
}

// função para obter o elemento na frente da fila
TipoItem FrenteFila(TipoFila *fila)
{  TipoItem item; item.Chave = -1;
  if (VaziaFila(*fila) == 0){
    item = fila->Frente->Prox->Item;
  } return (item);
}

// função para obter o elemento atrás na fila
TipoItem TrasFila(TipoFila *fila)
{  TipoItem item; item.Chave = -1;
  if (VaziaFila(*fila) == 0){
    item = fila->Tras->Item;
  } return (item);
}

// 1) Obtém o apontador para FRENTE PROX (aux)
// 2) Enquanto o apontador NÂO for nulo
// 2.1) Imprimir a chave contida na célula
// 2.2) Atualizar o apontador (aux) para aux->prox
//
// função que imprime o estado da FILA
void ImprimeFila(TipoFila fila)
{ TipoApontador Aux;
  Aux = fila.Frente->Prox;
  while (Aux != NULL)
  { printf("%d\n", Aux->Item.Chave);
    Aux = Aux->Prox;
  }
}
