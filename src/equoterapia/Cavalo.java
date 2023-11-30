package equoterapia;

public class Cavalo {
	private int id;
	private String nome;
	private int idade;
	private String raca;
	private Consulta consulta;
	private Usuario usuario;
	public Cavalo() {
		}
	
	public Cavalo(int id, String nome, int idade, String raca, Consulta consulta) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.raca = raca;
		this.consulta = consulta;

	}
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getIdade() {
			return idade;
		}
		public void setIdade(int idade) {
			this.idade = idade;
		}
		public String getRaca() {
			return raca;
		}
		public void setRaca(String raca) {
			this.raca = raca;
		}
		
		public String toString() {
			return id + nome + idade + raca;
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

