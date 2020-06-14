/*
 * Written by Hamza (@MZO9400)
*/
package jpanelsplit

import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.util.*
import java.util.regex.Pattern
import javax.swing.*
import javax.swing.table.DefaultTableModel


class JpanelSplit {
    private val frame: JFrame = JFrame()
    private val contentPane: JPanel
    private val pinkPanel: JPanel
    private val yellowPanel: JPanel
    private val greenPanel: JPanel
    private val bluePanel: JPanel
    private val twoPanelContainer: JPanel
    private val nameField: JTextField
    private val accountNumberField: JTextField
    private val amountField: JTextField
    private val yearField: JTextField
    private val monthList: JList<*>
    private val insertEntryButton: JButton
    private val radioButtonSaving: JRadioButton
    private val radioButtonCurrent: JRadioButton
    private val dayComboBox: JComboBox<String?>
    private val table: JTable
    private val transferAmount: JTextField
    private val transferAccountNames: JComboBox<String?>
    private val transferButton: JButton

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

    private fun removeElement(row: Int) {
        accountsList.removeAt(row)
        val model = table.model as DefaultTableModel
        model.removeRow(row)
        transferAccountNames.removeItemAt(row)
    }

    private fun insert(data: AccountInfo) {
        if (validate()) {
            JOptionPane.showMessageDialog(this.frame, "ADDED")
            resetForm()
            accountsList.add(data)
            val model = table.model as DefaultTableModel
            model.addRow(arrayOf(data.nameText, data.accountText, data.amountText, data.yearText, "X"))
            val boxModel = transferAccountNames.model as DefaultComboBoxModel
            boxModel.addElement(data.nameText)
        }
    }

