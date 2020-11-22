package com.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.bean.User;
import org.junit.Before;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/9/23.
 */
public class stream {

    List<User> before = new ArrayList<>();
    List<User> after = new ArrayList<>();
    @Before
    public void aaa(){
        // 之前
        for (int i = 1; i <= 2; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(i + 20);
            before.add(user);
        }
        // 之后
        for (int y = 1; y <= 4; y++) {
            User user = new User();
            user.setId(y);
            user.setAge(y + 200);
            after.add(user);
        }
    }

    @Test
    public void stream() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setAge(1 + 20);
        User user1 = new User();
        user1.setId(1);
        user1.setAge(1 + 20);
        userList.add(user);
        userList.add(user1);
        List<Integer> disShopList = userList.stream().filter(m -> m.getId() > 0).map(k -> k.getId()).distinct().collect(
            Collectors.toList());
        List<User> userList1 = userList.stream().filter(m -> m.getId() > 2).distinct().collect(Collectors.toList());
        List<Integer> oneIDList = userList.stream().map(k -> k.getId()).collect(Collectors.toList());
    }

    @Test
    public void parallelStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.forEach(str -> System.out.print(str + "  "));
    }

    @Test
    public void test1() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setAge(1 + 20);
        User user1 = new User();
        user1.setId(2);
        user1.setAge(1 + 20);
        User user2 = new User();
        user2.setId(3);
        user2.setAge(1 + 20);
        User user3 = new User();
        user3.setId(4);
        user3.setAge(1 + 20);
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        List<User> userList1 = new ArrayList<>();
        User user11 = new User();
        user11.setId(1);
        user11.setAge(1 + 20);
        User user111 = new User();
        user111.setId(2);
        user111.setAge(1 + 20);
        User user22 = new User();
        user22.setId(3);
        user22.setAge(1 + 20);
        User user32 = new User();
        user32.setId(4);
        user32.setAge(1 + 20);
        userList1.add(user111);
        userList1.add(user22);
        userList1.add(user32);
        userList1.add(user11);

        //System.out.println(userList.toString());
        //System.out.println(userList1.toString());

        for (int i = 0; i < userList.size(); i++) {
            for (int y = 0; y < userList1.size(); y++) {
                if (userList.get(i).getId().intValue() == (userList1.get(y).getId().intValue())) {

                    System.out.println("e");
                }
            }
        }

        for (int i = 0; i < userList.size(); i++) {
            User user3233 = userList.get(i);
            User user4 = userList1.stream().filter(k -> k.getId().intValue() == (user3233.getId().intValue())).collect(
                Collectors.toList()).get(0);

            //if(user3233.getId().intValue()==user4.getId().intValue()){
            System.out.println(user4.getId());
            //}

        }

    }

    @Test
    public void test2() {
        List<User> beforeList = new ArrayList<>();
        List<User> afterList = new ArrayList<>();
        List<User> addlist = new ArrayList<>();
        List<User> reducelist = new ArrayList<>();
        if (before.size() >= after.size()) {
            for (int x = 0; x < after.size(); x++) {
                for (int i = before.size() - 1; i >= 0; i--) {
                    if (after.get(x).getId() == before.get(i).getId()) {
                        System.out.println("f");
                        beforeList.add(before.get(i));
                        afterList.add(after.get(x));
                        before.remove(before.get(i));
                    }
                }
            }
            reducelist.addAll(before);
        }
        if (after.size() >= before.size()) {
            for (int x = 0; x < before.size(); x++) {
                for (int i = after.size() - 1; i >= 0; i--) {
                    if (before.get(x).getId() == after.get(i).getId()) {
                        System.out.println("e");
                        beforeList.add(before.get(i));
                        afterList.add(after.get(i));
                        after.remove(after.get(i));
                    }
                }

            }
            addlist.addAll(after);
        }
        System.out.println("beforeList:"+beforeList);
        System.out.println("afterList:"+afterList);
        System.out.println("reducelist:"+reducelist);
        System.out.println("addlist:"+addlist);

        System.out.println();

    }

    @Test
    public void test3() {
        //System.out.println(before);

        List<Integer> disShopList = after.stream().filter(m -> m.getId() > 0).map(k -> k.getId()).distinct().collect(
            Collectors.toList());

        //List<IUser> before1 = before.stream().filter((IUser k) ->k.setAge(1)).collect(Collectors.toList().);


        //after = after.stream().map(student -> new Demo(student.getAge(), student.getSex())).collect(Collectors.toList());


        //after.stream().map(k -> k.setAge(null)).collect(Collectors.toList());

        System.out.println(after);

    }
}
