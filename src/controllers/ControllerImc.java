/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelImc;
import views.ViewImc;
/**
 *llama las variables definidas en model
 * @author Edgar
 */
public class ControllerImc implements ActionListener {
    ModelImc modelImc;
    ViewImc viewImc;
    
    public ControllerImc(ViewImc viewImc, ModelImc modelImc){
        this.viewImc = viewImc;
        this.modelImc = modelImc;
        viewImc.jb_calcular.addActionListener(this);
        initComponents();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewImc.jb_calcular){
            jb_calcular();
    }   
}
    /**
     * se llama a este metodo para el calculo del imc
     */
    public void jb_calcular(){
        float peso= 0.0f;
        float altura= 0.0f;
        float imc= 0.0f;
        
        modelImc.setPeso(viewImc.jtf_peso.getText());
        modelImc.setAltura(viewImc.jtf_altura.getText());
        modelImc.setImc(viewImc.jtf_imc.getText());
        
        peso = Float.parseFloat(viewImc.jtf_peso.getText());
        altura = Float.parseFloat(viewImc.jtf_altura.getText());
         
        imc = peso/(altura*altura);
        if ((peso < 35) || (peso >200) || (altura<1.1) || (altura> 2)){
            JOptionPane.showMessageDialog(null, "Error Al ingresar Datos" );
        }
        else{
            if (imc<=16){
                viewImc.jl_message.setText("Infrapeso: Delgadez Severa");
                }
            else if ((imc>16) && (imc<=16.99)) {
                viewImc.jl_message.setText("Infrapeso: Delgadez Moderada");
            }
            else if ((imc>16.99) && (imc<=18.49)) {
                viewImc.jl_message.setText("Infrapeso: Delgadez Aceptable");
            }
            else if ((imc>18.49) && (imc<=24.99)) {
                viewImc.jl_message.setText("Peso Normal");
            }
            else if ((imc>24.99) && (imc<=29.99)) {
                viewImc.jl_message.setText("Sobrepeso");
            }
            else if ((imc>29.99) && (imc<=34.99)) {
                viewImc.jl_message.setText("Obesidad Tipo 1");
            }
            else if ((imc>34.99) && (imc<=40)) {
                viewImc.jl_message.setText("Obesidad Tipo 2");
            }
            else  if(imc>40) {
                viewImc.jl_message.setText("Obesidad Tipo 3");
            }
        viewImc.jtf_imc.setText(String.valueOf(imc));
    }
    }
    public final void initComponents(){
        viewImc.setVisible(true);
        viewImc.jtf_imc.setText(modelImc.getImc());
    }
}
