/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */
import java.util.*;

 public class AlteraRecu{
   public static void main(String[] args){
     String entrada[] = new String[1000];
     String re = "FIM";
     int numEntrada = 0;
     boolean f = true;
     Random gerador = new Random();
       gerador.setSeed ( 4 );
       char a, b;
       int j = 0, i = 0;
       int x = 0;
       String r = "";
     do{
       a = (char)( 'a'  + (Math. abs ( gerador.nextInt ( )) % 26));
       b = (char)( 'a'  + (Math. abs ( gerador.nextInt ( )) % 26));
       entrada[numEntrada] = MyIO.readLine();
       f = equals(entrada[i],re);
       if(f == false)
       MyIO.println(retornar(entrada[i],gerador,j,a,b,r,x));
       i++;
     }while(equals(entrada[numEntrada++],re)==false);

   }//Fim main

   //Metodo que retorna o metodo recursivo
   public static String retornar(String s, Random gerador,int a, int b, String re, int x){
     return retornar( s, gerador,0,a,b,re,x);
   }//Fim retornar

   //Metodo que compara, altera String e retorna
   public static String retornar(String s, Random gerador,int i,int a, int b, String re, int x){
      if(i<s.length()){
        x = (int) s.charAt(i);
          if(a== x){
            x = b;
          }
          re += (char)x;
           return retornar(s,gerador,i+1,a,b,re,x);
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
