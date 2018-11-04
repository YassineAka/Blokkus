/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g49382.blokus.controller;

import g49382.blokus.viewConsole.ViewConsole;


public class Controller {
    private ViewConsole view;
    
    public Controller(){
        this.view = new ViewConsole();
    }
    
    public void play(){
        this.view.start();
    }
}
