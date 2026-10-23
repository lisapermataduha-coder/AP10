
import model.Character;
import model.CharacterManager;
import view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        manager.addCharacter(new Character("Aragon", "Warrior", 7));
        manager.addCharacter(new Character("Merlin", "Mage", 5));
        manager.addCharacter(new Character("Legolas", "Archer", 4));
        manager.addCharacter(new Character("Thor", "Warrior", 3));
        manager.addCharacter(new Character("Luna", "Mage", 8));
        manager.addCharacter(new Character("Robin", "Archer", 1));

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
