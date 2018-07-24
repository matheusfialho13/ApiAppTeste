package com.example.matheus.instituicoes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import br.com.guerethes.offdroid.annotation.estrategy.OnlyOnLine;
import br.com.guerethes.offdroid.annotation.server.Headers;
import br.com.guerethes.offdroid.annotation.server.Path;
import br.com.guerethes.offdroid.persist.interfaces.PersistDB;

@OnlyOnLine
@Path("curso/v0.1/cursos")
@Headers("Authorization, x-api-key")
public class Curso implements PersistDB, Serializable {

    @JsonProperty("id-curso")
    private Object id;

    private String curso;

    @JsonProperty("id-coordenador")
    private Integer idCoordenador;

    @JsonProperty("id-modalidade-educacao")
    private Integer idModalidade;

    @JsonProperty("id-situacao-curso")
    private Integer idSituacaoCurso;

    @JsonProperty("id-unidade")
    private Integer idUnidade;

    private String municipio;

    private String nivel;

    @JsonProperty("tipo-curso")
    private String tipoCurso;

    private String unidade;


    @Override
    public Object getId() {
        return this.id;
    }

    @Override
    public void setId(Object id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getIdCoordenador() {
        return idCoordenador;
    }

    public void setIdCoordenador(Integer idCoordenador) {
        this.idCoordenador = idCoordenador;
    }

    public Integer getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(Integer idModalidade) {
        this.idModalidade = idModalidade;
    }

    public Integer getIdSituacaoCurso() {
        return idSituacaoCurso;
    }

    public void setIdSituacaoCurso(Integer idSituacaoCurso) {
        this.idSituacaoCurso = idSituacaoCurso;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return this.curso;
    }
}
