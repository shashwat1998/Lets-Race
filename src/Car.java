import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Car extends GraphicsProgram
{
    public static int players;
    GRect rec1,rec2,rec3;
    int s,t;
     
    GCar c1,c2,c3,c4,c5,c6,c7,c8,pcar1,pcar2,pcar3;
    track track1;
    double f;
    int end;
    int pc1,pc2,pc3;
    GOval oval1[]=new GOval[1000];
    GRect sq1[]=new GRect[1000];
    GOval oval2[]=new GOval[1000];
    GRect sq2[]=new GRect[1000];
    GOval oval3[]=new GOval[1000];
    GRect sq3[]=new GRect[1000];
    Player p[]=new Player[4];
    double score;
    double highscore;
    String playername;
    @Override
    public void run() 
    {
            end=0;
            highscore=0.0;
            addMouseListeners();
            addKeyListeners();
            while(true)
            {
                dispIntro();
            s=1;
            getNum();
            int p=0;
            createCars();
            GLabel go1=new GLabel("GAME OVER!!");
            go1.setFont("SansSerif-20");
            GLabel go2=new GLabel("GAME OVER!!");
            go2.setFont("SansSerif-20");
            GLabel go3=new GLabel("GAME OVER!!");
            go3.setFont("SansSerif-20");
            score=0;
            GLabel highscorelabel=new GLabel("HIGH SCORE");
            highscorelabel.setFont("SansSerif-15");
            String st;
            int dum=(int)highscore;
            st = Integer.toString(dum);
            GLabel sc1 = new GLabel(st);
            sc1.setFont("SansSerif-20");
            while(t!=1)
            {
                waitForClick();
            }
            removeAll();
            s=2;
            dispRules();
            giveMessage(s);
            dispCars();
            while(t!=1)
                {
                    waitForClick();
                }
                removeAll();
            if(players>=2)
            {
                s=3;
                giveMessage(s);
                dispCars();
                while(t!=1)
                {
                    waitForClick();
                }
                removeAll();
            }
            if(players==3)
            {
                s=4;
                giveMessage(s);
                dispCars();
                while(t!=1)
                {
                    waitForClick();
                }
                removeAll();
            }
            game();
            add(highscorelabel,10,80);
            add(sc1,10,120);
            GLabel scorelabel=new GLabel("SCORE");
            scorelabel.setFont("SansSerif-20");
            add(scorelabel,10,10);
            String st2;
            st2 = Double.toString(score);
            GLabel sc2 = new GLabel(st2);
            sc2.setFont("SansSerif-20");
            add(sc2,10,30);
            double d=100;
            int i;
            
            for(i=0;i<1000;i++)
            {
            oval1[i]= new GOval(pcar1.getWidth(),pcar1.getWidth());
            oval1[i].setFilled(true);
            oval1[i].setColor(Color.BLUE);
            sq1[i]=new GRect(pcar1.getWidth(),pcar1.getWidth());
            sq1[i].setFilled(true);
            sq1[i].setColor(Color.RED);
            oval2[i]= new GOval(pcar1.getWidth(),pcar1.getWidth());
            oval2[i].setFilled(true);
            oval2[i].setColor(Color.BLUE);
            sq2[i]=new GRect(pcar1.getWidth(),pcar1.getWidth());
            sq2[i].setFilled(true);
            sq2[i].setColor(Color.RED);
            oval3[i]= new GOval(pcar1.getWidth(),pcar1.getWidth());
            oval3[i].setFilled(true);
            oval3[i].setColor(Color.BLUE);
            sq3[i]=new GRect(pcar1.getWidth(),pcar1.getWidth());
            sq3[i].setFilled(true);
            sq3[i].setColor(Color.RED);
            
            }
            int j=0;
            i=0;
            Random rand=new Random();
            int rnum1;
            int rnum2;
            pc1=0;pc2=0;pc3=0;
            if(players>=1) pc1=1;
            if(players>=2) pc2=1;
            if(players>=3) pc3=1;
            king:
            while(pc1==1 || pc2==1 || pc3==1)
            {
            while(true)
            {
                if(i<1000)
                {
                rnum1=rand.nextInt(200);
                rnum2=rand.nextInt(200);
                double x1=0.0,x2=0.0,x3=0.0;
                if(rnum1%2==0)
                {
                    x1=f*(2+0.3);
                    x2=f*(4+0.3);
                    x3=f*(6+0.3);
                }
                else
                {
                    x1=f*(1+0.3);
                    x2=f*(3+0.3);
                    x3=f*(5+0.3);
                }
                if(rnum2%2==0)
                {
                    if(pc1==1) add(oval1[i],x1,-200);
                    if(pc2==1) add(oval2[i],x2,-200);
                    if(pc3==1) add(oval3[i],x3,-200);
                }
                else
                {
                    if(pc1==1) add(sq1[i],x1,-200);
                    if(pc2==1) add(sq2[i],x2,-200);
                    if(pc3==1) add(sq3[i],x3,-200);
                }
                }
                if(pc1==1) pcar1.sendForward();
                if(pc2==1) pcar2.sendForward();
                if(pc3==1) pcar3.sendForward();
                if(sq1[999].getY()<getHeight() || oval1[999].getY()< getHeight() || sq2[999].getY()<getHeight() || oval2[999].getY()< getHeight() || sq3[999].getY()<getHeight() || oval3[999].getY()< getHeight())
                {
                    int t=Math.min(i, 1000);
                    int b=1000;
                    for(int h=1;h<=40;h++){
                            for(int k=0;k<t;k++){
                            if(sq1[k].getLocation()!=null || sq3[k].getLocation()!=null || sq3[k].getLocation()!=null)
                            {
                                if(pc1==1) sq1[k].move(0, 10);
                                if(pc2==1) sq2[k].move(0, 10);
                                if(pc3==1) sq3[k].move(0, 10);
                            }
                            if(oval1[k].getLocation()!=null || oval2[k].getLocation()!=null || oval3[k].getLocation()!=null)
                            {
                                if(pc1==1) oval1[k].move(0,10);
                                if(pc2==1) oval2[k].move(0,10);
                                if(pc3==1) oval3[k].move(0,10);
                            }
                            if(pc1==1){if(oval1[k].getLocation()!=null)
                            {
                                if(oval1[k].getY()+oval1[k].getHeight()/6*5>pcar1.getY() && oval1[k].getY()+oval1[k].getHeight()<getHeight()-pcar1.getHeight()*1.2)
                                {
                                    if(oval1[k].getX()==1.3*f && pcar1.getX()>2*f)
                                    {pc1=0;
                                    add(go1,1.3*f,getHeight()/2);}
                                    if(oval1[k].getX()==2.3*f && pcar1.getX()<2*f)
                                    {pc1=0;
                                    add(go1,1.3*f,getHeight()/2);}
                                    remove(oval1[k]);
                                }
                            }
                            if(sq1[k].getLocation()!=null)
                            {
                                if(sq1[k].getY()+sq1[k].getHeight()/6*5>pcar1.getY() && sq1[k].getY()+sq1[k].getHeight()<getHeight()-pcar1.getHeight()*1.2)
                                {
                                    if(sq1[k].getX()==1.3*f && pcar1.getX()<2*f)
                                    {pc1=0;
                                    add(go1,1.3*f,getHeight()/2);}
                                    if(sq1[k].getX()==2.3*f && pcar1.getX()>2*f)
                                    {pc1=0;
                                    add(go1,1.3*f,getHeight()/2);}
                                    remove(sq1[k]);
                                }
                            }
                            }
                            if(pc2==1){if(oval2[k].getLocation()!=null)
                            {
                                if(oval2[k].getY()+oval2[k].getHeight()/6*5>pcar2.getY() && oval2[k].getY()+oval2[k].getHeight()<getHeight()-pcar2.getHeight()*1.2)
                                {
                                    if(oval2[k].getX()==3.3*f && pcar2.getX()>4*f)
                                    {pc2=0;
                                    add(go2,3.3*f,getHeight()/2);}
                                    if(oval2[k].getX()==4.3*f && pcar2.getX()<4*f)
                                    {pc2=0;
                                    add(go2,3.3*f,getHeight()/2);}
                                    remove(oval2[k]);
                                }
                            }
                            if(sq2[k].getLocation()!=null)
                            {
                                if(sq2[k].getY()+sq2[k].getHeight()/6*5>pcar2.getY() && sq2[k].getY()+sq2[k].getHeight()<getHeight()-pcar2.getHeight()*1.2)
                                {
                                    if(sq2[k].getX()==3.3*f && pcar2.getX()<4*f)
                                    {pc2=0;
                                    add(go2,3.3*f,getHeight()/2);}
                                    if(sq2[k].getX()==4.3*f && pcar2.getX()>4*f)
                                    {pc2=0;
                                    add(go2,3.3*f,getHeight()/2);}
                                    remove(sq2[k]);
                                }
                            }}
                            if(pc3==1){if(oval3[k].getLocation()!=null)
                            {
                                if(oval3[k].getY()+oval3[k].getHeight()/6*5>pcar3.getY() && oval3[k].getY()+oval3[k].getHeight()<getHeight()-pcar3.getHeight()*1.2)
                                {
                                    if(oval3[k].getX()==5.3*f && pcar3.getX()>6*f)
                                    {pc3=0;
                                    add(go3,5.3*f,getHeight()/2);}
                                    if(oval3[k].getX()==6.3*f && pcar3.getX()<6*f)
                                    {pc3=0;
                                    add(go3,5.3*f,getHeight()/2);}
                                    remove(oval3[k]);
                                }
                            }
                            if(sq3[k].getLocation()!=null)
                            {
                                if(sq3[k].getY()+sq3[k].getHeight()/6*5>pcar3.getY() && sq3[k].getY()+sq3[k].getHeight()<getHeight()-pcar3.getHeight()*1.2)
                                {
                                    if(oval1[k].getX()==5.3*f && pcar1.getX()<6*f)
                                    {pc3=0;
                                    add(go3,5.3*f,getHeight()/2);}
                                    if(oval1[k].getX()==6.3*f && pcar1.getX()>6*f)
                                    {pc3=0;
                                    add(go3,5.3*f,getHeight()/2);}
                                    remove(sq3[k]);
                                }
                            }}
                            }
                            if(100-0.1*p>10)
                            {
                                pause(100-0.1*p);
                                p++;
                            }
                            else
                            {
                                pause(10);
                            }
                            score+=0.5;
                            dum=(int)score;
                            st2 = Integer.toString(dum);
                            sc2.setLabel(st2);
                            add(sc2,20,60);
                            
                        }
                } 
                else
                {
                    add(sq1[999],-1000,-1000);
                    add(oval1[999],-1000,-1000);
                    add(sq2[999],-1000,-1000);
                    add(oval2[999],-1000,-1000);
                    add(sq3[999],-1000,-1000);
                    add(oval3[999],-1000,-1000);
                    break;
                }
                i++;
                if(pc1==0 && pc2==0 && pc3==0)
                {
                    break king;
                }
            }
            i=1;
            }
            
            {if(score>highscore)
                highscore=score;
            }
            removeAll();
            s=10;
            GLabel fin=new GLabel("Game Restarts in 5 sec Click to end");
            fin.setFont("SansSerif-20");
            GLabel fin2=new GLabel("THE END");
            fin2.setFont("SansSerif-20");
            add(fin,getWidth()/2-fin.getWidth()/2,getHeight()/2);
            pause(5000);
            if(end==1)
            {
                removeAll();
                add(fin2,getWidth()/2-fin2.getWidth()/2,getHeight()/2);
                break;
            }
            }
            
        
    }
    
    public void getNum()
    {
        GLabel l1= new GLabel("Choose number of players:");
        GLabel l2= new GLabel("1");
        GLabel l3= new GLabel("2");
        GLabel l4= new GLabel("3");
        l1.setFont("SansSerif-20");
        l2.setFont("SansSerif-20");
        l3.setFont("SansSerif-20");
        l4.setFont("SansSerif-20");
        rec1=new GRect(l2.getWidth()+10,l2.getHeight()+10);
        rec1.setFillColor(Color.BLACK);
        rec2=new GRect(l2.getWidth()+10,l2.getHeight()+10);
        rec2.setFillColor(Color.BLACK);
        rec3=new GRect(l2.getWidth()+10,l2.getHeight()+10);
        rec3.setFillColor(Color.BLACK);
        add(l1,(getWidth()-l1.getWidth())/2,(getHeight()-l1.getHeight())/2);
        add(l2,l1.getX(),l1.getY()+50);
        add(l3,l1.getX()+l1.getWidth()/2-l4.getWidth()/2,l1.getY()+50);
        add(l4,l1.getX()+l1.getWidth()-l4.getWidth(),l1.getY()+50);
        add(rec1,l2.getX()-5,l2.getY()-rec1.getHeight()+10);
        add(rec2,l3.getX()-5,l3.getY()-rec1.getHeight()+10);
        add(rec3,l4.getX()-5,l4.getY()-rec1.getHeight()+10);
        waitForClick();
    }
    @Override
    public void mouseClicked(MouseEvent e)
    {
    if(s==1)
    {
        if(rec1.contains(e.getX(),e.getY()))
                {
                    players=1;
                    t=1;
                }
        else if(rec2.contains(e.getX(),e.getY()))
                {
                    players=2;
                    t=1;
                }
        else if(rec3.contains(e.getX(),e.getY()))
                {
                    players=3;
                    t=1;
                }
        
        
    }
    if(s>=2 && s<=4)
    {
        if(c1.contains(e.getX(),e.getY()))
        {
            if(s==2)
            {
                pcar1=new GCar(Color.BLUE);
            }
            if(s==3)
            {
                pcar2=new GCar(Color.BLUE);
            }
            if(s==4)
            {
                pcar3=new GCar(Color.BLUE);
            }
            t=1;
        }
        else if(c2.contains(e.getX(),e.getY()))
        {
            if(s==2)
            {
                pcar1=new GCar(Color.GREEN);
            }
            if(s==3)
            {
                pcar2=new GCar(Color.GREEN);
            }
            if(s==4)
            {
                pcar3=new GCar(Color.GREEN);
            }
            t=1;
        }
        else if(c3.contains(e.getX(),e.getY()))
        {
            if(s==2)
            {
                pcar1=new GCar(Color.MAGENTA);
            }
            if(s==3)
            {
                pcar2=new GCar(Color.MAGENTA);
            }
            if(s==4)
            {
                pcar3=new GCar(Color.MAGENTA);
            }
            t=1;
        }
        else if(c4.contains(e.getX(),e.getY()))
        {
            if(s==2)
            {
                pcar1=new GCar(Color.CYAN);
            }
            if(s==3)
            {
                pcar2=new GCar(Color.CYAN);
            }
            if(s==4)
            {
                pcar3=new GCar(Color.CYAN);
            }
            t=1;
        }
        else if(c5.contains(e.getX(),e.getY()))
        {
            if(s==2)
            {
                pcar1=new GCar(Color.RED);
            }
            if(s==3)
            {
                pcar2=new GCar(Color.RED);
            }
            if(s==4)
            {
                pcar3=new GCar(Color.RED);
            }
            t=1;
        }
        else if(c6.contains(e.getX(),e.getY()))
        {
            if(s==2)
            {
                pcar1=new GCar(Color.ORANGE);
            }
            if(s==3)
            {
                pcar2=new GCar(Color.ORANGE);
            }
            if(s==4)
            {
                pcar3=new GCar(Color.ORANGE);
            }
            t=1;
        }
        else if(c7.contains(e.getX(),e.getY()))
        {
            if(s==2)
            {
                pcar1=new GCar(Color.PINK);
            }
            if(s==3)
            {
                pcar2=new GCar(Color.PINK);
            }
            if(s==4)
            {
                pcar3=new GCar(Color.PINK);
            }
            t=1;
        }
        else if(c8.contains(e.getX(),e.getY()))
        {
            if(s==2)
            {
                pcar1=new GCar(Color.YELLOW);
            }
            if(s==3)
            {
                pcar2=new GCar(Color.YELLOW);
            }
            if(s==4)
            {
                pcar3=new GCar(Color.YELLOW);
            }
            t=1;
        }
        
        
    }
    if(s==10)
                    {
                        end=1;
                    }
    
}
    public void giveMessage(int n)
    {
    GLabel l1=new GLabel("Player "+(s-1)+" choose your car");
    GLabel l2=new GLabel("(Double Click)");
    l1.setFont("SansSerif-40");
    l2.setFont("SansSerif-20");
    add(l1,getWidth()/2-l1.getWidth()/2,getHeight()/2);
    add(l2,getWidth()/2-l1.getWidth()/2,getHeight()/2+100);
    pause(1500);
    removeAll();
}
    public void dispCars()
    {
    t=0;
    add(c1,100,20);
    add(c2,200,20);
    add(c3,300,20);
    add(c4,400,20);
    add(c5,100,200);
    add(c6,200,200);
    add(c7,300,200);
    add(c8,400,200);
    waitForClick();
}
    public void createCars()
    {
    c1=new GCar(Color.BLUE);
    c2=new GCar(Color.GREEN);
    c3=new GCar(Color.MAGENTA);
    c4=new GCar(Color.CYAN);
    c5=new GCar(Color.RED);
    c6=new GCar(Color.ORANGE);
    c7=new GCar(Color.PINK);
    c8=new GCar(Color.YELLOW);
}
    public void game()
    {
        track1=new track(players,getWidth(),getHeight());
        add(track1,0.0,0.0);
        f=track1.lanewidth;
        add(pcar1,(2*1-1+0.3)*f,0.8*getHeight());
        if(players>=2)
        {
            
            add(pcar2,(2*2-1+0.3)*f,0.8*getHeight());
            if(players==3)
            {
                
                add(pcar3,(2*3-1+0.3)*f,0.8*getHeight());
            }
        }
        GLabel l1=new GLabel("READY!!");
        l1.setFont("SansSerif-50");
        GLabel l2=new GLabel("3!!");
        l2.setFont("SansSerif-50");
        GLabel l3=new GLabel("2!!");
        l3.setFont("SansSerif-50");
        GLabel l4=new GLabel("1!!");
        l4.setFont("SansSerif-50");
        GLabel l5=new GLabel("GO!!");
        l5.setFont("SansSerif-50");
        add(l1,(getWidth()-l1.getWidth())/2,getHeight()/2);
        pause(1000);
        remove(l1);
        add(l2,(getWidth()-l2.getWidth())/2,getHeight()/2);
        pause(1000);
        remove(l2);
        add(l3,(getWidth()-l3.getWidth())/2,getHeight()/2);
        pause(1000);
        remove(l3);
        add(l4,(getWidth()-l4.getWidth())/2,getHeight()/2);
        pause(1000);
        remove(l4);
        add(l5,(getWidth()-l5.getWidth())/2,getHeight()/2);
        pause(1000);
        remove(l5);
    }
    @Override
    public void keyPressed(KeyEvent ke)
    {
        f=track1.lanewidth;
        if(ke.getKeyCode()==KeyEvent.VK_Q && players>=1)
        {
            if(pcar1.getX()<=(2*1-1+0.3)*f+f/2)
            {
                pcar1.move(f, 0);
            }
            else
            {
                pcar1.move(-f, 0);
            }
        }
        if(ke.getKeyCode()==KeyEvent.VK_B && players>=2)
        {
            if(pcar2.getX()<=(2*2-1+0.3)*f+f/2)
            {
                pcar2.move(f, 0);
            }
            else
            {
                pcar2.move(-f, 0);
            }
        }
        if(ke.getKeyCode()==KeyEvent.VK_P && players>=3)
        {
            if(pcar3.getX()<=(2*3-1+0.3)*f+f/2)
            {
                pcar3.move(f, 0);
            }
            else
            {
                pcar3.move(-f, 0);
            }
        }
        
            
    }
    
    void dispIntro()
    {
        removeAll();
        
        GImage im=new GImage("img.jpg");
        im.setSize(80,80);
        GLabel l1= new GLabel("LETS RACE!!!");
        l1.setFont("SansSerif-30");
        double c=-im.getWidth();
        add(im,c,getHeight()/2);
        add(l1,getWidth()/2-l1.getWidth()/2,getHeight()/2+im.getHeight()+30);
        while(im.getX()<getWidth())
        {
            im.move(10, 0);
            pause(20);
        }
        GLabel l2=new GLabel("Click to continue");
        l2.setFont("SansSerif-20");
        add(l2,getWidth()/2-l2.getWidth()/2,getHeight()/2+im.getHeight()+l1.getHeight()+30);
        waitForClick();
        removeAll();
    }
    void dispRules()
    {
        GLabel l1=new GLabel("RULES");
        GLabel l2=new GLabel("1. Pick circles and avoid squares.");
        GLabel l3=new GLabel("2. Game Over if circle is skipped or square picked.");
        GLabel l4=new GLabel("3. Key Control to switch lanes.");
        GLabel l5=new GLabel("Player 1-Q");;
        if(players==1)
        {
            l5=new GLabel("Player 1-Q");
        } else if(players==2)
            {
            l5=new GLabel("Player 1-Q  Player 2-B");
        }
        else if(players==3)
            {
            l5=new GLabel("Player 1-Q  Player 2-B  Player 3-P");
        }
        GLabel l6=new GLabel("Click to continue");
        l1.setFont("SansSerif-bold-20");
        l2.setFont("SansSerif-20");
        l3.setFont("SansSerif-20");
        l4.setFont("SansSerif-20");
        l5.setFont("SansSerif-20");
        l6.setFont("SansSerif-20");
        add(l1,getWidth()/2-l1.getWidth()/2,20);
        add(l2,getWidth()/2-l2.getWidth()/2,50);
        add(l3,getWidth()/2-l3.getWidth()/2,90);
        add(l4,getWidth()/2-l4.getWidth()/2,120);
        add(l5,getWidth()/2-l5.getWidth()/2,150);
        add(l6,getWidth()/2-l6.getWidth()/2,190);
        waitForClick();
        removeAll();
    }
   
}
