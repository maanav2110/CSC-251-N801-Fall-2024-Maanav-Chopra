import java.util.Scanner;

public class Policy {
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    // No-arg constructor -->

    public Policy() {
        policyNumber = 0;
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "";
        height = 0.0;
        weight = 0.0;
    }

    // Constructor -->

    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    
    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //to calculate BMI-->

    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    //for policy price-->

    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;

        if (age > 50) {
            additionalFee += 75.0;
        }

        if (smokingStatus.equalsIgnoreCase("smoker")) {
            additionalFee += 100.0;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20;
        }

        return baseFee + additionalFee;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //user input -->

        System.out.println("Please enter the Policy Number:");
        int policyNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Please enter the Provider Name:");
        String providerName = scanner.nextLine();
        System.out.println("Please enter the Policyholders First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Please enter the Policyholders Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Please enter the Policyholders Age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Please enter the Policyholders Smoking Status (smoker/non-smoker):");
        String smokingStatus = scanner.nextLine();
        System.out.println("Please enter the Policyholders Height (in inches):");
        double height = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Please enter the Policyholders Weight (in pounds):");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Create Policy-->

        Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                    age, smokingStatus, height, weight);

        // Display policy-->
        System.out.println("\nSample Output:");
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholders First Name: " + policy.getFirstName());
        System.out.println("Policyholders Last Name: " + policy.getLastName());
        System.out.println("Policyholders Age: " + policy.getAge());
        System.out.println("Policyholders Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholders Height: " + policy.getHeight() + " in");
        System.out.println("Policyholders Weight: " + policy.getWeight() + " lbs");
        System.out.println("Policyholders BMI: " + policy.calculateBMI());
        System.out.printf("Policy Price: $%.2f\n", policy.calculatePolicyPrice());

        scanner.close();
    }
}