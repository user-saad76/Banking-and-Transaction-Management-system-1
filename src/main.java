import java.util.Scanner;

class Account{
     private String name;
    private String fatherName;
    private int age;
    private String phoneNo;
    private String CNIC;
    private String address;
    private String password;

    Account(String name,String fatherName,int age,String phoneNo,String CNIC,String address, String password){
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
        this.phoneNo = phoneNo;
        this.CNIC = CNIC;
        this.address = address;
        this.password = password;
    }

    void detail(){
        System.out.println("***********************");
        System.out.println("Name = " + name);
        System.out.println("Father name = " + fatherName);
        System.out.println("Age = " + age);
        System.out.println("Phone number  = " + phoneNo);
        System.out.println("CNIC = " + CNIC);
        System.out.println("Address = " + address);
        System.out.println("***********************");
    }


}

class SavingsAccount{

}

class CurrentAccount {

}







public class main {
    public static void main(String[] args) {
        System.out.println("*********************BANKING & TRANSACTION MANAGEMENT SYSTEM*********************");
        Scanner input = new Scanner(System.in);
        System.out.println();
        int totalAccounts = 5;
        String[] name = new String[totalAccounts];
        String[] fatherName = new String[totalAccounts];
        int[] age = new int[totalAccounts];
        String[] phoneNo = new String[totalAccounts];
        String[] CNIC = new String[totalAccounts];
        String[] address = new String[totalAccounts];
        String[] password = new String[totalAccounts];
        int x = 0;
         while(x<totalAccounts){
             boolean aggreed = false;
             System.out.println("You want to create account (Yes/No) : " );
             String decision = input.nextLine();
             if(decision.equalsIgnoreCase("Yes")){
                 aggreed = true;
             }
             if(aggreed){
                 System.out.print("Enter your name : ");
                 name[x] = input.nextLine();
                 System.out.print("Enter your father name : ");
                 fatherName[x] = input.nextLine();
                 System.out.print("Enter your age : ");
                 age[x] = input.nextInt();
                 System.out.print("Enter your phone number : ");
                 phoneNo[x] = input.nextLine();
                 System.out.print("Enter your CNIC number :  ");
                 CNIC[x] = input.nextLine();
                 System.out.print("Enter your address : ");
                 address[x] = input.nextLine();
                 System.out.print("Set a strong password for account : ");
                 password[x] = input.nextLine();
                 Account[] account = new Account[totalAccounts];
                 account[x] = new Account( name[x],fatherName[x], age[x], phoneNo[x],CNIC[x], address[x],password[x]);

             }

         }

    }
}
