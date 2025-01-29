package com.projeto.avabank.Exceptions;

public class  InsufficientBalanceException extends Exception {
	public InsufficientBalanceException() {
	    super("Saldo Insuficiente.");
}
	public InsufficientBalanceException(String message) {
	    super(message);
	}
}