package playerboundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

public class SplashScreenApplication extends JPanel {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SplashScreenApplication frame = new SplashScreenApplication();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SplashScreenApplication() {
        setBounds(100, 100, 540, 413);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{530, 0};
        gbl_contentPane.rowHeights = new int[]{63, 63, 63, 63, 63, 63, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        
        JLabel lblNewLabel = new JLabel("Team Copper\n");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("John");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        JLabel lblNewLabel_3 = new JLabel("Annie");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 2;
        contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Anthony");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 3;
        contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("James");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 4;
        contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        JLabel lblNewLabel_2 = new JLabel("Goutham");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 5;
        contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
    }
}
