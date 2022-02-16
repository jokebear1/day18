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
				System.out.println("계좌번호\t비밀번호\t계좌잔액");
				System.out.println("-------------------------");
				for(int i=0; i<e.count; i++) 
				{
					System.out.println(e.arAcc[i] + "\t" + e.arPw[i] + "\t" + e.arMoney[i]);
				}
				System.out.println("-------------------------");
				System.out.print("상태 : ");
				if(e.loginCheck == -1) 
				{
					System.out.println("로그아웃");
				}
				else {
					System.out.println(e.arAcc[e.loginCheck] + " 로그인");
				}
				System.out.println("-------------------------");
				System.out.println("[" + e.name + "]");
				System.out.println("[1]회원가입");
				System.out.println("[2]회원탈퇴");
				System.out.println("[3]로그인");
				System.out.println("[4]로그아웃");
				System.out.println("[5]입금하기");
				System.out.println("[6]이체하기");
				System.out.println("[7]잔액조회");
				System.out.println("[0]종료하기");
				
				System.out.print("메뉴 선택 : ");
				int sel = sc.nextInt();
				
				if(sel == 1)			//회원 가입
				{
					System.out.println("[가입]계좌 번호를 입력하세요");
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
						System.out.println("[메세지]중복되는 계좌번호 입니다.");
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
							
							e.arAcc = new String[e.count+1];		//e.arAcc.length가 +1됨
							e.arPw = new String[e.count+1];
							e.arMoney = new int[e.count+1];
							
							for(int i=0;i<e.arAcc.length-1;i++)		//i<e.arAcc.length하면 왜 Error 나지
							{
								
								
								e.arAcc[i] = temp_acc[i];
								e.arPw[i] = temp_pw[i];
								e.arMoney[i] = temp_money[i];
							}
							temp_acc = null;
							temp_pw = null;
							temp_money = null;
						}	
						System.out.println("[가입]비밀 번호를 입력하세요:");
						String pw = sc.next();
						
						System.out.println("[가입]금액을 입력하세요:");
						int money = sc.nextInt();
						

						e.arAcc[e.count] = acc;
						e.arPw[e.count] = pw;
						e.arMoney[e.count] = money;
						e.count++;
						
						System.out.println("가입을 축하드립니다.");
					}
				}
				else if(sel == 2) 		//회원 탈퇴
				{
					if(e.loginCheck == -1)
					{
						System.out.println("[메세지]로그인 후 사용 가능합니다.");
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
						System.out.println("[메세지]탈퇴되었습니다. 안녕히가십시오.");	
					}
				}
				else if(sel == 3) 		//로그인
				{
					if(e.loginCheck != -1)
					{
						System.out.println("[메세지]현재 " + e.arAcc[e.loginCheck]+"님이 로그인 중입니다.");
					}
					else
					{
						System.out.println("[로그인]계좌 번호를 입력하세요");
						String acc = sc.next();
						System.out.println("[로그인]비밀 번호를 입력하세요");
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
							System.out.println("[메세지]계좌번호 및 비밀 번호를 확인해주세요");
						}
						else
						{
							System.out.println("[메세지]" + e.arAcc[e.loginCheck]+"님, 환영합니다.");
						}
						
					}
					
				}
				else if(sel == 4)		//로그 아웃
				{
					if(e.loginCheck == -1)
					{
						System.out.println("[메세지]로그인 후 사용 가능합니다.");
						continue;
					}
					else
					{
						System.out.println("[메세지]"+e.arAcc[e.loginCheck]+"님 로그아웃 됬습니다.");
						e.loginCheck = -1;
					}
				}
				else if(sel == 5) 		//입금 하기
				{
					if(e.loginCheck == -1)
					{
						System.out.println("[메세지]로그인 후 사용 가능합니다.");
						continue;
					}
					else
					{
						System.out.println("[메세지]입금할 금액을 입력해주세요");
						int money = sc.nextInt();
						
						e.arMoney[e.loginCheck] += money;
						System.out.println("[메세지]입금을 완료했습다");
					}
				}
				else if(sel == 6) 		//이체 하기
				{
					if(e.loginCheck == -1)
					{
						System.out.println("[메세지]로그인 후 사용 가능합니다.");
						continue;
					}
					else
					{
						System.out.println("[이체]계좌번호를 입력하세요");
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
							System.out.println("[메세지]계좌 번호를 확인해주세요");
						}
						else
						{
							System.out.println("[이체]금액을 입력하세요");
							int money = sc.nextInt();
							
							if(e.arMoney[e.loginCheck] >= money)
							{
								e.arMoney[e.loginCheck] -= money;
								e.arMoney[check] += money;
								System.out.println("[메세지]이체를 완료하였습니다");
							}
							else
							{
								System.out.println("[메세지]계좌 잔액이 부족합니다");
							}
						}
					}
				}
				else if(sel == 7) 		//잔액 조회
				{
					if(e.loginCheck == -1)
					{
						System.out.println("[메세지]로그인 후 사용 가능합니다.");
						continue;
					}
					else
					{
						System.out.println(e.arAcc[e.loginCheck]+"님의 계좌잔액은"+e.arMoney[e.loginCheck]+"원 입니다.");
					}
				}
				else if(sel == 0) 		//종료
				{
					System.out.println("프로그램 종료");
					break;
				}
				
			}		
			
		}
	}

}

