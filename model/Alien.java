package model;


/**
 * Attribute für Klasse "Alien" wird festgelegt
 * @author Taha Yildirim
 */
public class Alien {

    private String name;
    private double lifePoints = 20.00;
    private boolean isFriendly = false;
    private String greetings;

    /**
     * Konstruktoren für Name, Lebenspunkte, Freundlichkeit und Begrüßung
     * @param name Name
     * @param lifePoints Lebenspunkte
     * @param isFriendly Freundlichkeit
     * @param greetings Begrüßung
     * @author Taha Yildirim
     */
    public Alien(String name, double lifePoints, boolean isFriendly, String greetings) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.isFriendly = isFriendly;
        this.greetings = greetings;
    }

    /**
     * Methode, in der Alien Damage von seinen Lebenspunkten abgezogen kriegt
     * Bei 0 Lebenspunkten oder weniger durch den Ammount Lebenspunkte auf 0
     * @param amount Menge von Damage
     * @author Taha Yildirim
     */
    public void takeDamage(int amount) {
        lifePoints -= amount;

        if (lifePoints <= 0) {
            lifePoints = 0;
        }
        System.out.println("This Alien took " + amount + " damage. Remaining life points: " + lifePoints);
    }

    /**
     * Methode für Besiegen von Alien
     * @return true, wenn Alien Lebenspunkte auf 0, andernfalls false
     * @author Taha Yildirim
     */
    public boolean isDefeated() {
        if (lifePoints == 0 ) {
            System.out.println("This Alien is defeated");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Liest Name aus
     * @return name Name des Alien
     * @author Taha Yildirim
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt Name des Alien
     * @param name Name des Alien
     * @author Taha Yildirim
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Liest Lebenspunkte aus
     * @return lifePoints Lebenspunkte
     * @author Taha Yildirim
     */
    public double getLifePoints() {
        return lifePoints;
    }

    /**
     * Stezt Lebenspunkte
     * @param lifePoints Lebenspunkte
     * @author Taha Yildirim
     */
    public void setLifePoints(double lifePoints) {
        this.lifePoints = lifePoints;
    }

    /**
     * Liest Freundlichkeit aus
     * @return isFriendly ob Alien freundlich ist
     * @author Taha Yildirim
     */
    public boolean getIsFriendly() {
        return isFriendly;
    }

    /**
     * Setzt Freundlichkeit
     * @param isFriendly ob Alien freundlich ist
     * @author Taha Yildirim
     */
    public void setIsFriendly(boolean isFriendly) {
        this.isFriendly = isFriendly;
    }

    /**
     * Liest Begrüßung aus
     * @return greetings Begrüßung
     * @author Taha Yildirim
     */
    public String getGreetings() {
        return greetings;
    }

    /**
     * Setzt Begrüßung
     * @param greetings Begrüßung
     * @author Taha Yildirim
     */
    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }


    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 1729389822767173584L;
}
