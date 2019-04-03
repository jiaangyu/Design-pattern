package com.huijz.net.proxy;
/**
 * @author huijz
 * @date 2019/04/03
 */
public class XiMen {
    public static void main(String[] args) {
        PanJinLian panJinLian = new PanJinLian();
        WangPo wangPo = new WangPo(panJinLian);
        wangPo.makeEyesWithMan();
        wangPo.happyWithMan();
    }

}
