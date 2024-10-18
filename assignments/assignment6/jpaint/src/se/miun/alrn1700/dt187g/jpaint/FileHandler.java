package se.miun.alrn1700.dt187g.jpaint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler {
    private static final Path baseFolder = Paths.get("drawings").toAbsolutePath();

    public static void save(Drawing drawing, String fileName) {
        try
        {
            if(!inputIsValid(drawing, fileName))
            {
                System.err.println("Invalid input");
                return;
            }

            if (!fileName.endsWith(".shape")) {
                fileName += ".shape";
            }

            var file = baseFolder.resolve(fileName);
            Files.createDirectories(file.getParent());
            if (Files.exists(file)) {
                System.err.println("File already exists: " + file);
                return;
            }

            Files.createFile(file);
            var content = formatShapeFileContent(drawing);
            Files.writeString(file, content, StandardOpenOption.WRITE);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    private static boolean inputIsValid(Drawing drawing, String fileName) {
        if(drawing == null) {
            return false;
        }

        if(fileName == null || fileName.isBlank()) {
            return false;
        }

        return true;
    }

    private static String formatShapeFileContent(Drawing drawing) {
        StringBuilder content = new StringBuilder();
        content.append(isNullOrBlank(drawing.getName()) ? "[not specified]" : drawing.getName()).append("\n");
        content.append(isNullOrBlank(drawing.getAuthor()) ? "[not specified]" : drawing.getAuthor()).append("\n");

        for (var shape : drawing.getShapes()) {
            content.append(shape.getClass().getSimpleName()).append(", ");
            
            var points = shape.getPoints();
            for (var point : points) {
                content.append((int) point.getX()).append(", ")
                    .append((int) point.getY()).append(", ");
            }

            content.append(shape.getColor()).append("\n");
        }

        return content.toString();
    }

    private static boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }
}