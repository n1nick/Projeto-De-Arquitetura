package arquitetura.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import arquitetura.controller.CtrlTransacao;
import arquitetura.model.Transacao;

public class TelaCadastroTransacao extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lbDescricao;
    private JTextField tfDescricao;
    private JLabel lbValor;
    private JTextField tfValor;
    private JButton btSalvar;
    private JButton btEditar;
    private JButton btExcluir;

    public TelaCadastroTransacao() {
        initComponents();
        addListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        setTitle("Cadastro de Transação");
        setLayout(null);

        lbDescricao = new JLabel("Descrição:");
        lbDescricao.setBounds(30, 30, 100, 25);
        add(lbDescricao);

        tfDescricao = new JTextField();
        tfDescricao.setBounds(140, 30, 200, 25);
        add(tfDescricao);

        lbValor = new JLabel("Valor:");
        lbValor.setBounds(30, 70, 100, 25);
        add(lbValor);

        tfValor = new JTextField();
        tfValor.setBounds(140, 70, 200, 25);
        add(tfValor);

        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(30, 160, 100, 30);
        add(btSalvar);

        btEditar = new JButton("Editar");
        btEditar.setBounds(140, 160, 100, 30);
        add(btEditar);

        btExcluir = new JButton("Excluir");
        btExcluir.setBounds(250, 160, 100, 30);
        add(btExcluir);
    }

    private void addListeners() {
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarTransacao();
            }
        });

        btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarTransacao();
            }
        });

        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirTransacao();
            }
        });
    }

    private void registrarTransacao() {
        try {
            String descricao = tfDescricao.getText();
            double valor = Double.parseDouble(tfValor.getText().trim());

            Transacao transacao = new Transacao(descricao, valor);

            if (CtrlTransacao.editarTransacao(transacao)) {
                JOptionPane.showMessageDialog(this, "Transação registrada com sucesso.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao registrar transação.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um valor válido para o campo valor.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarTransacao() {
        try {
            String descricao = tfDescricao.getText();
            double valor = Double.parseDouble(tfValor.getText().trim());

            Transacao transacao = new Transacao(descricao, valor);

            if (CtrlTransacao.editarTransacao(transacao)) {
                JOptionPane.showMessageDialog(this, "Transação editada com sucesso.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao editar transação.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um valor válido para o campo valor.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirTransacao() {
        String descricao = tfDescricao.getText();

        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a transação?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            double valor = Double.parseDouble(tfValor.getText().trim());
            Transacao transacao = new Transacao(descricao, valor);

            if (CtrlTransacao.excluirTransacao(transacao)) {
                JOptionPane.showMessageDialog(this, "Transação excluída com sucesso.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir transação.");
            }
        }
    }

    public static void main(String[] args) {
        new TelaCadastroTransacao();
    }
}
