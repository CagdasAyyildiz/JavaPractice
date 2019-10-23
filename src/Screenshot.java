import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screenshot implements Runnable {
    @Override
    public void run() {
        BufferedImage image = null;

        try {
            image = (new Robot()).createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (AWTException e) {
            e.printStackTrace();
        }

            try {
                if (image != null) {
                    ImageIO.write(image, Constants.FILE_FORMAT, new File(new File(".").getCanonicalPath()+ "\\ss.png"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
