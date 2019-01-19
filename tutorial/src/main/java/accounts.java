import java.util.Scanner;

public class accounts {

    private String Username;
    private String Password;
    private int Balance;

    public accounts(String username, String password, int balance) {
        Username = username;
        Password = password;
        Balance = balance;

        System.out.println("The account is created!! and your balance is: " + Balance);
    }


    public static void main(String[] args) {
        User a = new User();

        //if(signup) {
            System.out.println("Please create an account: ");

            Scanner input1 = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            Scanner input3 = new Scanner(System.in);

            String username = input1.nextLine();
            String password = input2.nextLine();
            String in = input3.nextLine();

            int balance = Integer.parseInt(in);


            accounts b = new accounts(username, password, balance);
            a.accounts.add(b);
            a.printArray();
        //}
    }
}