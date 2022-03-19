/**
 *
 * @author Ana Carolina Medeiros Gonçalves
 *
 */
import java.io.*;
import java.net.*;
public class Html{
  public static void main(String[] args){
    String endereco, html;
    String entrada;
    String parada = "FIM";
    entrada = MyIO.readLine();
    while(equals(entrada,parada)== false){
      endereco = MyIO.readLine();
      html = getHtml(endereco);
      int controle = 0;
      int controle2 = 0;
      controle = table(html);
      controle2 = br(html);
        System.out.print("a("+(vogalA(html)-(1*controle))+")");
        System.out.print(" e("+(vogalE(html)-(1*controle))+")");
        System.out.print(" i("+vogalI(html)+")");
        System.out.print(" o("+vogalO(html)+")");
        System.out.print(" u("+vogalU(html)+")");
        System.out.print(" á("+vogalA2(html)+")");
        System.out.print(" é("+vogalE2(html)+")");
        System.out.print(" í("+vogalI2(html)+")");
        System.out.print(" ó("+vogalO2(html)+")");
        System.out.print(" ú("+vogalU2(html)+")");
        System.out.print(" à("+vogalA3(html)+")");
        System.out.print(" è("+vogalE3(html)+")");
        System.out.print(" ì("+vogalI3(html)+")");
        System.out.print(" ò("+vogalO3(html)+")");
        System.out.print(" ù("+vogalU3(html)+")");
        System.out.print(" ã("+vogalA4(html)+")");
        System.out.print(" õ("+vogalO4(html)+")");
        System.out.print(" â("+vogalA5(html)+")");
        System.out.print(" ê("+vogalE5(html)+")");
        System.out.print(" î("+vogalI5(html)+")");
        System.out.print(" ô("+vogalO5(html)+")");
        System.out.print(" û("+vogalU5(html)+")");
        System.out.print(" consoante("+(consoant(html)-(controle * 3)-(controle2 * 2))+")");
        System.out.print(" <br>("+br(html)+")");
        System.out.print(" <table>("+table(html)+")");
        System.out.print(" " + entrada + "\n");
      entrada = MyIO.readLine();
    }

  }//FIm main

  //Metodo que le um link html e retorna o arquivo html como String
  public static String getHtml(String endereco){
     URL url;
     InputStream is = null;
     BufferedReader br;
     String resp = "", line;

     try {
        url = new URL(endereco);
        is = url.openStream();  // throws an IOException
        br = new BufferedReader(new InputStreamReader(is));

        while ((line = br.readLine()) != null) {
           resp += line + "\n";
        }
     } catch (MalformedURLException mue) {
        mue.printStackTrace();
     } catch (IOException ioe) {
        ioe.printStackTrace();
     }

     try {
        is.close();
     } catch (IOException ioe) {
         //tratar erro
     }

     return resp;
}//Fim getHtml

//Metodo que conta e retorna a quantidade de letras 'a' contido no arquivo lido
public static int vogalA(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'a'){
          cont++;
        }
    }
    return cont;
}
//Metodo que conta e retorna a quantidade de letras 'e' contido no arquivo lido
public static int vogalE(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'e'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'i' contido no arquivo lido
public static int vogalI(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'i'){
          cont++;
        }
    }
    return cont;
}
//Metodo que conta e retorna a quantidade de letras 'o' contido no arquivo lido
public static int vogalO(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'o'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'u' contido no arquivo lido
public static int vogalU(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'u'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'á' contido no arquivo lido
public static int vogalA2(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'á'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'é' contido no arquivo lido
public static int vogalE2(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'é'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'í' contido no arquivo lido
public static int vogalI2(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'í'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'ó' contido no arquivo lido
public static int vogalO2(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'ó'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'ú' contido no arquivo lido
public static int vogalU2(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'ú'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'à' contido no arquivo lido
public static int vogalA3(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'à'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'è' contido no arquivo lido
public static int vogalE3(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'è'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'ì' contido no arquivo lido
public static int vogalI3(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'ì'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'ò' contido no arquivo lido
public static int vogalO3(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'ò'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'ù contido no arquivo lido
public static int vogalU3(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'ù'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'ã' contido no arquivo lido
public static int vogalA4(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'ã'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'õ' contido no arquivo lido
public static int vogalO4(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'õ'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'â' contido no arquivo lido
public static int vogalA5(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'â'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'ê' contido no arquivo lido
public static int vogalE5(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'ê'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'î' contido no arquivo lido
public static int vogalI5(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'î'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'ô' contido no arquivo lido
public static int vogalO5(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'ô'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de letras 'û' contido no arquivo lido
public static int vogalU5(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == 'û'){
          cont++;
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de consoantes contido no arquivo lido
 public static int consoant(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) > 'a' && html.charAt(i) <= 'z'){
          if( html.charAt(i) != 'e' && html.charAt(i) != 'i' && html.charAt(i) != 'o' && html.charAt(i) != 'u'){
              cont++;
          }
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de 'br' contido no arquivo lido
public static int br(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == '<'){
          if(html.charAt(i+1) == 'b'){
            if(html.charAt(i+2) == 'r'){
              if(html.charAt(i+3) == '>'){
                cont++;
              }
            }
          }
        }
    }
    return cont;
}

//Metodo que conta e retorna a quantidade de 'table' contido no arquivo lido
public static int table(String html){
    int cont = 0;
    for(int i = 0;i<html.length();i++){
        if(html.charAt(i) == '<'){
          if(html.charAt(i+1) == 't'){
            if(html.charAt(i+2) == 'a'){
              if(html.charAt(i+3) == 'b'){
                if(html.charAt(i+4) == 'l'){
                  if(html.charAt(i+5) == 'e'){
                    if(html.charAt(i+6) == '>'){
                      cont++;
                    }
                  }
                }
              }
            }
          }
        }
    }
    return cont;
}

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
