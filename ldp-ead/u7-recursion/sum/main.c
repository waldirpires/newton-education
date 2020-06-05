#include <stdio.h>

// função recursiva
int calcularSomatorio(int n){
  printf("%d ", n);
  // caso base
  if (n == 1){
    return 1;
  }
  // passo recursivo
  return n + calcularSomatorio(n-1);
}

int main(void) {
  // declaração
  int n, r;
  // entrada
  printf("Digite um número: ");
  scanf("%d", &n);
  // processamento
  // calcular o somatório de N
  // S(N) = N + (n-1) + (N-2) . . . + 1
  r = calcularSomatorio(n);
  //saída
  printf("\nResultado: %d\n\n", r);
  return 0;
}