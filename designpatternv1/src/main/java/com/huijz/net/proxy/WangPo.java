package com.huijz.net.proxy;

/**
 * @author huijz
 * @date 2019/04/03
 */
public class WangPo implements KindWoman {
    private KindWoman kindWoman;

    public WangPo(KindWoman kindWoman) {
        this.kindWoman = kindWoman;
    }

    public void makeEyesWithMan() {
        this.kindWoman.makeEyesWithMan();
    }

    public void happyWithMan() {
        this.kindWoman.happyWithMan();
    }
}
