package br.inatel.cdg;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaProfessor {

    ProfessorService professorService;

    public BuscaProfessor(ProfessorService service){
        this.professorService = service;
    }

    public Professor buscaProfessor(int id){
        // id = 1 -> buscando um professor de ID 1
        //ProfessorJson é uma string que retornou do serviço
        String professorJson = professorService.busca(id);

        //jsonObject é um objeto JSON feito a partir da string de retonro
        JsonObject jsonObject = JsonParser.parseString(professorJson).getAsJsonObject();

        return new Professor(jsonObject.get("id").getAsInt(),
                jsonObject.get("nome").getAsString(),
                jsonObject.get("horarioDeAtendimento").getAsString(),
                jsonObject.get("periodo").getAsString(),
                jsonObject.get("sala").getAsString(),
                jsonObject.getAsJsonArray("predio"));
    }

    public boolean verificaArrayListExistente(int id){
        boolean professorExistente = professorService.professorExistente(id);

        if (professorExistente){
            return true;
        }else{
            return false;
        }
    }
}
