/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */

 public class Algebra{
   public static void main(String [] args){
      ler0();
   }//Fim main

   public static void ler0(){
     int x = MyIO.readInt();
      while(x!=0){
          int[] quant = arranjo(x);
          String s = MyIO.readLine();
          String s2 = alterWord(s,quant);
          MyIO.println(solu(s2));
          x = MyIO.readInt();
      }
   }//Fim ler0

   public static char solu(String s2){
     String[] op = {" "," not(0)","not(1)"
      ,"and(0,0)","and(1,1)","and(0,1)","and(1,0)"
      ,"and(0,0,","and(1,1,","and(0,1,","and(1,0,"
        ,"or(0,0)","or(1,1)","or(0,1)","or(1,0)"
        ,"or(0,0,","or(1,1,","or(0,1,","or(1,0,"};

     String[] op2 ={"","1","0","0","1","0","0"
      ,"and(and(0,0),","and(and(1,1),","and(and(0,1),"
      ,"and(and(1,0),","0","1","1","1","or(or(0,0),"
        ,"or(or(1,1),","or(or(0,1),","or(or(1,0),"};

            while(s2.charAt(0) != '0' && s2.charAt(0) != '1'){
                for(int i = 0;i<op.length;i++){
                    s2 = replace(s2,op[i],op2[i]);
                }
            }
            return s2.charAt(0);
   }//Fim solu


   public static int[] arranjo(int i){
      int array[] = new int[i];
        for(int j = 0; j<i;j++){
          array[j] = MyIO.readInt();
        }
      return array;
   }//Fim arranjo

   public static boolean igualidade(String s2, String op, int i){
      boolean b = false;
      int j = i;
        if(s2.length()- i >= op.length() && s2.charAt(i) == op.charAt(0)){
          while(j< s2.length() && j-i < op.length() && s2.charAt(j) ==
          op.charAt(j-i)){
              j++;
          }
          b = (j-i) >= op.length();
        }
        return b;

   }//Fim igualidade

   public static String alterWord(String s,int quant[]){
      String re = "";
        for(int i = 0;i<s.length();i++){
            int a = 0;
              while((char)('A' + a) != s.charAt(i) &&  a<quant.length){
                a++;
              }
              if(a>= quant.length){
                re+= s.charAt(i);
              }
              else{
                re+= (char)(quant[a] + '0');
              }
        }
        return re;
   }//Fim alterWord

  public static String replace(String s2, String op, String op2){
      String re = "";
      for(int i = 0;i<s2.length();i++){
        if(igualidade(s2,op,i)){
          re += op2;
          i+= op.length()- 1;
        }
        else{
          re+= s2.charAt(i);
        }
      }
      return re;
  }//Fim replace

 }//Fim classe
