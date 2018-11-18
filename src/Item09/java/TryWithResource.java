package Item09.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// try-with-resources - the best way to close resources!
public class TryWithResource {
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
}
