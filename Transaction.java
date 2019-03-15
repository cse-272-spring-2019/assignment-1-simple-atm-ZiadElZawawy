package projectATM;

public class Transaction {
	private int value = 0;
	CreditCard card ;
	String [] history = new String [5] ;
	int i=0;
	public int getValue() {
		return value;
		
	}
	public void setValue(int x) {
		this.value=x;
	}


	public boolean  withdraw(int x) {
		int temp;
	
		boolean a;
		if (x > value)
			a = false;
		else if (x < 0)
			a = false;
	
		else
			{this.value -= x;
			a = true;
			if(i==5) {
				for(temp=0 ; temp<4 ; temp++)
						history[temp]=history[temp+1];
						i--;
						history[4] = "Withdraw: " +x;
			}
				else {		
			history[i++] = "Withdraw: " +x;
				}
			}
		return a;
	}

	public boolean deposit(int x) {
		int temp;
		if (x<0)
			return false;
		else {
		
		this.value += x;
		if(i==5) {
			for(temp=0 ; temp<4 ; temp++)
					history[temp]=history[temp+1];
			i--;
			history[4] = "Deposit:" + x;
		}
	else		{
		history[i++] = "Deposit:" + x;
		
		}
		return true;
		}
		}
	public void inq() {
		
		int temp;
		if(i==5) {
		
			for(temp=0 ; temp<4 ; temp++)
					history[temp]=history[temp+1];
			i--;
			
			history[4] = "Balance inquiry:" + value;
}
	else
	{
		history[i++] = "Balance inquiry:" + value;
		
	}
		}
	
	public void prev() {
		
		i--;
		if(i <0)
			i++;
	}
	public void next() {
		
		i++;
		if(i>4)
			i--;
	}
	public String getString() {
	
		return history[i];
	}

}
