import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new Pix("TX001", 150.00, LocalDate.of(2026, 3, 10)));
        pagamentos.add(new CartaoCredito("TX002", 899.90, LocalDate.of(2026, 3, 12), 6));
        pagamentos.add(new Boleto("TX003", 320.00, LocalDate.of(2026, 3, 5)));

        System.out.println("=== Todos os pagamentos (ordem de cadastro) ===");
        for (Pagamento p : pagamentos) {
            System.out.println(p);
        }

        // TODO 4: percorra a lista chamando enviarNotificacao() em cada pagamento,
        // tratando-os de forma polimórfica (sem checar o tipo de cada um).
        System.out.println("TODO 4:");
        for (Pagamento pagamento : pagamentos) {
            pagamento.enviarNotificacao();
        }

        // TODO 5: ordene a lista pela ordem natural (compareTo, definido em Pagamento)
        // usando Collections.sort(pagamentos) e imprima o resultado.
        System.out.println("TODO 5:");
        Collections.sort(pagamentos);
        escreverLista(pagamentos);
        // TODO 6: crie um Comparator<Pagamento> que ordene por DATA (mais antigo primeiro)
        // e ordene a lista com ele. Duas formas possíveis:
        //   Collections.sort(pagamentos, comparator);
        //   pagamentos.sort(Comparator.comparing(Pagamento::getData));
        System.out.println("TODO 6:");
        Comparator<Pagamento> porData = Comparator.comparing(Pagamento::getData);
        Collections.sort(pagamentos, porData);
        escreverLista(pagamentos);

        // TODO 7: percorra a lista e, para cada pagamento que também for Estornavel,
        // chame estornar() e imprima o resultado (use "if (p instanceof Estornavel e) { ... }").
        System.out.println("TODO 7:");
        for (Pagamento pagamento : pagamentos) {
            System.out.println(pagamento);
            if (pagamento instanceof Estornavel e) {
                System.out.println(e.estornar());
            }
        }
    }

    public static void imprimirCodigoRastreio(Object objeto){
        if (objeto instanceof Rastreavel e) {
            System.out.println(e.codigoRastreio());
        }
    }

    public static void escreverLista(List<Pagamento> lista){
        for (Pagamento pagamento : lista) {
            System.out.println(pagamento);
            imprimirCodigoRastreio(pagamento);
        }
        System.out.println("----------------------------------------------------");
    }
}
