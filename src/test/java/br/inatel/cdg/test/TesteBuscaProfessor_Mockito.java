package br.inatel.cdg.test;

import br.inatel.cdg.BuscaProfessor;
import br.inatel.cdg.Professor;
import br.inatel.cdg.ProfessorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TesteBuscaProfessor_Mockito {

    @Mock
    ProfessorService service;
    private BuscaProfessor buscaProfessor;

    @Before
    public void setup() {
        buscaProfessor = new BuscaProfessor(service);
    }

    @Test
    public void testeBuscaChris() {
        Mockito.when(service.busca(1)).thenReturn(ProfessorConst.CHRIS);

        Professor chris = buscaProfessor.buscaProfessor(1);
        //Faz assertion
        assertEquals("Chris Lima", chris.getNome());
        assertEquals("Sexta-feira", chris.getHorarioAtendimento());
        assertEquals("Noturno", chris.getPeriodo());
        assertEquals("16", chris.getSala());
        //assertEquals(4, chris.getPredios());
    }

}