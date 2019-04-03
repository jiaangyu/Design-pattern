package com.huijz.net.singleton;

/**
 * @author huijz
 * @date 2019/04/03
 */
public class Emperor {
    private static Emperor ourInstance;

    public static Emperor getInstance() {
        if (ourInstance == null) {
            ourInstance = new Emperor();
        }
        return ourInstance;
    }

    private Emperor() {
    }

    public void emperorInfo() {
        System.out.println(this.hashCode() + "我就是皇帝某某！");
    }
}
