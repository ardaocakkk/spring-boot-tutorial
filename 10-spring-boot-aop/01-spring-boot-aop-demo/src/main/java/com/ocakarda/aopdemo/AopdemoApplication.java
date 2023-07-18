package com.ocakarda.aopdemo;

import com.ocakarda.aopdemo.dao.AccountDao;
import com.ocakarda.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDao, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDAO membershipDAO) {
		Account myAccount = new Account();
		accountDao.addAccount(myAccount);

		membershipDAO.addAccount();
	}

}
