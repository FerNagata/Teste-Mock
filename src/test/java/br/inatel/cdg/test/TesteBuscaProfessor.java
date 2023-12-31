package br.inatel.cdg.test;

import br.inatel.cdg.BuscaProfessor;
import br.inatel.cdg.Professor;
import br.inatel.cdg.ProfessorService;
import com.google.gson.JsonArray;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TesteBuscaProfessor {

    ProfessorService service;
    BuscaProfessor buscaProfessor;

    @Before
    public void setup() {
        
        //Criando o contexo do meu teste com o Mock (serviço mock)
        service = new MockProfessorService();
        buscaProfessor = new BuscaProfessor(service);
    }

    @Test
    public void testeBuscaChris() {

        //Fiz a busca
        Professor chris = buscaProfessor.buscaProfessor(1);

        //Faz assertion
        assertEquals("Chris Lima", chris.getNome());
        assertEquals("Noturno", chris.getPeriodo());
        assertEquals("16", chris.getSala());
    }

    @Test
    public void testeBuscaRenzo() {

        //Fiz a busca
        Professor renzo = buscaProfessor.buscaProfessor(2);

        ArrayList<String> prediosEsperados = new ArrayList<>();
        prediosEsperados.add("3");

        //Faz assertion
        assertEquals("Renzo Mesquita", renzo.getNome());
        assertEquals("Terça-feira", renzo.getHorarioAtendimento());
        assertEquals("Noturno", renzo.getPeriodo());
        assertEquals("11", renzo.getSala());
        assertEquals(prediosEsperados.toArray(), renzo.getPredio().toArray());
    }

    @Test
    public void testeBuscaMarcelo() {

        //Fiz a busca
        Professor marcelo = buscaProfessor.buscaProfessor(3);

       assertNotNull(marcelo);
    }

    @Test
    public void testePredioDaSala(){
        //Fiz a busca
        Professor chris = buscaProfessor.buscaProfessor(1);

        ArrayList<String> prediosEsperados = new ArrayList<>();
        prediosEsperados.add("4");

        assertEquals("16", chris.getSala());
        assertEquals(prediosEsperados.toArray(), chris.getPredio().toArray());
    }

    @Test
    public void testeExistePredios(){
        //Fiz a busca
        Professor chris = buscaProfessor.buscaProfessor(1);

        assertEquals("16", chris.getSala());
        assertFalse(chris.getPredio().isEmpty());
    }

    @Test
    public void testeVerificaPeriodo(){
        //Fiz a busca
        Professor ynoguti = buscaProfessor.buscaProfessor(4);

        String esperado = "Integral";

        assertEquals(esperado, ynoguti.getPeriodo());
    }

    @Test
    public void testeNumeroDePrediosValido(){
        //Fiz a busca
        Professor ynoguti = buscaProfessor.buscaProfessor(4);

        int esperado = 1;

        assertEquals(esperado, ynoguti.getPredio().size());
    }

    @Test
    public void testeTipoDeVariavelErrada() {
        //Fiz a busca
        Professor renzo = buscaProfessor.buscaProfessor(2);

        //Faz assertion
        assertNotEquals(11, renzo.getSala());
    }

    @Test
    public void testeVerificandoLetraMaiuscula() {

        //Fiz a busca
        Professor ynoguti = buscaProfessor.buscaProfessor(4);

        //Faz assertion
        assertNotEquals("carlos ynoguti", ynoguti.getNome());
        assertNotEquals("segunda-feira", ynoguti.getHorarioAtendimento());
        assertNotEquals("integral", ynoguti.getPeriodo());
    }

    @Test
    public void testeVerificandoQuantidadeDeCaracteres() {

        //Fiz a busca
        Professor ynoguti = buscaProfessor.buscaProfessor(4);

        int nome = ynoguti.getNome().length();

        //Faz assertion
        assertEquals(14, nome);
    }

    //Espirito de Porco
    @Test(expected = NullPointerException.class)
    public void testeDefeito() {
        //Fiz a busca
        Professor defeituoso = buscaProfessor.buscaProfessor(-2);

        //Faz assertion
        assertEquals("Defeito", defeituoso.getNome());
    }

    //Espirito de Porco
    @Test
    public void testeVariavelSalaEscritaErrada() {
        //Fiz a busca
        Professor aquino = buscaProfessor.buscaProfessor(5);

        //Faz assertion
        assertNotEquals("11", aquino.getSala());
    }

    //Espirito de Porco
    @Test
    public void testeVariavelPredioEscritaErrada() {
        //Fiz a busca
        Professor aquino = buscaProfessor.buscaProfessor(5);

        //Faz assertion
        assertNotEquals("3", aquino.getSala());
    }

    //Espirito de Porco
    @Test
    public void testeInexistente() {
        //Fiz a busca
        Professor inexistente = buscaProfessor.buscaProfessor(-1);

        //Faz assertion
        assertEquals("Inexistente", inexistente.getNome());
    }

    //Espirito de Porco
    @Test
    public void testeMaisQueUmPredio(){
        //Fiz a busca
        Professor marcelo = buscaProfessor.buscaProfessor(3);

        int esperado = 1;

        assertNotEquals(marcelo.getPredio().size(), esperado);
    }

    //Espirito de Porco
    @Test
    public void testePredioInexistenteSalaExistente(){
        //Fiz a busca
        Professor ynoguti = buscaProfessor.buscaProfessor(4);

        assertEquals("5", ynoguti.getSala());
        assertFalse(ynoguti.getPredio().contains("5"));
    }

    //Espirito de Porco
    @Test
    public void testePredioExistenteSalaInexistenteNoPredio(){
        //Fiz a busca
        Professor chris = buscaProfessor.buscaProfessor(1);

        assertEquals("16", chris.getSala());
        assertTrue( chris.getPredio().contains("4"));
    }

    //Espirito de Porco
    @Test
    public void testePredioInexistenteDoProfessorInexistente(){
        //Fiz a busca
        Professor inexistente = buscaProfessor.buscaProfessor(-1);

        ArrayList<String> prediosEsperados = new ArrayList<>();
        prediosEsperados.add("Error");

        assertEquals("Inexistente", inexistente.getNome());
        assertEquals(prediosEsperados.toArray(), inexistente.getPredio().toArray());
    }

    //Espirito de Porco
    @Test
    public void testeHorarioDeAtendimentoInexistente(){
        //Fiz a busca
        Professor chris = buscaProfessor.buscaProfessor(1);

        String horario_de_atendimento_correto = "Sexta-feira";

        assertNotEquals(chris.getHorarioAtendimento(), horario_de_atendimento_correto);
    }

    //Espirito de Porco
    @Test
    public void testePeriodoDeAtendimentoEscritoEmOutroIdioma(){
        //Fiz a busca
        Professor marcelo = buscaProfessor.buscaProfessor(3);

        String periodo_de_atendimento_correto = "Noturno";

        assertNotEquals(marcelo.getPeriodo(), periodo_de_atendimento_correto);
    }
}
