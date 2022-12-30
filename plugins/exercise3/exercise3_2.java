// by Frederik Holfeld

import ij.*;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import ij.process.ByteProcessor;

public class exercise3_2 implements PlugInFilter {

  public int setup(String args, ImagePlus im) {
    return DOES_8G + NO_CHANGES;
  }

  public void run(ImageProcessor ip) {
    int maxY = ip.getHeight();
    int maxX = ip.getWidth();
    int[] histogram = new int[256];

    for (int y = 0; y < maxY; y++) {
      for (int x = 0; x < maxX; x++) {
        histogram[ip.getPixel(x, y)]++;
      }
    }

    int max = 0;
    // for (int i = 0; i < 256; i++) {
    //   if (histogram[i] > max) max = histogram[i];
    // }


    for (int i = 1; i < 256; i++) {
      histogram[i] = histogram[i] + histogram[i - 1];
    }


    // for (int i = 0; i < histogram.length; i++) {
    //   IJ.showMessage(histogram[i] + "");
    // }

    int histMaxX = 256;
    int histMaxY = 150;
    ImageProcessor histIp = new ByteProcessor(histMaxX, histMaxY);
    histIp.setValue(255);
    histIp.fill();


    int val = 0;
    max = histogram[255];
    for (int x = 0; x < histMaxX; x++) {
      val = (int) (histogram[x] / (double) max * histMaxY);
      for (int y = histMaxY - 1; y > histMaxY - val; y--) {
        histIp.putPixel(x, y, 0);
      }
    }

    ImagePlus histImg = new ImagePlus("Test", histIp);
    histImg.show();
  }
}
