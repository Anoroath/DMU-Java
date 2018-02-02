package opgave17;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        URL imageLocation = new URL("https://i.ebayimg.com/images/g/kFkAAOSwWxNYq0gd/s-l300.jpg");
        JOptionPane.showMessageDialog(null, "`Sup", "Title", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
    }

}
