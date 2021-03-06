package com.samples.nasaww;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

import javax.swing.*;

/** This example demonstrates the simplest possible way
to create a WorldWind application. */
public class FirstShot extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1913647701268424645L;

	public FirstShot()
    {
        WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
        wwd.setPreferredSize(new java.awt.Dimension(1000, 800));
        this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
        wwd.setModel(new BasicModel());
    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
            	JFrame frame;
            	try{
            		frame = new FirstShot();
            		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
            	}
            	catch(Exception e){
            		System.out.println("Do nothing");
            		
            	}
                
            }
        });
    }
}