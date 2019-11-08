package model.marker;

import model.item.Item;

public interface Marker {

    public void addItem(Item i);

    public void removeItem(Item i);

    public Boolean containsSameItem(Item i);
}