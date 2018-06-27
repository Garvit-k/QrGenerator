import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		String details = in.nextLine();
		
		System.out.println("Enter a File name in which QR Code is to be stored");
		String filename = in.nextLine();
		
		ByteArrayOutputStream out =  QRCode.from(details).to(ImageType.JPG).stream();
		
		File f = new File(filename+".jpg");
		FileOutputStream fos = new FileOutputStream(f);
		
		fos.write(out.toByteArray());
		
		BufferedImage img = ImageIO.read(f);
        JLabel label = new JLabel(new ImageIcon(img));
	    JFrame frame = new JFrame("Image");
	    frame.setSize(300,300);
	    frame.add(label);
        frame.setFocusable(true);
        frame.setVisible(true);
        
		fos.flush();
		
		fos.close();
		in.close();
	}

}