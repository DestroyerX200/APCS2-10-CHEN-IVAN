import java.util.*;
public class Tester {
	public static void main(String[] args) {
		int WIDTH = 20;
    int HEIGHT = 20;
    int DELAY = 200;
    double DENSITY = .7;
		if(args.length > 1){
			WIDTH = Integer.parseInt(args[0]);
			HEIGHT = Integer.parseInt(args[1]);
			DENSITY = Double.parseDouble(args[2]);
		}
		if(args.length > 3){
			DELAY = Integer.parseInt(args[3]);
		}
		BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);
		int totalSteps=0;
		long totalTime=0;
		for(int i=0; i<1; i++) {
			long start = System.currentTimeMillis();
			totalSteps += b.run();
			totalTime += System.currentTimeMillis()-start;
		}
		System.out.println("time: " + totalTime);
		System.out.println("steps: " + totalSteps);
	}
}