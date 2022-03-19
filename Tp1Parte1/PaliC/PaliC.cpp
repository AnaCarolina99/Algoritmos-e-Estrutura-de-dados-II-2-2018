/**
 *
 * @author Ana Carolina Medeiros Gonçalves
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

  //Metodo que compara duas Strings, verifica se e palindromo e retorna um boolean
  int pali(char* linha){
  int j = strlen(linha) - 1;
  int i = 0;
  int resp = 0;
  char rever[1000];
  int  aux;
  do{
    strcpy(rever,linha);
    aux = rever[i];
    linha[i] = linha[j];
    linha[j] = aux;
      if(!(linha[i] == linha[j])){
          if(linha[i] <0 && linha[j] <0){
              resp = 0;
          }
          else{
            resp = 1;
            i = strlen(linha);
          }
      }
    i++;
    j--;
  }while(j>i);
  return resp;

}// Fim pali

int main (){
    char linha[1000];
    scanf("%[^\n]%*c",linha);
    while(strcmp(linha,"FIM")!=0){

        if(pali(linha) == 0){
          printf("SIM\n");
        }
        else if(pali(linha) != 0){
          printf("NAO\n");
        }
          scanf("%[^\n]%*c",linha);
    }
    return(0);
}//Fim Main
