package com.calculator.models;

public class Calculator {
	
	private Double operandOne;
	private String operator;
	private Double operandTwo;
	private Double solution;
	
	public Calculator() {
		this.operandOne = null;
		this.operator = null;
		this.operandTwo = null;
		this.solution = null;
	}
	
	public void setOperandOne(double num1) {
		operandOne = num1; 
	}
	
	public void setOperator(String op) {
		operator = op;
	}
	
	public void setOperandTwo(double num2) {
		operandTwo = num2;
	}
	
	public void performOperation() {
		
		if (operator.equals("+")) {
			solution = operandOne + operandTwo;
		}
		
		if (operator.equals("-")) {
			solution = operandOne - operandTwo; 
		}
	}
	
	public Double getResults() {
		return this.solution;
	}

}
