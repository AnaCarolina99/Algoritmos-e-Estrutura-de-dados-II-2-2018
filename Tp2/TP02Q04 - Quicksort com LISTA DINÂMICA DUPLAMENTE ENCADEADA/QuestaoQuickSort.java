/**
    *@author: Darlan Francisco
    *Date:16/10/2018
    *Note: Ajuda de Matheus Francisco no desenvolvimento no codigo
    */
 
import java.io.File;
import java.util.*;

//classe CelulaDupla
class CelulaDupla {
	
	public Facu elemento; // Elemento inserido na celula.
	public CelulaDupla ant; // Aponta a celula ant.
	public CelulaDupla prox; // Aponta a celula prox.
	
	//Construtor vazio da classe
	public CelulaDupla() {
		this.elemento = elemento;
      	this.prox = null;
	}

	//Construtor da classe
	public CelulaDupla(Facu elemento) {
      this.elemento = elemento;
      this.prox = null;
	}
}

//classe lista dupla com a celula
class ListaDupla {

	private CelulaDupla primeiro;
	private CelulaDupla ultimo;
	public int nComparacao;
	public int nMovimentacoes;


	//Construtor da classe que cria uma lista dupla sem elementos
	public ListaDupla(){
		primeiro = new CelulaDupla();
		ultimo = primeiro;
		nComparacao = 0;
		nMovimentacoes = 0;
	}

	//Insere um elemento na primeira posicao da lista.
	public void inserirInicio(Facu facu){
		
		CelulaDupla tmp = new CelulaDupla(facu);
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

	//Insere um elemento na ultima posicao da lista
	public void inserirFim(Facu facu){
		ultimo.prox = new CelulaDupla(facu);
		ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
	}

	//Remove um elemento da primeira posicao da lista e movimenta
	public Facu removerInicio() throws Exception{
		
		if(primeiro == ultimo){
			throw new Exception("Erro!");
		}
		
		CelulaDupla tmp = primeiro;
		primeiro = primeiro.prox;
		Facu element = primeiro.elemento;
		tmp.prox = primeiro.ant = null;
		tmp = null;

		return element;
	}

	//remove um elemento de uma posicao especifica da lista e movimenta os demais elementos para o inicio da mesma
	public Facu removerFim()throws Exception{

		if(primeiro == ultimo){
			throw new Exception("Erro!");
		}

		Facu element = ultimo.elemento;
		ultimo = ultimo.ant;
		ultimo.prox.ant = null;
		ultimo.prox = null;

		return element;	
	}

	//remove um elemento da primeira posicao da lisa e movimenta
	public void inserir(Facu facu, int pos) throws Exception{

		int tamanho = tamanho();

		if(pos < 0 || pos > tamanho){
			throw new Exception("Erro!");
		}
		else if(pos == 0){
			inserirInicio(facu);
		}
		else if(pos == tamanho){
			inserirFim(facu);
		}
		else{

			CelulaDupla i = primeiro;
			for(int j = 0; j < pos; j++, i = i.prox);
			CelulaDupla tmp = new CelulaDupla(facu);
			tmp.ant = i;
			tmp.prox = i.prox;
			tmp.ant.prox = tmp.prox.ant = tmp;
			tmp = i = null;
		}
	}

	//remeove um elemento de uma posicao especifica da lista
	public Facu remover(int pos) throws Exception{
		Facu element;
		int tamanho = tamanho();

		if(primeiro == ultimo){
			throw new Exception("Erro!");
		}
		else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro!");
		}
		else if(pos == 0){
			element = removerInicio();
		}
		else if(pos == tamanho -1){
			element = removerFim();
		}
		else{

			CelulaDupla i = primeiro.prox;
			for(int j = 0; j < pos; j++ , i = i.prox);
			i.ant.prox = i.prox;
			i.prox.ant = i.ant;
			element = i.elemento;
			i.prox = i.ant = null;
			i = null;	
		}

		return element;
	}

