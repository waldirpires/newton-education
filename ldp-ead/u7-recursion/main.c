#include <stdio.h>

// Calcula o fatorial de N (número inteiro) informado pelo usuário e forma iterativa (laço) e recursiva

// ex: f(5) = 5*4*3*2 = 120

// protótipo
int fatIterativo(int n);

//
int fatRecursivo(int n);

int main(void) {
  int n, r;

  printf("Digite um número inteiro: ");
  scanf("%d", &n);

  //r = fatIterativo(n);
  r = fatRecursivo(n);

  printf("Fatorial de %d é %d\n\n", n, r);

  return 0;
}

int fatIterativo(int n){
  int r = 1;

  for (int i = 2; i <=n; i++){
    r = r * i;
  }

  return r;
}

// recursão
int fatRecursivo(int n){
  // caso base
  if (n <= 2){
    return n;
  }
  // Fat(n) = n * Fat(n-1)
  return n * fatRecursivo(n-1);
}