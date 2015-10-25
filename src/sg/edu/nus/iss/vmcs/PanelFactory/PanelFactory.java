package sg.edu.nus.iss.vmcs.PanelFactory;

import sg.edu.nus.iss.vmcs.maintenance.MaintenanceController;

public class PanelFactory {
	private MaintenanceController mCtrl;
	
	
	public PanelFactory(MaintenanceController mctrl2) {
		this.mCtrl = mctrl2;
		// TODO Auto-generated constructor stub
	}

	public PanelComponent getPanelComponent(String PanelName){
		if(PanelName==null)
			return null;
		else if(PanelName=="coinpanel")
			return new CoinDisplayPanel(mCtrl);
		else if(PanelName=="drinkpanel")
			return new DrinkDisplayPanel(mCtrl);
		
		return null;
	
	
		
	}

}
