package day18;

import java.util.Scanner;

class Ex10
{
	String name="";
	int[] arPrice= {2500, 3800, 1500, 1000};
	String[] arMenu= {"ġ�����", "�������", "����Ƣ��", "��ī�ݶ�"};
	int[] arCount=new int[4];
	int total=0;
}
public class price {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Ex10 e=new Ex10();
		e.name="������ġ";
		
		System.out.println("     "+e.name);
		System.out.println("-----------------");
		while(true) {
			System.out.println("     �޴�����");
			System.out.println(" ITEM    QTY  AMT");
			
			for(int i=0; i<e.arPrice.length; i++)
			{
				System.out.print("[" + (i+1) + "]" + e.arMenu[i]+"  ");
				System.out.print(e.arCount[i]+"   ");
				System.out.print(e.arPrice[i]*e.arCount[i]+"  ");
				System.out.println();
				
			}
			System.out.println("������ �����ϼ���");
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
				System.out.println("�հ� �ݾ� : " +e.total);
				System.out.print("�ݾ� �Է� : ");
				int money=sc.nextInt();
				System.out.println("���� �ݾ� : "+money);
				System.out.println("��   �� : "+ (money-e.total));	
				
				break;
				
			}
			
			
		}	
		
	}

}
