package com.onenewcode;

import cn.hutool.core.convert.Convert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstTest {
    @Test
    public void firstT(){
        int a = 1;
        String aStr = Convert.toStr(a);
        System.out.println(aStr);
    }

}