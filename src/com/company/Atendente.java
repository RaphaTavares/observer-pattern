package com.company;

import java.util.Observable;
import java.util.Observer;

public class Atendente implements Observer {

    private String connectionString;
    private String ultimoTicketAtendido;

    public Atendente(String con)
    {
        this.connectionString = con;
    }

    public String getUltimoTicketAtendido(){
        return this.ultimoTicketAtendido;
    }

    public void atender(Ticket ticket){
        if(ticket.countObservers() >= 1)
        {
            return;
        }
        else {
            ticket.addObserver(this);
        }
    }

    public void update(Observable ticket, Object arg1){
        this.ultimoTicketAtendido = "Ticket atendido no server " + this.connectionString + ": " + ticket.toString();
    }

}
