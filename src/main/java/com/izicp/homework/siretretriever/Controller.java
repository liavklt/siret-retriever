package com.izicp.homework.siretretriever;

import exceptionHandling.SiretApplicationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.Company;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Simple controller that includes the mapping for recovering the company information based on the siret numbers we have as input
 */
@RestController
@EnableAutoConfiguration
public class Controller {

  private InputNumbersReader inputNumbersReader;

  @Autowired
  public Controller(InputNumbersReader inputNumbersReader) {
    this.inputNumbersReader = inputNumbersReader;
  }

  private final Logger logger = Logger.getLogger(this.getClass().getName());

  @RequestMapping(value = "/retrieve", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
  @ResponseBody
  public List<String> retrieveCompanyInformation() {
    List<Company> companies = new ArrayList<>();
    List<String> siretNumbers = inputNumbersReader.getSiretNumbersFromInputFile();
    try {
      for (String siret : siretNumbers) {
        Company company = getCompanyInformationForSiretNumber(siret);
        CollectionUtils.addIgnoreNull(companies, company);
      }
      ResponseToCsvWriter.writeCompanies(companies);
      return companies.stream().map(Company::toString).collect(Collectors.toList());
    } catch (SiretApplicationException e) {
      logger.log(Level.SEVERE, "Exception during the run of this get request: " + e.getMessage());
      e.printStackTrace();
      return null;
    }
  }

  private Company getCompanyInformationForSiretNumber(String siret)
      throws SiretApplicationException {
    Company company = null;
    try {
      String url = "https://entreprise.data.gouv.fr/api/sirene/v3/etablissements/" + siret;
      RestTemplate restTemplate = new RestTemplate();
      company = restTemplate.getForObject(url, Company.class);
    } catch (HttpClientErrorException e) {
      logger.log(Level.SEVERE, String.format("No results found for siret %s", siret));
    }
    return company;
  }
}
