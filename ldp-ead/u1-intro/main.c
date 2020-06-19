#include <stdio.h>
#include <string.h>
  // 2020.03.05
  // entrada: ler uma frase do usuario
  // saida: Imprimir
  // 1. o código ASCII dos caracteres V
  // 2. a frase invertida V
  // 3. informar quantas vogais existem na frase V
  // 4. somente as consoantes
#define MAX 100

int main(void) {

  // variáveis
  char frase[MAX];
  int tam, i, numVogais = 0;
 
  // 1. informar o usuario para digitar uma frase
  printf("Digite uma frase: ");
  // 2. ler a frase digitada pelo usuário
  gets(frase);
  // 3. calcular o tamanho da frase
  tam = strlen(frase);
  printf("Tamanho da frase: %d\n\n", tam);
  // 4. para cada caractere dentro da frase
  for (i = 0; i < tam; i++){
    // 4.1 exibir o codigo ASCII do caractere
    printf("%c: %d\n", frase[i], frase[i]);
  }
  // 5: inverter o laco de repetição
  printf("\nFrase invertida: \n");
  for (i = tam-1; i >=0; i--){
    printf("%c", frase[i]);
  }
  // 6: exibir quantas vogais existem na frase
  printf("\nVogais: ");
  for (i = tam-1; i >=0; i--){
    if (strchr("aeiouAEIOU", frase[i]) != NULL){
      numVogais++;
      printf("%c ", frase[i]);
    }
  }
  printf("\n\nNúmero de vogais: %d\n", numVogais);
  // 7: exibir somente as constantes
  printf("\nSomente consoantes: \n");
  for (i = 0; i <tam; i++){
    if (strchr("aeiouAEIOU", frase[i]) == NULL){
      printf("%c", frase[i]);
    }
  }
  printf("\n\n\n");



  return 0;
}