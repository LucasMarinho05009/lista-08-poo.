package br.com.cybercorp.model;

import java.util.Objects;

public class Credencial {
    private String codigoHex;
    private boolean ativo;
    private Funcionario titular;

    // Assinatura usada pela RN06.
    public Credencial(String codigoHex, boolean ativo, Funcionario titular) {
        this.codigoHex = Objects.requireNonNull(codigoHex);
        this.ativo = ativo;
        this.titular = Objects.requireNonNull(titular);
    }

    // Sobrecarga para a assinatura com dois parâmetros mostrada no UML.
    public Credencial(String codigoHex, Funcionario titular) {
        this(codigoHex, true, titular);
    }

    public String getCodigoHex() { return codigoHex; }
    // Não alterar a chave enquanto a credencial estiver armazenada em um HashSet.
    public void setCodigoHex(String codigoHex) { this.codigoHex = Objects.requireNonNull(codigoHex); }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
    public Funcionario getTitular() { return titular; }
    public void setTitular(Funcionario titular) { this.titular = Objects.requireNonNull(titular); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Credencial outra = (Credencial) obj;
        return Objects.equals(codigoHex, outra.codigoHex);
    }

    @Override
    public int hashCode() { return Objects.hash(codigoHex); }

    @Override
    public String toString() {
        return "Credencial [" + codigoHex + ", ativo=" + ativo + ", titular=" + titular.getNome() + "]";
    }
}
