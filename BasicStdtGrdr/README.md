# BasicStdtGrdr (Basic Student Grader)

A student grading system that calculates averages and assigns letter grades.

## Features
- Input student names and five test scores
- Automatically calculates average for each student
- Assigns letter grades (A-F) based on average
- Displays formatted results table
- Shows class statistics (class average, highest, lowest)

## Grading Scale
- **A**: 90-100
- **B**: 80-89
- **C**: 70-79
- **D**: 60-69
- **F**: Below 60

## How to Compile
```bash
javac BasicStdtGrdr.java
```

## How to Run
```bash
java BasicStdtGrdr
```

## Usage Example
```
Enter number of students: 2
--- Student 1 ---
Enter student name: John Doe
Enter 5 test scores:
Score 1: 95
Score 2: 88
Score 3: 92
Score 4: 85
Score 5: 90

--- Student 2 ---
Enter student name: Jane Smith
Enter 5 test scores:
Score 1: 78
Score 2: 82
Score 3: 75
Score 4: 80
Score 5: 85
```

## Output
The program displays a formatted table showing:
- Student names
- All five scores
- Calculated average
- Letter grade
- Class statistics
