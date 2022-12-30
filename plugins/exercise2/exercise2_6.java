// by Frederik Holfeld

import ij.*;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class exercise2_6 implements PlugInFilter {

  public int setup(String args, ImagePlus im) {
    return DOES_8G;
  }

  public void run(ImageProcessor ip) {
    int maxY = ip.getHeight();
    int maxX = ip.getWidth();
    int maxVal = ip.getPixel(0, 0);
    int minVal = ip.getPixel(0, 0);

    for (int x = 0; x < maxX; x++) {
      for (int y = 0; y < maxY; y++) {
        if (ip.getPixel(x, y) > maxVal) maxVal = ip.getPixel(x, y);
        else if (ip.getPixel(x, y) < minVal) minVal = ip.getPixel(x, y);
      }
    }
    IJ.log("Max intensity: " + maxVal);
    IJ.log("Min intensity: " + minVal);
  }
}
