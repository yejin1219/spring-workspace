package com.kh.dice;

import lombok.Data;

@Data
public class Player {

	
	private Dice dice;
	private int totalValue;
	
	public Player() {
		
	}
	
	
	public Player(Dice dice) {
		this.dice = dice;
	}
	
	// count 만큼 주사위를 굴려서 합을 매기는 메소드
	public void playDice(int count) {
		System.out.println("==>" + getClass().getName() + ".playDice() start ~ ");
		
		for(int i=0; i <count; i++) {
			dice.selectedNumber();
			
			System.out.println("[" + dice.getClass().getName() + "] 의 선택된 수 : " + dice.getValue());
			
			totalValue += dice.getValue();
			
		}
		System.out.println("==>" + getClass().getName() + ".playDice() end..");
	}

	
}
