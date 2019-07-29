class BankAccount{
    private static final double INTEREST_RATE_DEFAULT_VALUE=0.02;
    static int countAccounts=1;
    private int id;
    private double balance;
    private static double interestRate=INTEREST_RATE_DEFAULT_VALUE;
    public BankAccount(){
        this.id=countAccounts;
        System.out.println("Account ID"+id+" created");
        countAccounts++;
    }
    public static void setInterestRate(double interest){
        BankAccount.interestRate=interest;
    }
    public Double getInterest(int years){
        return BankAccount.interestRate*years*this.balance;
    }
    public int getId(){
        return this.id;
    }
    public void deposit(Double amount){
        this.balance+=amount;
    }
    
    
}