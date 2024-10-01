package gabriel;

import javax.swing.*;

public class Login {
    private final String usuarioValido = "usuario123";
    private final String senhaValida = "123";

    public boolean autenticar(String usuario, String senha) {
        if (usuario.equals(usuarioValido) && senha.equals(senhaValida)) {
            ConsoleBackend.log("Usuário autenticado com sucesso!");
            return true;
        } else {
            ConsoleBackend.log("Falha na autenticação. Usuário ou senha incorretos.");
            return false;
        }
    }

    public static void exibirTelaLogin() {
        String usuario = JOptionPane.showInputDialog(null, "Digite seu usuário:");
        String senha = JOptionPane.showInputDialog(null, "Digite sua senha:");
        Login login = new Login();

        if (!login.autenticar(usuario, senha)) {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos! Fechando aplicação.");
            System.exit(0);
        }
    }
}
