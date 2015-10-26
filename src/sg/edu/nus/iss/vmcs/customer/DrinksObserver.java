/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vmcs.customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author k
 */
public class DrinksObserver extends Observer {
    
    public DrinksObserver(DispenseController subject){
    this.dispenseController = subject;
    this.dispenseController.attach(this);
    }
    
    @Override
    public void update(ArrayList<String> names) {
        Set <String> list=new HashSet<String>();
        
        for (String name:names)
        {
            list.add(name);
        }
        
            System.out.println("Mail sent to maintainer as "+list+" items are running low");
        
        }
  } 
        
        
    
        


