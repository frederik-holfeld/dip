// by Frederik Holfeld

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class exercise2_4 implements PlugInFilter {

  public int setup(String args, ImagePlus im) {
    return DOES_8G;
  }

  public void run(ImageProcessor ip) {
    int maxY = ip.getHeight();
    int maxX = ip.getWidth();

    for (int x = 0; x < maxX; x++) {
      for (int y = 0; y < maxY; y++) {
        if ((x < 10 || x >= maxX - 10) || (y < 10 || y >= maxY - 10)) {
          ip.putPixel(x, y, 255);
        }
      }
    }
  }
}
