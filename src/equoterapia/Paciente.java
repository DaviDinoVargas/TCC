package equoterapia;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Paciente {
	
	    private int idCadastro;
	    private int idade;
	    private String praticante;
	    private Boolean sexo;
	    private String cpf;
	    private String email;
	    private Date dataNascimento;
	    private ArrayList<Endereco> enderecos;
	    private Usuario usuario;
	    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		private Consulta consulta;

	    public Paciente(int idcadastro, String nome, String dataNascimento, Boolean sexo, String cpf, int idade, String praticante, Consulta consulta) throws ParseException {
	        this.idCadastro = idcadastro;
	        this.praticante = praticante;
	        this.dataNascimento = (Date) sdf.parse(dataNascimento);
	        this.idade = idade;
	        this.sexo = sexo;
	        this.cpf = cpf;
	        this.consulta = consulta;
	        this.enderecos = new ArrayList<>();
	        
	        
	    }

	    public Paciente(int int1, String string, Date date, boolean boolean1, String string2, int int2, String string3,
				int int3) {
			// TODO Auto-generated constructor stub
		}

		public int getIdCadastro() {
			return idCadastro;
		}

		public void setIdCadastro(int idCadastro) {
			this.idCadastro = idCadastro;
		}

		public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
		}

		public String getPraticante() {
			return praticante;
		}

		public void setPraticante(String praticante) {
			this.praticante = praticante;
		}

		public Boolean getSexo() {
			return sexo;
		}

		public void setSexo(Boolean sexo) {
			this.sexo = sexo;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public void setEnderecos(ArrayList<Endereco> enderecos) {
			this.enderecos = enderecos;
		}

		public void adicionarEndereco(Endereco endereco) {
	        this.enderecos.add(endereco);
	        endereco.adicionarPaciente(this);
	    }

	    public ArrayList<Endereco> getEnderecos() {
	        return enderecos;
	    }
	    
	    public String getDataNascimentoFormatted() {
	        return sdf.format(dataNascimento);
	    }
	    
	    public Consulta getConsulta() {
	        return consulta;
	    }

	    public void setConsulta(Consulta consulta) {
	        this.consulta = consulta;
	    }

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
	}
