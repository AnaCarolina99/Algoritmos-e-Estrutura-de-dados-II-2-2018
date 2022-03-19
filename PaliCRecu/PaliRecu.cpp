/**
 *
 * @author Ana Carolina Medeiros Gonçalves
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

  //Metodo recursivo que compara duas Strings, verifica se e palindromo e retorna um boolean
  int pali(char*linha, int i, int j){
    int resp = 0;
    if(i<strlen(linha)/2){
         if(linha[i] != linha[j]){
            if(linha[i]< 0 && linha[j] <0){
                resp = pali(linha,i+1,j-1);
            }
            else{
              resp = 1;
            }
         }
         else{
           resp = pali(linha,i+1,j-1);
         }
    }
    return resp;
  }//Fim pali


int main (){
    char linha[1000];
    scanf("%[^\n]%*c",linha);
      while(strcmp(linha,"FIM")!=0){

      int j = strlen(linha) - 1;
      int i = 0;
        if(pali(linha,i,j) == 0){
          printf("SIM\n");
        }
        else if(pali(linha,i,j) != 0 && linha != "FIM"){
          printf("NAO\n");
        }

        scanf("%[^\n]%*c",linha);

    }
    return(0);
}//Fim main
