package egzamin;

import javax.swing.*;

public class test extends JApplet {
    @Override
    public void init() {
        // Budujemy GUI
        JButton btn = new JButton("Kliknij mnie");
        btn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Hello from JApplet!"));
        // Dodajemy do głównego kontenera
        getContentPane().add(btn);
    }
}