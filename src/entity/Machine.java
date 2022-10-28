package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Machine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private String marque;
    private double prix;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAchat;

    public Machine() {
        super();
    }

    public Machine(String ref, String marque, double prix, Date dateAchat) {
        this.ref = ref;
        this.marque = marque;
        this.prix = prix;
        this.dateAchat = dateAchat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    @Override
    public String toString() {
        return this.ref;
    }

}
