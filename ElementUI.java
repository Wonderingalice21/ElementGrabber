package prj5;

/*
 * File:          ElementUI.java
 * Description:   user interface
 * Author:        Alice Yu, Olivia Gillman
 */

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;


public class ElementUI extends JFrame {

    public static final int MAX_WORD_NUM_LEN = 20;

    private JTextField tfInputElement = null;

    private PropertyTextPane genProp = null;
    private ImagePane genPropImg = null;
    private PropertyTextPane pTable = null;
    private ImagePane gTableImg = null;
    private PropertyTextPane phyProp = null;
    private PropertyTextPane heatProp = null;
    /**
     * Constructs a new periodic table frame
     */
    public ElementUI() {

        // top panel
        JPanel topPanel = new JPanel();
        JPanel topRightPanel = new JPanel();
        JPanel topLeftPanel = new JPanel();

        // element input
        JLabel jlEnterElement = new JLabel("Enter an element", JLabel.CENTER);
        tfInputElement = new JTextField(MAX_WORD_NUM_LEN);

        JButton lookupButton = new JButton("Lookup Element");
        lookupButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @SuppressWarnings("ResultOfMethodCallIgnored")
            @Override
            public void mouseReleased(MouseEvent e) {
                if(!tfInputElement.getText().trim().isEmpty()) {
                    ElementInfo webEle = new ElementInfo();
                    CElement elm = new CElement();
                    webEle.getElement(tfInputElement.getText(), elm);
                    updateUI(elm);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // set up top panel
        topLeftPanel.add(jlEnterElement);
        topLeftPanel.add(tfInputElement);
        topRightPanel.add(lookupButton);

        topPanel.setBorder(BorderFactory.createTitledBorder(""));
        topPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(topLeftPanel);
        topPanel.add(topRightPanel);

        //property panel

        //property panel -- 1
        JPanel propertyPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel genProPanel = new JPanel();
        JPanel propertyUpLeftPanel = new JPanel();

        // Up Right  -- general property
        genProPanel.setLayout(new BoxLayout(genProPanel, BoxLayout.PAGE_AXIS));
        genProp = new PropertyTextPane("General Property");
        genProPanel.add(genProp);

        // Up left  -- image
        propertyUpLeftPanel.setLayout(new BoxLayout(propertyUpLeftPanel, BoxLayout.PAGE_AXIS));
        genPropImg = new ImagePane();
        propertyUpLeftPanel.add(genPropImg);

        propertyPanel1.add(genProPanel, BorderLayout.LINE_START);
        propertyPanel1.add(propertyUpLeftPanel, BorderLayout.LINE_END);

        //property panel - 2
        JPanel propertyPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel propertyMidRightPanel = new JPanel();
        JPanel propertyMidLeftPanel = new JPanel();

        // Middle Right -- peroidic table
        propertyMidRightPanel.setLayout(new BoxLayout(propertyMidRightPanel, BoxLayout.PAGE_AXIS));
        pTable = new PropertyTextPane("Periodic Table");
        propertyMidRightPanel.add(pTable);

        // middle left  -- image
        propertyMidLeftPanel.setLayout(new BoxLayout(propertyMidLeftPanel, BoxLayout.PAGE_AXIS));
        gTableImg = new ImagePane();
        propertyMidLeftPanel.add(gTableImg);

        propertyPanel2.add(propertyMidRightPanel,BorderLayout.LINE_START);
        propertyPanel2.add(propertyMidLeftPanel,BorderLayout.LINE_END);


        //property panel -- 3
        JPanel propertyPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel propertyDnRightPanel = new JPanel();
        JPanel propertyDnLeftPanel = new JPanel();

        // down right -- physical property
        propertyDnRightPanel.setLayout(new BoxLayout(propertyDnRightPanel, BoxLayout.PAGE_AXIS));
        phyProp = new PropertyTextPane("Physical Property");
        propertyDnRightPanel.add(phyProp);

        // down left -- heat property
        propertyDnLeftPanel.setLayout(new BoxLayout(propertyDnLeftPanel, BoxLayout.PAGE_AXIS));
        heatProp = new PropertyTextPane("Heat Property");
        propertyDnLeftPanel.add(heatProp);

        propertyPanel3.add(propertyDnRightPanel,BorderLayout.LINE_START);
        propertyPanel3.add(propertyDnLeftPanel,BorderLayout.LINE_END);

        // set up property panel
        JPanel propertyPanel = new JPanel();
        propertyPanel.setLayout(new BorderLayout());
        propertyPanel.setOpaque(false);
        propertyPanel.add(propertyPanel1,BorderLayout.NORTH);
        propertyPanel.add(propertyPanel2,BorderLayout.CENTER);
        propertyPanel.add(propertyPanel3,BorderLayout.SOUTH);

        //create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setOpaque(false);// !!
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(propertyPanel, BorderLayout.SOUTH);


        //set frame
        setTitle("Element");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("logo.png").getImage());
        setResizable(false);
        add(mainPanel);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void clear() {
        genProp.clearContentOnly();
        //ImagePane genPropImg = null;
        pTable.clearContentOnly();
        //ImagePane gTableImg = null;
        phyProp.clearContentOnly();
        heatProp.clearContentOnly();
    }

    private void updateUI(CElement element) {
        clear();
        genProp.appendText(element.genProperty.toString());
        //ImagePane genPropImg = null;
        pTable.appendText(element.periodicTable.toString());
        //ImagePane gTableImg = null;
        phyProp.appendText(element.phyProperty.toString());
        heatProp.appendText(element.heatProperty.toString());
        repaint();
    }



    /**
     * Displays this periodic table frame
     */
    public void display() {
        //this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}