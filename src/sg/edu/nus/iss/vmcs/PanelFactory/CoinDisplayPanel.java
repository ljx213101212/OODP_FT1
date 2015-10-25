package sg.edu.nus.iss.vmcs.PanelFactory;




import java.awt.Panel;

import sg.edu.nus.iss.vmcs.maintenance.ButtonItemDisplay;
import sg.edu.nus.iss.vmcs.maintenance.CoinDisplayListener;
import sg.edu.nus.iss.vmcs.maintenance.MaintenanceController;
//import sg.edu.nus.iss.vmcs.maintenance.testDisplayListener;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.util.LabelledDisplay;
import sg.edu.nus.iss.vmcs.util.VMCSException;

public class CoinDisplayPanel extends Panel implements PanelComponent  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String TITLE = "Quantity of Coins Available";

	private StoreController storeCtrl;
	private MaintenanceController mCtrl;
	private ButtonItemDisplay bi;
	public ButtonItemDisplay getBi() {
		return bi;
	}

	private int len;
	private int curIdx;
	
	//private Button testButton;

	/**
	 * This constructor creates an instance of CoinDisplay object.
	 * @param mctrl the MainController.
	 */
	public CoinDisplayPanel(MaintenanceController mctrl) {
		mCtrl = mctrl;
		storeCtrl = mCtrl.getMainController().getStoreController();

		len = storeCtrl.getStoreSize(Store.CASH);
		StoreItem[] items = storeCtrl.getStoreItems(Store.CASH);

		bi = new ButtonItemDisplay(TITLE, items, len);

 	    bi.addListener(new CoinDisplayListener(mCtrl));
		bi.clear();

		this.add(bi);

	
	
	 
		 
	 }

	/**
	 * This method activates the CoinDisplay if the parameter is TRUE&#46; Otherwise,
	 * the CoinDisplay is deactivated.
	 * @param st the active status of the CoinDisplay.
	 */
	public void setActive(boolean st) {
		bi.setActive(st);
	}

	/**
	 * Display the quantity of selected coin, clear other display.
	 * @throws VMCSException if fail to display quantity.
	 */
	public void displayQty(int idx, int qty) throws VMCSException {
		curIdx = idx;
		bi.clear();

		
		bi.displayQty(idx, qty);
	}

	/**
	 * Get the current displayed coin index&#46 This is used for updating when store MachinerySimulatorPanel is changed.
	 * Not required.
	 */
	public int getCurIdx() {
		return curIdx;
	}

	@Override
	public LabelledDisplay getPriceDisplay() {
		// TODO Auto-generated method stub
		return null;
	}

}
