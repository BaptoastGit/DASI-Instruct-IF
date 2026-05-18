/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.modele;

import jakarta.servlet.http.HttpServletRequest;
import web.test.ServiceTest;

/**
 *
 * @author tmoulard
 */
public class ConsulterListeDemandesAction extends Action {
    @Override
    public void execute(HttpServletRequest request) {
        request.setAttribute("listeDemandes", ServiceTest.listerDemandes());
        System.out.println(ServiceTest.listerDemandes());
    }

}
