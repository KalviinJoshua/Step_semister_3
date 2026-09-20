public class HealthBar {
    private int health;
    private final int maxHealth;
    public HealthBar(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }
    public void takeDamage(int amount) {
        health = health - amount;
        if (health < 0) {
            health = 0;
        }
    }
    public void heal(int amount) {
        health = health + amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    public int getHealth() {
        return health;
    }
    public static void main(String[] args) {
        HealthBar character = new HealthBar(100);
        character.takeDamage(30);
        System.out.println("Health after damage: "
                + character.getHealth());
        character.heal(50);
        System.out.println("Health after healing: "
                + character.getHealth());
        character.takeDamage(150);
        System.out.println("Health after extra damage: "
                + character.getHealth());
    }
}