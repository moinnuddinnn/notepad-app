import javax.swing.*;

public class NotepadFrame extends JFrame {
    JTextArea textArea;

    public NotepadFrame() {
        setTitle("Notepad");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text area with scroll
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        // Menus
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        // File menu items
        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem exitApp = new JMenuItem("Exit");

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(exitApp);

        // Edit menu items
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);

        // Add menus to bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        // Actions
        newFile.addActionListener(e -> textArea.setText("")); // clear text
        openFile.addActionListener(e -> FileHandler.openFile(this, textArea));
        saveFile.addActionListener(e -> FileHandler.saveFile(this, textArea));
        exitApp.addActionListener(e -> System.exit(0));

        cut.addActionListener(e -> textArea.cut());
        copy.addActionListener(e -> textArea.copy());
        paste.addActionListener(e -> textArea.paste());

        setVisible(true);
    }
}

