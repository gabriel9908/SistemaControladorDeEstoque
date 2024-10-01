package gabriel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstoqueApp extends JFrame {
    private JTextField nomeField, quantidadeField, precoField;
    private JTextArea displayArea;

    public EstoqueApp() {
        super("Sistema de Estoque, By: Gabriel Santos do Nascimento");

        // Exibe a tela de login antes de qualquer outra operação
        Login.exibirTelaLogin();

        // Criação dos campos de entrada e o console de exibição
        nomeField = new JTextField(15);
        quantidadeField = new JTextField(5);
        precoField = new JTextField(10);
        displayArea = new JTextArea(15, 50); // Aumentado para um tamanho maior
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 16)); // Fonte maior e monospaced

        // Criação dos botões com fontes maiores
        JButton addButton = new JButton("Adicionar Produto");
        JButton removeButton = new JButton("Remover Produto");
        JButton listarButton = new JButton("Listar Produtos");
        JButton sairButton = new JButton("Sair");

        Font botaoFonte = new Font("Arial", Font.BOLD, 18); // Define a fonte dos botões
        addButton.setFont(botaoFonte);
        removeButton.setFont(botaoFonte);
        listarButton.setFont(botaoFonte);
        sairButton.setFont(botaoFonte);

        // Ação para adicionar produto
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                int quantidade = Integer.parseInt(quantidadeField.getText());
                double preco = Double.parseDouble(precoField.getText());

                Produto produto = new Produto(nome, quantidade, preco);
                RepositorioProduto.adicionarProduto(produto);
                displayArea.append("Produto adicionado: " + nome + "\n");
            }
        });

        // Ação para remover produto
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                if (RepositorioProduto.removerProduto(nome)) {
                    displayArea.append("Produto removido: " + nome + "\n");
                } else {
                    displayArea.append("Produto não encontrado: " + nome + "\n");
                }
            }
        });

        // Ação para listar produtos
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder builder = new StringBuilder("Produtos no estoque:\n");
                for (Produto p : RepositorioProduto.listarProdutos()) {
                    builder.append(p.getNome()).append(" - ")
                           .append(p.getQuantidade()).append(" unidades - R$ ")
                           .append(p.getPreco()).append("\n");
                }
                displayArea.setText(builder.toString());
            }
        });

        // Ação para sair do app
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Encerra a aplicação
            }
        });

        // Configurações de layout
        setLayout(new BorderLayout());

        // Cabeçalho com título estilizado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Cor azul suave
        JLabel titleLabel = new JLabel("Sistema de Estoque");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32)); // Fonte grande e estilizada
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        // Painel de entrada de dados
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // Grid espaçoso
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Quantidade:"));
        inputPanel.add(quantidadeField);
        inputPanel.add(new JLabel("Preço:"));
        inputPanel.add(precoField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // Painel lateral decorativo com botões
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // Para "Listar" e "Sair"
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.add(listarButton);
        buttonPanel.add(sairButton);

        // Área central para exibição de dados (console)
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JScrollPane(displayArea));

        // Rodapé com alguma mensagem de informação ou status
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(192, 192, 192)); // Cinza claro
        JLabel footerLabel = new JLabel("Desenvolvido por Gabriel Santos do Nascimento");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        footerPanel.add(footerLabel);

        // Adiciona os componentes ao layout principal
        add(headerPanel, BorderLayout.NORTH);  // Cabeçalho
        add(inputPanel, BorderLayout.WEST);    // Painel de entrada à esquerda
        add(buttonPanel, BorderLayout.EAST);   // Painel de botões à direita
        add(centerPanel, BorderLayout.CENTER); // Console no centro
        add(footerPanel, BorderLayout.SOUTH);  // Rodapé

        // Configura para que a janela fique em modo "full screen"
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EstoqueApp());
    }
}
