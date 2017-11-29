package com.listdemo;

import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/10/20.
 */
public class listTest {

    @Test
    public void test1() {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            User user = new User();
            user.setAge(i);
            user.setName(i + "zhanghe");
            userList.add(user);
        }
        System.out.println(userList.size());
        for (int i = 1; i < userList.size(); i++) {
            if (userList.get(i).getName().equals("2zhanghe")) {
                userList.remove(i);
                i--;
            }
        }
        System.out.println(userList.size());
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void test2() {
        Integer ss = 0;
        System.out.println(ss.toString());
    }

}
