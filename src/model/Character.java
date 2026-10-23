
package model;

import java.util.Objects;

public class Character {

    private String name;
    private String type;
    private int level;

    public Character(String name, String type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
