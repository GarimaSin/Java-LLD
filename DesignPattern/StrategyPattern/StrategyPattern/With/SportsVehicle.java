package StrategyPattern.StrategyPattern.With;

import StrategyPattern.StrategyPattern.With.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{

	SportsVehicle() {
		super(new SportsDriveStrategy());
	}
}
