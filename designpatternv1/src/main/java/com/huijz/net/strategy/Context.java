package com.huijz.net.strategy;

/**
 * @author huijz
 * @date 2019/04/01
 */
public class Context {
    private IStrategy iStrategy;

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void operate() {
        this.iStrategy.operate();
    }

}
