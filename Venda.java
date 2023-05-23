package aplicacao;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private int id;
    private double valorTotal;
    private double valorUnitario;
    private List<Produto> produtos;

    public Venda(int id, double valorUnitario) {
        this.id = id;
        this.valorTotal = 0.0;
        this.valorUnitario = valorUnitario;
        this.produtos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        valorTotal += valorUnitario;
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        valorTotal -= valorUnitario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
