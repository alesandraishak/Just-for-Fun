import java.util.Scanner;
import java.lang.Math;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Welcome user and explain functionality
        System.out.println("Welcome to Alesandra's Grade Calculator!\nTo see instructions, please type 'help' or enter any character to get started.");
        String input = scanner.nextLine();
        if (input.equals("help")){
            System.out.println("\nBegin by entering your grade on an assessment, followed by it's respective weight.\nRepeat this until you have entered all entities and type 'done' to indicate this.");
            System.out.println("\nFrom here you will have the option to calculate the remaining grade you must recieve, to acheive your target grade.\n");
        }

        float totalWeight = 0;
        float totalGradeWeighted = 0;
        // Collect user input until they input 'done'
        while (true){
            System.out.println("Please enter your grade, or type 'done' to indicate you are finished: ");
            input = scanner.nextLine();

            if (input.equals("done")){
                break;
            }

            float grade = Float.parseFloat(input);

            System.out.println("Please enter the corresponding weight: ");
            float weighting = Float.parseFloat(scanner.nextLine());

            totalWeight += weighting;
            totalGradeWeighted += grade * weighting;

        }

        if (totalWeight > 0 && totalWeight == 100){
            float current = totalGradeWeighted/totalWeight;

            System.out.println("Grade: " + current);
        }

        if (totalWeight > 0 && totalWeight < 100){
            float current = totalGradeWeighted/totalWeight;
            System.out.println("Grade: " + current);

            // prompt and calculate required grade to reach target grade
            if (totalWeight != 100){
                System.out.print("Please enter your target grade: ");
                float target = Float.parseFloat(scanner.nextLine());
                
                // convert total weight and final (remaining) weighting to decfimal values for the calculations`                                                                                                                                                        
                float decTotalWeight = (totalWeight)/100;
                float decFinalWeight = (100 - totalWeight)/100;

                float required = (target - (decTotalWeight * current))/(decFinalWeight);
                if (required >= 0 && required <= 100){
                    System.out.println("To finish with a " + target + " you must achieve a grade of " + required + " on your final exam.");
                }
                // return if the user would have to get a negative mark for the remainder of their grade
                else if (required < 0){
                    System.out.println("It is impossible for your grade to drop to a(n) " + target);
                }
                // return if the user would have to get a mark that is greater than 100% for the remainder of their grader2
                else {
                    System.out.println("Sorry, it is impossible for you to finish with a(n) " + target);
                }
                
            }
        
        }
        else if (totalWeight == 0){
            System.out.println("Sorry, unable to calculate final grade. No grades entered.");
        }
        else if (totalWeight > 100){
            System.out.println("Oops, your grade makeup is greater than 100%. Please try again.");
        }
        else{
            System.out.println("You have completed all assessments for this course. Congratulations!");
        }

        scanner.close();
    }
}

