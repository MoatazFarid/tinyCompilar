package Scanner;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class tinyScanner {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String myin = new String("sum := sum 1");
		// testin the scanner 
		List<token> list = new ArrayList<token>();
		list = Scanner(myin);
		for (token temp : list) {
			System.out.println(temp.tockenValue);
			System.out.println(temp.tokenType);
		}
		
		// end testing the scanner

	}
	// enum contain the states 
	//enum States {START ,INNUM ,INID, INASSIGN , INCOMMENT, DONE };
	static boolean isRepeated(StringBuilder result , ArrayList<token> token_Bank){
//		for (int i = 0 ; i < token_Bank.size() ;i++){
//			if(result.substring(0).matches(token_Bank.get(i)))
//					//equals(token_Bank.get(i)))
//				return false;
//		}
		
		return false;
	}
	/*
	public static void TinyScanner(String expression) throws IOException{
		int character = 0;
		ArrayList<String> tokens = new ArrayList<String>();
		// current state
		int current_state =0;
		int next_state = 0;
		boolean comment =false;
		boolean res_w =false;
		
		//fill all array with false value 
		//Arrays.fill(tokens, Boolean.FALSE);
		// a string is cutted to char 
		StringReader s = new StringReader(expression);
		StringBuilder result = new StringBuilder();
		while(character < (expression.length()+1) ){
			char c = (char) s.read();
			current_state = next_state;
			if( (current_state==0)&&isSpace(c)){
				next_state= 0;
				
			}else if((current_state == 0)&&(c == '{')){
				next_state = 4;
				result.append(c);
				comment=true;
				
			}else if((current_state == 4)&&(c=='}')){
				next_state = 0;
				result.append(c);
			}
			else if((current_state == 4)&&(c!='}')){
				next_state = 4;
				result.append(c);
			}
			else if((current_state == 0)&&isDigit(c)){
				next_state = 1;
				result.append(c);
			}
			else if((current_state == 0)&&(isletter(c)) ){
				next_state = 2;
				result.append(c);
			}
			else if((current_state == 0)&&(c==':')){
				next_state= 3;
				result.append(c);
			}
			else if((current_state == 0)&&((c!=':')&& (!isSpace(c)) && !isDigit(c)&& !isletter(c))){
				next_state = 5;
				System.out.println("Error");
				next_state = 0;
				
			
			}
			else if((current_state == 1)&& isDigit(c)){
				next_state =1;
				result.append(c);

			}
			else if((current_state == 1)&& !isDigit(c)){
				next_state =5;
				if(!isRepeated(result, tokens)){
					tokens.add(result.toString());
					System.out.println(result + "\t" + "==> INNUM");
				}
				result = new StringBuilder();
				next_state = 0;
			}
			else if((current_state == 2)&&( isletter(c))){
				next_state =2;
				result.append(c);
				if(isRes_w(result)){
					res_w = true;
				}
			}
			else if((current_state == 2)&& !(isletter(c))){
				next_state =5;
				if(!isRepeated(result, tokens)){
					tokens.add(result.toString());
					System.out.println(result + "\t" + "==> INID");
				}
				result = new StringBuilder();
				next_state =0;

			}
			else if((current_state == 3)&& (c =='=')){
				next_state =5 ;
				result.append(c);
				if(!isRepeated(result, tokens)){
					tokens.add(result.toString());
					System.out.println(result + "\t" + "==> INASSIGN");
				}
				result = new StringBuilder();
				next_state = 0;
			}
			else if((current_state == 3)&& (c !='=')){
				next_state=5;
				if(!isRepeated(result, tokens)){
					tokens.add(result.toString());
					System.out.println(result + "\t" + "==> INASSIGN");
				}
				result = new StringBuilder();
				next_state = 0;
			}else{
				System.out.println("OTHER");
			}
			character++;
		}
	}
	*/
	
	private static boolean isDigit(char c) {
		// TODO Auto-generated method stub
		if((c >='0' && c<='9'))
			return true;
		return false;
		
	}
	private static boolean isSpecialSim(char c) {
		// TODO Auto-generated method stub
		if( c=='+' || c=='-' || c=='*' || c=='/' || c== '<' || c==')' ||c=='(' || c==';'  )
			return true;
		return false;
		
		
	}
	private static boolean isSpace(char c) {
		// TODO Auto-generated method stub
		if(c ==' ' || c == '\n' || c== '\t' )
			return true;
		return false;
		
	}
	private static boolean isletter(char c) {
		// TODO Auto-generated method stub
		if(((c >='a' && c<='z')||(c>='A' && c<='Z')))
			return true;
		return false;
		
	}
	public static boolean isRes_w(StringBuilder result) {
		// TODO Auto-generated method stub
		if(result.toString().equalsIgnoreCase("if")||result.toString().equalsIgnoreCase("else")||result.toString().equalsIgnoreCase("then")||result.toString().equalsIgnoreCase("end")||result.toString().equalsIgnoreCase("repeat")||result.toString().equalsIgnoreCase("until")||result.toString().equalsIgnoreCase("read")||result.toString().equalsIgnoreCase("write")){
			return true;
		}
		return false;
	}
	
