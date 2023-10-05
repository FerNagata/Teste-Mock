package br.inatel.cdg.test;

import br.inatel.cdg.BuscaProfessor;
import br.inatel.cdg.Professor;
import br.inatel.cdg.ProfessorService;
import com.google.gson.JsonArray;
import org.junit.Before;
import org.junit.Test;
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
        assertEquals("Sexta-feira", chris.getHorarioAtendimento());
        assertEquals("Noturno", chris.getPeriodo());
        assertEquals("16", chris.getSala());
    }

    @Test
    public void testePredioDaSala(){
        //Fiz a busca
        Professor chris = buscaProfessor.buscaProfessor(1);

        String[] predioEsperado = {"4"};

        assertEquals("16", chris.getSala());
        assertEquals(predioEsperado, chris.getPredio());



    }
}
