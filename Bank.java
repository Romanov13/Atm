package card;

class Bank{
	
	HashSet accounts = new HashSet();
	
	public Account makeAccount(Client client){
		Account account = new Account(client);
		
		return account;
	}
}
