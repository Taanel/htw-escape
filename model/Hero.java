package model;

import java.util.Random;
import java.io.Serializable;

/**
 * Hier werden die Attribute für die Klasse Hero festgelegt
 * @author thanh
 */
public class Hero implements Serializable {
    private String name;
    private double healthPoints;
    private int experiencePoints;
    private Lecturer[] signedExerciseLeaders;

    /**
     * Konstruktoren für den Helden, Lebenspunkte, Erfahrungspunkte und Initialisierung Lecturer
     * @param   name Name des Helden
     * @param   healthPoints Lebenspunkte des Helden
     * @param   experiencePoints Erfahrungspunkte des Helden
     * @author  Taha Yildirim
     * @author  thanh
     */
    public Hero(String name, int healthPoints, int experiencePoints, Lecturer[] signedExerciseLeaders) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.experiencePoints = experiencePoints;
        this.signedExerciseLeaders = signedExerciseLeaders;
    }


    /**
     * Methode, in der Schaden die Lebenspunkte des Helden verringert und auf Null bringen kann
     * @param   amount Menge des Schaden
     * @author  Taha Yildirim
     * @author  thanh
     */
    public void takeDamage(int amount) {
        healthPoints -= amount;
        if (healthPoints <= 0) {
            healthPoints = 0;
        }
    }

    /**
     * Methode für längere Pause, in der Lebenspunkte sich um 3 oder 10 Punkte erhöhen kann
     * Setzt eine Grenze von Maximal 50 Lebenspunkten
     * @param   longRest längere Pause
     * @author  Taha Yildirim
     * Vereinfachung des longrest statement
     * @author thanh
     */
    public void regenerate(boolean longRest) {
        healthPoints += longRest ? 10 : 3;
        if (healthPoints > 50) {
            healthPoints = 50;
        }
    }

    /**
     * Methode für Flüchten vor Alien
     * @return true, wenn Held zu 42% flüchten kann. Andernfalls false
     * @author Taha Yildirim
     * @author thanh
     */
    public boolean flee() {
        Random rand = new Random();
        int zuf = rand.nextInt(100);

        if (zuf < 42) {
            return true;
        }  else {
            return false;
        }
    }

    /**
     * Methode für Attacke des Spielers
     * @return  baseDamage Schaden bei gewöhnlichen Angriffen
     * @return  baseDamage doppelter Angriffsschaden bei einer Chance von 15%
     * @return  0          Verfehlen des Angriffes bei einer Chance von 13%
     * @author Taha Yildirim
     * @author thanh
     */
    public int attack () {
        Random rand = new Random();
        int zuf = rand.nextInt(100);

        int baseDamage = (int) (experiencePoints * 2.3 + 1);

        if  (zuf < 13) {
            return 0;
        }
        else if (zuf < 25) {
            baseDamage = baseDamage * 2;
            return baseDamage;
        } else {
            return baseDamage;
        }
    }

    /**
     * hier wird in dem array überprüft, ob welcher index schon ein elemnt hat
     * und dann wird der leere Platz in dem Array mit der Unterschrift des Profs ersetzt
     * @param lecturer
     * @author thanh
     */
    public void signExerciseLeader(Lecturer lecturer) {
        for (int i = 0; i < signedExerciseLeaders.length; i++) {
            if (signedExerciseLeaders[i] == null) {
                signedExerciseLeaders[i] = lecturer;
                break;
            }
        }
    }

    /**
     * Hier wird der Fortschritt des Spielers angezeigt
     * genauer gesagt wie viel von wie vielen Unterschriften hat er schon
     * @author thanh
     */
    public void getProgress() {
        System.out.println("Collected Signature: ");
        int signatureCount = 0;
        for (int i = 0; i < signedExerciseLeaders.length; i++) {
            if (signedExerciseLeaders[i] != null) {
                System.out.println("- " + signedExerciseLeaders[i].getName());
                signatureCount++;
            }
        }
        if (signatureCount == 0) {
            System.out.println("You have no signatures yet.");
        }
        System.out.println("Total: " + signatureCount + "/5");
    }

    /**
     * getter Methode, um den Namen zu erfahren
     * @return Name
     * @author thanh
     */
    public String getName() {
        return name;
    }

    /**
     * Setter Methode, um den Namen zu ersetzen / verändern
     * @param name
     * @author thanh
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter Methode, um die momentane Lebenspunkte zu erfahren
     * @return momentan vorhandene Lebenspunkte
     * @author thanh
     */
    public double getHealthPoints() {
        return healthPoints;
    }

    /**
     * Setter Methode, um die momentane Lebenspunkte zu ersetzen / verändern
     * @param healthPoints
     * @author thanh
     */
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * eine getter Methode, um die momentane Erfarungspunkte zu erfahren
     * @return momentan vorhandene Erfahrungspunkte
     * @author thanh
     */
    public int getExperiencePoints() {
        return experiencePoints;
    }

    /**
     * Setter Methode, um die momentane Erfarungspunkte zu ersetzen / verändern
     * @param experiencePoints
     * @author thanh
     */
    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    /**
     * hier wird geprüft, ob der Spieler weiter spielen kann
     * es wird verglichen ob der Spieler <= 0 healthPoints hat
     * @author thanh
     */
    public boolean isOperational() {
        if (healthPoints <= 0) {
            System.out.println("Your character just died. Game Over.");
            return false;
        }
        return true;
    }

    /**
     * hier wird die vorhandenen Erfahrungspunkte mit x addiert
     * @param experiencePoints das sind die momentanen Erfahrungspunkte
     * @author thanh
     */
    public void addExperiencePoints(int experiencePoints) {
        this.experiencePoints += experiencePoints;
    }

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 3578735620108186013L;
}