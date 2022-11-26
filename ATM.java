import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class transhist{
	void add(int amt,int choice,List<String> transhist1) {
		if(choice == 2) {
			String transaction = amt+" has been withdrawn";
			transhist1.add(transaction);
		}
		else {
			String transaction = amt+" deposited";
			transhist1.add(transaction);
		}
	}
	void add(int amt,String rec,List<String> transhist1) {
		String transaction = amt+" transferred to "+rec;
		transhist1.add(transaction);
	}
	void display(List<String> transhist1) {
		if(transhist1.size() == 0) {
			System.out.println("No Transactions yet!");
		}
		else {
			for(int i=1;i<=transhist1.size();i++) {
				System.out.println("Transaction "+i+" : "+transhist1.get(i-1));
			}
		}
	}
}
class withdraw {
	int draw(int bal,int amt) {
		bal = bal - amt;
		return bal;
	}
}
class deposit{
	int add(int bal,int amt) {
		bal = bal + amt;
		return bal;
	}
}
class transfer{
	int trans(int bal,int amt) {
		bal = bal - amt;
		return bal;
	}
}
public class ATM {
	public static void main(String args[]) {
		List<String> transhist1 = new ArrayList<>();
		String userid = "7218381521";
		int password = 7218;
		int balance = 100000;
		int amount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your User ID:");
		String id = sc.nextLine();
		System.out.println("Enter your password:");
		int pword = sc.nextInt();
		boolean leave=true;
		if(userid.equals(id) && password==pword) {
			System.out.println("Welcome! Your account balance is "+balance);
			do {
				System.out.println("\nPress the corresponding numbers:");
				System.out.println("1.Transaction History\n2.Deposit Money\n3.Withdraw Money\n4.Transfer Money\n5.Exit\n");
				int choice = sc.nextInt();
				transhist objx;
				switch(choice) {
				case 1: transhist obj = new transhist();
						obj.display(transhist1);
					    break;
				case 2: System.out.println("Enter amount to be deposited:");
                    amount = sc.nextInt();
                    deposit obj2 = new deposit();
                    balance = obj2.add(balance, amount);
                    objx = new transhist();
                    objx.add(amount,3,transhist1);
                    System.out.println("Successfully deposited!");
                    System.out.println("Current Balance: "+balance);
                    break;
				case 3: 
                        System.out.println("Enter amount to be withdrawn:");
						amount = sc.nextInt();
						if(amount > balance) {
							System.out.println("Amount greater than balance");
							break;
						}
						withdraw obj1 = new withdraw();
					    balance = obj1.draw(balance, amount);
					    objx = new transhist();
						objx.add(amount,2,transhist1);
					    System.out.println("Money is Successfully Withdrawn!");
					    System.out.println("Current Balance is: "+balance);
					    break;
				case 4: System.out.println("Enter amount to be transfered:");
						amount = sc.nextInt();
						if(amount > balance) {
							System.out.println("Amount is greater than balance");
							break;
						}
						System.out.println("Enter receipent Number:");
						String rec = sc.next();
						transfer obj3 = new transfer();
					    balance = obj3.trans(balance, amount);
					    objx = new transhist();
						objx.add(amount,rec,transhist1);
					    System.out.println("Successfully transferred to "+rec+"!");
					    System.out.println("Current Balance: "+balance);
					    break;
				case 5: leave = false;
					    break;
				default: System.out.println("Invalid Choice");
			
				}
			}while(leave);
		}
		else {
			System.out.println("Wrong Credentials");
		}
		sc.close();
	}
}