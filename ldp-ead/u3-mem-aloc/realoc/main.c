#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main () {
   char *str;

   /* Initial memory allocation */
   str = (char *) malloc(15); // 15 x sizeof(char)
   // cópia
   strcpy(str, "tutorialspoint");
   printf("String = %s,  Address = %p\n", str, str);

   /* Reallocating memory */
   str = (char *) realloc(str, 25);
   printf("String = %s,  Address = %p\n", str, str);
   // concatenação
   strcat(str, ".com");
   printf("String = %s,  Address = %p\n", str, str);

   free(str);
   
   return(0);
}