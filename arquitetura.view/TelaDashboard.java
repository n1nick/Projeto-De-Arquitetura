package arquitetura.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaDashboard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JMenuBar menuBar;
    private JMenu menuCategoria;
    private JMenuItem miCadastrarCategoria;
    private JMenu menuConfiguracao;
    private JMenuItem miAlterarIdioma;
    private JMenuItem miAlterarTema;
    private JMenuItem miExcluirConta;
    private JMenu menuNotificacao;
    private JMenuItem miEnviarAlerta;
    private JMenu menuRecompensa;
    private JMenuItem miConcederRecompensa;
    private JMenu menuTransacao;
    private JMenuItem miRegistrarTransacao;
    private JMenuItem miEditarTransacao;
    private JMenuItem miExcluirTransacao;

    public TelaDashboard() {
        initComponents();
        addListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centralizar a tela
        setVisible(true);
    }

    private void initComponents() {
        setTitle("Dashboard");
        
        // MenuBar
        menuBar = new JMenuBar();

        // Menu Categoria
        menuCategoria = new JMenu("Categoria");
        miCadastrarCategoria = new JMenuItem("Cadastrar Categoria");
        menuCategoria.add(miCadastrarCategoria);
        menuBar.add(menuCategoria);

        // Menu Configuração
        menuConfiguracao = new JMenu("Configuração");
        miAlterarIdioma = new JMenuItem("Alterar Idioma");
        miAlterarTema = new JMenuItem("Alterar Tema");
        miExcluirConta = new JMenuItem("Excluir Conta");
        menuConfiguracao.add(miAlterarIdioma);
        menuConfiguracao.add(miAlterarTema);
        menuConfiguracao.add(miExcluirConta);
        menuBar.add(menuConfiguracao);

        // Menu Notificação
        menuNotificacao = new JMenu("Notificação");
        miEnviarAlerta = new JMenuItem("Enviar Alerta");
        menuNotificacao.add(miEnviarAlerta);
        menuBar.add(menuNotificacao);

        // Menu Recompensa
        menuRecompensa = new JMenu("Recompensa");
        miConcederRecompensa = new JMenuItem("Conceder Recompensa");
        menuRecompensa.add(miConcederRecompensa);
        menuBar.add(menuRecompensa);

        // Menu Transação
        menuTransacao = new JMenu("Transação");
        miRegistrarTransacao = new JMenuItem("Registrar Transação");
        miEditarTransacao = new JMenuItem("Editar Transação");
        miExcluirTransacao = new JMenuItem("Excluir Transação");
        menuTransacao.add(miRegistrarTransacao);
        menuTransacao.add(miEditarTransacao);
        menuTransacao.add(miExcluirTransacao);
        menuBar.add(menuTransacao);

        setJMenuBar(menuBar);
    }

    private void addListeners() {
        miCadastrarCategoria.addActionListener(e -> abrirTelaCadastroCategoria());
        miAlterarIdioma.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade: Alterar Idioma"));
        miAlterarTema.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade: Alterar Tema"));
        miExcluirConta.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade: Excluir Conta"));
    }

    private void abrirTelaCadastroCategoria() {
        TelaCadastroCategoria telaCadastroCategoria = new TelaCadastroCategoria();
        telaCadastroCategoria.setVisible(true);
    }

    public static void main(String[] args) {
        new TelaDashboard();
    }
}
