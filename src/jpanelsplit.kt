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
    private var frame: JFrame = JFrame()
    private var contentPane: JPanel
    private var pinkPanel: JPanel
    private var yellowPanel: JPanel
    var textPanel: JPanel? = null
    private var greenPanel: JPanel
    private var bluePanel: JPanel
    private var twoPanelContainer: JPanel
    private var nameField: JTextField
    private var accountNumberField: JTextField
    private var ammountField: JTextField
    private var yearField: JTextField
    private var monthList: JList<*>
    private var insertEntryButton: JButton

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
    private var count = 0
    private val alist = ArrayList<JpanelSplit>()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            JpanelSplit()
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
        val accountLabel = JLabel("Add new Account", SwingConstants.LEFT)
        accountLabel.font = Font("Times New Roman", 1, 20)
        accountLabel.setBounds(0, 50, 10, 10)

        //Nmae
        val nameLabel = JLabel("Name:   ", SwingConstants.LEFT)
        nameLabel.font = Font("Times New Roman", 1, 18)
        nameLabel.setBounds(0, 100, 10, 10)
        nameField = JTextField("Name", 15)

        //Account number
        val accountNumberLabel = JLabel("Account #:   ", SwingConstants.LEFT)
        accountNumberLabel.font = Font("Times New Roman", 1, 18)
        accountNumberLabel.setBounds(0, 150, 10, 10)
        accountNumberField = JTextField("Account Number", 15)

        //Amount
        val ammountLabel = JLabel("Amount:   ", SwingConstants.LEFT)
        ammountLabel.font = Font("Times New Roman", 1, 18)
        ammountLabel.setBounds(0, 50, 10, 10)
        ammountField = JTextField("Amount", 15)

        // Radio Button ---> Account type
        val accountTypeLabel = JLabel("Account Type:   ", SwingConstants.LEFT)
        accountTypeLabel.font = Font("Times New Roman", 1, 18)
        accountTypeLabel.setBounds(0, 50, 10, 10)
        val radioButtonCurrent = JRadioButton("Current")

        //current.setSelected(true);
        val radioButtonSaving = JRadioButton("Saving")
        val accountTypeRadioButtonGroup = ButtonGroup()
        accountTypeRadioButtonGroup.add(radioButtonCurrent)
        accountTypeRadioButtonGroup.add(radioButtonSaving)

        //Date Of Opening
        val dateOfOpeningLabel = JLabel("Date of Opening:   ", SwingConstants.LEFT)
        dateOfOpeningLabel.font = Font("Times New Roman", 1, 18)
        dateOfOpeningLabel.setBounds(0, 50, 10, 10)

        //comboBox for day
        val daysArr = Array<String?>(31) { "it = $it" };
        for (x in 1..31) {
            daysArr[x - 1] = x.toString();
        }
        val dayComboBox = JComboBox(daysArr)
        //List for month
        val monthsArr = arrayOf<String>(
            "January", "February", "March",
            "April", "May", "June", "July", "August",
            "September", "October", "November", "December"
        )
        monthList = JList<Any?>(monthsArr)
        monthList.selectedIndex = 1
        val listScroller = JScrollPane(monthList)
        listScroller.preferredSize = Dimension(100, 80)
        // text Field for year
        yearField = JTextField("Year", 6)

        // Add Button
        insertEntryButton = JButton("Add")
        insertEntryButton.setBounds(125, 90, 80, 30)

        //adding values into an array
        // ButtonListener bh = new ButtonListener();
        // add.addActionListener((ActionListener) bh);

        //*****************************************************************************// 
        // Adding Listener to JButton
        insertEntryButton.addActionListener {
            //get text from text fields
            nameTf = nameField.text
            accTf = accountNumberField.text
            amountTf = ammountField.text
            yTf = yearField.text
            //alist.add(j)
            this.nameTf = nameTf
            this.accTf = accTf
            this.amountTf = amountTf
            this.yTf = yTf
            //adding into array
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
            if (radioButtonCurrent.isSelected) {
                qual = "Current"
            } else if (radioButtonSaving.isSelected) {
                qual = "Saving"
            } else {
                qual = "NO Option Is selected"
                JOptionPane.showMessageDialog(null, qual)
            }

            // MessageDialog to show information selected radion buttons.
            // JOptionPane.showMessageDialog(null,qual);
        }

        //yellowPanel.setLayout(new BoxLayout(yellowPanel, BoxLayout.Y_AXIS));
        yellowPanel.add(accountLabel)
        yellowPanel.add(nameLabel)
        yellowPanel.add(nameField, BorderLayout.WEST)
        yellowPanel.add(accountNumberLabel)
        yellowPanel.add(accountNumberField, BorderLayout.WEST)
        yellowPanel.add(ammountLabel)
        yellowPanel.add(ammountField, BorderLayout.WEST)
        yellowPanel.add(accountTypeLabel)
        yellowPanel.add(radioButtonCurrent)
        yellowPanel.add(radioButtonSaving)
        yellowPanel.add(dateOfOpeningLabel)
        yellowPanel.add(dayComboBox)
        yellowPanel.add(listScroller)
        yellowPanel.add(yearField, BorderLayout.WEST)
        yellowPanel.add(insertEntryButton)

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