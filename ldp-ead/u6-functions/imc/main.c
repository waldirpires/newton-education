#include <stdio.h>

// imc = p / (a*a)
// Kg/m2

// protótipo da função
float calcularImc(float p, float a);

int main(void) {
  float p, a, imc;

  // entrada
  printf("Digite o seu peso (Kg): ");
  scanf("%f", &p);

  printf("Digite a sua altura (m): ");
  scanf("%f", &a);

  // processamento
  imc = calcularImc(p, a);

  // saída
  printf("\nIMC: %f Kg/m2\n", imc);
  return 0;
}

// implementação
float calcularImc(float p, float a){
  return p / (a*a);
}