package com.company.tests;

import com.company.Atendente;
import com.company.Ticket;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AtendenteTest {

    @Test
    public void deveNotificarUmAtendente(){
        Ticket ticket = new Ticket("MG-3-server4-banco2", true, "Marco Antonio");
        Atendente atendente = new Atendente("server4-banco2;user-admin;password-1234");
        atendente.atender(ticket);
        ticket.enviarConteudo();
        assertEquals("Ticket atendido no server server4-banco2;user-admin;password-1234: Ticket{\n" +
                "Cliente: Marco Antonio\n" +
                "Query String: MG-3-server4-banco2\n" +
                "Instantaneo: true}", atendente.getUltimoTicketAtendido());
    }

    @Test
    public void deveNotificarAtendentes(){
        Ticket ticket = new Ticket("MG-3-server4-banco2", true, "Marco Antonio");
        Atendente atendente1 = new Atendente("server4-banco2;user-admin;password-1234");
        Atendente atendente2 = new Atendente("server3-banco1;user-user;password-3456");

        atendente1.atender(ticket);
        atendente2.atender(ticket);
        ticket.enviarConteudo();
        assertEquals("Ticket atendido no server server4-banco2;user-admin;password-1234: Ticket{\n" + "Cliente: Marco Antonio\n" + "Query String: MG-3-server4-banco2\n" +
                "Instantaneo: true}", atendente1.getUltimoTicketAtendido());
        assertEquals(null, atendente2.getUltimoTicketAtendido());;
    }

    @Test
    public void naoDeveNotificaratendente(){
        Ticket ticket = new Ticket("MG-3-server4-banco2", true, "Marco Antonio");
        Atendente atendente1 = new Atendente("server4-banco2;user-admin;password-1234");

        ticket.enviarConteudo();
        assertEquals(null, atendente1.getUltimoTicketAtendido());
    }

    @Test
    public void deveNotificarAtendente1(){
        Ticket ticket1 = new Ticket("MG-3-server4-banco2", true, "Marco Antonio");
        Ticket ticket2 = new Ticket("SP-7-server3-banco1", true, "Márcia Antonieta");
        Atendente atendente1 = new Atendente("server4-banco2;user-admin;password-1234");
        Atendente atendente2 = new Atendente("server3-banco1;user-user;password-3456");
        atendente1.atender(ticket1);
        atendente2.atender(ticket2);

        ticket1.enviarConteudo();
        assertEquals("Ticket atendido no server server4-banco2;user-admin;password-1234: Ticket{\n" + "Cliente: Marco Antonio\n" + "Query String: MG-3-server4-banco2\n" +
                "Instantaneo: true}", atendente1.getUltimoTicketAtendido());
        assertEquals(null, atendente2.getUltimoTicketAtendido());
    }
}
