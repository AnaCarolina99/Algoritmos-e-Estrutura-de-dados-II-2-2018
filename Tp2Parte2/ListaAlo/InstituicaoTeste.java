import java.io.File;

class Lista{

   private Facu[] array;
   private int n;

   //contrutor classe
   public Lista () {
      this(0);
   }

   //contrutor class que recebe o tamanho da lista
   public Lista (int tamanho){
      array = new Facu[tamanho];
      n = 0;
   }

   //insere um elemento na primeira posicao da lista e move os demais elementos para o fim da lista
   public void inserirInicio(Facu facu) throws Exception {

      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }
      //levar elementos para o fim do array
      for(int i = n; i > 0; i--){
         array[i] = array[i-1];
      }
      array[0] = facu.clone() ;
      n++;
   }

   //insere um elemento na ultima posicao da lista
   public void inserirFim(Facu facu) throws Exception {

      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }

      array[n] = facu;
      n++;
   }

   //remove um elemento da primeira posicao da lisa e movimenta
   public void inserir(Facu facu, int pos) throws Exception {

      //validar insercao
      if(n >= array.length || pos < 0 || pos > n){
         throw new Exception("Erro ao inserir!");
      }

      //levar elementos para o fim do array
      for(int i = n; i > pos; i--){
         array[i] = array[i-1];
      }
      array[pos] = facu;
      n = n+1;
   }

   //remove um elemento da primeira posicao da lista e movimenta
   public Facu removerInicio() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      Facu resp = array[0];
      n--;

      for(int i = 0; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }

   //remove um elemento de uma posicao especifica da lista e movimenta os demais elementos para o inicio da mesma
   public Facu removerFim() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      return array[--n];
   }

   //remove um elemento de uma posicao especifica da lista e movimenta os demias elementos para oo inicio da mesma
   public Facu remover(int pos) throws Exception {

      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }

      Facu resp = array[pos];
      n--;

      for(int i = pos; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }

   //mostra os elementos da lista separados por espacos
   public void mostrar(){
      for(int i = 0; i < n; i++){
         array[i].imprimir();
      }
   }

   //procura um elemento se ele existe
   public boolean pesquisar(Facu x) {
      boolean retorno = false;
      for (int i = 0; i < n && retorno == false; i++) {
         retorno = (array[i] == x);
      }
      return retorno;
   }
   public void mostrarRec (){
      System.out.print("[ ");
      mostrarRec(0);
      System.out.println("]");
   }

   public void mostrarRec(int i){
      if(i < n){
         System.out.print(array[i] + " ");
         mostrarRec(i + 1);
      }
   }

}

