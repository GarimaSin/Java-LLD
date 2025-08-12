package StrategyPattern.StrategyPattern.With;

import StrategyPattern.StrategyPattern.With.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{

	OffRoadVehicle() {
		super(new SportsDriveStrategy());
	}
}
