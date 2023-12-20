package com.nefel.pocketbook.controller;

import com.nefel.pocketbook.models.Expense;
import com.nefel.pocketbook.services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class PocketBkController {

    @Autowired
    ExpenseService service;
// handler method to handle list expenses and return mode and view
    @GetMapping("/expenses")
    public String getExpenses(Model model){
        model.addAttribute("expenses", service.getAll());
        return "index";
    }

    @GetMapping("/expenses/new")
    public String getExpense(Model model ){
// create expense object to hold expense form data
        Expense expense= new Expense();
        model.addAttribute("expense", expense);
        return "create_expense";
    }

    @PostMapping("/expenses")
    public String saveExpense(@ModelAttribute("expense") Expense expense ){
        service.save(expense);
        return"redirect:/index";
    }
     @GetMapping("/expenses/edit/{id}")
	public String editExpenseForm(@PathVariable Integer id, Model model) {
		model.addAttribute("expense", servise.get(id));
		return "edit_student";
	}
    @PostMapping("/expenses/{id}")
	public String updateExpense(@PathVariable Integer id,
			@ModelAttribute("expense") Expense expense,
			Model model) {
		
		// get expense from database by id
		Expense existingExpense = servise.get(id);
		existingExpense.setId(id);
		existingExpense.setName(Expense.getName());
		existingExpense.setAmount(Expense.getAmount());
		existingExpense.setVendor(Expense.getVendor());
        existingExpense.setDescription(Expense.getDescription());
		
		// save updated expense object
		servise.update(existingExpense);
		return "redirect:/index";		
	}

   /* @PutMapping("/expenses/edit/{id}")
    public Expense updateExpenses(@PathVariable("id") Integer id, Model model ){
        model.addAttribute("expense", service.update(expense));
        return "edit_expense";
    }*/
   

    @DeleteMapping("/expenses/delete/{id}")
    public void updateExpenses(@PathVariable("id") Integer id){
        service.delete(id);
		return "redirect:/index";
    }
}