	//mostra os elementos da lista separados por espacos
	public void mostrar(){
		for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
 			i.elemento.imprimir();
 		}
	}

	//mostra os elementos da lista de forma invertida
	public void mostrarInverso() {
		for(CelulaDupla i = ultimo; i != primeiro; i = i.ant){
			i.elemento.imprimir();
		}
	}

	//Procura um elemento e retirna se ele existe
	public boolean pesquisar(Facu facu){
		boolean resp = false;
		for(CelulaDupla i = primeiro.prox; i != null; i = i.prox){
			if(i.elemento == facu){
				resp = true;
				i = ultimo;
			}
		}
		return resp;
	}

	//retorna o tamanho da minha lista
	public int tamanho(){
		int tamanho = 0;
		for(CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++);
 		return tamanho;
	}

    //metodo vazio para poder chama o metodo de ordenacao
    public void quicksort() throws Exception {
    	quicksort(primeiro.prox, ultimo);
    }

    //metodo de ordenacao quickSort
    public void quicksort(CelulaDupla l, CelulaDupla h){
    	if(h != null && l != h & l!= h.prox){
    		CelulaDupla tmp = particao (l,h);
    		quicksort(l, tmp.ant);
    		quicksort(tmp.prox, h);
    	}
    }

    //particiona o quick sort
    public CelulaDupla particao(CelulaDupla l, CelulaDupla h){
    	
    	String pivo = h.elemento.getNome();

    	CelulaDupla i = l.ant;

    	for(CelulaDupla j = l; j != h;j = j.prox){
    		nComparacao++;
    		if(j.elemento.getNome().compareTo(pivo) <= 0){
    			i = (i == null) ? l : i.prox;
    			swap(i,j);
    		}
    	}
    	i = (i == null) ? l : i.prox;
    	swap(i,h);
    	return i;
    }

    //metodo para troca usando celulaDupla
    public void swap(CelulaDupla i,CelulaDupla j){
    	nMovimentacoes += 3;
        Facu temp = i.elemento;
        i.elemento = j.elemento;
        j.elemento = temp;
    }
}

//classe Instituicao
class Facu{
    
    //variaveis privadas
    private int codigo;
    private String nome;
    private String sigla;
    private int codigoMantenedora;
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
    
    //objeto facu
    public Facu(){

        setCodigo(0);
        setNome("");
        setSigla("");
        setCodigoMantenedora(0);
        setMantenedora("");
        setCategoria(0);
        setOrganizacao(0);
        setCodigoMunicipio(0);
        setMunicipio("");
        setUf("");
        setRegiao("");
        setTecnico(0);
        setPeriodico(0);
        setLivro(0);
        setReceita(0);
        setTransferencia(0);
        setOutraReceita(0);
        setDespesaDocente(0);
        setDespesaTecnico(0);
        setDespesaEncargo(0);
        setDespesaCusteio(0);
        setDespesaInvestimento(0);
        setDespesaPesquisa(0);
        setDespesaOutras(0);
    }
    
    //recebeu todas as variaveis privadas como paramentro
    public Facu(int codigo, String nome, String sigla, int codigoMantenedora, String mantenedora, int categoria, int organizacao, int codigoMunicipio, String municipio, String uf, String regiao, int tecnico, int periodico, int livro, double receita, double transferencia, double outraReceita, double despesaDocente, double despesaTecnico, double despesaEncargo, double despesaCusteio, double despesaInvestimento, double despesaPesquisa, double despesaOutras){
        
        setCodigo(codigo);
        setNome(nome);
        setSigla(sigla);
        setCodigoMantenedora(codigoMantenedora);
        setMantenedora(mantenedora);
        setCategoria(categoria);
        setOrganizacao(organizacao);
        setCodigoMunicipio(codigoMunicipio);
        setMunicipio(municipio);
        setUf(uf);
        setRegiao(regiao);
        setTecnico(tecnico);
        setPeriodico(periodico);
        setLivro(livro);
        setReceita(receita);
        setTransferencia(transferencia);
        setOutraReceita(outraReceita);
        setDespesaDocente(despesaDocente);
        setDespesaTecnico(despesaTecnico);
        setDespesaEncargo(despesaEncargo);
        setDespesaCusteio(despesaCusteio);
        setDespesaInvestimento(despesaInvestimento);
        setDespesaPesquisa(despesaPesquisa);
        setDespesaOutras(despesaOutras);  
    }

