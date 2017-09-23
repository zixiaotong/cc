package cn.mode.proxy;

/**
 * Created by shanglei on 2017/6/6.
 */
public class UserImpl implements User {
    @Override
    public void getUser() {
        System.out.println("user");
    }

    @Override
    public void getName() {
        System.out.printf("name");
    }
}
