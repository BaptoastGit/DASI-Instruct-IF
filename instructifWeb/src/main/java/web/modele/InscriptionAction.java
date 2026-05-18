/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import metier.modele.Eleve;
import java.time.LocalDate;
import metier.service.ServiceCompte;

/**
 *
 * @author bgallissia
 */
public class InscriptionAction extends Action {

    @Override
    public void execute(HttpServletRequest request) {
        if (ACTION_LOG_ACTIVE) {
            System.out.println("execute - InscriptionAction");
            
        }
        Boolean succesInscription = false;
        try {
            String nom = request.getParameter("nom");
            System.out.println(nom);
            String prenom = request.getParameter("prenom");
            String dateNaissanceString = request.getParameter("dateNaissance");
            String niveauScolaireString = request.getParameter("niveauScolaire");
            System.out.println(niveauScolaireString);
            String mail = request.getParameter("mail");
            String mdp = request.getParameter("mdp");
            String codeUAI = request.getParameter("uai");
            
            int niveauScolaire = Integer.parseInt(niveauScolaireString);
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-);
            LocalDate dateNaissance = LocalDate.parse(dateNaissanceString);
            
            Eleve eleve = new Eleve(nom, prenom, niveauScolaire, dateNaissance, mail, mdp);
            
            succesInscription = ServiceCompte.inscrireEleve(eleve, codeUAI);
            if (ACTION_LOG_ACTIVE) {
                System.out.println("succesInscription = " + succesInscription);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            request.setAttribute("succes", succesInscription);
        }
        
    }

}
