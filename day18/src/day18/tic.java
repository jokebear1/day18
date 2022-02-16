package day18;

import java.util.Scanner;

class Ex12
{
	String[][] game=new String[3][3];
	int turn=0;
	int win=0;
}
public class tic {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Ex12 e=new Ex12();
		
		for(int i=0; i<e.game.length; i++)
		{
			for(int j=0; j<e.game.length; j++)
			{
				e.game[i][j]="[ ]";
				
			}
		}
		
		System.out.println("~~~~~Æ½¾ØÅå °ÔÀÓ~~~~~");
		while(true) {
			for(int i=0; i<e.game.length; i++)
			{
				for(int j=0; j<e.game.length; j++)
				{
					System.out.println("");
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

}
