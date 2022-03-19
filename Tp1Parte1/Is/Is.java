/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */

 public class Is{
   public static void main(String[] args){
     String entrada = MyIO.readLine();
     String fim = "FIM";
     while(equals(entrada, fim)==false){
       if(isVogal(entrada)){
         System.out.print("SIM ");
       }else{
         System.out.print("NAO ");
       }

       if(isConsoant(entrada)){
         System.out.print("SIM ");
       }else{
         System.out.print("NAO ");
       }

       if(isInt(entrada)){
         System.out.print("SIM ");
       }else{
         System.out.print("NAO ");
       }

       if(isReal(entrada)){
         System.out.println("SIM");
       }else{
         System.out.println("NAO");
       }
       entrada = MyIO.readLine();
     }
   }//Fim main

   //Metodo que verifica se uma String contem somente vogais e retorna um boolean
   public static boolean isVogal(String entrada){
    boolean resp = false;
    int cont = 0;
    for(int i = 0;i<entrada.length();i++){
        if(entrada.charAt(i) == 'a' ||entrada.charAt(i) == 'e' ||entrada.charAt(i) == 'i' ||
        entrada.charAt(i) == 'o' || entrada.charAt(i) == 'o' ||entrada.charAt(i) == 'u' ||
        entrada.charAt(i) == 'A' || entrada.charAt(i) == 'E' || entrada.charAt(i) == 'I' ||
        entrada.charAt(i) == 'O' || entrada.charAt(i) == 'U') {
          resp = true;
        }
        else{
          resp = false;
          i = entrada.length();
        }
      }
    return resp;
  }//Fim isVogal

  //Metodo que verifica se uma String contem somente consoates e retorna um boolean
   public static boolean isConsoant(String entrada){
    boolean resp = true;
    for(int i = 0;i<entrada.length();i++){
        if(entrada.charAt(i) != 'a' ||entrada.charAt(i) != 'e' ||entrada.charAt(i) != 'i' ||
        entrada.charAt(i) != 'o' || entrada.charAt(i) != 'o' ||entrada.charAt(i) != 'u' ||
        entrada.charAt(i) != 'A' || entrada.charAt(i) != 'E' || entrada.charAt(i) != 'I' ||
        entrada.charAt(i) != 'O' || entrada.charAt(i) != 'U' || entrada.charAt(i) != '0'
        || entrada.charAt(i) != '1' || entrada.charAt(i) != '2' || entrada.charAt(i) != '3'
        || entrada.charAt(i) != '4' || entrada.charAt(i) != '5' || entrada.charAt(i) != '6'
        || entrada.charAt(i) != '7' || entrada.charAt(i) != '8' || entrada.charAt(i) != '9') {
          resp = false;
          i = entrada.length();
        }
      }
      return resp;
   }//Fim isConsoant
   //Metodo que verifica se uma String contem somente numeros inteiros e retorna um boolean
   public static boolean isInt(String entrada){
    boolean resp = false;
    for(int i = 0;i<entrada.length();i++){
        if(entrada.charAt(i) == '0' ||entrada.charAt(i) == '1' || entrada.charAt(i) == '2' ||
        entrada.charAt(i) == '3' || entrada.charAt(i) == '4' || entrada.charAt(i) == '5' ||
        entrada.charAt(i) == '6' || entrada.charAt(i) == '7' || entrada.charAt(i) == '8' ||
        entrada.charAt(i) == '9') {
          resp = true;
        }
        else{
          resp = false;
          i = entrada.length();
        }
      }
      return resp;
   }//Fim isInt

//Metodo que verifica se uma String contem numeros reais e retorna um boolean
   public static boolean isReal(String entrada){
    boolean resp = true;
    for(int i = 0;i<entrada.length();i++){
        if(entrada.charAt(i) == '0' ||entrada.charAt(i) == '1' || entrada.charAt(i) == '2' ||
        entrada.charAt(i) == '3' || entrada.charAt(i) == '4' || entrada.charAt(i) == '5' ||
        entrada.charAt(i) == '6' || entrada.charAt(i) == '7' || entrada.charAt(i) == '8' ||
        entrada.charAt(i) == '9' || entrada.charAt(i) == '.' || entrada.charAt(i) == ',') {
          resp = true;
        }

        else{
          resp = false;
          i = entrada.length();
        }
      }
      int cont = 0;
      for(int i = 0;i<entrada.length();i++){
        if(entrada.charAt(i) == '.' || entrada.charAt(i) == ','){
          cont++;
        }

      }
        if(cont >1){
          resp = false;
        }

      return resp;
   }//Fim isReal

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
