package com.kazunokofactory.vem.annotation;

/**
 * Created by kazunoko on 2014/07/14.
 * APIの種類
 */
public enum VeViewType {
    TEXT_VIEW(1),
    NON(999);

    private final int type;

    private VeViewType(final int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }
}
