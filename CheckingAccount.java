public class CheckingAccount implements Account{
    public int accountNumber;
    private String username;
    private String dob;
    private String gender;
    private String phone;
    private double balance;
    private int counting = 1;
    String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m", yellow = "\u001B[33m", purple = "\u001B[35m", cyan = "\u001B[36m";
    public CheckingAccount(){

    }

    public CheckingAccount(int accountNumber, String username, String dob, String gender, String phone, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.balance = balance;
        ++counting;
//        System.out.println(++counting);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountNumber=" + accountNumber +
                ", username='" + username + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }

    static boolean check1 = false;

    @Override
    public void deposit(double amount) {
        if (amount <= 0){
            System.out.println(red + "Amount deposit money must be greater than 0" + reset);
        }else {
            double oldBalance = getBalance();
            setBalance(oldBalance + amount);
            System.out.println(yellow + "\n\t\t\tChecking Account\n" + reset);
            System.out.println("Received    \t: " + purple + " \t\t\t$" + amount + reset);
            System.out.println("Total Amount\t: " + purple + " \t\t\t$" + getBalance() + reset);
            System.out.println(green +"\nDeposit successfully"+ reset);
        }
    }

    @Override
    public void withdraw(double amount) {
        if ((amount <= 0) || (amount > getBalance())){
            System.out.println(red + "Amount withdraw money must be greater than 0 and smaller or equal balance and please check your it might be empty" + reset);
        }else {
            double oldBalance = getBalance();
            setBalance(oldBalance - amount);
            System.out.println(yellow + "\n\t\t\tWithdraw Account\n" + reset);
            System.out.println("Withdraw    \t: " + purple + " \t\t\t$" + amount + reset);
            System.out.println("Total Amount\t: " + purple + " \t\t\t$" + getBalance() + reset);
            System.out.println(green +"\nWithdraw successfully"+ reset);
        }
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        if (amount >= getBalance()){
//            System.out.println(red + "Not enough balance for transfer" + reset);
            System.out.println(red + "Amount withdraw money must be greater than 0 and smaller or equal balance and please check your it might be empty" + reset);
        }else {
            setBalance(getBalance() - amount);
            SavingAccount.check = false;
            targetAccount.deposit(amount);
            SavingAccount savingAccount = (SavingAccount) targetAccount;
            System.out.println(yellow + "\n>>>>>>>>>>>>>>>>>>>> Checking Account <<<<<<<<<<<<<<<<<<<<" + reset);
            System.out.println("Transferred                   : " + cyan + " \t\t\t$ " + amount + reset);
            System.out.println("From Checking Account with ID : " + cyan + " \t\t\t"  +  getAccountNumber() + reset);
            System.out.println("To Saving account with ID     : " + cyan + " \t\t\t"  + savingAccount.getAccountNumber() + reset);
            System.out.println("Total Remain                  : " + cyan + " \t\t\t$ " + getBalance() + reset);
            System.out.println("=============================================================");
            System.out.println(green +"Transfer successfully"+ reset);
        }
    }



    @Override
    public void displayAccountInfo() {
        if (counting == 0){
            System.out.println(red + "No account haven't been register yet\n" + reset);
        }else {
            if (accountNumber != 0){
                System.out.println(yellow + "\n>>>>>>>>>>>>>>>>>>>> Checking Account <<<<<<<<<<<<<<<<<<<<" + reset);
                System.out.println("Account Type   \t: "+  "\t\t\t" + green +  "Checking Account" + reset);
                System.out.println("Account Number \t: " + "\t\t\t" + green + accountNumber + reset);
                System.out.println("User Name      \t: " + "\t\t\t" + green + username + reset);
                System.out.println("Date of Birth  \t: " + "\t\t\t" + green + dob + reset);
                System.out.println("Gender         \t: " + "\t\t\t" + green + gender + reset);
                System.out.println("Phone Number   \t: " + "\t\t\t" + green + phone + reset);
                System.out.println("Balance        \t: " + "\t\t\t" + green + balance + " $" + reset);
                System.out.println("=============================================================\n");
            }
        }
    }
}
