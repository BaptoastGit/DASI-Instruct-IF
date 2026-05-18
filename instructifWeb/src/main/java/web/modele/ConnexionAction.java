/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import metier.modele.Eleve;
import metier.modele.Intervenant;
import metier.service.ServiceCompte;

/**
 *
 * @author bgallissia
 */
public class ConnexionAction extends Action {

    @Override
    public void execute(HttpServletRequest request) {
        if (ACTION_LOG_ACTIVE) {
            System.out.println("execute - ConnexionAction");
        }
        Boolean succesConnexion = true;
        try {

            String mail = request.getParameter("mail");
            String mdp = request.getParameter("mdp");

            Eleve eleve = null;
            Intervenant intervenant = null;
            eleve = ServiceCompte.authentificationEleve(mail, mdp);
            if (eleve == null) {
                intervenant = ServiceCompte.authentificationIntervenant(mail, mdp);
                if (intervenant == null) {
                    succesConnexion = false;
                }
            }
            if (ACTION_LOG_ACTIVE) {
                System.out.println("succesConnexion = " + succesConnexion);
                System.out.println("Eleve = " + eleve);
                System.out.println("Intervenant = " + intervenant);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            request.setAttribute("succes", succesConnexion);
        }
    }
}
