public class TransactionImpl implements Comparable<TransactionImpl>,Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setStatus(TransactionStatus status){
        this.status = status;
    }
    public int compareTo(TransactionImpl o) {
        return Integer.compare(this.getId(),o.getId());
    }
}
