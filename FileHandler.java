import javax.swing.*;
import java.io.*;

public class FileHandler {
    
    public static void openFile(JFrame parent, JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parent, "Error opening file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void saveFile(JFrame parent, JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parent, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
