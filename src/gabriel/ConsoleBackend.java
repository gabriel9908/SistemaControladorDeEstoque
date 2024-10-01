package gabriel;

import java.util.ArrayList;
import java.util.List;

public class ConsoleBackend {
    private static List<String> logMensagens = new ArrayList<>();

    public static void log(String mensagem) {
        logMensagens.add(mensagem);
        System.out.println(mensagem);
    }

    public static void exibirLog() {
        System.out.println("=== LOG DE OPERAÇÕES ===");
        for (String mensagem : logMensagens) {
            System.out.println(mensagem);
        }
    }
}
