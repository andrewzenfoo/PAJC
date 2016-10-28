package it.ing.unibs.pajc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcModel calcolatrice = new CalcModel();
		calcolatrice.pushOperand(6.0);
		calcolatrice.pushOperand(6.0);
		calcolatrice.performOperation("*");
		//calcolatrice.performOperation("-");

	}

}
