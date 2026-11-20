import java.util.Scanner;

class Account{
     private String name;
    private String fatherName;
    private int age;
    private String phoneNo;
    private String CNIC;
    private String address;
    private String password;
    private String role;

    Account(String name,String fatherName,int age,String phoneNo,String CNIC,String address, String password,String role){
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
        this.phoneNo = phoneNo;
        this.CNIC = CNIC;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    void detail(){
        System.out.println("***********************");
        System.out.println("Name = " + name);
        System.out.println("Father name = " + fatherName);
        System.out.println("Age = " + age);
        System.out.println("Phone number  = " + phoneNo);
        System.out.println("CNIC = " + CNIC);
        System.out.println("Address = " + address);
        System.out.println("Role = " + role);
        System.out.println("***********************");
    }


}

class SavingsAccount extends Account{
      private int balance;
       double amount;
      int profitRate = 10;

     SavingsAccount(String name,String fatherName,int age,String phoneNo,String CNIC,String address, String password,String role){
         super(name, fatherName, age, phoneNo, CNIC, address, password,role);
     }
      int Balance(){
//          System.out.println("The Intial balance = " + balance);
          return balance;
      }


     void calculateProfit(){
         int profit = balance*(profitRate/100);
         System.out.println("Your profit = " + profit);
         balance = balance + profit;
         System.out.println("Balance = " + balance);
     }

    void deposit(int amount){
        System.out.println("*****************************");
        if(amount>0){
            System.out.println("You have deposit " + amount);
            balance = balance + amount;
            System.out.println("Now total balance = " + balance);
        }
        else{
            System.out.println("You have enter invaild deposit.");
        }

        System.out.println("*****************************");
    }
    void WithDraw(int amount){
        System.out.println("*****************************");
        System.out.println("You have withdraw " + amount);
        if(amount<=balance&&amount>0){
            balance = balance - amount;
        }
        System.out.println("Now total balance = " + Math.abs(balance));
        System.out.println("*****************************");
    }



}

class CurrentAccount extends Account {
    private double balance;

       CurrentAccount(String name,String fatherName,int age,String phoneNo,String CNIC,String address, String password,String role){
           super(name, fatherName, age, phoneNo, CNIC, address, password,role);
       }
    void Balance(){
        System.out.println("The Intial balance = " + balance);
    }


