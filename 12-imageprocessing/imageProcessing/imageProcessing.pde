void setup(){
  size(1450,500);
  PImage car = loadImage("redcar.jpg");
  PImage output = car.copy();
  //identity:
  //Kernel k = new Kernel( new float[][]    { {0, 0, 0},
  //   {0, 1, 0},
  // {0, 0, 0} } );
  //k.apply(car,output);
  //blur:
  //Kernel g = new Kernel( new float[][] { {0.0625, 0.125, 0.0625},
  //{0.125, 0.250, 0.125},
  //{0.0625, 0.125, 0.0625} } );
  //g.apply(car, output);
  Kernel k = new Kernel( new float[][]    { {-1, -1, -1},
     {-1, 8, -1},
   {-1, -1, -1} } );
  k.apply(car,output);
  image(car,0,0);
  image(output,car.width,0);
}
