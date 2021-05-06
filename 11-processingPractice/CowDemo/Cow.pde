public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding, selected;

  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    stroke(0);
    fill(c);
    ellipse(x, y, radius*2, radius*2);
    if (selected) {
      //eyes
      float dyEye, dxEye;
      dxEye = 0.5 * radius;
      dyEye = 0.5 * radius;
      fill(255);
      ellipse(x-dxEye, y-dyEye, radius/4, radius/4);
      ellipse(x+dxEye, y-dyEye, radius/4, radius/4);
      fill(0);
      ellipse(x-dxEye, y-dyEye, radius/10, radius/10);
      ellipse(x+dxEye, y-dyEye, radius/10, radius/10);
      //mouth
      fill(255);
      arc(x, y, radius, radius, PI/8, PI-PI/8, CHORD);
    }
  }

  void click(){
    if (dist((float)mouseX, (float)mouseY, x, y)<= radius) {
      selected = !selected;
    }
    
  }
}
