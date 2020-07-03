package co.com.s4n.delivery.util;

import co.com.s4n.delivery.constants.AppConstants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.com.s4n.delivery.constants.AppConstants.BASE_PATH;
import static co.com.s4n.delivery.constants.AppConstants.INVALID_INPUT_FOLDER;

public final class FileUtil {


    private FileUtil() {
    }

    public static List<String> readDirectoryFiles(String folder){
        try (Stream<Path> paths = Files.walk(Paths.get(BASE_PATH+ AppConstants.SEPARATOR +folder))) {
            return paths
                    .filter(Files::isRegularFile)
                    .map(f -> f.toAbsolutePath().toString()).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(INVALID_INPUT_FOLDER);
        }
    }

    public static List<String> readFile(String folder) {

        try (Stream<String> lines = Files.lines(Paths.get(folder))) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(AppConstants.INVALID_INPUT_FILE);
        }

    }

    public static void writeFile(final String folder, String name, List<String> results) {
        String fileName = AppConstants.SEPARATOR + folder + AppConstants.SEPARATOR +name+ AppConstants.FILE_EXTENTION;
        try {
            File theDir = new File(BASE_PATH + AppConstants.SEPARATOR +folder);
            if (!theDir.exists()) theDir.mkdirs();
            Files.write(Paths.get(BASE_PATH +fileName), (AppConstants.FILE_HEADER +System.lineSeparator()).getBytes());
            Files.write(Paths.get(BASE_PATH +fileName), results, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(AppConstants.INVALID_OUTPUT_FILE);
        }
    }

}
