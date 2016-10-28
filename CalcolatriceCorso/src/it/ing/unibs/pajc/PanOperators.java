package it.ing.unibs.pajc;

public class PanOperators extends PanOpBase {

	@Override
	void addOperator() {
		for(Character ch:"+-*/".toCharArray())
		{
			addOperator(""+ch);
		}

	}

}