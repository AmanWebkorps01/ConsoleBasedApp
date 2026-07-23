import java.util.*;

public class Operations {

    private final Map<String,User>  map = new HashMap<>();
    private final Scanner input = new Scanner(System.in);


    public void createUser(){

        System.out.println("Enter the user name: ");
        String name = input.nextLine();
        System.out.println("Enter the user email: ");
        String email = input.nextLine();
        List<String> list = new ArrayList<>();

        if(!isValidEmail(email)){
            System.out.println("Invalid Email");
            return;
        }

        if(map.containsKey(email)) {
            System.out.println("User already exist with this email");
            return;
        }

        System.out.println("Enter the user mobile numbers : ");

        while(true){
            String number = input.nextLine();
            if(number.isEmpty()){
                break;
            }

            if(!isValidMobile(number)) {
                System.out.println("Invalid number");
                continue;
            }

            list.add(number);

        }

        User user = new User(email,list,name);
        map.put(email,user);
        System.out.println("User Created Successfully");

    }

    public void getUser(){

        System.out.println("Enter the email : ");
        String email = input.nextLine();

        if(!isValidEmail(email)){
            System.out.println("Enter the email in correct format");
            return;
        }

        if(map.containsKey(email)){
            System.out.println(map.get(email));
        }else{
            throw new UserNotFoundException("User not found with this email");
        }

    }


    public void deleteUser(){

        System.out.println("Enter the email of user : ");
        String email = input.nextLine();
        if (!map.containsKey(email)) {
            throw new UserNotFoundException("User not found with this email");
        }

        map.remove(email);
        System.out.println("User Deleted successfully");

    }


    public void updateUser(){

        System.out.println("Enter email to update : ");
        String email = input.nextLine();

        if(!map.containsKey(email)){
            throw new UserNotFoundException("User not found with this email");
        }

        User currentUser = map.get(email);

        System.out.println("Enter new username: ");
        String name = input.nextLine();

        List<String> list = new ArrayList<>();
        System.out.println("Enter new mobile numbers : ");

        while(true){
            String number = input.nextLine();
            if(number.isEmpty()){
                break;
            }

            if(!isValidMobile(number)) {
                System.out.println("Invalid number");
                continue;
            }

            list.add(number);

        }

        currentUser.setName(name);
        currentUser.setMobile_no(list);

        map.put(email,currentUser);

        System.out.println("User updated successfully");


    }

    public void getAllUser(){

       if(map.isEmpty()){
           System.out.println("No users found");
           return;
       }

       for(User u : map.values()){
           System.out.println(u);
       }


    }


    boolean isValidEmail(String email) {
        return email != null
                && email.contains("@")
                && !email.startsWith("@")
                && email.endsWith("@gmail.com");
    }

    boolean isValidMobile(String number) {
        return number != null
                && number.length() == 10
                && number.chars().allMatch(Character::isDigit);
    }
}