///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            P2
// Files:            P2.java, ListADT.java, ListNode.java, NodeChain.java, 
//                   LLStack.java, StackADT.java
// Semester:         CS367 Summer 2014
//
// Author:           Zak Scholl
// Email:            zscholl@wisc.edu
// CS Login:         scholl
// Lecturer's Name:  M. Hidayath Ansari
//
///////////////////////////////////////////////////////////////////////////////
import stack.*;

import java.io.*;
import java.util.Scanner;
/**
 * This is the main class, used to evaluate post-fix expressions and the state
 * of balanced parenthesis in expressions.
 * 
 * <p>These are each evaluated line by line from a text file, expressions to be 
 * balanced begin with the keyword "bal" and post-fix expressions evaluated 
 * will begin with the keyword "eval"
 * 
 * @author zakscholl
 *
 */
public class P2 {

	/**
	 * This is the main method which evaluates the expressions in the text
	 * file passed as the first command line argument.
	 * @param args
	 */
	public static void main(String[] args) {

		// Check for exactly one argument
		if (args.length != 1) {
			System.out.println("Usage: java P2 filename");
			System.exit(0);
		}
		//instantiate new file with first command line argument
		File expressions = new File(args[0]);

		// Check if it exists and can be read
		if (!expressions.exists() || !expressions.canRead()) {
			System.out.println("Error: invalid file");
			System.exit(0);
		}

		try {
			//Create scanner for input file
			Scanner fileSCNR = new Scanner(expressions);
			
			//repeats the following steps for every line of the input file
			while (fileSCNR.hasNextLine()) {
				
				String check = fileSCNR.next();//save the keyword "bal" or "eval"
				
				//save the expression, trimming whitespace
				String evaluate = fileSCNR.nextLine().trim(); 
			
				switch (check) {
				// if balancing expression
				case "bal":
					
					//stack to save each token of the expression
					LLStack<Character> balancer = new LLStack<Character>();
					
					//boolean variable to indicate balance status
					boolean isBalanced = true;
					
					// for each character in the expression
					balance: for (int i = 0; i < evaluate.length(); i++) {
						
						char tmp = evaluate.charAt(i);

						// if a valid open parenthesis add to stack
						if (tmp =='(' || tmp == '{' || tmp == '['
								|| tmp == '<') {
							balancer.push(tmp);
						}
						// if a closing, valid parenthesis
						else if (tmp == ')' || tmp == '}' || tmp == ']'
								|| tmp == '>') {
							
							//if there is not opening bracket in stack
							if (balancer.isEmpty()){
								System.out.println("not balanced");
								isBalanced = false;
								break balance;
							}
							// check if top of stack is matching open bracket
							// and print result if not
							switch (tmp) {
							case ')':
								if ( balancer.pop() != '(') {
									System.out.println("not balanced");
									isBalanced = false;
									break balance;
								}
								break;
							case '}':
								if (balancer.pop() != '{') {
									System.out.println("not balanced");
									isBalanced = false;
									break balance;
								}
								break;
							case ']':
								if (balancer.pop() != '[') {
									System.out.println("not balanced");
									isBalanced = false;
									break balance;
								}
								break;
							case '>':
								if (balancer.pop() != '<') {
									System.out.println("not balanced");
									isBalanced = false;
									break balance;
								}
								break;
							default:
								break;

							}
						}
						
					}
			//if it made it through and didn't trigger non balanced boolean set
					if (isBalanced) {
						System.out.println("balanced");
					}
					break;
					
				//if keyword is eval
				case "eval":
					//stack to hold the valid doubles in the expression
					LLStack<Double> doubleStack = new LLStack<Double>();
					
					//scanner for the expression line
					Scanner lineScnr = new Scanner(evaluate);
					
					//repeat while there are tokens left in the expression
					while (lineScnr.hasNext()) {

						//if token is a double push it onto the stack
						if (lineScnr.hasNextDouble()) {
							doubleStack.push(lineScnr.nextDouble());
							continue;
						}
						//if not double, enter switch statement
						switch (lineScnr.next().trim()) {
						
						case "+":
							doubleStack.push(doubleStack.pop() + doubleStack.pop());
							break;
							
						case "-":
							double tmp = doubleStack.pop();
							double tmp1 = doubleStack.pop();
							doubleStack.push(tmp1- tmp);
							break;
							
						case "*":
							doubleStack.push(doubleStack.pop() * doubleStack.pop());
							break;
							
						case "/":
							double tmp2 = doubleStack.pop();
							double tmp3 = doubleStack.pop();
							doubleStack.push(tmp3 / tmp2);
							break;
							
						case "%":
							double tmp4 = doubleStack.pop();
							double tmp5 = doubleStack.pop();
							doubleStack.push(tmp5 % tmp4);
							break;
							
						case "sqrt":
							doubleStack.push(Math.sqrt(doubleStack.pop()));
							break;
							
						case "abs":
							doubleStack.push(Math.abs(doubleStack.pop()));
							break;
							
						case "u-":
							doubleStack.push(0 - doubleStack.pop());
							break;
							
						case "sp":
							double c = doubleStack.pop();
							double b = doubleStack.pop();
							double a = doubleStack.pop();
							doubleStack.push(Math.pow((a + b)- c, 3));
							break;
							
						default:
							break;

						}
					}
		//print result of expression evaluation, limiting to two decimals after zero
					System.out.printf("%.2f%n", doubleStack.pop());
					break;
				default:
					break;

				}
			}
			fileSCNR.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + args[0] + " was not found");
		}

	}

}
 