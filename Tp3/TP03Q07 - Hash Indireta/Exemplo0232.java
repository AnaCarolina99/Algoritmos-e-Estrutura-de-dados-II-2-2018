/**
* Exemplo0221
*
* @author
* @version 01
*/
// ---------------------------------------------- dependencias
//import IO.*;
// ---------------------------------------------- definicao de classe auxiliar
/**
* Classe para tratar contatos.
*/
class Contato
{

/**
* atributos.
*/
public String nome;
public String fone;
/**
* construtor padrao.
*/
public Contato ( )
{
// atribuir valores iniciais nulos
nome = null;
fone = null;
} // fim construtor padrao


private int erro;
/**
* indicar a existencia de erro.
*/
public boolean hasErro ( )
{
   return ( getErro( ) != 0 );
} // end hasErro ( )
/**
* obter o codigo de erro.
*/
public int getErro ( )
{
   return ( erro );
} // end getErro ( )
/**
* estabelecer novo codigo de erro.
*/
private void setErro ( int codigo )
{
   erro = codigo;
} // end setErro ( )
//Ler e atribuir a variavel nome
public String lerNumero(){
   fone = MyIO.readLine();
   MyIO.println(fone);
   return fone;
}

//Testar a variavel nome
public boolean verificarNumero(){
  boolean resp = false;
   if(lerNome() != null){
     resp = true;
   }
   else{
     MyIO.println("Nome vazio");
     resp = false;
   }
   return resp;

}
/**
* construtor alternativo.
*/
public Contato (String nomeInicial, String foneInicial )
{
// testar e inserir valores iniciais
   setErro ( 0 ); // ainda n�o h� erro
   if ( true ) // <modificar o teste>
   {
      setErro ( 1 ); // ERRO: Nome invalido.
   }
   else
   {
      setNome ( nomeInicial );
   } // fim se
// testar e atribuir telefone inicial
// <incluir teste semelhante para telefone>
} // fim construtor alternativo
/**
* obter o nome.
*/
public String getNome ( )
{
   return ( nome );
} // end getNome ( )
/**
* obter o telefone.
*/
public String getFone ( )
{
   return ( fone );
} // end getFone ( )
/**
* estabelecer novo nome.
*/
public void setNome ( String novoNome )
{
   nome = novoNome;
} // end setNome ( )
/**
* estabelecer novo telefone.
*/
public void setFone ( String novoFone )
{
   fone = novoFone;
} // end setFone ( )
/**
* obter os conteudos do objeto.
*
* @return dados contidos no objeto.
*/
public String toString ( )
{
   return ( ""+nome+" - "+fone );
} // end toString ( )
/**
* clonar os conteudos do objeto.
*
* @return copia dos dados contidos no objeto.
*/
public Contato clone ( )
{
   Contato copia = new Contato ( );
   if ( copia == null || hasErro( ) )
   {
      setErro ( 3 ); // ERRO: Problema ao copiar.
   }
   else
   {
      if ( copia != null )
      {
         copia.setNome ( getNome( ) );
         copia.setFone ( getFone( ) );
      } // fim se
   } // fim se
   return ( copia );
} // end clone ( )

/**
* Testar definições da classe Contato.
*/
public void metodo01 ( )
{
// 1. definir dados
Contato a1 = null;
Contato a2 = new Contato ( );
// 2. identificar
MyIO.println ( "Definicoes da Contato" );
// 3. testar as definicoes da Contato
if ( a1 == null )
{
MyIO.println ( "Contato a1 nulo" );
}
else
{
MyIO.println ( "Contato a1 nao nulo" );
} // fim se
if ( a2 == null )
{
MyIO.println ( "Contato a2 nulo" );
}
else
{
MyIO.println ( "Contato a2 nao nulo" );
} // fim se
// encerrar
MyIO.println ( );
MyIO.pause ( "Apertar ENTER para continuar." );
} // fim metodo01 ( )



} // fim da classe Contato// ---------------------------------------------- definicao da classe principal
public class Exemplo0232
{


// ---------------------------------------------- definicao do metodo principal
/**
* main() – metodo principal
*/
public static void main ( String [ ] args )
{
// identificar
MyIO.println ( "EXEMPLO0201 - Programa em Java" );
MyIO.println ( "Autor: ________________________" );
// criar e executar o metodo auxiliar
Contato m1 = new Contato ( );
m1.metodo01 ( );
m1.lerNumero();
m1.verificarNumero();
// encerrar
//MyIO.pause ( “Apertar ENTER para terminar.” );
} // fim main( )
} // fim class Exemplo0221
