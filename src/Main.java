import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Operations ops = new Operations();
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("C -> Create User");
            System.out.println("G -> Get User");
            System.out.println("A -> Get All User");
            System.out.println("D -> Delete User");
            System.out.println("U -> Update User");
            System.out.println("E -> Exit");
            System.out.println("Enter Choice.....");

            char ch = Character.toLowerCase(input.next().charAt(0));
            input.nextLine();

            try {
                switch (ch) {

                    case 'c':
                        ops.createUser();
                        break;

                    case 'g':
                        ops.getUser();
                        break;

                    case 'a':
                        ops.getAllUser();
                        break;

                    case 'd':
                        ops.deleteUser();
                        break;

                    case 'u':
                        ops.updateUser();
                        break;

                    case 'e':
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (UserNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}