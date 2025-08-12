package StrategyPattern.StrategyPattern.With;

import StrategyPattern.StrategyPattern.With.Strategy.DriveStrategy;

public class Vehicle {
	
	DriveStrategy strategy;
	
	//Constructor injection
	Vehicle(DriveStrategy obj) {
		this.strategy = obj;
	}

	public void drive() {
		strategy.drive();
	}
}
