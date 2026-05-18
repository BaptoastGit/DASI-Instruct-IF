/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.vue;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import web.test.DemandeTest;

/**
 *
 * @author tmoulard
 */
public class ListeDemandesSerialisation extends Serialisation {

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<DemandeTest> demandes = (List<DemandeTest>) request.getAttribute("listeDemandes");
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();

        JsonArrayBuilder jsonListeDemandes = Json.createArrayBuilder();

        for (DemandeTest demande : demandes) {

            JsonObjectBuilder jsonDemande = Json.createObjectBuilder();
            jsonDemande.add("id", demande.getId());
            jsonDemande.add("dateCreation", demande.getDateCreation().toString());
            jsonDemande.add("description", demande.getDescription());
            jsonListeDemandes.add(jsonDemande);
        }

        jsonContainer.add("demande", jsonListeDemandes);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.print(jsonContainer.build().toString());

        out.close();
    }
}
