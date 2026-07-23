import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Operations ops = new Operations();



        while(true) {

            System.out.println("C -> Create User ");
            System.out.println("G -> Get User ");
            System.out.println("A -> Get All User ");
            System.out.println("D -> Delete User ");
            System.out.println("U -> Update User ");
            System.out.println("E -> Exit ");
            System.out.println("Enter Choice..... ");

            char ch = input.next().charAt(0);

            switch (ch) {
                case 'C':
                    ops.createUser();
                    break;

                case 'G':
                    ops.getUser();
                    break;

                case 'A':
                    ops.getAllUser();
                    break;

                case 'D':
                    ops.deleteUser();
                    break;

                case 'U':
                    ops.updateUser();
                    break;

                case 'E':
                    return;

                default:
                    break;

            }
        }
    }
}