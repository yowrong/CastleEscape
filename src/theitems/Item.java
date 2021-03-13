package theitems;

public class Item {

    private String itemName;
    private String itemDescription;
    private int[] itemCoordinate;

    public Item(int[] itemCoordinate, String itemName, String itemDescription) {
        this.itemCoordinate = itemCoordinate;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }


    public int[] getItemCoordinate() {
        return itemCoordinate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemCoordinate(int[] itemCoordinate) {
        this.itemCoordinate = itemCoordinate;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
