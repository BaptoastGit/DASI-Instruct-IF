/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import metier.modele.Matiere;
import metier.service.ServiceSoutien;

/**
 *
 * @author bgallissia
 */
public class MatiereAction extends Action {
    @Override
    public void execute(HttpServletRequest request) {
        if (ACTION_LOG_ACTIVE) {
            System.out.println("execute - MatiereAction");
        }
        Boolean succes = true;
        List<Matiere> listeMatiere = null;
        try {

            listeMatiere = ServiceSoutien.getMatieres();
            if (listeMatiere == null) {
                succes = false;
            }
            if (ACTION_LOG_ACTIVE) {
                System.out.println("succes = " + succes);
                System.out.println("liste des matières = " + listeMatiere);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            request.setAttribute("succes", succes);
            request.setAttribute("listeMatiere", listeMatiere);
        }
    }
}
