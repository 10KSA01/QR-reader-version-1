package testing;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Reader {
	public static void main(String[] args) throws IOException{
		try {

			// Please choose either Windows or Raspberry Pi:

			// Windows (11)
			 ProcessBuilder builder = new ProcessBuilder("python",
			 	System.getProperty("user.dir") + "\\src\\testing\\script.py"); //You most likely have to change the file path if you are running this on windows
			 Process process = builder.start();

			// Raspberry Pi
//			ProcessBuilder builder = new ProcessBuilder("python3", 
//                            System.getProperty("user.dir") +"/script.py");
//			Process process = builder.start();
			
			// Reading from python script
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			// Reading errors from python script (Comment out errors and the 2nd while loop if you do not want to see the errors)
			BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			// Output every line from python script
			String lines = null;
			while((lines = reader.readLine())!= null) {
				System.out.println("Lines: " + lines);
			}
			// Output every error line from python script
			while((lines = errors.readLine())!= null) {
				System.out.println("Error lines: " + lines);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Please make sure install the following libraries in your raspberry pi or PC
	// sudo apt-get update
	// sudo apt-get install python3-opencv
	// sudo apt-get install libqt4-test python3-sip python3-pyqt5 libqtgui4 libjasper-dev libatlas-base-dev -y
	// pip3 install opencv-contrib-python
	// sudo modprobe bcm2835-v4l2


}
