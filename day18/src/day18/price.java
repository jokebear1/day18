package day18;

import java.util.Scanner;

class Ex10
{
	String name="";
	int[] arPrice= {2500, 3800, 1500, 1000};
	String[] arMenu= {"치즈버거", "새우버거", "감자튀김", "콜카콜라"};
	int[] arCount=new int[4];
	int total=0;
}
public class price {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Ex10 e=new Ex10();
		e.name="맘스터치";
		
		System.out.println("     "+e.name);
		System.out.println("-----------------");
		while(true) {
			System.out.println("     메뉴선택");
			System.out.println(" ITEM    QTY  AMT");
			
			for(int i=0; i<e.arPrice.length; i++)
			{
				System.out.print("[" + (i+1) + "]" + e.arMenu[i]+"  ");
				System.out.print(e.arCount[i]+"   ");
				System.out.print(e.arPrice[i]*e.arCount[i]+"  ");
				System.out.println();
				
			}
			System.out.println("음식을 선택하세요");
			int sel=sc.nextInt();
			System.out.println("---------------");
			
			if(1 <= sel && sel <= e.arPrice.length)
			{
				sel-=1;
				e.arCount[sel]+=1;
			}
			else if(sel==5)
			{
				for(int i=0; i<e.arPrice.length; i++)
				{
					e.total+=e.arPrice[i] * e.arCount[i];
				}
				System.out.println("합계 금액 : " +e.total);
				System.out.print("금액 입력 : ");
				int money=sc.nextInt();
				System.out.println("받은 금액 : "+money);
				System.out.println("잔   돈 : "+ (money-e.total));	
				
				break;
				
			}
			
			
		}	
		
	}

}
