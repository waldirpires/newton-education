#include <stdio.h>

// Recebe um valor inteiro N e exibe a taboada de N

// prototipo
void imprimirTaboada(int n);

int main(void) {
  int n;

  // entrada
  printf("Digite um número inteiro: ");
  scanf("%d", &n);

  // processamento e saída
  imprimirTaboada(n);

  return 0;
}

void imprimirTaboada(int n){
  int r = 0;
 
  printf("\n Taboada de %d\n", n);

  for (int i = 0; i <=10; i++){
    r = n*i; // valor na linha da taboada
    printf("%2d X %2d = %3d\n", n, i, r);
  }
  printf("\n");
}