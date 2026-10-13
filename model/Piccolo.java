package model;

import java.util.Random;

/**
 * Kinderklasse für weiteren Alientyp "Piccolo"
 * @author Taha Yildirim
 */
public class Piccolo extends Alien {
    /**
     * Konstruktoren für Name, Lebenspunkte, Freundlichkeit und Begrüßung
     *
     * @param name       Name
     * @param lifePoints Lebenspunkte
     * @param isFriendly Freundlichkeit
     * @param greetings  Begrüßung
     * @author Taha Yildirim
     */
    public Piccolo(String name, double lifePoints, boolean isFriendly, String greetings) {
        super(name, lifePoints, isFriendly, greetings);
    }

    /**
     * Methode, in der Piccolo Attacken entweichen kann
     * @return true, wenn er zu 20% auswicht, andernfalls false
     * @author Taha Yildirim
     */
   public boolean dodgesAttack() {
        Random rand = new Random();
        int zuf = rand.nextInt(100);

        if (zuf < 20) {
           return true;
        } else {
            return false;
        }
    }

    /**
     * Methode für Piccolos Spezialangriff "Special Beam Cannon"
     * @author Taha Yildirim
     */
    public void specialBeamCannon(Hero hero) {
        Random rand = new Random();
        double zuf = rand.nextDouble(100);
        double damage = 2.0;

        if (zuf < 16.66) {
            damage = 4.0;
        }
        hero.takeDamage((int) damage);
    }
}