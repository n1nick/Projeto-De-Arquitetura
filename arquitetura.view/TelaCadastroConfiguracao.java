package arquitetura.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import arquitetura.controller.CtrlConfiguracao;
import arquitetura.model.Configuracao;

public class TelaCadastroConfiguracao extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lbIdioma;
    private JComboBox<String> cbIdioma;
    private JLabel lbTema;
    private JComboBox<String> cbTema;
    private JButton btSalvar;
    private JButton btExcluirConta;

    public TelaCadastroConfiguracao() {
        initComponents();
        addListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        setTitle("Cadastro de Configuração");
        setLayout(null);

        lbIdioma = new JLabel("Idioma:");
        lbIdioma.setBounds(30, 30, 100, 25);
        add(lbIdioma);

        cbIdioma = new JComboBox<>(new String[]{"Português", "Inglês", "Espanhol"});
        cbIdioma.setBounds(140, 30, 150, 25);
        add(cbIdioma);

        lbTema = new JLabel("Tema:");
        lbTema.setBounds(30, 70, 100, 25);
        add(lbTema);

        cbTema = new JComboBox<>(new String[]{"Claro", "Escuro"});
        cbTema.setBounds(140, 70, 150, 25);
        add(cbTema);

        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(50, 120, 100, 30);
        add(btSalvar);

        btExcluirConta = new JButton("Excluir Conta");
        btExcluirConta.setBounds(200, 120, 150, 30);
        add(btExcluirConta);
    }

    private void addListeners() {
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarIdioma();
                alterarTema();
            }
        });

        btExcluirConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirConta();
            }
        });
    }

    private void alterarIdioma() {
        String idioma = (String) cbIdioma.getSelectedItem();
        Configuracao configuracao = new Configuracao();
        configuracao.setIdioma(idioma);

        if (CtrlConfiguracao.alterarIdioma(configuracao)) {
            JOptionPane.showMessageDialog(this, "Idioma alterado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar idioma.");
        }
    }

    private void alterarTema() {
        String tema = (String) cbTema.getSelectedItem();
        Configuracao configuracao = new Configuracao();
        configuracao.setTema(tema);

        if (CtrlConfiguracao.alterarTema(configuracao)) {
            JOptionPane.showMessageDialog(this, "Tema alterado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar tema.");
        }
    }

    private void excluirConta() {
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir a conta?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            Configuracao configuracao = new Configuracao();

            if (CtrlConfiguracao.excluirConta(configuracao)) {
                JOptionPane.showMessageDialog(this, "Conta excluída com sucesso.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir conta.");
            }
        }
    }

    public static void main(String[] args) {
        new TelaCadastroConfiguracao();
    }
}
