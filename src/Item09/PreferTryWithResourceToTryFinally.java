package Item09;


import java.io.*;

/**
 * @Try-with-resource is shorter and more readable.
 * -----
 * @Try-with-resource provide far better diagnostics.
 */

/*
   Always use try-with-resources in preference to try-finally when working with resources that must be closed

   The resulting code shorter and clearer
 */
public class PreferTryWithResourceToTryFinally {

    // Example of ugly try-finally
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
