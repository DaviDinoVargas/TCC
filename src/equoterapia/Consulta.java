package equoterapia;

import java.sql.Date;
import java.util.ArrayList;

public class Consulta {
    private int idConsulta;
    private Date dataAvaliacao;
    private String condicaoSaude;
    private String mediador;
    private String guia;
    private String encilhamento;
    private Local local;
    private Usuario usuario;
    private ArrayList<EscalaAvaliacao> escalasAvaliacao;  

    public Consulta(int idConsulta, Date dataAvaliacao, String condicaoSaude, String mediador, String guia, String encilhamento, Local local) {
        this.idConsulta = idConsulta;
        this.dataAvaliacao = dataAvaliacao;
        this.condicaoSaude = condicaoSaude;
        this.mediador = mediador;
        this.guia = guia;
        this.encilhamento = encilhamento;
        this.local = local;
        this.setEscalasAvaliacao(new ArrayList<>());  
    }

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public String getCondicaoSaude() {
		return condicaoSaude;
	}

	public void setCondicaoSaude(String condicaoSaude) {
		this.condicaoSaude = condicaoSaude;
	}

	public String getMediador() {
		return mediador;
	}

	public void setMediador(String mediador) {
		this.mediador = mediador;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public String getEncilhamento() {
		return encilhamento;
	}

	public void setEncilhamento(String encilhamento) {
		this.encilhamento = encilhamento;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public ArrayList<EscalaAvaliacao> getEscalasAvaliacao() {
		return escalasAvaliacao;
	}

	public void setEscalasAvaliacao(ArrayList<EscalaAvaliacao> escalasAvaliacao) {
		this.escalasAvaliacao = escalasAvaliacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	}

   
