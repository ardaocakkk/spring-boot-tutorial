package com.ocakarda.aopdemo;

import com.ocakarda.aopdemo.dao.AccountDao;
import com.ocakarda.aopdemo.dao.MembershipDAO;
import com.ocakarda.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
		return runner -> {
//			demoTheBeforeAdvice(accountDao, membershipDAO);
//			demoTheAfterReturningAdvice(accountDao);
//			demoTheAfterThrowingAdvice(accountDao);
//			demoTheAfterAdvice(accountDao);
//			demoTheAroundAdvice(trafficFortuneService);
//			demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);

		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main program: demoTheAroundAdviceRethrowException()");

		System.out.println("getfortune()");
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("the fortune is: " + data);
		System.out.println("finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main program: demoTheAroundAdviceHandleException()");

		System.out.println("getfortune()");
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("the fortune is: " + data);
		System.out.println("finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main program: demoTheAroundAdvice()");

		System.out.println("getfortune()");
		String data = trafficFortuneService.getFortune();
		System.out.println("the fortune is: " + data);
		System.out.println("finished");
	}

	private void demoTheAfterAdvice(AccountDao accountDao) {
		List<Account> accounts = null;

		try {
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		}catch (Exception exception) {
			System.out.println("Main program caught exception:" + exception.getMessage() );
		}

		System.out.println("\n\n main program: demoTheAfterThrowingAdvice()");
		System.out.println(accounts);
		System.out.println("\n");

	}

	private void demoTheAfterThrowingAdvice(AccountDao accountDao) {
		List<Account> accounts = null;

		try {
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		}catch (Exception exception) {
			System.out.println("Main program caught exception:" + exception.getMessage() );
		}

		System.out.println("\n\n main program: demoTheAfterThrowingAdvice()");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDao accountDao) {
		List<Account> accounts = accountDao.findAccounts();

		System.out.println("\n\n main program: demoTheAfterReturningAdvice()");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDAO membershipDAO) {
		Account myAccount = new Account();
		myAccount.setName("arda");
		myAccount.setLevel("99");
		accountDao.addAccount(myAccount);
		accountDao.setName("foobar");
		accountDao.setServiceCode("silver");

		String name = accountDao.getName();
		String serviceName = accountDao.getServiceCode();
		membershipDAO.addAccount();
	}

}
