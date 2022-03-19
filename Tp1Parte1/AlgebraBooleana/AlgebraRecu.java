/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */

public class AlgebraRecu{
  public static void main(String[] args) {
    leAte0();
  }//Fim main


  //Metodo que controla a condicao de parada do programa(Flag = 0) e tambem chama os demais metodos.
  public static void leAte0(){
    int i = MyIO.readInt();
    while(i != 0){
      int[] qntValores = criaArranjo(i);
      String expressao = MyIO.readLine();
      String expressao2 = alterLetra(expressao, qntValores);
      MyIO.println(resolve(expressao2));

      i = MyIO.readInt();
    }
    
  }//Fim leAte0


   //Metodo que cria e retorna um arranjo com o as entradas da expressao booleana.
  public static int[] criaArranjo(int i){
    int arrayEnt[] = new int[i];
    for(int x = 0; x < i; x++){
      arrayEnt[x] = MyIO.readInt();
    }
    return arrayEnt;
  }//Fim criaArranjo


  //Metodo que substitui as letras por 0 ou 1 dependendo da expressao booleana.
  public static String alterLetra(String expressao,int qntValores[]){
    String r = "";
    for(int i = 0; i < expressao.length(); i++){
      int c = 0;
      while(c < qntValores.length && (char)('A' + c) != expressao.charAt(i)){
        c++;
      }
      if(c >= qntValores.length){
        r+= expressao.charAt(i);
      }
      else{
        r+= (char) (qntValores[c] + '0');
      }
    }
    return r;
  }//Fim alterLetra


   //Metodo que resolve e retorna o valor final da expressao booleana(com a ajuda de metodos auxiliares).
  public static char resolve(String expressao2){
    String[] opcoes =
    {" ",
    "not(0)",
    "not(1)",
    "and(0,0)",
    "and(1,1)",
    "and(0,1)",
    "and(1,0)",
    "and(0,0,",
    "and(1,1,",
    "and(0,1,",
    "and(1,0,",
    "or(0,0)",
    "or(1,1)",
    "or(0,1)",
    "or(1,0)",
    "or(0,0,",
    "or(1,1,",
    "or(0,1,",
    "or(1,0,"
    };

    String[] opcoes2 =
    {"",
    "1",
    "0",
    "0",
    "1",
    "0",
    "0",
    "and(and(0,0),",
    "and(and(1,1),",
    "and(and(0,1),",
    "and(and(1,0),",
    "0",
    "1",
    "1",
    "1",
    "or(or(0,0),",
    "or(or(1,1),",
    "or(or(0,1),",
    "or(or(1,0),"
    };

    while(expressao2.charAt(0) != '0' && expressao2.charAt(0) != '1'){
      for(int i = 0; i < opcoes.length; i++){
        expressao2 = replace(expressao2, opcoes[i], opcoes2[i]);
      }
    }
    return expressao2.charAt(0);
  }//Fim resolve



  //Metodo que substitui a expressao booleana por seu resultado(0 ou 1).
  public static String replace(String frase, String estouProcu, String lugar){
    String nova = "";
    for(int i = 0; i < frase.length(); i ++){
      if(saoIguais(frase, estouProcu, i)){
        nova += lugar;
        i += estouProcu.length() - 1;
      }
      else {
        nova += frase.charAt(i);
      }
    }
    return nova;
  }//Fim replace



  //Metodo que verifica se a String frase possui em sua composicao a String estouProcu.
  public static boolean saoIguais(String frase, String estouProcu, int i){
    boolean is = false;
    int j = i;
    if(frase.length() - i >= estouProcu.length() && frase.charAt(i) == estouProcu.charAt(0)){

      while(j < frase.length() && j - i < estouProcu.length() && frase.charAt(j) == estouProcu.charAt(j - i)){
        j++;
      }
      is = (j - i) >= estouProcu.length();
    }
    return is;
  }//Fim saoIguais

}//Fim classe
