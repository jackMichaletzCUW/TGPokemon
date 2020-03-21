import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class panel extends JPanel implements KeyListener
{
  Font poke;
  Font pokeb;
  
  Random randx = new Random();
  
  Icon bg;
  Icon bgd;
  Icon bgdb;
  Icon bgdn;
  Icon bg1;
  Icon tg;
  Icon bg2;
  Icon arrow;
  Icon tgcolor;
  Icon ms;
  Icon[] bar = new ImageIcon[2];
  
  String[] attacks = new String[22];
  String[] loc = new String[22];
  
  String entry = "";
  String lose = "";
  String win = "";
  String runs = "";
  String bgm = "";
  
	int whichAttack = 0;
	
  String[] tgdada = new String[8];
  
  String currentAttack = "";
  
  boolean crd = false;
  
  int[] attackStrength = new int[22];
  int[] buffer = new int[4];
  int count;
  int arrowPositDiag = 0;
  double health = 100;
  double ehealth = 100;
  int aNum = 0;
  int aCount = 0;
  int eCount = 0;
  int decount = 0;
  int fecount = 0;
  int wait = 0;
  int rCount = 0;
  
  boolean[] used = new boolean[22];
  boolean eAttacking = false;
  boolean isMSAppear = false;
  boolean isDiag = false;
  boolean isFight = false;
  boolean isItem = false;
  boolean isRun = false;
  boolean atPrompt = false;
  boolean attacking = false;
  
  boolean mallSanta = false;
	
  String msText = "MALL SANTA";
	
  Timer t;
  Timer fps;
  
  public panel(boolean censored, boolean emerald)
  {
	crd = censored;
  
	if(Math.random() < 0.5)
	{
		mallSanta = false;
		msText = "ANGRY JANITOR";
	}
	else
	{
		mallSanta = true;
		msText = "MALL SANTA";
	}

	  
	if(emerald)
	{
		bgm = "background-e.wav";
	}
	else
	{
		bgm = "background.wav";
	}
  
    buffer[0] = 0;
    buffer[1] = 0;
    buffer[2] = 0;
    buffer[3] = 0;
    
	if(!censored)
	{
		attacks[0] = "Buttfuck!";
		attacks[1] = "Bob Saget!";
		attacks[2] = "Go count your dick!";
		attacks[3] = "PISS!";
		attacks[4] = "Fuck you in the ASS!";
		attacks[5] = "Lick my balls!";
		attacks[6] = "ROAR!";
		attacks[7] = "gr-uh!";
		attacks[8] = "Men's Asses!";
		attacks[9] = "Eat my short dick!";
		attacks[10] = "ASS! ASS! ASS!";
		attacks[11] = "You go to hell!";
		attacks[12] = "You have balls!";
		attacks[13] = "Fuck you kid, you're a dick!";
		attacks[14] = "Quit it!";
		attacks[15] = "SHUT UP!";
		attacks[16] = "Mortal dickhead!";
		attacks[17] = "God dammit!";
		attacks[18] = "Fuck you, there's a fly in here!";
		attacks[19] = "My ass!";
		attacks[20] = "Fuck you!";
		attacks[21] = "Quit bullshitting!";
		
		//attacks[16] = "Fuck the Philippines!";
		
		loc[0] = "butt.wav";
		loc[1] = "ohbs.wav";
		loc[2] = "countit.wav";
		loc[3] = "piss.wav";
		loc[4] = "tgfufufua.wav";
		loc[5] = "lickit.wav";
		loc[6] = "uhh.wav";
		loc[7] = "groan.wav";
		loc[8] = "mensa.wav";
		loc[9] = "eatit.wav";
		loc[10] = "tripleass.wav";
		loc[11] = "gth.wav";
		loc[12] = "balls.wav";
		loc[13] = "fukid.wav";
		loc[14] = "qi.wav";
		loc[15] = "shutup.wav";
		loc[16] = "mdh.wav";
		loc[17] = "gd.wav";
		loc[18] = "fufly.wav";
		loc[19] = "myass.wav";
		loc[20] = "fu.wav";
		loc[21] = "quitbsing.wav";
		
		if(mallSanta)
		{
			entry = "tgdadtalkshit.wav";
			win = "tgdadhateshit.wav";
		}
		else
		{
			entry = "aj_entry.wav";
			//entry = "piss.wav";
			win = "aj_defeat.wav";
		}

		
		lose = "hitdick.wav";
		runs = "tgdadcomebackhere.wav";
		
		if(mallSanta)
		{
			tgdada[0] = "tgdadfu.wav";
			tgdada[1] = "tgdadgdshit.wav";
			tgdada[2] = "tgdadguh.wav";
			tgdada[3] = "tgdadfphil.wav";
			tgdada[4] = "tgdadf911.wav";
			tgdada[5] = "tgdadfuall.wav";
			tgdada[6] = "tgdadof.wav";
			tgdada[7] = "tgdadwthts.wav";
		}
		else
		{
			tgdada[0] = "aj_shithorse.wav";
			tgdada[1] = "aj_wannasee.wav";
			tgdada[2] = "aj_wannaseebig.wav";
			tgdada[3] = "aj_whobeen.wav";
			tgdada[4] = "aj_shithorse.wav";
			tgdada[5] = "aj_wannasee.wav";
			tgdada[6] = "aj_wannaseebig.wav";
			tgdada[7] = "aj_whobeen.wav";
		}

	}
	else
	{
		attacks[0] = "Buttf-ck!";
		attacks[1] = "Bob Saget!";
		attacks[2] = "Go count your dick!";
		attacks[3] = "PISS!";
		attacks[4] = "F-ck you in the ass!";
		attacks[5] = "Lick my balls!";
		attacks[6] = "ROAR!";
		attacks[7] = "gr-uh!";
		attacks[8] = "Men's asses!";
		attacks[9] = "Eat my short dick!";
		attacks[10] = "ASS! ASS! ASS!";
		attacks[11] = "You go to hell!";
		attacks[12] = "You have balls!";
		attacks[13] = "F-ck you kid, you're a dick!";
		attacks[14] = "Quit it!";
		attacks[15] = "SHUT UP!";
		attacks[16] = "Mortal dickhead!";
		attacks[17] = "God dammit!";
		attacks[18] = "F-ck you, there's a fly in here!";
		attacks[19] = "My ass!";
		attacks[20] = "F-ck you!";
		attacks[21] = "Quit bullsh-tting!";
		
		loc[0] = "zbutt.wav";
		loc[1] = "ohbs.wav";
		loc[2] = "countit.wav";
		loc[3] = "piss.wav";
		loc[4] = "ztgfufufua.wav";
		loc[5] = "lickit.wav";
		loc[6] = "uhh.wav";
		loc[7] = "groan.wav";
		loc[8] = "mensa.wav";
		loc[9] = "eatit.wav";
		loc[10] = "tripleass.wav";
		loc[11] = "gth.wav";
		loc[12] = "balls.wav";
		loc[13] = "zfukid.wav";
		loc[14] = "qi.wav";
		loc[15] = "shutup.wav";
		loc[16] = "mdh.wav";
		loc[17] = "gd.wav";
		loc[18] = "zfufly.wav";
		loc[19] = "myass.wav";
		loc[20] = "zfu.wav";
		loc[21] = "zquitbsing.wav";
		
		if(mallSanta)
		{
			entry = "ztgdadtalkshit.wav";
			win = "ztgdadhateshit.wav";
		}
		else
		{
			entry = "zaj_entry.wav";
			win = "zaj_defeat.wav";
		}

		lose = "zhitdick.wav";
		runs = "tgdadcomebackhere.wav";
		
		if(mallSanta)
		{
			tgdada[0] = "ztgdadfu.wav";
			tgdada[1] = "ztgdadgdshit.wav";
			tgdada[2] = "tgdadguh.wav";
			tgdada[3] = "ztgdadfphil.wav";
			tgdada[4] = "ztgdadf911.wav";
			tgdada[5] = "ztgdadfuall.wav";
			tgdada[6] = "ztgdadof.wav";
			tgdada[7] = "ztgdadwthts.wav";
		}
		else
		{
			tgdada[0] = "zaj_shithorse.wav";
			tgdada[1] = "zaj_wannasee.wav";
			tgdada[2] = "zaj_wannaseebig.wav";
			tgdada[3] = "zaj_whobeen.wav";
			tgdada[4] = "zaj_shithorse.wav";
			tgdada[5] = "zaj_wannasee.wav";
			tgdada[6] = "zaj_wannaseebig.wav";
			tgdada[7] = "zaj_whobeen.wav";
		}
	}
	
	//loc[16] = "tgfphil.wav";
    
    //attackStrength[0] = 30;
    //attackStrength[1] = 15;
    //attackStrength[2] = 20;
    //attackStrength[3] = 10;
    //attackStrength[4] = 13;
    //attackStrength[5] = 9;
    //attackStrength[6] = 5;
    //attackStrength[7] = 8;
    //attackStrength[8] = 12;
    //attackStrength[9] = 25;
    //attackStrength[10] = 10;
    //attackStrength[11] = 4;
    //attackStrength[12] = 10;
    //attackStrength[13] = 23;
    //attackStrength[14] = 3;
    //attackStrength[15] = 16;
    
    attackStrength[0] = 10 + randx.nextInt(10);
    attackStrength[1] = 3 + randx.nextInt(13);
    attackStrength[2] = 8 + randx.nextInt(3);
    attackStrength[3] = 10 + randx.nextInt(10);
    attackStrength[4] = 8 + randx.nextInt(5);
    attackStrength[5] = 8 + randx.nextInt(3);
    attackStrength[6] = 3 + randx.nextInt(5);
    attackStrength[7] = 3 + randx.nextInt(8);
    attackStrength[8] = 3 + randx.nextInt(13);
    attackStrength[9] = 13 + randx.nextInt(8);
    attackStrength[10] = 3 + randx.nextInt(8);
    attackStrength[11] = 3 + randx.nextInt(5);
    attackStrength[12] = 3 + randx.nextInt(10);
    attackStrength[13] = 5 + randx.nextInt(10);
    attackStrength[14] = 3 + randx.nextInt(5);
    attackStrength[15] = 3 + randx.nextInt(10);
	attackStrength[16] = 3 + randx.nextInt(10);
    attackStrength[17] = 3 + randx.nextInt(13);
    attackStrength[18] = 3 + randx.nextInt(10);
    attackStrength[19] = 3 + randx.nextInt(8);
    attackStrength[20] = 3 + randx.nextInt(15);
    attackStrength[21] = 5 + randx.nextInt(8);
    
	
    for(int i = 0; i < 16; i++)
    {
      used[i] = false;
    }
    
    
    count = 0;
    poke = new Font("Pokemon GB", Font.PLAIN, 16);
    pokeb = new Font("Pokemon GB", Font.BOLD, 16);
    
    tg = new ImageIcon(getClass().getResource("tg.png"));
    bg = new ImageIcon(getClass().getResource("wild.jpg"));
    bgd = new ImageIcon(getClass().getResource("wilddiag.jpg"));
    bgdb = new ImageIcon(getClass().getResource("wildblur.png"));
    bgdn = new ImageIcon(getClass().getResource("wildneg.png"));
    bg1 = new ImageIcon(getClass().getResource("wild1.png"));
    bg2 = new ImageIcon(getClass().getResource("wild2.png"));
    arrow = new ImageIcon(getClass().getResource("arrow.jpg"));
	  
	if(mallSanta)
	{
		ms = new ImageIcon(getClass().getResource("ms.png"));
	}
	else
	{
		ms = new ImageIcon(getClass().getResource("aj.png"));
	}

    tgcolor = new ImageIcon(getClass().getResource("tgcolor.png"));
    
    bar[0] = new ImageIcon(getClass().getResource("barright.jpg"));
    bar[1] = new ImageIcon(getClass().getResource("barleft.jpg"));
       // this.addKeyListener(this);
        
        start();
        
        try
    {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(bgm));
            clip.open(inputStream);
            clip.loop(clip.LOOP_CONTINUOUSLY);
            
          } catch (Exception e) {
            System.err.println(e.getMessage());
      }
  }
  
  public void start()
  {
	//100
    t = new javax.swing.Timer(100, new TimerHandler());
    //50
	fps = new javax.swing.Timer(50, new fpshand());
    
    t.start();
    fps.start();
  }
  
  public void attack(int attackNum)
  {
    aNum = attackNum;
    attacking = true;
	
	currentAttack = attacks[buffer[attackNum]];
    
    used[buffer[attackNum]] = true;
    
    try
    {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(loc[buffer[attackNum]]));
            clip.open(inputStream);
            clip.start(); 
          } catch (Exception e) {
            System.err.println(e.getMessage());
      }

  }
  
  public void paintComponent(Graphics g)
  {
	super.paintComponent(g);
  
    if(health > 0.0)
    {
      if(eAttacking)
      {
        isDiag = true;
        eCount++;
      }
      
      if(!isDiag)
      {
        bg.paintIcon(this, g, 0, 0);
      }
      else
      {
        atPrompt = true;
        bgd.paintIcon(this, g, 0, 0);
      }
      
      g.setFont(new Font("Pokemon GB", Font.PLAIN, 24));   
      
      g.setColor(Color.BLACK);
      
      tg.paintIcon(this, g, 25, 150);
      
      //Draw hp levels and such
      bar[0].paintIcon(this, g, 15, 50);
      bar[1].paintIcon(this, g, 300, 300);
      
      g.drawString(msText, 30, 50);
      g.drawString("DANNY", 400, 275);
      
      g.setFont(pokeb);
      
      g.drawString("HP:", 50, 105);
      g.drawString("HP:", 350, 315);
      
      g.setColor(Color.BLUE);
      
      g.fillRect(100, 90, (int)(ehealth * 2), 15);
      g.fillRect(400, 300, (int)(health * 2), 15);
      
      g.setColor(Color.BLACK);
      
      g.drawString(String.format("%d/100", (int)health), 450, 350);
      g.drawString(String.format("%d/100", (int)ehealth), 150, 75);
      
      if(isMSAppear == true)
      {
        if(isDiag != true && isFight != true && isItem != true && isRun != true)
        {
          g.drawString("A  wild " + msText + "\n appeared!", 50, 450);
          arrow.paintIcon(this, g, 575, 525);
          atPrompt = true;
        }
        else if(isDiag == true)
        {
          atPrompt = true;
          
          if(arrowPositDiag == 0)
          {
            arrow.paintIcon(this, g, 340, 435);
          }
          else if(arrowPositDiag == 1)
          {
            arrow.paintIcon(this, g, 340, 490);
          }
          else if(arrowPositDiag == 2)
          {
            arrow.paintIcon(this, g, 465, 490);
          }
        }
        else if(isFight == true)
        {
          atPrompt = true;
          
          g.drawString(attacks[buffer[0]], 75, 435);
          g.drawString(attacks[buffer[1]], 75, 465);
          g.drawString(attacks[buffer[2]], 75, 490);
          g.drawString(attacks[buffer[3]], 75, 515);
          
          //g.drawString(String.format("%d" ,attackStrength[buffer[0]]), 550, 435);
          //g.drawString(String.format("%d" ,attackStrength[buffer[1]]), 550, 465);
          //g.drawString(String.format("%d" ,attackStrength[buffer[2]]), 550, 490);
          //g.drawString(String.format("%d" ,attackStrength[buffer[3]]), 550, 515);
  
          if(arrowPositDiag == 0)
          {
            arrow.paintIcon(this, g, 50, 420);
          }
          else if(arrowPositDiag == 1)
          {
            arrow.paintIcon(this, g, 50, 450);
          }
          else if(arrowPositDiag == 2)
          {
            arrow.paintIcon(this, g, 50, 475);
          }
          else if(arrowPositDiag == 3)
          {
            arrow.paintIcon(this, g, 50, 500);
          }
        }
		else if(isRun == true)
		{
			
			if(rCount == 0)
			{
				try
				{
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(runs));
					clip.open(inputStream);
					clip.start();
					
				  } catch (Exception efse) {
					System.err.println(efse.getMessage());
				}
			}
			else if(rCount == 20)
			{
				isRun = false;
				isDiag = false;
				rCount = -1;
			}
			else if(rCount % 2 == 0)
			{
				g.drawString("There is no running from a", 50, 450);
				g.drawString(" wild " + msText + "!", 50, 475);
				//arrow.paintIcon(this, g, 575, 525);
				//atPrompt = true;
			}
			else
			{
				g.setColor(Color.BLACK);
				g.fillRect(0,0,700,700);
			}
			
			++rCount;
		}
        
        if(eCount > 0)
        {
			int r456 = 5 + randx.nextInt(8);
			
			
          /**if(eCount < 15)
          {
            //g.setColor(Color.RED);
            //g.fillRect(((10 - eCount) * 5) + 100, ((eCount) * 12) + 125, 15, 15);
			health -= r456 / 30.0;
          }**/
			
          if(eCount < 20)
          {
            //g.setColor(Color.RED);
            
			health -= r456 / 15.0;
			
            if(eCount % 2 == 0)
            {
              bgdb.paintIcon(this, g, 0, 0);
              ms.paintIcon(this, g, 400, 50);
            }
            else if(eCount % 3 == 0)
            {
              bgdn.paintIcon(this, g, 0, 0);
              ms.paintIcon(this, g, 400, 50);
            }
			
              
            /**for(int i = 0; i < 5; i++)
            {
              g.fill3DRect(randx.nextInt(500), randx.nextInt(500), randx.nextInt(25), randx.nextInt(25), true);
            }**/
          }
          else
          {
            //health -= randx.nextInt(50);
            eCount = 0;
            eAttacking = false;
            isDiag = true;
            isFight = false;
            isItem = false;
            isRun = false;
            atPrompt = true;
            arrowPositDiag = 0;
            
            buffer[0] = 0;
            buffer[1] = 0;
            buffer[2] = 0;
            buffer[3] = 0;
            
            int rand = randx.nextInt(3);
            
            /**if(health > 0.0)
            {
              
            }**/
          }
        }
        
        if(ehealth > 0.0)
        {
          if(count < 15)
          {
            if(count % 2 != 0)
            {
              ms.paintIcon(this, g, 400, 50);
            }
          }
          else
          {
            if(attacking)
            {
              if(aCount < 20)
              {
                //if(count % 2 == 0)
			
                if(whichAttack == 0)
				{ 
                  g.setColor(new Color((int)(Math.random() * 254),(int)(Math.random() * 254),(int)(Math.random() * 254)));
				  g.fillRect(0,0,654,615);
				  
				  g.setColor(new Color(randx.nextInt(255),randx.nextInt(255),randx.nextInt(255)));
				  g.fillArc(0,0,654,615,0,(18*aCount));
				  
				  g.setColor(new Color(randx.nextInt(255),randx.nextInt(255),randx.nextInt(255)));
				  g.fillArc(80,72,480,432,90,(18*aCount));
				  
				  g.setColor(new Color(randx.nextInt(255),randx.nextInt(255),randx.nextInt(255)));
				  g.fillArc(160,144,320,288,0,(-18*aCount));
				  
				  if(aCount % 2 == 0)
				  {
					ms.paintIcon(this, g, 400, 50);
					//tgcolor.paintIcon(this, g, randx.nextInt(600), randx.nextInt(525));
					//ms.paintIcon(this, g, randx.nextInt(600), randx.nextInt(525));
					/**g.setFont(new Font("Pokemon GB", Font.PLAIN, 24));   
                
					g.setColor(Color.BLACK);
					
					bar[0].paintIcon(this, g, 15, 50);
					bar[1].paintIcon(this, g, 300, 300);
					
					**/
					g.setFont(new Font("Pokemon GB", Font.PLAIN, 24));
					g.setColor(Color.BLACK);
					g.drawString(msText, 30, 50);
					g.drawString("DANNY", 400, 275);
					
					g.setFont(pokeb);
					
					g.drawString("HP:", 50, 105);
					g.drawString("HP:", 350, 315);
					
					g.setColor(Color.BLUE);
					
					g.fillRect(100, 90, (int)(ehealth * 2), 15);
					g.fillRect(400, 300, (int)(health * 2), 15);
					
					g.setColor(Color.BLACK);
					
					g.drawString(String.format("%d/100", (int)health), 450, 350);
					g.drawString(String.format("%d/100", (int)ehealth), 150, 75);
				  }
                  else
				  {
					tgcolor.paintIcon(this, g, 25, 150);
					//ms.paintIcon(this, g, randx.nextInt(600), randx.nextInt(525));
					//tgcolor.paintIcon(this, g, randx.nextInt(600), randx.nextInt(525));
				  }
				  
				  //g.setColor(new Color(randx.nextInt(255),randx.nextInt(255),randx.nextInt(255)));
				  g.setColor(Color.BLACK);
				  g.setFont(new Font("Pokemon GB", Font.PLAIN, 100));
				  
				  int strLen = 100 * currentAttack.length();
				  
				  int mvmPF = (strLen + 654) / 20;
				  
				  g.drawString(currentAttack, 654 - (mvmPF * aCount) ,200);
				  //g.drawString(currentAttack, (mvmPF * aCount) - strLen ,350);
				 // g.drawString(currentAttack, (mvmPF * aCount) - strLen ,50);
				 // g.drawString(currentAttack, 654 - (mvmPF * aCount) ,500);
				}
				else if(whichAttack == 1)
				{
				  g.setColor(Color.BLACK);
				  g.fillRect(0,0,654,615);
							  
				  ms.paintIcon(this, g, 400, 50);
				  tg.paintIcon(this, g, 25, 150);
				  g.setFont(new Font("Pokemon GB", Font.PLAIN, 24));
				  g.setColor(Color.BLUE);
				  g.drawString(msText, 30, 50);
				  g.drawString("DANNY", 400, 275);
				  
				  g.setFont(pokeb);
				  
				  g.drawString("HP:", 50, 105);
				  g.drawString("HP:", 350, 315);
				  
				  g.setColor(Color.BLUE);
				  
				  g.fillRect(100, 90, (int)(ehealth * 2), 15);
				  g.fillRect(400, 300, (int)(health * 2), 15);
				  
				  g.setColor(Color.BLUE);
				  
				  g.drawString(String.format("%d/100", (int)health), 450, 350);
				  g.drawString(String.format("%d/100", (int)ehealth), 150, 75);
							
                    
                    g.setFont(new Font("Pokemon GB", Font.PLAIN, 87));
                    
                    int strLen = 100 * currentAttack.length();
                    
                    int mvmPF = (strLen + 654) / 20;
                    
                    g.setColor(Color.RED);
                    g.drawString(currentAttack, 654 - (mvmPF * aCount) ,87);
                    
                    g.setColor(Color.ORANGE);
                    g.drawString(currentAttack, 654 - (mvmPF * aCount) ,174);
                    
                    g.setColor(Color.YELLOW);
                    g.drawString(currentAttack, 654 - (mvmPF * aCount) ,261);
                    
                    g.setColor(Color.GREEN);
                    g.drawString(currentAttack, 654 - (mvmPF * aCount) ,348);
                    
                    g.setColor(Color.CYAN);
                    g.drawString(currentAttack, 654 - (mvmPF * aCount) ,435);
                    
                    g.setColor(Color.BLUE);
                    g.drawString(currentAttack, 654 - (mvmPF * aCount) ,522);
                    
                    g.setColor(new Color(128, 0, 128));
                    g.drawString(currentAttack, 654 - (mvmPF * aCount) ,609);
                    
                    
				}
				else if(whichAttack == 2)
				{
					
					g.setColor(new Color(randx.nextInt(255), randx.nextInt(255), randx.nextInt(255)));
					
					g.fillRect(0,0,654,615);
					
					ms.paintIcon(this, g, 400, 50);
					tg.paintIcon(this, g, 25, 150);
					g.setFont(new Font("Pokemon GB", Font.PLAIN, 24));
					g.setColor(Color.BLACK);
					g.drawString(msText, 30, 50);
					g.drawString("DANNY", 400, 275);
					
					g.setFont(pokeb);
					
					g.drawString("HP:", 50, 105);
					g.drawString("HP:", 350, 315);
					
					g.setColor(Color.BLUE);
					
					g.fillRect(100, 90, (int)(ehealth * 2), 15);
					g.fillRect(400, 300, (int)(health * 2), 15);
					
					g.setColor(Color.BLACK);
					
					g.drawString(String.format("%d/100", (int)health), 450, 350);
					g.drawString(String.format("%d/100", (int)ehealth), 150, 75);
					
					g.setColor(Color.BLACK);
					g.setFont(new Font("Pokemon GB", Font.PLAIN, 100));
					
					int strLen = 100 * currentAttack.length();
					
					int mvmPF = (strLen + 654) / 20;
					
					g.drawString(currentAttack, 654 - (mvmPF * aCount) ,200);

				}
				else if(whichAttack == 3)
				{
					if(aCount % 2 == 0)
					{
						g.setColor(Color.WHITE);
						g.fillRect(0,0,654,615);
						g.setColor(Color.BLUE);
					}
					else
					{
						g.setColor(Color.BLACK);
						g.fillRect(0,0,654,615);
						g.setColor(Color.WHITE);
					}
					
					ms.paintIcon(this, g, 400, 50);
					tg.paintIcon(this, g, 25, 150);
					g.setFont(new Font("Pokemon GB", Font.PLAIN, 24));
					g.drawString(msText, 30, 50);
					g.drawString("DANNY", 400, 275);
					
					g.setFont(pokeb);
					
					g.drawString("HP:", 50, 105);
					g.drawString("HP:", 350, 315);
					
					
					g.drawString(String.format("%d/100", (int)health), 450, 350);
					g.drawString(String.format("%d/100", (int)ehealth), 150, 75);
					
					g.setFont(new Font("Pokemon GB", Font.PLAIN, 100));
					
					int strLen = 100 * currentAttack.length();
					
					int mvmPF = (strLen + 654) / 20;
					
					g.drawString(currentAttack, 654 - (mvmPF * aCount) ,200);
					
					g.setColor(Color.BLUE);
					
					g.fillRect(100, 90, (int)(ehealth * 2), 15);
					g.fillRect(400, 300, (int)(health * 2), 15);
				}
				  
				  ehealth -= attackStrength[buffer[aNum]] / 20.0;
				  
                  aCount++;
               
                
                /**g.setFont(new Font("Pokemon GB", Font.PLAIN, 24));   
                
                g.setColor(Color.BLACK);
                
                bar[0].paintIcon(this, g, 15, 50);
                bar[1].paintIcon(this, g, 300, 300);
                
                g.drawString("MALL SANTA", 30, 50);
                g.drawString("DANNY", 400, 275);
                
                g.setFont(pokeb);
                
                g.drawString("HP:", 50, 105);
                g.drawString("HP:", 350, 315);
                
                g.setColor(Color.BLUE);
                
                g.fillRect(100, 90, (int)(ehealth * 2), 15);
                g.fillRect(400, 300, (int)(health * 2), 15);
                
                g.setColor(Color.BLACK);
                
                g.drawString(String.format("%d/100", (int)health), 450, 350);
                g.drawString(String.format("%d/100", (int)ehealth), 150, 75);**/
              }
			  else if(aCount < 25)
			  {
				if(aCount % 2 == 0)
					g.setColor(Color.WHITE);
				else
					g.setColor(Color.BLACK);
					
				g.fillRect(0,0,654,615);
				aCount++;
			  }
              else
              {
                ms.paintIcon(this, g, 400, 50);
                attacking = false;
                aCount = 0;
                
                //ehealth -= attackStrength[buffer[aNum]];
                
                //int rand = randx.nextInt(3);
                
				double randy = Math.random();
				
                if(ehealth > 0.0)
                {
                  if(attacks[buffer[aNum]].contains("fuck") || attacks[buffer[aNum]].contains("Fuck") || attacks[buffer[aNum]].contains("FUCK") || attacks[buffer[aNum]].contains("f-ck") || attacks[buffer[aNum]].contains("F-ck") || attacks[buffer[aNum]].contains("F-CK"))
                  {
                    try
                    {
                            Clip clip = AudioSystem.getClip();
                            AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(tgdada[0]));
                            clip.open(inputStream);
                            clip.start();
                            
                          } catch (Exception e) {
                            System.err.println(e.getMessage());
                      }
                  }
                  else if(randy <= 0.15)
                  {
                    try
                    {
                            Clip clip = AudioSystem.getClip();
                            AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(tgdada[1]));
                            clip.open(inputStream);
                            clip.start();
                            
                          } catch (Exception e) {
                            System.err.println(e.getMessage());
                      }
                  }
                  else if(randy > 0.15 && randy <= 0.30)
                  {
                    try
                    {
                            Clip clip = AudioSystem.getClip();
                            AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(tgdada[2]));
                            clip.open(inputStream);
                            clip.start();
                            
                          } catch (Exception e) {
                            System.err.println(e.getMessage());
                      }
                  }
				  else if(randy > 0.30 && randy  <= 0.45)
				  {
						try
						{
                            Clip clip = AudioSystem.getClip();
                            AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(tgdada[3]));
                            clip.open(inputStream);
                            clip.start();
                            
                          } catch (Exception e) {
                            System.err.println(e.getMessage());
                      }
				  }
				  else if(randy > 0.45 && randy  <= 0.60)
				  {
						try
						{
                            Clip clip = AudioSystem.getClip();
                            AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(tgdada[4]));
                            clip.open(inputStream);
                            clip.start();
                            
                          } catch (Exception e) {
                            System.err.println(e.getMessage());
                      }
				  }
				  else if(randy > 0.60 && randy <= 0.75)
				  {
						try
						{
                            Clip clip = AudioSystem.getClip();
                            AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(tgdada[5]));
                            clip.open(inputStream);
                            clip.start();
                            
                          } catch (Exception e) {
                            System.err.println(e.getMessage());
                      }
				  }
				  else if(randy > 0.75 && randy <= 0.90)
				  {
						try
						{
                            Clip clip = AudioSystem.getClip();
                            AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(tgdada[6]));
                            clip.open(inputStream);
                            clip.start();
                            
                          } catch (Exception e) {
                            System.err.println(e.getMessage());
                      }
				  }
				  else
				  {
						try
						{
                            Clip clip = AudioSystem.getClip();
                            AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(tgdada[7]));
                            clip.open(inputStream);
                            clip.start();
                            
                          } catch (Exception e) {
                            System.err.println(e.getMessage());
                      }
				  }
                }
                      
                  eAttacking = true;
              }
              
              //g.setColor(Color.GREEN);
              //g.fillRect(((aCount) * 15) + 125, ((10 - aCount) * 5) + 200, 15, 15);
            }
            else
            {
              ms.paintIcon(this, g, 400, 50);
            }
          }
        }
        else
        {
          if(fecount == 0)
          {
            try
            {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(win));
                    clip.open(inputStream);
                    clip.start();
                    
                  } catch (Exception e) {
                    System.err.println(e.getMessage());
              }
          }
          else
          {
            
          }
          
          g.setColor(Color.WHITE);
          g.fillRect(0, 0, 640, 640);
          
          g.setFont(new Font("Pokemon GB", Font.BOLD, 72));
          g.setColor(Color.BLACK);
          g.drawString("You won!", 50, 250);
          
          fps.stop();
          t.stop();
          
          fecount++;
        }
      }
    }
    else
    {
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, 640, 640);
      
      g.setFont(new Font("Pokemon GB", Font.BOLD, 72));
      g.setColor(Color.BLACK);
      g.drawString("You lose!", 50, 250);
      
      fps.stop();
      t.stop();
      
      if(decount == 0)
      {
        try
        {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(lose));
                clip.open(inputStream);
                clip.start();
                
          } 
        catch (Exception e)
          {
                System.err.println(e.getMessage());
          }
      }
      
      decount++;
    }
  }
  
  
  public void keyPressed( KeyEvent e )
  {
    if(e.getKeyCode() == e.VK_UP)
    {
      if(isDiag == true || isFight == true)
      {
        if(arrowPositDiag > 0)
        {
          arrowPositDiag--;
        }
      }
    }
    else if(e.getKeyCode() == e.VK_DOWN)
    {
      if(isDiag)
      {
        if(arrowPositDiag < 2)
        { 
          arrowPositDiag++;
        }
      }
      else if(isFight)
      {
        if(arrowPositDiag < 3)
        {
          arrowPositDiag++;
        }
      }
    }
    else if(e.getKeyCode() == e.VK_ENTER)
    {
      if(atPrompt)
      {
        if(isDiag == false && isFight == false && isItem == false && isRun == false)
        {
          isDiag = true;
          atPrompt = false;
        }
        else if(isDiag == true && isFight == false && isItem == false && isRun == false)
        {
          if(arrowPositDiag == 0)
          {
            for(int i = 0; i < 4; i++)
            {
              buffer[i] = randx.nextInt(attacks.length);
              
              if(used[buffer[i]] == true)
              {
                buffer[i] = randx.nextInt(attacks.length);
              }
              
              for(int it = 0; it < i; it++)
              {
                if(buffer[it] == buffer[i])
                {
                  buffer[i] = randx.nextInt(attacks.length);
                }
              }
            }
            
            isFight = true;
            isDiag = false;
            atPrompt = false;
			  
          }
          else if(arrowPositDiag == 1)
          {
            isItem = false;
            isDiag = false;
            atPrompt = false;
          }
          else if(arrowPositDiag == 2)
          {
            isRun = true;
            isDiag = false;
            atPrompt = false;
          }
          
          arrowPositDiag = 0;
        }
        else if(isDiag == false && isFight == true && isItem == false && isRun == false)
        {
          attack(arrowPositDiag);
			
			/**if(Math.random() <= 0.25)
			{
				whichAttack = 0;
			}
			else if(Math.random() <= 0.50)
			{
				whichAttack = 1;
			}
			else if(Math.random() <= 0.75)
			{
				whichAttack = 2;
			}
			else
			{
				whichAttack = 3;
			}**/
            
            if(currentAttack.equals("PISS!") || currentAttack.equals("Buttfuck!") || currentAttack.equals("Buttf-ck!"))
            {
                whichAttack = 0;
            }
            else if(currentAttack.contains("fuck") || currentAttack.contains("f-ck") || currentAttack.contains("Fuck") || currentAttack.contains("F-ck"))
            {
                whichAttack = 1;
            }
            else if(currentAttack.contains("balls") || currentAttack.contains("Balls"))
            {
                whichAttack = 2;
            }
            else
            {
                whichAttack = 3;
            }
        }
      }
      
    }
  }
  
  public void keyTyped( KeyEvent e )
  {
    
  }
  
  public void keyReleased( KeyEvent e )
  {
    
  }
  
  public class TimerHandler implements ActionListener
  {
    public void actionPerformed( ActionEvent a )
    {
      if(count > 5)
      {
        isMSAppear = true;
      }
      
      if(count == 5)
      {
        try
        {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(main.class.getResourceAsStream(entry));
                clip.open(inputStream);
                clip.start();
                
              } catch (Exception e) {
                System.err.println(e.getMessage());
          }
      }
      
      count++;
    }
  }
  
  public class fpshand implements ActionListener
  {
    public void actionPerformed( ActionEvent a )
    {
      repaint();
    }
  }
}