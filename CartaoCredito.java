import java.time.LocalDate;

public class CartaoCredito extends Pagamento implements Estornavel {

    private final int parcelas;

    public CartaoCredito(String idTransacao, double valor, LocalDate data, int parcelas) {
        super(idTransacao, valor, data);
        this.parcelas = parcelas;
    }

    public int getParcelas() {
        return parcelas;
    }

    // TODO: taxa de 3,5% sobre o valor, mais R$ 0,50 por parcela além da 1ª
    @Override
    public double calcularTaxa() {
        return (getValor() * 0.035) + (0.5 * (parcelas - 1));
    }

    // TODO: imprima uma mensagem informando o número de parcelas
    @Override
    public void enviarNotificacao() {
        System.out.println("O quantidade de parcelas é: " + parcelas);
    }

    // TODO: cartão de crédito sempre pode ser estornado — retorne true
    @Override
    public boolean estornar() {
        return true;
    }
}
