package com.booking.iterator;

import com.booking.Model.Place;

public interface PlaceIterator {

    boolean hasNext();

    Place getNext();

    void reset();
}
