#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n, i, *ptr = NULL, sum = 0;

    printf("Entre a quantidade de elementos: ");
    scanf("%d", &n);

    //ptr = (int*) malloc(n * sizeof(int));
    ptr = (int*) calloc(n, sizeof(int));
 
    if(ptr == NULL)                     
    {
        printf("Erro: memória não pôde ser alocada.");
        exit(0);
    }

    printf("Endereço: %p\n", ptr);

    for(i = 0; i < n; ++i)
    {
        printf("%d: %d\n", i, *(ptr + i));
    }

    printf("Entre os elementos: ");
    for(i = 0; i < n; ++i)
    {
        scanf("%d", ptr + i);
        sum += *(ptr + i);
    }

    for(i = 0; i < n; ++i)
    {
        printf("%d: %d\t %p\n", i, *(ptr + i), ptr + i);
    }

    printf("Soma = %d", sum);
  
    // liberação da memória
    free(ptr);
    return 0;
}