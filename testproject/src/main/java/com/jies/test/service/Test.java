package com.jies.test.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
* Created by peijie on 17/1/12.
*/
public class Test {
    private final static int[] li_SecPosValue = { 1601, 1637, 1833, 2078, 2274,
            2302, 2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858,
            4027, 4086, 4390, 4558, 4684, 4925, 5249, 5590 };
    private final static String[] lc_FirstLetter = { "a", "b", "c", "d", "e",
            "f", "g", "h", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "w", "x", "y", "z" };

    /**
     * 取得给定汉字串的首字母串,即声母串
     * @param str 给定汉字串
     * @return 声母串
     */
    public String getAllFirstLetter(String str) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }

        String _str = "";
        for (int i = 0; i < str.length(); i++) {
            _str = _str + this.getFirstLetter(str.substring(i, i + 1));
        }

        return _str;
    }

    /**
     * 取得给定汉字的首字母,即声母
     * @param chinese 给定的汉字
     * @return 给定汉字的声母
     */
    public String getFirstLetter(String chinese) {
        if (chinese == null || chinese.trim().length() == 0) {
            return "";
        }
        chinese = this.conversionStr(chinese, "GB2312", "ISO8859-1");

        if (chinese.length() > 1) // 判断是不是汉字
        {
            int li_SectorCode = (int) chinese.charAt(0); // 汉字区码
            int li_PositionCode = (int) chinese.charAt(1); // 汉字位码
            li_SectorCode = li_SectorCode - 160;
            li_PositionCode = li_PositionCode - 160;
            int li_SecPosCode = li_SectorCode * 100 + li_PositionCode; // 汉字区位码
            if (li_SecPosCode > 1600 && li_SecPosCode < 5590) {
                for (int i = 0; i < 23; i++) {
                    if (li_SecPosCode >= li_SecPosValue[i]
                            && li_SecPosCode < li_SecPosValue[i + 1]) {
                        chinese = lc_FirstLetter[i];
                        break;
                    }
                }
            } else // 非汉字字符,如图形符号或ASCII码
            {
                chinese = this.conversionStr(chinese, "ISO8859-1", "GB2312");
                chinese = chinese.substring(0, 1);
            }
        }

        return chinese;
    }

    /**
     * 字符串编码转换
     * @param str 要转换编码的字符串
     * @param charsetName 原来的编码
     * @param toCharsetName 转换后的编码
     * @return 经过编码转换后的字符串
     */
    private String conversionStr(String str, String charsetName,String toCharsetName) {
        try {
            str = new String(str.getBytes(charsetName), toCharsetName);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("字符串编码转换异常：" + ex.getMessage());
        }
        return str;
    }

    public static void main(String args []) throws IOException, InterruptedException, ParseException {


        Test cte = new Test();
        System.out.println("获取拼音首字母："+ cte.getAllFirstLetter("裴杰"));

//        Exception e = new Exception();
//        List a = new ArrayList<>();
//        List b = new ArrayList<>();
//        a.add(1);
//        b.add(2);

//        String urlStr = "http://www.baidu.com/s?wd=%E7%99%BE%E5%BA%A6&ie=utf-8&rsv_op=V398IhT3OPR6N00IV049chPYcMa3Q4SdTP7g7OWZfJdN4P0hZUhML1O6IOh80P05V89R6JL4XeNSS7NI8LRac4fTT864OhT5&tn=99434623_hao_pg&ch=&rsv_su=TeU985JgSg8a3c8Ld41VRbK2LUULR3LgIdc8h5gRZYT2gTefLc8gOc4SU42K1Qd1VgYRP2WMNM2JKcK5h93YZIV68VcN7ZeO";
//        URL url = new URL(urlStr);
//        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
//        InputStreamReader input = new InputStreamReader(httpURLConnection.getInputStream(), "utf-8");


//        String urlStr = "https://user.qzone.qq.com/978737382";
//        URL url = new URL(urlStr);
//        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//        InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
//        BufferedReader bufReader = new BufferedReader(input);
//        String line = "";
//        StringBuilder contentBuf = new StringBuilder();
//        while ((line = bufReader.readLine()) != null) {
//            contentBuf.append(line);
//        }
//        String buf = contentBuf.toString();
//        System.out.println(buf);
//
//

//        String [] strings = buf.split("d_post_content j_d_post_content \">");
//        for(int i=1;i<strings.length;i++){
//            String str = strings[i];
//            str = str.substring(12, str.length());
//            Integer index = str.indexOf("</div>");
//            str = str.substring(0, index);
//            if(str.contains("<img") && str.contains(">")){
//                Integer index1 = str.indexOf(">");
//                str = str.substring(index1 + 1, str.length());
//            }
//            System.out.println(str);
//        }

//        System.out.println(buf);/^[\u4E00-\u9FA5]

//        Pattern pattern = Pattern.compile("d_post_content j_d_post_content \">[\\s|\\S]*([\\u4E00-\\u9FA5])</div>");
//        Matcher matcher = pattern.matcher(buf);
//        while(matcher.find()){
//            System.out.println(matcher.group(1));
//
//        }

//        String str = "abc<icon>def</icon>deftfh<icon>a</icon>";
//
//        Pattern p=Pattern.compile("<icon>(\\w+)</icon>");
//        Matcher m=p.matcher(str);
//        while(m.find()){
//            System.out.println(m.group(1));
//
//        }
//        System.out.println(0|0x01);

//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, -3);
//        calendar.set(Calendar.MONTH,8);
//        calendar.set(Calendar.DATE,22);
//        Date beginDt = calendar.getTime();
//        System.out.println(beginDt);

//         List<Integer> l = new ArrayList<>();
//         l.add(4);l.add(1);l.add(3);l.add(2);
//        Collections.sort(l, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1 > o2){
//                    return 1;
//                }else {
//                    return -1;
//                }
//            }
//        });
//        for(Integer i : l){
//            System.out.println(i);
//        }
//        Map<DuiXiang, Integer> map = new HashMap<>();
//        DuiXiang d = new DuiXiang();
//        map.put(d, 1);
//        System.out.println(map.get(d));
//        d.setProperty("111");
//        System.out.println(map.get(d));
//        DuiXiang dd = new DuiXiang();
//        System.out.println(map.get(dd));

//        BigDecimal a = BigDecimal.valueOf(2.0);
//        BigDecimal b = BigDecimal.valueOf(1.0);
//        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DATE, 1);
//        calendar.add(Calendar.MONTH, -1);
//        calendar.set(Calendar.YEAR, 2017);
//        System.out.println(f.format(calendar.getTime()));

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMM");
//        System.out.println(simpleDateFormat.format(new Date()));

//        List<Integer> l = new ArrayList<>();
//        l.add(3);l.add(30);l.add(4);l.add(15);l.add(32);l.add(11);l.add(32);l.add(124);l.add(22);
//        l=l.stream().sorted(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1 > o2){
//                    return -1;
//                }else {
//                    return 1;
//                }
//            }
//        }).collect(Collectors.toList());
//        l = l.subList(0,9);
//        for(Integer i : l){
//            System.out.println(i);
//        }

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DATE, 1);
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(format.format(calendar.getTime()));

//        System.out.println(1&0);

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, 2018);
//        calendar.set(Calendar.MONTH, 3);
//        calendar.set(Calendar.DAY_OF_MONTH, 4);
//        calendar.set(Calendar.HOUR_OF_DAY, 17);
//        calendar.set(Calendar.MINUTE,40);
//        calendar.set(Calendar.SECOND,0);
//        System.out.println(format.format(calendar.getTime()));
//        if((new Date().after(calendar.getTime()))){
//            System.out.println("sdadaskdjaslkdjaslkjdaskldjas");
//        }


    }


}
