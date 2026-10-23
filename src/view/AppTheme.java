
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class AppTheme {

    // Warna tema
    public static final Color BACKGROUND =
            new Color(245, 247, 250);

    public static final Color CARD_BACKGROUND =
            Color.WHITE;

    public static final Color TEXT_COLOR =
            new Color(45, 52, 64);

    public static final Color GOLD =
            new Color(212, 160, 23);

    // Warna berdasarkan role karakter
    public static final Color WARRIOR_COLOR =
            new Color(255, 220, 220);

    public static final Color MAGE_COLOR =
            new Color(220, 230, 255);

    public static final Color ARCHER_COLOR =
            new Color(220, 245, 225);

    public static final Color DEFAULT_COLOR =
            new Color(235, 235, 235);

    // Font tema
    public static final Font TITLE_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 22);

    public static final Font NORMAL_FONT =
            new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    public static final Font LEVEL_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 14);

    // Border kartu karakter
    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(210, 215, 220)
                    ),
                    BorderFactory.createEmptyBorder(
                            10, 12, 10, 12
                    )
            );

    // Batas level untuk teks emas
    public static final int GOLD_LEVEL_THRESHOLD = 5;

    // Menentukan warna berdasarkan role
    public static Color colorFor(String role) {
        if (role == null) {
            return DEFAULT_COLOR;
        }

        switch (role.toLowerCase()) {
            case "warrior":
                return WARRIOR_COLOR;

            case "mage":
                return MAGE_COLOR;

            case "archer":
                return ARCHER_COLOR;

            default:
                return DEFAULT_COLOR;
        }
    }

    // Mencegah objek AppTheme dibuat
    private AppTheme() {
    }
}
