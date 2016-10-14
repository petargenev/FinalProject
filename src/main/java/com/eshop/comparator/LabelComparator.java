package com.eshop.comparator;

import java.util.Comparator;

import com.eshop.models.Label;

public class LabelComparator implements Comparator<Label>
{
    public int compare(Label c1, Label c2)
    {
        return c1.getName().compareTo(c2.getName());
    }
}