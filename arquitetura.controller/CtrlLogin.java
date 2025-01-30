package arquitetura.controller;

import arquitetura.model.LoginBean;
import arquitetura.model.LoginDAO;

public class CtrlLogin {
    
    public static boolean login(LoginBean loginBean) throws Exception {
        // Verificação simples
        if (loginBean.getUser().isEmpty() || loginBean.getPassword().isEmpty())
            return true;
        // Validar usuário e senha
        LoginDAO loginDAO = new LoginDAO();
        return loginDAO.authenticateUser(loginBean);
    }

}
