package gabriel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void testProdutoCreation() {
        Produto produto = new Produto("Produto A", 10, 99.99);
        assertEquals("Produto A", produto.getNome());
        assertEquals(10, produto.getQuantidade());
        assertEquals(99.99, produto.getPreco(), 0.01);
    }
}
