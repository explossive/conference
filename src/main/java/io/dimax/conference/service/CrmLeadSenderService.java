package io.dimax.conference.service;

import io.dimax.conference.model.User;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class CrmLeadSenderService implements LeadSenderService {

    private final String url = "https://itech-testing.bitrix24.ru/";

    private final String queryUrl = "https://itech-testing.bitrix24.ru/rest/1/7weijsnqhivdav32/";

    @Override
    public void send(User data) {
        byte[] postData = "".getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = null;
        HttpURLConnection conn = null;
        try {
            url = new URL(queryUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);
        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
