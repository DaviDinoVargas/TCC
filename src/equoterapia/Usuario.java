package equoterapia;

public class Usuario {
    private int idUsuario;
    private String usuario;
    private String senha;
    private String Empresa;
    private Local local; 

    public Usuario(int idUsuario, String usuario, String senha, Local local) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.senha = senha;
        this.local = local;
    }



    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}
}