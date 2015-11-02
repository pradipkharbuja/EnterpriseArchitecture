package cs544.exercise6_1;

public class InventoryService implements IInventoryService {

	public int getNumberInStock(int productNumber) {
		// TODO Auto-generated method stub
		return productNumber - 200;
	}

}
