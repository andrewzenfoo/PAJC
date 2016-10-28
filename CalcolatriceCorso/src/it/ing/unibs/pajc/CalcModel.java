package it.ing.unibs.pajc;

import java.util.HashMap;
import java.util.Stack;

public class CalcModel {
	private class CalculatorElement {
		final String name;
		final BaseOperator operator;
		final Double value;
		final boolean isOperator;
		
		public CalculatorElement(Double value) {
			this.value = value;
			this.isOperator = false;
			this.name = null;
			this.operator = null;
		}
		
		public CalculatorElement(String name, BaseOperator operator) {
			this.name = name;
			this.operator = operator;
			this.value = null;
			this.isOperator = true;
		}
	}
	
	Stack<CalculatorElement> calcStack = new Stack<>();
	HashMap<String, CalculatorElement> knownOperators = new HashMap<>();
	
	void addKnownOperator(String name, BinaryOperator operator) {
		knownOperators.put(name, 
				new CalculatorElement(name, operator));
	}
	
	
	void addKnownOperator(String name, UnaryOperator operator) {
		knownOperators.put(name,  
				new CalculatorElement(name, operator));
	}
	
	public CalcModel() {
		addKnownOperator("+", (a, b) -> a+b);
		addKnownOperator("-", (a, b) -> a-b);
		addKnownOperator("*", (a, b) -> a*b);
		addKnownOperator("/", (a, b) -> b/a);

		addKnownOperator("\u221A", Math::sqrt); 
	
	}
	
	public Double pushOperand(Double op) {
		calcStack.add(new CalculatorElement(op));
		return evaluate();
	}
	
	public Double performOperation(String op) {
		switch (op) {
		case "CA": calcStack.clear();
			break;
		case "CL": if(calcStack.size() > 0)
					calcStack.pop();
			break;
		
		default: //known operator
			if(knownOperators.containsKey(op))
				calcStack.push(knownOperators.get(op));
		}
		
		return calcStack.size() > 0 ? evaluate() : 0.;

	}
	
	private class EvaluateResult {
		Double result;
		Stack<CalculatorElement> remainingElements;
		
		public EvaluateResult(Double result, Stack<CalculatorElement> remainingElements) {
			this.result = result;
			this.remainingElements = remainingElements;
			System.out.println(this.result);
		}
	}
	
	public Double evaluate() {
		return evaluate(
				(Stack<CalculatorElement>) calcStack
				.clone())
				.result;
	}
	
	private EvaluateResult evaluate(Stack<CalculatorElement>
			opStack) {
		
		if(opStack.isEmpty())
			return new EvaluateResult(0., opStack);
		
		Stack<CalculatorElement> wStack = 
				(Stack<CalculatorElement>) opStack.clone();
		
		CalculatorElement op = wStack.pop();
		
		if(!op.isOperator) {
			return new EvaluateResult(op.value, wStack);
		} 
		else if(op.operator instanceof UnaryOperator) {
			EvaluateResult opEval = evaluate(wStack);
			if(opEval.result != null) {
				return new EvaluateResult(
						((UnaryOperator)op.operator).eval(opEval.result),
						opEval.remainingElements);
			}
		} else if(op.operator instanceof BinaryOperator) {
			EvaluateResult opEval1 = evaluate(wStack);
			wStack.pop();
			EvaluateResult opEval2 = evaluate(wStack);
			if(opEval1.result != null && opEval2.result != null) {
				return new EvaluateResult(
						((BinaryOperator)op.operator).eval(opEval1.result, opEval2.result), opEval2.remainingElements);
			}
		}
		
		return null;
		
	}
}
