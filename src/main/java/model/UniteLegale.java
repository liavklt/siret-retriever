package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UniteLegale {

  @JsonProperty("denomination")
  @CsvBindByName
  private String fullName;
  @CsvBindByName
  @JsonProperty("numero_tva_intra")
  private String tvaNumber;

  @Override public String toString() {
    return "UniteLegale{" + "fullName='" + fullName + '\'' + ", tvaNumber='" + tvaNumber + '\'' + '}';
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getTvaNumber() {
    return tvaNumber;
  }

  public void setTvaNumber(String tvaNumber) {
    this.tvaNumber = tvaNumber;
  }
}
