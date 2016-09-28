package sifiscon.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
    @Id
    @GeneratedValue
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String cep;
    private String unidadeFederativa;

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public Integer getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getNumero() {
        return numero;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setUnidadeFederativa(String uf) {
        this.unidadeFederativa = uf;
    }
}
