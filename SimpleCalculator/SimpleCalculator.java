import java.util.Scanner;

/**
 * SimpleCalculator - A command-line calculator that performs basic arithmetic operations
 * on two numbers using a single operator.
 * 
 * Features:
 * - Supports addition (+), subtraction (-), multiplication (*), and division (/)
 * - Error checking for division by zero
 * - Error checking for invalid operators
 * - Uses switch statement for operation selection
 */
public class SimpleCalculator {
    
    /**
     * Main method - Entry point of the calculator application
     * Prompts user for two numbers and an operator, then displays the result
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Display welcome message
            displayWelcomeMessage();
            
            // Get first number from user
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            
            // Get second number from user
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            // Clear the newline character
            scanner.nextLine();
            
            // Get operator from user
            System.out.print("Enter operator (+, -, *, /): ");
            String operator = scanner.nextLine().trim();
            
            // Perform calculation
            double result = calculate(num1, num2, operator);
            
            // Display result
            displayResult(num1, num2, operator, result);
            
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: Invalid input. Please enter valid numbers.");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Displays welcome message and instructions to the user
     */
    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("   Simple Calculator Application    ");
        System.out.println("=====================================");
        System.out.println("This calculator supports: +, -, *, /");
        System.out.println();
    }
    
    /**
     * Performs the calculation based on the operator provided
     * 
     * @param num1 First operand
     * @param num2 Second operand
     * @param operator Arithmetic operator (+, -, *, /)
     * @return Result of the calculation
     * @throws ArithmeticException if division by zero is attempted
     * @throws IllegalArgumentException if operator is invalid
     */
    private static double calculate(double num1, double num2, String operator) {
        double result;
        
        // Use switch statement to determine operation
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            
            case "-":
                result = num1 - num2;
                break;
            
            case "*":
                result = num1 * num2;
                break;
            
            case "/":
                // Check for division by zero
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed!");
                }
                result = num1 / num2;
                break;
            
            default:
                // Invalid operator error
                throw new IllegalArgumentException("Invalid operator: '" + operator + "'. Please use +, -, *, or /");
        }
        
        return result;
    }
    
    /**
     * Displays the calculation result in a formatted manner
     * 
     * @param num1 First operand
     * @param num2 Second operand
     * @param operator Arithmetic operator used
     * @param result Result of the calculation
     */
    private static void displayResult(double num1, double num2, String operator, double result) {
        System.out.println();
        System.out.println("=====================================");
        System.out.println("Result:");
        System.out.printf("%.2f %s %.2f = %.2f%n", num1, operator, num2, result);
        System.out.println("=====================================");
    }
}
