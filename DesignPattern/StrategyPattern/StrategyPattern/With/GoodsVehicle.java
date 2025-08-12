package StrategyPattern.StrategyPattern.With;

import StrategyPattern.StrategyPattern.With.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{

	public GoodsVehicle() {
		super(new NormalDriveStrategy());
	}
}
