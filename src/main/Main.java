/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.ViewImc;
import models.ModelImc;
import controllers.ControllerImc;
/**
 *se importan los componentes de otros package para que trabajen en conjunto
 * @author Edgar
 */
public class Main {
    private static ViewImc viewImc;
    private static ModelImc modelImc;
    private static ControllerImc controllerImc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        viewImc = new ViewImc();
        modelImc = new ModelImc();
        controllerImc = new ControllerImc(viewImc, modelImc);
    }
    
}
