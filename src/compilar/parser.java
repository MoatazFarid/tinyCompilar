package compilar;

import java.util.*;

public class parser {
	public ArrayList<token> tokenn ;//= new ArrayList<token>();
	int i = 0;
	void setToken(ArrayList<token> token){
		this.tokenn = token;
	}
	boolean isReserved(String temp){
		if(temp == "read" ||temp == "write" ||temp == "if" ||temp == "then" ||temp == "else" ||temp == "end" ||temp == "repeat" ||temp == "until"){
			return true;
		}else{
			return false;
		}
	}
	boolean match(String temp){
		if (tokenn.get(i).getTokenType() == "reserved" && tokenn.get(i).getisReserved() ){
			if(tokenn.get(i).getTokenValue().equals(temp)){
				i++;
				return true;
			}
			return false;
		}
		else if (tokenn.get(i).getTokenType() == "OTHER"){
			if(tokenn.get(i).getTokenValue() == temp){
				i++;
				return true;
			}
			return false;
		}else if(tokenn.get(i).getTokenType() == temp){
			i++;
			return true;
		} 
		return false;		
	}
	
	boolean factor(){
		if(match("(")){
			if(exp()){
				if(match(")")){
					return true;
				}else
				{
					return false;
				}
			}else
			{
				return false;
			}
		}else if(match("number"))
		{
			return true;
		}else if(match("identifier"))
		{
			return true;
		}else
		{
			return false;
		}
	}

	boolean mulop(){
		if(match("*")){
			return true;
		}
		else if (match("/"))
		{
			return true;
		}else
		{
			return false;
		}
	}

	boolean term(){
		if(factor()){

			while (mulop())
			{
				if(factor()){
					////// true 
				}else
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}

	boolean addop(){
		if(match("+")){
			return true;
		}
		else if (match("-")){
			return true;
		}
		else
		{
			return false;
		}
	}

	boolean simple_exp(){
		if(term()){
			while(addop()){
				if(term()){
					
				}else{
					return false;
				}
			}
			return true;
		}else
		{
			return false;
		}
	}

	boolean comparison_exp(){
		if(match("<")){return true;}
		else if(match("=")){return true;}
		else{return	false;}
	}

	boolean exp(){
		if(simple_exp()){
			if(comparison_exp()){
				if(simple_exp()){
					return true;
				}else{return false;}
			}else{return true;}
		}else{return false;}
	}

	boolean write_stmt(){
		if(match("write")){
			if(exp()){
				return true;
			}else{return false;}
		}else{return false;}
	}

	boolean read_stmt(){
		if(match("read")){
			if(match("identifier")){
				return true;
			}else{
				return false;
			}
		}else{return false;}
	}

	boolean assign_stmt(){
		if(match("identifier")){
			if(match("assign")){
				if(exp()){
					return true;
				}else{return false;}
			}else{return false;}
		}else{return false;}
	}

	boolean repeat_stmt(){
		if(match("repeat")){
			if(stmt_sequence()){
				if(match("until")){
					if(exp()){
						return true;
					}else{return false;}
				}else{return false;}
			}else{return false;}
		}else{return false;}
	}

	boolean if_stmt(){
		if(match("if")){
			if(exp()){
				if(match("then")){
					if(stmt_sequence()){
						if(match("else")){
							if(stmt_sequence()){
								return true;
							}else{
								return false;
							}
						}else if(match("end")){
							return true;
						}else{
							return false;
						}
					}
					else{
						return false;
					}
				}else{
					return false;
				}

			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	boolean statement (){
		if( if_stmt() ||repeat_stmt() || assign_stmt() || read_stmt() || write_stmt() )
		{
			return true ;
		}
		else{
			return false;
		}
	}

	// non terminal
	boolean stmt_sequence(){
	    if(statement()){

			while(match("semicolon")){
				if(statement());else{return false;}
			}

			return true;
		}else{
			return false;
		}

	}

	boolean program()
	{
	    return stmt_sequence();
	}


}
