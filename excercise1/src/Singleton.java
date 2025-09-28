// --- Singleton Class ---
class GameManager {
    // 1. The single, private, static instance
    private static GameManager instance;
    private int score = 0;

    // 2. A private constructor prevents instantiation from other classes
    private GameManager() {
        System.out.println("GameManager instance created.");
    }

    // 3. The public static method to get the single instance
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void addScore(int points) {
        score += points;
        System.out.println("Current Score: " + score);
    }

    public int getScore() {
        return score;
    }
}

// --- Demo ---
public class Singleton {
    public static void main(String[] args) {
        // Get the instance from two different parts of the game
        GameManager manager1 = GameManager.getInstance();
        GameManager manager2 = GameManager.getInstance();

        System.out.println("Are both manager instances the same? " + (manager1 == manager2));

        manager1.addScore(100); // Player scores points
        manager2.addScore(50);  // Another part of the game adds score
    }
}