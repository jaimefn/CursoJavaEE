package model;

public class RedeSocial {
	
	private Long id;
	private String rede;
	private Long contatoId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRede() {
		return rede;
	}
	public void setRede(String rede) {
		this.rede = rede;
	}

	public Long getContatoId() {
		return contatoId;
	}
		
	public void setContatoId(Long contatoId) {
		this.contatoId = contatoId;
	}
	
	@Override
	public String toString() {
		return "RedeSocial [id=" + id + ", rede=" + rede + ", contatoId=" + contatoId + "]";
	}

}
