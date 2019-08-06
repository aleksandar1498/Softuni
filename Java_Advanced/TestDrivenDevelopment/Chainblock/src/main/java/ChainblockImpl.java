import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        if (!this.contains(transaction)) {
            this.transactions.put(((TransactionImpl) transaction).getId(),transaction);
        }
    }

    public boolean contains(Transaction transaction) {

        return transactions.values().stream().anyMatch(x -> x.equals(transaction));
    }

    public boolean contains(int id) {
        return this.transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if(!this.transactions.containsKey(id)){
            throw new IllegalArgumentException("Invalid ID");
        }
        if(newStatus == null){
            throw new IllegalArgumentException("Invalid Status");
        }
        ((TransactionImpl)this.getById(id)).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if(this.getById(id) == null){
            throw new IllegalArgumentException("Id not found");
        }
        this.transactions.remove(id);
    }

    public Transaction getById(int id) {
        if(!this.transactions.containsKey(id)){
            throw new IllegalArgumentException("Id not found");
        }
        return this.transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        if(this.transactions.values().stream().noneMatch(x -> ((TransactionImpl)x).getStatus().equals(status))){
            throw new IllegalArgumentException("No transactions found");
        }
        return this.transactions.values().stream().filter(x -> ((TransactionImpl)x).getStatus().equals(status)).sorted((t1,t2) -> Double.compare(((TransactionImpl)t2).getAmount(),((TransactionImpl)t1).getAmount())).collect(Collectors.toList());
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> senders = this.transactions.values().stream().filter(x -> ((TransactionImpl)x).getStatus().equals(status)).sorted((t1,t2) -> Double.compare(((TransactionImpl)t2).getAmount(),((TransactionImpl)t1).getAmount())).map(x -> ((TransactionImpl) x).getFrom()).collect(Collectors.toList());
        if(senders.size() == 0 ){
            throw new IllegalArgumentException("Status does not exists");
        }
        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> receivers = this.transactions.values().stream().filter(x -> ((TransactionImpl)x).getStatus().equals(status)).sorted((t1,t2) -> Double.compare(((TransactionImpl)t2).getAmount(),((TransactionImpl)t1).getAmount())).map(x -> ((TransactionImpl) x).getTo()).collect(Collectors.toList());
        if(receivers.size() == 0 ){
            throw new IllegalArgumentException("Status does not exists");
        }
        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        List<Transaction> results = new ArrayList<>(this.transactions.values());
        return results.stream().sorted(((o1, o2) -> {
            int sort = Double.compare(((TransactionImpl)o2).getAmount(),((TransactionImpl)o1).getAmount());
            if(sort == 0){
                sort = Integer.compare(((TransactionImpl) o1).getId(),((TransactionImpl) o2).getId());
            }
            return sort;
        })).collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> results = this.transactions.values().stream().filter(x -> ((TransactionImpl)x).getFrom().equals(sender)).collect(Collectors.toList());
        if(results.size() == 0){
            throw new IllegalArgumentException("Transactions from this sender are not available");
        }
        return results.stream().sorted(((o1, o2) -> Double.compare(((TransactionImpl)o2).getAmount(),((TransactionImpl)o1).getAmount()))).collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> results = this.transactions.values().stream().filter(x -> ((TransactionImpl)x).getTo().equals(receiver)).collect(Collectors.toList());
        if(results.size() == 0){
            throw new IllegalArgumentException("Transactions from this receiver are not available");
        }
        return results.stream().sorted(((o1, o2) -> {
            int sort = Double.compare(((TransactionImpl)o2).getAmount(),((TransactionImpl)o1).getAmount());
            if(sort == 0){
                sort = Integer.compare(((TransactionImpl) o1).getId(),((TransactionImpl) o2).getId());
            }
            return sort;
        })).collect(Collectors.toList());
    }
    // from HERE
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.transactions.values().stream().filter(t -> ((TransactionImpl)t).getStatus().equals(status) && ((TransactionImpl)t).getAmount() <= amount).sorted((t1,t2) -> Double.compare(((TransactionImpl)t2).getAmount(),((TransactionImpl)t1).getAmount())).collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> results = this.transactions.values().stream().filter(t -> ((TransactionImpl)t).getFrom().equals(sender) && ((TransactionImpl)t).getAmount() > amount).collect(Collectors.toList());
        if(results.size() == 0){
            throw new IllegalArgumentException("");
        }
        return results.stream().sorted((t1,t2) -> Double.compare(((TransactionImpl)t2).getAmount(),((TransactionImpl)t1).getAmount())).collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> results = this.transactions.values().stream().filter(t -> ((TransactionImpl)t).getTo().equals(receiver) && ((TransactionImpl)t).getAmount() >= lo && ((TransactionImpl)t).getAmount() <= hi).collect(Collectors.toList());
        if(results.size() == 0){
            throw new IllegalArgumentException("");
        }
        return results.stream().sorted((t1,t2) ->{
            int sort = Double.compare(((TransactionImpl)t2).getAmount(),((TransactionImpl)t1).getAmount());
            if(sort == 0){
                sort = Integer.compare(((TransactionImpl)t1).getId(),((TransactionImpl)t2).getId());
            }
            return sort;
        }).collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.transactions.values().stream().filter(x ->  ((TransactionImpl)x).getAmount() >= lo && ((TransactionImpl)x).getAmount() <= hi).collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return this.transactions.values().iterator();
    }
}
