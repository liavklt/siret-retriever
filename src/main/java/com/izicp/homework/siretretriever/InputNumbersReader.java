package com.izicp.homework.siretretriever;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

/**
 * Class for reading the input text
 */
@Component
public class InputNumbersReader {

  private final Logger logger = Logger.getLogger(InputNumbersReader.class.getName());


  /**
   * Method to retrieve the siret numbers from input.txt file. There is a backup list in case the file is not found
   *
   * @return
   */
  protected List<String> getSiretNumbersFromInputFile() {
    List<String> result;
    try (Stream<String> lines = Files.lines(Paths.get("./resources/input.txt"))) {
      result = lines.collect(Collectors.toList());
    } catch (IOException e) {
      logger.log(Level.SEVERE,
          "Could not retrieve file with input siret numbers, will use default backup instead");
      result = Arrays.asList("31302979500017", "41339442000033", "41339442000090", "41339442000116",
          "41776304200013", "43438147100011", "45251723800013", "52170053400014", "75254783600011",
          "47962817400042", "97080195700014");
      e.printStackTrace();
    }
    return result;
  }
}
