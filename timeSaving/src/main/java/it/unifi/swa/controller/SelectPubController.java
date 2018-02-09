/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unifi.swa.controller;

import it.unifi.swa.dao.PubDAO;
import it.unifi.swa.domain.Pub;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Alessandro
 */

@Named
@SessionScoped
public class SelectPubController implements Serializable {


    @Inject
    private PubDAO pubDao;
    
    private Pub selectedPub;
    
    public void select(){
        
    }
    
    public String showInfo(){
        
        return "pubInfo?&faces-redirect=true";
        
    }
    
    /**
     * @return the selectedPub
     */
    public Pub getSelectedPub() {
        return selectedPub;
    }

    /**
     * @param selectedPub the selectedPub to set
     */
    public void setSelectedPub(Pub selectedPub) {
        this.selectedPub = selectedPub;
    }
    
}
