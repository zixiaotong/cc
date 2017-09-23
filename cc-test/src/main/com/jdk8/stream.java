package com.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mode.User;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/9/23.
 */
public class stream {

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
        /**
         * ��list���������id
         * map����Ӧ����Ҫ�Ž�ȥ��������Ϣ
         * filter ��������ã��ŵ����ж�������
         */
        List<Integer> disShopList = userList.stream().filter(m -> m.getId() > 0).map(k -> k.getId()).distinct().collect(Collectors.toList());

        // �ѷ�����������Ϣ��װ�ɶ���  distinct������ص��Ƕ�����distinct����Ч��
        List<User> userList1 = userList.stream().filter(m -> m.getId()>2).distinct().collect(Collectors.toList());

        //���жϣ�ֱ�Ӱ�map��ȡ�����ݷŵ�integer������
        List<Integer> oneIDList=userList.stream().map(k->k.getId()).collect(Collectors.toList());

        //findFirst
    }
    @Test
    public void parallelStream(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.forEach(str -> System.out.print(str + "  "));
    }

}
