package main.constructionCompany.estimates.materialEstimate;

import main.constructionCompany.estimates.ICost;
import main.constructionCompany.reserves.ISimilar;
import main.constructionCompany.reserves.material.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class MaterialEstimate implements ICost, ISimilar {
    private int code;
    private double quantity;
    private Material material;
    private static final Logger logger = LogManager.getLogger(MaterialEstimate.class);

    public MaterialEstimate() {
    }

    public MaterialEstimate(Material material, int code, double quantity) {
        this.material = material;
        if (code < 0) {
            logger.error("Unique number exception: it less then 0");
        } else {
            this.code = code;
        }
        this.quantity = quantity;
    }

    public void setCode(int code) {
        if (code < 0) {
            logger.error("Unique number exception: it less then 0");
        } else {
            this.code = code;
        }
    }

    public int getCode() {
        return code;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "\nMaterial Estimate [ Material => " + getMaterial()
                + " code => " + code
                + " nquantity => " + quantity + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        MaterialEstimate m = (MaterialEstimate) obj;
        return Objects.equals(material, m.material)
                && code == m.code
                && quantity == m.quantity;
    }

    /**
    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode(), getType().hashCode(), getCost(), code, quantity);
    }
     */
    @Override
    public int hashCode() {
        return Objects.hash(getMaterial().hashCode(), code, quantity);
    }
    @Override
    public double getPrice() {
        return material.getCost() * quantity;
    }

    @Override
    public boolean isSimilarType(Material material) {
        return Objects.equals(this.getMaterial().getType(), material.getType());
    }

    @Override
    public boolean isSimilarMaterial(Material material) {
        return Objects.equals(this.material.getType(), material.getType()) && Objects.equals(this.material.getName(), material.getName());
    }
}
