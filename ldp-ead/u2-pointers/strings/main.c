#include<stdlib.h>
#include<stdio.h>

#define SIZE 31
int main()
{
  char *pstring;
  // alocação dinâmica de memória 
  pstring = malloc(sizeof(char)*SIZE);

  printf("Digite uma palavra de até 20 caracteres:");
  gets(pstring);
  
  printf("A palavra é: %s\n",pstring);

  char* p = pstring;
  for (char* p = pstring; p <pstring+SIZE; p++){
    printf("Endereço: %p\t%c\n", p, *p);
  }
  
  free(pstring);
}