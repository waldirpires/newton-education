// TAD Lista
#define MAX 900000

// definição do tipochave
typedef int TipoChave;

// definição do registro tipo item
typedef struct {
  TipoChave Chave;
} TipoItem;

// definição do apontador para célula
typedef struct TipoCelula *TipoApontador;

// definição para o tipo célula
typedef struct TipoCelula {
  TipoItem Item;
  TipoApontador Prox;
  TipoApontador Ant;
} TipoCelula;

// definição do tipo lista
typedef struct TipoLista{
  TipoApontador Primeiro, Ultimo;
  int Tamanho;
  int Capacidade;
} TipoListaDuplEnc;

// função que inicializa a lista
void FLVazia(TipoListaDuplEnc *lista, int capacidade);
// função que verifica se a lista está vazia
int VaziaLista(TipoListaDuplEnc lista);
// função que verifica se a lista está cheia
int CheiaLista(TipoListaDuplEnc lista);
// função que adiciona um item na lista
void InsereLista(TipoItem x, TipoListaDuplEnc *lista);
// função que remove um item da lista
void RetiraLista(TipoListaDuplEnc *lista,  TipoItem *Item);
// função que retorna o tamanho da lista
int TamanhoLista(TipoListaDuplEnc lista);
// função que imprime o estado atual da lista
void ImprimeLista(TipoListaDuplEnc lista);
// função que remove um item específico da lista
void RetiraItem(TipoListaDuplEnc *lista,  TipoItem *Item, TipoChave chave);
// retira um item específico da lista
void RetiraListaItemChave(TipoListaDuplEnc *lista,  TipoItem *Item, TipoChave chave);

void ImprimeListaInvertida(TipoListaDuplEnc lista);

void InsereListaOrdenado(TipoItem x, TipoListaDuplEnc *lista);