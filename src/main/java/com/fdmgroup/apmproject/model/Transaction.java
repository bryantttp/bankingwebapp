package com.fdmgroup.apmproject.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * This class represents a transaction in the banking system.
 *
 * @author 
 * @version 1.0
 * @since 2024-04-22
 */
@Entity
@Table(name = "listOfTransactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Transaction ID")
	private long transactionId;
	
	@Column(name = "Transaction Date")
	private LocalDateTime transactionDate;
	
	@Column(name = "Transaction Type")
	private String transactionType;
	
	@Column(name = "Transaction Amount")
	private double transactionAmount;
	
	@Column(name = "Recipient Account Number")
	private String recipientAccountNumber;
	
	@Column(name = "Cashback")
	private double cashback;
	
	@Column(name = "Description")
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "FK Credit Card ID")
	private CreditCard transactionCreditCard;

	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "FK Account ID")
	private Account transactionAccount;
	
	//example
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "FK recipientAccount ID")
	private Account recipientAccount;

	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "FK Merchant Category Code ID")
	private MerchantCategoryCode transactionMerchantCategoryCode;

	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "FK Foreign Exchange Currency ID")
	private ForeignExchangeCurrency transactionCurrency;
	
	/**
     * Constructs a new Transaction object with the specified details.
     */
	public Transaction() {
		
	};
	
	/**
     * Constructs a new Transaction object with the specified details.
     *
     * @param transactionDate              The date of the transaction.
     * @param transactionType              The type of transaction.
     * @param transactionAmount            The amount of the transaction.
     * @param recipientAccountNumber       The account number of the recipient.
     * @param cashback                     The amount of cashback earned on the transaction.
     * @param transactionCreditCard         The credit card used for the transaction.
     * @param transactionAccount           The account used for the transaction.
     * @param transactionMerchantCategoryCode The merchant category code for the transaction.
     * @param transactionCurrency           The currency used for the transaction.
     */
	public Transaction(LocalDateTime transactionDate, String transactionType,
			double transactionAmount, String recipientAccountNumber, double cashback, CreditCard transactionCreditCard,
			Account transactionAccount, MerchantCategoryCode mcc,
			ForeignExchangeCurrency transactionCurrency) {
		setTransactionDate(transactionDate);
		setTransactionType(transactionType);
		setTransactionAmount(transactionAmount);
		setRecipientAccountNumber(recipientAccountNumber);
		setCashback(cashback);
		setTransactionCreditCard(transactionCreditCard);
		setTransactionAccount(transactionAccount);
		setTransactionMerchantCategoryCode(mcc);
		setTransactionCurrency(transactionCurrency);
	}
	
	/**
     * Constructs a new Transaction object with the specified details.
     *
     * @param transactionType              The type of transaction.
     * @param transactionAmount            The amount of the transaction.
     * @param recipientAccountNumber       The account number of the recipient.
     * @param cashback                     The amount of cashback earned on the transaction.
     * @param transactionCreditCard         The credit card used for the transaction.
     * @param transactionAccount           The account used for the transaction.
     * @param transactionMerchantCategoryCode The merchant category code for the transaction.
     * @param transactionCurrency           The currency used for the transaction.
     */
	public Transaction(String transactionType,
			double transactionAmount, String recipientAccountNumber, double cashback, CreditCard transactionCreditCard,
			Account transactionAccount, MerchantCategoryCode mcc,
			ForeignExchangeCurrency transactionCurrency) {
		setTransactionDate(LocalDateTime.now());
		setTransactionType(transactionType);
		setTransactionAmount(transactionAmount);
		setRecipientAccountNumber(recipientAccountNumber);
		setCashback(cashback);
		setTransactionCreditCard(transactionCreditCard);
		setTransactionAccount(transactionAccount);
		setTransactionMerchantCategoryCode(mcc);
		setTransactionCurrency(transactionCurrency);
	}
	//record transaction for bank accounts - no cashback or rewards
	public Transaction(String transactionType, Account transactionAccount, double transactionAmount,String recipientAccountNumber, ForeignExchangeCurrency transactionCurrency, String transactionDescription
			) {
		setTransactionDate(LocalDateTime.now());
		
		setTransactionType(transactionType);
		
		setTransactionAccount(transactionAccount);
		
		setTransactionAmount(transactionAmount);
		
		setRecipientAccountNumber(recipientAccountNumber);
		
		setTransactionCurrency(transactionCurrency);
		
		setDescription(transactionDescription);
	}

	public Transaction(String transactionType, Account transactionAccount,Account recipientAccount, double transactionAmount,String recipientAccountNumber, ForeignExchangeCurrency transactionCurrency, String transactionDescription
			) {
		setTransactionDate(LocalDateTime.now());
		
		setTransactionType(transactionType);
		
		setTransactionAccount(transactionAccount);
		
		setTransactionAmount(transactionAmount);
		
		setRecipientAccountNumber(recipientAccountNumber);
		
		setTransactionCurrency(transactionCurrency);
		
		setRecipientAccount(recipientAccount);
		
		setDescription(transactionDescription);
	}
	
	
	
	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public String getRecipientAccountNumber() {
		return recipientAccountNumber;
	}

	public void setRecipientAccountNumber(String recipientAccountNumber) {
		this.recipientAccountNumber = recipientAccountNumber;
	}
	
	public double getCashback() {
		return cashback;
	}

	public void setCashback(double cashback) {
		this.cashback = cashback;
	}
	
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public CreditCard getTransactionCreditCard() {
		return transactionCreditCard;
	}

	public void setTransactionCreditCard(CreditCard transactionCreditCard) {
		this.transactionCreditCard = transactionCreditCard;
	}

	public Account getTransactionAccount() {
		return transactionAccount;
	}

	public void setTransactionAccount(Account transactionAccount) {
		this.transactionAccount = transactionAccount;
	}

	public ForeignExchangeCurrency getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(ForeignExchangeCurrency transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}


	public MerchantCategoryCode getTransactionMerchantCategoryCode() {
		return transactionMerchantCategoryCode;
	}

	public void setTransactionMerchantCategoryCode(MerchantCategoryCode transactionMerchantCategoryCode) {
		this.transactionMerchantCategoryCode = transactionMerchantCategoryCode;
	}
	
	public Account getRecipientAccount() {
		return recipientAccount;
	}

	public void setRecipientAccount(Account recipientAccount) {
		this.recipientAccount = recipientAccount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCreditCardDescription(String text, double rate) {
		BigDecimal value = new BigDecimal(this.transactionAmount / rate);
		DecimalFormat df = new DecimalFormat("#.##");
		String formattedString = df.format(value);
		String finalDescription = text + " " + this.getTransactionCurrency().getCode() + " " + formattedString;
		setDescription(finalDescription);
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionType=" + transactionType + ", transactionAmount=" + transactionAmount
				+ ", recipientAccountNumber=" + recipientAccountNumber + ", cashback=" + cashback
				;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cashback, recipientAccountNumber, transactionAmount, transactionCurrency, transactionDate,
				transactionId, transactionMerchantCategoryCode, transactionType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Double.doubleToLongBits(cashback) == Double.doubleToLongBits(other.cashback)
				&& Objects.equals(recipientAccountNumber, other.recipientAccountNumber)
				&& Double.doubleToLongBits(transactionAmount) == Double.doubleToLongBits(other.transactionAmount)
				&& Objects.equals(transactionCurrency, other.transactionCurrency)
				&& Objects.equals(transactionDate, other.transactionDate) && transactionId == other.transactionId
				&& Objects.equals(transactionMerchantCategoryCode, other.transactionMerchantCategoryCode)
				&& Objects.equals(transactionType, other.transactionType);
	}
	
	
	
	
	
	
}
