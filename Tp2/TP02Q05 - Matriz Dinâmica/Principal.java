class Celula {
   public int elemento;
   public Celula inf, sup, esq, dir;
   //Construtor Celula
   public Celula(){
      this(0, null, null, null, null);
   }//Fim construtor

   //Construtor Celula
   public Celula(int elemento){
      this(elemento, null, null, null, null);
   }//Fim construtor

   //Construtor Celula
   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }//Fim construtor

}//Fim classe
class Matriz {
   private Celula inicio;
   private int linha, coluna;
   //Construtor Matriz
   public Matriz (int tamanho){
      this.linha = this.coluna = tamanho;
   }//Fim construtor
   //Construtor Matriz
   public Matriz (int linha, int coluna){
      this.linha = linha;
      this.coluna = coluna;
      Celula col = null;
      Celula lin = null;
      for(int i = 0;i<linha;i++){
        for(int j = 0;j<coluna;j++){
            if(i==0 && j ==0){
              inicio = new Celula();
              col = inicio;
              lin= inicio;
            }else if(j!=0){
              col.dir = new Celula();
              col.dir.esq = col;
              col = col.dir;

              if(i!=0){
                col.esq.sup.dir.inf =col;
                col.sup = col.esq.sup.dir;
              }
            }
          }//Fim for j
          if(1+ i != linha){
            lin.inf = new Celula();
            lin.inf.sup= lin;
            lin = lin.inf;
            col = lin;
          }
      }//Fim for "i"
   }//Fim construtor

//Metodo para inserir e percorrer uma matriz
   public void inserir(){
     String[] r = new String[linha];
      for(int i = 0;i< linha;r[i] = MyIO.readLine(),i++);
      int i = 0;
      int j = 0;
        for(Celula l = inicio;l != null;l = l.inf,j++){
          String[] v = r[j].split(" ");
          i = 0;
          for(Celula c = l;c != null;c = c.dir,i++){
              c.elemento = Integer.parseInt(v[i]);
          }
        }
   }//Fim metodo
   
//Metodo que soma os elementos de uma Matriz e retorna o seu valor
   public static Matriz soma (Matriz m, Matriz m2) {
      Matriz resp = new Matriz(m.linha, m2.coluna);
          for(Celula l = resp.inicio, linha1 = m.inicio, linha2 = m2.inicio; l != null; l= l.inf, linha1= linha1.inf,linha2= linha2.inf){
            for(Celula c = l, coluna1 =linha1, coluna2 = linha2; c != null; c= c.dir, coluna1= coluna1.dir,coluna2= coluna2.dir){
                c.elemento = coluna1.elemento + coluna2.elemento;
            }
          }

      return resp;
   }//Fim metodo

//Metodo que multiplica os elementos de uma Matriz e retorna o seu valor
   public static Matriz multiplicacao (Matriz m, Matriz m2, int x) {
      Matriz resp = new Matriz(m.linha, m2.coluna);
      for(Celula l = resp.inicio, linha1 = m.inicio; l != null; l= l.inf, linha1= linha1.inf){
        for(Celula c = l, coluna1 =m2.inicio; c != null; c= c.dir, coluna1= coluna1.dir){
            x = 0;
            for(Celula colunaA = linha1, linhaB = coluna1; colunaA != null; colunaA= colunaA.dir, linhaB = linhaB.inf){
              x+= colunaA.elemento*linhaB.elemento;
            }
            c.elemento = x;
        }
      }
      return resp;
   }//Fim metodo


//Metodo para chamar o metodo mostrarDiagonalPrincipal
   public void mostrarDiagonalPrincipal(){
     mostrarDiagonalPrincipal(inicio);
     System.out.println();
   }//Fim metodo

//Metodo para mostrar a diagonal principal de uma Matriz na tela
   public void mostrarDiagonalPrincipal(Celula m){
     System.out.print(m.elemento + " ");
      if((m.dir != null) && (m.dir.inf != null))
        mostrarDiagonalPrincipal(m.dir.inf);
   }//Fim metodo

//Metodo para percorrer a matriz e chamar o metodo mostrarDiagonalSecundaria
   public void mostrarDiagonalSecundaria(){
     Celula r;
      for(r = inicio;r.dir != null;r=r.dir);
            mostrarDiagonalSecundaria(r);
     System.out.println();
   }//Fim metodo

//Metodo para mostrar a diagonal secundaria de uma Matriz na tela
   public void mostrarDiagonalSecundaria(Celula r){
     System.out.print(r.elemento + " ");
      if((r.esq != null) && (r.esq.inf != null))
      mostrarDiagonalSecundaria(r.esq.inf);
   }//Fim metodo

//Metodo para mostrar uma Matriz na tela
   public void mostrar(){
     for(Celula l = inicio; l != null; l= l.inf){
       for(Celula c = l; c != null; c= c.dir){
         System.out.print(c.elemento + " ");
   }
    System.out.println();
  }

 }//Fim metodo

}//Fim Classe

class Principal {

   public static void main(String[] args){
      int cont = Integer.parseInt(MyIO.readLine());
      int linhas = 0;
      int colunas = 0;
        for(int i =0;i < cont; i++){
            linhas = Integer.parseInt(MyIO.readLine());
            colunas = Integer.parseInt(MyIO.readLine());
            Matriz m1 = new Matriz(linhas,colunas);
            m1.inserir();
            linhas = Integer.parseInt(MyIO.readLine());
            colunas = Integer.parseInt(MyIO.readLine());
            Matriz m2 = new Matriz(linhas,colunas);
            m2.inserir();
            m1.mostrarDiagonalPrincipal();
            m1.mostrarDiagonalSecundaria();
            Matriz.soma(m1,m2).mostrar();
            Matriz.multiplicacao(m1,m2,0).mostrar();
        }//Fim for
   }//Fim main
}//Fim classe
