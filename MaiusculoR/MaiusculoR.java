/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */
public class MaiusculoR{
  public static void main(String args[]){
    String entrada[] = new String[1000];
    String saida = "FIM";
    int numEntrada = 0;
      do{
        entrada[numEntrada] = MyIO.readLine();
      }while(equals(entrada[numEntrada++],saida)== false);
        numEntrada--;
        int j = 0;
        for(int i = 0;i<numEntrada;i++){
            MyIO.println(maius(entrada[i]));
        }
  }//Fim main

  //Metodo que retorna o metodo recursivo
  public static int maius(String s){
    return maius(s,0);
  }

  //Metodo boolean que retorna uma condicao
  public static boolean ma(char a){
    return (a>='A' && a<='Z');
  }//Fim ma

  //Metodo recursivo que retorna um contador inteiro
  public static int maius(String entrada, int i){
      if(entrada.length() > i){
        if(ma(entrada.charAt(i)) == true)
          return 1 + maius(entrada,i+1);

      else return maius(entrada,i+1);
      }
      else  return 0;
  }//Fim maius

  //Metodo que compara duas Strings e retorna boolean
  public static boolean equals(String entrada,String fim){
      boolean resp = false;
      int size = entrada.length();
      int size2 = fim.length();
        if(size == size2){
          for(int i = 0;i<entrada.length();i++){
              if(entrada.charAt(i)== fim.charAt(i)){
                resp = true;
              }
          }
        }
        return resp;
  }//Fim equals

}//Fim classe