//	public static void TinyScanner_with_repetation(String expression) throws IOException{
//		int character = 0;
//		ArrayList<String> tokens = new ArrayList<String>();
//		// current state
//		int current_state =0;
//		int next_state = 0;
//		boolean comment =false;
//		
//		//fill all array with false value 
//		//Arrays.fill(tokens, Boolean.FALSE);
//		// a string is cutted to char 
//		StringReader s = new StringReader(expression);
//		StringBuilder result = new StringBuilder();
//		while(character < (expression.length()+1) ){
//			char c = (char) s.read();
//			current_state = next_state;
//			if( (current_state==0)&&(c == ' ')){
//				next_state= 0;
//				
//			}else if((current_state == 0)&&(c == '{')){
//				next_state = 4;
//				result.append(c);
//				comment=true;
//				
//			}else if((current_state == 4)&&(c=='}')){
//				next_state = 0;
//				result.append(c);
//			}
//			else if((current_state == 4)&&(c!='}')){
//				next_state = 4;
//				result.append(c);
//			}
//			else if((current_state == 0)&&(c >='0' && c<='9')){
//				next_state = 1;
//				result.append(c);
//			}
//			else if((current_state == 0)&&((c >='a' && c<='z')||(c>='A' && c<='Z')) ){
//				next_state = 2;
//				result.append(c);
//			}
//			else if((current_state == 0)&&(c==':')){
//				next_state= 3;
//				result.append(c);
//			}
//			else if((current_state == 0)&&((c!=':')&&(c !=' ') && !(c >='0' && c<='9')&& !((c >='a' && c<='z')||(c>='A' && c<='Z')))){
//				next_state = 5;
//				if(comment){
//					if(!isRepeated(result, tokens))
//					{	
//						tokens.add(result.toString());
//						{System.out.println(result + "\t" + "==> INCOMMENT");}
//						
//					}
//					comment= false;
//					result = new StringBuilder();
//					next_state = 0;
//				}else{
//					if(!isRepeated(result, tokens)){
//						tokens.add(result.toString());
//						System.out.println(result + "\t" + "==> SPACE");
//					}
//					result = new StringBuilder();
//					next_state = 0;
//				}
//			}
//			else if((current_state == 1)&&(c >='0' && c<='9')){
//				next_state =1;
//				result.append(c);
//
//			}
//			else if((current_state == 1)&& !(c >='0' && c<='9')){
//				next_state =5;
//				if(!isRepeated(result, tokens)){
//					tokens.add(result.toString());
//					System.out.println(result + "\t" + "==> INNUM");
//				}
//				result = new StringBuilder();
//				next_state = 0;
//			}
//			else if((current_state == 2)&&((c >='a' && c<='z')||(c>='A' && c<='Z'))){
//				next_state =2;
//				result.append(c);
//			}
//			else if((current_state == 2)&& !((c >='a' && c<='z')||(c>='A' && c<='Z'))){
//				next_state =5;
//				if(!isRepeated(result, tokens)){
//					tokens.add(result.toString());
//					System.out.println(result + "\t" + "==> INID");
//				}
//				result = new StringBuilder();
//				next_state =0;
//
//			}
//			else if((current_state == 3)&& (c =='=')){
//				next_state =5 ;
//				result.append(c);
//				if(!isRepeated(result, tokens)){
//					tokens.add(result.toString());
//					System.out.println(result + "\t" + "==> INASSIGN");
//				}
//				result = new StringBuilder();
//				next_state = 0;
//			}
//			else if((current_state == 3)&& (c !='=')){
//				next_state=5;
//				if(!isRepeated(result, tokens)){
//					tokens.add(result.toString());
//					System.out.println(result + "\t" + "==> INASSIGN");
//				}
//				result = new StringBuilder();
//				next_state = 0;
//			}else{
//				System.out.println("OTHER");
//			}
//			character++;
//		}
//	}
	
	public static ArrayList<token> Scanner(String expression) throws IOException{
		int character = 0;
		ArrayList<token> tokens = new ArrayList<token>();
		// current state
		int current_state =0;
		int next_state = 0;
		boolean comment =false;
		
		//fill all array with false value 
		//Arrays.fill(tokens, Boolean.FALSE);
		// a string is cutted to char 
		StringReader s = new StringReader(expression);
		StringBuilder result = new StringBuilder();
		while(character < (expression.length()+1) ){
			char c = (char) s.read();
			current_state = next_state;
			if( (current_state==0)&&(c == ' ')){
				next_state= 0;
				
			}else if((current_state == 0)&&(c == '{')){
				next_state = 4;
				result.append(c);
				comment=true;
				
			}else if((current_state == 4)&&(c=='}')){
				next_state = 0;
				result.append(c);
			}
			else if((current_state == 4)&&(c!='}')){
				next_state = 4;
				result.append(c);
			}
			else if((current_state == 0)&&(c >='0' && c<='9')){
				next_state = 1;
				result.append(c);
			}
			else if((current_state == 0)&&((c >='a' && c<='z')||(c>='A' && c<='Z')) ){
				next_state = 2;
				result.append(c);
			}
			else if((current_state == 0)&&(c==':')){
				next_state= 3;
				result.append(c);
			}
			else if((current_state == 0)&&((c!=':')&&(c !=' ') && !(c >='0' && c<='9')&& !((c >='a' && c<='z')||(c>='A' && c<='Z')))){
				next_state = 5;
				if(comment){
					if(!isRepeated(result, tokens))
					{	
						//tokens.add(result.toString());
						tokens.add(new token("INCOMMENT",result.toString()));

						//System.out.println(result + "\t" + "==> INCOMMENT");
						
					}
					comment= false;
					result = new StringBuilder();
					next_state = 0;
				}else{
					if(!isRepeated(result, tokens)){
						//tokens.add(result.toString());
						tokens.add(new token("SPACE",result.toString()));
						//System.out.println(result + "\t" + "==> SPACE");
					}
					result = new StringBuilder();
					next_state = 0;
				}
			}
			else if((current_state == 1)&&(c >='0' && c<='9')){
				next_state =1;
				result.append(c);

			}
			else if((current_state == 1)&& !(c >='0' && c<='9')){
				next_state =5;
				if(!isRepeated(result, tokens)){
					//tokens.add(result.toString());
					tokens.add(new token("INNUM",result.toString()));

					//System.out.println(result + "\t" + "==> INNUM");
				}
				result = new StringBuilder();
				next_state = 0;
			}
			else if((current_state == 2)&&((c >='a' && c<='z')||(c>='A' && c<='Z'))){
				next_state =2;
				result.append(c);
			}
			else if((current_state == 2)&& !((c >='a' && c<='z')||(c>='A' && c<='Z'))){
				next_state =5;
				if(!isRepeated(result, tokens)){
					//tokens.add(result.toString());
					tokens.add(new token("INID",result.toString()));

					//System.out.println(result + "\t" + "==> INID");
				}
				result = new StringBuilder();
				next_state =0;

			}
			else if((current_state == 3)&& (c =='=')){
				next_state =5 ;
				result.append(c);
				if(!isRepeated(result, tokens)){
//					tokens.add(result.toString());
					tokens.add(new token("INASSIGN",result.toString()));

					//System.out.println(result + "\t" + "==> INASSIGN");
				}
				result = new StringBuilder();
				next_state = 0;
			}
			else if((current_state == 3)&& (c !='=')){
				next_state=5;
				if(!isRepeated(result, tokens)){
					//tokens.add(result.toString());
					tokens.add(new token("INASSIGN",result.toString()));

					//System.out.println(result + "\t" + "==> INASSIGN");
				}
				result = new StringBuilder();
				next_state = 0;
			}else{
				System.out.println("OTHER");
			}
			character++;
		}
		return tokens;
	}

}
