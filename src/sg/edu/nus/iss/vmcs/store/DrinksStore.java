/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.store;

/**
 * This object is storage, in the vending machine's memory, for the total number of
 * cans of each DrinksBrand held by the vending machine&#46;
 * 
 * @see CashStore
 * @see CashStoreItem
 * @see Coin
 * @see DrinksBrand
 * @see DrinksStoreItem
 * @see Store
 * @see StoreController
 * @see StoreItem
 * @see StoreObject
 * 
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */
public class DrinksStore extends Store {

	/**
	 * This constructor creates an instance of DrinksStore object.
	 */
	public DrinksStore() {
	}

	@Override
	public Store initializeStore(PropertyLoader propLoad, Store store) {
		// TODO Auto-generated method stub
		DrinksStore dStore = (DrinksStore) store;
		int numOfItems = propLoad.getNumOfItems();
		dStore.setStoreSize(numOfItems);
		getList(propLoad,dStore);
//		for (int i = 0; i < numOfItems; i++) {
//            DrinksStoreItem item = (DrinksStoreItem) propLoad.getItem(i);
//			StoreObject brand = item.getContent();
//			StoreObject existingBrand = dStore.findObject(brand.getName());
//			if (existingBrand != null) {
//			    item.setContent(existingBrand);
//			}
//			dStore.addItem(i, item);
//		}
		return dStore;
	}
	
	public Store getList(PropertyLoader propLoad, Store store){
		Store dStore = (DrinksStore) store;
		for (int i = 0; i < propLoad.getNumOfItems(); i++) {
            DrinksStoreItem item = (DrinksStoreItem) propLoad.getItem(i);
			StoreObject brand = item.getContent();
			StoreObject existingBrand = dStore.findObject(brand.getName());
			if (existingBrand != null) {
			    item.setContent(existingBrand);
			}
			dStore.addItem(i, item);
		}
		return dStore;
	}
}//End of class DrinksStore
