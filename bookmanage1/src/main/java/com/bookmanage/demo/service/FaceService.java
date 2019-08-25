package com.bookmanage.demo.service;


import com.bookmanage.demo.unity.FaceAddUnity;
import com.bookmanage.demo.unity.FaceDetectUnity;
import com.bookmanage.demo.unity.FaceSearchUnity;
import org.springframework.stereotype.Service;

@Service
public class FaceService {
    private FaceAddUnity faceAddUnity = new FaceAddUnity();
    private FaceDetectUnity faceDetectUnity = new FaceDetectUnity();
    private FaceSearchUnity faceSearchUnity = new FaceSearchUnity();

    public String useradd(String str,String account ){
        String result= faceAddUnity.add(str,account);
        return result;
    }
    public String userDetect(String str){
       String result = faceDetectUnity.detect(str);
       return result;
    }
    public  String useSearch(String str){
         String res = faceSearchUnity.search(str);
         return res;
    }
}
