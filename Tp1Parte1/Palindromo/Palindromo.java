/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */

 public class Palindromo{
   public static void main(String[] args){
     String entrada[] = new String[1000];
     String re = "FIM";
     int numEntrada = 0;
     do{
       entrada[numEntrada] = MyIO.readLine();
     }while(equals(entrada[numEntrada++],re)==false);
     numEntrada--;
     for(int i = 0;i<numEntrada;i++){
       if(palin(entrada[i])== true){
            MyIO.println("SIM");
       }
       else{
         MyIO.println("NAO");
       }
     }

   }//Fim main


   //Metodo que inverte e compara e verifica duas strings e retorna um boolean
   public static boolean palin(String entrada){
        boolean pali = true;
        String inver = "";
        for(int i = entrada.length() - 1;i>=0;i--){
          inver += entrada.charAt(i);
        }
        for(int i = 0;i<entrada.length();i++){
            if(entrada.charAt(i) != inver.charAt(i)){
                  pali =false;
            }
        }
        return pali;

   }//Fim palin

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
