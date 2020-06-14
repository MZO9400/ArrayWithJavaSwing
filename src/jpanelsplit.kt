/*
 * Written by Hamza (@MZO9400)
*/
package jpanelsplit

import java.awt.*
import java.util.*
import javax.swing.*

class JpanelSplit {
    private var frame: JFrame = JFrame()
    private var contentPane: JPanel
    private var pinkPanel: JPanel
    private var yellowPanel: JPanel
    private var greenPanel: JPanel
    private var bluePanel: JPanel
    private var twoPanelContainer: JPanel
    private var nameField: JTextField
    private var accountNumberField: JTextField
    private var amountField: JTextField
    private var yearField: JTextField
    private var monthList: JList<*>
    private var insertEntryButton: JButton
    private var radioButtonSaving: JRadioButton
    private var radioButtonCurrent: JRadioButton
    private var dayComboBox: JComboBox<String?>

    private val accountsList = ArrayList<AccountInfo>()

    private fun resetForm() {
        this.nameField.text = ""
        this.accountNumberField.text = ""
        this.amountField.text = ""
        this.yearField.text = ""
        this.radioButtonCurrent.isSelected = false
        this.radioButtonSaving.isSelected = false
        this.monthList.selectedIndex = 0
        this.dayComboBox.selectedIndex = 0
    }
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

        // first panel contain Introduction and project name
        pinkPanel = JPanel()
        pinkPanel.background = Color.PINK
        val headerLabel =
            JLabel("<html><h1>GUI FOR BANKING SYSTEM</h1><br>Name:  Sheeza Sarwar<br>Roll#:  3706-FBAS/BSSE/F18-B</html>")
        headerLabel.font = Font("Verdana", 1, 20)
        pinkPanel.add(headerLabel)


        //yellowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        yellowPanel = JPanel()
        yellowPanel.background = Color.YELLOW

        //Add new Account
        val accountLabel = JLabel("Add new Account", SwingConstants.LEFT)
        accountLabel.font = Font("Times New Roman", 1, 20)
        accountLabel.setBounds(0, 50, 10, 10)

        //Name
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
        amountField = JTextField("Amount", 15)

        // Radio Button ---> Account type
        val accountTypeLabel = JLabel("Account Type:   ", SwingConstants.LEFT)
        accountTypeLabel.font = Font("Times New Roman", 1, 18)
        accountTypeLabel.setBounds(0, 50, 10, 10)
        radioButtonCurrent = JRadioButton("Current")

        //current.setSelected(true);
        radioButtonSaving = JRadioButton("Saving")
        val accountTypeRadioButtonGroup = ButtonGroup()
        accountTypeRadioButtonGroup.add(radioButtonCurrent)
        accountTypeRadioButtonGroup.add(radioButtonSaving)

        //Date Of Opening
        val dateOfOpeningLabel = JLabel("Date of Opening:   ", SwingConstants.LEFT)
        dateOfOpeningLabel.font = Font("Times New Roman", 1, 18)
        dateOfOpeningLabel.setBounds(0, 50, 10, 10)

        //comboBox for day
        val daysArr = Array<String?>(31) { "it = $it" }
        for (x in 1..31) {
            daysArr[x - 1] = x.toString()
        }
        dayComboBox = JComboBox(daysArr)
        //List for month
        val monthsArr = arrayOf(
            "January", "February", "March",
            "April", "May", "June", "July", "August",
            "September", "October", "November", "December"
        )

        monthList = JList<Any?>(monthsArr)
        monthList.selectedIndex = 0
        val listScroller = JScrollPane(monthList)
        listScroller.preferredSize = Dimension(100, 80)

        // text Field for year
        yearField = JTextField("Year", 6)

        // Add Button
        insertEntryButton = JButton("Add")
        insertEntryButton.setBounds(125, 90, 80, 30)

        // Adding Listener to JButton
        insertEntryButton.addActionListener {
            //get text from text fields
            accountsList.add(AccountInfo(nameField.text, amountField.text, accountNumberField.text, yearField.text))
            resetForm()
            //adding into array
            // If condition to check if jRadioButton2 is selected.
            val isValid = radioButtonCurrent.isSelected || radioButtonSaving.isSelected
            JOptionPane.showMessageDialog(this.frame, if (isValid) "ADDED" else "No option is selected")

            /// Display for OurSelf
            for (i in accountsList.indices) {
                print(
                    """Name: ${accountsList[i].nameText}
 Account#:""" + accountsList[i]
                        .accountText + "\n Amount: " + accountsList[i].amountText + "\n Year : " + accountsList[i]
                        .yearText
                )
            }
        }

        //yellowPanel.setLayout(new BoxLayout(yellowPanel, BoxLayout.Y_AXIS));
        yellowPanel.add(accountLabel)
        yellowPanel.add(nameLabel)
        yellowPanel.add(nameField, BorderLayout.WEST)
        yellowPanel.add(accountNumberLabel)
        yellowPanel.add(accountNumberField, BorderLayout.WEST)
        yellowPanel.add(ammountLabel)
        yellowPanel.add(amountField, BorderLayout.WEST)
        yellowPanel.add(accountTypeLabel)
        yellowPanel.add(radioButtonCurrent)
        yellowPanel.add(radioButtonSaving)
        yellowPanel.add(dateOfOpeningLabel)
        yellowPanel.add(dayComboBox)
        yellowPanel.add(listScroller)
        yellowPanel.add(yearField, BorderLayout.WEST)
        yellowPanel.add(insertEntryButton)

        bluePanel = JPanel()
        bluePanel.background = Color.BLUE

        greenPanel = JPanel()
        greenPanel.background = Color.GREEN

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
        frame.isVisible = true // .show() is depreciated
    }
}