import java.awt.*;
import java.awt.event.*;

public class FlipFlopGUI extends JFrame {

    private JPanel mainPanel;
    private JButton setJButton;
    private JButton clearJButton;
    private JButton toggleJButton;
    private JLabel inputJLabel;
    private JLabel outputJLabel;
    private JComboBox<String> flipFlopTypeJComboBox;

    private FlipFlop flipFlop;

    public FlipFlopGUI() {
        super("Flip Flop Simulator");

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2));

        inputJLabel = new JLabel("Input");
        mainPanel.add(inputJLabel);

        flipFlopTypeJComboBox = new JComboBox<>();
        flipFlopTypeJComboBox.addItem("S-R Flip Flop");
        flipFlopTypeJComboBox.addItem("D Flip Flop");
        flipFlopTypeJComboBox.addItem("JK Flip Flop");
        mainPanel.add(flipFlopTypeJComboBox);

        outputJLabel = new JLabel("Output");
        mainPanel.add(outputJLabel);

        setJButton = new JButton("Set");
        setJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flipFlop.setInput(true);
                updateOutput();
            }
        });
        mainPanel.add(setJButton);

        clearJButton = new JButton("Clear");
        clearJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flipFlop.setInput(false);
                updateOutput();
            }
        });
        mainPanel.add(clearJButton);

        toggleJButton = new JButton("Toggle");
        toggleJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flipFlop.toggle();
                updateOutput();
            }
        });
        mainPanel.add(toggleJButton);

        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initFlipFlop();
    }

    private void initFlipFlop() {
        switch (flipFlopTypeJComboBox.getSelectedItem().toString()) {
            case "S-R Flip Flop":
                flipFlop = new SRFlipFlop();
                break;
            case "D Flip Flop":
                flipFlop = new DFlipFlop();
                break;
            case "JK Flip Flop":
                flipFlop = new JKFlipFlop();
                break;
        }

        updateOutput();
    }

    private void updateOutput() {
        outputJLabel.setText(String.valueOf(flipFlop.getOutput()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlipFlopGUI().setVisible(true);
            }
        });
    }
}