    void deposit(double amount){
        System.out.println("*****************************");
        if(amount>0){
            System.out.println("You have deposit " + amount);
            balance = balance + amount;
            System.out.println("Now total balance = " + balance);
        }
        System.out.println("*****************************");
    }
    void WithDraw(double amount){
        System.out.println("*****************************");
        System.out.println("You have withdraw " + amount);
        if(amount<=balance&&amount>0){
            balance = balance - amount;
            System.out.println("Now total balance = " + Math.abs(balance));
        }
        else{
            System.out.println("You have enter invalid amount");
        }


        System.out.println("*****************************");
    }


}







public class main {
    public static void main(String[] args) {
        System.out.println("*********************BANKING & TRANSACTION MANAGEMENT SYSTEM*********************");
        Scanner input = new Scanner(System.in);
        System.out.println();
        int totalAccounts = 10;
        String[] name = new String[totalAccounts];
        String[] fatherName = new String[totalAccounts];
        int[] age = new int[totalAccounts];
        String[] phoneNo = new String[totalAccounts];
        String[] CNIC = new String[totalAccounts];
        String[] address = new String[totalAccounts];
        String[] password = new String[totalAccounts];
        String[] role = new String[totalAccounts];
        int[] amountData = new int[totalAccounts];
        int[] withdrawalAmounts = new int[totalAccounts];
        SavingsAccount[] savingsAccounts = new SavingsAccount[totalAccounts];
        CurrentAccount[] currentAccounts = new CurrentAccount[totalAccounts];
         int totalTransaction = 5;
         int[][] transaction = new int[totalAccounts][totalTransaction];
         int[] transactionCount = new int[totalTransaction];
         int[] transactionCurrentAccount = new int[totalTransaction];

        int x = 0;
        while (x<totalAccounts) {
            boolean isSavingAccountCreated = false;
            boolean isCurrentAccountCreated = false;
            System.out.println("You have 2 options for creating account : ");
            System.out.println();
            System.out.println("1,Saving Account");
            System.out.println("2,Current Account");
            System.out.println();
            System.out.print("Enter your opinion : ");
            int choice = input.nextInt();
            if (choice == 1) {
                isSavingAccountCreated = true;
            } else if (choice == 2) {
                isCurrentAccountCreated = true;
            } else {
                System.out.println("You have given invaild choice try again!");
            }
            if (isSavingAccountCreated) {
                input.nextLine();
                System.out.print("Enter your name : ");
                name[x] = input.nextLine();
                System.out.print("Enter your father name: ");
                fatherName[x] = input.nextLine();
                System.out.print("Enter your age : ");
                age[x] = input.nextInt();
                if (age[x] >= 15) {
                    input.nextLine();
                    System.out.print("Enter your phone number : ");
                    phoneNo[x] = input.nextLine();
                    System.out.print("Enter your CNIC : ");
                    CNIC[x] = input.nextLine();
                    System.out.print("Enter your address : ");
                    address[x] = input.nextLine();
                    System.out.print("Enter your password : ");
                    password[x] = input.nextLine();
                    System.out.print("Enter your role : ");
                    role[x] = input.nextLine();
                } else {
                    System.out.println("Your age is invalid for creating account");
                    isSavingAccountCreated = false;
                }
            }
            if (isSavingAccountCreated) {
                System.out.println("Your saving account is created successfully.");
                System.out.println("********************************");
                // accounts[x] = new Account( name[x],fatherName[x],age[x],phoneNo[x], CNIC[x],address[x],password[x],role[x]);
                System.out.println();
                System.out.println("Welcome " + name[x]);
                System.out.println();
                System.out.println("1,Check your balance ");
                System.out.println("2,Deposit ");
                System.out.println("3,WithDraw ");
                System.out.println("4,Profit ");
                System.out.println("5,Checking transaction history ");
                System.out.println("6,Transfer money ");
                System.out.println();
                savingsAccounts[x] = new SavingsAccount(
                        name[x], fatherName[x], age[x], phoneNo[x],
                        CNIC[x], address[x], password[x], role[x]
                );
                int count = 0;
                while (true) {
                    System.out.print("Enter your option : ");
                    int givingNumber = input.nextInt();
                    if (givingNumber == 1) {
                        savingsAccounts[x].Balance();

                    } else if (givingNumber == 2) {
                        System.out.print("Enter amount you want to deposit : ");
                        amountData[x] = input.nextInt();
                        if(amountData[x]>0){
                            if(count<totalTransaction){
                                savingsAccounts[x].deposit(amountData[x]);
                                transactionCount[count] =  + amountData[x];
                                transaction[x][count] = + amountData[x];
                                count++;
                            }
                            else{
                                System.out.println("Your transaction cross limited");
                            }
                        }

                    } else if (givingNumber == 3) {
                        System.out.println("Enter amount you want to withdraw : ");
                        withdrawalAmounts[x] = input.nextInt();
                        if (withdrawalAmounts[x] > 0&& withdrawalAmounts[x]<=savingsAccounts[x].Balance()) {
                            if(count<totalTransaction){
                                savingsAccounts[x].WithDraw(withdrawalAmounts[x]);
                                transactionCount[count] = - withdrawalAmounts[x];
                                transaction[x][count] = - withdrawalAmounts[x];
                                count++;
                            }
                            else{
                                System.out.println("Your transaction cross limited");
                            }

                        } else {
                            System.out.println("Negative value amount are not allowed");
                        }
                    }
                    else if (givingNumber == 4) {
                        System.out.println("*********Profit*************");
                        savingsAccounts[x].calculateProfit();
                    }
                    else if (givingNumber == 5) {
                        System.out.println("***********Transaction history*************");
                        System.out.println();
                        System.out.println("Account name : " + name[x]);
                        System.out.println();
                        for(int z = 0;z<totalTransaction;z++){
                            if(transactionCount[z]!=0){
                                System.out.println("Transaction - " + (z+1) + " : " + transactionCount[z]);
                            }
                        }
                        System.out.println();


                    }
                    else if(givingNumber == 6){
                        System.out.println("*************Money Transfer***************");
                        System.out.println();
                        boolean isPhoneNumberisMatched = false;
                        input.nextLine();
                        System.out.print("Enter the phone number which you want to transfer : ");
                        String transferNumber = input.nextLine();
                        for(int i = 0;i<totalAccounts;i++){
                            if(transferNumber.equalsIgnoreCase(phoneNo[i])){
                                isPhoneNumberisMatched = true;
                                System.out.print("Enter amount you have to transfer : ");
                                int transferAmount = input.nextInt();
                                if(transferAmount<=savingsAccounts[x].Balance()){
                                    savingsAccounts[x].WithDraw(transferAmount);
                                    System.out.println("************************");
                                    System.out.println("Account name you have transfer : " + name[i]);
                                    savingsAccounts[i].deposit(transferAmount);
                                    System.out.println("************************");
                                    // 035242775

                                }

                            }
                        }
                        if(!isPhoneNumberisMatched){
                            System.out.println("The phone number is invaild ");
                        }
                    }
                    else if (givingNumber == 7) {
                        break;
                    }
                    else{
                        System.out.println("Your have enter invaild in menu");
                    }
                }
                System.out.print("You want to make new saving account (Yes/No) : ");
                input.nextLine();
                String NewAccount = input.nextLine();
                if(NewAccount.equalsIgnoreCase("Yes")){
                    x++;
                }
            }


            // Current acount logic implemented
            if(isCurrentAccountCreated){
                input.nextLine();
                System.out.print("Enter your name : ");
                name[x] = input.nextLine();
                System.out.print("Enter your father name: ");
                fatherName[x] = input.nextLine();
                System.out.print("Enter your age : ");
                age[x] = input.nextInt();
                if (age[x] >= 15) {
                    input.nextLine();
                    System.out.print("Enter your phone number : ");
                    phoneNo[x] = input.nextLine();
                    System.out.print("Enter your CNIC : ");
                     CNIC[x] = input.nextLine();
                    System.out.print("Enter your address : ");
                    address[x] = input.nextLine();
                    System.out.print("Enter your password : ");
                    password[x] = input.nextLine();
                    System.out.print("Enter your role : ");
                    role[x] = input.nextLine();
                } else {
                    System.out.println("Your age is invalid for creating account");
                    isCurrentAccountCreated = false;
                }
            }

            if (isCurrentAccountCreated) {
                System.out.println("Your current account is created successfully.");
                System.out.println("********************************");
                System.out.println();
                System.out.println("Welcome " + name[x]);
                System.out.println();
                System.out.println("1,Check your balance ");
                System.out.println("2,Deposit ");
                System.out.println("3,WithDraw ");
                System.out.println("4,Transaction history ");
                System.out.println("5,Money Transfer ");
                System.out.println("6,Exit ");
                System.out.println();
                currentAccounts[x] = new CurrentAccount(
                        name[x], fatherName[x], age[x], phoneNo[x],
                        CNIC[x], address[x], password[x], role[x]
                );
                int count = 0;
                while (true) {
                    System.out.print("Enter your option : ");
                    int givingNumber = input.nextInt();
                    if (givingNumber == 1) {
                        currentAccounts[x].Balance();
                    } else if (givingNumber == 2) {
                        System.out.print("Enter amount you want to deposit : ");
                        amountData[x] = input.nextInt();
                        if(amountData[x]>0){
                            if(count<totalTransaction){
                                currentAccounts[x].deposit(amountData[x]);
                                transactionCurrentAccount[count] =  + amountData[x];
//                                transaction[x][count] = + amountData[x];
                                count++;
                            }
                            else{
                                System.out.println("Your transaction cross limited");
                            }
                        }

                    } else if (givingNumber == 3) {
                        System.out.println("Enter amount you want to withdraw : ");
                        withdrawalAmounts[x] = input.nextInt();
                        if (withdrawalAmounts[x] > 0) {
                            if(count<totalTransaction){
                                currentAccounts[x].WithDraw(withdrawalAmounts[x]);
                                transactionCurrentAccount[count] = - withdrawalAmounts[x];
                             //   transaction[x][count] = - withdrawalAmounts[x];
                                count++;
                            }
                        } else {
                            System.out.println("Negative value amount are not allowed");
                        }
                    }
                    else if (givingNumber == 4) {
                        System.out.println("***********Transaction history*************");
                        System.out.println();
                        System.out.println("Account name : " + name[x]);
                        System.out.println();
                        for(int z = 0;z<totalTransaction;z++){
                            if(transactionCurrentAccount[z]!=0){
                                System.out.println("Transaction - " + (z+1) + " : " + transactionCurrentAccount[z]);
                            }
                        }
                        System.out.println();


                    }
                    else if(givingNumber == 6){
                        System.out.println("*************Money Transfer***************");
                        System.out.println();
                        boolean isPhoneNumberisMatched = false;
                        input.nextLine();   // 0325465655
                        System.out.print("Enter the phone number which you want to transfer : ");
                        String transferNumber = input.nextLine();
                        for(int i = 0;i<totalAccounts;i++){
                            if(transferNumber.equalsIgnoreCase(phoneNo[i])){
                                isPhoneNumberisMatched = true;
                                System.out.print("Enter amount you have to transfer : ");
                                int transferAmount = input.nextInt();
                                if(transferAmount<=savingsAccounts[x].Balance()){
                                    savingsAccounts[x].WithDraw(transferAmount);
                                    System.out.println("************************");
                                    System.out.println("Account name you have transfer : " + name[i]);
                                    currentAccounts[x].deposit(transferAmount);
                                    System.out.println("************************");
                                    // 035242775

                                }

                            }
                        }
                        if(!isPhoneNumberisMatched){
                            System.out.println("The phone number is invaild ");
                        }
                    }
                    else if (givingNumber == 6) {
                        break;
                    }
                }
                System.out.print("You want to make new current account (Yes/No) : ");
                input.nextLine();
                String NewAccount = input.nextLine();
                if(NewAccount.equalsIgnoreCase("Yes")){
                    x++;
                }
            }




        }

    }

    }

