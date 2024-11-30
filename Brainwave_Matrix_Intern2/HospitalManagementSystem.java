import java.util.*;

// Class for Patient
class Patient {
    int id;
    String name;
    int age;
    String disease;
    String appointmentDate;

    public Patient(int id, String name, int age, String disease, String appointmentDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + 
               ", Disease: " + disease + ", Appointment Date: " + appointmentDate;
    }
}

// Class for Staff
class Staff {
    int staffId;
    String name;
    String position;

    public Staff(int staffId, String name, String position) {
        this.staffId = staffId;
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Staff ID: " + staffId + ", Name: " + name + ", Position: " + position;
    }
}

// Class for Inventory
class Inventory {
    String itemName;
    int quantity;

    public Inventory(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item: " + itemName + ", Quantity: " + quantity;
    }
}

// Main Hospital Management System Class
public class HospitalManagementSystem {
    static List<Patient> patients = new ArrayList<>();
    static List<Staff> staffList = new ArrayList<>();
    static List<Inventory> inventoryList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHospital Management System:");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View Patients");
            System.out.println("4. Manage Staff");
            System.out.println("5. Manage Inventory");
            System.out.println("6. Billing");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerPatient(scanner);
                    break;
                case 2:
                    scheduleAppointment(scanner);
                    break;
                case 3:
                    viewPatients();
                    break;
                case 4:
                    manageStaff(scanner);
                    break;
                case 5:
                    manageInventory(scanner);
                    break;
                case 6:
                    generateBill(scanner);
                    break;
                case 7:
                    System.out.println("Exiting System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
        scanner.close();
    }

    // Patient Registration
    public static void registerPatient(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();

        patients.add(new Patient(id, name, age, disease, "Not Scheduled"));
        System.out.println("Patient Registered Successfully!");
    }

    // Schedule Appointment
    public static void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter Patient ID to Schedule Appointment: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.print("Enter Appointment Date (DD-MM-YYYY): ");
                String date = scanner.nextLine();
                p.appointmentDate = date;
                System.out.println("Appointment Scheduled Successfully!");
                return;
            }
        }
        System.out.println("Patient ID not found!");
    }

    // View Patients
    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No Patients Registered.");
            return;
        }
        System.out.println("Registered Patients:");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
 // Manage Staff
 public static void manageStaff(Scanner scanner) {
    System.out.println("1. Add Staff");
    System.out.println("2. View Staff");
    System.out.print("Enter choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice == 1) {
        System.out.print("Enter Staff ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Position: ");
        String position = scanner.nextLine();

        staffList.add(new Staff(id, name, position));
        System.out.println("Staff Added Successfully!");
    } else if (choice == 2) {
        if (staffList.isEmpty()) {
            System.out.println("No Staff Registered.");
            return;
        }
        System.out.println("Staff Details:");
        for (Staff s : staffList) {
            System.out.println(s);
        }
    } else {
        System.out.println("Invalid choice!");
    }
}

// Manage Inventory
public static void manageInventory(Scanner scanner) {
    System.out.println("1. Add Item to Inventory");
    System.out.println("2. View Inventory");
    System.out.print("Enter choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice == 1) {
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        inventoryList.add(new Inventory(itemName, quantity));
        System.out.println("Item Added to Inventory!");
    } else if (choice == 2) {
        if (inventoryList.isEmpty()) {
            System.out.println("Inventory is Empty.");
            return;
        }
        System.out.println("Inventory Details:");
        for (Inventory i : inventoryList) {
            System.out.println(i);
        }
    } else {
        System.out.println("Invalid choice!");
    }
}

// Generate Bill
public static void generateBill(Scanner scanner) {
    System.out.print("Enter Patient ID to Generate Bill: ");
    int id = scanner.nextInt();

    for (Patient p : patients) {
        if (p.id == id) {
            System.out.println("Generating Bill for Patient: " + p.name);
            System.out.print("Enter Total Charges: ");
            double charges = scanner.nextDouble();
            System.out.println("Bill Generated Successfully! Total Amount: $" + charges);
            return;
        }
    }
    System.out.println("Patient ID not found!");
}
}