//class Docente
class Facu {

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
    public Facu() {
        this.codigo = 0;
        this.nome = "";
        this.sigla = "";
        this.codigoMantenedora = 0;
        this.mantenedora = "";
        this.categoria = 0;
        this.organizacao = 0;
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

    //recebeu todas as variaveis privadas como paramentro
    public Facu(int codigo, String nome, String sigla, int codigoMantenedora, String mantenedora, int categoria, int organizacao, int codigoMunicipio, String municipio, String uf, String regiao, int tecnico, int periodico, int livro, double receita, double transferencia, double despesaDocente,
            double despesaTecnico, double despesaEncargo, double despesaCusteio, double despesaInvestimento,
            double despesaPesquisa, double despesaOutras) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
        this.codigoMantenedora = codigoMantenedora;
        this.mantenedora = mantenedora;
        this.categoria = categoria;
        this.organizacao = organizacao;
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

    /* metodos set() para passar o valor
    metodos get() para retorna o valor */

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getCodigoMantenedora() {
        return this.codigoMantenedora;
    }

    public void setCodigoMantenedora(int codigoMantenedora) {
        this.codigoMantenedora = codigoMantenedora;
    }

    public String getMantenedora() {
        return this.mantenedora;
    }

    public void setMantenedora(String mantenedora) {
        this.mantenedora = mantenedora;
    }

    public int getCategoria() {
        return this.categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getOrganizacao() {
        return this.organizacao;
    }

    public void setOrganizacao(int organizacao) {
        this.organizacao = organizacao;
    }

    public int getCodigoMunicipio() {
        return this.codigoMunicipio;
    }

    public void setCodigoMunicipio(int codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String sigla) {
        this.uf = uf;
    }

    public String getRegiao() {
        return this.regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public int getTecnico() {
        return this.tecnico;
    }

    public void setTecnico(int tecnico) {
        this.tecnico = tecnico;
    }

    public int getPeriodico() {
        return this.periodico;
    }

    public void setPeriodico(int periodico) {
        this.periodico = periodico;
    }

    public int getLivro() {
        return this.livro;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    public double getReceita() {
        return this.receita;
    }

    public void setReceita(double receita) {
        this.receita = receita;
    }

    public double getTransferencia() {
        return this.transferencia;
    }

    public void setTransferencia(double transferencia) {
        this.transferencia = transferencia;
    }

    public double getOutraReceita() {
        return this.outraReceita;
    }

    public void setOutraReceite(double outraReceita) {
        this.outraReceita = outraReceita;
    }

    public double getDespesaDocente() {
        return this.despesaDocente;
    }

    public void setDespesaDocente(double despesaDocente) {
        this.despesaDocente = despesaDocente;
    }

    public double getDespesaTecnico() {
        return this.despesaTecnico;
    }

    public void setDespesaTecnico(double despesaTecnico) {
        this.despesaTecnico = despesaTecnico;
    }

    public double getDespesaEncargo() {
        return this.despesaEncargo;
    }

    public void setDespesaEncargo(double despesaEncargo) {
        this.despesaEncargo = despesaEncargo;
    }

    public double getDespesaCusteio() {
        return this.despesaCusteio;
    }

    public void setDespesaCusteio(double despesaCusteio) {
        this.despesaCusteio = despesaCusteio;
    }

    public double getDespesaInvestimento() {
        return this.despesaInvestimento;
    }

    public void setDespesaInvestimento(double despesaInvestimento) {
        this.despesaInvestimento = despesaInvestimento;
    }

    public double getDespesaPesquisa() {
        return this.despesaPesquisa;
    }

    public void setDespesaPesquisa(double despesaPesquisa) {
        this.despesaPesquisa = despesaPesquisa;
    }

    public double getDespesaOutras() {
        return this.despesaOutras;
    }

    public void setDespesaOutras(double despesaOutras) {
        this.despesaOutras = despesaOutras;
    }

    public Facu clone() {

        Facu facu = new Facu();

        facu.codigo = this.codigo;
        facu.nome = this.nome;
        facu.sigla = this.sigla;
        facu.codigoMantenedora = this.codigoMantenedora;
        facu.mantenedora = this.mantenedora;
        facu.categoria = this.categoria;
        facu.organizacao = this.organizacao;
        facu.codigoMunicipio = this.codigoMunicipio;
        facu.municipio = this.municipio;
        facu.uf = this.uf;
        facu.regiao = this.regiao;
        facu.tecnico = this.tecnico;
        facu.periodico = this.periodico;
        facu.livro = this.livro;
        facu.receita = this.receita;
        facu.transferencia = this.transferencia;
        facu.outraReceita = this.outraReceita;
        facu.despesaDocente = this.despesaDocente;
        facu.despesaTecnico = this.despesaTecnico;
        facu.despesaEncargo = this.despesaEncargo;
        facu.despesaCusteio = this.despesaCusteio;
        facu.despesaInvestimento = this.despesaInvestimento;
        facu.despesaPesquisa = this.despesaPesquisa;
        facu.despesaOutras = this.despesaOutras;
        return facu;
    }

    public void ler(int j) throws Exception {
        String str = "";
        MyIO.setCharset("ISO-8859-1");
        Arq.openRead("/tmp/censo.dat", "ISO-8859-1");
        Arq.readLine();

        for (int i = 1; i <= j; i++) {
            str = Arq.readLine();
        }
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
        this.periodico = Integer.parseInt(s[12]);
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

        Arq.close();
        //MyIO.println("parei aqui!");
    }

    public Facu ler2(int j) throws Exception {
        String str = "";
        MyIO.setCharset("ISO-8859-1");
        Arq.openRead("/tmp/censo.dat", "ISO-8859-1");
        Arq.readLine();

        for (int i = 1; i <= j; i++) {
            str = Arq.readLine();
        }

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
        this.periodico = Integer.parseInt(s[12]);
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

        Arq.close();
        return this.clone();
    }

    public void imprimir() {
        MyIO.setCharset("ISO-8859-1");
        MyIO.println(this.codigo + " " + this.nome + " " + this.sigla + " " + this.codigoMantenedora + " " + this.mantenedora + " " + this.categoria
                + " " + this.organizacao + " " + this.codigoMunicipio + " " + this.municipio + " " + this.uf + " " + this.regiao + " " + this.tecnico + " " + this.periodico
                + " " + this.livro + " " + this.receita + " " + this.transferencia + " " + this.outraReceita + " " + this.despesaDocente + " " + this.despesaTecnico
                + " " + this.despesaEncargo + " " + this.despesaCusteio + " " + this.despesaInvestimento + " " + this.despesaPesquisa + " " + this.despesaOutras);

    }

}

public class InstituicaoTeste {
  public static void main(String[] args) throws Exception {
          MyIO.setCharset("ISO-8859-1");
          Lista lista = new Lista(1000);

          String[] entrada = new String[1000];
          int nEntrada = 0;
          String[] parte2 = new String[1000];
          String[] dados;
          int nparte2 = 0;

          do {
              entrada[nEntrada] = MyIO.readLine();
          } while (entrada[nEntrada++].equals("0") == false);
          nEntrada--;

          int n = MyIO.readInt();

          do {
              parte2[nparte2] = MyIO.readLine();
              nparte2++;
          } while (nparte2 < n);


          for (int i = 0; i < nEntrada; i++) {
              Facu inst = new Facu();
              inst.ler(Integer.parseInt(entrada[i]));
              lista.inserirFim(inst);

          }//fim for

          for (int k = 0; k < n; k++) {
              dados = parte2[k].split(" ");
              Facu inst = new Facu();
              if (dados[0].charAt(0) == 'I') {
                  if (dados[0].charAt(1) == 'I') {
                      inst.ler(Integer.parseInt(dados[1]));
                      lista.inserirInicio(inst);
                  } else if (dados[0].charAt(1) == 'F') {
                      inst.ler(Integer.parseInt(dados[1]));
                      lista.inserirFim(inst);
                  } else if (dados[0].charAt(1) == '*') {
                      inst.ler(Integer.parseInt(dados[2]));
                      int pos = Integer.parseInt(dados[1]);
                      //System.out.println("pos"+pos);
                      lista.inserir(inst, pos);
                  } else {
                      MyIO.println("Comando invalido: " + dados[0]);
                      System.exit(1);
                  }
              } else if (dados[0].charAt(0) == 'R') {
                  if (dados[0].charAt(1) == 'I') {
                      inst = lista.removerInicio();
                      MyIO.println("(R) " + inst.getNome());
                  } else if (dados[0].charAt(1) == 'F') {
                      inst = lista.removerFim();
                      MyIO.println("(R) " + inst.getNome());
                  } else if (dados[0].charAt(1) == '*') {
                      int pos = Integer.parseInt(dados[1]);
                      inst = lista.remover(pos);
                      MyIO.println("(R) " + inst.getNome());
                  } else {
                      MyIO.println("Comando invalido: " + dados[0]);
                      System.exit(1);
                  }

              } else {
                  MyIO.println("Comando invalido: " + dados[0]);
                  System.exit(1);
              }

          }

          //lista.mostrar();

      }//fim main
}
