package interfaces;

import java.io.IOException;

public interface CsvPrintable  {
    void printToFile(double start, double step, int numberOfValues, String file) throws IOException;
}
