#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

struct Pessoa {
    char nome[30];
    int idade;
    double renda;
};

int main()
{
    struct Pessoa Pessoa01;
    printf("Insira o nome do aluno: ");
    gets(Pessoa01.nome);
    printf("Insira a idade da pessoa: ");
    scanf("%d",&Pessoa01.idade);
    printf("Insira a renda da pessoa: ");
    scanf("%lf",&Pessoa01.renda);

    printf("Nome: %s\nIdade:%d\nRenda:%0.2lf\n", Pessoa01.nome, Pessoa01.idade, Pessoa01.renda);

    return 0;
}
