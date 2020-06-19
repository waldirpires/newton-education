#include <stdio.h>
#include "heapsort.h"


// Driver program
int main()
{
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = sizeof(arr)/sizeof(arr[0]);

    //        12
    //      /   \
    //    11     13
    //   /  \   /
    //  5    6 7

    printf("Vetor original: \n");
    printArray(arr, n);
    printf("\n");

    heapSort(arr, n);
 
    printf("Vetor ordenado: \n");
    printArray(arr, n);
    return 0;
}