    private fun validate(): Boolean {
        var isValid = true
        val stk = Stack<String>()
        if (!radioButtonCurrent.isSelected && !radioButtonSaving.isSelected) {
            isValid = false
            stk.push("Account type is invalid")
        }
        if (nameField.text == "Name" || nameField.text == "" || !Pattern.matches("[a-zA-Z]+", nameField.text)) {
            isValid = false
            stk.push("Name is invalid")
        }
        if (accountNumberField.text == "" || accountNumberField.text.toIntOrNull() == null) {
            isValid = false
            stk.push("Account Number is invalid")
        }
        if (amountField.text == "" || amountField.text.toIntOrNull() == null) {
            isValid = false
            stk.push("Amount is invalid")
        }
        if (yearField.text == "Year" || yearField.text == "") {
            isValid = false
            stk.push("Year is invalid")
        }
        if (!isValid)
            JOptionPane.showMessageDialog(this.frame, java.lang.String.join(",", stk))
        return isValid
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            JpanelSplit()
        }
    }

    init {
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        contentPane = JPanel(GridLayout(3, 1))

        // first panel contain Introduction and project name
        pinkPanel = JPanel()
        pinkPanel.background = Color.PINK
        val headerLabel =
            JLabel("<html><h1>GUI FOR BANKING SYSTEM</h1><br>Name:  Sheeza Sarwar<br>Roll#:  3706-FBAS/BSSE/F18-B</html>")
        headerLabel.font = Font("Verdana", 1, 20)
        pinkPanel.add(headerLabel)

        yellowPanel = JPanel()
        yellowPanel.background = Color.YELLOW

        bluePanel = JPanel()
        bluePanel.background = Color.BLUE

        greenPanel = JPanel()
        greenPanel.background = Color.GREEN

        // Add new Account
        val accountLabel = JLabel("Add new Account", SwingConstants.LEFT)
        accountLabel.font = Font("Times New Roman", 1, 20)
        accountLabel.setBounds(0, 50, 10, 10)

        // Name
        val nameLabel = JLabel("Name:   ", SwingConstants.LEFT)
        nameLabel.font = Font("Times New Roman", 1, 18)
        nameLabel.setBounds(0, 100, 10, 10)
        nameField = JTextField("Name", 15)

        // Account number
        val accountNumberLabel = JLabel("Account #:   ", SwingConstants.LEFT)
        accountNumberLabel.font = Font("Times New Roman", 1, 18)
        accountNumberLabel.setBounds(0, 150, 10, 10)
        accountNumberField = JTextField("Account Number", 15)

        // Amount
        val ammountLabel = JLabel("Amount:   ", SwingConstants.LEFT)
        ammountLabel.font = Font("Times New Roman", 1, 18)
        ammountLabel.setBounds(0, 50, 10, 10)
        amountField = JTextField("Amount", 15)

        // Radio Button ---> Account type
        val accountTypeLabel = JLabel("Account Type:   ", SwingConstants.LEFT)
        accountTypeLabel.font = Font("Times New Roman", 1, 18)
        accountTypeLabel.setBounds(0, 50, 10, 10)
        radioButtonCurrent = JRadioButton("Current")

        // current.setSelected(true);
        radioButtonSaving = JRadioButton("Saving")
        val accountTypeRadioButtonGroup = ButtonGroup()
        accountTypeRadioButtonGroup.add(radioButtonCurrent)
        accountTypeRadioButtonGroup.add(radioButtonSaving)

        // Date Of Opening
        val dateOfOpeningLabel = JLabel("Date of Opening:   ", SwingConstants.LEFT)
        dateOfOpeningLabel.font = Font("Times New Roman", 1, 18)
        dateOfOpeningLabel.setBounds(0, 50, 10, 10)

        // comboBox for day
        val daysArr = Array<String?>(31) { "it = $it" }
        for (x in 1..31) {
            daysArr[x - 1] = x.toString()
        }
        dayComboBox = JComboBox(daysArr)

        // List for month
        val monthsArr = arrayOf(
            "January", "February", "March",
            "April", "May", "June", "July", "August",
            "September", "October", "November", "December"
        )

        monthList = JList<Any?>(monthsArr)
        monthList.selectedIndex = 0
        val monthListScroller = JScrollPane(monthList)
        monthListScroller.preferredSize = Dimension(100, 80)

        // text Field for year
        yearField = JTextField("Year", 6)

        // Add Button
        insertEntryButton = JButton("Add")
        insertEntryButton.setBounds(125, 90, 80, 30)

        // Adding Listener to JButton
        insertEntryButton.addActionListener {
            insert(AccountInfo(nameField.text, amountField.text, accountNumberField.text, yearField.text))

            // Display on log
            for (i in accountsList.indices) {
                print(
                    """Name: ${accountsList[i].nameText}
 Account#:""" + accountsList[i]
                        .accountText + "\n Amount: " + accountsList[i].amountText + "\n Year : " + accountsList[i]
                        .yearText
                )
            }
        }

        /*
        * Extend JTable with an anonymous class which overrides isCellEditable to always return false
        * Thus disabling editing
        */
        table = object : JTable() {
            override fun isCellEditable(row: Int, column: Int): Boolean {
                return false
            }
        }
        val model = DefaultTableModel()
        model.setColumnIdentifiers(arrayOf("NAME", "ACC #", "AMOUNT", "YEAR", "DELETE"))
        table.model = model

        table.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {
                if (table.columnAtPoint(e.point) == 4)
                    removeElement(table.rowAtPoint(e.point))
            }
        })

        // Tooltips
        nameField.toolTipText = "NAME"
        accountNumberField.toolTipText = "ACCOUNT NUMBER"
        amountField.toolTipText = "AMOUNT"
        radioButtonCurrent.toolTipText = "ACCOUNT TYPE: CURRENT"
        radioButtonSaving.toolTipText = "ACCOUNT TYPE: SAVINGS"
        monthListScroller.toolTipText = "MONTH"
        dayComboBox.toolTipText = "DAY"
        yearField.toolTipText = "YEAR"
        insertEntryButton.toolTipText = "COMMIT CHANGE"

        transferAmount = JTextField("Transfer Amount")
        transferAccountNames = JComboBox<String?>()
        transferButton = JButton("Transfer")
        transferButton.addActionListener {
            if (transferAmount.text.toIntOrNull() == null) {
                JOptionPane.showMessageDialog(this.frame, "Amount is not valid")
            } else {
                accountsList[transferAccountNames.selectedIndex].amountText =
                    (accountsList[transferAccountNames.selectedIndex].amountText.toInt() +
                            transferAmount.text.toInt()).toString()
                val transferModel = table.model as DefaultTableModel
                transferModel.setValueAt(
                    accountsList[transferAccountNames.selectedIndex].amountText,
                    transferAccountNames.selectedIndex, 2
                )
                transferAmount.text = ""
                JOptionPane.showMessageDialog(this.frame, "Transfer successful!")
            }
        }
        transferAmount.setBounds(50, 50, 100, 10)
        transferAccountNames.setBounds(50, 100, 100, 10)
        transferButton.setBounds(50, 150, 100, 10)

        transferAmount.toolTipText = "Amount to transfer"
        transferAccountNames.toolTipText = "Account name"
        transferButton.toolTipText = "Transfer now"

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
        yellowPanel.add(monthListScroller)
        yellowPanel.add(yearField, BorderLayout.WEST)
        yellowPanel.add(insertEntryButton)

        greenPanel.add(JScrollPane(table))

        bluePanel.add(transferAccountNames)
        bluePanel.add(transferAmount)
        bluePanel.add(transferButton)

        twoPanelContainer = JPanel(GridLayout(1, 2))
        twoPanelContainer.add(yellowPanel)
        twoPanelContainer.add(bluePanel)
        contentPane.add(pinkPanel)
        contentPane.add(twoPanelContainer)
        contentPane.add(greenPanel)
        frame.contentPane = contentPane
        val dim = Toolkit.getDefaultToolkit().screenSize
        frame.size = dim
        frame.isVisible = true // .show() is depreciated
    }
}