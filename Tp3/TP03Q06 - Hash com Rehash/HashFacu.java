/**
*@author: Darlan Francisco
*Date:29/10/2018
Note: 
*/

class Hash {

	Facu tabela[];
	int tamTab;
	public int comparacoes = 0;

	public Hash() {
		this(21);
	}

	public Hash(int tamanhoTabela){

		this.tamTab = tamTab;
		this.tabela = new Facu[this.tamTab];

		for(int i = 0; i < tamTab; i++){
			tabela[i] = null;
		}
	}

	public int h(Facu elemento){
		return elemento.getCodigoMantenedora() % tamTab;
	}

	public int reh(Facu elemento){
		return ((elemento.getCodigoMantenedora() + 1)) % tamTab;
	}

    public boolean inserir (Facu elemento){
        
        boolean resp = false;

        if(elemento != null){

            int pos = h(elemento);

            if(tabela[pos] == null){
                tabela[pos] = elemento;
                resp = true;

            } else{

                pos = reh(elemento);

                if(tabela[pos] == null){
                    tabela[pos] = elemento;
                    resp = true;
                }
            }
        }

        return resp;
    }

	public int converte(String x){
		
		int resp = 0;

		for(int i = 0; i < x.length(); i++){
			resp = resp + (int)x.charAt(i);
		}

		return resp;
	}

	public boolean pesquisar(String elemento){

		boolean resp = false;

		for(int i = 0; i < tamTab; i++){
			if(tabela[i] != null){
				if(tabela[i].getSigla().equals(elemento)){
					resp = true;
					MyIO.println(elemento + "\t" + "("+ i + ")" + " SIM");
					i = tamTab;
				}
			}
		}

		if(!resp){
			MyIO.println(elemento + "\t" + "NÃO");			
		}

		return resp;
	}

	public void mostrarTabela(){
		MyIO.print("[ ");
     	for(int i = 0;i<tabela.length;i++){
       		if(tabela[i] != null){
       			MyIO.print("("+tabela[i].getCodigoMantenedora()+ ")");
         		//tabela[i].imprimir();
       		}
       		else{
         		continue;
       		}
     	}
     	MyIO.println(" ] ");
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

    //metodo ler que retorna o clone
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
        MyIO.println(this.codigo + " " + this.nome + " " + this.sigla + " " + this.codigoMantenedora + " " + this.mantenedora + " " + this.categoria +
            " " + this.organizacao + " " + this.codigoMunicipio + " " + this.municipio + " " + this.uf + " " + this.regiao + " " + this.tecnico + " " + this.periodico +
            " " + this.livro + " " + this.receita + " " + this.transferencia + " " + this.outraReceita + " " + this.despesaDocente + " " + this.despesaTecnico +
            " " + this.despesaEncargo + " " + this.despesaCusteio + " " + this.despesaInvestimento + " " + this.despesaPesquisa + " " + this.despesaOutras);
    }
}

public class HashFacu {
   public static void main(String args[]) throws Exception {

        String[] entrada = new String[1000];
        int nEntrada = 0;
        //Instanciar Lista
        Hash hashComReserva = new Hash();
        long inicio = System.nanoTime();


        //Laco para ler vetor de String ate a flag "0"
        do {
            entrada[nEntrada] = MyIO.readLine();
        } while (entrada[nEntrada++].equals("0") == false);
        nEntrada--;

        String[] r = new String[1000];
        int nEntrada2 = 0;

        //Laco para ler vetor de String ate a flag nEntrada2< num
        do {
            r[nEntrada2] = MyIO.readLine();
        } while (r[nEntrada2++].equals("FIM") == false);
        nEntrada2--;

        //laco para acessar o arquivo, imprimir seus dados e insirir o arquivo no fim da lista
        for (int i = 0; i < nEntrada; i++) {
    		Facu p = new Facu();
            p.ler(Integer.parseInt(entrada[i]));
            hashComReserva.inserir(p);
        } //Fim for

        //Laco para inserir na Classe lista e pesquisar se a sigla inserida existe no arquivo que criamos na classe Docente
        for (int i = 0; i < nEntrada2; i++) {
            String d = r[i];
            hashComReserva.pesquisar(d);
        }
        //MyIO.print("\n");

		//hashComReserva.mostrarTabela();
        //Criaçao do Log e inicializacao de suas variaveis
        long fim = System.nanoTime();
        long com = fim - inicio;
        //Criacao e escrita do arquivo log
        Arq.openWrite("613838_hashRehash.txt", "ISO-8859-1");
        //Printacao das variaveis contidas no arquivo
        Arq.println("613838 \t Tempo:" + com + "s \t Comparaçoes:" + hashComReserva.comparacoes);
        //Fechamento do arquivo
        Arq.close();
    }
}