 class Docente{

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
   private float receita;
   private float transferencia;
   private float outraReceita;
   private float despesaDocente;
   private float despesaTecnico;
   private float despesaEncargo;
   private float despesaCusteio;
   private float despesaInvestimento;
   private float despesaPesquisa;
   private float despesaOutras;

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

    public Docente(int codigo,String nome,String sigla,int codigoMantenedora,String mantenedora
    ,int categoria,int organizacao,int codigoMunicipio,String municipio,String uf, String regiao
    ,int tecnico,int periodico,int livro,float receita,float transferencia,float despesaDocente,
    float despesaTecnico,float despesaEncargo,float despesaCusteio,float despesaInvestimento,
    float despesaPesquisa,float despesaOutras){
      this.codigo = codigo;
      this.nome = nome;
      this.sigla = nome;
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

    public int getCodigo(){
      return this.codigo;
    }

    public void setCodigo(int codigo){
      this.codigo = codigo;
    }

    public String getNome(){
      return this.nome;
    }

    public void setNome(String nome){
      this.nome = nome;
    }

    public String getSigla(){
      return this.sigla;
    }

    public void setSigla(String sigla){
      this.sigla = sigla;
    }

    public int getCodigoMantenedora(){
      return this.codigoMantenedora;
    }

    public void setCodigoMantenedora(int codigoMantenedora){
      this.codigoMantenedora = codigoMantenedora;
    }

    public String getMantenedora(){
      return this.mantenedora;
    }

    public void setMantenedora(String mantenedora ){
      this.mantenedora = mantenedora;
    }

    public int getCategoria(){
      return this.categoria;
    }

    public void setCategoria(int categoria){
      this.categoria = categoria;
    }

    public int getOrganizacao(){
      return this.organizacao;
    }

    public void setOrganizacao(int organizacao){
      this.organizacao = organizacao;
    }

    public int getCodigoMunicipio(){
      return this.codigoMunicipio;
    }

    public void setCodigoMunicipio(int codigoMunicipio){
      this.codigoMunicipio = codigoMunicipio;
    }

    public String getMunicipio(){
      return this.municipio;
    }

    public void setMunicipio(String municipio){
      this.municipio = municipio;
    }

    public String getUf(){
      return this.uf;
    }

    public void setUf(String sigla){
      this.uf = uf;
    }

    public String getRegiao(){
      return this.regiao;
    }

    public void setRegiao(String regiao){
      this.regiao = regiao;
    }

    public int getTecnico(){
      return this.tecnico;
    }

    public void setTecnico(int tecnico){
      this.tecnico = tecnico;
    }

    public int getPeriodico(){
      return this.periodico;
    }

    public void setPeriodico(int periodico){
      this.periodico = periodico;
    }

    public int getLivro(){
      return this.livro;
    }

    public void setLivro(int livro){
      this.livro = livro;
    }

    public float getReceita(){
      return this.receita;
    }

    public void setReceita(float receita){
      this.receita = receita;
    }

    public float getTransferencia(){
      return this.transferencia;
    }

    public void setTransferencia(float transferencia){
      this.transferencia = transferencia;
    }

    public float getOutraReceita(){
      return this.outraReceita;
    }

    public void setOutraReceite(float outraReceita){
      this.outraReceita = outraReceita;
    }

    public float getDespesaDocente(){
      return this.despesaDocente;
    }

    public void setDespesaDocente(float despesaDocente){
      this.despesaDocente = despesaDocente;
    }

    public float getDespesaTecnico(){
      return this.despesaTecnico;
    }

    public void setDespesaTecnico(float despesaTecnico){
      this.despesaTecnico = despesaTecnico;
    }

    public float getDespesaEncargo(){
      return this.despesaEncargo;
    }

    public void setDespesaEncargo(float despesaEncargo){
      this.despesaEncargo = despesaEncargo;
    }

    public float getDespesaCusteio(){
      return this.despesaCusteio;
    }

    public void setDespesaCusteio(float despesaCusteio){
      this.despesaCusteio = despesaCusteio;
    }

    public float getDespesaInvestimento(){
      return this.despesaInvestimento;
    }

    public void setDespesaInvestimento(float despesaInvestimento){
      this.despesaInvestimento = despesaInvestimento;
    }

    public float getDespesaPesquisa(){
      return this.despesaPesquisa;
    }

    public void setDespesaPesquisa(float despesaPesquisa){
      this.despesaPesquisa = despesaPesquisa;
    }

    public float getDespesaOutras(){
      return this.despesaOutras;
    }

    public void setDespesaOutras(float despesaOutras){
      this.despesaOutras = despesaOutras;
    }



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
    }

    public static void ler(){
      Arq.openRead("censo.dat");
      Arq.print("censo.dat");
      Arq.close();
    }



}//FIm Classe

public class Instituicao{
  public static void main(String args[]){
      Docente ana = new Docente();
      ana.ler();
  }
}
