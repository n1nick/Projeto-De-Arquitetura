package arquitetura.model;

public class Seguranca {
    
    private String idioma;
    private String tema;
    
    public Seguranca(String senhaAtual, String novaSenha) {
		// TODO Auto-generated constructor stub
	}

	public String getIdioma() {
        return idioma;
    }
    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public String getTema() {
        return tema;
    }
    
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public boolean criptografarDados() {
        // Implementar lógica de criptografia de dados
        return true;
    }
    
    public boolean autenticarLogin() {
        // Implementar lógica de autenticação de login
        return true;
    }
    
    public boolean excluirConta() {
        // Implementar lógica de exclusão de conta
        return true;
    }
    
}
	
