package sg.edu.nus.iss.vmcs.yangcheng;

import java.awt.Panel;

import sg.edu.nus.iss.vmcs.maintenance.ButtonItemDisplay;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.util.LabelledDisplay;
import sg.edu.nus.iss.vmcs.util.VMCSException;

public interface PanelComponent {
	
	
	/**
	 * This method activates the CoinDisplay if the parameter is TRUE&#46; Otherwise,
	 * the CoinDisplay is deactivated.
	 * @param st the active status of the CoinDisplay.
	 */
	public void setActive(boolean st);

	/**
	 * Display the quantity of selected coin, clear other display.
	 * @throws VMCSException if fail to display quantity.
	 */
	public void displayQty(int idx, int qty) throws VMCSException;

	/**
	 * Get the current displayed coin index&#46 This is used for updating when store MachinerySimulatorPanel is changed.
	 * Not required.
	 */
	public int getCurIdx();

	public LabelledDisplay getPriceDisplay();
	
	public ButtonItemDisplay getBi();
	
	

}
