import java.io.File;

class No {
    public Docente elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.
    public int nivel;

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    public No(Docente elemento) {
        this(elemento, null, null,1);
    }

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    public No(Docente elemento, No esq, No dir, int nivel) {
        this.elemento = elemento.clone();
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }

    // Cálculo do número de níveis a partir de um vértice
   public No setNivel() {
      this.nivel = 1 + Math.max(getNivel(esq),getNivel(dir));
      return this;
   }

   // Retorna o número de níveis a partir de um vértice
   public static int getNivel(No no) {
      return (no == null) ? 0 : no.nivel;
   }
}

/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */

  class AVL {
     private No raiz; // Raiz da arvore.
     public int comparacoes;//Numero de comparacoes feitas
     /**
      * Construtor da classe.
      */
     public AVL() {
         raiz = null;
         comparacoes = 0;
     }
     //metodo para obter altura da arvore
    public int getAltura() {
       return No.getNivel(raiz) - 1;
    }
    //Metodo para obter o nivel
    public static int nivel(No no) {
       return (no == null) ? 0 : (1 + Math.max(nivel(no.esq),nivel(no.dir)));
    }

     /**
      * Metodo publico iterativo para pesquisar elemento.
      * @param elemento Elemento que sera procurado.
      * @return <code>true</code> se o elemento existir,
      * <code>false</code> em caso contrario.
      */
     public boolean pesquisar(String elemento) {
       MyIO.print(elemento +" raiz");
         return pesquisar(raiz, elemento);
     }

     /**
      * Metodo privado recursivo para pesquisar elemento.
      * @param no No em analise.
      * @param x Elemento que sera procurado.
      * @return <code>true</code> se o elemento existir,
      * <code>false</code> em caso contrario.
      */
     private boolean pesquisar(No no, String x) {
       boolean resp;
         if (no == null) {
           comparacoes++;
           MyIO.println(" NÃO");
          resp = false;

       } else if (x.equals(no.elemento.getSigla())) {
         comparacoes++;
          resp = true;
          MyIO.println(" SIM");

       } else if (x.compareTo(no.elemento.getSigla()) < 0) {
         comparacoes++;
         MyIO.print(" esq");
          resp = pesquisar(no.esq, x);

       } else {
         comparacoes++;
         MyIO.print(" dir");
          resp = pesquisar(no.dir, x);
       }
       return resp;
     }

     /**
      * Metodo publico iterativo para exibir elementos.
      */
     public void mostrarCentral() {
         System.out.print("[ ");
         mostrarCentral(raiz);
         System.out.println("]");
     }

     /**
      * Metodo privado recursivo para exibir elementos.
      * @param no No em analise.
      */
     private void mostrarCentral(No no) {
         if (no != null) {
             mostrarCentral(no.esq); // Elementos da esquerda.
             System.out.print(no.elemento + " "); // Conteudo do no.
             mostrarCentral(no.dir); // Elementos da direita.
         }
     }

     /**
      * Metodo publico iterativo para exibir elementos.
      */
     public void mostrarPre() {
         System.out.print("[ ");
         mostrarPre(raiz);
         System.out.println("]");
     }

     /**
      * Metodo privado recursivo para exibir elementos.
      * @param no No em analise.
      */
     private void mostrarPre(No no) {
         if (no != null) {
             System.out.print(no.elemento + "(fator " + (No.getNivel(no.dir) - no.getNivel(no.esq)) + ") "); // Conteudo do no.
             mostrarPre(no.esq); // Elementos da esquerda.
             mostrarPre(no.dir); // Elementos da direita.
         }
     }

     /**
      * Metodo publico iterativo para exibir elementos.
      */
     public void mostrarPos() {
         System.out.print("[ ");
         mostrarPos(raiz);
         System.out.println("]");
     }

     /**
      * Metodo privado recursivo para exibir elementos.
      * @param no No em analise.
      */
     private void mostrarPos(No no) {
         if (no != null) {
             mostrarPos(no.esq); // Elementos da esquerda.
             mostrarPos(no.dir); // Elementos da direita.
             System.out.print(no.elemento + " "); // Conteudo do no.
         }
     }


     /**
      * Metodo publico iterativo para inserir elemento.
      * @param x Elemento a ser inserido.
      * @throws Exception Se o elemento existir.
      */
     public void inserir(Docente x) throws Exception {
         raiz = inserir(raiz, x);
     }

     /**
      * Metodo privado recursivo para inserir elemento.
      * @param no No em analise.
      * @param x Elemento a ser inserido.
      * @return No em analise, alterado ou nao.
      * @throws Exception Se o elemento existir.
      */
     private No inserir(No no, Docente x) throws Exception {
         if (no == null) {
           comparacoes++;
          //System.out.println("Inserindo o " + x);
          no = new No(x);

       } else if (x.getSigla().compareTo(no.elemento.getSigla()) < 0) {
          //System.out.println("-> esq");
          comparacoes++;
          no.esq = inserir(no.esq, x);

       } else if (x.getSigla().compareTo(no.elemento.getSigla()) > 0) {
         comparacoes++;
          //System.out.println("-> dir");
          no.dir = inserir(no.dir, x);

        }else if (x.getSigla().equals(no.elemento.getSigla())) {
          comparacoes++;
          return no;
          }

          else {
            comparacoes++;
          throw new Exception("Erro ao inserir elemento (" + x + ")! ");
       }

       no = balancear(no);
         return no;
     }

    private No balancear(No no) throws Exception {
       if(no != null){
          int fator = No.getNivel(no.dir) - no.getNivel(no.esq);

          //Se balanceada
          if (Math.abs(fator) <= 1){
            comparacoes++;
             no = no.setNivel();

          //Se desbalanceada para a direita
          }else if (fator == 2){
              comparacoes++;
             int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);

             //Se o filho a direita tambem estiver desbalanceado
             if (fatorFilhoDir == -1) {
               comparacoes++;
                no.dir = rotacionarDir(no.dir);
             }
             no = rotacionarEsq(no);

          //Se desbalanceada para a esquerda
          }else if (fator == -2){
              comparacoes++;
             int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);

             //Se o filho a esquerda tambem estiver desbalanceado
             if (fatorFilhoEsq == 1) {
               comparacoes++;
                no.esq = rotacionarEsq(no.esq);
             }
             no = rotacionarDir(no);

          }else{
            comparacoes++;
             throw new Exception("Erro fator de balanceamento (" + fator + ") invalido!");
          }
       }

       return no;
    }

    private No rotacionarDir(No no) {
       //System.out.println("Rotacionar DIR(" + no.elemento + ")");
       No noEsq = no.esq;
       No noEsqDir = noEsq.dir;

       noEsq.dir = no;
       no.esq = noEsqDir;

       no.setNivel();
       noEsq.setNivel();

       return noEsq;
    }

    private No rotacionarEsq(No no) {
       //System.out.println("Rotacionar ESQ(" + no.elemento + ")");
       No noDir = no.dir;
       No noDirEsq = noDir.esq;

       noDir.esq = no;
       no.dir = noDirEsq;

       no.setNivel();
       noDir.setNivel();
       return noDir;
    }

     /**
      * Metodo publico iterativo para remover elemento.
      * @param elemento Elemento a ser removido.
      * @throws Exception Se nao encontrar elemento.
      */
     public void remover(Docente x) throws Exception {
         raiz = remover(raiz, x);
     }

     /**
      * Metodo privado recursivo para remover elemento.
      * @param no No em analise.
      * @param x Elemento a ser removido.
      * @return No em analise, alterado ou nao.
      * @throws Exception Se nao encontrar elemento.
      */
     private No remover(No no, Docente x) throws Exception {

         if (no == null) {
           comparacoes++;
          throw new Exception("Erro ao remover!");

       } else if (x.getSigla().compareTo(no.elemento.getSigla()) < 0) {
         comparacoes++;
          no.esq = remover(no.esq, x);

       } else if (x.getSigla().compareTo(no.elemento.getSigla()) > 0) {
         comparacoes++;
          no.dir = remover(no.dir, x);

       // Sem no a direita.
       } else if (no.dir == null) {
         comparacoes++;
          no = no.esq;

       // Sem no a esquerda.
       } else if (no.esq == null) {
         comparacoes++;
          no = no.dir;

       // No a esquerda e no a direita.
       } else {
         comparacoes++;
          no.esq = antecessor(no, no.esq);
         }

       no = balancear(no);
         return no;
     }

     /**
      * Metodo para trocar no removido pelo antecessor.
      * @param n1 No que teve o elemento removido.
      * @param n2 No da subarvore esquerda.
      * @return No em analise, alterado ou nao.
      */
     private No antecessor(No n1, No n2) {

       // Existe no a direita.
         if (n2.dir != null) {
           comparacoes++;
          // Caminha para direita.
             n2.dir = antecessor(n1, n2.dir);

       // Encontrou o maximo da subarvore esquerda.
         } else {
           comparacoes++;
             n1.elemento = n2.elemento; // Substitui N1 por N2.
             n2 = n2.esq; // Substitui N2 por N2.ESQ.
         }
         return n2;
     }
     //metodo get que recebe a variavel comparacoes
       public void setComp(int comparacoes){
     this.comparacoes = comparacoes;
   }//Fim setComp

   //metodo set que retorna a variavel comparacoes
   public int getComp(){
     return this.comparacoes;
   }//Fim getComp

 }

 /**
  *
  * @author Ana Carolina Medeiros Gonçalves
  * Feito com a ajuda de Darlan Francisco e Ana Luiza Pacheco
  */

 class Docente{
 	//AtributosString array[]
 	private String nome;
 	private String sigla;
 	private int codigoMantenedora;
 	private int codigo;
 	private String mantenedora;
 	private int categoria;
 	private int organizacao;
 	private int codigoMunicipio;
 	private String municipio;
 	private String uf;
 	private String regiao;
 	private int tecnico;
 	private int periodico;
 	private int livro;
 	private double receita;
 	private double transferencia;
 	private double outraReceita;
 	private double despesaDocente;
 	private double despesaTecnico;
 	private double despesaEncargo;
 	private double despesaCusteio;
 	private double despesaInvestimento;
 	private double despesaPesquisa;
 	private double despesaOutras;

 	//Construtor 1
 	public Docente(){
 		this.codigo = 0;
 		this.nome = "";
 		this.sigla = "";
 		this.codigoMantenedora = 0;
 		this.mantenedora = "";
 		this.categoria = 0;
 		this.organizacao= 0;
 		this.codigoMunicipio = 0;
 		this.municipio = "";
 		this.uf = "";
 		this.regiao = "";
 		this.tecnico = 0;
 		this.periodico = 0;
 		this.livro = 0;
 		this.receita = 0;
 		this.transferencia = 0;
 		this.outraReceita = 0;
 		this.despesaDocente = 0;
 		this.despesaTecnico = 0;
 		this.despesaEncargo = 0;
 		this.despesaCusteio = 0;
 		this.despesaInvestimento = 0;
 		this.despesaPesquisa = 0;
 		this.despesaOutras = 0;
 	}
 //Construtor 2
 	public Docente(int codigo,String nome,String sigla,int codigoMantenedora,String mantenedora
 			,int categoria,int organizacao,int codigoMunicipio,String municipio,String uf, String regiao
 			,int tecnico,int periodico,int livro,double receita,double transferencia,double despesaDocente,
 			double despesaTecnico,double despesaEncargo,double despesaCusteio,double despesaInvestimento,
 			double despesaPesquisa,double despesaOutras){
 		this.codigo = codigo;
 		this.nome = nome;
 		this.sigla = sigla;
 		this.codigoMantenedora = codigoMantenedora;
 		this.mantenedora = mantenedora;
 		this.categoria = categoria;
 		this.organizacao= organizacao;
 		this.codigoMunicipio = codigoMunicipio;
 		this.municipio = municipio;
 		this.uf = uf;
 		this.regiao = regiao;
 		this.tecnico = tecnico;
 		this.periodico = periodico;
 		this.livro = livro;
 		this.receita = receita;
 		this.transferencia = transferencia;
 		this.outraReceita = outraReceita;
 		this.despesaDocente = despesaDocente;
 		this.despesaTecnico = despesaTecnico;
 		this.despesaEncargo = despesaEncargo;
 		this.despesaCusteio = despesaCusteio;
 		this.despesaInvestimento = despesaInvestimento;
 		this.despesaPesquisa = despesaPesquisa;
 		this.despesaOutras = despesaOutras;
 	}

 	//Metodo get do atributo codigo
 	public int getCodigo(){
 		return this.codigo;
 	}// Fim getCodigo

 //Metodo set do atributo codigo
 	public void setCodigo(int codigo){
 		this.codigo = codigo;
 	}// Fim setCodigo

 //Metodo get do atributo Nome
 	public String getNome(){
 		return this.nome;
 	}// Fim getNome

 //Metodo set do atributo nome
 	public void setNome(String nome){
 		this.nome = nome;
 	}// Fim setNome

 //Metodo get do atributo sigla
 	public String getSigla(){
 		return this.sigla;
 	}// Fim getSigla

 //Metodo set do atributo sigla
 	public void setSigla(String sigla){
 		this.sigla = sigla;
 	}// Fim setSigla

 //Metodo get do atributo codigoMantenedora
 	public int getCodigoMantenedora(){
 		return this.codigoMantenedora;
 	}// Fim getCodigoMantenedora

 //Metodo set do atributo codigoMantenedora
 	public void setCodigoMantenedora(int codigoMantenedora){
 		this.codigoMantenedora = codigoMantenedora;
 	}// Fim setCodigoMantenedora

 //Metodo get do atributo mantenedora
 	public String getMantenedora(){
 		return this.mantenedora;
 	}// Fim getMantenedora

 //Metodo set do atributo mantenedora
 	public void setMantenedora(String mantenedora ){
 		this.mantenedora = mantenedora;
 	}// Fim setMantenedora

 //Metodo get do atributo categoria
 	public int getCategoria(){
 		return this.categoria;
 	}// Fim getCategoria

 //Metodo set do atributo categoria
 	public void setCategoria(int categoria){
 		this.categoria = categoria;
 	}// Fim setCategoria

 //Metodo get do atributo organizacao
 	public int getOrganizacao(){
 		return this.organizacao;
 	}// Fim getOrganizacao

 //Metodo set do atributo organizacao
 	public void setOrganizacao(int organizacao){
 		this.organizacao = organizacao;
 	}// Fim setOrganizacao

 //Metodo get do atributo codigoMunicipiomunicipio
 	public int getCodigoMunicipio(){
 		return this.codigoMunicipio;
 	}// Fim getCodigoMunicipio

 //Metodo set do atributo codigoMunicipio
 	public void setCodigoMunicipio(int codigoMunicipio){
 		this.codigoMunicipio = codigoMunicipio;
 	}// Fim setCodigoMunicipio

 //Metodo get do atributo municipio
 	public String getMunicipio(){
 		return this.municipio;
 	}// Fim getMunicipio

 //Metodo set do atributo municipio
 	public void setMunicipio(String municipio){
 		this.municipio = municipio;
 	}// Fim setMunicipio

 //Metodo get do atributo Uf
 	public String getUf(){
 		return this.uf;
 	}// Fim getUf

 //Metodo set do atributo uf
 	public void setUf(String sigla){
 		this.uf = uf;
 	}// Fim setUf

 //Metodo get do atributo regiao
 	public String getRegiao(){
 		return this.regiao;
 	}// Fim getRegiao

 //Metodo set do atributo regiao
 	public void setRegiao(String regiao){
 		this.regiao = regiao;
 	}// Fim setRegiao

 //Metodo get do atributo tecnico
 	public int getTecnico(){
 		return this.tecnico;
 	}// Fim getTecnico

 //Metodo set do atributo tecnico
 	public void setTecnico(int tecnico){
 		this.tecnico = tecnico;
 	}// Fim setTecnico

 //Metodo get do atributo periodico
 	public int getPeriodico(){
 		return this.periodico;
 	}// Fim getPeriodico

 //Metodo set do atributo periodico
 	public void setPeriodico(int periodico){
 		this.periodico = periodico;
 	}// Fim setPeriodico

 //Metodo get do atributo livro
 	public int getLivro(){
 		return this.livro;
 	}// Fim getLivro

 //Metodo set do atributo livro
 	public void setLivro(int livro){
 		this.livro = livro;
 	}// Fim setLivro

 //Metodo get do atributo receita
 	public double getReceita(){
 		return this.receita;
 	}// Fim getReceita

 //Metodo set do atributo receita
 	public void setReceita(double receita){
 		this.receita = receita;
 	}// Fim setReceita

 //Metodo get do atributo transferencia
 	public double getTransferencia(){
 		return this.transferencia;
 	}// Fim getTransferencia

 //Metodo set do atributo transferencia
 	public void setTransferencia(double transferencia){
 		this.transferencia = transferencia;
 	}// Fim setTransferencia

 //Metodo get do atributo outraReceita
 	public double getOutraReceita(){
 		return this.outraReceita;
 	}// Fim getOutraReceita

 //Metodo set do atributo outraReceita
 	public void setOutraReceitA(double outraReceita){
 		this.outraReceita = outraReceita;
 	}// Fim setOutraReceita

 //Metodo get do atributo despesaDocente
 	public double getDespesaDocente(){
 		return this.despesaDocente;
 	}// Fim getDespesaDocente

 //Metodo set do atributo despesaDocente
 	public void setDespesaDocente(double despesaDocente){
 		this.despesaDocente = despesaDocente;
 	}// Fim setDespesaDocente

 //Metodo get do atributo despesaTecnico
 	public double getDespesaTecnico(){
 		return this.despesaTecnico;
 	}// Fim getDespesaTecnico

 //Metodo set do atributo despesaTecnico
 	public void setDespesaTecnico(double despesaTecnico){
 		this.despesaTecnico = despesaTecnico;
 	}// Fim setDespesaTecnico

 //Metodo get do atributo despesaEncargo
 	public double getDespesaEncargo(){
 		return this.despesaEncargo;
 	}// Fim getDespesaEncargo

 //Metodo set do atributo despesaEncargo
 	public void setDespesaEncargo(double despesaEncargo){
 		this.despesaEncargo = despesaEncargo;
 	}// Fim setDespesaEncargo

 //Metodo get do atributo despesaCusteio
 	public double getDespesaCusteio(){
 		return this.despesaCusteio;
 	}// Fim getDespesaCusteio

 //Metodo set do atributo despesaCusteio
 	public void setDespesaCusteio(double despesaCusteio){
 		this.despesaCusteio = despesaCusteio;
 	}// Fim setDespesaCusteio

 //Metodo get do atributo despesaInvestimento
 	public double getDespesaInvestimento(){
 		return this.despesaInvestimento;
 	}// Fim getDespesaInvestimento

 //Metodo set do atributo despesaInvestimento
 	public void setDespesaInvestimento(double despesaInvestimento){
 		this.despesaInvestimento = despesaInvestimento;
 	}// Fim setDespesaInvestimento

 //Metodo get do atributo despesaPesquisa
 	public double getDespesaPesquisa(){
 		return this.despesaPesquisa;
 	}// Fim getDespesaPesquisa

 //Metodo set do atributo despesaPesquisa
 	public void setDespesaPesquisa(double despesaPesquisa){
 		this.despesaPesquisa = despesaPesquisa;
 	}// Fim setDespesaPesquisa

 //Metodo get do atributo despesaOutras
 	public double getDespesaOutras(){
 		return this.despesaOutras;
 	}// Fim getDespesaOutras

 //Metodo set do atributo despesaOutras
 	public void setDespesaOutras(double despesaOutras){
 		this.despesaOutras = despesaOutras;
 	}// Fim setDespesaOutras


 	//Metodo clone que retorna o objeto instanciado
 	public Docente clone(){
 		Docente docente = new Docente();

 		docente.codigo = this.codigo;
 		docente.nome = this.nome;
 		docente.sigla = this.sigla;
 		docente.codigoMantenedora = this.codigoMantenedora;
 		docente.mantenedora = this.mantenedora;
 		docente.categoria = this.categoria;
 		docente.organizacao = this.organizacao;
 		docente.codigoMunicipio = this.codigoMunicipio;
 		docente.municipio = this.municipio;
 		docente.uf = this.uf;
 		docente.regiao = this.regiao;
 		docente.tecnico = this.tecnico;
 		docente.periodico = this.periodico;
 		docente.livro = this.livro;
 		docente.receita = this.receita;
 		docente.transferencia = this.transferencia;
 		docente.outraReceita = this.outraReceita;
 		docente.despesaDocente = this.despesaDocente;
 		docente.despesaTecnico = this.despesaTecnico;
 		docente.despesaEncargo = this.despesaEncargo;
 		docente.despesaCusteio = this.despesaCusteio;
 		docente.despesaInvestimento = this.despesaInvestimento;
 		docente.despesaPesquisa = this.despesaPesquisa;
 		docente.despesaOutras = this.despesaOutras;
 		return docente;
 	}//Fim docente

 	/*Metodo ler que recebe a posicao requisitada pelo usuario
 	/	Metodo que le o arquivo censo.dat
 	/ E metodo que atribuiu valor as variaveis de acordo com suas posicoes
 	*/
 	public void ler(int j) throws Exception{
 		String str = "";
 		MyIO.setCharset("ISO-8859-1");
 		//Abrindo arquivo
 		Arq.openRead("/tmp/censo.dat","ISO-8859-1");
 		Arq.readLine();

 		for(int i = 1;i<=j;i++){
 			str = Arq.readLine();
 		}//Fim for
 		String[] s = str.split("\t");
 		this.codigo = Integer.valueOf(s[0]);
 		this.nome = s[1];
 		this.sigla = s[2];
 		this.codigoMantenedora = Integer.parseInt(s[3]);
 		this.mantenedora = s[4];
 		this.categoria = Integer.parseInt(s[5]);
 		this.organizacao = Integer.parseInt(s[6]);
 		this.codigoMunicipio = Integer.parseInt(s[7]);
 		this.municipio = s[8];
 		this.uf = s[9];
 		this.regiao = s[10];
 		this.tecnico = Integer.parseInt(s[11]);
 		this.periodico= Integer.parseInt(s[12]);
 		this.livro = Integer.parseInt(s[13]);
 		this.receita = Double.parseDouble(s[14]);
 		this.transferencia = Double.parseDouble(s[15]);
 		this.outraReceita = Double.parseDouble(s[16]);
 		this.despesaDocente = Double.parseDouble(s[17]);
 		this.despesaTecnico = Double.parseDouble(s[18]);
 		this.despesaEncargo = Double.parseDouble(s[19]);
 		this.despesaCusteio = Double.parseDouble(s[20]);
 		this.despesaInvestimento = Double.parseDouble(s[21]);
 		this.despesaPesquisa = Double.parseDouble(s[22]);
 		this.despesaOutras = Double.parseDouble(s[23]);

 		//Fechando arquivo
 		Arq.close();
 	}//Fim Ler

 	//Metodo que imprimi os atributos solicitadas
 	public void imprimir(){
 		MyIO.setCharset("ISO-8859-1");
 		MyIO.println(this.codigo+ " " + this.nome+ " " + this.sigla + " " + this.codigoMantenedora +" "+ this.mantenedora +" "+ this.categoria
 				+" "+ this.organizacao +" "+ this.codigoMunicipio +" "+ this.municipio +" "+ this.uf +" "+ this.regiao +" "+ this.tecnico +" "+ this.periodico
 				+" "+ this.livro +" "+ this.receita +" "+ this.transferencia +" "+ this.outraReceita +" "+ this.despesaDocente +" "+ this.despesaTecnico
 				+" "+ this.despesaEncargo +" "+ this.despesaCusteio +" "+ this.despesaInvestimento +" "+ this.despesaPesquisa +" "+ this.despesaOutras);


 	}//Fim imprimi

 }//FIm Classe Docente

 public class Instituicao{
 	public static void main(String args[])throws Exception{
     String[] entrada = new String[1000];
     int nEntrada = 0;
     //Instanciar AVL
     AVL arvore = new AVL();
     //inicio variavel log
     long inicio = System.nanoTime();


     //Laco para ler vetor de String ate a flag "0"
     do{
       entrada[nEntrada] = MyIO.readLine();
     }while(entrada[nEntrada++].equals("0") == false);
     nEntrada--;

       String[] r = new String[1000];
       int nEntrada2 = 0;

       //Laco para ler vetor de String ate a flag nEntrada2< num
       do{
         r[nEntrada2] = MyIO.readLine();
       }while(r[nEntrada2++].equals("FIM")== false);
       nEntrada2--;

     //laco para acessar o arquivo e inserir o arquivo na AVL
     for(int i = 0; i<nEntrada; i++){
       Docente p = new Docente();
         p.ler(Integer.parseInt(entrada[i]));
         arvore.inserir(p);
       }//Fim for

       //Laco para pesquisar se a sigla inserida existe no arquivo que criamos na classe Docente
     for(int i = 0; i<nEntrada2; i++){
       String d = r[i];
       arvore.pesquisar(d);
     }//Fim for
     MyIO.print("\n");

     //Criaçao do Log e inicializacao de suas variaveis
     long fim = System.nanoTime();
     long com = fim - inicio;
 	//Criacao e escrita do arquivo log
     Arq.openWrite("591513_avl.txt","ISO-8859-1");
 	//Printacao das variaveis contidas no arquivo
     Arq.println("591513 \t Tempo:" + com +"s \t Comparaçoes:" + arvore.getComp());
 	//Fechamento do arquivo
     Arq.close();

 	}//Fim main

 }//Fim classe Instituicao
