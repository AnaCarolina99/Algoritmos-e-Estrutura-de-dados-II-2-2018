/**
 *TP01Q07-> Pesquisa Binaria
 *@author:Raiana Pereira Brito
 *02/09/2018
 */
public class TP01P2Q07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        MyIO.setCharset("ISO-8859-1");
        Lista lista = new Lista(1000);

        String[] entrada = new String[1000];
        int nEntrada = 0;
        String[] parte2 = new String[1000];
        String[] dados;
        int nparte2 = 0;

        int comparacoes = 0;
        long inicio = System.currentTimeMillis();

        do {
            entrada[nEntrada] = MyIO.readLine();
        } while (entrada[nEntrada++].equals("0") == false);
        nEntrada--;

        do {
            parte2[nparte2] = MyIO.readLine();
        } while (parte2[nparte2++].equals("FIM") == false);
        nparte2--;

        for (int i = 0; i < nEntrada; i++) {
            Instituicao inst = new Instituicao();
            inst.lerInstituicao(Integer.parseInt(entrada[i]));
            lista.inserirFim(inst);

        }//fim for
        for(int k=0; k<nparte2; k++){
            lista.pesquisaBinaria(parte2[k]);
        }
        long fim = System.currentTimeMillis();

        Arq.openWrite("matrı́cula_binaria.txt");
        Arq.print("Matricula - 604696 \tInicio - " + inicio + "\tFim - " + fim + "\tComparacoes - " + comparacoes);
        Arq.close();

    }//fim main

}//fim ClassePrincipal

class Instituicao {

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

    Instituicao(int codigo, String nome, String sigla, int codigoMantenedora, String mantenedora, int categoria, int organizacao, int codigoMunicipio, String municipio, String uf, String regiao, int tecnico, int periodico, int livro, double receita, double transferencia, double outraReceita, double despesaDocente, double despesaTecnico, double despesaEncargo, double despesaCusteio, double despesaInvestimento, double despesaPesquisa, double despesaOutras) {
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
    }//end contrutor

    Instituicao() {
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
        this.receita = 0.0;
        this.transferencia = 0.0;
        this.outraReceita = 0.0;
        this.despesaDocente = 0.0;
        this.despesaTecnico = 0.0;
        this.despesaEncargo = 0.0;
        this.despesaCusteio = 0.0;
        this.despesaInvestimento = 0.0;
        this.despesaPesquisa = 0.0;
        this.despesaOutras = 0.0;
    }//end contrutor vazio

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

    public Instituicao clone() {
        Instituicao c = new Instituicao();

        c.setCodigo(getCodigo());
        c.setNome(getNome());
        c.setSigla(getSigla());
        c.setCodigoMantenedora(getCodigoMantenedora());
        c.setMantenedora(getMantenedora());
        c.setCategoria(getCategoria());
        c.setOrganizacao(getOrganizacao());
        c.setCodigoMunicipio(getCodigoMunicipio());
        c.setMunicipio(getMunicipio());
        c.setUf(getUf());
        c.setRegiao(getRegiao());
        c.setTecnico(getTecnico());
        c.setPeriodico(getPeriodico());
        c.setLivro(getLivro());
        c.setReceita(getReceita());
        c.setTransferencia(getTransferencia());
        c.setOutraReceita(getOutraReceita());
        c.setDespesaDocente(getDespesaDocente());
        c.setDespesaTecnico(getDespesaTecnico());
        c.setDespesaEncargo(getDespesaEncargo());
        c.setDespesaCusteio(getDespesaCusteio());
        c.setDespesaInvestimento(getDespesaInvestimento());
        c.setDespesaPesquisa(getDespesaPesquisa());
        c.setDespesaOutras(getDespesaOutras());

        return (c);
    }//fim metodo clone

