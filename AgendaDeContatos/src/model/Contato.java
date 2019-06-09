package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contato {
	
	private Long id;
	private Long usuarioId;
	private String nome;
	private String endereco;
	private String foto;
	private List<Telefone> telefones;
	private List<Email> emails;
	private List<RedeSocial> redesSociais;
	private LocalDate dataNascimento;
	private LocalDateTime dataCadastro;
	private String telefone;
	private String redeSocial;
	private String email;
	
	public Contato() {
		telefones = new ArrayList<Telefone>();
		emails = new ArrayList<Email>();
		redesSociais = new ArrayList<RedeSocial>();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}	
	/*
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(Telefone telefone) {
		this.telefones.add(telefone);
	}
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(Email email) {
		this.emails.add(email);
	}
	public List<RedeSocial> getRedesSociais() {
		return redesSociais;
	}
	public void setRedesSociais(RedeSocial redeSociai) {
		this.redesSociais.add(redeSociai);
	}
	*/
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getRedeSocial() {
		return redeSocial;
	}
	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Contato [id=" + id + ", usuarioId=" + usuarioId + ", nome=" + nome + ", endereco=" + endereco
				+ ", foto=" + foto + ", dataNascimento=" + dataNascimento + ", dataCadastro=" + dataCadastro
				+ ", telefone=" + telefone + ", redeSocial=" + redeSocial + ", email=" + email + "]";
	}

	
	
}
