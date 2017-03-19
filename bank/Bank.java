package bank;

import java.util.*;

class Bank{

	Set<Client> clients = new HashSet<Client>();

	HashMap<Client, Account> accounts = new HashMap<Client, Account>();
	
	public Account makeAccount(Client client){
		Account account = new Account(client);
		
		return account;
	}
}
