package Runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Services.AccountService;
import Beans.Account;
import Config.BeanConfiguration;
import Dao.AccountDao;

public class Runner {
	
	public static void main(String[] args){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	
		AccountService service = context.getBean(AccountService.class);
	
		Account account1 = service.getAccount(1);
		Account account2 = service.getAccount(2);
		
		printAccountInfo(account1,account2);
		
		System.out.println("\nTransfering 10 form Dennis to Victor");
		service.transferMoney(1, 2, 10.00);
		
		printAccountInfo(account1,account2);
		
		System.out.println("\nDennis depositing $50.00");
		
		try {
			service.depositMOney(1, 50.00);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		printAccountInfo(account1, account2);
		 
	}
	
	private static void printAccountInfo(Account...accounts){
		for(Account account : accounts)
			System.out.println("Account Owner: " + account.getOwnerName() + "\tAccountBalance: " + account.getBalance());		
	}
	
}
