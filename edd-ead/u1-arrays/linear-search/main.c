#include <stdio.h>

#define NAO_ENCONTRADO -1
#define SIZE 6

// pesquisa sequencial
int pesqSeq(int a[], int t, int k) {
  // para cada valor existente no vetor:
  for (int c = 0; c < t; c++){ 
    //   Se o valor for igual ao valor sendo pesquisado
    if (a[c] == k) {
      //     Retornar o índice do valor no vetor
      return c;
    }
  }
  // retornar NAO_ENCONTRADO
  return NAO_ENCONTRADO;
}

int main(void) {
  // declaracao
  int a[] = {4, 7, 2, 3, 9, 1};
  int k, r;

  // exibe o vetor
  for (int i = 0; i < SIZE; i++) {
    printf("%d\t", a[i]);
  }
  printf("\n");

  // entrada
  printf("Digite um número inteiro: ");
  scanf("%d", &k);
  // processamento
  r = pesqSeq(a, 6, k);
  // saída
  printf("\nResultado: %d\n", r);

  if (r == NAO_ENCONTRADO) {
    printf("Chave informada não encontrada");
  } else {
    printf("Chave informada encontrada na posição %d", r);
  }

  return 0;
}