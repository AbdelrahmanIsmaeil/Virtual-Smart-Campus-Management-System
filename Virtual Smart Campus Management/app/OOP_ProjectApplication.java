package com.mycompany.OOP_Project.app;

import com.mycompany.OOP_Project.service.SystemManager;
import com.mycompany.OOP_Project.ui.UserInterface;

public class OOP_ProjectApplication {
    
    public static void main(String[] args) {
   
        SystemManager systemManager = SystemManager.getInstance();
       
        UserInterface ui = new UserInterface();
        ui.start();
    }
}
