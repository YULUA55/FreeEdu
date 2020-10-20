package com.example.freeedu.connection;

import org.springframework.http.HttpMethod;

public class Request {

    public enum urlId {

        TEACHER_COURSES("http://192.168.43.159:8090/teacher/courses");

        private String url;

        urlId(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    private urlId url;
    private HttpMethod method;
    private Long paramId;
    private String bodyJson;

    public Request(urlId url, Long paramId) {
        this.url = url;
        this.method = HttpMethod.GET;
        this.paramId = paramId;
    }

    public Request(urlId url, Long paramId, String bodyJson) {
        this.url = url;
        this.method = HttpMethod.POST;
        this.paramId = paramId;
        this.bodyJson = bodyJson;
    }

    public urlId getUrl() {
        return url;
    }

    public void setUrl(urlId url) {
        this.url = url;
    }


    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public Long getParamId() {
        return paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public String getBodyJson() {
        return bodyJson;
    }

    public void setBodyJson(String bodyJson) {
        this.bodyJson = bodyJson;
    }
}
