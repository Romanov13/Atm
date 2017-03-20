package atm;

public class InternetShop{

String name;

public InternetShop(String name){
this.name = name;
}

public void buyItem(){

System.out.println("To buy an item, please enter the card number, the date of expiery and CVV.");
verify();
}

public boolean verify(){

Scanner sc = new Scanner(System.In);
System.out.println("Enter the number");

}
}
