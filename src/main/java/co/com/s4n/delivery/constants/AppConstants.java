package co.com.s4n.delivery.constants;

import java.nio.file.Paths;

public final class AppConstants {

    public static final String NOT_AVAILABLE_DRONES = "There is not available drones";
    public static final String CAPACITY_EXCEEDED = "Load capacity exceeded";
    public static final String INVALID_INPUT_FOLDER = "Invalid input folder";
    public static final String BASE_PATH = Paths.get("").toAbsolutePath().toString();
    public static final String OUTPUT_FOLDER_PREFIX = "out";
    public static final String SEPARATOR = "/";
    public static final String FILE_EXTENTION = ".txt";
    public static final String INVALID_OUTPUT_FILE = "Invalid output file";
    public static final String INVALID_INPUT_FILE = "Invalid input file";
    public static final String INVALID_ARGUMENT= "Invalid Argument";
    public static final String FILE_HEADER = "== Reporte de entregas ==";

    private  AppConstants() {
    }


}

