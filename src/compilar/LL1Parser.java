package compilar;

import java.util.ArrayList;
import java.util.Stack;

public class LL1Parser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * @author Moataz
	 * @see initialize the stacks with the values 
	 */
	static public Stack parsingStack ;
	static public Stack inputStack ;
	public LL1Parser(ArrayList<token> tk) {
//		---------------- step 2 ----------------------------
		// create 2 stacks 
			// parsing stack start with $
		parsingStack = new Stack();
				// push into it the starting symbol  
			// input stack end with $ 
		inputStack = new Stack();
//		------------------------------- end step 2 --------------------------------
		int i = 0 ; // initialized for the input stack ,
		
		parsingStack.push(new String("$"));
		parsingStack.push(new String("program"));
		
		inputStack.push(new String("$"));
		
		while(i != tk.size()-2){
			inputStack.push(new String(tk.get(i).getTokenType().toString()));
			i++;
		}
	}
	
//	------------------ step 1 --------------------------
	// step 1 : construct the parsing table
	// the row is identified by the first array and the column is identified by the 2nd array

	
//	----------------------- end step 1 -----------------------------
	

	
	
//	--------------------- step 3 apply LL1 function ------------------------------
	// see what in top of parsing stack and compare it with the 1stcolum values 
	// if it match pop the top and push the rule
	// if the top was terminal	 
		// check if the tockens are identical , if so pop from input stack then return true
	// the last else return -> false 
	
	/**
	 * @author Moataz
	 * @see This function apply the LL1 parsing Rules 
	 * @param no parameters since the 2 stacks (input and parsing ) are Global 
	 * @return boolean : true when the tokens are identical and the top element in input stack is terminated 
	 * 
	 */
	public static boolean applyLL1(){
		int pos = parsingStack.size();
				boolean flag = true;
				while(flag == true){
					if(inputStack.peek().toString().equals("if")){
						// column rule at numbers available 

						if(parsingStack.peek().toString().equals("program")){
							if(!doAction(1))return false;
						}else if(parsingStack.peek().toString().equals("stmt-sequence")){
							if(!doAction(2))return false;
						}else if(parsingStack.peek().toString().equals("statement")){
							if(!doAction(5))return false;
						}else if(parsingStack.peek().toString().equals("if-stmt")){
							if(!doAction(10))return false;
						}else{
							
							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("repeat")){
						
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("program")){
							if(!doAction(1))return false;
						}else if(parsingStack.peek().toString().equals("stmt-sequence")){
							if(!doAction(2))return false;
						}else if(parsingStack.peek().toString().equals("statement")){
							if(!doAction(6))return false;
						}else if(parsingStack.peek().toString().equals("repeat-stmt")){
							if(!doAction(13))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("identifier")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("program")){
							if(!doAction(1))return false;
						}else if(parsingStack.peek().toString().equals("stmt-sequence")){
							if(!doAction(2))return false;
						}else if(parsingStack.peek().toString().equals("statement")){
							if(!doAction(7))return false;
						}else if(parsingStack.peek().toString().equals("assign-stmt")){
							if(!doAction(14))return false;
						}else if(parsingStack.peek().toString().equals("exp")){
							if(!doAction(17))return false;
						}else if(parsingStack.peek().toString().equals("simple-exp")){
							if(!doAction(22))return false;
						}else if(parsingStack.peek().toString().equals("term")){
							if(!doAction(27))return false;
						}else if(parsingStack.peek().toString().equals("factor")){
							if(!doAction(34))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("read")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("program")){
							if(!doAction(1))return false;
						}else if(parsingStack.peek().toString().equals("stmt-sequence")){
							if(!doAction(2))return false;
						}else if(parsingStack.peek().toString().equals("statement")){
							if(!doAction(8))return false;
						}else if(parsingStack.peek().toString().equals("read-stmt")){
							if(!doAction(15))return false;
							
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("write")){
						
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("program")){
							if(!doAction(1))return false;
						}else if(parsingStack.peek().toString().equals("stmt-sequence")){
							if(!doAction(2))return false;
						}else if(parsingStack.peek().toString().equals("statement")){
							if(!doAction(9))return false;
						}else if(parsingStack.peek().toString().equals("write-stmt")){
							if(!doAction(16))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals(";")){

						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("stmt-sequence`")){
							if(!doAction(3))return false;
						}else if(parsingStack.peek().toString().equals("exp`")){
							if(!doAction(19))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("until")){

						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("stmt-sequence`")){
							if(!doAction(4))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("else")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("stmt-sequence`")){
							if(!doAction(4))return false;
						}else if(parsingStack.peek().toString().equals("if-stmt`")){
							if(!doAction(11))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("end")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("stmt-sequence`")){
							if(!doAction(4))return false;
						}else if(parsingStack.peek().toString().equals("if-stmt`")){		
							if(!doAction(12))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("(")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("exp")){
							if(!doAction(17))return false;
						}else if(parsingStack.peek().toString().equals("simple-exp")){
							if(!doAction(22))return false;
						}else if(parsingStack.peek().toString().equals("term")){
							if(!doAction(27))return false;
						}else if(parsingStack.peek().toString().equals("factor")){
							if(!doAction(32))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals(")")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("exp`")){
							if(!doAction(19))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals(">")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("exp`")){
							if(!doAction(18))return false;
						}else if(parsingStack.peek().toString().equals("simple-exp`")){
							if(!doAction(24))return false;
						}else if(parsingStack.peek().toString().equals("comparison-op")){
							if(!doAction(20))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("assign")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("exp`")){
							if(!doAction(18))return false;
						}else if(parsingStack.peek().toString().equals("simple-exp`")){
							if(!doAction(24))return false;
						}else if(parsingStack.peek().toString().equals("comparison-op")){
							if(!doAction(21))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("-")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("term`")){
							if(!doAction(29))return false;
						}else if(parsingStack.peek().toString().equals("simple-exp`")){
							if(!doAction(23))return false;
						}else if(parsingStack.peek().toString().equals("addop")){
							if(!doAction(26))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("+")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("term`")){
							if(!doAction(29))return false;
						}else if(parsingStack.peek().toString().equals("simple-exp`")){
							if(!doAction(23))return false;
						}else if(parsingStack.peek().toString().equals("addop")){
							if(!doAction(25))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("number")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("exp`")){
							if(!doAction(17))return false;
						}else if(parsingStack.peek().toString().equals("simple-exp")){
							if(!doAction(22))return false;
						}else if(parsingStack.peek().toString().equals("term")){
							if(!doAction(27))return false;
						}else if(parsingStack.peek().toString().equals("factor")){
							if(!doAction(33))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("*")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("term`")){
							if(!doAction(28))return false;
						}else if(parsingStack.peek().toString().equals("mulop")){
							if(!doAction(30))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}
					else if (inputStack.peek().toString().equals("/")){
						// column rule at numbers available 
						if(parsingStack.peek().toString().equals("exp`")){
							if(!doAction(19))return false;
						}else if(parsingStack.peek().toString().equals("term`")){
							if(!doAction(28))return false;
						}else if(parsingStack.peek().toString().equals("mulop")){
								if(!doAction(31))return false;
						}else{

							System.out.println("error");
							return false;
						}
					}

					else if (inputStack.peek().toString().equals("$")){
						flag = false;
						return true;
					}

				}
		
		return false;
	} 
	
// --------------------- end step 3 apply LL1 function ------------------------------
	
	/**
	 * @desc this function apply the rules given by numbers
	 * @param int i which is the rule number 
	 * @return boolean 
	 * @author Moataz
	 */
	public static boolean doAction(int i) {
		switch (i) {
		case 1:
			
			parsingStack.pop();
			parsingStack.push(new String("stmt-sequence"));
			ismatch();
			break;
		case 3:
			
			parsingStack.pop();
			parsingStack.push(new String("stmt-sequence`"));
			parsingStack.push(new String("statement"));
			parsingStack.push(new String("semicolon"));
			ismatch();
			break;
		case 2:
			
			parsingStack.pop();
			parsingStack.push(new String("stmt-sequence"));
			parsingStack.push(new String("statement"));
			ismatch();
			break;
		case 4:
			
			parsingStack.pop();
			ismatch();
			break;
		case 5:
			
			parsingStack.pop();
			parsingStack.push(new String("if-stmt"));
			ismatch();
			break;
		case 6:
			
			parsingStack.pop();
			parsingStack.push(new String("repeat-stmt"));
			ismatch();
			break;
		case 7:
			
			parsingStack.pop();
			parsingStack.push(new String("assign-stmt"));
			ismatch();
			break;
		case 8:
			
			parsingStack.pop();
			parsingStack.push(new String("read-stmt"));
			ismatch();
			break;
		case 9:
			
			parsingStack.pop();
			parsingStack.push(new String("write-stmt"));
			ismatch();
			
			break;
		case 10:
			
			parsingStack.pop();
			parsingStack.push(new String("if-stmt`"));
			parsingStack.push(new String("stmt-sequence"));
			parsingStack.push(new String("then"));
			parsingStack.push(new String("exp"));
			parsingStack.push(new String("if"));
			ismatch();
			
			break;
		case 11:
			
			parsingStack.pop();
			parsingStack.push(new String("end"));
			parsingStack.push(new String("stmt-sequence"));
			parsingStack.push(new String("else"));
			ismatch();
			
			break;
		case 12:
			
			parsingStack.pop();
			parsingStack.push(new String("else"));
			ismatch();
			
			break;
		case 13:
			
			parsingStack.pop();
			parsingStack.push(new String("exp"));
			parsingStack.push(new String("until"));
			parsingStack.push(new String("stmt-sequence"));
			parsingStack.push(new String("repeat"));
			ismatch();
			break;
		case 14:
			
			parsingStack.pop();
			parsingStack.push(new String("exp"));
			parsingStack.push(new String("assign"));
			parsingStack.push(new String("identifier"));
			ismatch();
			
			break;
		case 15:
			
			parsingStack.pop();
			parsingStack.push(new String("identifier"));
			parsingStack.push(new String("read"));
			ismatch();
			
			break;
		case 16:
			
			parsingStack.pop();
			parsingStack.push(new String("simple-exp"));
			parsingStack.push(new String("write"));
			ismatch();
			
			break;
		case 17:
			
			parsingStack.pop();
			parsingStack.push(new String("exp`"));
			parsingStack.push(new String("simple-exp"));
			ismatch();
			
			break;
		case 18:
			
			parsingStack.pop();
			parsingStack.push(new String("simple-exp"));
			parsingStack.push(new String("comparison-op"));
			ismatch();
			
			break;
		case 19:
			
			parsingStack.pop();
			ismatch();
			break;
		case 20:
			
			parsingStack.pop();
			parsingStack.push(new String("<"));
			ismatch();
			break;
		case 21:
			
			parsingStack.pop();
			parsingStack.push(new String("assign"));
			ismatch();
			break;
		case 22:
			
			parsingStack.pop();
			parsingStack.push(new String("simple-exp`"));
			parsingStack.push(new String("term"));
			ismatch();
			break;
		case 23:
			parsingStack.pop();
			parsingStack.push(new String("simple-exp`"));
			parsingStack.push(new String("term"));
			parsingStack.push(new String("addop"));
			ismatch();
			break;
		case 24:
			
			parsingStack.pop();
			ismatch();
			break;
		case 25:
			parsingStack.pop();
			parsingStack.push(new String("+"));
			ismatch();
			break;
		case 26:
			
			parsingStack.pop();
			parsingStack.push(new String("-"));
			ismatch();
			break;
		case 27:
			parsingStack.pop();
			parsingStack.push(new String("term`"));
			parsingStack.push(new String("factor"));
			ismatch();
			
			break;
		case 28:
			parsingStack.pop();
			parsingStack.push(new String("term`"));
			parsingStack.push(new String("factor"));
			parsingStack.push(new String("mulop"));
			ismatch();
			
			break;
		case 29:
			parsingStack.pop();
			ismatch();
			
			break;
		case 30:
			parsingStack.pop();
			parsingStack.push(new String("*"));
			ismatch();
			
			break;
		case 31:
			parsingStack.pop();
			parsingStack.push(new String("/"));
			ismatch();
			
			break;
		case 32:
			parsingStack.pop();
			parsingStack.push(new String(")"));
			parsingStack.push(new String("exp"));
			parsingStack.push(new String("("));
			ismatch();
			
			break;
		case 33:
			parsingStack.pop();
			parsingStack.push(new String("number"));
			ismatch();
			
			break;
		case 34:
			
			parsingStack.pop();
			parsingStack.push(new String("identifier"));
			ismatch();
			break;
		
		default:
			return false;
			
		}
		return true;
	}
	
	public static void ismatch(){
		if(parsingStack.peek().toString().equals(inputStack.peek().toString())){
			inputStack.pop();
			parsingStack.pop();
		}

	}
}
