import java.util.ArrayDeque;
import java.lang.IllegalArgumentException;
public class Calculator {
	/*Evaluate a postfix expression stored in s.
	 *Assume valid postfix notation, of ints doubles and operators separated by spaces.
	 *Valid operators are + - / * and % (remainder not modulo)
	 *All results are doubles even if the operands are both int.
	 *@throws IllegalArgumentException when there are too many or too few operands.
	 *        Use the string parameter of your exception to indicate what happened.
	 */
	public static double eval(String s) {
		String[] tokens = s.split(" ");
		ArrayDeque<Double> stack = new ArrayDeque<Double>(s.length());
		for (int i=0; i<tokens.length;i++) {
			if ("+-/*%".indexOf(tokens[i]) > -1) {
				if (stack.size() < 2) {
					throw new IllegalArgumentException("too few operands");
				}
				if (tokens[i].equals("+")) {
					stack.push(stack.pop()+stack.pop());
				}
				else if (tokens[i].equals("-")) {
					double rightOperand = stack.pop();
					double leftOperand = stack.pop();
					stack.push(leftOperand-rightOperand);
				}
				else if (tokens[i].equals("/")) {
					double rightOperand = stack.pop();
					double leftOperand = stack.pop();
					stack.push(leftOperand/rightOperand);					
				}
				else if (tokens[i].equals("*")) {
					stack.push(stack.pop()+stack.pop());
				}
				else if (tokens[i].equals("%")) {
					double rightOperand = stack.pop();
					double leftOperand = stack.pop();
					stack.push(leftOperand % rightOperand);					
				}
				else {
					stack.push(Double.parseDouble(tokens[i]) );
				}
			}
		}
		if (stack.size() == 1) {
			return stack.pop();
		}
		else {
			throw new IllegalArgumentException("too many operands");
		}
	}
        
}