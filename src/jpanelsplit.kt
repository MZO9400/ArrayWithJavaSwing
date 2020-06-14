/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelsplit

import java.awt.*
import java.util.*
import javax.swing.*

/**
 *
 * @author wali
 */
class JpanelSplit {
    var frame: JFrame = JFrame()
    var contentPane: JPanel
    var pinkPanel: JPanel
    var yellowPanel: JPanel
    var textPanel: JPanel? = null
    var greenPanel: JPanel
    var bluePanel: JPanel
    var twoPanelContainer: JPanel
    var t1: JTextField
    var t2: JTextField
    var t3: JTextField
    var t4: JTextField
    var mon: JList<*>
    var add: JButton

    /* private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    /* private void addBtnActionPerformed(java.awt.event.ActionEvent e){
        //get text from text fields
        nameTf=t1.getText();
        accTf=t2.getText();
        amountTf= t3.getText();
        yTf= t4.getText();
        JpanelSplit j = new JpanelSplit();
        j.setNameTf(nameTf);
        j.setAccTf(accTf);
        j.setAmountTf(amountTf);
        j.setYTf(yTf);
        //adding into array
        alist.add(j);

        count++;
        JOptionPane.showMessageDialog(null,"ADDED");

    }*/
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    private var nameTf: String

    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    private var amountTf: String

    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    private var accTf: String

    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    private var yTf: String
    var d: String? = null
    var m: String? = null
    var i: Int? = null
    var count = 0
    private val alist = ArrayList<JpanelSplit>()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val jpanelSplit = JpanelSplit()
        }
    }

    init {
//        initComponents();
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        contentPane = JPanel(GridLayout(3, 1))
        //*********************************************************************************************//

        // first panel contain Introduction and project name
        pinkPanel = JPanel()
        pinkPanel.background = Color.PINK
        val jlabel =
            JLabel("<html><h1>GUI FOR BANKING SYSTEM</h1><br>Name:  Sheeza Sarwar<br>Roll#:  3706-FBAS/BSSE/F18-B</html>")
        jlabel.font = Font("Verdana", 1, 20)
        pinkPanel.add(jlabel)

        //*******************************************************************************************///
        //yellowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        yellowPanel = JPanel()
        yellowPanel.background = Color.YELLOW
        //Add new Account
        val l = JLabel("Add new Account", SwingConstants.LEFT)
        l.font = Font("Times New Roman", 1, 20)
        l.setBounds(0, 50, 10, 10)
        //Nmae
        val label1 = JLabel("Name:   ", SwingConstants.LEFT)
        label1.font = Font("Times New Roman", 1, 18)
        label1.setBounds(0, 100, 10, 10)
        t1 = JTextField("Name", 15)
        //Account number
        val accno = JLabel("Account #:   ", SwingConstants.LEFT)
        accno.font = Font("Times New Roman", 1, 18)
        accno.setBounds(0, 150, 10, 10)
        t2 = JTextField("Account Number", 15)
        //Amount
        val amount = JLabel("Amount:   ", SwingConstants.LEFT)
        amount.font = Font("Times New Roman", 1, 18)
        amount.setBounds(0, 50, 10, 10)
        t3 = JTextField("Amount", 15)
        // Radio Button ---> Account type
        val acctype = JLabel("Account Type:   ", SwingConstants.LEFT)
        acctype.font = Font("Times New Roman", 1, 18)
        acctype.setBounds(0, 50, 10, 10)
        val current = JRadioButton("Current")
        //current.setSelected(true);
        val saving = JRadioButton("Saving")
        val g = ButtonGroup()
        g.add(current)
        g.add(saving)
        //Date Of Opening
        val DoO = JLabel("Date of Opening:   ", SwingConstants.LEFT)
        DoO.font = Font("Times New Roman", 1, 18)
        DoO.setBounds(0, 50, 10, 10)

        ///combo Box for day
        val day = arrayOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31"
        )
        val Day = JComboBox(day)
        //List for month
        val month = arrayOf<String?>(
            "January", "February", "March",
            "April", "May", "June", "July", "August",
            "September", "October", "November", "December"
        )
        mon = JList<Any?>(month)
        mon.selectedIndex = 1
        val listScroller = JScrollPane(mon)
        listScroller.preferredSize = Dimension(100, 80)
        // text Field for year
        t4 = JTextField("Year", 6)

        // Add Button
        add = JButton("Add")
        add.setBounds(125, 90, 80, 30)

        //adding values into an array
        // ButtonListener bh = new ButtonListener();
        // add.addActionListener((ActionListener) bh);

        //*****************************************************************************// 
        // Adding Listener to JButton
        add.addActionListener {
            //get text from text fields
            nameTf = t1.text
            accTf = t2.text
            amountTf = t3.text
            yTf = t4.text
            val j = JpanelSplit()
            j.nameTf = nameTf
            j.accTf = accTf
            j.amountTf = amountTf
            j.yTf = yTf
            //adding into array
            alist.add(j)
            count++
            JOptionPane.showMessageDialog(null, "ADDED")

            /// Display for OurSelf
            for (i in alist.indices) {
                print(
                    """Name: ${alist[i].nameTf}
 Account#:""" + alist[i]
                        .accTf + "\n Amount: " + alist[i].amountTf + "\n Year : " + alist[i]
                        .yTf
                )
            }


            // Override Method

            // Declaration of String class Objects.
            var qual = " "

            // If condition to check if jRadioButton2 is selected.
            if (current.isSelected) {
                qual = "Current"
            } else if (saving.isSelected) {
                qual = "Saving"
            } else {
                qual = "NO Option Is selected"
                JOptionPane.showMessageDialog(null, qual)
            }

            // MessageDialog to show information selected radion buttons.
            // JOptionPane.showMessageDialog(null,qual);
        }

        //yellowPanel.setLayout(new BoxLayout(yellowPanel, BoxLayout.Y_AXIS));
        yellowPanel.add(l)
        yellowPanel.add(label1)
        yellowPanel.add(t1, BorderLayout.WEST)
        yellowPanel.add(accno)
        yellowPanel.add(t2, BorderLayout.WEST)
        yellowPanel.add(amount)
        yellowPanel.add(t3, BorderLayout.WEST)
        yellowPanel.add(acctype)
        yellowPanel.add(current)
        yellowPanel.add(saving)
        yellowPanel.add(DoO)
        yellowPanel.add(Day)
        yellowPanel.add(listScroller)
        yellowPanel.add(t4, BorderLayout.WEST)
        yellowPanel.add(add)

        //********ADDING VALUES IN AN ARRAY************************************************************//
        nameTf = String()
        accTf = String()
        amountTf = String()
        yTf = String()


        //*******************************************************************************************//
        bluePanel = JPanel()
        bluePanel.background = Color.BLUE

        //******************************************************************************************//
        greenPanel = JPanel()
        greenPanel.background = Color.GREEN

        //*******************************************************************************************//
        twoPanelContainer = JPanel(GridLayout(1, 2))
        twoPanelContainer.add(yellowPanel)
        twoPanelContainer.add(bluePanel)
        contentPane.add(pinkPanel)
        contentPane.add(twoPanelContainer)
        contentPane.add(greenPanel)
        frame.contentPane = contentPane
        val dim = Toolkit.getDefaultToolkit().screenSize
        frame.size = dim
        //frame.pack();
        frame.isVisible = true
        frame.show()
    }
}