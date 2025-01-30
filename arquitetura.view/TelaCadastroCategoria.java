package arquitetura.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import arquitetura.controller.CtrlCategoria;
import arquitetura.model.Categoria;

public class TelaCadastroCategoria extends JFrame {
    
    private static final long serialVersionUID = 1L;
	private JLabel lbNome;
    private JTextField tfNome;
    private JButton btSalvar;
    private JButton btCancelar;
    
    public TelaCadastroCategoria() {
        // Implementar a tela de cadastro de categoria
    }
    
    @SuppressWarnings("unused")
	private void initComponents() {
        // Inicializar componentes da tela
    }
    
    @SuppressWarnings("unused")
	private void addListeners() {
        // Adicionar listeners aos botões
    }
    
    @SuppressWarnings("unused")
	private void salvarCategoria() {
        // Obter dados da categoria
        String nome = tfNome.getText();
        Categoria categoria = new Categoria();
        categoria.setNome(nome);
        
        // Salvar categoria
        if (CtrlCategoria.criarCategoria(categoria)) {
            JOptionPane.showMessageDialog(this, "Categoria salva com sucesso.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar categoria.");
        }
    }

	

	public JLabel getLbNome() {
		return lbNome;
	}

	public void setLbNome(JLabel lbNome) {
		this.lbNome = lbNome;
	}

	public JButton getBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(JButton btSalvar) {
		this.btSalvar = btSalvar;
	}

	public JButton getBtCancelar() {
		return btCancelar;
	}

	public void setBtCancelar(JButton btCancelar) {
		this.btCancelar = btCancelar;
	}
    
}
