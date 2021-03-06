package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity

public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_movimentacao;
    private int id_lote;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto id_produto;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mov_data;
    private int mov_qtde;
    


    public int getId_movimentacao() {
        return id_movimentacao;
    }

    public void setId_movimentacao(int id_movimentacao) {
        this.id_movimentacao = id_movimentacao;
    }

    public int getId_lote() {
        return id_lote;
    }

    public void setId_lote(int id_lote) {
        this.id_lote = id_lote;
    }



    public int getMov_qtde() {
        return mov_qtde;
    }

    public void setMov_qtde(int mov_qtde) {
        this.mov_qtde = mov_qtde;
    }


    public Produto getId_produto() {
        return id_produto;
    }

    public void setId_produto(Produto id_produto) {
        this.id_produto = id_produto;
    }

    public Date getMov_data() {
        return mov_data;
    }

    public void setMov_data(Date mov_data) {
        this.mov_data = mov_data;
    }

}
