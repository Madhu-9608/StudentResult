import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class StudentRecord {
    public static void main(String[] args) {
        try {
            // Create and write student records to the file
            FileWriter writer = new FileWriter("student.txt");

            writer.write("Student ID: 101\n");
            writer.write("Student Name: Arun\n");
            writer.write("Department: CSE\n");
            writer.write("Marks: 85\n");

            writer.close();

            // Read student records from the file
            FileReader reader = new FileReader("student.txt");

            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
