package jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import mode.User;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/9/23.
 */
public class strem {

    @Test
    public void test1() {
        List<User> userList = new ArrayList<>();
        //for (int i = 1; i < 5; i++) {
        //    User user = new User();
        //    user.setId(i);
        //    user.setAge(i + 20);
        //    userList.add(user);
        //}
        User user = new User();
        user.setId(1);
        user.setAge(1 + 20);
        User user1 = new User();
        user1.setId(1);
        user1.setAge(1 + 20);
        userList.add(user);
        userList.add(user1);
        /**
         * 从list集合里过滤id
         * map里面应该是要放进去的内容信息
         * filter 起过滤作用，放的是判断条件。
         */
        List<Integer> disShopList = userList.stream().filter(m -> m.getId() > 0).map(k -> k.getId()).distinct().collect(Collectors.toList());

        // 把符合条件的信息封装成对象  distinct如果返回的是对象，用distinct是无效的
        List<User> userList1 = userList.stream().filter(m -> m.getId()>2).distinct().collect(Collectors.toList());

        //不判断，直接把map里取的数据放到integer集合中
        List<Integer> oneIDList=userList.stream().map(k->k.getId()).collect(Collectors.toList());

        List<User> seclist =userList.stream().filter(k->k.getId()>1).collect(Collectors.toList());
        System.out.println(disShopList);
        //findFirst
    }
    @Test
    public void test2(){
        //parallelStream
        //list.forEach(str -> System.out.print(str + "  "));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream()
            .forEach(out::println);
    }

}
