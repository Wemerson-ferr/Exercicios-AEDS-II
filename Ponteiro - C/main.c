#include <stdio.h>
#include <stdlib.h>

int main()
{
    char escolha;
    int adiciona = 0;
    int *v;
    int contador = 0;
    printf("Escolha entre as opções abaixo: ");
    printf("Digite (+) para adicionar mais um número");
    printf("Digite (-) para adicionar mais um número");
    while(escolha!='-'){
        v = (int*) malloc (sizeof(int)*adiciona++);
        int num=0;
        printf("Digite o número que gostaria de salvar: ");
        scanf("%i", num);
        v[contador] = num;
        contador ++;
    }
    for(int i=0; i<contador;i++){
        printf("%d", v[i]);
    }
    free(v);
    }