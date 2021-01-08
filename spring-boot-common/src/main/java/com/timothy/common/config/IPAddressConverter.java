package com.timothy.common;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/6 12:57
 */
public class IPAddressConverter extends ClassicConverter {
    public static String getIpAddress() {
        return ipAddress;
    }

    public static void setIpAddress(String ipAddress) {
        IPAddressConverter.ipAddress = ipAddress;
    }

    private static String ipAddress;

    static {
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            ipAddress = "UNKNOWN";
        }
    }

    public String convert(ILoggingEvent iLoggingEvent) {
        return ipAddress;
    }
}
