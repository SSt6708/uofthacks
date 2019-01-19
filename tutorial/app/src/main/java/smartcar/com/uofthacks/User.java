package smartcar.com.uofthacks;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    ArrayList accounts;
    public User() {
        ArrayList accounts = new ArrayList();
    }

    public void printArray(){

        for (int i = 0; i < accounts.size(); i++){
            System.out.println(accounts.get(i));
        }
    }


}










