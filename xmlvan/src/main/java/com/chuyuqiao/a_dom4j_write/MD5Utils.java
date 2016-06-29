package com.chuyuqiao.a_dom4j_write;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by chuyuqiao on 2016/6/29.
 */
public class MD5Utils {

    public static String crateMD5(File file) throws Exception {
        return DigestUtils.md5Hex(new FileInputStream(file));
    }
}
