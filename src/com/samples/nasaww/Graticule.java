package com.samples.nasaww;

import gov.nasa.worldwind.layers.LatLonGraticuleLayer;
import gov.nasa.worldwindx.examples.ApplicationTemplate;

public class Graticule extends ApplicationTemplate
{
    public static class AppFrame extends ApplicationTemplate.AppFrame
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = -1869402835430206271L;

		public AppFrame()
        {
            super(true, true, false);

            // Add graticule
            insertBeforePlacenames(this.getWwd(), new LatLonGraticuleLayer());

            // Update layer
            this.getLayerPanel().update(this.getWwd());
        }
    }

    public static void main(String[] args)
    {
        ApplicationTemplate.start("Getting Started with NASA World Wind", AppFrame.class);
    }
}
