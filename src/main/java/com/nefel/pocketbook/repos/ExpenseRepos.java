package com.nefel.pocketbook.repos;

import com.nefel.pocketbook.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepos extends JpaRepository<Expense, Integer> {
}
