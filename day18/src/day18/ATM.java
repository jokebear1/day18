package day18;

import java.util.Scanner;

class Ex11
{
	String name="";
	String[]arAcc= {"1111", "2222", "3333", "4444", "5555"};
	String[]arPw= {"1234" , "2345", "3456" ,"4567", "5678"};
	int[] arMoney= {87000, 34000, 17500, 98000, 12500};
	int count=5;
	int logincheck=2;
	public int loginCheck;
}
public class ATM {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Ex11 e=new Ex11();
		
		e.name="jjj";
		while(true) {
			while(true) 
			{
				System.out.println("-------------------------");
				System.out.println("���¹�ȣ\t��й�ȣ\t�����ܾ�");
				System.out.println("-------------------------");
				for(int i=0; i<e.count; i++) 
				{
					System.out.println(e.arAcc[i] + "\t" + e.arPw[i] + "\t" + e.arMoney[i]);
				}
				System.out.println("-------------------------");
				System.out.print("���� : ");
				if(e.loginCheck == -1) 
				{
					System.out.println("�α׾ƿ�");
				}
				else {
					System.out.println(e.arAcc[e.loginCheck] + " �α���");
				}
				System.out.println("-------------------------");
				System.out.println("[" + e.name + "]");
				System.out.println("[1]ȸ������");
				System.out.println("[2]ȸ��Ż��");
				System.out.println("[3]�α���");
				System.out.println("[4]�α׾ƿ�");
				System.out.println("[5]�Ա��ϱ�");
				System.out.println("[6]��ü�ϱ�");
				System.out.println("[7]�ܾ���ȸ");
				System.out.println("[0]�����ϱ�");
				
				System.out.print("�޴� ���� : ");
				int sel = sc.nextInt();
				
				if(sel == 1)			//ȸ�� ����
				{
					System.out.println("[����]���� ��ȣ�� �Է��ϼ���");
					String acc = sc.next();
					
					int check = 1;
					for(int i=0;i<e.arAcc.length;i++)
					{
						if(e.arAcc[i].equals(acc))
						{
							check = -1;
						}
					}
					
					if(check==-1)
					{
						System.out.println("[�޼���]�ߺ��Ǵ� ���¹�ȣ �Դϴ�.");
					}
					else
					{
						if(e.count==0)
						{
							e.arAcc = new String[e.count+1];
							e.arPw = new String[e.count+1];
							e.arMoney = new int[e.count+1];
						}
						else if(e.count>0)
						{
							String[] temp_acc = e.arAcc;
							String[] temp_pw = e.arPw;
							int[] temp_money = e.arMoney;
							
							e.arAcc = new String[e.count+1];		//e.arAcc.length�� +1��
							e.arPw = new String[e.count+1];
							e.arMoney = new int[e.count+1];
							
							for(int i=0;i<e.arAcc.length-1;i++)		//i<e.arAcc.length�ϸ� �� Error ����
							{
								
								
								e.arAcc[i] = temp_acc[i];
								e.arPw[i] = temp_pw[i];
								e.arMoney[i] = temp_money[i];
							}
							temp_acc = null;
							temp_pw = null;
							temp_money = null;
						}	
						System.out.println("[����]��� ��ȣ�� �Է��ϼ���:");
						String pw = sc.next();
						
						System.out.println("[����]�ݾ��� �Է��ϼ���:");
						int money = sc.nextInt();
						

						e.arAcc[e.count] = acc;
						e.arPw[e.count] = pw;
						e.arMoney[e.count] = money;
						e.count++;
						
						System.out.println("������ ���ϵ帳�ϴ�.");
					}
				}
				else if(sel == 2) 		//ȸ�� Ż��
				{
					if(e.loginCheck == -1)
					{
						System.out.println("[�޼���]�α��� �� ��� �����մϴ�.");
						continue;
					}
					else
					{
						for(int i=e.loginCheck; i<e.count-1; i++) {
							e.arAcc[i] = e.arAcc[i + 1];
							e.arPw[i] = e.arPw[i + 1];
							e.arMoney[i] = e.arMoney[i + 1];
						}
						e.count -= 1;
						e.loginCheck = -1;
						System.out.println("[�޼���]Ż��Ǿ����ϴ�. �ȳ������ʽÿ�.");	
					}
				}
				else if(sel == 3) 		//�α���
				{
					if(e.loginCheck != -1)
					{
						System.out.println("[�޼���]���� " + e.arAcc[e.loginCheck]+"���� �α��� ���Դϴ�.");
					}
					else
					{
						System.out.println("[�α���]���� ��ȣ�� �Է��ϼ���");
						String acc = sc.next();
						System.out.println("[�α���]��� ��ȣ�� �Է��ϼ���");
						String pw = sc.next();
						
						for(int i=0;i<e.count;i++)
						{
							if(e.arAcc[i].equals(acc) && e.arPw[i].equals(pw))
							{
								e.loginCheck = i;
							}
						}
						
						if(e.loginCheck == -1)
						{
							System.out.println("[�޼���]���¹�ȣ �� ��� ��ȣ�� Ȯ�����ּ���");
						}
						else
						{
							System.out.println("[�޼���]" + e.arAcc[e.loginCheck]+"��, ȯ���մϴ�.");
						}
						
					}
					
				}
				else if(sel == 4)		//�α� �ƿ�
				{
					if(e.loginCheck == -1)
					{
						System.out.println("[�޼���]�α��� �� ��� �����մϴ�.");
						continue;
					}
					else
					{
						System.out.println("[�޼���]"+e.arAcc[e.loginCheck]+"�� �α׾ƿ� ����ϴ�.");
						e.loginCheck = -1;
					}
				}
				else if(sel == 5) 		//�Ա� �ϱ�
				{
					if(e.loginCheck == -1)
					{
						System.out.println("[�޼���]�α��� �� ��� �����մϴ�.");
						continue;
					}
					else
					{
						System.out.println("[�޼���]�Ա��� �ݾ��� �Է����ּ���");
						int money = sc.nextInt();
						
						e.arMoney[e.loginCheck] += money;
						System.out.println("[�޼���]�Ա��� �Ϸ��߽���");
					}
				}
				else if(sel == 6) 		//��ü �ϱ�
				{
					if(e.loginCheck == -1)
					{
						System.out.println("[�޼���]�α��� �� ��� �����մϴ�.");
						continue;
					}
					else
					{
						System.out.println("[��ü]���¹�ȣ�� �Է��ϼ���");
						String acc = sc.next();
						
						int check = -1;
						for(int i=0;i<e.count;i++)
						{
							if(e.arAcc[i].equals(acc))
							{
								check = i;
							}
						}
						if(check==-1)
						{
							System.out.println("[�޼���]���� ��ȣ�� Ȯ�����ּ���");
						}
						else
						{
							System.out.println("[��ü]�ݾ��� �Է��ϼ���");
							int money = sc.nextInt();
							
							if(e.arMoney[e.loginCheck] >= money)
							{
								e.arMoney[e.loginCheck] -= money;
								e.arMoney[check] += money;
								System.out.println("[�޼���]��ü�� �Ϸ��Ͽ����ϴ�");
							}
							else
							{
								System.out.println("[�޼���]���� �ܾ��� �����մϴ�");
							}
						}
					}
				}
				else if(sel == 7) 		//�ܾ� ��ȸ
				{
					if(e.loginCheck == -1)
					{
						System.out.println("[�޼���]�α��� �� ��� �����մϴ�.");
						continue;
					}
					else
					{
						System.out.println(e.arAcc[e.loginCheck]+"���� �����ܾ���"+e.arMoney[e.loginCheck]+"�� �Դϴ�.");
					}
				}
				else if(sel == 0) 		//����
				{
					System.out.println("���α׷� ����");
					break;
				}
				
			}		
			
		}
	}

}

