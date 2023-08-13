package code.manage.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLI {

    public CLI() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            System.out.print("=> ");
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if(line.equalsIgnoreCase("q")) break;

                System.out.println(CommandParser.parseLine(line));
                System.out.print("=> ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
