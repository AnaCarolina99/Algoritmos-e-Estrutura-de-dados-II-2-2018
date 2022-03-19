import java.io.*;
import java.*;
import java.io.RandomAccessFile;

/**
 *
 * @author Ana Carolina Medeiros Goncalves
 */

public class Arq{
  int q;
  long cont;
  double real;

  public static void main(String[] args) throws Exception{
      Arq arq = new Arq();
      arq.ler();
      arq.inverso();
  }//Fim main

  //Metodo para escrever no arquivo criado
  public void ler() throws Exception, IOException{
      RandomAccessFile r = new RandomAccessFile("tp.txt","rw");
      q = MyIO.readInt();
      for(int i = 0;i<q;i++){
          real = MyIO.readDouble();
          r.writeDouble(real);
      }
      cont = r.getFilePointer() - 8;
      r.close();
  }//Metodo ler

  //Metodo para inverter a ordem do arquivo criado lendo de tras para frente
  public  void inverso() throws Exception{
      RandomAccessFile r = new RandomAccessFile("tp.txt","rw");
      for(int i = 0;i<q;i++){
          r.seek(cont);
          real = r.readDouble();
          if(real == (int) real){
            MyIO.println((int) real);
          }

          else{
            MyIO.println(real);
          }
          cont = cont - 8;
      }

      r.close();
  }//Fim inverso

}//Fim classe
