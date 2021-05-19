import java.util.Arrays;
public class Kernel {
  float[][]kernel;

  /*Constructor takes the kernel that will be applied to the image
    This implementation only allows 3x3 kernels*/
  public Kernel(float[][]init) {
    kernel = new float[init.length][];
    for (int i = 0; i < init.length; i++) {
      kernel[i] = init[i].clone();
    }
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    int r = 0;
    int g = 0;
    int b = 0;
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        color c = img.get(x+i-1, y+j-1);
        r += kernel[i][j]*red(c);
        g += kernel[i][j]*green(c);
        b += kernel[i][j]*blue(c);
      }
    }
    return color(r, g, b);
  }


  /*Assume the destination is the same dimensions as the source.

  */
  void apply(PImage source, PImage destination) {
    for (int x = 0; x < source.width; x++) {
      for (int y = 0; y < source.height; y++) {
        if (x == 0 || x == source.width || y == 0 || y == source.height) {
          destination.set(x, y, 0);
        }
        else {
          color newColor = calcNewColor(source, x, y);
          destination.set(x, y, newColor);
        }
      }
    }
  }

}
