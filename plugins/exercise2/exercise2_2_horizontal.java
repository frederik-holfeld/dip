// by Frederik Holfeld

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class exercise2_2_horizontal implements PlugInFilter {

  public int setup(String args, ImagePlus im) {
    return DOES_8G;
  }

  public void run(ImageProcessor ip) {
    int maxY = ip.getHeight();
    int maxX = ip.getWidth();
    int middle = maxX / 2;

    for (int y = 0; y < maxY; y++) {
      for (int x = 0; x < middle; x++) {
        int temp = ip.getPixel(x, y);
        ip.putPixel(x, y, ip.getPixel(maxX - x - 1, y));
        ip.putPixel(maxX - x - 1, y, temp);
      }
    }
  }
}
