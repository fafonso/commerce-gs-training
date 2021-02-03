package com.liferay.commerce.payment.method.redsys.constants;
/**
 * 
 * @author Roselaine Marques
 * 
 * Implemented only Authorization at this moment.
 *
 */
public enum RedsysTypeOfTransaction {
	
	T0("0");
	/**
	 * TODO
	T1("1"),
	T2("2"),
	T3("3"),
	T5("5"),
	T6("6"),
	T7("7"),
	T8("8"),
	T9("9"),
	TO("O"),
	TP("P"),
	TQ("Q"),
	TR("R"),
	TS("S");
	*/
	
	private RedsysTypeOfTransaction(String transaction) {
		_transaction = transaction;
	}
	
	public String getTypeOfTransaction() {
		return _transaction;
	}
	
	private String _transaction;
	
}