    /* metodos set() para passar o valor
    metodos get() para retorna o valor */
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getSigla() {
        return sigla;
    }
    
    public int getCodigoMantenedora() {
        return codigoMantenedora;
    }
    
    public String getMantenedora() {
        return mantenedora;
    }
    
    public int getCategoria() {
        return categoria;
    }
    
    public int getOrganizacao() {
        return organizacao;
    }
    
    public int getCodigoMunicipio() {
        return codigoMunicipio;
    }
    
    public String getMunicipio() {
        return municipio;
    }
    
    public String getUf() {
        return uf;
    }
    
    public String getRegiao() {
        return regiao;
    }
    
    public int getTecnico() {
        return tecnico;
    }
    
    public int getPeriodico() {
        return periodico;
    }
    
    public int getLivro() {
        return livro;
    }
    
    public double getReceita() {
        return receita;
    }
    
    public double getTransferencia() {
        return transferencia;
    }
    
    public double getOutraReceita() {
        return outraReceita;
    }
    
    public double getDespesaDocente() {
        return despesaDocente;
    }
    
    public double getDespesaTecnico() {
        return despesaTecnico;
    }
    
    public double getDespesaEncargo() {
        return despesaEncargo;
    }
    
    public double getDespesaCusteio() {
        return despesaCusteio;
    }
    
    public double getDespesaInvestimento() {
        return despesaInvestimento;
    }
    
    public double getDespesaPesquisa() {
        return despesaPesquisa;
    }
    
    public double getDespesaOutras() {
        return despesaOutras;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public void setCodigoMantenedora(int codigoMantenedora) {
        this.codigoMantenedora = codigoMantenedora;
    }
    
    public void setMantenedora(String mantenedora) {
        this.mantenedora = mantenedora;
    }
    
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    public void setOrganizacao(int organizacao) {
        this.organizacao = organizacao;
    }
    
    public void setCodigoMunicipio(int codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }
    
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    
    public void setTecnico(int tecnico) {
        this.tecnico = tecnico;
    }
    
    public void setPeriodico(int periodico) {
        this.periodico = periodico;
    }
    
    public void setLivro(int livro) {
        this.livro = livro;
    }
    
    public void setReceita(double receita) {
        this.receita = receita;
    }
    
    public void setTransferencia(double transferencia) {
        this.transferencia = transferencia;
    }
    
    public void setOutraReceita(double outraReceita) {
        this.outraReceita = outraReceita;
    }
    
    public void setDespesaDocente(double despesaDocente) {
        this.despesaDocente = despesaDocente;
    }
    
    public void setDespesaTecnico(double despesaTecnico) {
        this.despesaTecnico = despesaTecnico;
    }
    
    public void setDespesaEncargo(double despesaEncargo) {
        this.despesaEncargo = despesaEncargo;
    }
    
    public void setDespesaCusteio(double despesaCusteio) {
        this.despesaCusteio = despesaCusteio;
    }
    
    public void setDespesaInvestimento(double despesaInvestimento) {
        this.despesaInvestimento = despesaInvestimento;
    }
    
    public void setDespesaPesquisa(double despesaPesquisa) {
        this.despesaPesquisa = despesaPesquisa;
    }
    
    public void setDespesaOutras(double despesaOutras) {
        this.despesaOutras = despesaOutras;
    }
    
    //metodo clone
    public Facu clone(){

        return new Facu(
        getCodigo(),
        getNome(),
        getSigla(),
        getCodigoMantenedora(),
        getMantenedora(),
        getCategoria(),
        getOrganizacao(),
        getCodigoMunicipio(),
        getMunicipio(),
        getUf(),
        getRegiao(),
        getTecnico(),
        getPeriodico(),
        getLivro(),
        getReceita(),
        getTransferencia(),
        getOutraReceita(),
        getDespesaDocente(),
        getDespesaTecnico(),
        getDespesaEncargo(),
        getDespesaCusteio(),
        getDespesaInvestimento(),
        getDespesaPesquisa(),
        getDespesaOutras()
        );    
    }
    
    //metodo ler e converte as variaveis
    public void ler(String[] dados){

        setCodigo(Integer.valueOf(dados[0]));
        setNome(dados[1]);
        setSigla(dados[2]);
        setCodigoMantenedora(Integer.valueOf(dados[3]));
        setMantenedora(dados[4]);
        setCategoria(Integer.valueOf(dados[5]));
        setOrganizacao(Integer.valueOf(dados[6]));
        setCodigoMunicipio(Integer.valueOf(dados[7]));
        setMunicipio(dados[8]);
        setUf(dados[9]);
        setRegiao(dados[10]);
        setTecnico(Integer.valueOf(dados[11]));
        setPeriodico(Integer.valueOf(dados[12]));
        setLivro(Integer.valueOf(dados[13]));
        setReceita(Double.valueOf(dados[14]));
        setTransferencia(Double.valueOf(dados[15]));
        setOutraReceita(Double.valueOf(dados[16]));
        setDespesaDocente(Double.valueOf(dados[17]));
        setDespesaTecnico(Double.valueOf(dados[18]));
        setDespesaEncargo(Double.valueOf(dados[19]));
        setDespesaCusteio(Double.valueOf(dados[20]));
        setDespesaInvestimento(Double.valueOf(dados[21]));
        setDespesaPesquisa(Double.valueOf(dados[22]));
        setDespesaOutras(Double.valueOf(dados[23]));
    }
    
    
    //metodo que imprimi o arquivo em suas respectivas variaveise
    public void imprimir(){
        MyIO.println(
        getCodigo() + " " +
        getNome() + " " +
        getSigla() + " " +
        getCodigoMantenedora() + " " +
        getMantenedora() + " " +
        getCategoria() + " " +
        getOrganizacao() + " " +
        getCodigoMunicipio() + " " +
        getMunicipio() + " " +
        getUf() + " " +
        getRegiao() + " " +
        getTecnico() + " " +
        getPeriodico() + " " +
        getLivro() + " " +
        getReceita() + " " +
        getTransferencia() + " " +
        getOutraReceita() + " " +
        getDespesaDocente() + " " +
        getDespesaTecnico() + " " +
        getDespesaEncargo() + " " +
        getDespesaCusteio() + " " +
        getDespesaInvestimento() + " " +
        getDespesaPesquisa() + " " +
        getDespesaOutras()
        );
    }
}

//class principal
public class QuestaoQuickSort{

