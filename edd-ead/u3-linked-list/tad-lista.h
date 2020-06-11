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
} TipoCelula;

// definição do tipo lista
typedef struct TipoLista{
  TipoApontador Primeiro, Ultimo;
  int Tamanho;
  int Capacidade;
} TipoLista;

// função que inicializa a lista
void FLVazia(TipoLista *lista, int capacidade);
// função que verifica se a lista está vazia
int VaziaLista(TipoLista lista);
// função que verifica se a lista está cheia
int CheiaLista(TipoLista lista);
// função que adiciona um item na lista
void InsereLista(TipoItem x, TipoLista *lista);
// função que remove um item da lista
void RetiraLista(TipoLista *lista,  TipoItem *Item);
// função que retorna o tamanho da lista
int TamanhoLista(TipoLista lista);
// função que imprime o estado atual da lista
void ImprimirLista(TipoLista lista);
// função que remove um item específico da lista
void RetiraItem(TipoLista *lista,  TipoItem *Item, TipoChave chave);