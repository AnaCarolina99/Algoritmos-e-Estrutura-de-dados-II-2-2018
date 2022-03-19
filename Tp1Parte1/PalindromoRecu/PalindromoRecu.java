/**
 *
 * @author Ana Carolina Medeiros Gonçalves
 */

public class PalindromoRecu{
   public static void main(String[] args){
	String entrada[] = new String[1000];
	int numEntrada = 0;
	String parada = "FIM";
  int j = 0;
	do{
	entrada[numEntrada] = MyIO.readLine();
	}while(equals(entrada[numEntrada++],parada)==false);
	numEntrada--;
	for(int i = 0;i<numEntrada;i++){
      	if(pa(entrada[i]) == true){
		MyIO.println("SIM");
	}
	else
		MyIO.println("NAO");

	}
}//Fim main

        //Metodo que retorna o metodo rescursivo 
        public static boolean pa(String s){
            return pa(s,0);
      	}//Fim pa

        //Metodo que inverte uma String e depois retorna ela invertidas
        public static String pg(String s){
            String re = "";
              for(int i = s.length()- 1;i >= 0;i--){
                  re += s.charAt(i);
              }
              return re;
        }//Fim pg

  //Metodo recursivo para comparar Strings e retornar boolean
	public static boolean pa(String s,int j){
      boolean resp = true;
      String c = pg(s);
      if(j < s.length()){
          if(s.charAt(j) == c.charAt(j)){
            resp = resp && pa(s,j+1);
          }
          else return false;
      }
      return resp;
    }//Fim pa

  //Metodo que compara duas Strings e retorna boolean
	public static boolean equals(String s, String re){
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
