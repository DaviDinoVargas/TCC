package equoterapia;

public class EscalaAvaliacao {
    private int idEscalaAvaliacao;
    private int somaTotal;
    private Usuario usuario;
    private int idConsulta;

    public EscalaAvaliacao(int idEscalaAvaliacao, int somaTotal, int idConsulta) {
        this.idEscalaAvaliacao = idEscalaAvaliacao;
        this.somaTotal = somaTotal;
        this.idConsulta = idConsulta;
    }

    public int getIdEscalaAvaliacao() {
        return idEscalaAvaliacao;
    }

    public void setIdEscalaAvaliacao(int idEscalaAvaliacao) {
        this.idEscalaAvaliacao = idEscalaAvaliacao;
    }

    public int getSomaTotal() {
        return somaTotal;
    }

    public void setSomaTotal(int somaTotal) {
        this.somaTotal = somaTotal;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}