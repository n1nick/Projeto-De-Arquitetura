package arquitetura.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import arquitetura.controller.CtrlRecompensa;
import arquitetura.model.Recompensa;

public class TelaCadastroRecompensa extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lbNome;
    private JTextField tfNome;
    private JLabel lbDescricao;
    private JTextField tfDescricao;
    private JLabel lbPontos;
    private JTextField tfPontos;
    private JButton btSalvar;
    private JButton btCancelar;

    public TelaCadastroRecompensa() {
        initComponents();
        addListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        setTitle("Cadastro de Recompensa");
        setLayout(null);

        lbNome = new JLabel("Nome:");
        lbNome.setBounds(30, 30, 100, 25);
        add(lbNome);

        tfNome = new JTextField();
        tfNome.setBounds(140, 30, 200, 25);
        add(tfNome);

        lbDescricao = new JLabel("Descrição:");
        lbDescricao.setBounds(30, 70, 100, 25);
        add(lbDescricao);

        tfDescricao = new JTextField();
        tfDescricao.setBounds(140, 70, 200, 25);
        add(tfDescricao);

        lbPontos = new JLabel("Pontos:");
        lbPontos.setBounds(30, 110, 100, 25);
        add(lbPontos);

        tfPontos = new JTextField();
        tfPontos.setBounds(140, 110, 200, 25);
        add(tfPontos);

        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(50, 160, 100, 30);
        add(btSalvar);

        btCancelar = new JButton("Cancelar");
        btCancelar.setBounds(200, 160, 100, 30);
        add(btCancelar);
    }

    private void addListeners() {
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarRecompensa();
            }
        });

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void salvarRecompensa() {
        try {
            String nome = tfNome.getText();
            String descricao = tfDescricao.getText();
            int pontos = Integer.parseInt(tfPontos.getText().trim());

            Recompensa recompensa = new Recompensa(nome, descricao, pontos);

            if (CtrlRecompensa.criarRecompensa(recompensa)) {
                JOptionPane.showMessageDialog(this, "Recompensa salva com sucesso.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar recompensa.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um valor válido para os pontos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new TelaCadastroRecompensa();
    }
}
