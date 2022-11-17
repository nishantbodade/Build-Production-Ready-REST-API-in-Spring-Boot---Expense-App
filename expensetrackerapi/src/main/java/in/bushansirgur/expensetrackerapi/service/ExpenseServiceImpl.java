package in.bushansirgur.expensetrackerapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bushansirgur.expensetrackerapi.entity.Expense;
import in.bushansirgur.expensetrackerapi.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepo;

	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}

	@Override
	public Expense getExpenseById(Long id) {
	
		Optional<Expense> expense = expenseRepo.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		}
		
		throw new RuntimeException("Expense is not found for the id "+id);
	}

	@Override
	public void deleteExpenseById(Long id) {
		expenseRepo.deleteById(id);
		
	}

}
