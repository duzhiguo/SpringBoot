package com.bookmanage.demo.unity;



import java.util.*;

/**
 * 人脸搜索
 */
public class FaceSearchUnity {
    public  AuthUnity authUnity = new AuthUnity();

    public   String search(String img) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", img);
            map.put("liveness_control", "NORMAL");
            map.put("group_id_list", "ren");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = authUnity.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}