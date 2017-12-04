//package com.thread;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadPoolExecutor;
//
//import com.zhtx.commoncore.util.HttpUtil;
//import com.zhtx.commoncore.util.JsonUtil;
//import com.zhtx.commoncore.util.StringUtils;
//import com.zhtx.commonentity.common.IJobDo;
//import com.zhtx.goodscore.config.Config;
//import com.zhtx.goodsentity.resp.ServiceStationResp;
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Service;
//
///**
// * @author shanglei
// * @date 2017/10/9.
// */
//@Service
//public class FloorDataTaskService implements IJobDo {
//    private static int taskThreadNum = Runtime.getRuntime().availableProcessors() * 2;
//    private static ExecutorService executorService = Executors.newFixedThreadPool(taskThreadNum);
//    private static Map<Integer, String> map = new ConcurrentHashMap<>();
//    private static List<ServiceStationResp> serviceStationRespList = new ArrayList<>();
//    private static Logger logger = Logger.getLogger(FloorDataTaskService.class);
//
//    @Override
//    public void run() {
//        ThreadPoolExecutor b=(ThreadPoolExecutor)executorService;
//        if(b.getActiveCount()>0){
//            return;
//        }
//        getServerStationsBaseInfo();
//        if (serviceStationRespList == null || serviceStationRespList.size() <= 0) {
//            return;
//        }
//        for (ServiceStationResp serviceStationReq : serviceStationRespList) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    runMain(serviceStationReq);
//                }
//            });
//        }
//    }
//
//    private void runMain(ServiceStationResp serviceStationReq) {
//        String result = getFloorData(serviceStationReq);
//        if (("Exception").equals(result)) {
//            return;
//        }
//        String str = replace(result);
//        try {
//            boolean flag = true;
//            String sHtml = map.get(serviceStationReq.getId());
//            if (sHtml == null) {
//                flag = wirteFile(serviceStationReq.getId(), str);
//            } else {
//                if (!sHtml.equals(str)) {
//                    flag = wirteFile(serviceStationReq.getId(), str);
//                }
//            }
//            if (flag) {
//                map.put(serviceStationReq.getId(), str);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private synchronized boolean wirteFile(int id, String result) {
//        boolean flag = true;
//        String floorPath = Config.getFloorDataPath();
//        List<String> arrayList = new ArrayList<>();
//        if (floorPath.contains(",")) {
//            String[] split = floorPath.split(",");
//            for (String sarr : split) {
//                arrayList.add(sarr);
//            }
//        } else {
//            arrayList.add(floorPath);
//        }
//        for (String sarr : arrayList) {
//            try {
//                File filepath = new File(sarr);
//                if (!filepath.exists()) {
//                    filepath.mkdirs();
//                }
//                File filename = new File(sarr + "/" + id + ".html");
//                if (!filename.exists()) {
//                    filename.createNewFile();
//                }
//                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filename), "utf-8");
//                osw.write(result);
//                osw.flush();
//                osw.close();
//            } catch (IOException e) {
//                flag = false;
//                logger.error("楼层定时任务：写文件出错；机器路径：" + sarr + "服务站id："+id+"：异常信息：" + e.getMessage() + StringUtils.getStackTrace(e));
//            }
//        }
//        return flag;
//    }
//
//    private static String replace(String result) {
//        if (result.indexOf("  ") >= 0) {
//            return replace(result.replace("  ", " "));
//        } else {
//            return result;
//        }
//    }
//
//    /**
//     * 获取net接口楼层数据
//     *
//     * @return
//     */
//    private void getServerStationsBaseInfo() {
//        try {
//            String json = HttpUtil.sendGet(Config.getUserBaseUrl() + "/api/ServerStation/GetServerStationsBaseInfo", "");
//            List<ServiceStationResp> stationResps = JsonUtil.str2list(json, ServiceStationResp.class);
//            if (stationResps != null && stationResps.size() > 0) {
//                serviceStationRespList = stationResps;
//            }
//        } catch (Exception e) {
//            logger.error("楼层定时任务：调取.net楼层数据出错；" + "异常信息：" + e.getMessage() + StringUtils.getStackTrace(e));
//        }
//    }
//
//    private String getFloorData(ServiceStationResp serviceStationReq) {
//        Long start = System.currentTimeMillis();
//        String result;
//        try {
//            result = HttpUtil.sendGet(Config.getProductWebUrl() + "/home/getFloorGoodsDataBySsIdAndSmId?ssid=" + serviceStationReq.getId() + "", "");
//        } catch (Exception e) {
//            result = "Exception";
//            logger.error("楼层定时任务：调取getFloorGoodsDataBySsIdAndSmId接口出错；服务站id："+serviceStationReq.getId()+"" + "：异常信息：" + e.getMessage() + StringUtils.getStackTrace(e));
//        }
//        logger.debug("楼层定时任务：调取getFloorGoodsDataBySsIdAndSmId接口时间:" + (System.currentTimeMillis()-start)+"毫秒,服务站id："+serviceStationReq.getId());
//        return result;
//    }
//}
