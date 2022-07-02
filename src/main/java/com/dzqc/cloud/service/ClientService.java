package com.dzqc.cloud.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 * @file: ClientService.java
 * @time: 2022/7/2 18:28
 * @Author by Pking
 */

@Service
public class ClientService {


    public String sendMessageAndGetResultOfClassification(String s) {
        // s is the case, which is like “性别，年龄。症状”
        // for example: "女，10岁。高烧不退，还有经常性的咳嗽"
        Socket socket = null;
        String Code_Adress = "43.138.65.17";
        try {
            socket = new Socket(Code_Adress,9008); // 9008 is the classification port
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            outputStream.write(s.getBytes());
            int len = inputStream.read(bytes);
            String result = new String(bytes,0,len);
            //System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String sendMessageAndGetResultOfCasePrediction(String s) {
        // s is the case, which is like “性别，年龄。症状”
        // for example: "女，10岁。高烧不退，还有经常性的咳嗽"
        Socket socket = null;
        String Code_Adress = "43.138.65.17"; // server ip address
        try {
            socket = new Socket(Code_Adress,9007); // 9007 is the case prediction port
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            outputStream.write(s.getBytes());
            int len = inputStream.read(bytes);
            String result = new String(bytes,0,len);
            //System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}

