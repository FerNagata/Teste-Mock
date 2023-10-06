package br.inatel.cdg.test;

import br.inatel.cdg.ProfessorService;

import java.util.ArrayList;

public class MockProfessorService implements ProfessorService {


    @Override
    public String busca(int id) {
        if (id == 1){
            return ProfessorConst.CHRIS;
        }else if (id == 2){
            return ProfessorConst.RENZO;
        }else if(id == 3){
            return ProfessorConst.MARCELO;
        }else if(id == 4){
            return ProfessorConst.YNOGUTI;
        } else if(id == 5){
            return ProfessorConst.Aquino;
        }else if(id == -1){
            return ProfessorConst.INEXISTENTE;
        } else {
            return ProfessorConst.DEFEITO;
        }
    }

    @Override
    public boolean professorExistente(int id) {
        //Aceitando somente IDs 10 e 20. Pode-se melhorar a logica para aceitar também IDs positivos
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        for (int i=0; i < list.size(); i++){
            if (list.get(i).equals(id) || list.get(i).equals(id)){
                return true;
            }else{
                return false;
            }
        }

        return false;
    }
}
