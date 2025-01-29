package com.projeto.avabank.Exceptions;

public class CpfExistException extends Exception {
	
public CpfExistException() {
    super("CPF já existente no sistema.");
}

public CpfExistException(String message) {
    super(message);
}
}