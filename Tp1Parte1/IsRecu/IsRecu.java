/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */

public class IsRecu{

  public static void main(String[] args){
    String entrada = MyIO.readLine();
    String fim = "FIM";
    //vogais
    while(Equals(entrada, fim)==false){
      if(isVogal(entrada) == true){
        System.out.print("SIM ");
      }else{
        System.out.print("NAO ");
      }
      //cosoantes
      if(isConsoant(entrada)){
        System.out.print("SIM ");
      }else{
        System.out.print("NAO ");
      }
      //inteiros
      if(isInt(entrada)){
        System.out.print("SIM ");
      }else{
        System.out.print("NAO ");
      }
      //real
      if(isReal(entrada)){
        System.out.println("SIM");
      }else{
        System.out.println("NAO");
      }
      entrada = MyIO.readLine();
    }

  }//Fim main


  //Metodo que retorna o metodo recursivo isVogal
  public static boolean isVogal(String s){

    return isVogal(s,0);
  }//Fim isVogal

      //Metodo para verificar se a string e composta somente por vogais e retornar um boolean
      public static boolean isVogal(String s, int i){
        boolean resp = true;
      if(i<s.length() && resp != false){
        if(s.charAt(i) == 'A' || s.charAt(i) == 'a' || s.charAt(i) == 'E'||
           s.charAt(i) == 'e' || s.charAt(i) == 'I' || s.charAt(i) == 'i'||
           s.charAt(i) == 'O' || s.charAt(i) == 'o' || s.charAt(i) == 'U'||
           s.charAt(i) == 'u' ){
             resp = isVogal(s,i+1);
        }
        else{
          resp = false;
        }

      }
      return resp;
    }//Fim isVogal

    //Metodo que retorna o metodo recursivo isConsoant
  public static boolean isConsoant(String s){

    return isConsoant(s,0);
  }//Fim isConsoant

  //Metodo para verificar se a string e composta somente por consoantes e retornar um boolean
  public static boolean isConsoant(String s,int i){
    boolean resp = true;
   if(i<s.length() && resp != false){
     if(s.charAt(i) != 'A' && s.charAt(i) != 'a' && s.charAt(i) != 'E' &&
        s.charAt(i) != 'e' && s.charAt(i) != 'I' && s.charAt(i) != 'i' &&
        s.charAt(i) != 'O' && s.charAt(i) != 'o' && s.charAt(i) != 'U' &&
        s.charAt(i) != 'u' && s.charAt(i) != '0' && s.charAt(i) != '1' &&
        s.charAt(i) != '2' && s.charAt(i) != '3' && s.charAt(i) != '4' &&
        s.charAt(i) != '5' && s.charAt(i) != '6' && s.charAt(i) != '7' &&
        s.charAt(i) != '8' && s.charAt(i) != '9' ){
          resp = isConsoant(s,i+1);
     }
     else{
       resp = false;
     }

   }
   return resp;
 }//Fim isConsoant

 //Metodo que retorna o metodo recursivo isInt
  public static boolean isInt(String s){

    return isInt(s,0);
  }//Fim isInt

  //Metodo para verificar se a string e composta somente por numeros inteiros e retornar um boolean
  public static boolean isInt(String s, int i){
   boolean resp = true;
   if(i<s.length()){
     if(s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' ||
        s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' ||
        s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9' ||
        s.charAt(i) == '0'){
          resp = isInt(s,i+1);

     }else{
       resp = false;
     }

   }
   return  resp;
 }//Fim isInt

//Metodo que retorna o metodo recursivo isReal
  public static boolean isReal(String s){

    return isReal(s,0, false);

  }//FIm isReal

  //Metodo para verificar se a string e composta por numeros reais e retornar um boolean
  public static boolean isReal(String s,int i, boolean v){
    boolean resp = true;
    if(i<s.length()){
      if( s.charAt(i) == '0' || s.charAt(i) == '.' || s.charAt(i) == ','
      || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' ||
           s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' ||
           s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9'){

        if(s.charAt(i) == '.' || s.charAt(i) == ','){
          if(v)resp = false;
          else {
            v = true;
            resp = isReal(s, i+1, v);
          }
        }
        else{
          resp = isReal(s, i+1, v);
        }

      }else{
        resp = false;
      }
    }
    return resp;
  }//Fim isReal

  //Metodo que compara duas Strings e retorna boolean
  public static boolean Equals(String s, String re){
    boolean e = false;
    int size = s.length();
    int size2 = re.length();
      if(size == size2){
        for(int i = 0;size>i;i++){
          if(s.charAt(i) == re.charAt(i)){
            e = true;
          }
          else{
            e = false;
            i = size;
          }
        }
      }
        return e;
   }//Fim equals

}//Fim classe
