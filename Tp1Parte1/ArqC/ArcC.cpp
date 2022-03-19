#include <stdio.h>
/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */
int main(int args, char* argv[]){
    int tamanho;
    FILE *arq;
    double a;
    char* linha;
  arq = fopen("arquivo.txt","wb+");
  scanf("%d\n", &tamanho);
    if(arq== NULL){
      printf("Erro ao abrir o arquivo");
    }
      for(int i =0;i<tamanho;i++){
          scanf("%lf", &a);
          fwrite(&a, sizeof(double),1,arq);
      }
      fclose(arq);
  arq = fopen("arq.txt","wb+");
      for(int i = tamanho - 1; i>-1 ;i--){
          fseek(arq,sizeof(double) *i,SEEK_SET);
          fread(&a,sizeof(double),1,arq);
          printf("%.6g\n", a);
          
      }
      fclose(arq);

  return 0;
}//FIm main
