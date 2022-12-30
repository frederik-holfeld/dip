// by Frederik Holfeld

import ij.*;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class exercise2_5 implements PlugInFilter {

  public int setup(String args, ImagePlus im) {
    return DOES_8G;
  }

  public void run(ImageProcessor ip) {
    int maxY = ip.getHeight();
    int maxX = ip.getWidth();
    long sum = 0;

    for (int x = 0; x < maxX; x++) {
      for (int y = 0; y < maxY; y++) {
        sum += ip.getPixel(x, y);
      }
    }
    IJ.log(sum + "");
    IJ.log("The maximum number of pixels an image can have for an int to always work is " + Integer.MAX_VALUE / 255 + ".");
    IJ.log(Integer.MAX_VALUE / 255 + " * 255 does not cause any overflow: " + Integer.MAX_VALUE / 255 * 255);
    IJ.log(Integer.MAX_VALUE / 255 + 1 + " * causes an overflow: " + (Integer.MAX_VALUE / 255 + 1) * 255);
  }
}
