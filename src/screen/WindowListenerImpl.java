package screen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WindowListenerImpl extends WindowAdapter {

    private Picture pic;

    private final String savePath;

    public WindowListenerImpl(Picture pic, String savePath) {
        this.pic = pic;
        this.savePath = savePath;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //write the history highest mark into the file "mark"
    	try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(savePath));
            outputStream.write(String.valueOf(pic.mark).getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        super.windowClosing(e);
        //System.exit(0);
    }
}
