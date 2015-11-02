package com.samples.nasaww;

import gov.nasa.worldwind.Configuration;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.*;
import gov.nasa.worldwind.util.BasicDragger;
import gov.nasa.worldwindx.examples.ApplicationTemplate;

import java.util.ArrayList;

public class ShapeAttributes extends ApplicationTemplate
{
    public static class AppFrame extends ApplicationTemplate.AppFrame
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AppFrame()
        {
            super(true, true, false);

            //Enable shape dragging, if you want.
            this.getWwd().addSelectListener(new BasicDragger(this.getWwd()));

            //Create the layer where you will place your polygons
            RenderableLayer layer = new RenderableLayer();

            // Set the basic attributes of your polygon
            BasicShapeAttributes normalAttributes = new BasicShapeAttributes();
            normalAttributes.setInteriorMaterial(Material.YELLOW);
            normalAttributes.setOutlineWidth(2);
            normalAttributes.setOutlineOpacity(0.5);
            normalAttributes.setDrawInterior(true);
            normalAttributes.setDrawOutline(true);

            // Set the coordinates (in degrees) to draw your polygon
            // To radians just change the method the class Position
            // to fromRadians().
            ArrayList<Position> positions = new ArrayList<Position>();
            positions.add(Position.fromDegrees(52, 10, 5e4));
            positions.add(Position.fromDegrees(55, 11, 5e4));
            positions.add(Position.fromDegrees(55, 11, 5e4));
            positions.add(Position.fromDegrees(52, 14, 5e4));
            positions.add(Position.fromDegrees(52, 10, 5e4));
           

            Polygon poly = new Polygon(positions);

            poly.setAttributes(normalAttributes);
            //Tooltip text of the polygon
            poly.setValue(AVKey.DISPLAY_NAME, "Sample Polygon");
            //Add the just created polygon to a renderable layer
            layer.addRenderable(poly);
            // Add the layer to the model.
            insertBeforeCompass(getWwd(), layer);
            // Update layer panel
            this.getLayerPanel().update(this.getWwd());
        }
    }

    public static void main(String[] args)
    {
        //Set the initial configurations of your NASA World Wind App
    	//Altitute, logitude and latitute, and window caption.
    	Configuration.setValue(AVKey.INITIAL_LATITUDE, 54);
        Configuration.setValue(AVKey.INITIAL_LONGITUDE, 13);
        Configuration.setValue(AVKey.INITIAL_ALTITUDE, 190e4);
    	ApplicationTemplate.start("NASA World Wind Tutorial - Simple Polygons",
AppFrame.class);
    }
}