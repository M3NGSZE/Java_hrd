import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String red = "\u001B[31m", green = "\u001B[32m", reset = "\u001B[0m", yellow = "\u001B[33m";
        BankService bankService = new BankService();
        Account account = new CheckingAccount();
        Account account2 = new SavingAccount();
        Account[] ac = new Account[2];




//        account = new CheckingAccount(123456789,"cheata","14-10-2007","female","0883833888",100);
//        account2 = new SavingAccount(987654321,"mengse","27-03-2003","male","0979402096",100);

        while (true){
            System.out.println("================== Online Banking System ==================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Display Account Information");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");
            String option = bankService.option();
            switch (option){
                case "1" -> {
                    label:
                    while (true){
                        bankService.checkingSaving("Checking");
                        switch (bankService.option()){
                            case "1" -> {
                                if (bankService.checkingAccountCount){
                                    System.out.println(red + "Checking Account is already created!!!\n" + reset);
                                }else {
                                    account = bankService.createCheckingAccount();
                                }
                            }
                            case "2" -> {
                                if (bankService.savingAccountCount){
                                    System.out.println(red + "Saving Account is already created!!!\n" + reset);
                                }else {
                                    account2 = bankService.createSavingAccount();
                                }
                            }
                            case "3" -> {
                                System.out.println();
                                break label;
                            }
                            default -> System.out.println(red + "Invalid option! Please try again ...\n" + reset);
                        }
                    }
                }
                case "2" -> {
                    label:
                    while (true){
                        bankService.checkingSaving("Deposit");
                        switch (bankService.option()){
                            case "1" -> {
                                if (!bankService.checkingAccountCount){
                                    System.out.println(red + "Checking Account haven't been created yet!!!\n" + reset);
                                }else {
                                    int amount = bankService.verifyMoney("Deposit");
                                    account.deposit(amount);
                                }
                            }
                            case "2" -> {
                                if (!bankService.savingAccountCount){
                                    System.out.println(red + "Saving Account haven't been created yet!!!\n" + reset);
                                }else {
                                    int amount = bankService.verifyMoney("Deposit");
                                    account2.deposit(amount);
                                }
                            }
                            case "3" -> {
                                System.out.println();
                                break label;
                            }
                            default -> System.out.println(red + "Invalid option! Please try again ...\n" + reset);
                        }
                    }
                }
                case "3" -> {
                    label:
                    while (true){
                        bankService.checkingSaving("Withdraw");
                        switch (bankService.option()){
                            case "1" -> {
                                if (!bankService.checkingAccountCount){
                                    System.out.println(red + "Checking Account haven't been created yet!!!\n" + reset);
                                }else {
                                    int amount = bankService.verifyMoney("Withdraw");
                                    account.withdraw(amount);
                                }
                            }
                            case "2" -> {
                                if (!bankService.savingAccountCount){
                                    System.out.println(red + "Saving Account haven't been created yet!!!\n" + reset);
                                }else {
                                    int amount = bankService.verifyMoney("Withdraw");
                                    account2.withdraw(amount);
                                }
                            }
                            case "3" -> {
                                System.out.println();
                                break label;
                            }
                            default -> System.out.println(red + "Invalid option! Please try again ...\n" + reset);
                        }
                    }
                }
                case "4" -> {
                    if ((bankService.checkingAccountCount) && (bankService.savingAccountCount)){
                        label:
                        while (true){
                            System.out.println(yellow + "\n>>>>>>>>>>>>>>>>>>>> Transfer Money <<<<<<<<<<<<<<<<<<<<" + reset);
                            System.out.println("1. Checking Account -> Saving Account");
                            System.out.println("2. Saving Account -> Checking Account");
                            System.out.println("3. Back");
                            System.out.println("==========================================================");
                            switch (bankService.option()){
                                case "1" -> {
                                    int amount = bankService.verifyMoney("Transfer");
                                    account.transfer(amount,account2);
                                }
                                case "2" -> {
                                    int amount = bankService.verifyMoney("Transfer");
                                    account2.transfer(amount,account);
                                }
                                case "3" -> {
                                    System.out.println();
                                    break label;
                                }
                                default -> System.out.println(red + "Invalid option! Please try again ...\n" + reset);
                            }
                        }
                    }else {
                        System.out.println(red + "Checking Account or Saving Account haven't been created yet!!!\n" + reset);
                    }
                }
                case "5" -> {
                    if ((bankService.checkingAccountCount) || (bankService.savingAccountCount)){
                        account.displayAccountInfo();
                        account2.displayAccountInfo();
                    }else {
                        System.out.println(red + "Checking Account or Saving Account haven't been created yet!!!\n" + reset);
                    }
                }
                case "6" -> {
                    if ((bankService.checkingAccountCount) && (bankService.savingAccountCount)){
                        label:
                        while (true){
                            bankService.checkingSaving("Delete");
                            switch (bankService.option()){
                                case "1" -> {
                                    if (!bankService.checkingAccountCount){
                                        System.out.println(red + "Checking Account haven't been created yet!!!\n" + reset);
                                    }else {
                                        if (bankService.confirm().equals("y")){
                                            account = bankService.deleteCheckingAccount(account,account2);
                                            break label;
                                        }else if (bankService.confirm().equals("n")){
                                            break label;
                                        }
                                    }
                                }
                                case "2" -> {
                                    if (!bankService.savingAccountCount){
                                        System.out.println(red + "Saving Account haven't been created yet!!!\n" + reset);
                                    }else {
                                        if (bankService.confirm().equals("y")){
                                            account2 = bankService.deleteSavingAccount(account2,account);
                                        }
                                    }
                                }
                                case "3" -> {
                                    System.out.println();
                                    break label;
                                }
                                default -> System.out.println(red + "Invalid option! Please try again ...\n" + reset);
                            }
                        }
                    }else {
                        System.out.println(red + "At least one account must remain\n" + reset);
                    }

                }
                case "7" -> {
                    System.out.println(green + "\n(^-^) Good Bye! (^-^)" + reset);
                    return;
                }
                default -> System.out.println(red + "Invalid option! Please try again(1-7) ...\n" + reset);
            }
        }
    }
}
