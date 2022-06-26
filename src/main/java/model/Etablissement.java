package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvRecurse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Etablissement {
    @CsvBindByName
    private String id;
    @CsvBindByName
    private String nic;
    @CsvBindByName
    @JsonProperty("geo_adresse")
    private String fullAddress;
    @CsvBindByName
    @JsonProperty("date_creation")
    private String creationDate;
    @CsvRecurse
    @JsonProperty("unite_legale")
    private UniteLegale uniteLegale;

    @Override public String toString() {
        return "Etablissement{" + "id='" + id + '\'' + ", nic='" + nic + '\'' + ", fullAddress='" + fullAddress + '\''
            + ", creationDate='" + creationDate + '\'' + ", uniteLegale=" + uniteLegale + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public UniteLegale getUniteLegale() {
        return uniteLegale;
    }

    public void setUniteLegale(UniteLegale uniteLegale) {
        this.uniteLegale = uniteLegale;
    }
}