     /**
    *Metodo que lê um determinado arquivo censo referende a uma determinada Instituicao escolhida de acordo com o codigo da mesma, o metodo
    faz do censo das instuticoes,como o codigo da instituicao, seu nome, suas receitas e sua localizacao
    *@param line int
    */
    public void lerInstituicao(int linha) {
        String line;
        String[] dados;
        MyIO.setCharset("iso-8859-1");
        Arq.openRead("/tmp/censo.dat/", "iso-8859-1");
        line = Arq.readLine();

        for (int i = 1; i <= linha; i++) {
            line = Arq.readLine();
        }

        dados = line.split("\t");
        setCodigo(Integer.valueOf(dados[0]));
        setNome(dados[1]);
        setSigla(dados[2]);
        setCodigoMantenedora(Integer.parseInt(dados[3]));
        setMantenedora(dados[4]);
        setCategoria(Integer.parseInt(dados[5]));
        setOrganizacao(Integer.parseInt(dados[6]));
        setCodigoMunicipio(Integer.parseInt(dados[7]));
        setMunicipio(dados[8]);
        setUf(dados[9]);
        setRegiao(dados[10]);
        setTecnico(Integer.parseInt(dados[11]));
        setPeriodico(Integer.parseInt(dados[12]));
        setLivro(Integer.parseInt(dados[13]));
        setReceita(Double.parseDouble(dados[14]));
        setTransferencia(Double.parseDouble(dados[15]));
        setOutraReceita(Double.parseDouble(dados[16]));
        setDespesaDocente(Double.parseDouble(dados[17]));
        setDespesaTecnico(Double.parseDouble(dados[18]));
        setDespesaEncargo(Double.parseDouble(dados[19]));
        setDespesaCusteio(Double.parseDouble(dados[20]));
        setDespesaInvestimento(Double.parseDouble(dados[21]));
        setDespesaPesquisa(Double.parseDouble(dados[22]));
        setDespesaOutras(Double.parseDouble(dados[23]));

        Arq.close();

    }//end metodo lerInstituicao

    public void imprimir() {
        MyIO.setCharset("ISO-8859-1");
        MyIO.println(getCodigo() + " " + getNome() + " " + getSigla() + " " + getCodigoMantenedora() + " " + getMantenedora() + " " + getCategoria() + " " + getOrganizacao() + " " + getCodigoMunicipio() + " " + getMunicipio() + " " + getUf() + " " + getRegiao() + " " + getTecnico() + " " + getPeriodico() + " " + getLivro() + " " + getReceita() + " " + getTransferencia() + " " + getOutraReceita() + " " + getDespesaDocente() + " " + getDespesaTecnico() + " " + getDespesaEncargo() + " " + getDespesaCusteio() + " " + getDespesaInvestimento() + " " + getDespesaPesquisa() + " " + getDespesaOutras());

    }//fim metodo imprimir

}//end classIntituicao

