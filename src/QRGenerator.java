import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * 
 */

/**
 * @author Garvit Kothari
 *
 */
public class QRGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new InputStreamReader(System.in));
		
		System.out.println("Enter a sentence to be converted into QR code");
		String str = in.nextLine();
		
		System.out.println("Enter a File name in which QR Code is to be stored");
		String filename = in.nextLine();
		
		ByteArrayOutputStream out =  QRCode.from(str).to(ImageType.JPG).stream();
		
		File f = new File(filename+".jpg");
		FileOutputStream fos = new FileOutputStream(f);
		
		fos.write(out.toByteArray());
		fos.flush();
		
		fos.close();
		in.close();
	}

}
