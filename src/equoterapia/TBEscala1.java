package equoterapia;

public class TBEscala1 {
    private int idTBEscala1;
    private int op1_1;
    private int op1_2;
    private int op1_3;
    private int op1_4;
    private String comentarioDM1;
    private int somaDM1;
    private int idEscalaAvaliacao;
    private Usuario usuario;

    public TBEscala1(int idTBEscala1, int op1_1, int op1_2, int op1_3, int op1_4, String comentarioDM1, int somaDM1, int idEscalaAvaliacao) {
        this.idTBEscala1 = idTBEscala1;
        this.op1_1 = op1_1;
        this.op1_2 = op1_2;
        this.op1_3 = op1_3;
        this.op1_4 = op1_4;
        this.comentarioDM1 = comentarioDM1;
        this.somaDM1 = somaDM1;
        this.idEscalaAvaliacao = idEscalaAvaliacao;
    }

	public int getIdTBEscala1() {
		return idTBEscala1;
	}

	public void setIdTBEscala1(int idTBEscala1) {
		this.idTBEscala1 = idTBEscala1;
	}

	public int getOp1_1() {
		return op1_1;
	}

	public void setOp1_1(int op1_1) {
		this.op1_1 = op1_1;
	}

	public int getOp1_2() {
		return op1_2;
	}

	public void setOp1_2(int op1_2) {
		this.op1_2 = op1_2;
	}

	public int getOp1_3() {
		return op1_3;
	}

	public void setOp1_3(int op1_3) {
		this.op1_3 = op1_3;
	}

	public int getOp1_4() {
		return op1_4;
	}

	public void setOp1_4(int op1_4) {
		this.op1_4 = op1_4;
	}

	public String getComentarioDM1() {
		return comentarioDM1;
	}

	public void setComentarioDM1(String comentarioDM1) {
		this.comentarioDM1 = comentarioDM1;
	}

	public int getSomaDM1() {
		return somaDM1;
	}

	public void setSomaDM1(int somaDM1) {
		this.somaDM1 = somaDM1;
	}

	public int getIdEscalaAvaliacao() {
		return idEscalaAvaliacao;
	}

	public void setIdEscalaAvaliacao(int idEscalaAvaliacao) {
		this.idEscalaAvaliacao = idEscalaAvaliacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}