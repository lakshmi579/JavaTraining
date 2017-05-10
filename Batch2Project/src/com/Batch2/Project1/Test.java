package com.Batch2.Project1;

import java.util.Scanner;

public class Test {

	static BankTransactions bt = new BankTransactions();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true){
		System.out.println("welcome to my bank");
		System.out.println("please enter 1 to register and 2 to log in");
		int a = sc.nextInt();
		switch(a){
		case 1: {
			System.out.println("please enter your name");
			String name = sc.next();
			System.out.println("please enter your phone number");
			long phone = sc.nextLong();
			System.out.println("please enter your user ID");
			String userID = sc.next();
			System.out.println("please enter your password");
			String password = sc.next();
			boolean k =bt.regitration(name, phone, userID, password);
			if(k==true){
				System.out.println("thannks for registering... please log in to make transactions");
				
			}else{
				System.out.println("registrayion failed. please try again.");
			}
			break;
		}
		case 2:{
			boolean k = false;
			System.out.println("please enter your user ID");
			String userID = sc.next();
			System.out.println("please enter your password");
			String password = sc.next();
			boolean j = bt.login(userID, password);
			if(j==true){
				 k =successfulLogin();
					}else{
						System.out.println("login in fail. try again");
					}
			if(k==true){
				break;
			}
			}
			
		}
		}
		}

		
		

	

public static boolean successfulLogin(){
	Scanner sc = new Scanner(System.in);
	
	while(true){
	System.out.println("please enter 1 to deposit 2 to withdraw 3 to balance check and 4 to logout");
	int b = sc.nextInt();
	switch(b){
		case 1:{
			System.out.println("please enter amount to deposit");
			int amount = sc.nextInt();
			boolean  k = bt.deposit(amount);
			if(k==true){
				System.out.println("deposit sucessful");
				
			}else{
				System.out.println("depoit fail");
			}
			break;
		}
		case 2:{
			System.out.println("please enter amount to withdraw");
			int amount = sc.nextInt();
			boolean  k = bt.withdraw(amount);
			if(k==true){
				System.out.println("withdraw sucessful");
				
			}else{
				System.out.println("withdraw fail. please check ur balance");
			}
			break;
		}
		case 3:{
			int amount = bt.balanceCheck();
			System.out.println(" your current balance is: "+amount);
			break;
		}
		case 4:{
			boolean k =bt.logout();
			if(k==true){
				System.out.println("withdraw sucessful");
				return true;
			}else{
				System.out.println("withdraw fail. please check ur balance");
			}
			break;
			}
	}

}
}
}
