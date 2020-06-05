#include <stdio.h>

int main(void) {
  FILE * p = NULL;

  p = fopen("teste.txt", "w");

  if (p == NULL){
    printf("\nERRO: arquivo não pôde ser aberto.");
  } else {
    printf("\nINFO: arquivo aberto com sucesso.");

    //fputc('d', p);
    fputs("the book is on the table", p);
    printf("\nINFO: escrito.");
    fclose(p);

    p = fopen("teste.txt", "r");

    char c = fgetc(p);
    printf("\nINFO: lido %c\n", c);

    fclose(p);

    remove("teste.txt");
  }

  return 0;
}