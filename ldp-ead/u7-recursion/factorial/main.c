#include <stdio.h>

int fatorial(int n){
  // caso base
  if (n == 1){
    return 1;
  }
  // passo recursivo
  return n * fatorial(n-1);
}

int main(void) {
  // declaracao
  int n, r;
  // entrada
  printf("Digite um número inteiro: ");
  scanf("%d", &n);
  // processamento
  r = fatorial(n);
  // saida
  printf("\nResultado: %d\n", r);
  printf("Hello World\n");
  return 0;
}