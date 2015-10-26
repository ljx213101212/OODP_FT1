/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vmcs.customer;

import java.util.ArrayList;




/**
 *
 * @author k
 */
public abstract class Observer {
    
         protected DispenseController dispenseController;
         public abstract void update(ArrayList<String> names);
    
}
