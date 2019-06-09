package model;

public class Email {
	
	private Long id;
	private String email;
	private Long contatoId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getContatoId() {
		return contatoId;
	}
		
	public void setContatoId(Long contatoId) {
		this.contatoId = contatoId;
	}
	
	@Override
	public String toString() {
		return "Email [id=" + id + ", email=" + email + ", contatoId=" + contatoId + "]";
	}
	
}
