#include<stdlib.h>
#include<stdio.h>
#define WIDTH 4
#define HEIGHT 5
#define SIZE WIDTH*HEIGHT

int main()
{
  int *pt, i, j, mat[WIDTH][HEIGHT];

  for(i=0;i<WIDTH;i++)  
  {
    for(j=0;j<HEIGHT;j++) 
    {
      mat[i][j]=j+1;
      printf("%d ", mat[i][j]);
    }
    printf("\n");
  }
  
  printf("\n\n");

  pt =&mat[0][0]; // apontador
  for(i=0;i<SIZE;i++)
  {
    printf("%p - %i\n", pt, *pt);
    // exibindo o endereço e o valor na matriz
    pt++; // aritmética de ponteiros
  }
}