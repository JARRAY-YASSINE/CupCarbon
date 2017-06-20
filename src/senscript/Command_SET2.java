package senscript;

import wisen_simulation.SimLog;
import device.SensorNode;

public class Command_SET2 extends Command {

	protected String arg1 = "";
	protected String arg2 = "";
	
	public Command_SET2(SensorNode sensor, String arg1, String arg2) {
		this.sensor = sensor ;
		this.arg1 = arg1 ;
		this.arg2 = arg2 ;
	}

	@Override
	public double execute() {
		SimLog.add("S" + sensor.getId() + " Set " + arg1 + "=" + arg2);
		String arg = sensor.getScript().getVariableValue(arg2);
		sensor.getScript().addVariable(arg1, arg);
		return 0 ;
	}

	@Override
	public String toString() {
		return "SET";
	}
	
	@Override
	public String getArduinoForm() {
		String s = arg1 + " = " + arg2.replace("$", "") + ";";
		return s;
	}
	
}
