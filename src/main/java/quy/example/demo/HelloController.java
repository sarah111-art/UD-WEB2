package quy.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private List<Integer> numbers = new ArrayList<>();

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, Client!";
    }

    @PostMapping("/add")
    public String addNumber(@RequestParam int number) {
        numbers.add(number);
        return "Number added: " + number;
    }

    @PutMapping("/update")
    public String updateNumber(@RequestParam int index, @RequestParam int number) {
        if (index >= 0 && index < numbers.size()) {
            numbers.set(index, number);
            return "Number at index " + index + " updated to: " + number;
        } else {
            return "Index out of bounds";
        }
    }

    @DeleteMapping("/delete")
    public String deleteNumber(@RequestParam int index) {
        if (index >= 0 && index < numbers.size()) {
            int removedNumber = numbers.remove(index);
            return "Number removed: " + removedNumber;
        } else {
            return "Index out of bounds";
        }
    }

    @GetMapping("/sum")
    public String sumNumbers() {
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        return "Sum of numbers: " + sum;
    }

    @GetMapping("/sumTwo")
    public String sumTwoNumbers(@RequestParam int num1, @RequestParam int num2) {
        int sum = num1 + num2;
        return "Sum of " + num1 + " and " + num2 + " is: " + sum;
    }
}