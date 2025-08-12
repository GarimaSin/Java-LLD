package Template;

public class Client {

	
	public static void main(String[] args) {
		PaymentFlow pay = new PayToFriend();
		pay.sendMoney();
		
		System.out.println();
		
		pay = new PayToMerchant();
		pay.sendMoney();
	}
}
