
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shashwat
 */
import acm.graphics.*;
import java.awt.*;
public class track extends GCompound{

    /**
     *
     */
    public static double lanewidth;
    public track(int pla,int Width,int Height)
            {
                int a=pla*2+2;
                GRect whole=new GRect(Width,Height);
                whole.setFilled(true);
                whole.setFillColor(Color.LIGHT_GRAY);
                GRect side1=new GRect(Width/a,Height);
                side1.setFilled(true);
                side1.setFillColor(Color.green);
                GRect side2=new GRect(Width/a,Height);
                side2.setFilled(true);
                side2.setFillColor(Color.green);
                GRect line1=new GRect(0.01*Width,Height);
                GRect line2=new GRect(0.01*Width,Height);
                GRect line3=new GRect(0.01*Width,Height);
                GRect line4=new GRect(0.01*Width,Height);
                line4.setFilled(true);
                line4.setFillColor(Color.WHITE);
                line1.setFilled(true);
                line1.setFillColor(Color.WHITE);
                line2.setFilled(true);
                line2.setFillColor(Color.WHITE);
                line3.setFilled(true);
                line3.setFillColor(Color.WHITE);
                lanewidth=Width/a;
                add(whole,0,0);
                add(side1,0.0,0.0);
                add(line1,side1.getWidth(),0);
                if(pla>=2)
                {
                    add(line2,side1.getWidth()*3,0.0);
                }
                if(pla==3)
                {
                    add(line3,side1.getWidth()*5,0);
                }
                add(line4,whole.getWidth()-side2.getWidth()-line4.getWidth(),0);
                
                add(side2,whole.getWidth()-side1.getWidth(),0);
            }
    
    
    
}
