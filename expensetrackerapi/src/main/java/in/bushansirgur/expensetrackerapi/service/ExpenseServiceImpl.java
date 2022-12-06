package in.bushansirgur.expensetrackerapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.bushansirgur.expensetrackerapi.entity.Expense;
import in.bushansirgur.expensetrackerapi.exceptions.ExpenseNotFoundException;
import in.bushansirgur.expensetrackerapi.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepo;

	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepo.findAll(page);
	}

	@Override
	public Expense getExpenseById(Long id) {
	
		Optional<Expense> expense = expenseRepo.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		}
		
		throw new ExpenseNotFoundException("Expense is not found for the id "+id);
	}

	@Override
	public void deleteExpenseById(Long id) {
		expenseRepo.deleteById(id);
		
	}

	@Override
	public Expense saveExpenseDetails(Expense expense) {
			
		return expenseRepo.save(expense);
	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense existingExpense=getExpenseById(id);
		existingExpense.setName(expense.getName()!=null?expense.getName():existingExpense.getName());
		existingExpense.setAmount(expense.getAmount()!=null?expense.getAmount():existingExpense.getAmount());
		existingExpense.setCategory(expense.getCategory()!=null?expense.getCategory():existingExpense.getCategory());
		existingExpense.setDate(expense.getDate()!=null?expense.getDate():existingExpense.getDate());
		existingExpense.setDescription(expense.getDescription()!=null?expense.getDescription():existingExpense.getDescription());
		return expenseRepo.save(existingExpense);
		
	}

}
