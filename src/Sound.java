import java.util.*;
import javax.sound.sampled.*;
import java.io.*;

public class Sound
{
    public static Map<String, Clip> sounds;
    
    public static void init()
    {
       sounds = new HashMap<String, Clip>();
    }
    
    public static void addSound(String[] keys, String[] locs)
    {
        for(int i = 0; i < keys.length; i++)
        {
            /*try
            {
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(locs[i]));
                //AudioFormat format = inputStream.getFormat();
                //DataLine.Info info = new DataLine.Info(Clip.class, format);
                Clip c = AudioSystem.getClip();
                c.open(inputStream);
                sounds.put(keys[i], c);
                //sounds.put(keys[i], (Clip)AudioSystem.getLine(info);
                //clip.open(inputStream);
                //clip.start();
            } catch (Exception e) {
                    System.err.println(e.getMessage());
            }*/
            
            try {
                File file = new File(locs[i]);
                if (file.exists()) {
                    Clip myClip = AudioSystem.getClip();
                    AudioInputStream ais = AudioSystem.getAudioInputStream(file.toURI().toURL());
                    myClip.open(ais);
                    sounds.put(keys[i], myClip);
                }
                else {
                    throw new RuntimeException("Sound: file not found: " + locs[i]);
                }
            } catch(Exception e) { e.printStackTrace(); }
        }
    }
    
    public static void addSound(String keys, String locs)
    {

            /*try
            {
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(locs));
                //AudioFormat format = inputStream.getFormat();
                //DataLine.Info info = new DataLine.Info(Clip.class, format);
                Clip c = AudioSystem.getClip();
                c.open(inputStream);
                sounds.put(keys, c);
                //sounds.put(keys[i], (Clip)AudioSystem.getLine(info);
                //clip.open(inputStream);
                //clip.start();
            } catch (Exception e) {
                    System.err.println(e.getMessage());
            }*/
        try {
            File file = new File(locs);
            if (file.exists()) {
                Clip myClip = AudioSystem.getClip();
                AudioInputStream ais = AudioSystem.getAudioInputStream(file.toURI().toURL());
                myClip.open(ais);
                sounds.put(keys, myClip);
            }
            else {
                throw new RuntimeException("Sound: file not found: " + locs);
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    public static void play(String key)
    {
        Clip target = sounds.get(key);
        
        target.stop();
        target.setFramePosition(0);
        target.loop(0);
        target.start();
    }
}
