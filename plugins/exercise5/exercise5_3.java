// by Frederik Holfeld

import ij.*;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import ij.process.ByteProcessor;

public class exercise5_3 implements PlugInFilter {
  // ImagePlus im;

  public int setup(String args, ImagePlus im) {
    // this.im = im;
    return DOES_8G + NO_CHANGES;
  }

  public void run(ImageProcessor ip) {
    int maxY = ip.getHeight();
    int maxX = ip.getWidth();

    int gaussMaxX = maxX;
    int gaussMaxY = maxY;
    ImageProcessor gaussIp = new ByteProcessor(gaussMaxX, gaussMaxY);

    ImagePlus gaussImg = new ImagePlus("Gaussed image", gaussIp);

    float[] gaussMask = makeGaussKernel1d(10);
    double gaussSum = 0;
    for (int i = 0; i < gaussMask.length; i++) {
      gaussSum += gaussMask[i];
    }
    IJ.showMessage(gaussSum + "");

    // for (int i = 0; i < newFloat.length; i++) {
    //   IJ.showMessage(newFloat[i] + " " + i);
    // }

    double val = 0;
    for (int y = 0; y < gaussImg.getHeight(); y++) {
      for (int x = 0; x < gaussImg.getWidth(); x++) {
        for (int i = 0; i < gaussMask.length; i++) {
          val += gaussMask[i] * ip.getPixel(x - (gaussMask.length / 2) + i, y);
        }
        gaussIp.putPixel(x, y, (int) (val / gaussSum));
        val = 0;
      }

    }

    gaussImg.show();
  }

// This function was already given on the assignment sheet.

  float[] makeGaussKernel1d(double sigma) {
    int center = (int) (3. * sigma);
    float[] h = new float[2 * center + 1];

    double sigma2 = sigma * sigma;
    for (int i = 0; i < h.length; i++) {
      double r = center - i;
      h[i] = (float) Math.exp(-0.5 * (r * r) / sigma2);
    }
    return h;
  }
}
