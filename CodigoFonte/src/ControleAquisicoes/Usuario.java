package ControleAquisicoes;
public class Usuario
{
    private static int nextId = 0;
    protected int id;
    protected String nome;
    protected boolean isAdmin;

    public Usuario(String nome, boolean isAdmin) {
        this.id = nextId++;
        this.nome = nome;
        this.isAdmin = isAdmin;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}