package com.nefel.pocketbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import net.javaguides.sms.entity.Expense;
import net.javaguides.sms.repository.ExpenseRepos;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocketbookApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PocketbookApplication.class, args);
	}
	@Autowired
	private ExpenseRepos expenseRepos;

	@Override
	public void run(String... args) throws Exception {
		
		
		 Expense expense1 = new Expense("Farouk", "xxxxx", 54.0f,"xxxxxxxx");
		 expenseRepos.save(expense1);
		 
		 Expense expense2 = new Expense("fathi", "yyyyy", 12.6f,"yyyyyyy");
		 expenseRepos.save(expense2);
		 
		 Expense expense3 = new Expense("Ahlem", "zzzzzz", 44.0f,"zzzzzz");
		 expenseRepos.save(expense3);
		 
		
	}


}
