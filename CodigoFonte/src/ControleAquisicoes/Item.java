package ControleAquisicoes;
public class Item
{
    private int idItem;
    private String descricao;
    private double valor;

    public Item(int idItem, String descricao, double valor)
    {
        this.idItem = idItem;
        this.descricao = descricao;
        this.valor = valor;
    }
}