package se.miun.alrn1700.dt187g.jpaint;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import se.miun.alrn1700.dt187g.jpaint.geometry.Circle;
import se.miun.alrn1700.dt187g.jpaint.geometry.Rectangle;
import se.miun.alrn1700.dt187g.jpaint.geometry.Shape;

public class FileHandler {
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

            var file = Paths.get(fileName);

            Files.createFile(file);
            var content = formatShapeFileContent(drawing);
            Files.writeString(file, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static Drawing load(String fileName) throws FileNotFoundException {
        try {
            var file = Paths.get(fileName);
            if(!Files.exists(file) || !Files.isRegularFile(file))
            {
                throw new FileNotFoundException();
            }

            var lines = Files.readAllLines(file);

            var name = lines.size() > 0 ? lines.get(0) : "[not specified]";
            var author = lines.size() > 1 ? lines.get(1) : "[not specified]";
            var drawing = new Drawing(name, author);

            for (int i = 2; i < lines.size(); i++) {
                var line = lines.get(i);
                var shape = parseShapeFileContent(line);
                if (shape != null) {
                    drawing.addShape(shape);
                }
            }

            return drawing;
        }
        catch (FileNotFoundException e) {
            throw e;
        } 
        catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
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
    
    private static boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
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


    private static Shape parseShapeFileContent(String line) {
        String[] parts = line.split(", ");
        if (parts.length < 5) {
            return null;
        }

        String shapeType = parts[0];
        int x1 = Integer.parseInt(parts[1]);
        int y1 = Integer.parseInt(parts[2]);
        int x2 = Integer.parseInt(parts[3]);
        int y2 = Integer.parseInt(parts[4]);
        String color = parts[5];

        switch (shapeType.toLowerCase()) {
            case "rectangle":
                return new Rectangle(x1, y1, x2, y2, color);
            case "circle":
                return new Circle(x1, y1, x2, y2, color);
            default:
                System.err.println("Unknown shape type: " + shapeType);
                return null;
        }
    }
}