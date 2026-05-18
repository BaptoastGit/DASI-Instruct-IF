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
import metier.modele.Matiere;
import metier.modele.Theme;

/**
 *
 * @author bgallissia
 */
public class MatiereSerialisation extends Serialisation {

    @Override
    public void appliquer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Matiere> listeMatiere = (List<Matiere>) request.getAttribute("listeMatiere");
        
        JsonObjectBuilder jsonContainer = Json.createObjectBuilder();

        JsonArrayBuilder jsonListeMatiere = Json.createArrayBuilder();
        JsonArrayBuilder jsonListeThemes;

        for (Matiere matiere : listeMatiere) {

            JsonObjectBuilder jsonMatiere = Json.createObjectBuilder();
            jsonMatiere.add("nom", matiere.getNom());
            
            jsonListeThemes = Json.createArrayBuilder();
            for (Theme theme : matiere.getThemes()) {
                JsonObjectBuilder jsonTheme = Json.createObjectBuilder();
                jsonTheme.add("nom", theme.getNom());
                jsonListeThemes.add(jsonTheme);
            }
            jsonMatiere.add("listeThemes", jsonListeThemes);
            
            jsonListeMatiere.add(jsonMatiere);
        }

        jsonContainer.add("listeMatiere", jsonListeMatiere);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.print(jsonContainer.build().toString());

        out.close();
    }

}
