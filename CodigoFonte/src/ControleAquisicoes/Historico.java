package ControleAquisicoes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Historico
{
    private ArrayList<Pedido> listaPedidos;

    public Historico() {
        listaPedidos = new ArrayList<Pedido>();
    }

    public void adicionarPedido(Pedido pedido) {
        if (pedido != null)
            listaPedidos.add(pedido);
    }

    // public String listarPedidosEntreDuasDatas(){}
    // public Usuario buscarPedidosFuncionario(){}
    // public Pedido buscarPelaDescricao(){}


    public String totalPedidos() {
        if (listaPedidos.size() == 0)
            return "Nenhum pedido registrado neste histórico.";

        int totalAbertos = 0, totalAprovados = 0, totalReprovados = 0;
        
        for (Pedido p: listaPedidos) {
            if (p.getStatus().equals("APROVADO"))
                totalAprovados++;
            else if (p.getStatus().equals("REPROVADO"))
                totalReprovados++;
            else
                totalAbertos++;
        }

        int percentualAbertos = totalAbertos * 100 / listaPedidos.size();
        int percentualAprovados = totalAprovados * 100 / listaPedidos.size();
        int percentualReprovados = totalReprovados * 100 / listaPedidos.size();

        return "Total de pedidos: " + listaPedidos.size() + 
               " || Abertos: " + totalAbertos + " (" + percentualAbertos + 
               "%) || Aprovados: " + totalAprovados + " (" + percentualAprovados +
               "%) || Reprovados: " + totalReprovados + " (" + percentualReprovados + "%)";
    }

        public List<Pedido> pedidosUltimos30Dias(){
            LocalDate data30DiasAtras = LocalDate.now().minusDays(30);
            List<Pedido> pedidosDe30DiasAtras =  listaPedidos.stream() .filter(p->p.getDataPedido().isBefore(data30DiasAtras)).collect(Collectors.toList());
            return pedidosDe30DiasAtras;
        }
    // public double valorTotalCategoria(){}
    // public String detalhePedidoMaiorAquisicao(){}

}
