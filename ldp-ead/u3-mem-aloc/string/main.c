#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 50

int main(void) {
  int tam = 0;
  // declarando o vetor de caracteres para a frase
  char * frase;
  // alocando o vetor com tamanho máximo
  char * pt;

  frase = malloc(sizeof(char)*MAX);

  printf("Digite uma frase: ");
  gets(frase);

  tam = strlen(frase);
  // iniciando o apontador pt para a ultima posição do vetor com a frase
  // enquanto pt for maior ou igual a posição inicial do vetor
  // decrementar o apontador
  char *inicio = frase; // inicio da frase - apontador
  char *fim = frase + tam; // fim da frase - apontador
  // para pt começando no fim do vetor
  // enquanto pt for maior ou igual ao inicio do vetor, decrementar pt
  for (pt = fim; pt >= inicio; pt--){
    printf("%c", *pt);
  }

  printf("\n");
  return 0;
}