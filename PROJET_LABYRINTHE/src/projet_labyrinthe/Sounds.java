package projet_labyrinthe;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.io.File;
import java.util.Random;

/**
 *
 * @author Ody
 */
public class Sounds implements LineListener {

    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
            // Lorsque la lecture est terminée, fermer le Clip
            clip.close();
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Clip clip;

    Random r = new Random();

    /**
     * Stopsound
     */
    public void stopsound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    /**
     * getter clip
     * @return clip value
     */
    public boolean getClipActive() {
        return clip.isActive();
    }

    
    
    /**
     * Methode qui permet de lire des fichiers audio en arriere plan
     *
     * @param name Le nom du fichier audio que l'on veut entendre
     */
    public void playsound(String name) {

        switch (name) {
            case "click" -> {
                try {

                    // Charger le fichier audio
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/sounds/click.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);

                    // Ajouter un écouteur pour détecter la fin de la lecture
                    clip.addLineListener(this);

                    // Lancer la lecture
                    clip.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            case "win" -> {
                try {

                    // Charger le fichier audio
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/sounds/win.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);

                    // Ajouter un écouteur pour détecter la fin de la lecture
                    clip.addLineListener(this);

                    // Lancer la lecture
                    clip.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            case "leave" -> {
                try {

                    // Charger le fichier audio
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/sounds/leave.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);

                    // Ajouter un écouteur pour détecter la fin de la lecture
                    clip.addLineListener(this);

                    // Lancer la lecture
                    clip.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            case "music" -> {
                int random = r.nextInt(3);
                switch (random) {
                    case 0 -> {
                        try {
                            // Charger le fichier audio
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/music/ambient1.wav"));
                            clip = AudioSystem.getClip();
                            clip.open(audioInputStream);

                            // Ajouter un écouteur pour détecter la fin de la lecture
                            clip.addLineListener(this);

                            // Lancer la lecture
                            clip.start();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    case 1 -> {
                        try {
                            // Charger le fichier audio
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/music/ambient2.wav"));
                            clip = AudioSystem.getClip();
                            clip.open(audioInputStream);

                            // Ajouter un écouteur pour détecter la fin de la lecture
                            clip.addLineListener(this);

                            // Lancer la lecture
                            clip.start();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    case 2 -> {
                        try {
                            // Charger le fichier audio
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./src/music/ambient3.wav"));
                            clip = AudioSystem.getClip();
                            clip.open(audioInputStream);

                            // Ajouter un écouteur pour détecter la fin de la lecture
                            clip.addLineListener(this);

                            // Lancer la lecture
                            clip.start();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }

    }

}
