package Template;

public class PayToFriend extends PaymentFlow{

	@Override
	public void validateRequest() {
		System.out.println("Validate logic of payToFriend");
	}

	@Override
	public void calculateFees() {
		System.out.println("Debit the amount logic of payToFriend");
	}

	@Override
	public void debitAmount() {
		System.out.println("0% fees charged");
	}

	@Override
	public void creditAmount() {
		System.out.println("Credit the full amount");
	}

}
