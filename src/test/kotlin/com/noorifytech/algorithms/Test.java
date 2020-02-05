package com.noorifytech.algorithms;

import org.junit.Assert;

public class Test {
    private String getCategorySlug(String path) {
//        return path.replaceAll("^(/m)?/?(ar|en)?/?(.*?)/\\d{4}/\\d{1,2}/\\d{1,2}.*$", "$3");
        return path = path.trim().replaceAll("^(/m/)?(ar|en)?/?(property-for-(rent|sale)/)", "$3");
    }

    @org.junit.Test
    public void test() {
        Assert.assertEquals("motors/used-cars/audi/q5",
            getCategorySlug("/motors/used-cars/audi/q5/2019/6/2/audi-q5-20l-2015-model-with-warranty-gcc-s-2/")
        );
    }
}
