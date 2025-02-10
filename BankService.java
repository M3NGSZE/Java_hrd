import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankService {
    Scanner scanner = new Scanner(System.in);
    String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m",yellow = "\u001B[33m", cyan = "\u001B[36m", purple = "\u001B[35m";
    String[] strDOB;
    int[] intDOB;
    boolean checkingAccountCount = false, savingAccountCount = false;
    int count = 0;


    private void emptyString(){
        System.out.println(red + "Empty string or space won't allow" + reset);
    }

    public String option(){
        while (true){
            System.out.print("=> Choose an option: ");
            String option = scanner.nextLine();
            boolean matches = Pattern.matches("^[1-9a-zA-Z]\\w*$", option);
            if (matches){
                return option;
            }
            emptyString();
        }
    }

    public CheckingAccount createCheckingAccount() {
        System.out.println("\n>>>>>>>>>>>>>>>>>>>> Account Information <<<<<<<<<<<<<<<<<<<<");
        int id = randomID();
        String username = validateUsername();
        String dob = validateDOB();
        String gender = validateGender();
        String phone = validatePhone();
        CheckingAccount checkingAccount = new CheckingAccount(id, username, dob, gender, phone, 0);
        System.out.println("=============================================================");
        System.out.println(green + "Your checking account has been created successfully!" + reset);
        checkingAccountCount = true;

        count++;
        return checkingAccount;
    }


    public CheckingAccount createSavingAccount(){
        System.out.println("\n>>>>>>>>>>>>>>>>>>>> Account Information <<<<<<<<<<<<<<<<<<<<");
        int id = randomID();
        String username = validateUsername();
        String dob = validateDOB();
        String gender = validateGender();
        String phone = validatePhone();
        SavingAccount savingAccount = new SavingAccount(id,username,dob,gender,phone,0);
        System.out.println("=============================================================");
        System.out.println(green + "Your saving account has been created successfully!" + reset);
        savingAccountCount = true;
        return savingAccount;
    }


    private int randomID(){
        Random random = new Random();
        return random.nextInt(999999999);
    }

    public void checkingSaving(String naming){
        System.out.println("\n>>>>>>>>>>>>>>>>>>>> " + naming + " Account <<<<<<<<<<<<<<<<<<<<");
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Back");
        System.out.println("=============================================================");
    }

    private String validateUsername(){
        while (true){
            System.out.print("Enter username: ");
            String name = scanner.nextLine();
            boolean matches = Pattern.matches("^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$", name);
            if (matches){
                return name;
            }
            emptyString();
        }
    }

    private String validateDOB(){
        boolean message = false;
        while (true){
            System.out.print("Enter date of birth (dd-mm-yyyy): ");
            String dob = scanner.nextLine();
            boolean matches = Pattern.matches("^(0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-\\d{4}$", dob);
            if (matches){
                strDOB = dob.split("-");
                intDOB = new int[strDOB.length];
                for (int i =0; i < strDOB.length; i++){
                    intDOB[i] = Integer.parseInt(strDOB[i].trim());
                }
                for (int i = 0; i < intDOB.length; i++){
                    if (((2025 - intDOB[2]) < 16) || ((2025 - intDOB[2]) > 150)){
                        System.out.println(red + "User age must be between 16 and 150" + reset);
                        message = true;
                        break;
                    }else if (intDOB[2] % 4 == 0){
                        if (intDOB[1] == 2){
                            if (intDOB[0] <= 29){
                                return dob;
                            }
                        }else if ((intDOB[1] == 1) || (intDOB[1] == 3) || (intDOB[1] == 5) || (intDOB[1] == 7) || (intDOB[1] == 8) || (intDOB[1] == 10) || (intDOB[1] == 12)){
                            if (intDOB[0] <= 31){
                                return dob;
                            }
                        }else if ((intDOB[1] == 4) || (intDOB[1] == 6) || (intDOB[1] == 9) || (intDOB[1] == 11)){
                            if (intDOB[0] <= 30){
                                return dob;
                            }
                        }
                    }else {
                        if (intDOB[1] == 2){
                            if (intDOB[0] <= 28){
                                return dob;
                            }
                        }
                        else if ((intDOB[1] == 1) || (intDOB[1] == 3) || (intDOB[1] == 5) || (intDOB[1] == 7) || (intDOB[1] == 8) || (intDOB[1] == 10) || (intDOB[1] == 12)){
                            if (intDOB[0] <= 31){
                                return dob;
                            }
                        }else if ((intDOB[1] == 4) || (intDOB[1] == 6) || (intDOB[1] == 9) || (intDOB[1] == 11)){
                            if (intDOB[0] <= 30){
                                return dob;
                            }
                        }
                    }
                }
            }
            if (!message){
                System.out.println(red + "Invalid (dd-mm-yyyy), empty string or space won't allow\n" + reset);
            }
            message = false;
        }
    }

    private String validateGender(){
        while (true){
            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            boolean matches = Pattern.matches("^(?i)(male|female|other|m|f|o)$", gender);
            if (matches){
                return gender;
            }
            emptyString();
        }
    }

    private String validatePhone(){
        while (true){
            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();
            boolean matches = Pattern.matches("^0\\d{8,9}$", phone);
            if (matches){
                return phone;
            }
            emptyString(); //System.out.print(red + "Phone number length can't be greater 10 or smaller 9 and check ");
        }
    }

    public int verifyMoney(String option){
        while (true){
            System.out.print("Enter money to "+option+": ");
            String money = new Scanner(System.in).nextLine();
            boolean matches = Pattern.matches("^\\d+$", money);
            if (matches){
                return Integer.parseInt(money);
            }
            System.out.println(red + "Money can't be letter or space" + reset);

        }
    }

    public String confirm(){
        while (true){
            System.out.print("Are you sure you want to delete this account? (Y/N): ");
            String confirm = new Scanner(System.in).nextLine();
            boolean matches = Pattern.matches("^^[yYnN]$", confirm);
            if (matches){
                return confirm.toLowerCase();
            }
            System.out.println(red + "Wrong input. Please input only yes(y/Y) or no(n/N)." + reset);
        }
    }

    public CheckingAccount deleteCheckingAccount(Account source, Account targetAccount){

        CheckingAccount checkingAccount = (CheckingAccount) source;
        SavingAccount savingAccount = (SavingAccount) targetAccount;

        System.out.println(yellow + "\n>>>>>>>>>>>>>>>>>>>> Checking Account <<<<<<<<<<<<<<<<<<<<" + reset);
        System.out.println("Transferred                   : " + cyan + " \t\t\t$ " + checkingAccount.getBalance() + reset);
        System.out.println("From Checking Account with ID : " + cyan + " \t\t\t"  +  checkingAccount.getAccountNumber() + reset);
        System.out.println("To Saving account with ID     : " + cyan + " \t\t\t"  + savingAccount.getAccountNumber() + reset);
        System.out.println("Total Remain                  : " + cyan + " \t\t\t$ " + "0.0" + reset);
        CheckingAccount checkingAccount1 = new SavingAccount();
        savingAccount.setBalance(savingAccount.getBalance() + checkingAccount.getBalance());
        System.out.println(yellow + "\n\t\t\tSaving Account\n" + reset);
        System.out.println("Received    \t: " + purple + " \t\t\t$" + checkingAccount.getBalance() + reset);
        System.out.println("Total Amount\t: " + purple + " \t\t\t$" +  savingAccount.getBalance() + reset);
        System.out.println("=============================================================");
        checkingAccountCount = false;
        System.out.println(green + "Transferred all balance from Checking account to Saving account." + reset);
        System.out.println(green + "Account deleted successfully" + reset);
        return checkingAccount1;
    }

    public CheckingAccount deleteSavingAccount(Account source, Account targetAccount){
        SavingAccount savingAccount = (SavingAccount) source;
        CheckingAccount checkingAccount = (CheckingAccount) targetAccount;

        System.out.println(yellow + "\n>>>>>>>>>>>>>>>>>>>> Saving Account <<<<<<<<<<<<<<<<<<<<" + reset);
        System.out.println("Transferred                   : " + cyan + " \t\t\t$ " + savingAccount.getBalance() + reset);
        System.out.println("From Checking Account with ID : " + cyan + " \t\t\t"  +  savingAccount.getAccountNumber() + reset);
        System.out.println("To Saving account with ID     : " + cyan + " \t\t\t"  + checkingAccount.getAccountNumber() + reset);
        System.out.println("Total Remain                  : " + cyan + " \t\t\t$ " + "0.0" + reset);
        SavingAccount savingAccount1 =  new SavingAccount();
        checkingAccount.setBalance(savingAccount.getBalance() + checkingAccount.getBalance());
        System.out.println(yellow + "\n\t\t\tChecking Account\n" + reset);
        System.out.println("Received    \t: " + purple + " \t\t\t$" + savingAccount.getBalance() + reset);
        System.out.println("Total Amount\t: " + purple + " \t\t\t$" +  checkingAccount.getBalance() + reset);
        System.out.println("=============================================================");
        savingAccountCount = false;
        System.out.println(green + "Transferred all balance from Saving account to Checking account." + reset);
        System.out.println(green + "Account deleted successfully" + reset);
        return savingAccount1;
    }

}
