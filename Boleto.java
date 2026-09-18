import java.time.LocalDate;

// Repare: Boleto NÃO implementa Estornavel — depois de compensado, não há como estornar.
// Isso é proposital: mostra que interfaces são contratos opcionais por subclasse,
// diferente de um método herdado da classe abstrata (que toda subclasse carrega).
public class Boleto extends Pagamento implements Rastreavel {

    public Boleto(String idTransacao, double valor, LocalDate data) {
        super(idTransacao, valor, data);
    }

    // TODO: taxa fixa de R$ 3,49
    @Override
    public double calcularTaxa() {
        return 3.49;
    }

    @Override
    public String codigoRastreio() {
        return "Codigo: \n00191.57379 00391.944279 44354.919928 6 26210000352155";
    }

    // TODO: imprima uma mensagem confirmando que o boleto foi gerado
    @Override
    public void enviarNotificacao() {
        System.out.println("Boleto gerado.");
    }
}
