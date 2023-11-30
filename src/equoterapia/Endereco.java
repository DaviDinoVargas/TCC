package equoterapia;
import java.util.ArrayList;

public class Endereco {
		private int idtb_endereco;
		private int numero;
		private int cep;
		private String cidade;
		private String pais;
		private String uf;
	    private String rua;
	    private Usuario usuario;
	    private ArrayList<Paciente> pacientes;

	    public Endereco(String rua, int idtb_endereco, int numero, int cep, String cidade, String pais, String uf) {
	    	this.idtb_endereco = idtb_endereco;
			this.numero = numero;
			this.cep = cep;
			this.cidade = cidade;
			this.pais = pais;
			this.uf = uf;
	        this.rua = rua;
	        this.pacientes = new ArrayList<>();
	    }

	    public Endereco(int int1, String string, String string2, int int2, String string3, int int3, String string4) {
			
		}

		public int getIdtb_endereco() {
			return idtb_endereco;
		}

		public void setIdtb_endereco(int idtb_endereco) {
			this.idtb_endereco = idtb_endereco;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public int getCep() {
			return cep;
		}

		public void setCep(int cep) {
			this.cep = cep;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getPais() {
			return pais;
		}

		public void setPais(String pais) {
			this.pais = pais;
		}

		public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public String getRua() {
			return rua;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}

		public void setPacientes(ArrayList<Paciente> pacientes) {
			this.pacientes = pacientes;
		}

		public void adicionarPaciente(Paciente paciente) {
	        this.pacientes.add(paciente);
	    }

	    public ArrayList<Paciente> getPacientes() {
	        return pacientes;
	    }

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public String getCnpj() {
			
			return null;
		}

		public int getIdEndereco() {
			
			return 0;
		}
	    
	}

