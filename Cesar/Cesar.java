/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */

 public class Cesar{
   public static void main(String[] args){
     String entrada[] = new String[1000];
     String re = "FIM";
     int numEntrada = 0;
     do{
       entrada[numEntrada] = MyIO.readLine();
     }while(equals(entrada[numEntrada++],re)==false);
     numEntrada--;
     for(int i = 0;i<numEntrada;i++){
       MyIO.println(crip(entrada[i]));
     }

   }//Fim main

   //Metodo que altera String e retorna a String alterada
   public static String crip(String s){
     char cifra;
     String top = "";
      for(int i = 0;i<s.length();i++){
          cifra = (char)(((int) s.charAt(i)) + 3);
          top += cifra;
      }
      return top;
   }//Fim crip

   //Metodo que compara duas Strings e retorna boolean
   public static boolean equals(String s , String re){
      boolean fim = false;
      int size = s.length();
      int size2 = re.length();
      if(size == size2){
        for(int i = 0;i<size;i++){
            if(s.charAt(i)== re.charAt(i)){
                fim = true;
            }

            else{
              fim = false;
              i = size;
            }
          }
        }
          return fim;
        }//Fim equals
 }//Fim classe
