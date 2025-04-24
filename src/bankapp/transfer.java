/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transfer") 
public class transfer {
    
    
    @Column(name = "transfer_amount")
    private String transfer_amount;
    @Id
    @Column(name = "cards")
    private String cards;
    @Column(name = "purpose")
    private String purpose;

    
    
    public transfer() {
}
    
    public transfer(String transfer_amount, String cards, String purpose) {
      this.transfer_amount=transfer_amount;
      this.cards= cards;
      this.purpose=purpose;
    }

    public String getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(String transfer_amount) {
        this.transfer_amount = transfer_amount;
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    
      
}
