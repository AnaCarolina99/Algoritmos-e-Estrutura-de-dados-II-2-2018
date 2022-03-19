class Celula {
   public int elemento;
   public Celula inf, sup, esq, dir;

   public Celula(){
      this(0, null, null, null, null);
   }

   public Celula(int elemento){
      this(elemento, null, null, null, null);
   }

   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }
}
class Matriz {
   private Celula inicio;
   private int linha, coluna;

   public Matriz (int tamanho){
      this.linha = this.coluna = tamanho;
   }

   public Matriz (int linha, int coluna){
      this.linha = linha;
      this.coluna = coluna;
      Celula col = null;
      Celula lin = null;
      for(int i = 0;i<linha;i++){
        for(int j = 0;j<linha;j++){
            if(i==0 && j ==0){
              inicio = new Celula();
              col = inicio;
              lin= inicio;
            }else if(j!=0){
              col.dir = new Celula();
              col.dir.esq = col;
              col = col.dir;
            }
            if(i!=0){
              col.esq.sup.dir.inf =col;
              col.sup = col.esq.sup.dir;
            }
        }

          if(1+ i != linha){
            lin.inf = new Celula();
            lin.inf.sup= lin;
            lin = lin.sup;
            col = lin;
          }
      }
   }

   public void inserir(){
     String[] r = new String[linha];
      for(int i = 0;i< linha;r[i] = MyIO.readLine(),i++);
      int i = 0;
      int j = 0;
        for(Celula l = inicio;l != null;l = l.inf,i++){
          String[] v = r[i].split(" ");
          j = 0;
          for(Celula c = inicio;c != null;c = c.dir,j++){
              c.elemento = Integer.parseInt(v[j]);
          }
        }
   }

   public Matriz soma (Matriz m, Matriz m2) {
      Matriz resp = new Matriz(m.linha, m2.linha);
          for(Celula l = resp.inicio, linha1 = m.inicio, linha2 = m2.inicio; l != null; l= l.inf, linha1= linha1.inf,linha2= linha2.inf){
            for(Celula c = l, coluna1 =linha1, coluna2 = linha2; c != null; c= c.dir, coluna1= coluna1.dir,coluna2= coluna2.dir){
                c.elemento = coluna1.elemento + coluna2.elemento;
            }
          }

      return resp;
   }

   public Matriz multiplicacao (Matriz m, Matriz m2, int x) {
      Matriz resp = new Matriz(m.linha, m2.linha);
      for(Celula l = resp.inicio, linha1 = m.inicio, linha2 = m2.inicio; l != null; l= l.inf, linha1= linha1.inf,linha2= linha2.inf){
        for(Celula c = l, coluna1 =linha1, coluna2 = linha2; c != null; c= c.dir, coluna1= coluna1.dir,coluna2= coluna2.dir){
            x = 0;
            for(Celula colunaA = linha1, linhaB = coluna1; colunaA != null; colunaA= colunaA.dir, linhaB = linhaB.inf){
              x+= colunaA.elemento*linhaB.elemento;
            }
            c.elemento = x;
        }
      }
      return resp;
   }

   /*public boolean isQuadrada(){
      boolean (this.linha == this.coluna);
   }

   public void mostrarDiagonalPrincipal (){
      if(isQuadrada() == true){
         for(Celula i = inicio; i != null; i = i.inf.dir){
            Sop(i.elemento);
         }
      }
   }

   public void mostrarDiagonalSecundaria (){
      if(isQuadrada() == true){

      }
   }
*/
   public void mostrar(){
     for(Celula l = inicio; l != null; l= l.inf){
       for(Celula c = l; c != null; c= c.dir){
         System.out.print(c.elemento + " ");
   }
    System.out.println();
  }
 }

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
        }
   }
}
