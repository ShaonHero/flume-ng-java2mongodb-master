package org.linuxsogood.flume;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LogProduce {
    public static Log log = LogFactory.getLog(LogProduce.class);
    public static final String appName = "Masterapp";
    public static final List<String> addresslist = new ArrayList<String>();
    public static final List<String> statusList = new ArrayList<String>();

    static {
        addresslist.add(0, "/do/userlist");
        addresslist.add(1, "/do/createuser");
        addresslist.add(2, "/do/deleteuser");
        addresslist.add(3, "/do/productlist");
        addresslist.add(4, "/do/purse/{id}");
        addresslist.add(5, "/do/login");
    }

    static {
        statusList.add(0, "200");//OK
        statusList.add(1, "404");
        statusList.add(2, "500");
        statusList.add(3, "400");
        statusList.add(4, "405");
        statusList.add(5, "408");//Request Timeout
        statusList.add(6, "503");
        statusList.add(7, "504");//Gateway Timeout
    }
//    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        while (true) {
////            String ip = randIP();
////            String address = randAddress();
//            int a;
//            int b;
//            int c;
//            int d;
//            c = randStatus();
//            for(int j = 0;j<24;j++) {
//                a = randStatus();
//                b = randStatus();
//                d = randStatus();
//                if(a!=b){
//                    String LogoInfo = "{\"userId\":\"" + c + "\",\"day\":\"" + sdf.format(new Date()) + "\",\"beginningtime\":\"" + System.currentTimeMillis()
//                            + "\",\"endingtime\":\"" + (System.currentTimeMillis() + a*100) + "\",\"data\":[{\"" + "package\":\"" + "com.browser" + a*3 + "\",\"activetime\":\"" + d*50 + "\" , \"package\":\"" + "com.browser" + b*2 + "\",\"activetime\":\"" + d*80 + "\"}]}";
//                    log.info(LogoInfo);
//                    try {                Thread.sleep(5000);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//
//
//
//        }
//    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (true) {
//            String ip = randIP();
//            String address = randAddress();
            int a;
            int b;
            int c = randStatus();
            int d = randStatus();
            do {
                 a = randStatus();
                 b = randStatus();
            }while (b==a);


            String LogoInfo = "{\"userId\":\""+ c + "\",\"day\":\""+ sdf.format(new Date()) + "\",\"beginningtime\":\""+ System.currentTimeMillis()
                    + "\",\"endingtime\":\""+ (System.currentTimeMillis()+ a*100)+"\",\"data\":[{\""+ "package1\":\""+ "com.browser"+a + "\",\"activetime1\":\""+ c*70 + "\" },{ \"package2\":\""+ "com.browser"+b*50 + "\",\"activetime2\":\""+ d*60 + "\"}]}";
            log.info(LogoInfo);
            try {                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String randIP() {
        Random random = new Random(System.currentTimeMillis());
        return (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1);
    }

            public static String randAddress() {
                Random random = new Random();
                int i = random.nextInt(5);
                return addresslist.get(i);
            }

    public static int randStatus() {
        Random random = new Random();
        int i = random.nextInt(10) + 1;
            return i;


    }
}