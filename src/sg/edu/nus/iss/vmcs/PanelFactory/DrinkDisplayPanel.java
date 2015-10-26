package sg.edu.nus.iss.vmcs.PanelFactory;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;

import sg.edu.nus.iss.vmcs.maintenance.ButtonItemDisplay;
import sg.edu.nus.iss.vmcs.maintenance.DrinkDisplayListener;
import sg.edu.nus.iss.vmcs.maintenance.MaintenanceController;
import sg.edu.nus.iss.vmcs.maintenance.PriceDisplayListener;
import sg.edu.nus.iss.vmcs.store.Store;
import sg.edu.nus.iss.vmcs.store.StoreController;
import sg.edu.nus.iss.vmcs.store.StoreItem;
import sg.edu.nus.iss.vmcs.util.LabelledDisplay;
import sg.edu.nus.iss.vmcs.util.VMCSException;

public class DrinkDisplayPanel extends Panel implements PanelComponent  {
	public final static String TITLE = "Quantity of Drinks Available";

	private StoreController storeCtrl;
	private MaintenanceController mCtrl;
	private ButtonItemDisplay bi;
	private LabelledDisplay price;
	private int curIdx; //current displayed item index;

	/**
	 * This constructor creates an instance of the DrinkDisplay object.
	 * @param mctrl the MaintenanceController.
	 */
	public DrinkDisplayPanel(MaintenanceController mctrl) {
		mCtrl = mctrl;
		storeCtrl = mCtrl.getMainController().getStoreController();

		this.setLayout(new BorderLayout());
		int len;
		len = storeCtrl.getStoreSize(Store.DRINK);
		StoreItem[] items = storeCtrl.getStoreItems(Store.DRINK);

		bi = new ButtonItemDisplay(TITLE, items, len);

		bi.addListener(new DrinkDisplayListener(mCtrl));
		bi.clear();
		price = new LabelledDisplay("Brand Price", 4, LabelledDisplay.FLOW);

		PriceDisplayListener pdl;

		pdl = new PriceDisplayListener(mCtrl);
		price.addListener(pdl);
		Panel tp = new Panel();
		tp.setLayout(new FlowLayout(FlowLayout.CENTER));
		tp.add(bi);
		curIdx = 0;
		this.add("Center", tp);
		this.add("South", price);
		price.setEnabled(false);
	}

	/**
	 * This method returns the LabelledDisplay of the price.
	 * @return LabelledDisplay of the price.
	 */
	public LabelledDisplay getPriceDisplay() {
		return price;
	}

	/**
	 * This method set the active status of the LabelledDisplay and ButtonItemDisplay.
	 * @param st the active status of the LabelledDisplay and ButtonItemDisplay.
	 */
	public void setActive(boolean st) {
		price.setActive(st);
		bi.setActive(st);
	}

	/**
	 * This method displays the stock value received for the currently selected brand.
	 * This display will be done on a text field associated with the DrinkDisplay object.
	 * @param idx the index of the stock.
	 * @param qty the quantity of the stock.
	 * @throws VMCSException if fail to display quantity.
	 */
	public void displayQty(int idx, int qty) throws VMCSException {
		curIdx = idx;
		bi.clear();
		price.setEnabled(true);
		bi.displayQty(idx, qty);
	}

	/**
	 * This method returns the current index.
	 * @return the current index.
	 */
	public int getCurIdx() {
		return curIdx;
	}

	@Override
	public ButtonItemDisplay getBi() {
		// TODO Auto-generated method stub
		return null;
	}
}
