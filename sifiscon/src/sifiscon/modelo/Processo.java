package sifiscon.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Processo {
    @Id
    @GeneratedValue
    private Integer id;
    private String relatoFiscalizacao;
    private Date dataRelato;
    private String fiscalResponsavel;
    private String numeroDoProcesso;
    
    @ManyToOne
    private Fornecedor fornecedor = new Fornecedor();

    public void setNumeroDoProcesso(String numeroDoProcesso) {
		this.numeroDoProcesso = numeroDoProcesso;
	}
    
    public String getNumeroDoProcesso() {
		return numeroDoProcesso;
	}
    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDataRelato() {
        return dataRelato;
    }

    public String getFiscalResponsavel() {
        return fiscalResponsavel;
    }

    public Integer getId() {
        return id;
    }

    public String getRelatoFiscalizacao() {
        return relatoFiscalizacao;
    }

    public void setDataRelato(Date dataRelato) {
        this.dataRelato = dataRelato;
    }

    public void setFiscalResponsavel(String fiscalResponsavel) {
        this.fiscalResponsavel = fiscalResponsavel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRelatoFiscalizacao(String relatoFiscalizacao) {
        this.relatoFiscalizacao = relatoFiscalizacao;
    }
}
