package gabriel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioProduto {
    private static List<Produto> produtos = new ArrayList<>();

    public static void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public static Optional<Produto> consultarProduto(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public static List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }

    public static boolean removerProduto(String nome) {
        return produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }
}
