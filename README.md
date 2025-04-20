# IU-Kochbuch

Ich habe jetzt schon mal ein System über spring initializr aufgesetzt
Habe auch direkt eine gitignore aufgesetzt, damit unwichtige Dateien nicht hier im Repository landen. 
Schon mal als Information, dass System wird über Eclipse (Version: 2024-09) entwickelt
Es läuft auf der Java JDK 21

## Erster Schritt

Es wäre jetzt eure Aufgabe, jetzt euch mal den Stuss hier zu ziehen. 
Dafür führt bitte im gewünschten Ordner im Terminal diesen Befehl aus:

```bash
git clone https://github.com/TietoLP/IU-Kochbuch.git
```

Ich würde euch außerdem bitten, einen **GitHub-Account** zu erstellen, da es euch einfacher macht, Commits zu erstellen und Änderungen hochzuladen.

---

## Kurze Erklärung zu Git

**Git** ist ein Versionskontrollsystem, das uns hilft, alle Änderungen an unseren Dateien nachzuvollziehen.
Damit können wir immer alle versionen tracken und im notfall zu einer alten Version leichter zurückkommen.

---

## Wichtige Git-Befehle

Hier eine Übersicht der wichtigsten Git-Befehle, die wir im Projekt verwenden werden:

### 1. **Dateien zum Commit hinzufügen**
- **`git add "Dateiname"`**  
  Fügt eine spezifische Datei zu deinem nächsten Commit hinzu.

- **`git add .`**  
  Fügt **alle** geänderten Dateien zu deinem Commit hinzu.

### 2. **Neuesten Stand vom Repository holen**
- **`git pull`**  
  Lädt die neuesten Änderungen vom Remote-Repository herunter. Ich empfehle, diesen Befehl zu verwenden, bevor ihr anfangt zu arbeiten.

### 3. **Status anzeigen**
- **`git status`**  
  Zeigt an, auf welchem Branch du dich befindest und ob du die neueste Version des Projekts hast.

### 4. **Änderungen speichern**
- **`git commit -m "Kommentar"`**  
  Speichert die Änderungen mit einer kurzen Beschreibung (z.B. „Füge Login-Feature hinzu“).

### 5. **Änderungen hochladen**
- **`git push`**  
  Sendet deine lokalen Änderungen an das Remote-Repository (z.B. GitHub).

---

## Branching

### 6. **Neuen Branch erstellen und wechseln**
- **`git checkout -b neuer-branchname`**  
  Erstellt einen neuen Branch und wechselt sofort zu diesem. Dieser Befehl wird oft verwendet, damit wir niemals unfertige Features direkt auf den `main`-Branch committen.

**Beispiel:**  
```bash
git checkout -b feature_Login
```

Damit weiß jeder sofort, dass du an einem Login-Feature arbeitest.

### 7. **Branch wechseln**
- **`git checkout branchname`**  
  Wechselt zu einem bestehenden Branch, ohne einen neuen zu erstellen.

---

## Zusammenfassung der wichtigsten Befehle

| Befehl                        | Bedeutung                                                      |
|-------------------------------|----------------------------------------------------------------|
| `git add .`                    | Fügt alle Änderungen zur Versionierung hinzu                  |
| `git commit -m "Kommentar"`    | Speichert die Änderungen mit einer Nachricht                  |
| `git push`                     | Überträgt die Änderungen ins Remote-Repository                |
| `git pull`                     | Holt die neuesten Änderungen aus dem Remote-Repository        |
| `git checkout -b branchname`   | Erstellt einen neuen Branch und wechselt sofort darauf        |
| `git checkout branchname`      | Wechselt zu einem bestehenden Branch                         |

---

