public class TestingInheritanceProcess {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(123456789,"cheata","14-10-2007","female","0883833888",100);
        CheckingAccount checkingAccount = new CheckingAccount();
        System.out.println(checkingAccount);
        System.out.println(checkingAccount.getGender());

        SavingAccount savingAccount = new SavingAccount(123456789,"mengse","27-03-2003","male","0979402096",200);
//        SavingAccount savingAccount = new SavingAccount(123456789,"mengse","27-03-2003","male","0979402096",200);
        System.out.println(savingAccount);
        System.out.println(savingAccount.getGender());
    }
}
