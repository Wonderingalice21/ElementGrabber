package prj5;

/*
 * File:          ImagePane.java
 * Description:   image panel
 * Author:        Alice Yu, Olivia Gillman
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePane extends JPanel {
    private BufferedImage img = null;

    public void setImage() {
        img = null;
    }
    public void setImage(BufferedImage img) {
        this.img = img;
    }

    // draw everything
    @Override
    public void paint(Graphics g) {
        if(img != null)
             g.drawImage(img, 0, 0, null);
     }

}
