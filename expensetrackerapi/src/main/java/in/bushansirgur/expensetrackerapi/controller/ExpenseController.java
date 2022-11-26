package in.bushansirgur.expensetrackerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.expensetrackerapi.entity.Expense;
import in.bushansirgur.expensetrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	@ResponseBody
	public List<Expense> getAllExpenses(Pageable page) {
		System.out.println(expenseService.getAllExpenses(page).toString());
		return expenseService.getAllExpenses(page).toList();
	}
	
	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable("id") Long id	) {
		return expenseService.getExpenseById(id);
	}
	
	@DeleteMapping("/expenses")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteExpenseById(@RequestParam("id") Long id) {
		 expenseService.deleteExpenseById(id);
		
	}
	
	@PostMapping("/expenses")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Expense saveExpenseDetails(@RequestBody Expense expense) {

		return expenseService.saveExpenseDetails(expense);
	}
	
	@PostMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@RequestBody Expense expense,@PathVariable Long id) {
		return  expenseService.updateExpenseDetails(id, expense);
	}
}
