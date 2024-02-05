import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SRFlipFlop extends JFrame {
    private boolean s, r;
    private boolean q;
    private JLabel qLabel;
    private JLabel qBarLabel;
    private JTextField sInput;
    private JTextField rInput;
    private JTextField qOutput;
    private JTextField qBarOutput;

    public SRFlipFlop() {
        initComponents();
    }

    private void initComponents() {
        setTitle("SR Flip Flop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        sInput = new JTextField();
        rInput = new JTextField();
        qOutput = new JTextField();
        qOutput.setEditable(false);
        qBarOutput = new JTextField();
        qBarOutput.setEditable(false);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = Boolean.parseBoolean(sInput.getText());
                r = Boolean.parseBoolean(rInput.getText());
                updateOutputs();
            }
        });

        qLabel = new JLabel("Q:");
        qBarLabel = new JLabel("Q(bar):");

        add(new JLabel("S input:"));
        add(sInput);
        add(new JLabel("R input:"));
        add(rInput);
        add(updateButton);
        add(qLabel);
        add(qOutput);
        add(qBarLabel);
        add(qBarOutput);
    }

    private void updateOutputs() {
        if (s && !r) {
            q = true;
        } else if (!s && r) {
            q = false;
        }

        qOutput.setText(q ? "1" : "0");
        qBarOutput.setText(q ? "0" : "1");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SRFlipFlop flipFlop = new SRFlipFlop();
                flipFlop.setVisible(true);
            }
        });
    }
}
