package bank;

import java.util.*;

class Bank{

	Set<Client> clients = new HashSet<Client>();

	HashMap<Client, HashSet<Account>> accounts = new HashMap<Client, HashSet<Account>>();
	
	public Account makeAccount(Client client){
		if(!clients.contains(client){
			clients.add(client);
		}
		Account account = new Account(client);
		accounts.get(client).add(account);
		return account;
	}
	
	public void addClient(Client client){
		clients.add(client);
	}
	
}
