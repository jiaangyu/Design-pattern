package com.huijz.net.strategy;

/**
 * @author huijz
 * @date 2019/04/01
 */
public class Zhaoyun {
    public static void main(String[] args) {
        System.out.println("**************刚到吴国****************");
        Context context0 = new Context(new BackDoor());
        context0.operate();
        System.out.println("**************拆第一锦囊**************");

        System.out.println("**************已在吴国落脚****************");
        Context context1 = new Context(new GivenGreenLight());
        context1.operate();
        System.out.println("**************拆第二锦囊**************");

        System.out.println("**************离开吴国****************");
        Context context2 = new Context(new BlockEnemy());
        context2.operate();
        System.out.println("**************拆第三锦囊**************");
    }
}
