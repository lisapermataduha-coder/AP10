
package view;

import model.Character;
import model.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    public MainWindow(CharacterManager characterManager) {
        setTitle("Character Manager - TP10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(AppTheme.BACKGROUND);
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Judul aplikasi
        JLabel titleLabel = new JLabel("My Characters");
        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.TEXT_COLOR);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel untuk menampilkan kartu karakter
        JPanel characterPanel =
                new JPanel(new GridLayout(0, 2, 10, 10));

        characterPanel.setBackground(AppTheme.BACKGROUND);

        // Mengambil data karakter dari CharacterManager
        List<Character> characters =
                characterManager.getAllCharacters();

        for (Character character : characters) {
            JPanel card = createCharacterCard(character);
            characterPanel.add(card);
        }

        // Scroll jika kartu terlalu banyak
        JScrollPane scrollPane = new JScrollPane(characterPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        // Menyesuaikan ukuran jendela
        pack();
        setMinimumSize(new Dimension(500, 350));
        setLocationRelativeTo(null);
    }

    // Membuat kartu untuk setiap karakter
    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        // Warna kartu mengikuti role karakter
        card.setBackground(AppTheme.colorFor(character.getType()));
        card.setOpaque(true);
        card.setBorder(AppTheme.CARD_BORDER);

        // Nama karakter
        JLabel nameLabel = new JLabel(
                "Nama: " + character.getName()
        );
        nameLabel.setFont(AppTheme.NORMAL_FONT);
        nameLabel.setForeground(AppTheme.TEXT_COLOR);

        // Role karakter
        JLabel roleLabel = new JLabel(
                "Role: " + character.getType()
        );
        roleLabel.setFont(AppTheme.NORMAL_FONT);
        roleLabel.setForeground(AppTheme.TEXT_COLOR);

        // Level karakter
        JLabel levelLabel = new JLabel(
                "Level: " + character.getLevel()
        );

        // Level 5 ke atas menggunakan teks emas dan tebal
        if (character.getLevel() >= AppTheme.GOLD_LEVEL_THRESHOLD) {
            levelLabel.setForeground(AppTheme.GOLD);
            levelLabel.setFont(AppTheme.LEVEL_FONT);
        } else {
            levelLabel.setForeground(AppTheme.TEXT_COLOR);
            levelLabel.setFont(AppTheme.NORMAL_FONT);
        }

        // Properti tambahan 1: tooltip detail karakter
        card.setToolTipText(
                character.getName()
                + " | Role: " + character.getType()
                + " | Level: " + character.getLevel()
        );

        // Menambahkan komponen ke kartu
        card.add(nameLabel);
        card.add(roleLabel);
        card.add(levelLabel);

        return card;
    }
}
