package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_marca;
    private String desc_marca;

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getDesc_marca() {
        return desc_marca;
    }

    public void setDesc_marca(String desc_marca) {
        this.desc_marca = desc_marca;
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id_marca;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Marca other = (Marca) obj;
        if (this.id_marca != other.id_marca) {
            return false;
        }
        return true;
    }

}
