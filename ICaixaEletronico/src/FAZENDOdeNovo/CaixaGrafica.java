package FAZENDOdeNovo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaixaGrafica extends JFrame {

    // Instância da lógica do caixa
    private ICaixaEletronico caixa = new CaixaEletronico();

    // Componentes da Interface
    private JTextField txtValor = new JTextField(10);
    private JTextArea areaConsola = new JTextArea(10, 30);
    private JButton btnSacar = new JButton("Sacar");
    private JButton btnSaldo = new JButton("Ver Saldo");
    private JButton btnRelatorio = new JButton("Relatório Notas");

    public CaixaGrafica() {
        // Configurações da Janela
        setTitle("Sistema de Caixa Eletrónico");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Adicionar componentes ao ecrã
        add(new JLabel("Valor (R$):"));
        add(txtValor);
        add(btnSacar);
        add(btnSaldo);
        add(btnRelatorio);
        
        // Área de texto com scroll para ver os resultados
        areaConsola.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaConsola);
        add(scroll);

        // --- Configuração dos Eventos (CLIQUES) ---

        // Ação do botão Saldo
        btnSaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String resultado = caixa.pegaValorTotalDisponivel();
                areaConsola.append(resultado + "\n");
            }
        });

        // Ação do botão Sacar
        btnSacar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer valor = Integer.parseInt(txtValor.getText());
                    String msg = caixa.sacar(valor);
                    areaConsola.append(msg + "\n");
                } catch (NumberFormatException ex) {
                    areaConsola.append("Erro: Digite um número válido!\n");
                }
            }
        });

        // Ação do botão Relatório
        btnRelatorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaConsola.append(caixa.pegaRelatorioCedulas() + "\n");
            }
        });

        // Inicializar com algum dinheiro para testar
        caixa.reposicaoCedulas(50, 20); // R$ 1000
    }

    public static void main(String[] args) {
        // Executar a interface
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CaixaGrafica().setVisible(true);
            }
        });
    }
}