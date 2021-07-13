package com.company;

import java.util.Observable;

public class Ticket extends Observable {

    private String queryStr;
    private boolean instantaneo;
    private String cliente;
    private boolean atendido;

    public Ticket(String queryStr, boolean instantaneo, String cliente) {
        this.queryStr = queryStr;
        this.instantaneo = instantaneo;
        this.cliente = cliente;
        this.atendido = false;
    }

    public String getCliente() {
        return cliente;
    }

    public Ticket setCliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public String getQueryStr() {
        return queryStr;
    }

    public Ticket setQueryStr(String queryStr) {
        this.queryStr = queryStr;
        return this;
    }

    public boolean isInstantaneo() {
        return instantaneo;
    }

    public Ticket setInstantaneo(boolean instantaneo) {
        this.instantaneo = instantaneo;
        return this;
    }

    public void enviarConteudo(){
        atendido = true;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        return "Ticket{\nCliente: " + cliente +
                "\nQuery String: " + queryStr +
                "\nInstantaneo: " + instantaneo + "}";
    }
}
