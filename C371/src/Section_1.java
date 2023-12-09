import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Section_1 {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Fireb\\Downloads\\aoc\\C371\\src\\Day_1.txt";
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            int sum = lines.mapToInt(line -> getCalibrationValue(line)).sum();
            System.out.println(sum);
        } catch (IOException e) {
            System.out.println("didnt find file");
        }
    }

    public static int getCalibrationValue(String line){
        int firstDigit = Character.getNumericValue(line.chars()
                .filter(Character::isDigit)
                .findFirst()
                .orElse(-1));
        int lastDigit = Character.getNumericValue(line.chars()
                .filter(Character::isDigit)
                .reduce((first, second) -> second)
                .orElse(-1));
        return Integer.parseInt(String.valueOf(firstDigit) + String.valueOf(lastDigit));
    }
}