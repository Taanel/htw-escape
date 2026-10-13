package model;

import java.io.Serializable;

/**
 * In dieser Methode werden die Attribute für Lecturer erstellt
 * @author Taha Yildirim
 */
public class Lecturer implements Serializable {
    private String name;
    private boolean hasSigned;

    /**
     * Methode bildet Konstruktoren für Namen der Lecturer und Unterschrift
     * @param name Name des Lecturers
     * @param hasSigned Unterschrift
     * @author Taha Yildirim
     *
     */
    public Lecturer(String name, boolean hasSigned) {
        this.name = name;
        this.hasSigned = hasSigned;
    }

    /**
     * Setter-Methode für Namen der Lecturer
     * @param name Name des Lecturers
     * @author Taha Yildirim
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter-Methode für Unterschrift
     * @param hasSigned Unterschrift
     * @author Taha Yildirim
     */
    public void setHasSigned(boolean hasSigned) {
        this.hasSigned = hasSigned;
    }

    /**
     * Getter-Methode für Name des Lecturers
     * @return name Name des Lecturers
     * @author Taha Yildirim
     */
    public String getName() {
        return name;
    }

    /**
     * Getter-Methode für die Unterschrift
     * @return hasSigned Unterschrift
     * @author Taha Yildirim
     */
    public boolean getHasSigned() {
        return hasSigned;
    }

    /**
     * Überprüft, ob der Lecturer überhaupt Unterschriften aushändigen kann.
     * @return hasSigned wenn false, dann hat Lecturer unterschrieben. Wenn true, dann hat Lecturer nicht unterschrieben
     * @author Taha Yildirim
     */
    public boolean isReadyToSign() {
        return !hasSigned;
    }

    /**
     * Ermöglicht, dass Lecturer Unterschrift aushändigt.
     * @author thanh
     */
    public boolean sign() {
        hasSigned = true;
        return hasSigned;
    }

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 540082607047283589L;
}