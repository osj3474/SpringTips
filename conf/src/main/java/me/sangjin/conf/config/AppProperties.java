package me.sangjin.conf.config;

import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {
    private static final String AppPropertyFile = "application.properties";
    private static final Properties Prop = new Properties();

    static {
        load();   // 어플리케이션 시작 시점에 load 한번 되게 하기 위해서.
    }


    // application.properties 를 읽는 함수
    private static void load() {
        FileInputStream fileInputStream = null;  // close를 할지 말지 null로 판단하기 위함.

        try{
            ClassPathResource classPathResource = new ClassPathResource(AppPropertyFile);
            fileInputStream = new FileInputStream(classPathResource.getFile());
            Prop.load(fileInputStream);

        } catch(IOException e) {
            // logging 필요
            // 파일을 못 읽었습니다.
        } finally {
            if(fileInputStream != null) {
                try{
                    fileInputStream.close();
                } catch(IOException e){
                }
            }
        }
    }

    // keyName에 해당되는 value를 반환하는 함수
    public static String getProperty(String keyName) {
        String value = Prop.getProperty(keyName);
        if (value == null){
            return "";
        }
        return value;
    }
}
