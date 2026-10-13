package model;


/**
 * Klasse für weiteren Alientyp "Mike Glotzkowsky"
 * @author Taha Yildirim
 */
public class MikeGlotzkowsky extends Alien {

    /**
     * Konstruktoren für Name, Lebenspunkte, Freundlichkeit und Begrüßung
     *
     * @param name       Name
     * @param lifePoints Lebenspunkte
     * @param isFriendly Freundlichkeit
     * @param greetings  Begrüßung
     * @author Taha Yildirim
     */
    public MikeGlotzkowsky(String name, double lifePoints, boolean isFriendly, String greetings) {
        super(name, lifePoints, isFriendly, greetings);
    }

    /**
     * Held kriegt durch Mike Glotzkowsky Leben
     * @param hero Held
     * @author Taha Yildirim
     */
    public void giveHealth(Hero hero) {
       double amount = 10;
       double newHealth = hero.getHealthPoints() + amount;


       if (newHealth > 50) {
           newHealth = 50;
       }

       hero.setHealthPoints(newHealth);
   }
}
