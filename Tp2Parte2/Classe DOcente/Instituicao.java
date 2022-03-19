import java.io.File;

/**
 *
 * @author Ana Carolina Medeiros Gonçalves
 * Feito com a ajuda de Darlan Francisco e Ana Luiza Pacheco
 */

class Docente{
	//Atributos
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
    String linha;
    int nEntrada = 0;

		//Laco para ler vetor de String ate a flag "0"
    do{
      entrada[nEntrada] = MyIO.readLine();
    }while(entrada[nEntrada++].equals("0") == false);
    nEntrada--;
		//Instanciar Docente
    Docente tp = new Docente();

		//laco para acessar o arquivo e imprimir seus dados
		for(int i = 0; i<nEntrada; i++){
        tp.ler(Integer.parseInt(entrada[i]));
        tp.imprimir();
    }// Fim for

	}//Fim main

}//Fim classe Instituicao
