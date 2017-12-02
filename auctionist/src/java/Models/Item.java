/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author fabri
 */
public class Item {
   
    private String id;
    private String description;
    private float initialAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(float initialAmount) {
        this.initialAmount = initialAmount;
    }
  
}
