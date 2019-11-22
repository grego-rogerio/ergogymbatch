package com.consultoria.ergogymbatch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Empresa implements Serializable {

	private static final long serialVersionUID = 121312319L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "RAZAO_SOCIAL")
	private String razaoSocial;
	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;
	private String cnpj;
	@Column(name = "INSCRICAO_ESTADUAL")
	private String inscricaoEstadual;
	@Column(name = "IND_IE_ISENTO", nullable = false)
	private Boolean indIEIsento = true;
	private String telefone;
	private String celular;
	private String cep;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String referencia;
	private String email;
	private String observacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public Boolean getIndIEIsento() {
		return indIEIsento;
	}
	public void setIndIEIsento(Boolean indIEIsento) {
		this.indIEIsento = indIEIsento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return this.getNomeFantasia();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(obj instanceof Empresa) {
			if(((Empresa)obj).getNomeFantasia().equals(this.getNomeFantasia())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.getId()*58;
	}
}
