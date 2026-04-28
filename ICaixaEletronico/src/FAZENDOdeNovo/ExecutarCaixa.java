package FAZENDOdeNovo;

public class ExecutarCaixa {
    public static void main(String[] args) {
    	
        // Instanciamos a nossa implementação
        ICaixaEletronico meuCaixa = new CaixaEletronico();

        // 1. Abastecendo o caixa
        System.out.println(meuCaixa.reposicaoCedulas(50, 10)); // Adiciona 10 notas de 50 (R$ 500)
        System.out.println(meuCaixa.armazenaCotaMinima(20));   // Saque mínimo de 20

        // 2. Verificando saldo
        System.out.println(meuCaixa.pegaValorTotalDisponivel());

        // 3. Tentando sacar
        System.out.println(meuCaixa.sacar(150));
        
        // 4. Verificando saldo final e relatório
        System.out.println(meuCaixa.pegaValorTotalDisponivel());
        System.out.println(meuCaixa.pegaRelatorioCedulas());
    }
}