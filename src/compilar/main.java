package compilar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import compilar.tinyScanner;
import compilar.*;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		tinyScanner CompScanner = new tinyScanner();
		RecursiveDesentParser CompParser = new RecursiveDesentParser();
		Scanner myinput = new Scanner(System.in);
		/*
		 * TEST STATEMENT FROM THE SLIDES
		 sum := man
		 * 
		 */
		String myin = new String("sum := man");
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
		System.out.println("LL1 parser Output.. ");
		System.out.println("-------------------");
		LL1Parser llParser = new LL1Parser(token);
		System.out.println(LL1Parser.applyLL1());
		System.out.println("---------------------");
	}

}
