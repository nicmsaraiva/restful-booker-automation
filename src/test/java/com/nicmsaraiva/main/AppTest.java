package com.nicmsaraiva.main;

import com.nicmsaraiva.utils.JsonUtils;
import junit.framework.TestCase;

public class AppTest extends TestCase {
    public void testApp() {
        System.out.println(JsonUtils.json2String("auth"));
    }
}
