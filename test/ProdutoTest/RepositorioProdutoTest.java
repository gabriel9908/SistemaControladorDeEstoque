package gabriel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepositorioProdutoTest {

    @BeforeEach
    public void setUp() {
        // Limpa a lista antes de cada teste
        while (!RepositorioProduto.listarProdutos().isEmpty()) {
            RepositorioProduto.removerProduto(RepositorioProduto.listarProdutos().get(0).getNome());
        }
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto("Produto A", 10, 99.99);
        RepositorioProduto.adicionarProduto(produto);
        List<Produto> produtos = RepositorioProduto.listarProdutos();
        assertEquals(1, produtos.size());
        assertEquals("Produto A", produtos.get(0).getNome());
    }

    @Test
    public void testRemoverProduto() {
        Produto produto = new Produto("Produto B", 5, 49.99);
        RepositorioProduto.adicionarProduto(produto);
        RepositorioProduto.removerProduto("Produto B");
        List<Produto> produtos = RepositorioProduto.listarProdutos();
        assertEquals(0, produtos.size());
    }

    @Test
    public void testListarProdutos() {
        Produto produto1 = new Produto("Produto C", 3, 29.99);
        Produto produto2 = new Produto("Produto D", 2, 19.99);
        RepositorioProduto.adicionarProduto(produto1);
        RepositorioProduto.adicionarProduto(produto2);
        
        List<Produto> produtos = RepositorioProduto.listarProdutos();
        assertEquals(2, produtos.size());
        assertEquals("Produto C", produtos.get(0).getNome());
        assertEquals("Produto D", produtos.get(1).getNome());
    }
}
