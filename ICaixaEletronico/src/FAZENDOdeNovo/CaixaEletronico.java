package FAZENDOdeNovo;

import java.util.HashMap;
import java.util.Map;

public class CaixaEletronico implements ICaixaEletronico {

    private Integer saldoTotal = 0;
    private Integer cotaMinima = 0;
    // Mapa para armazenar: <Valor da Nota, Quantidade>
    private Map<Integer, Integer> cedulas = new HashMap<>();

    @Override
    public String pegaValorTotalDisponivel() {
        return "Saldo disponível: R$ " + saldoTotal;
    }

    @Override
    public String sacar(Integer valor) {
        if (valor > saldoTotal) {
            return "Erro: Saldo insuficiente no caixa.";
        }
        if (valor < cotaMinima) {
            return "Erro: O valor mínimo para saque é R$ " + cotaMinima;
        }

        saldoTotal -= valor;
        return "Saque de R$ " + valor + " realizado com sucesso!";
    }

    @Override
    public String pegaRelatorioCedulas() {
        StringBuilder relatorio = new StringBuilder("--- Relatório de Cédulas ---\n");
        for (Map.Entry<Integer, Integer> entry : cedulas.entrySet()) {
            relatorio.append("Nota R$ ").append(entry.getKey())
                     .append(": ").append(entry.getValue()).append(" unidades\n");
        }
        return relatorio.toString();
    }

    @Override
    public String reposicaoCedulas(Integer cedula, Integer quantidade) {
        cedulas.put(cedula, cedulas.getOrDefault(cedula, 0) + quantidade);
        saldoTotal += (cedula * quantidade);
        return "Reposição concluída: " + quantidade + " notas de R$ " + cedula + " adicionadas.";
    }

    @Override
    public String armazenaCotaMinima(Integer minimo) {
        this.cotaMinima = minimo;
        return "Cota mínima de atendimento definida para: R$ " + minimo;
    }
}