  	public static void main(String[] args){

        MyIO.setCharset("ISO-8859-1");

        String[] entradaPrimeiraParte = new String[1000];
        int numEntradaPrimeiraParte = 0;

        do{
            entradaPrimeiraParte[numEntradaPrimeiraParte] = MyIO.readLine();
        }
        while(!entradaPrimeiraParte[numEntradaPrimeiraParte++].equals("0"));
        numEntradaPrimeiraParte--;

        //leitura do arquivo
        Arq.openRead("/tmp/censo.dat", "ISO-8859-1");
        String arquivo = Arq.readAll();
        Arq.close();

        String[] todosDados = new String[2500];
        int contador = 0;
        for(int i = 0; i < arquivo.length(); i++){

            if(todosDados[contador] == null){
                todosDados[contador] = "";
            }

            todosDados[contador] += arquivo.charAt(i);

            if(arquivo.charAt(i) == '\n'){
                contador++;
            }
        }

        //Executa as inserções e remoções
        try{

            ListaDupla lista = new ListaDupla();
            for(int i = 0; i < numEntradaPrimeiraParte; i++){

                Facu facu = new Facu();
                facu.ler(todosDados[Integer.parseInt(entradaPrimeiraParte[i])].split("\t"));
                lista.inserirFim(facu);
            }

            long startTime = System.nanoTime();

            lista.quicksort();

            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;

            lista.mostrar();

            Arq.openWrite("613838_quicksort2.txt", "ISO-8859-1");
            Arq.println("613838\t" + lista.nComparacao + "\t" + lista.nMovimentacoes + "\t" + totalTime);
            Arq.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}