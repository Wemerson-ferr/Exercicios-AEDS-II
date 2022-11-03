#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

struct Livros {
    char titulo[30];
    char autor[20];
    char assunto[100];
    int id;
};

int main(){
    setlocale(LC_ALL, "Portuguese");
   struct Livros livro[5];
   for(int i=0; i<5; i++){
    printf("Escreva o titulo do %d° livro: ", (i+1));
    gets(livro[i].titulo);
    fflush(stdin);
    printf("Escreva o autor do %d° livro: ", (i+1));
    gets(livro[i].autor);
    fflush(stdin);
    printf("Escreva o assunto do %d° livro: ", (i+1));
    gets(livro[i].assunto);
    fflush(stdin);
    printf("Escreva o ID do %d° livro: ", (i+1));
    scanf("%d", &livro[i].id);
    fflush(stdin);
   };
    printf("--------------------------------------------------------\n");
   for(int j=0; j<5; j++){
    printf("O titulo do %d° livro é: %s \n", (j+1), livro[j].titulo);
    printf("O autor do %d° livro é: %s \n", (j+1), livro[j].autor);
    printf("O assunto do %d° livro é: %s \n", (j+1), livro[j].autor);
    printf("O ID do %d° livro é: %d \n", (j+1), livro[j].id);
    printf("--------------------------------------------------------\n");
   };
}