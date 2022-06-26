package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvRecurse;

/**
 * Base class to help with the unmarshalling of the json response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
  @CsvRecurse
  private Etablissement etablissement;

  public Etablissement getEtablissement() {
    return etablissement;
  }

  public void setEtablissement(Etablissement etablissement) {
    this.etablissement = etablissement;
  }

  @Override public String toString() {
    return "Company{" + "etablissement=" + etablissement + '}';
  }
}
