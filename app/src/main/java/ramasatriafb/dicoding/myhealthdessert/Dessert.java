package ramasatriafb.dicoding.myhealthdessert;

import android.os.Parcel;
import android.os.Parcelable;

public class Dessert {
    private String name;
    private String remarks;
    private String photo;

    private String ingrediant;
    private String procedures;

    public String getIngrediant() {
        return ingrediant;
    }

    public void setIngrediant(String ingrediant) {
        this.ingrediant = ingrediant;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


}
