/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */

public class CesarRecu{
  public static void main(String args[]){
    String entrada[] = new String[1000];
    String saida = "FIM";
    int numEntrada = 0;
    int j = 0;
      do{
        entrada[numEntrada] = MyIO.readLine();
      }while(equals(entrada[numEntrada++],saida)== false);
        numEntrada--;
        for(int i = 0;i<numEntrada;i++){
            MyIO.println(crip(entrada[i],j));
        }
  }//Fim main

  //Metodo que retorna o metodo recursivo
  public static String crip(String s){
    return crip(s,0);
  }
     //Metodo que altera String e retorna ela
    public static String crip(String s, int i){
      char cifra;
      String top = "";
       if(i<s.length()){
         cifra = (char)(((int) s.charAt(i)) + 3);
         top += cifra;
         return top  += crip(s,i+1);
       }
       else return "";

    }//Fim crip

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
