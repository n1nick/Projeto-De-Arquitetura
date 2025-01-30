package arquitetura.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import arquitetura.controller.CtrlLogin;
import arquitetura.model.LoginBean;

public class TelaLogin extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JLabel lbUser;
    private JLabel lbPassword;
    private JTextField tfUser;
    private JPasswordField tfPassword;
    private JButton btLogin;
    private JButton btClose;

    public TelaLogin() {
        initComponents();
        addListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centralizar a tela
        setVisible(true);
    }
    
    private void initComponents() {
        setTitle("Tela de Login");
        setLayout(null);
        
        lbUser = new JLabel("Usuário:");
        lbUser.setBounds(50, 30, 80, 25);
        add(lbUser);

        tfUser = new JTextField();
        tfUser.setBounds(130, 30, 120, 25);
        add(tfUser);

        lbPassword = new JLabel("Senha:");
        lbPassword.setBounds(50, 70, 80, 25);
        add(lbPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(130, 70, 120, 25);
        add(tfPassword);

        btLogin = new JButton("Login");
        btLogin.setBounds(50, 110, 90, 25);
        add(btLogin);

        btClose = new JButton("Fechar");
        btClose.setBounds(160, 110, 90, 25);
        add(btClose);
    }

    private void addListeners() {
        btLogin.addActionListener(e -> login());
        btClose.addActionListener(e -> dispose());
    }

    private void login() {
        String user = tfUser.getText();
        String password = new String(tfPassword.getPassword());
        LoginBean loginBean = new LoginBean(user, password);
        
        try {
            if (CtrlLogin.login(loginBean)) {
                TelaDashboard dashboard = new TelaDashboard();
                dashboard.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao realizar login: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new TelaLogin();
    }

    public JLabel getLbUser() {
        return lbUser;
    }

    public void setLbUser(JLabel lbUser) {
        this.lbUser = lbUser;
    }

    public JLabel getLbPassword() {
        return lbPassword;
    }

    public void setLbPassword(JLabel lbPassword) {
        this.lbPassword = lbPassword;
    }

    public JButton getBtLogin() {
        return btLogin;
    }

    public void setBtLogin(JButton btLogin) {
        this.btLogin = btLogin;
    }

    public JButton getBtClose() {
        return btClose;
    }

    public void setBtClose(JButton btClose) {
        this.btClose = btClose;
    }
}
