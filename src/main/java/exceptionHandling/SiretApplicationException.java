package exceptionHandling;

/**
 * Class that inherits from the Exception class to handle all types of exceptions in our application
 */
public class SiretApplicationException extends Exception{
  public SiretApplicationException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }
}
