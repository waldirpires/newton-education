#include <stdio.h>

void quadrado(int * ptr){
  *ptr = *ptr * *ptr;
}

int main(){
  int n, *ptr;
  printf("Digite um número inteiro\n");
  scanf("%d", &n);
  quadrado(&n);
  printf("Resultado: %d\n", n);
}