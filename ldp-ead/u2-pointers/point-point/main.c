#include <stdio.h>

int main(void) {
  int a = 12;
  int b = 13;

  int *p1 = &a;
  int *p2 = p1; //ponteiro para ponteiro

  printf("Valor de a: %d\n", a);
  printf("Endereço de a: %p\n\n", &a);

  printf("Valor de b: %d\n", b);
  printf("Endereço de b: %p\n\n", &b);

  printf("Valor de p1: %p\n", p1);
  printf("Endereço de p1: %p\n\n", &p1);

  printf("Valor de p2: %p\n", p2);
  printf("Endereço de p2: %p\n\n", &p2);

  p2--; // decremento de apontador

  printf("Valor de p2: %p\n", p2);
  printf("Endereço de p2: %p\n\n", &p2);
  printf("Valor para onde p2 ponta: %d\n", *p2);

  return 0;
}