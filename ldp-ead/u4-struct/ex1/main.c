#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// registro heterogeneo
struct Automovel {
  char marca[20];
  char modelo[20];
  char cor[10];
  int ano;
  float valor;
} ;

#define MAX 20

void exibeAutomovel(struct Automovel a){
      printf("%s\t%s\t%s\t%d\tR$ %.2f\n", 
        a.marca, a.modelo, a.cor, a.ano, a.valor);
}

void flush(){
  while (getchar() != '\n');
}

void clearscreen(){
  system("@cls||clear");
}

void pause(){
  printf("Aperte qualquer tecla para continuar\n");
  getchar();
}

int main(void) {
  // registro de automovel
  struct Automovel a[MAX];
  int op, tam = 0, i;
  char sn;
  

  while (op != 6){
    clearscreen();

    printf("MENU\n");
    printf("===========================\n");
    printf("1. cadastrar novo automóvel\n");
    printf("2. recuperar um automóvel\n");
    printf("3. listar os automóveis\n");
    printf("4. atualizar um automóvel\n");
    printf("5. excluir um automóvel\n");
    printf("6. Sair\n\n");

    printf("Selecione uma opção: ");
    scanf("%d", &op);
    flush();
    switch(op){
      case 1:
      printf("==CADASTRO==\n");
        // cadastrar um novo automovel
      // marca
      printf("\nDigite a marca do automóvel: ");
      gets(a[tam].marca);
      // modelo
      printf("\nDigite o modelo do automóvel: ");
      gets(a[tam].modelo);
      // cor
      printf("\nDigite a cor do automóvel: ");
      gets(a[tam].cor);
      // ano
      printf("\nDigite o ano de fabricação do automóvel: ");
      scanf("%d", &a[tam].ano);
      // valor
      printf("\nDigite o valor do automóvel: ");
      scanf("%f", &a[tam].valor);

      tam++;

      printf("Exibindo os dados do automóvel informado:\n");

      // exibir o registro de carro
      printf("Cod\tMarca\tModelo\tCor\tAno\tValor\n");
      printf("==================================\n");
      printf("%d: \t", tam-1);
      exibeAutomovel(a[tam-1]);

      break;
      case 2: // recuperar um automóvel
        printf("==SELEÇÃO==\n");

        if (tam == 0){
          printf("Não existem automóveis na lista.\n");
          break;
        }

        printf("\ndigite o código desejado:");
        scanf("%d", &i);

        if (i >= tam){
          printf("\n O automóvel desejado não existe na listagem.");
        } else {
          // exibir o registro de carro
          printf("Cod\tMarca\tModelo\tCor\tAno\tValor\n");
          printf("==================================\n");
          printf("%d: \t", i);
          exibeAutomovel(a[i]);
        }
      break;
      case 3:
        printf("==LISTAGEM==\n");

        if (tam == 0){
          printf("Não existem automóveis na lista.\n");
          break;
        }

        printf("Listando os automóveis: %d\n\n", tam);
        printf("Cod\tMarca\tModelo\tCor\tAno\tValor\n");
        printf("==================================\n");
        for (int i = 0;i<tam; i++){
          printf("%d: \t", i);
          exibeAutomovel(a[i]);
        }
      break;
      case 4:
        printf("==ATUALIZAÇÃO==\n");

        if (tam == 0){
          printf("Não existem automóveis na lista.\n");
          break;
        }

        printf("Listando os automóveis: %d\n\n", tam);
        printf("Cod\tMarca\tModelo\tCor\tAno\tValor\n");
        printf("==================================\n");
        for (int i = 0;i<tam; i++){
          printf("%d: \t", i);
          exibeAutomovel(a[i]);
        }

        printf("\ndigite o código desejado:");
        scanf("%d", &i);

        if (i >= tam){
          printf("\n O automóvel desejado não existe na listagem.");
        } else {
          // exibir o registro de carro
          printf("Cod\tMarca\tModelo\tCor\tAno\tValor\n");
          printf("==================================\n");
          exibeAutomovel(a[i]);

          gets(a[i].marca);
          printf("\nDigite a marca do automóvel: ");
          gets(a[i].marca);
          // modelo
          printf("\nDigite o modelo do automóvel: ");
          gets(a[i].modelo);
          // cor
          printf("\nDigite a cor do automóvel: ");
          gets(a[i].cor);
          // ano
          printf("\nDigite o ano de fabricação do automóvel: ");
          scanf("%d", &a[i].ano);
          // valor
          printf("\nDigite o valor do automóvel: ");
          scanf("%f", &a[i].valor);

          printf("\nAutomóvel atualizado com sucesso.\n");

          // exibir o registro de carro
          printf("Cod\tMarca\tModelo\tCor\tAno\tValor\n");
          printf("==================================\n");
          exibeAutomovel(a[i]);

        }

      break;
      case 5:
        printf("==EXCLUSÃO==\n");

        if (tam == 0){
          printf("Não existem automóveis na lista.\n");
          break;
        }

        printf("Listando os automóveis: %d\n\n", tam);
        printf("Cod\tMarca\tModelo\tCor\tAno\tValor\n");
        printf("==================================\n");
        for (int i = 0;i<tam; i++){
          printf("%d: \t", i);
          exibeAutomovel(a[i]);
        }

        printf("\ndigite o código desejado:");
        scanf("%d", &i);
        flush();

        if (i >= tam){
          printf("\n O automóvel desejado não existe na listagem.");
        } else {
          scanf("%c", &sn);
          printf("Você realmente deseja excluir o automóvel? (s/n)");
          scanf("%c", &sn);

          if (sn == 's' || sn == 'S'){
            for (int j = i; j < tam; j++){
              strcpy(a[j+1].marca, a[j].marca);
              strcpy(a[j+1].modelo, a[j].modelo);
              strcpy(a[j+1].cor, a[j].cor);
              a[j].ano = a[j+1].ano;
              a[j].valor = a[j+1].valor;
            }
            tam--;
            printf("\nAutomóvel excluido com sucesso.\n");
          }
        }
      break;
      case 6:
        printf("==SAIR==\n");
        printf("Você realmente deseja excluir o automóvel? (s/n)");
        scanf("%c", &sn);

        if (sn != 's' && sn != 'S'){
          op = -1;
        }      
      break;
      default:
      printf("Opção inválida: %d\n", op);
    }
    if (op != 6){
      printf("\n\n==================================\n");
      flush();
      pause();
    }
  }
    // saindo do menu

  return 0;
}