package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader2 {
    public static Process process;
    public static String lines;
    public static boolean found;
    public static String text;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QR_Reader("3");

	}
    public static void QR_Reader(String QR_Duration){
        try {

            // Please choose either Windows or Raspberry Pi:
            
            // Windows (11)
            ProcessBuilder builder = new ProcessBuilder("python",
                System.getProperty("user.dir") + "\\src\\testing\\script2.py", QR_Duration); //You most likely have to change the file path if you are running this on windows
            process = builder.start();
            
            // Reading from python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            // Output every line from python script
            while((lines = reader.readLine())!= null) {
                System.out.println("Lines: " + lines);
            }
            
        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }

}
