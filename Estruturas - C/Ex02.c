#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

struct Pessoa {
    char nome[30];
    int idade;
    double renda;
};

int main(){
    int tam;
    printf("Digite a quantidade de pessoas: ");
    scanf("%d", &tam);
    fflush(stdin);
    struct Pessoa Pessoa[tam];
    for(int i=0; i<tam; i++){
    printf("Insira o nome do aluno: ");
    gets(Pessoa[i].nome);
    fflush(stdin);
    printf("Insira a idade da pessoa: ");
    scanf("%d",&Pessoa[i].idade);
    fflush(stdin);
    printf("Insira a renda da pessoa: ");
    scanf("%lf",&Pessoa[i].renda);
    fflush(stdin);
    }
    for(int j=0; j<tam; j++){
       printf("------------------------------------Pessoa(%i)------------------------------------\n", (j+1));
       printf("Nome: %s\nIdade:%d\nRenda:%0.2lf\n", Pessoa[j].nome, Pessoa[j].idade, Pessoa[j].renda);
    }
    printf("----------------------------------------------------------------------------------");
    return 0;
}