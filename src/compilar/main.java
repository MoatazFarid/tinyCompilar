package compilar;
import java.io.IOException;
import java.util.ArrayList;

import compilar.tinyScanner;
import compilar.parser;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		tinyScanner CompScanner = new tinyScanner();
		parser CompParser = new parser();
		
		String myin = new String("read x ; write y ");
		ArrayList<token> token = CompScanner.Scanner(myin);
		
		System.out.println("Scanner Output.. ");
		System.out.println("-------------------");
		for (token temp : token) {
			System.out.println(temp.getTokenType());
			System.out.println(temp.getisReserved());
			//System.out.println(temp);
		}
		for (token temp : token) {
			System.out.println(temp.getTokenValue());
			//System.out.println(temp);
		}
		System.out.println();
		System.out.println("parser Output.. ");
		System.out.println("-------------------");
		CompParser.setToken(token);
		System.out.println(CompParser.program());
	}

}
