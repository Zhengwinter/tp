package model;

public interface ItemManager {

    boolean add(MenuItem item);
    boolean remove(String itemID);

    public String getId();
}
