import java.util.*;

public class Operations {

    private final Map<String,User>  map = new HashMap<>();
    private final Scanner input = new Scanner(System.in);


    public void createUser(){

        String name;

        while (true) {
            System.out.println("Enter the user name: ");
            name = input.nextLine().trim();

            if (!name.trim().isEmpty() && isValidName(name)) {
                break;
            }

            System.out.println("Invalid name. Enter alphabets and numbers only.");
        }

        String email;

        while (true) {
            System.out.println("Enter the user email: ");
            email = input.nextLine().toLowerCase();

            if (!isValidEmail(email)) {
                System.out.println("Invalid email. Try again.");
                continue;
            }

            if (map.containsKey(email)) {
                System.out.println("User already exists with this email. Try another email.");
                continue;
            }

            break;
        }

        List<String> list = new ArrayList<>();

        System.out.println("Enter mobile numbers:");

        while (true) {

            String number = input.nextLine().trim();

            if (number.isEmpty()) {
                System.out.println("Mobile number cannot be empty. Please enter a number.");
                continue;
            }

            if (!isValidMobile(number)) {
                System.out.println("Invalid mobile number. Enter exactly 10 digits.");
                continue;
            }

            if (list.contains(number)) {
                System.out.println("Number already added.");
                continue;
            }

            list.add(number);

            System.out.println("Mobile number added successfully.");

            System.out.println("Do you want to add another number? (Y/N)");
            char choice = Character.toLowerCase(input.nextLine().charAt(0));

            if (choice == 'n') {
                break;
            }
        }

        User user = new User(email,list,name);
        map.put(email,user);
        System.out.println("User Created Successfully");

    }

    public void getUser() {

        String email;

        while (true) {

            System.out.println("Enter the email: ");
            email = input.nextLine().trim().toLowerCase();

            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Try again.");
                continue;
            }

            if (!map.containsKey(email)) {
                throw new UserNotFoundException("User not found with this email");
            }

            System.out.println(map.get(email));
            break;
        }
    }


    public void deleteUser() {

        String email;

        while (true) {

            System.out.println("Enter the email of user to delete: ");
            email = input.nextLine().trim().toLowerCase();

            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Try again.");
                continue;
            }

            if (!map.containsKey(email)) {
                throw new UserNotFoundException("User not found with this email");
            }

            break;
        }


        System.out.println("Are you sure you want to delete this user? (Y/N)");

        char choice = Character.toLowerCase(input.nextLine().charAt(0));

        if (choice == 'y') {
            map.remove(email);
            System.out.println("User Deleted Successfully");
        } else {
            System.out.println("Delete operation cancelled");
        }
    }


    public void updateUser() {

        String email;

        while (true) {

            System.out.println("Enter email to update: ");
            email = input.nextLine().trim().toLowerCase();

            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Try again.");
                continue;
            }

            if (!map.containsKey(email)) {
                throw new UserNotFoundException("User not found with this email");
            }

            break;
        }


        User currentUser = map.get(email);


        String name;

        while (true) {

            System.out.println("Enter new username: ");
            name = input.nextLine().trim();

            if (!name.isEmpty() && isValidName(name)) {
                break;
            }

            System.out.println("Invalid name. Enter alphabets and numbers only.");
        }


        List<String> list = currentUser.getMobile_no();

        System.out.println("Enter mobile numbers:");

        while (true) {

            String number = input.nextLine().trim();

            if (number.isEmpty()) {
                System.out.println("Mobile number cannot be empty. Please enter a number.");
                continue;
            }

            if (!isValidMobile(number)) {
                System.out.println("Invalid mobile number. Enter exactly 10 digits.");
                continue;
            }

            if (list.contains(number)) {
                System.out.println("Number already added.");
                continue;
            }



            list.add(number);

            System.out.println("Mobile number added successfully.");

            System.out.println("Do you want to add another number? (Y/N)");
            char choice = Character.toLowerCase(input.nextLine().charAt(0));

            if (choice == 'n') {
                break;
            }
        }


        currentUser.setName(name);
        currentUser.setMobile_no(list);

        map.put(email, currentUser);

        System.out.println("User updated successfully");
    }

    public void getAllUser() {

        if (map.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        System.out.println("Total Users: " + map.size());
        System.out.println("----------------------------");

        int count = 1;

        for (User u : map.values()) {
            System.out.println("User " + count);
            System.out.println(u);
            System.out.println("----------------------------");
            count++;
        }
    }




    boolean isValidEmail(String email) {
        return email != null &&
                email.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$");
    }


    boolean isValidMobile(String number) {
        return number != null &&
                number.matches("\\d{10}");
    }


    boolean isValidName(String name) {
        return name != null &&
                name.matches("[a-zA-Z0-9 ]+");
    }



}