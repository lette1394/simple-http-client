package org.ooptraining.util.test.extendwith;

public class Man extends Person {
    @Override
    public String talk() {
        super.talk();
        return "and i'm a man";
    }

    @Override
    public boolean isMarried() {
        return true;
    }
}
