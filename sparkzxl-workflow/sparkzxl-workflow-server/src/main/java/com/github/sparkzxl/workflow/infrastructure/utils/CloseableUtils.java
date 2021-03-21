package com.github.sparkzxl.workflow.infrastructure.utils;


import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/**
 * description: 关闭资源工具类
 *
 * @author charles.zhou
 * @date   2020-07-17 15:30:12
 */
public final class CloseableUtils {

    private CloseableUtils() {
    }

    public static void close(Closeable... closeAble) {
        if (closeAble == null || closeAble.length == 0) {
            return;
        }

        for (Closeable closable : closeAble) {
            try {
                if (closable != null) {
                    closable.close();
                }
            } catch (IOException e) {
                System.err.println("Close resource exception:" + Arrays.toString(e.getStackTrace()));
            }
        }
    }

    public static void close(AutoCloseable... closables) {
        if (closables == null || closables.length == 0) {
            return;
        }

        for (AutoCloseable closable : closables) {
            try {
                if (closable != null) {
                    closable.close();
                }
            } catch (Exception e) {
                System.err.println("Close resource exception:" + Arrays.toString(e.getStackTrace()));
            }
        }
    }

}
