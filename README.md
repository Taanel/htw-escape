# HTW Escape

Konsolenbasiertes Escape-Spiel in Java. Entstanden im Zweierteam als Programmierprojekt im Modul „Grundlagen der Programmierung“ (1. Semester Wirtschaftsinformatik, HTW Berlin, Wintersemester 2025/26).

## Worum geht es?

Der Held ist in der HTW eingeschlossen und hat 24 Runden Zeit, um die Unterschriften von fünf Lehrenden auf seinem Laufzettel zu sammeln. Beim Erkunden des Campus passiert zufällig eines von drei Dingen:

- Der Raum ist leer.
- Ein Alien taucht auf. Freundliche Aliens heilen den Helden, gegen feindliche kann man kämpfen oder fliehen.
- Eine Lehrkraft stellt eine Quizfrage. Bei richtiger Antwort gibt es die Unterschrift.

Zwischendurch kann der Held rasten, um Lebenspunkte zurückzugewinnen. Der Spielstand lässt sich speichern, laden und löschen.

## Starten

Voraussetzung ist ein installiertes JDK (Version 17 oder neuer).

```bash
javac -d out app/*.java model/*.java
java -cp out app.EscapeApp
```

## Aufbau

| Datei | Aufgabe |
|---|---|
| `app/EscapeApp.java` | Hauptmenü, Speichern, Laden und Löschen des Spielstands |
| `app/EscapeGame.java` | Spielmenü, Rundenzähler, Erkunden, Kampf und Quiz |
| `model/Hero.java` | Spielfigur mit Lebens- und Erfahrungspunkten und Laufzettel |
| `model/Alien.java` | Basisklasse für Aliens |
| `model/Piccolo.java`, `model/MikeGlotzkowsky.java` | Feindliches und freundliches Alien (erben von `Alien`) |
| `model/HTWRoom.java`, `model/Lecturer.java` | Räume und Lehrende |
| `docs/Spielablauf.txt` | Unser Spielentwurf aus der Planungsphase |

## Was wir dabei gelernt haben

- Objektorientierung mit eigenen Klassen und Vererbung
- Zustände eines Programms über Menüs steuern und Eingaben prüfen
- Spielstand mit Java-Serialisierung speichern und laden
- Zusammenarbeit über Git und GitHub mit festen Abgabefristen

## Team

Thanh Lindemann und Taha Yildirim. Wer welche Methode geschrieben hat, steht jeweils im `@author`-Kommentar.

## Hinweise

- Der Stand entspricht der Abgabe vom Januar 2026. Für die Veröffentlichung wurde der Code aufgeräumt, und einige Fehler wurden behoben (unter anderem der Menüpunkt „Quit“ und der Gegenangriff der Aliens).
- Die Namen der Lehrenden im Spiel sind frei erfunden.
- Das Grundgerüst stammt aus dem Startercode des Kurses und steht unter der Apache-Lizenz 2.0 (siehe `LICENSE`).
