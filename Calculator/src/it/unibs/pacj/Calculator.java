package it.unibs.pacj;

public class Calculator {
	
	private double num1;
	private double num2;
	private String operation;
	private double result;
	
	public Calculator() {
	}
	
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public double getResult() {
		
		switch (this.operation) {
		case "+": this.result = this.num1 + this.num2;
		break;
		case "-": this.result = this.num1 - this.num2;
		break;
		case "*": this.result = this.num1 * this.num2;
		break;
		case "/": this.result = this.num1 / this.num2;
		break;
		}
		
		return this.result;
	}

	
	
	
}
