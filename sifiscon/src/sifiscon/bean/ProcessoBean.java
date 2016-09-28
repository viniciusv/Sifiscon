package sifiscon.bean;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sifiscon.dao.DAO;
import sifiscon.modelo.Processo;

@ManagedBean
@SessionScoped
public class ProcessoBean {
	
	private Processo processo = new Processo();
	private String mensagem = new String();
	public static final String CADASTRAR_PROCESSO = "cadastrarProcesso";
	public static final String CONSULTAR_PROCESSO = "consultarProcesso";
	public static final String EDITAR_PROCESSO = "editarProcesso";
	private static final String INDEX = "index";
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Processo getProcesso() {
		return processo;
	}
	
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	
	public String excluirProcesso(Processo processo){
		
		new DAO<Processo>(Processo.class).remover(processo);
		return CONSULTAR_PROCESSO;
	}
	
	public String novoProcesso(){
		processo = new Processo();
		return CADASTRAR_PROCESSO;
	}
	
	public String buscar(){
		String cnpjPesquisar = this.processo.getFornecedor().getCnpj();
		
		processo.setFornecedor(new DAO<Processo>(Processo.class).buscarPorCnpj(cnpjPesquisar));
		if(processo.getFornecedor() == null){
			mensagem = "CNPJ não encontrado!";
			processo = new Processo();
		}else{
			mensagem = "";
		}
		return CADASTRAR_PROCESSO;
	}	
	
	public String editarProcesso(Processo processo){
		this.processo = processo;
		return EDITAR_PROCESSO;
	}
	
	public String salvar(){
		System.out.println("passei");
		if(processo.getId() == null){
			System.out.println("passei - add");
			SimpleDateFormat formtData = new SimpleDateFormat("yyyyMMdd-HHmmss-");
			String numeroProcesso = formtData.format(processo.getDataRelato());
			numeroProcesso += processo.getFornecedor().getCnpj();
			System.out.println(numeroProcesso);
			processo.setNumeroDoProcesso(numeroProcesso);
			new DAO<Processo>(Processo.class).adicionar(this.processo);
		}else{
			new DAO<Processo>(Processo.class).atualizar(this.processo);
		}
		this.processo = new Processo();
		return CONSULTAR_PROCESSO;
	}
	
	public List<Processo> getProcessos(){
		return new DAO<Processo>(Processo.class).listar();
	}
	
   public String consultProcesso(){
        return CONSULTAR_PROCESSO;
    }
   
   public String home(){
       return INDEX;
   }
}
