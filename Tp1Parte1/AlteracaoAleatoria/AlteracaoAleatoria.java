/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */
import java.util.*;

 public class AlteracaoAleatoria{
   public static void main(String[] args){
     String entrada[] = new String[1000];
     String re = "FIM";
     int numEntrada = 0;
     Random gerador = new Random();
       gerador . setSeed ( 4 ) ;
     do{
       entrada[numEntrada] = MyIO.readLine();
     }while(equals(entrada[numEntrada++],re)==false);
     numEntrada--;
     for(int i = 0;i<numEntrada;i++){
            MyIO.println(retornar(entrada[i],gerador));
     }

   }//Fim main

   //Metodo que altera e gera outra String e retorna a String alterada
   public static String retornar(String s, Random gerador){
     int x;
     int a = (char)( 'a'  + (Math. abs ( gerador.nextInt ( )) % 26));
     int b = (char)( 'a'  + (Math. abs ( gerador.nextInt ( )) % 26));
     String re = "";
      for(int i = 0;i<s.length();i++){
        x = (int) s.charAt(i);
        if(a==x){
          x = b;
        }
          re = re + (char) x;
      }
        return re;
   }//Fim retornar


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
