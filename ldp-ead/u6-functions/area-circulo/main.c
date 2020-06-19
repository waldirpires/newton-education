#include <stdio.h>
#include "circulo.h"

int main(void) {
  float r, a, c;

  printf("Digite o raio do círculo: ");
  scanf("%f", &r);

  printf("\nVocê digitou o raio: %f\n\n", r);

  a = calcularArea(r);

  c = calcularCircunferencia(r);

  printf("Área: %f\n", a);

  printf("Circunferência: %f\n", c);

  return 0;
}