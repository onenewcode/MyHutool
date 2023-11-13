package com.onenewcode;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class ConvertTest {
    /**
     *字符串转换
     */
    @Test
    public void strTest(){
    //  各种类型转字符串
        int a = 1;
    //aStr为"1"
        String aStr = Convert.toStr(a);
        System.out.println(aStr);

        long[] b = {1,2,3,4,5};
    //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        System.out.println(bStr);
        Map<String,Integer> map=new HashMap<>();
        map.put("SDfsd",4);
        map.put("dfgd",676);
        map.put("Sdfssd",4);
        System.out.println(Convert.toStr(map));


    // 半角和全角转换
        // 半角转全角
        String a1= "123456789";

//结果为："１２３４５６７８９"
        String sbc = Convert.toSBC(a1);

        System.out.println(sbc);
        // 全角转半角
        //结果为"123456789"
        String dbc=Convert.toDBC(sbc);
        System.out.println(dbc);

    }
/*
十六进制转换
 */
    @Test
    public void hexTest(){
        String a = "我是一个小小可爱的字符串";
    //    字符串转化为十六进制字符串
        String hex = Convert.toHex(a, CharsetUtil.CHARSET_UTF_8);
        //结果："e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2"
        System.out.println(hex);
        // 十六进制字符串转化为正常字符串
        String raw = Convert.hexToStr(hex, CharsetUtil.CHARSET_UTF_8);
//        输出
        System.out.println(raw);
    }
    @Test
    public void unTest(){
        String a = "我是一个小小的可爱的字符串";
        //   字符串转化为unf-8
        //结果为："\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
        String unicode = Convert.strToUnicode(a);
        System.out.println(unicode);
        String raw = Convert.unicodeToStr(unicode);
    //结果为："我是一个小小的可爱的字符串"
        System.out.println(raw);

        //utf-8转换为ios-8859-i字符集
        String result = Convert.convertCharset(a, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        //转换后result为乱码
        System.out.println(result);
        // 把编码转化出来
        String s=Convert.convertCharset(result,CharsetUtil.ISO_8859_1,CharsetUtil.UTF_8);
        System.out.println(s);
    }
    @Test
    public void timeT(){
        long a = 4535345;

        //结果为：75
        long minutes = Convert.convertTime(a, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
        System.out.println(minutes);
    }
    @Test
    public  void digTest(){
        double a = 67556.32;

//结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(a);

        System.out.println(digitUppercase);

    }
    @Test
    public void numberTest(){
//        数字转为英文表达 ONE HUNDRED AND CENTS TWENTY THREE ONLY
        String format = Convert.numberToWord(100.23);
        System.out.println(format);
//        数字简化  1.2k
        String format1 = Convert.numberToSimple(1200);
        System.out.println(format1);
//        数字转中文 数字转中文方法中，只保留两位小数  一万零八百八十九点七二
        String f1 = Convert.numberToChinese(10889.72356, false);
        System.out.println(f1);

// 使用金额大写  壹万贰仟陆佰伍拾叁
        String f2 = Convert.numberToChinese(12653, true);
        System.out.println(f2);
//        数字中文表示转换为数字 1012
        Integer i= Convert.chineseToNumber("一千零一十二");
        System.out.println(i);
    }

}
