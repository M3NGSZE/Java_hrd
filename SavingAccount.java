import java.net.http.HttpResponse;
import java.security.spec.RSAOtherPrimeInfo;

public class SavingAccount extends CheckingAccount implements Account{
    private  final double rate = 0.05;
    private int count = 1;

    String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m", cyan = "\u001B[36m", purple = "\u001B[35m";

    public SavingAccount(int accountNumber, String username, String dob, String gender, String phone, double balance) {
        super(accountNumber,username, dob, gender, phone,balance);
        count++;
    }

    public SavingAccount(){

    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountNumber=" + super.getAccountNumber() +
                ", username='" + super.getUsername() + '\'' +
                ", dob='" + super.getDob() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                ", balance=" + super.getBalance() +
                ", rate=" + rate +
                '}';
    }

    static boolean check = true;

    @Override
    public void deposit(double amount) {
        if (check){
            if (amount <= 0){
                System.out.println(red + "Amount deposit money must be greater than 0" + reset);
            }else {
                double oldBalance = getBalance();
                if (amount >= 200){
                    setBalance((oldBalance + amount) + (amount * rate));
                }else {
                    setBalance(oldBalance + amount);
                }
                System.out.println(yellow + "\n\t\t\tSaving Account\n" + reset);
                System.out.println("Received    \t: " + purple + " \t\t\t$" + amount + reset);
                System.out.println("Total Amount\t: " + purple + " \t\t\t$" + getBalance() + reset);
                System.out.println(green +"\nDeposit successful"+ reset);
            }
        }else {
            if (amount <= 0){
                System.out.println(red + "Amount deposit money must be greater than 0" + reset);
            }else {
                double oldBalance = getBalance();
                if (amount >= 200){
                    setBalance((oldBalance + amount) + (amount * rate));
                }else {
                    setBalance(oldBalance + amount);
                }
            }
        }

    }


    @Override
    public void withdraw(double amount) {
        if ((amount <= 0) || (amount > getBalance())){
            System.out.println(red + "Amount withdraw money must be greater than 0 and smaller or equal balance and please check your it might be empty" + reset);
        }else {
            if (amount >= (0.8 * getBalance())){
                System.out.println(red + "Cannot transfer $" + amount + " At least $" + (getBalance() - (0.8 * getBalance())) + " must remain in the account." + reset);
            }else {
                double oldBalance = getBalance();
                setBalance(oldBalance - amount);
                System.out.println(yellow + "\n\t\t\tWithdraw Account\n" + reset);
                System.out.println("Withdraw    \t: " + purple + " \t\t\t$" + amount + reset);
                System.out.println("Total Amount\t: " + purple + " \t\t\t$" + getBalance() + reset);
                System.out.println(green +"\nWithdraw successful"+ reset);
            }

        }
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        if (amount >= getBalance()){
//            System.out.println(red + "Not enough balance for transfer" + reset);
            System.out.println(red + "Amount withdraw money must be greater than 0 and smaller or equal balance and please check your it might be empty" + reset);
        }else {
            if (amount >= (0.8 * getBalance())){
                System.out.println(red + "Cannot transfer $" + amount + " At least $" + (getBalance() - (0.8 * getBalance())) + " must remain in the account." + reset);
            }else {
                setBalance(getBalance() - amount);
                CheckingAccount.check1 = false;
                targetAccount.deposit(amount);
                CheckingAccount checkingAccount = (CheckingAccount) targetAccount;
                System.out.println(yellow + "\n>>>>>>>>>>>>>>>>>>>> Checking Account <<<<<<<<<<<<<<<<<<<<" + reset);
                System.out.println("Transferred                   : " + cyan + " \t\t\t$ " + amount + reset);
                System.out.println("From Checking Account with ID : " + cyan + " \t\t\t"  +  getAccountNumber() + reset);
                System.out.println("To Saving account with ID     : " + cyan + " \t\t\t"  + checkingAccount.getAccountNumber() + reset);
                System.out.println("Total Remain                  : " + cyan + " \t\t\t$ " + getBalance() + reset);
                System.out.println("=============================================================");
                System.out.println(green +"Transfer successful"+ reset);
            }
        }
    }

    @Override
    public void displayAccountInfo() {
        if (count == 0){
            System.out.println(red + "No account haven't been register yet\n" + reset);
        }else {
            if (getAccountNumber() != 0){
                System.out.println(yellow + ">>>>>>>>>>>>>>>>>>>> Saving Account <<<<<<<<<<<<<<<<<<<<" + reset);
                System.out.println("Account Type   \t: "+  "\t\t\t" + green +  "Saving Account" + reset);
                System.out.println("Account Number \t: " + "\t\t\t" + green + super.getAccountNumber() + reset);
                System.out.println("User Name      \t: " + "\t\t\t" + green + super.getUsername() + reset);
                System.out.println("Date of Birth  \t: " + "\t\t\t" + green + super.getDob() + reset);
                System.out.println("Gender         \t: " + "\t\t\t" + green + super.getGender() + reset);
                System.out.println("Phone Number   \t: " + "\t\t\t" + green + super.getPhone() + reset);
                System.out.println("Balance        \t: " + "\t\t\t" + green + super.getBalance() + " $" + reset);
                System.out.println("=============================================================\n");
            }
        }
    }
}
