/*
 * File:          PropertyTextPane.java
 * Description:   property panel
 * Author:        Alice Yu, Olivia Gillman
 */

import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

public class PropertyTextPane extends JTextPane {

    String title = null;

    public PropertyTextPane() {
        super();
    }

    public PropertyTextPane(String title) {
        super();
        this.title = "                    "+ title + "                    \n";
        setText(this.title);
    }

    public PropertyTextPane(StyledDocument doc) {
        super(doc);
    }

    // Appends text to the document and ensure that it is visible
    public void appendText(String text) {
        try {
            Document doc = getDocument();

            // Move the insertion point to the end
            setCaretPosition(doc.getLength());

            // Insert the text
            replaceSelection(text);

            // Convert the new end location
            // to view co-ordinates
            Rectangle r = modelToView(doc.getLength());

            // Finally, scroll so that the new text is visible
            if (r != null) {
                scrollRectToVisible(r);
            }
        } catch (BadLocationException e) {
            System.out.println("Failed to append text: " + e);
        }
    }

    public void clearAll(){
        title = "";
        setText("");
    }

    public void clearContentOnly() {
        setText("");
        setText(this.title);
    }

    public void addProperty(String name, String prop){
        String temp = name + ":   " + prop + "\n";
        appendText(temp);
    }

}
