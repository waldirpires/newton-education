#include <stdio.h>
#include <stdlib.h>

int main(void) {
  // declarações
  int c[10]; // estática
  int n, *ptr = NULL, sum = 0;

  // Solicitar do usuário a quantidade de numeros
  printf("Digite a quantidade de numeros: ");
  scanf("%d", &n);
  printf("\nTamanho solicitado: %d\n", n);

  // alocar espaço de forma dinâmica
  ptr = (int*) malloc(n * sizeof(int));
  if (ptr == NULL) {
    printf("ERRO: não foi possivel alocar memória!\n");
    exit(-1);
  }
  // exibir o vetor alocado
  for (int i = 0; i < n; i++) {
    printf("%d: %d\n", i, *(ptr+i));
  }
  // ler cada um dos elementos
  printf("Digite os %d números: \n", n);
  for (int i = 0; i < n; i++) {
    scanf("%d", ptr+i);
    sum += *(ptr+i); // acumulando a soma
  }
  // exibir o vetor depois de preenchido
  for (int i = 0; i < n; i++) {
    printf("%d: %d \t %p\n", i, *(ptr+i), ptr+i);
  }

  // exibir a soma calculada
  printf("Soma: %d\n", sum);

  free(ptr);

  return 0;
}