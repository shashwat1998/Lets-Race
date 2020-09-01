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
import acm.program.*;
import java.awt.*;
import java.awt.event.*;

public class GCar extends GCompound {
    
    public GCar(Color a)
    {
        double width=40.0,height=60.0;
        GPolygon p1= new GPolygon();
        p1.addVertex(0,0);
        p1.addVertex(width,0);
        p1.addVertex(0.90*width,0.10*height);
        p1.addVertex(0.10*width,0.10*height);
        p1.setFilled(true);
        p1.setFillColor(Color.YELLOW);
        GRect fbum=new GRect(0.33*width,0.10*height);
        GRect rbum=new GRect(0.33*width,0.10*height);
        fbum.setFilled(true);
        rbum.setFilled(true);
        GRect shield=new GRect(0.8*width,0.3*height);
        shield.setFilled(true);
        shield.setFillColor(Color.LIGHT_GRAY);
        GRect roof=new GRect(0.8*width,0.5*height);
        roof.setFilled(true);
        GRect body=new GRect(width,height);
        body.setFilled(true);
        body.setFillColor(a);
        GRect roof1=new GRect(0.33*width,0.5*height);
        roof.setFilled(true);
        roof1.setFilled(true);
        roof1.setFillColor(a);
        add(body,0+0.1*width,0);
        add(p1,0+0.1*width,0);
        add(shield,0.10*width+0.1*width,0.10*height);
        add(roof,0.1*width+0.1*width,0.4*height);
        add(roof1,0.33*width+0.1*width,0.4*height);
        add(fbum,0.33*width+0.1*width,0);
        add(rbum,0.33*width+0.1*width,0.9*height);
        GRect w1=new GRect(0.1*width,0.2*height);
        w1.setFilled(true);
        GRect w2=new GRect(0.1*width,0.2*height);
        w2.setFilled(true);
        GRect w3=new GRect(0.1*width,0.2*height);
        w3.setFilled(true);
        GRect w4=new GRect(0.1*width,0.2*height);
        w4.setFilled(true);
        add(w1,0,0.2*height);
        add(w2,0,0.7*height);
        add(w3,width+ 0.1*width,0.2*height);
        add(w4,width+ 0.1*width,0.7*height);
        
        
    }
    
}
