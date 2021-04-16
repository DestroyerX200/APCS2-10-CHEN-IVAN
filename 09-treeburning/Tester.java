import java.util.*;
public class Tester {
	public static void main(String[] args) {
		int size = 1000;
    double density = .7;
    int trials = 1;
		if(args.length > 1){
			size = Integer.parseInt(args[0]);
			density = Double.parseDouble(args[1]);
			trials = Integer.parseInt(args[2]);
		}
		BurnTrees b = new BurnTrees(size, size, density);
		int totalSteps=0;
		long totalTime=0;
		for(int i=0; i<trials; i++) {
			long start = System.currentTimeMillis();
			totalSteps += b.run();
			totalTime += System.currentTimeMillis()-start;
		}
		System.out.println("time: " + totalTime);
		System.out.println("steps: " + totalSteps);
	}
}