package StrategyPattern.StrategyPatternMain;

import StrategyPattern.StrategyPattern.With.GoodsVehicle;
import StrategyPattern.StrategyPattern.With.Vehicle;

public class Main {

	public static void main(String[] args) {
		Vehicle v = new GoodsVehicle();
		v.drive();
	}
}
