#include <stdio.h>

// Fib(n) = 
// Fib(0) = 0 // caso base
// Fib(1) = 1 // caso base
// Fib(2) = Fib(1) + Fib(0) = 1
// Fib(3) = Fib(2) + Fib(1) = 2
// Fib(n) = Fib(n-1) + Fib(n-2)
// 0, 1, 2, 3, 5, 8, 13, 21, 34. 55  . .

int fib(int n){
  // caso base
  if (n <= 1){
    return n;
  }
  // passo recursivo
  return fib(n-1) + fib(n-2);
}

// solucao por iteração
int fib2(int n){
  int f, f1 = 0, f2 = 1;

  if (n <= 1){
    return n;
  }

  for (int i = 0; i < n; i++){
    f = f2 + f1; // fib(n)
    f1 = f2; 
    f2 = f;
  }
  return f;
}

int main(void) {
  // declaracao
  int n, i, r;
  // entrada
  printf("Digite um número inteiro: ");
  scanf("%d", &n);
  // processamento 
  for (i = 0; i <= n; i++){
    r = fib2(i);
    // saída
    printf("fib(%d) = %d\n", i, r);
  }
  return 0;
}