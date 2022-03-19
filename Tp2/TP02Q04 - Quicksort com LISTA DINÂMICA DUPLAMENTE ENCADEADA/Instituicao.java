import java.io.File;

/**
 * Celula Dupla (lista dupla dinamica)
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class CelulaDupla {
    public Docente elemento;
    public CelulaDupla ant;
    public CelulaDupla prox;

    /**
     * Construtor da classe.
     */
    public CelulaDupla() {
        this(null);
    }


    /**
     * Construtor da classe.
     * @param elemento int inserido na celula.
     */
    public CelulaDupla(Docente elemento) {
        this.elemento = elemento;
        this.ant = this.prox = null;
    }
}

/**
 * Lista dupla dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class ListaDupla {
    private CelulaDupla primeiro;
    private CelulaDupla ultimo;

    /**
     * Construtor da classe que cria uma lista dupla sem elementos (somente no cabeca).
     */
    public ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    /**
     * Insere um elemento na primeira posicao da lista.
     * @param x int elemento a ser inserido.
     */
    public void inserirInicio(Docente x) {
        CelulaDupla tmp = new CelulaDupla(x);

        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if(primeiro == ultimo){
            ultimo = tmp;
        }else{
            tmp.prox.ant = tmp;
        }
        tmp = null;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     * @param x int elemento a ser inserido.
     */
    public void inserirFim(Docente x) {
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }

    /**
     * Remove um elemento da primeira posicao da lista.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
    public Docente removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        CelulaDupla tmp = primeiro;
        primeiro = primeiro.prox;
        Docente resp = primeiro.elemento;
        tmp.prox = primeiro.ant = null;
        tmp = null;
        return resp;
    }

    /**
     * Remove um elemento da ultima posicao da lista.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
    public Docente removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }
        Docente resp = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        return resp;
    }

    /**
     * Insere um elemento em uma posicao especifica considerando que o
     * primeiro elemento valido esta na posicao 0.
     * @param x int elemento a ser inserido.
     * @param pos int posicao da insercao.
     * @throws Exception Se <code>posicao</code> invalida.
     */
    public void inserir(Docente x, int pos) throws Exception {

        int tamanho = tamanho();

        if(pos < 0 || pos > tamanho){
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        } else if (pos == 0){
            inserirInicio(x);
        } else if (pos == tamanho){
            inserirFim(x);
        } else {
            // Caminhar ate a posicao anterior a insercao
            CelulaDupla i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);

            CelulaDupla tmp = new CelulaDupla(x);
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.ant.prox = tmp.prox.ant = tmp;
            tmp = i = null;
        }
    }

    /**
     * Remove um elemento de uma posicao especifica da lista
     * considerando que o primeiro elemento valido esta na posicao 0.
     * @param posicao Meio da remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se <code>posicao</code> invalida.
     */
    public Docente remover(int pos) throws Exception {
        Docente resp;
        int tamanho = tamanho();

        if (primeiro == ultimo){
            throw new Exception("Erro ao remover (vazia)!");

        } else if(pos < 0 || pos >= tamanho){
            throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
        } else if (pos == 0){
            resp = removerInicio();
        } else if (pos == tamanho - 1){
            resp = removerFim();
        } else {
            // Caminhar ate a posicao anterior a insercao
            CelulaDupla i = primeiro.prox;
            for(int j = 0; j < pos; j++, i = i.prox);

            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            resp = i.elemento;
            i.prox = i.ant = null;
            i = null;
        }

        return resp;
    }

    /**
     * Troca o conteudo de duas posicoes do ponteiro
     */
    public void swap(CelulaDupla x,CelulaDupla y){
      Docente t = new Docente();
      t = x.elemento;
      x.elemento = y.elemento;
      y.elemento = t;
    }

        /**
         * Algoritmo de ordenacao Quicksort.
         * Retorna o outro metodo quicksort
         */
        public void quicksort() {
          quicksort(primeiro.prox, ultimo);
       }

        /**
         * Algoritmo de ordenacao Quicksort
         */
        private void quicksort(CelulaDupla esq, CelulaDupla dir) {
            if(dir != null && esq!= dir & esq != dir.prox){
              CelulaDupla tmp = particao(esq,dir);
              quicksort(esq, tmp.ant);
              quicksort(tmp.prox, dir);
            }
        }

        /**
       * Algoritmo que particiona o algoritmo de Quicksort.
       * Retorna ele particionado
         */
        public CelulaDupla particao(CelulaDupla esq, CelulaDupla dir){
            String pivo = dir.elemento.getNome();
            CelulaDupla c = esq.ant;
              for(CelulaDupla i = esq; i != dir; i = i.prox){
                  if(i.elemento.getNome().compareTo(pivo)<=0){
                      c = (c==null) ? esq : c.prox;
                      swap(c,i);
                  }
              }
              c = (c== null) ? esq : c.prox;
              swap(c,dir);
              return c;
        }

    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrar() {
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            i.elemento.imprimir();
        }
    }

    /**
     * Mostra os elementos da lista de forma invertida
     * e separados por espacos.
     */
    public void mostrarInverso() {
        System.out.print("[ ");
        for (CelulaDupla i = ultimo; i != primeiro; i = i.ant){
            System.out.print(i.elemento + " ");
        }
        System.out.println("] "); // Termina de mostrar.
    }

    /**
     * Calcula e retorna o tamanho, em numero de elementos, da lista.
     * @return resp int tamanho
     */
    public int tamanho() {
        int tamanho = 0;
        for(CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++);
        return tamanho;
    }

}

 /**
  *
  * @author Ana Carolina Medeiros Gonçalves
  * Feito com o auxilio de Darlan Francisco e Ana Luiza Pacheco
  * A mudança na main e metodo ler feito com a total ajuda de Darlan Francisco
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
 	public void ler(String[] s) throws Exception{

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
    MyIO.setCharset("ISO-8859-1");
    //Instanciar Lista
    int comp = 0;


    //Laco para ler vetor de String ate a flag "0"
    do{
      entrada[nEntrada] = MyIO.readLine();
    }while(entrada[nEntrada++].equals("0") == false);
    nEntrada--;
    //Leitura do arquivo
    Arq.openRead("/tmp/censo.dat", "ISO-8859-1");
    String s = Arq.readAll();
    Arq.close();

    //Percorre o arquivo e verifica se esta null
    //Caso contrario conta sua quantidade
    String[] dados = new String[10000];
    int cont = 0;
      for(int i = 0;i<s.length();i++){
          if(dados[cont] == null){
            dados[cont] = "";
          }
          dados[cont] += s.charAt(i);

          if(s.charAt(i) == '\n'){
            cont++;
          }
      }
    try{
      ListaDupla lista = new ListaDupla();
    //laco para acessar o arquivo,insirir o arquivo no fim da lista

    for(int j = 0; j<nEntrada; j++){
      Docente p = new Docente();
        p.ler(dados[Integer.parseInt(entrada[j])].split("\t"));
        lista.inserirFim(p);
      }//Fim for
          long inicio = System.nanoTime();
    //Chamando metodo quicksort
     lista.quicksort();
      long fim = System.nanoTime();
      ////Imprimir o arquivo ordenado
    lista.mostrar();


    //Criaçao do Log e inicializacao de algumas variaveis
    long com = fim - inicio;
	//Criacao e escrita do arquivo log
    Arq.openWrite("591513_quicksort.txt","ISO-8859-1");
	//Printacao das variaveis contidas no arquivo
    Arq.println("591513 \t Tempo:" + com +"s \t");
	//Fechamento do arquivo
    Arq.close();
  }catch(Exception e){
    e.printStackTrace();
  }//Fim catch

	}//Fim main

}//Fim classe Instituicao
