# Iron Minecarts (Kistenloren)

Fabric-Mod für Minecraft 26.3. Fügt Loren mit Kiste hinzu: Kupfer, Eisen, Gold, Diamant, Smaragd.
Die Slot-Anzahl entspricht immer der jeweiligen Iron-Chests-Kiste (auch bei geänderter `ironchest.json`).
Rezept (Werkbank, formlos): Iron-Chests-Kiste + Lore (Minecart).

## Bauen (empfohlen: GitHub Actions, nichts zu installieren)
1. In `gradle.properties` bei `fabric_api_version` die Version deiner Fabric API eintragen
   (steht im Dateinamen `fabric-api-<VERSION>.jar` im mods-Ordner deines Servers).
2. Neues GitHub-Repository anlegen und den Inhalt dieses Ordners hochladen (inkl. Ordner `libs` und `.github`).
3. Reiter "Actions" -> Workflow "build" -> abwarten -> unten bei "Artifacts" `ironminecarts` herunterladen.
4. Die Datei `ironminecarts-1.0.0.jar` (nicht die `-sources`) in den mods-Ordner von Server UND Clients legen.

## Lokal bauen
Java 25 + Gradle 9.8.1 installieren, im Projektordner `gradle build` ausführen. Jar liegt in `build/libs/`.

Hinweis: Die Dateien in `libs/` sind nur zum Kompilieren und stammen aus deinen Iron-Mods. Nicht weitergeben.
