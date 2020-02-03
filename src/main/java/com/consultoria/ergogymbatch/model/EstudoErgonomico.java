package com.consultoria.ergogymbatch.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ESTUDO_ERGONOMICO")
public class EstudoErgonomico implements Serializable {

	private static final long serialVersionUID = 121312320L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String funcionario;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_EMPRESA", nullable = false)
	private Empresa empresa;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_SETOR", nullable = false)
	private Setor setor;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_FUNCAO", nullable = false)
	private Funcao funcao;
	@Column(name = "IND_FAIXA_SALARIAL")
	private short indFaixaSalarial;
	@Column(name = "IND_GENERO")
	private short indGenero;
	@Column(name = "IND_TEMPO_TRABALHO")
	private short indTempoTrabalho;
	@Column(name = "IND_HORARIO")
	private short indHorario;
	@Column(name = "INICIO_JORNADA")
	@Temporal(value = TemporalType.TIME)
	@JsonFormat(pattern = "HH:MM")
	private Date inicioJornada;
	@Column(name = "FIM_JORNADA")
	@Temporal(value = TemporalType.TIME)
	@JsonFormat(pattern = "HH:MM")
	private Date fimJornada;
	private int peso;
	private int altura;
	@Column(name = "IND_AUSENCIA")
	private short indAusencia;
	@Column(name = "DIAS_AUSENCIA")
	private int diasAusencia;
	private String motivo;
	@Column(name = "IND_TIPO_DOR")
	private short indTipoDor;
	@Column(name = "IND_METAS")
	private short indMetas;
	@Column(name = "IND_TEMPO_METAS")
	private short indTempoMetas;
	@Column(name = "IND_AVALIACAO_FUNCAO")
	private short indAvaliacaoFuncao;
	@Column(name = "IND_AVALIACAO_AMBIENTE")
	private short indAvaliacaoAmbiente;
	@Column(name = "IND_AVALIACAO_CHEFE")
	private short indAvaliacaoChefe;
	@Column(name = "IND_AVALIACAO_COLEGAS")
	private short indAvaliacaoColegas;
	@Column(name = "IND_HORA_EXTRA")
	private short indHoraExtra;
	@Column(name = "IND_SATISFACAO")
	private short indSatisfacao;
	@Column(name = "IND_DOR")
	private short indDor;
	@Column(name = "IND_LOCAL_DOR")
	private short indLocalDor;
	@Column(name = "IND_QUEIXA_DOR")
	private short indQueixaDor;
	@Column(name = "DESCRICAO_QUEIXA")
	private String descricaoQueixa;
	private String sugestao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public short getIndFaixaSalarial() {
		return indFaixaSalarial;
	}

	public void setIndFaixaSalarial(short indFaixaSalarial) {
		this.indFaixaSalarial = indFaixaSalarial;
	}

	public short getIndGenero() {
		return indGenero;
	}

	public void setIndGenero(short indGenero) {
		this.indGenero = indGenero;
	}

	public short getIndTempoTrabalho() {
		return indTempoTrabalho;
	}

	public void setIndTempoTrabalho(short indTempoTrabalho) {
		this.indTempoTrabalho = indTempoTrabalho;
	}

	public short getIndHorario() {
		return indHorario;
	}

	public void setIndHorario(short indHorario) {
		this.indHorario = indHorario;
	}

	public Date getInicioJornada() {
		return inicioJornada;
	}

	public void setInicioJornada(Date inicioJornada) {
		this.inicioJornada = inicioJornada;
	}

	public Date getFimJornada() {
		return fimJornada;
	}

	public void setFimJornada(Date fimJornada) {
		this.fimJornada = fimJornada;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public short getIndAusencia() {
		return indAusencia;
	}

	public void setIndAusencia(short indAusencia) {
		this.indAusencia = indAusencia;
	}

	public int getDiasAusencia() {
		return diasAusencia;
	}

	public void setDiasAusencia(int diasAusencia) {
		this.diasAusencia = diasAusencia;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public short getIndTipoDor() {
		return indTipoDor;
	}

	public void setIndTipoDor(short indTipoDor) {
		this.indTipoDor = indTipoDor;
	}

	public short getIndMetas() {
		return indMetas;
	}

	public void setIndMetas(short indMetas) {
		this.indMetas = indMetas;
	}

	public short getIndTempoMetas() {
		return indTempoMetas;
	}

	public void setIndTempoMetas(short indTempoMetas) {
		this.indTempoMetas = indTempoMetas;
	}

	public short getIndAvaliacaoFuncao() {
		return indAvaliacaoFuncao;
	}

	public void setIndAvaliacaoFuncao(short indAvaliacaoFuncao) {
		this.indAvaliacaoFuncao = indAvaliacaoFuncao;
	}

	public short getIndAvaliacaoAmbiente() {
		return indAvaliacaoAmbiente;
	}

	public void setIndAvaliacaoAmbiente(short indAvaliacaoAmbiente) {
		this.indAvaliacaoAmbiente = indAvaliacaoAmbiente;
	}

	public short getIndAvaliacaoChefe() {
		return indAvaliacaoChefe;
	}

	public void setIndAvaliacaoChefe(short indAvaliacaoChefe) {
		this.indAvaliacaoChefe = indAvaliacaoChefe;
	}

	public short getIndAvaliacaoColegas() {
		return indAvaliacaoColegas;
	}

	public void setIndAvaliacaoColegas(short indAvaliacaoColegas) {
		this.indAvaliacaoColegas = indAvaliacaoColegas;
	}

	public short getIndHoraExtra() {
		return indHoraExtra;
	}

	public void setIndHoraExtra(short indHoraExtra) {
		this.indHoraExtra = indHoraExtra;
	}

	public short getIndSatisfacao() {
		return indSatisfacao;
	}

	public void setIndSatisfacao(short indSatisfacao) {
		this.indSatisfacao = indSatisfacao;
	}

	public short getIndDor() {
		return indDor;
	}

	public void setIndDor(short indDor) {
		this.indDor = indDor;
	}

	public short getIndLocalDor() {
		return indLocalDor;
	}

	public void setIndLocalDor(short indLocalDor) {
		this.indLocalDor = indLocalDor;
	}

	public short getIndQueixaDor() {
		return indQueixaDor;
	}

	public void setIndQueixaDor(short indQueixaDor) {
		this.indQueixaDor = indQueixaDor;
	}

	public String getDescricaoQueixa() {
		return descricaoQueixa;
	}

	public void setDescricaoQueixa(String descricaoQueixa) {
		this.descricaoQueixa = descricaoQueixa;
	}

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	@Override
	public String toString() {
		return this.getFuncionario();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj instanceof Funcionario) {
			if (((Funcionario) obj).getNome().equals(this.getFuncionario())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getId() * 158;
	}

}
