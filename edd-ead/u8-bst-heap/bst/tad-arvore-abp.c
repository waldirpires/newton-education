#include "tad-arvore-abp.h"

void inicializar(TipoApontador * a){
  (*a) = NULL;
}

TipoChave pesquisar(TipoApontador a, TipoChave c){
// descricao textual
  if (a != NULL){// 1) Se o nó for valido (existente)
    if (c == a->chave){// 1.1) Se a chave for igual a chave do no
      return c;// 1.1.1) retornar a chave (achei!)
    } else// 1.2) caso contrario:
    if (c < a->chave){// 1.2.1) Se a chave for menor que a chave do nó
      return pesquisar(a->esq, c);// 1.2.1.1) navegar para a esquerda do nó
    } else if (c > a->chave){// 1.2.2) Senão se a chave for maior que a chave do no
      return pesquisar(a->dir, c);// 1.2.2.1) navegar para a direita do nó
    }// 1.2.3) voltar ao passo 1
  } else {// 2) Senão (no invalido)
    printf("INFO: no nao existe.\n");
    return CHAVE_NAO_EXISTE;// 2.1) informar que a chave nao existe    
  }
}

void inserir(TipoApontador * a, TipoChave c){
// descricao textual
  if ((*a) == NULL){// 1) se nao houver no (i.e., no nulo)

    (*a) = (TipoApontador) malloc(sizeof(TipoNo));// 1.1) criar um novo no
    (*a)->chave = c;// 1.2) colocar a chave no novo no
    (*a)->dir = NULL;
    (*a)->esq = NULL;

    printf("Item inserido com sucesso.");

  } else if (c < (*a)->chave) {// 2) se a chave for menor que a chave no no
    inserir(&(*a)->esq, c);// 2.1) navegar para a esquerda do no// 2.2) voltar ao passo 1
  } else if (c > (*a)->chave) { // 3) se a chave for maior que a chave no no
    inserir(&(*a)->dir, c);// 3.1) navegar para a direita do no  }// 3.2) voltar ao passo 1
  } else {// 4) senao (chave for igual)
    printf("INFO: Chave jah existe!\n");// 4.1) a chave jah existe     
  }
}

void central(TipoApontador a){
  if (a == NULL){
    return;
  }

  central(a->esq);
  printf("[%d]  ", a->chave);
  central(a->dir);
}

void preOrdem(TipoApontador a){
  if (a == NULL) {
    return;
  }

  printf("[%d]  ", a->chave);
  preOrdem(a->esq);
  preOrdem(a->dir);
}

void posOrdem(TipoApontador a){
  if (a == NULL){
    return;
  }

  posOrdem(a->esq);
  posOrdem(a->dir);
  printf("[%d]  ", a->chave);
}

void Antecessor(TipoApontador q, 
  TipoApontador *r)
{ 
  if ((*r)->dir != NULL) { 
    Antecessor(q, &(*r)->dir);
    return;
  }

  q->chave = (*r)->chave;
  q = *r; 
  *r = (*r)->esq;

  free(q);
} 

void retira(TipoChave x, TipoApontador *p)
{  
  TipoApontador Aux;
  
  if (*p == NULL) 
  { 
    printf("Erro : Registro nao esta na arvore\n");
    return;
  }

  if (x < (*p)->chave) { 
    retira(x, &(*p)->esq); 
    return; 
  }

  if (x > (*p)->chave) { 
    retira(x, &(*p)->dir); 
    return; 
  }

  if ((*p)->dir == NULL) { 
    Aux = *p;  *p = (*p)->esq;
    free(Aux);
    printf("\nChave retirada com sucesso.\n");
    return;
  }

  if ((*p)->esq == NULL) { 
    Aux = *p;  *p = (*p)->dir;
    free(Aux);
    printf("\nChave retirada com sucesso.\n");
    return;
  }

  Antecessor(*p, &(*p)->esq);
}  

