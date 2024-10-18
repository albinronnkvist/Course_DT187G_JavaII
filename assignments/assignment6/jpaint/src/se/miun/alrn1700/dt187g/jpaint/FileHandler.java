package se.miun.alrn1700.dt187g.jpaint;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import se.miun.alrn1700.dt187g.jpaint.geometry.Circle;
import se.miun.alrn1700.dt187g.jpaint.geometry.Rectangle;
import se.miun.alrn1700.dt187g.jpaint.geometry.Shape;

public class FileHandler {
    private static final String delimiter = ",";

    public static void save(Drawing drawing, String fileName) throws Exception {
        if(!inputIsValid(drawing, fileName))
        {
            System.err.println("Invalid input");
            return;
        }

        if (!fileName.endsWith(".shape")) {
            fileName += ".shape";
        }

        var file = Paths.get(fileName);
        var content = formatDrawingFile(drawing);
        Files.writeString(file, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING); 
    }

    public static Drawing load(String fileName) throws FileNotFoundException, Exception {
        var file = Paths.get(fileName);
        if(!Files.exists(file) || !Files.isRegularFile(file))
        {
            throw new FileNotFoundException("File '" + fileName + "' does not exist or is not a regular file: ");
        }

        var lines = Files.readAllLines(file);
        return parseDrawingFile(lines);
    }

    private static boolean inputIsValid(Drawing drawing, String fileName) {
        if(drawing == null) {
            return false;
        }

        if(isNullOrBlank(fileName)) {
            return false;
        }

        return true;
    }
    
    private static boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }

    private static String formatDrawingFile(Drawing drawing) {
        StringBuilder content = new StringBuilder();
        content.append(isNullOrBlank(drawing.getName()) ? "[not specified]" : drawing.getName()).append("\n");
        content.append(isNullOrBlank(drawing.getAuthor()) ? "[not specified]" : drawing.getAuthor()).append("\n");

        return content.append(drawing.getShapes().stream()
            .map(shape -> formatDrawingShape(shape))
            .collect(Collectors.joining("\n")))
            .toString();
    }

    private static String formatDrawingShape(Shape shape) {
        StringBuilder content = new StringBuilder();
    
        content.append(shape.getClass().getSimpleName()).append(delimiter);
    
        shape.getPoints().stream()
            .forEach(point -> content
                .append((int) point.getX())
                .append(delimiter)
                .append((int) point.getY())
                .append(delimiter));
    
        content.append(shape.getColor());
    
        return content.toString();
    }

    private static Drawing parseDrawingFile(List<String> lines) throws Exception {
        var name = lines.size() > 0 ? lines.get(0) : "[not specified]";
        var author = lines.size() > 1 ? lines.get(1) : "[not specified]";

        var drawing = new Drawing(name, author);

        lines.stream()
            .skip(2)
            .map(shape -> parseDrawingShape(shape))
            .filter(shape -> shape != null)
            .forEach(drawing::addShape);

        return drawing;
    }

    private static Shape parseDrawingShape(String line) {
        var parts = line.split(delimiter);
        if (parts.length < 6) {
            System.err.println("Invalid shape format: " + line);
            return null;
        }

        var shapeType = parts[0];
        var x1 = Integer.parseInt(parts[1]);
        var y1 = Integer.parseInt(parts[2]);
        var x2 = Integer.parseInt(parts[3]);
        var y2 = Integer.parseInt(parts[4]);
        var color = parts[5];

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