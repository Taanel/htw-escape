package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


/**
 * Klasse für den Hauptprogrammablauf des Spiels.
 * @author Thanh
 */
public class EscapeApp {

    public static final String SAVE_FILE_NAME = "save";
    private EscapeGame game;
    public static final Scanner INPUT = new Scanner(System.in);
    private boolean appRunning = true;

    public static void main(String[] args) {
        System.out.println("Welcome to the HTW escape");
        System.out.println("");
        System.out.println("");

        EscapeApp app = new EscapeApp();

        while (app.appRunning) {
            app.showMainMenu();
            String choice = app.readUserInput();
            app.handleUserInput(choice);
            System.out.println("====================");
        }
    }


    /**
     * Methode erstellt Hauptmenü.
     * Menüeinträge werden durch Bedingungen erweitert.
     * @author Taha Yildirim
     */
    private void showMainMenu() {

        System.out.println("MAIN MENU");
        System.out.println("========================================");
        System.out.println("What do you want to do next?");
        System.out.println("(1) Start new game");
        if (isGameRunning() && !isGameFinished())    {
            System.out.println("(2) Resume game");
        }
        if (hasSavedGame())     {
            System.out.println("(3) Load game");
        }
        if (isGameRunning())    {
            System.out.println("(4) Save game");
        }
        if (hasSavedGame())     {
            System.out.println("(5) Delete game");
        }
        System.out.println("(6) Quit game");
        System.out.println("");
        System.out.println("Please choose a number between 1 and 6: ");
    }


    /**
     * Input des Users wird gelesen
     * @return userInput Benutzereingabe
     * @author Thanh
     */
    private String readUserInput() {
        Scanner scanner = INPUT;
        String userInput = scanner.nextLine();
        return userInput;
    }


    /**
     * Methode für sechs mögliche Menüeingaben, welche jeweils Methoden ausführen.
     * @param input Menüeingabe des Spielers
     * @author Thanh
     */
    private void handleUserInput(String input) {
        switch (input) {
            case "1":
                this.startGame();
                break;
            case "2":
                if (isGameRunning() && !isGameFinished()) {
                    this.resumeGame();
                } else {
                    System.out.println("The game has not started yet!");
                }
                break;
            case "3":
                if (hasSavedGame()) {
                    this.loadGame();
                } else {
                    System.out.println("There are no saved games!");
                }
                break;
            case "4":
                if (isGameRunning()) {
                    this.saveGame();
                } else {
                    System.out.println("The game has not started yet!");
                }
                break;
            case "5":
                if (hasSavedGame()) {
                    this.deleteGame();
                } else {
                    System.out.println("There are no saved games!");
                }
                break;
            case "6":
                System.out.println("Goodbye!");
                this.appRunning = false;
                break;
            default:
                System.out.println("Invalid input. Please choose a correct number between 1 and 6");
                break;
        }
    }


    /**
     * Fragt den Namen des Helden ab und startet ein neues Spiel.
     * @author Thanh
     */
    private void startGame() {
        Scanner scanner = INPUT;
        System.out.println("Please insert your Heros name: ");
        String heroName = scanner.nextLine();
        this.game = new EscapeGame(heroName);

        resumeGame();
    }


    /**
     * Methode für das Weiterführen des Spieles.
     * @author Thanh
     */
    private void resumeGame() {
        this.game.setGameRunning(true);
        this.game.run();

    }


    /**
     * Löscht Spielstand vom aktuellen Spieles.
     * @author Thanh
     */
    private void deleteGame() {
        if (new File(SAVE_FILE_NAME).delete()) {
            System.out.println("Game deleted!");
        }
    }


    /**
     * Methode, welche den aktuellen Spielstand speichert.
     * @author Thanh
     */
    private void saveGame() {
        try (FileOutputStream fos = new FileOutputStream(SAVE_FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
            oos.flush();
        } catch (Exception ex) {
            System.err.println("Something went wrong while saving the game: " + ex.getMessage());
            return;
        }
        System.out.println("Game saved!");
    }


    /**
     * Methode, welche gespeichertes Spiel lädt.
     * @author Thanh
     */
    private void loadGame() {
        try (FileInputStream fis = new FileInputStream(SAVE_FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.game = (EscapeGame) ois.readObject();
            System.out.println("Game loaded!");
        } catch (Exception ex) {
            System.err.println("Something went wrong while loading the game: " + ex.getMessage());
        }
    }


    /**
     * Gibt an, ob das Spiel ausgeführt wird.
     * @return true, wenn Spiel ausgeführt wird. Andernfalls ergibt es false.
     * @author Thanh
     */
    private boolean isGameRunning() {
        return game != null;
    }


    /**
     * Gibt an, ob das Spiel beendet wurde.
     * @return true, wenn Spiel existiert und abgeschlossen wurde. Andernfalls false.
     * @author Thanh
     */
    private boolean isGameFinished() {
        return game != null && game.isGameFinished();
    }


    /**
     * Prüft, ob Spiel mit gespeichertem Inhalt vorhanden ist.
     * @return true, wenn Spielstand existiert. Andernfalls false.
     * @author Thanh
     */
    private boolean hasSavedGame() {
        return new File(SAVE_FILE_NAME).exists();
    }

}

