package fiap.com.br.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by RM30222 on 29/08/2016.
 */
public class Time {

    private String nome;
    private String estado;
    private String escudo;
    @SerializedName("anofundacao")
    private int anoFundacao;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }
}