/**
 * Lista estatica
 *
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista {

    private Instituicao[] inst;
    private int n;

    /**
     * Construtor da classe.
     */
    public Lista() {
        this(0);
    }

    /**
     * Construtor da classe.
     *
     * @param tamanho Tamanho da lista.
     */
    public Lista(int tamanho) {
        inst = new Instituicao[tamanho];
        n = 0;
    }

    /**
     * Insere um elemento na primeira posicao da lista e move os demais
     * elementos para o fim da lista.
     *
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirInicio(Instituicao instituicao) throws Exception {

        //validar insercao
        if (n >= inst.length) {
            throw new Exception("Erro ao inserir!");
        }

        //levar elementos para o fim do array
        for (int i = n; i > 0; i--) {
            inst[i] = inst[i - 1];
        }

        inst[0] = instituicao.clone();
        n++;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     *
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirFim(Instituicao instituicao) throws Exception {

        //validar insercao
        if (n >= inst.length) {
            throw new Exception("Erro ao inserir!");
        }

        inst[n] = instituicao; // Instituicao.clone();
        n++;
    }

    /**
     * Insere um elemento em uma posicao especifica e move os demais elementos
     * para o fim da lista.
     *
     * @param x int elemento a ser inserido.
     * @param pos Posicao de insercao.
     * @throws Exception Se a lista estiver cheia ou a posicao invalida.
     */
    public void inserir(Instituicao instituicao, int pos) throws Exception {

        //validar insercao
        if (n >= inst.length || pos < 0 || pos > n) {
            throw new Exception("Erro ao inserir!");
        }

        //levar elementos para o fim do array
        for (int i = n; i > pos; i--) {
            inst[i] = inst[i - 1];
        }

        inst[pos] = instituicao.clone();
        n++;
    }

    /**
     * Remove um elemento da primeira posicao da lista e movimenta os demais
     * elementos para o inicio da mesma.
     *
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Instituicao removerInicio() throws Exception {

        //validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        Instituicao resp = inst[0]; // ou colocar inst[0].clone
        n--;

        for (int i = 0; i < n; i++) {
            inst[i] = inst[i + 1];
        }

        return resp;
    }

    /**
     * Remove um elemento da ultima posicao da lista.
     *
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Instituicao removerFim() throws Exception {

        //validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        return inst[--n];
    }

    /**
     * Remove um elemento de uma posicao especifica da lista e movimenta os
     * demais elementos para o inicio da mesma.
     *
     * @param pos Posicao de remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
     */
    public Instituicao remover(int pos) throws Exception {

        //validar remocao
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro ao remover!");
        }

        Instituicao resp = inst[pos];
        n--;

        for (int i = pos; i < n; i++) {
            inst[i] = inst[i + 1];
        }

        return resp;
    }

          /**
     * Metodo pesquisaBinaria serve  encontrar um item em uma lista ordenada de Instituicoes.O metodo
       vai dividindo repetidamente pela metade a porção da lista que deve conter o item, até reduzir
       as localizações possíveis a apenas uma.
     * @param s String
     * @return comparacoes
     */
    public int pesquisaBinaria(String s) {
        int comparacoes = selecao();
        boolean verificar = false;
        int dir = n - 1, esq = 0, meio;

        while (esq <= dir) {
            meio = (dir + esq) / 2;
            if (s.compareTo(inst[meio].getSigla())==0) {
                verificar = true;
                esq = n;
                comparacoes++;
            } else if (s.compareTo(inst[meio].getSigla()) > 0) {
                esq = meio + 1;
                comparacoes++;
            } else {
                dir = meio - 1;
                comparacoes++;
            }
        }

        if (verificar) {//boolean verdadeiro escreva sim caso contrario nao
            MyIO.println("SIM");
        } else {
            MyIO.println("NÃO");
        }//fim else
        return comparacoes;
    }//fim metodo


    public  int selecao() {
      int comparacoes = 0;
      for (int i = 0; i < (n - 1); i++) {
        int menor = i;
          for (int j = (i + 1); j < n; j++){
             if (inst[menor].getSigla().compareTo(inst[j].getSigla())>0){
                menor = j;
                comparacoes++;
             }
          }
         swap(menor, i);
      }
      return comparacoes;
    }

     /**
     * Troca o conteudo de duas posicoes do array
     * @param i int primeira posicao
     * @param j int segunda posicao
     */
    public  void swap(int i, int j) {
       Instituicao aux = new Instituicao();
       aux = inst[i];
       inst[i] = inst[j];
       inst[j] = aux;
    }

    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrar() {
        //System.out.print("[ ");
        for (int i = 0; i < n; i++) {
            inst[i].imprimir();
        }
        /// System.out.println("]");
    }//fim metodo mostrar

    /**
     * Procura um elemento e retorna se ele existe.
     *
     * @param x int elemento a ser pesquisado.
     * @return <code>true</code> se o array existir, <code>false</code> em caso
     * contrario.
     */
    public boolean pesquisar(Instituicao x) {
        boolean retorno = false;
        for (int i = 0; i < n && retorno == false; i++) {
            retorno = (inst[i] == x);
        }
        return retorno;
    }

    public void mostrarRec() {
        System.out.print("[ ");
        mostrarRec(0);
        System.out.println("]");
    }

    public void mostrarRec(int i) {
        if (i < n) {
            System.out.print(inst[i] + " ");
            mostrarRec(i + 1);
        }
    }

}
