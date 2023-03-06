import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.err.println("Please pass the input file as a command-line parameter.");
            System.exit(1);
        }
        try {
            FileReader progFile = new FileReader(args[0]);
            Parser parser = new Parser(progFile);
            Node program = parser.Program();
            program.print();
        } catch (ParseException e) {
            System.err.println("Parse Error: " + e.getMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("Could not open file for reading.");
            System.exit(1);
        }
    }
}

