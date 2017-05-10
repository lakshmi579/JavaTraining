package com.Batch2.Project1;

public class BankTransactions {
	
	private BankCustomer bc[] = new BankCustomer[100];
	
	int counter=0;
	BankCustomer currentLoggenInCustomer = new BankCustomer();
	int loggedInCustomerIndex =0;
	public BankTransactions() {
		// TODO Auto-generated constructor stub
		for(int i =0; i<bc.length;i++){
			bc[i] = new BankCustomer();
		}
	}
	
	public boolean regitration(String name, long phone, String userID, String password){
		boolean a= phoneValidation(phone);
		boolean b= userIdValidation(userID);
		
		if(a==false){
			System.out.println("invalid phone number. please enter correctly");
		}
		if(b==false){
			
			System.out.println("giver userid already exists . please try other one");
		}
		if(a==false&& b== false){
			System.out.println("Registration failed");
		}else if(a== true&& b == true){
			bc[counter].setName(name);
			bc[counter].setTelephone(phone);
			bc[counter].setUserID(userID);
			bc[counter].setPassword(password);
			bc[counter].setBalance(0);
			counter++;
			return true;
		}
		return false;
	}
	
	public boolean login(String userID, String password){
		for(int i =0; i<counter;i++){
			if(bc[i].getUserID().equalsIgnoreCase(userID)){
				if(bc[i].getPassword().equals(password)){
					currentLoggenInCustomer= bc[i];
					loggedInCustomerIndex = i;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean withdraw(int amount){
		if(currentLoggenInCustomer.getBalance()> amount){
			int newBalance= currentLoggenInCustomer.getBalance() - amount;
			currentLoggenInCustomer.setBalance(newBalance);
			return true;
		}
		return false;
	}
	
	public boolean deposit(int amount){
		int newBalance= currentLoggenInCustomer.getBalance() + amount;
		currentLoggenInCustomer.setBalance(newBalance);
		return true;
	}
	public int balanceCheck(){
		int balance= currentLoggenInCustomer.getBalance();
		return balance;
	}
	
	private boolean phoneValidation(long phone){
		if(phone> 1000000000l && phone< 9999999999l){
			return true;
		}else{
		return false;
		}
	}
	
	private boolean userIdValidation(String userID){
		for(int i =0; i<counter;i++){
			if(bc[i].getUserID().equalsIgnoreCase(userID)){
				return false;
			}
		}
		return true;
	}
	public boolean logout(){
		bc[loggedInCustomerIndex]= currentLoggenInCustomer;
		return true;
	}
	
	

}
