package compilar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import compilar.tinyScanner;
import compilar.parser;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		tinyScanner CompScanner = new tinyScanner();
		parser CompParser = new parser();
		Scanner myinput = new Scanner(System.in);
		/*
		 * TEST STATEMENT FROM THE SLIDES
		 read x; {input an integer }
if 0 < x then { don’t compute if x <= 0 }
fact := 1;
repeat
fact := fact * x;
x := x -1
until x = 0;
write fact { output factorial of x }
end
		 * 
		 */
		String myin =myinput.nextLine();
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
