package in.bushansirgur.expensetrackerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.expensetrackerapi.entity.Expense;
import in.bushansirgur.expensetrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	@ResponseBody
	public List<Expense> getAllExpenses() {
		System.out.println(expenseService.getAllExpenses().toString());
		return expenseService.getAllExpenses();
	}
	
	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable("id") Long id	) {
		return expenseService.getExpenseById(id);
	}
	
	@DeleteMapping("/expenses")
	public void deleteExpenseById(@RequestParam("id") Long id) {
		 expenseService.deleteExpenseById(id);
		
	}
}
