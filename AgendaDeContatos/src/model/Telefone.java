package model;

public class Telefone {
	
	private Long id;
	private Long tipoId;
	private String numero;
	private Long contatoId;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTipoId() {
		return tipoId;
	}
	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Long getContatoId() {
		return contatoId;
	}
		
	public void setContatoId(Long contatoId) {
		this.contatoId = contatoId;
	}
	
	@Override
	public String toString() {
		return "Telefone [id=" + id + ", tipoId=" + tipoId + ", numero=" + numero + ", contatoId=" + contatoId + "]";
	}
	
}
