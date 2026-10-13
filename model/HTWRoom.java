package model;

import java.io.Serializable;

/**
 * hier werden die Attribute der Klasse HTWRoom festgelegt
 * @author thanh
 */
public class HTWRoom implements Serializable {
    private String identifier;
    private String description;
    private Lecturer lecturer;

    /**
     * Konstruktor für die Attribute
     * @param identifier
     * @param description
     * @param lecturer
     * @author Thanh
     */
    public HTWRoom(String identifier, String description, Lecturer lecturer) {
        this.identifier = identifier;
        this.description = description;
        this.lecturer = lecturer;
    }

    /**
     * getter Methode
     * @return identifier
     * @author thanh
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * getter Methode
     * @return description
     * @author thanh
     */
    public String getDescription() {
        return description;
    }

    /**
     * getter Methode
     * @return lecturer
     * @author thanh
     */
    public Lecturer getLecturer() {
        return lecturer;
    }


    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 9065680017147292999L;
}
