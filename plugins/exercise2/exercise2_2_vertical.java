// by Frederik Holfeld

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class exercise2_2_vertical implements PlugInFilter {

  public int setup(String args, ImagePlus im) {
    return DOES_8G;
  }

  public void run(ImageProcessor ip) {
    int maxY = ip.getHeight();
    int maxX = ip.getWidth();
    int middle = maxY / 2;

    for (int x = 0; x < maxX; x++) {
      for (int y = 0; y < middle; y++) {
        int temp = ip.getPixel(x, y);
        ip.putPixel(x, y, ip.getPixel(x, maxY - y - 1));
        ip.putPixel(x, maxY - y - 1, temp);
      }
    }
  }
}
