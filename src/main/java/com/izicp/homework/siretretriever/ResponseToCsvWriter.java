package com.izicp.homework.siretretriever;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import exceptionHandling.SiretApplicationException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import model.Company;

/**
 * Class that handles the writing to the local data storage system (csv in our case) based on the company information we have recovered
 */
public class ResponseToCsvWriter {

  public static void writeCompanies(List<Company> companies) throws SiretApplicationException {

    try {
      Writer writer = new FileWriter("Companies.csv");

      StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
      beanToCsv.write(companies);
      writer.close();
    } catch (IOException ioException) {
      throw new SiretApplicationException("Error while writing to file", ioException);
    } catch (CsvRequiredFieldEmptyException csvRequiredFieldEmptyException) {
      throw new SiretApplicationException("There is a field missing needed for the csv transform",
          csvRequiredFieldEmptyException);
    } catch (CsvDataTypeMismatchException csvDataTypeMismatchException) {
      throw new SiretApplicationException("There is mismatch in the csv data types",
          csvDataTypeMismatchException);
    }
  }
}
