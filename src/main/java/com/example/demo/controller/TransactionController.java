package com.example.demo.controller;

import com.example.demo.model.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TransactionController {

        private List<Transaction> transactions = new ArrayList<>();

        @GetMapping
        public List<Transaction> getTransactions() {
            return transactions;
        }

        @GetMapping("/{id}")
        public Transaction getTransaction(@PathVariable Long id) {
            // Assuming tasks are identified by their ID
            return transactions.stream()
                    .filter(tx -> tx.getId() == id)
                    .findFirst()
                    .orElse(null);
        }

        @PostMapping
        public Transaction addTransaction(@RequestBody Transaction task) {
            // Assuming you have some way to generate unique IDs
            Long id = generateUniqueId();
            task.setId(id);
            transactions.add(task);
            return task;
        }
/*
        @PutMapping("/{id}")
        public Task updateTransaction(@PathVariable Long id, @RequestBody Task updatedTask) {
            Task task = getTransaction(id);

            if (task != null) {
                task.setName(updatedTask.getName());
                task.setCompleted(updatedTask.isCompleted());
            }

            return task;
        }

        @DeleteMapping("/{id}")
        public void deleteTask(@PathVariable Long id) {
            Task task = getTask(id);
            tasks.remove(task);
        }
*/
        private Long generateUniqueId() {
            // You need to implement a way to generate unique IDs
            // This can be done in many ways, e.g., using UUIDs, database auto-increment, etc.
            // For simplicity, let's assume a counter.
            return System.currentTimeMillis();
        }
    }
}
