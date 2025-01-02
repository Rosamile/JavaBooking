package com.booking.iterator;

import com.booking.Model.Place;

import java.util.List;

public class PlaceIteratorImpl implements PlaceIterator {

    private List<Place> places;
    private int position;

    public PlaceIteratorImpl(List<Place> places) {
        this.places = places;
    }

    @Override
    public boolean hasNext() {

        return position<places.size();
    }

    @Override
    public Place getNext() {
        if(!hasNext()){
            return null;
        }
        position++;
        return places.get(position-1);
    }

    @Override
    public void reset() {
        position=0;
    }
}
