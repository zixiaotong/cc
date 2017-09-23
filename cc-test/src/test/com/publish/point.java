package com.publish;

import java.io.IOException;
import java.util.ArrayList;

import com.github.odiszapc.nginxparser.NgxBlock;
import com.github.odiszapc.nginxparser.NgxConfig;
import com.github.odiszapc.nginxparser.NgxDumper;
import com.github.odiszapc.nginxparser.NgxParam;
import com.github.odiszapc.nginxparser.NgxToken;
import org.junit.Test;

/**
 * @author shanglei
 * @date 2017/8/11.
 */
public class point {

    @Test
    public void addPoint() throws IOException {
        NgxConfig conf = NgxConfig.read("/Users/shanglei/Downloads/nginx.conf");
        ArrayList arrayList = (ArrayList)conf.getEntries();
        NgxBlock ngxBlock = (NgxBlock)arrayList.get(7);
        ArrayList arrayList1 = (ArrayList)ngxBlock.getEntries();

        for (int i = 0; i < arrayList1.size(); i++) {
            if ("upstream payadmin.zhangheyun.cn {".equals(arrayList1.get(i).toString())) {
                ArrayList arrayList2 = (ArrayList)((NgxBlock)arrayList1.get(i)).getEntries();
                for (int j = 0; j < arrayList2.size(); j++) {
                    if (arrayList2.get(j).toString().equals("server 192.168.102.185:8305 weight=1;")) {
                        NgxParam ngxParam = new NgxParam();
                        System.out.println();
                        ngxParam.addValue(new NgxToken("#server 192.168.102.185:8305 weight=1"));
                        arrayList2.remove(j);
                        arrayList2.add(j, ngxParam);
                    }
                }
            }
        }
        NgxDumper dumper = new NgxDumper(conf);
        dumper.dump(System.out);
    }

    @Test
    public void delPoint() {

    }
}
