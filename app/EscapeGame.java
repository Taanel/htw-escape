package app;

import model.*;

import java.util.Random;
import java.util.Scanner;
import java.io.Serializable;


/**
 * Klasse repräsentiert das Spiel und erstellt Held, HTW-Räume und Zustände zum Spiel.
 * @author thanh
 */
public class EscapeGame implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[5];
    private boolean gameRunning = true;
    private boolean gameFinished = false;
    private int r = 0;
    private final int rMax = 24;
    private boolean shortRestBenutzt = false;
    private Lecturer l1;
    private Lecturer l2;
    private Lecturer l3;
    private Lecturer l4;
    private Lecturer l5;

    /**
     * Hier wird der Name der von EscapeApp eingegeben wurde weitergegeben
     * Räume werden hier initialisiert und einem Lecturer zugewiesen
     * @param heroName
     * @author thanh
     */
    public EscapeGame(String heroName) {
        this.hero = new Hero(heroName, 50, 0, new Lecturer[5]);

        this.l1 = new Lecturer("Kern, Ada", false);
        this.l2 = new Lecturer("Baum, Linus", false);
        this.l3 = new Lecturer("Stein, Grace", false);
        this.l4 = new Lecturer("Wolf, Alan", false);
        this.l5 = new Lecturer("Lang, Dana", false);

        rooms[0] = new HTWRoom("A 143", "A bright seminar room with large windows and modern whiteboards.", l1);
        rooms[1] = new HTWRoom("A 216b", "A computer lab with numerous workstations and quietly humming PCs.", l2);
        rooms[2] = new HTWRoom("A 238", "A large lecture hall with tiered seating and a projection screen.", l3);
        rooms[3] = new HTWRoom("Bibliothek", "The library - a quiet place full of bookshelves and reading areas.", l4);
        rooms[4] = new HTWRoom("D205", "A project room with tables grouped into work islands.", l5);
    }

    /**
     * Methode gibt an, ob das Spiel aktuell läuft.
     * @return gameRunning true, wenn Spiel läuft. false, wenn Spiel nicht läuft.
     * @author Taha Yildirim
     */
    public boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * setzt den Zustand, ob das Spiel momentan läuft.
     * @param gameRunning neuer Zustand des Spiels
     * @author Taha Yildirim
     */
    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    /**
     * Methode überprüft, ob das Spiel beendet wurde
     * @return gameFinished true, wenn Game beendet wurde. Andernfalls false.
     * @author Taha Yildirim
     */
    public boolean isGameFinished() {
        return gameFinished;
    }

    /**
     * Setter-Methode setzt das Beenden des Spiels
     * @param gameFinished true/false für Beenden des Spiels
     * @author Taha Yildirim
     */
    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    /**
     * Methode, welche das Spielmenü startet
     * Hier wird switch cases benutzt
     * dreiLeerz und typeEnter ist nur für Struktur und Zeiteffienz
     * @author Taha Yildirim
     * @author thanh
     */
    public void run() {
        Scanner scanner = EscapeApp.INPUT;

        while (gameRunning && !gameFinished) {
            dreiLeerZ();
            System.out.println("========================================");
            System.out.println("GAME MENU");
            System.out.println("========================================");
            System.out.println("What do you want to do next?");
            System.out.println("(1) Explore campus");
            System.out.println("(2) Show hero status");
            System.out.println(("(3) Show run sheet"));
            System.out.println("(4) Take a rest");
            System.out.println("(5) Leave game");
            System.out.println("");
            System.out.println("Please choose a number between 1 and 5: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    dreiLeerZ();
                    exploreCampus();
                    typeEnter();
                    break;
                case "2":
                    dreiLeerZ();
                    System.out.println("====== Hero Stats ======");
                    System.out.println("Name: " + hero.getName());
                    System.out.println("Healthpoints: " + hero.getHealthPoints());
                    System.out.println("Experiencepoints: " + hero.getExperiencePoints());
                    System.out.println("Current Round: " + r + "/" + rMax);
                    hero.getProgress();
                    typeEnter();
                    break;
                case "3":
                    dreiLeerZ();
                    hero.getProgress();
                    typeEnter();
                    break;
                case "4":
                    Scanner restOption = EscapeApp.INPUT;
                    dreiLeerZ();
                    System.out.println("====== Rest ======");
                    System.out.println("What do you want to do next?");
                    System.out.println("(1) Take a short rest (+3)");
                    System.out.println("*This option can be done once every round*");
                    System.out.println("");
                    System.out.println("(2) Take a long rest (+10)");
                    System.out.println("*This option will end the round*");
                    System.out.println("");
                    System.out.println("Please choose a number between 1 and 2: ");
                    String option = restOption.nextLine();

                    switch (option) {
                        case "1":
                            dreiLeerZ();
                            if (shortRestBenutzt == false) {
                                hero.regenerate(false);
                                System.out.println("====== You have restored 3 healthpoints ======");
                            } else {
                                System.out.println("====== You already used a short rest this round! ======");
                            }
                            typeEnter();
                            break;
                        case "2":
                            dreiLeerZ();
                            hero.regenerate(true);
                            r++;
                            shortRestBenutzt = false;
                            System.out.println("====== You have restored 10 healthpoints ======");
                            System.out.println("============= The round has ended =============");
                            System.out.println("Current round: " + r + "/" + rMax);

                            if (r >= rMax) {
                                System.out.println("====================================");
                                System.out.println("        TIME IS UP!");
                                System.out.println("====================================");
                                System.out.println("You failed to escape the HTW within 24 rounds.");
                                System.out.println("The professor boards her spaceship and flies away...");
                                System.out.println("        GAME OVER");
                                setGameFinished(true);
                                setGameRunning(false);
                            }
                            typeEnter();
                            break;
                        default:
                            System.out.println("Invalid input. Please choose a correct number between 1 and 2");
                            break;
                    }
                    break;
                case "5":
                    setGameRunning(false);
                    break;
                default:
                    System.out.println("Invalid input. Please choose a correct number between 1 and 5");
                    break;
            }
        }
    }

    /**
     * Getter Methode für hero
     * Gibt den Helden zurück.
     * @return hero Held
     * @author Taha Yildirim
     */
    public Hero getHero() {
        return hero;
    }

    /**
     * diese Methode erleichert für mich die Arbeit und Struktur
     * Automatisch werden für mich 3 Leer Zeilen hinzugefügt
     * @author thanh
     */
    public void dreiLeerZ() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    /**
     * diese Methode erleichert für mich die Arbeit und Struktur
     * Dem Spieler wird gefragt Enter zu drücken,
     * damit er erstmal lesen kann was passiert,
     * ohne direkt in das Spielmenü zu kommen
     * @author thanh
     */
    public void typeEnter() {
        dreiLeerZ();
        System.out.println("Press Enter to continue from the game menu");
        Scanner enter = EscapeApp.INPUT;
        enter.nextLine();
    }

    /**
     * Methode stellt dem Spieler eine Quiz-Frage basierend auf dem Lecturer
     * @param lecturer Der Lecturer, der die Frage stellt
     * @return true, wenn die Antwort korrekt war, sonst false
     * @author Taha Yildirim
     */
    private boolean askQuizQuestion(Lecturer lecturer) {
        Scanner scanner = EscapeApp.INPUT;
        String question = "";
        String correctAnswer = "";
        String[] options = new String[4];

        // Quiz-Fragen für jeden Lecturer
        if (lecturer.getName().equals("Kern, Ada")) {
            question = "What is the capital of Germany?";
            options[0] = "1) Berlin";
            options[1] = "2) Munich";
            options[2] = "3) Hamburg";
            options[3] = "4) Frankfurt";
            correctAnswer = "1";

        } else if (lecturer.getName().equals("Baum, Linus")) {
            question = "What does OOP stand for?";
            options[0] = "1) Object Oriented Programming";
            options[1] = "2) Only One Program";
            options[2] = "3) Optimal Output Process";
            options[3] = "4) Order Of Procedures";
            correctAnswer = "1";

        } else if (lecturer.getName().equals("Stein, Grace")) {
            question = "What is 7 * 8?";
            options[0] = "1) 54";
            options[1] = "2) 56";
            options[2] = "3) 64";
            options[3] = "4) 72";
            correctAnswer = "2";

        } else if (lecturer.getName().equals("Wolf, Alan")) {
            question = "Which data structure uses LIFO (Last In First Out)?";
            options[0] = "1) Queue";
            options[1] = "2) Array";
            options[2] = "3) Stack";
            options[3] = "4) LinkedList";
            correctAnswer = "3";

        } else if (lecturer.getName().equals("Lang, Dana")) {
            question = "What is the result of 2^10?";
            options[0] = "1) 512";
            options[1] = "2) 1024";
            options[2] = "3) 2048";
            options[3] = "4) 256";
            correctAnswer = "2";
        }

        // Quiz-Frage anzeigen
        System.out.println("========================================");
        System.out.println(lecturer.getName() + " asks you a question:");
        System.out.println("========================================");
        System.out.println(question);
        System.out.println("");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("");
        System.out.print("Your answer: ");

        String answer = scanner.nextLine().trim();

        // Antwort überprüfen
        if (answer.equals(correctAnswer)) {
            dreiLeerZ();
            System.out.println(">>> CORRECT! <<<");
            System.out.println(lecturer.getName() + " is impressed with your knowledge!");
            return true;
        } else {
            dreiLeerZ();
            System.out.println(">>> WRONG ANSWER! <<<");
            System.out.println(lecturer.getName() + " shakes their head in disappointment.");
            System.out.println("'" + lecturer.getName() + " will not sign your run sheet.'");
            System.out.println("You need to find them again and answer correctly!");
            return false;
        }
    }

    /**
     * Methode für das Erkunden der HTW
     * Hier passieren zufällige Ereignisse
     * @author thanh
     */
    private void exploreCampus() {
        Random rand = new Random();
        Scanner scanner = EscapeApp.INPUT;

        r++; // Runde erhöhen
        shortRestBenutzt = false; // Reset

        System.out.println("====== Exploring HTW Campus ======");
        System.out.println("Round: " + r + "/" + rMax);
        System.out.println("");

        int roomIndex = rand.nextInt(rooms.length);
        HTWRoom currentRoom = rooms[roomIndex];

        System.out.println("You enter room " + currentRoom.getIdentifier());
        System.out.println(currentRoom.getDescription());
        System.out.println("");

        int zuf = rand.nextInt(100);

        if (zuf < 20) {
            System.out.println("The room is quiet. Nothing unusual happens.");
            System.out.println("You continue your search for the exercise leaders...");

        } else if (zuf < 72) {
            System.out.println(">>> ALERT! An alien appears! <<<");
            System.out.println("");

            int alienTyp = rand.nextInt(2);
            Alien alien;

            if (alienTyp == 0) {
                alien = new Piccolo("Piccolo", 8, false, "Mwahahaha! A human!");
            } else {
                alien = new MikeGlotzkowsky("Mike", 15, true, "Hey! Do you need help?");
            }

            System.out.println("You encounter: " + alien.getName());
            System.out.println(alien.getGreetings());
            System.out.println("");

            if (alien.getIsFriendly()) {
                System.out.println(alien.getName() + " seems friendly!");
                if (alien instanceof MikeGlotzkowsky) {
                    ((MikeGlotzkowsky) alien).giveHealth(hero);
                    System.out.println(alien.getName() + " heals you. Your HP: " + hero.getHealthPoints());
                }

            } else {
                System.out.println(alien.getName() + " looks hostile!");
                System.out.println("Alien HP: " + alien.getLifePoints());
                System.out.println("");

                boolean kampf = true;

                while (kampf == true && alien.getLifePoints() > 0 && hero.getHealthPoints() > 0) {
                    System.out.println("What do you want to do?");
                    System.out.println("(1) Fight");
                    System.out.println("(2) Try to flee");
                    System.out.print("Choose: ");

                    String kampfWahl = scanner.nextLine();
                    boolean alienGreiftAn = false;

                    switch (kampfWahl) {
                        case "1":
                            int damage = hero.attack();
                            dreiLeerZ();
                            if (damage == 0) {
                                System.out.println("Your attack missed!");
                            } else if (alien instanceof Piccolo && ((Piccolo) alien).dodgesAttack()) {
                                System.out.println(alien.getName() + " dodged your attack!");
                            } else {
                                System.out.println("Your attack did " + damage);
                                alien.takeDamage(damage);
                            }
                            alienGreiftAn = true;
                            break;
                        case "2":
                            dreiLeerZ();
                            if (hero.flee() == true) {
                                System.out.println("You successfully escaped!");
                                kampf = false;
                            } else {
                                System.out.println("Escape failed! You have to fight " + alien.getName() + "!");
                                alienGreiftAn = true;
                            }
                            break;
                        default:
                            dreiLeerZ();
                            System.out.println("Invalid input. Please choose a correct number between 1 and 2");
                            break;
                    }

                    // Gegenangriff des Aliens, solange es noch lebt
                    if (alienGreiftAn && alien.getLifePoints() > 0 && alien instanceof Piccolo) {
                        double vorher = hero.getHealthPoints();
                        ((Piccolo) alien).specialBeamCannon(hero);
                        int schaden = (int) (vorher - hero.getHealthPoints());
                        System.out.println(alien.getName() + " hits you with the Special Beam Cannon! -" + schaden + " HP");
                        System.out.println("Your HP: " + hero.getHealthPoints());
                    }
                }

                if (alien.isDefeated()) {
                    dreiLeerZ();
                    System.out.println("Victory! You defeated " + alien.getName() + "!");
                    hero.addExperiencePoints(5);
                    System.out.println("+5 Experience Points!");
                } else if (hero.getHealthPoints() <= 0) {
                    dreiLeerZ();
                    System.out.println("You were defeated...");
                    hero.addExperiencePoints(1);
                    System.out.println("+1 Experience Point for trying.");
                }
            }

        } else {
            Lecturer lecturer = currentRoom.getLecturer();

            if (lecturer != null) {
                System.out.println(">>> You found an exercise leader! <<<");
                System.out.println("You meet: " + lecturer.getName());
                dreiLeerZ();

                if (lecturer.getHasSigned() == true) {
                    System.out.println(lecturer.getName() + " has already signed your run sheet.");
                } else if (lecturer.isReadyToSign() == true) {
                    System.out.println(lecturer.getName() + " is willing to sign, but first you must answer a question!");
                    dreiLeerZ();

                    // Quiz-Frage stellen
                    // @author Taha Yildirim
                    boolean correctAnswer = askQuizQuestion(lecturer);

                    if (correctAnswer) {
                        lecturer.sign();
                        hero.signExerciseLeader(lecturer);
                        dreiLeerZ();
                        System.out.println(">>> Signature received! <<<");

                        // Prüfe ob alle 5 Unterschriften gesammelt wurden
                        int signaturesCollected = 0;
                        for (HTWRoom room : rooms) {
                            if (room.getLecturer() != null && room.getLecturer().getHasSigned()) {
                                signaturesCollected++;
                            }
                        }

                        if (signaturesCollected == 5) {
                            dreiLeerZ();
                            System.out.println("========================================");
                            System.out.println("    🎉 CONGRATULATIONS! YOU WON! 🎉");
                            System.out.println("========================================");
                            System.out.println("You have collected all 5 signatures!");
                            System.out.println("You successfully escaped from HTW Berlin!");
                            System.out.println("Final Round: " + r + "/" + rMax);
                            System.out.println("Final Health: " + hero.getHealthPoints());
                            System.out.println("Final Experience: " + hero.getExperiencePoints());
                            System.out.println("========================================");
                            System.out.println("        GAME WON - WELL DONE!");
                            System.out.println("========================================");
                            setGameFinished(true);
                            setGameRunning(false);
                            return; // Beende die Methode sofort
                        }
                    }
                    // Bei falscher Antwort wird keine Unterschrift gegeben
                } else {
                    System.out.println(lecturer.getName() + " is not ready to sign yet.");
                    System.out.println("(You may need to complete a task first...)");
                }
            } else {
                System.out.println("You expected to find someone here, but the room is empty.");
            }
        }

        // @author thanh
        if (r >= rMax) {
            System.out.println("====================================");
            System.out.println("        TIME IS UP!");
            System.out.println("====================================");
            System.out.println("You failed to escape the HTW within 24 rounds.");
            System.out.println("The professor boards her spaceship and flies away...");
            System.out.println("        GAME OVER");
            setGameFinished(true);
            setGameRunning(false);
        }

        if (hero.isOperational() == false) {
            System.out.println("====================================");
            System.out.println("        GAME OVER");
            System.out.println("====================================");
            System.out.println("Your character has fallen...");
            setGameFinished(true);
            setGameRunning(false);
        }
    }
}