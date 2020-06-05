import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame(String title)
    {
        initCalculatorWindow(title);
        setLayout(new BorderLayout());

        JTextField tfCalcField = new JTextField();
        tfCalcField.setFont(tfCalcField.getFont().deriveFont(30f));
        tfCalcField.setEditable(false);

        JPanel pnCalcField = createTextPanel(tfCalcField);
        JPanel pnButtons   = createButtonsPanel(tfCalcField);

        add(pnCalcField, BorderLayout.NORTH);
        add(pnButtons  , BorderLayout.CENTER);

        setVisible(true);
    }

    public void initCalculatorWindow(String aTitle)
    {
        setTitle(aTitle);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(50, 35, 300, 300);
    }

    public JPanel createTextPanel(JTextField aJtf)
    {
        JPanel vPnl = new JPanel(new BorderLayout());
        vPnl.add(aJtf, BorderLayout.CENTER);

        return vPnl;
    }

    public JPanel createButtonsPanel(JTextField aJtf)
    {
        JPanel vPnl = new JPanel(new GridLayout(5, 4));
        String[][] vBtnNames = {
                                   {   "C", "<x", "%", "/"}
                                 , {   "7",  "8", "9", "x"}
                                 , {   "4",  "5", "6", "-"}
                                 , {   "1",  "2", "3", "+"}
                                 , { "+/-",  "0", ",", "="}
                               };

        for (int i = 0; i < vBtnNames.length; i++)
        {
            for (int j = 0; j < vBtnNames[i].length; j++)
            {
                JButton jb = new JButton(vBtnNames[i][j]);
                switch (vBtnNames[i][j])
                {
                    case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
                       , "/", "x", "-", "+", ",":
                        jb.addActionListener(new ButtonListener(aJtf));
                        break;
                    case "C":
                        jb.addActionListener(
                                new ActionListener()
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        aJtf.setText("");
                                    }
                                });
                        break;
                    case "<x":
                        jb.addActionListener(
                                new ActionListener()
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        StringBuilder vTextValue = new StringBuilder(aJtf.getText());
                                        vTextValue.setLength(
                                                vTextValue.length() > 0 ? vTextValue.length() - 1 : 0);
                                        aJtf.setText(vTextValue.toString());
                                    }
                                });
                        break;
                    default:
                        jb.addActionListener(
                                new ActionListener()
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        jb.setBackground(new Color(227, 74, 74));
                                        jb.setText("N/A");
                                    }
                                });
                }

                vPnl.add(jb);
            }
        }
        return vPnl;
    }
}
