package br.inatel.cdg;

import com.google.gson.JsonArray;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Professor {

    private int id;
    private String nome;
    private String horarioAtendimento;
    private String periodo;
    private String sala;
    private ArrayList<String> predio;

    public Professor(int id, String nome, String horarioAtendimento, String periodo, String sala, ArrayList<String> predio){
        this.id = id;
        this.nome = nome;
        this.horarioAtendimento = horarioAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public ArrayList<String> getPredio() {
        return predio;
    }

    public void setPredio(ArrayList<String> predio) {
        this.predio = predio;
    }
}
