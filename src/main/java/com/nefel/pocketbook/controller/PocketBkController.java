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
//@RequestMapping("/expenses")
@AllArgsConstructor
public class PocketBkController {

    @Autowired
    ExpenseService service;

    @GetMapping("/expenses")
    public String getExpenses(Model model){
        model.addAttribute("expenses", service.getAll());
        return "index";
    }

    @GetMapping("/expenses/new")
    public String getExpense(Model model ){
        Expense expense= new Expense();
        model.addAttribute("expense", expense);

        return "create_expense";
    }

    @PostMapping("/expenses")
    public String saveExpenses(@ModelAttribute("expense") Expense expense ){
        service.save(expense);
        return"redirect:/index";
    }

    @PutMapping("/expenses/edit/{id}")
    public Expense updateExpenses(@PathVariable("id") Integer id, Model model ){
        model.addAttribute("expense", service.update(expense));
        return "edit_expense";
    }
    @GetMapping("/expenses/edit/{id}")
	public String editExpenseForm(@PathVariable Integer id, Model model) {
		model.addAttribute("expense", servise.get(id));
		return "edit_student";
	}

    @DeleteMapping("/expenses/delete/{id}")
    public void updateExpenses(@PathVariable("id") Integer id){
        service.delete(id);
		return "redirect:/index";
    }
}
