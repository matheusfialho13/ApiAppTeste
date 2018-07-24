package com.example.matheus.instituicoes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import br.com.guerethes.offdroid.annotation.estrategy.OnlyOnLine;
import br.com.guerethes.offdroid.annotation.server.Headers;
import br.com.guerethes.offdroid.annotation.server.Path;
import br.com.guerethes.offdroid.persist.interfaces.PersistDB;

//Informando que deve usar o repositório online
@OnlyOnLine
//Informando o endereço que deve ser usado para buscar as informações
@Path("internacionalizacao/v0.1/unidades")
@Headers("Authorization, x-api-key")
public class Unidade implements PersistDB, Serializable {

    @JsonProperty("id-unidade")
    private Object id;

    @JsonProperty("codigo-unidade")
    private Long codigoUnidade;

    @JsonProperty("data-criacao")
    private Long dataCriacao;

    @JsonProperty("id-ambiente-organizacional")
    private Long idAmbienteOrg;

    @JsonProperty("id-area-atuacao-unidade")
    private Long idAreaAtuacao;

    @JsonProperty("id-classificacao-unidade")
    private Long idClassificacao;

    @JsonProperty("id-municipio")
    private Long idMunicipio;

    @JsonProperty("id-nivel-organizacional")
    private Long idNivelOrg;

    @JsonProperty("id-tipo-unidade-organizacional")
    private Long idTipoUnidadeOrg;

    private String email;

    @JsonProperty("nome-unidade")
    private String nome;

    private String sigla;

    private String telefones;

    @JsonProperty("unidade-patrimonial")
    private Boolean unidadePatrimonial;

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = id;
    }

    public Long getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(Long codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public Long getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Long dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getIdAmbienteOrg() {
        return idAmbienteOrg;
    }

    public void setIdAmbienteOrg(Long idAmbienteOrg) {
        this.idAmbienteOrg = idAmbienteOrg;
    }

    public Long getIdAreaAtuacao() {
        return idAreaAtuacao;
    }

    public void setIdAreaAtuacao(Long idAreaAtuacao) {
        this.idAreaAtuacao = idAreaAtuacao;
    }

    public Long getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(Long idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Long getIdNivelOrg() {
        return idNivelOrg;
    }

    public void setIdNivelOrg(Long idNivelOrg) {
        this.idNivelOrg = idNivelOrg;
    }

    public Long getIdTipoUnidadeOrg() {
        return idTipoUnidadeOrg;
    }

    public void setIdTipoUnidadeOrg(Long idTipoUnidadeOrg) {
        this.idTipoUnidadeOrg = idTipoUnidadeOrg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public Boolean getUnidadePatrimonial() {
        return unidadePatrimonial;
    }

    public void setUnidadePatrimonial(Boolean unidadePatrimonial) {
        this.unidadePatrimonial = unidadePatrimonial;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}
