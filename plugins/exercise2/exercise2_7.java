// by Frederik Holfeld

import ij.*;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class exercise2_7 implements PlugInFilter {
  ImagePlus im;

  public int setup(String args, ImagePlus im) {
    this.im = im;
    return DOES_8G;
  }

  public void run(ImageProcessor ip) {
    int maxY = ip.getHeight();
    int maxX = ip.getWidth();
    int temp;

    for (int runs = 0; runs < maxX; runs++) {
      for (int y = 0; y < maxY; y++) {
        temp = ip.getPixel(maxX - 1, y);
        int x = maxX - 2;
        for (; x >= 0; x--) {
          ip.putPixel(x + 1, y, ip.getPixel(x, y));
        }
        ip.putPixel(0, y, temp);
      }
      im.updateAndDraw();
    }
  }
}
