package sifiscon.bean;

import sifiscon.dao.DAO;
import sifiscon.modelo.Fornecedor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class FornecedorBean {
    private Fornecedor fornecedor = new Fornecedor();
    private static final String CADASTRO_FORNECEDOR = "cadastroFornecedor";
    private static final String CONSULTAR_FORNECEDOR = "consultarFornecedor";
    private static final String INDEX = "index";
    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public List<Fornecedor> getFornecedores(){
    	 
        return new DAO<Fornecedor>(Fornecedor.class).listar();
    }
    
    public String novoFornecedor(){
        return CADASTRO_FORNECEDOR;
    }
    
    public String consultFornecedor(){
        return CONSULTAR_FORNECEDOR;
    }

    public String home(){
        return INDEX;
    }
    
    public String salvar() {
           // System.out.println("Registrando filme " + this.filme.getTitulo());
        
//            if (filme.getArtistas().isEmpty()) {
//                    throw new RuntimeException("O filme deve ter pelo menos um artista.");
//            }
      /*  String msg = new String();
        if(this.fornecedor.getCnpj() == null){
            msg += ",o cnpj está vazio ";
        }
        if(this.fornecedor.getRazaoSocial() == null){
            msg += "A razão social está vazio ";
        }
        if(this.fornecedor.getReceitaBruta() == null){
            msg += "A receita bruta está vazio ";
        }
        if(this.fornecedor.getEndereco().getLogradouro() == null){
            msg += "logradouro está vazio";
        }
        if(this.fornecedor.getEndereco().getNumero() == null){
            msg += "numero está vazio";
        }
        if(this.fornecedor.getEndereco().getBairro() == null){
            msg += "Bairro está vazio ";
        }
        if(this.fornecedor.getEndereco().getCep() == null){
            msg += "CEP está vazio";
        }
        if(this.fornecedor.getEndereco().getMunicipio() == null){
            msg += "Municipio está vazio";
        }
        if(this.fornecedor.getEndereco().getUnidadeFederativa() == null){
            msg += "Unidade federativa está vazio";
        }
        if(msg != "")
            throw new RuntimeException(msg);*/
       
        new DAO<Fornecedor>(Fornecedor.class).adicionar(this.fornecedor);

        this.fornecedor = new Fornecedor();
        return CONSULTAR_FORNECEDOR;
    }
}
