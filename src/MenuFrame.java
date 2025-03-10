import javax.swing.*;
import java.util.Random;

public class MenuFrame extends JFrame{ //obsahuje JFrame
    private JPanel panel;
    private JCheckBox cbZatrzeno;
    private JTextField textField1;

    Random generator = new Random();

    public MenuFrame(){ // konstrukstor, kde voláme metody
        initComponents();


    }

    public static void main(String[] args) {
        MenuFrame frame = new MenuFrame(); // vytvoří oobjekt frame
        frame.setVisible(true); // nastaví abychom viděli okna ve framě
    }

    private void initComponents(){
        setContentPane(panel);
        setTitle("Ukázka menu");
        setSize(400,200);
        initMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar(); //vytvoříme panel pro menu
        setJMenuBar(menuBar);    //nastavíme panel

        JMenu menuAkce = new JMenu("akce"); // vytvoříme políčko menu
        menuBar.add(menuAkce); // přidíme políčko do panelu

        JMenuItem miPozdrav = new JMenuItem("pozdrav"); //vytvoří položku
        menuAkce.add(miPozdrav); //menu přidej položku
        menuAkce.addSeparator(); // menu přidej oddělovač
        miPozdrav.addActionListener(e -> pozdrav()); //přidá úkol co provede


        JMenuItem miZmeny = new JMenuItem("změna");
        menuAkce.add(miZmeny);
        miZmeny.addActionListener(e -> provedZmeny()); //přidá úkol co provede
    }

    private void pozdrav(){ // metoda pro vyskakovací okno pro položku POZDRAV
        JOptionPane.showMessageDialog(this, "Ahoj z menu"); //vyskakovací okno Ahoj
    }

    private void provedZmeny(){ // vyvolá akci pro položku ZMĚNA
        cbZatrzeno.setSelected(! cbZatrzeno.isSelected()); // zaškrtne opačnou vlastnost
        textField1.setText(""+(generator.nextInt(100))); // vygeneruje náhodné číslo a dá do textového pole

    }
}
