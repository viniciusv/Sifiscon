package sifiscon.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String cnpj;
    private String razaoSocial;
    private String inscricaoMunicipal;
    private String receitaBruta;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco = new Endereco();

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "fornecedor")
    private List<Processo> listProcesso = new ArrayList<Processo>();

    
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public List<Processo> getListProcesso() {
        return listProcesso;
    }

    public void setListProcesso(List<Processo> listProcesso) {
        this.listProcesso = listProcesso;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Integer getId() {
        return id;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public String getReceitaBruta() {
        return receitaBruta;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public void setReceitaBruta(String receitaBruta) {
        this.receitaBruta = receitaBruta;
    }
    
    
    
}
