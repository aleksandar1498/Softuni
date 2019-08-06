import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock chainblock;

    @Before
    public void init() {
        this.chainblock = new ChainblockImpl();
    }

    @Test
    public void getCountShouldReturnZeroIfTheCollectionIsEmpty() {
        assertEquals(0, chainblock.getCount());
    }

    @Test
    public void getCountShouldReturnTenIfTheCollectionContainsTenElements() {
        for (Transaction buildTransaction : buildTransactions(10)) {
            this.chainblock.add(buildTransaction);
        }
        assertEquals(10, chainblock.getCount());
    }

    @Test
    public void addShouldBeSuccessfulIfThereAreNotOtherTransactionsWithTheSameId() {
        this.chainblock.add(buildTransactions(1).get(0));
        assertEquals(1, this.chainblock.getCount());
    }

    @Test
    public void addShouldFailIfThereAreOtherTransactionsWithTheSameId() {
        this.chainblock.add(buildTransactions(1).get(0));
        this.chainblock.add(buildTransactions(1).get(0));
        assertEquals(1, this.chainblock.getCount());
    }

    @Test
    public void containsByIdShouldReturnTrueIfTheTransactionExists() {
        this.chainblock.add(buildTransactions(1).get(0));
        assertTrue(this.chainblock.contains(1));
    }

    @Test
    public void containsByIdShouldReturnFalseIfTheTransactionDoesNotExists() {
        assertFalse(this.chainblock.contains(1));
    }

    @Test
    public void containsByTransactionShouldReturnTrueIfTheTransactionExists() {
        Transaction transaction = buildTransactions(1).get(0);
        this.chainblock.add(transaction);
        assertTrue(this.chainblock.contains(transaction));
    }

    @Test
    public void containsByTransactionShouldReturnFalseIfTheTransactionDoesNotExists() {
        Transaction transaction = buildTransactions(1).get(0);
        assertFalse(this.chainblock.contains(transaction));
    }


    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowExpectedIfTheIdIsNotValid() {
        Transaction transaction = buildTransactions(1).get(0);
        this.chainblock.add(transaction);
        this.chainblock.changeTransactionStatus(2, TransactionStatus.ABORTED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowExpectedIfTheStatusIsNotValid() {
        Transaction transaction = buildTransactions(1).get(0);
        this.chainblock.add(transaction);
        TransactionStatus transactionStatus = null;
        this.chainblock.changeTransactionStatus(1, transactionStatus);
    }

    @Test
    public void changeTransactionStatusShouldEffectivelyChangeTheStatusOfTheTransaction() {
        Transaction transaction = buildTransactions(1).get(0);
        this.chainblock.add(transaction);
        this.chainblock.changeTransactionStatus(1, TransactionStatus.SUCCESSFUL);
        assertEquals(TransactionStatus.SUCCESSFUL, ((TransactionImpl) this.chainblock.getById(1)).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIdShouldThrowExpectedIfTheIdDoesNotExists() {
        this.chainblock.removeTransactionById(2);
    }

    @Test
    public void removeTransactionByIdShouldDecreaseTheCountOfElements() {
        Transaction transaction = buildTransactions(1).get(0);
        this.chainblock.add(transaction);
        this.chainblock.removeTransactionById(1);
        assertEquals(0, this.chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByIdShouldThrowExpectedIfIdDoesNotExist() {
        this.chainblock.getById(2);
    }

    @Test
    public void getByIdShouldReturnTheCorrectTransactionById() {
        Transaction transaction = buildTransactions(1).get(0);
        this.chainblock.add(transaction);
        Transaction transaction1 = this.chainblock.getById(1);
        assertEquals(transaction, transaction1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldThrowExpectedIfThereAreNoResults() {
        this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void getByTransactionStatusShouldReturnAnDescendOrderedIterable() {
        boolean descendingOrdered = true;
        this.chainblock.add(new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "X", "Y", 1));
        this.chainblock.add(new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "X", "Y", 3));
        this.chainblock.add(new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "X", "Y", 2));

        Iterable<Transaction> results = this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        Transaction[] transactions = StreamSupport.stream(results.spliterator(), false).toArray(Transaction[]::new);
        for (int i = 0; i < transactions.length - 1; i++) {
            if (((TransactionImpl) transactions[i]).getAmount() < ((TransactionImpl) transactions[i + 1]).getAmount()) {
                descendingOrdered = false;
                break;
            }
        }
        assertTrue(descendingOrdered);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowExpectedIfThereAreNotSendersWIthThisStatus() {
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllSendersWithTransactionStatusShouldReturnTheNameOfAllTheSendersInDescendingOrderByAmount() {
        this.chainblock.add(new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "X", "Y", 1));
        this.chainblock.add(new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Z", "Y", 3));
        this.chainblock.add(new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "K", "Y", 2));
        Iterable<String> results = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        System.out.println(results.toString().replaceAll("[\\[\\], ]", ""));
        assertEquals("ZKX", results.toString().replaceAll("[\\[\\], ]", ""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowExpectedIfThereAreNotSendersWIthThisStatus() {
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllReceiversWithTransactionStatusShouldReturnTheNameOfAllTheSendersInDescendingOrderByAmount() {
        this.chainblock.add(new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "X", "A", 1));
        this.chainblock.add(new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Z", "B", 3));
        this.chainblock.add(new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "K", "C", 2));
        Iterable<String> results = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        System.out.println(results.toString().replaceAll("[\\[\\], ]", ""));
        assertEquals("BCA", results.toString().replaceAll("[\\[\\], ]", ""));
    }

    @Test
    public void getAllOrderedByAmountDescendingThenByIdShouldReturnAllTheTransactionOrderedCorrectly() {
        this.chainblock.add(new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "X", "A", 1));
        this.chainblock.add(new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "X", "B", 2));
        this.chainblock.add(new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "K", "B", 2));
        Iterable<Transaction> results = this.chainblock.getAllOrderedByAmountDescendingThenById();
        boolean orderedCorrectly = true;
        Transaction[] transactions = StreamSupport.stream(results.spliterator(), false).toArray(Transaction[]::new);
        for (int i = 0; i < transactions.length - 1; i++) {
            if (((TransactionImpl) transactions[i]).getAmount() < ((TransactionImpl) transactions[i + 1]).getAmount()) {
                orderedCorrectly = false;
                break;
            } else if (((TransactionImpl) transactions[i]).getAmount() == ((TransactionImpl) transactions[i + 1]).getAmount()) {
                if (((TransactionImpl) transactions[i]).getTo().compareTo(((TransactionImpl) transactions[i + 1]).getTo()) < 0) {
                    orderedCorrectly = false;
                }
            }
        }
        assertTrue(orderedCorrectly);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByAmountDescendingShouldThrowExpectedIfTheSenderDoesNotExists() {
        this.chainblock.getBySenderOrderedByAmountDescending("sash");
    }

    @Test
    public void getBySenderOrderedByAmountDescendingShouldReturnAllTransactionsCorrectly() {
        this.chainblock.add(new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "X", "A", 1));
        this.chainblock.add(new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "X", "B", 3));
        this.chainblock.add(new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "K", "C", 2));
        Iterable<Transaction> results = this.chainblock.getBySenderOrderedByAmountDescending("X");
        boolean descendingOrdered = true;
        Transaction[] transactions = StreamSupport.stream(results.spliterator(), false).toArray(Transaction[]::new);
        for (int i = 0; i < transactions.length - 1; i++) {
            if (((TransactionImpl) transactions[i]).getAmount() < ((TransactionImpl) transactions[i + 1]).getAmount()) {
                descendingOrdered = false;
                break;
            }
        }
        assertTrue(descendingOrdered);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByIdShouldThrowExpectedIfTheSenderDoesNotExists() {
        this.chainblock.getByReceiverOrderedByAmountThenById("sash");
    }

    @Test
    public void getByReceiverOrderedByAmountThenById() {
        this.chainblock.add(new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "X", "A", 1));
        this.chainblock.add(new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "X", "B", 2));
        this.chainblock.add(new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "K", "B", 2));
        Iterable<Transaction> results = this.chainblock.getByReceiverOrderedByAmountThenById("B");
        boolean orderedCorrectly = true;
        Transaction[] transactions = StreamSupport.stream(results.spliterator(), false).toArray(Transaction[]::new);
        for (int i = 0; i < transactions.length - 1; i++) {
            if (((TransactionImpl) transactions[i]).getAmount() < ((TransactionImpl) transactions[i + 1]).getAmount()) {
                orderedCorrectly = false;
                break;
            } else if (((TransactionImpl) transactions[i]).getAmount() == ((TransactionImpl) transactions[i + 1]).getAmount()) {
                if (((TransactionImpl) transactions[i]).getTo().compareTo(((TransactionImpl) transactions[i + 1]).getTo()) < 0) {
                    orderedCorrectly = false;
                }
            }
        }
        assertTrue(orderedCorrectly);
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionIfNoneOfTheTransactionsSatisfiesTheCondition() {
        Transaction[] actual = StreamSupport.stream(this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.ABORTED, 19.00).spliterator(), false).toArray(Transaction[]::new);
        Transaction[] expected = new Transaction[0];
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnTheCorrectIterable() {
        this.chainblock.add(new TransactionImpl(1, TransactionStatus.ABORTED, "X", "A", 1));
        this.chainblock.add(new TransactionImpl(2, TransactionStatus.ABORTED, "X", "B", 2));
        this.chainblock.add(new TransactionImpl(3, TransactionStatus.ABORTED, "K", "B", 212));
        Transaction[] actual = StreamSupport.stream(this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.ABORTED, 19.00).spliterator(), false).toArray(Transaction[]::new);
        int[] expected = new int[]{2, 1};
        int[] actualIds = Arrays.stream(actual).mapToInt(x -> ((TransactionImpl) x).getId()).toArray();
        Assert.assertArrayEquals(expected, actualIds);

    }


    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowExpectedIfNoSuchTransactionsAreFound() {
        this.chainblock.getBySenderAndMinimumAmountDescending("Alex", 10);
    }

    @Test
    public void getBySenderAndMinimumAmountDescendingShouldReturnTheTransactionsThatSatisfiesTheCondition() {
        this.chainblock.add(new TransactionImpl(1, TransactionStatus.ABORTED, "X", "A", 1));
        this.chainblock.add(new TransactionImpl(2, TransactionStatus.ABORTED, "X", "B", 2));
        this.chainblock.add(new TransactionImpl(3, TransactionStatus.ABORTED, "K", "B", 212));
        this.chainblock.add(new TransactionImpl(4, TransactionStatus.ABORTED, "K", "B", 215));
        int[] actual = StreamSupport.stream(this.chainblock.getBySenderAndMinimumAmountDescending("K", 209).spliterator(), false).mapToInt(x -> ((TransactionImpl) x).getId()).toArray();
        int[] expected = new int[]{4, 3};
        Assert.assertArrayEquals(actual, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowExpectedIfNoSuchTransactionsAreFound() {
        this.chainblock.getByReceiverAndAmountRange("Alex", 10, 23);
    }

    @Test
    public void getByReceiverAndAmountRangeShouldReturnTheTransactionsThatSatisfiesTheCondition() {
        this.chainblock.add(new TransactionImpl(1, TransactionStatus.ABORTED, "X", "A", 1));
        this.chainblock.add(new TransactionImpl(2, TransactionStatus.ABORTED, "X", "B", 2));
        this.chainblock.add(new TransactionImpl(4, TransactionStatus.ABORTED, "K", "B", 212));
        this.chainblock.add(new TransactionImpl(3, TransactionStatus.ABORTED, "K", "B", 212));
        int[] actual = StreamSupport.stream(this.chainblock.getByReceiverAndAmountRange("B", 200, 230).spliterator(), false).mapToInt(x -> ((TransactionImpl) x).getId()).toArray();
        int[] expected = new int[]{3, 4};
        Assert.assertArrayEquals(actual, expected);
    }

    @Test
    public void getAllInAmountRangeShouldReturnAnEmptyCollectionIfNoSuchTransactionAreFound() {
        this.chainblock.getAllInAmountRange(10, 12);
    }

    @Test
    public void getAllInAmountRangeShouldReturnOnlyTheTransactionsWhoseAmountIsInTheRange() {
        this.chainblock.add(new TransactionImpl(1, TransactionStatus.ABORTED, "X", "A", 1));
        this.chainblock.add(new TransactionImpl(2, TransactionStatus.ABORTED, "X", "B", 2));
        this.chainblock.add(new TransactionImpl(3, TransactionStatus.ABORTED, "K", "B", 212));
        this.chainblock.add(new TransactionImpl(4, TransactionStatus.ABORTED, "K", "B", 212));
        int[] actual = StreamSupport.stream(this.chainblock.getAllInAmountRange(200, 230).spliterator(), false).mapToInt(x -> ((TransactionImpl) x).getId()).toArray();
        int[] expected = new int[]{3, 4};
        Assert.assertArrayEquals(actual, expected);
    }


    private List<Transaction> buildTransactions(int n) {
        List<Transaction> transactions = new ArrayList<>();
        int index = 1;
        for (int i = 0; i < n; i++) {
            TransactionStatus[] transactionStatuses = TransactionStatus.values();
            Random random = new Random();
            transactions.add(new TransactionImpl(index, transactionStatuses[random.nextInt(transactionStatuses.length)], "Alex", "ToThere", i * n * 1.23));
            index++;
        }
        return transactions;
    }
}