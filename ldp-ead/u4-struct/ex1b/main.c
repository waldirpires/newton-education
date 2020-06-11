#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// registro heterogeneo
struct Automovel {
  char marca[20];
  char modelo[20];
  char cor[10];
  int ano;
  float valor;
} Automovel;

typedef struct Automovel T_Automovel;

void exibir(T_Automovel a){
  printf("Marca: %s\t | Modelo: %s\t | Cor: %s | Ano: %d | Valor: %.2f.\n", a.marca, a.modelo, a.cor, a.ano, a.valor);
}

T_Automovel cadastrar(T_Automovel a){
  printf("Digite a marca: ");
  gets(a.marca);
  printf("Digite o modelo: ");
  gets(a.modelo);
  printf("Digite a cor: ");
  gets(a.cor);
  printf("Digite o ano: ");
  scanf("%d", &a.ano);
  printf("Digite o valor: ");
  scanf("%f", &a.valor);

  exibir(a);
  return a;
}

void cadastrar2(T_Automovel* a){
  char n[20];
  printf("Digite a marca: ");
  gets(a->marca);
  printf("Digite o modelo: ");
  gets(a->modelo);
  printf("Digite a cor: ");
  gets(a->cor);
  printf("Digite o ano: ");
  scanf("%d", &a->ano);
  printf("Digite o valor: ");
  scanf("%f", &a->valor);

  exibir(*a);
}

int main(void) {
  T_Automovel a, *b;
  
  //a = cadastrar(a);
  b = (T_Automovel *) malloc(sizeof(T_Automovel));
  //exibir(*b);
  cadastrar2(b);

  printf("%d\n", a.ano);
  return 0;
}