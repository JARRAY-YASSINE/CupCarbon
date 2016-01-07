package simulation;

import map.MapLayer;
import device.DeviceList;

public class FaultInjector extends Thread {

	private boolean loop = true; 
	
	@Override
	public void run() {
		int n = DeviceList.size();
		double p ;
		while(loop) {
			for (int i = 0; i < n; i++) {
				p=Math.random();				
				if(p<0.0004) {
					DeviceList.getNodes().get(i).setDead(true);
					MapLayer.getMapViewer().repaint();
				}
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopInjection() {
		loop = false;
	}
	
}
