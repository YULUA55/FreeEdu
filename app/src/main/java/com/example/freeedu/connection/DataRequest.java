package com.example.freeedu.connection;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public class DataRequest {

    public static enum urlId {

        TEACHER_COURSES(HttpMethod.GET, "http://192.168.31.252:8090/teacher/courses"),
        COURSE_LESSONS(HttpMethod.GET, "http://192.168.31.252:8090/course/lessons"),
        TEACHER_LESSONS(HttpMethod.GET, "http://192.168.31.252:8090/teacher/schedule"),
        STUDENT_LESSONS(HttpMethod.GET, "http://192.168.31.252:8090/student/schedule"),
        GET_TEACHER(HttpMethod.GET, "http://localhost:8090/teacher/getTeacher");

        private HttpMethod method;
        private String url;

        urlId(HttpMethod method, String url) {
            this.method = method;
            this.url = url;
        }

        public HttpMethod getMethod() {
            return method;
        }

        public String getUrl() {
            return url;
        }
    }

    private urlId url;
    private HttpHeaders headers;
    private String params;
    private String bodyJson;

    public DataRequest(urlId url, HttpHeaders headers, String params, String bodyJson) {
        this.url = url;
        this.headers = headers;
        this.params = params;
        this.bodyJson = bodyJson;
    }

    public urlId getUrl() {
        return url;
    }

    public void setUrl(urlId url) {
        this.url = url;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getBodyJson() {
        return bodyJson;
    }

    public void setBodyJson(String bodyJson) {
        this.bodyJson = bodyJson;
    }

    public static class DataRequestBuilder {
        private urlId url;
        private HttpHeaders headers;
        private String params;
        private String bodyJson;

        public DataRequestBuilder setUrl(DataRequest.urlId urlId) {
            this.url = urlId;
            return this;
        }

        public DataRequestBuilder setHeaders(HttpHeaders headers) {
            this.headers = headers;
            return this;
        }

        public DataRequestBuilder setParams(String params) {
            this.params = params;
            return this;
        }

        public DataRequestBuilder setBody(String body) {
            this.bodyJson = body;
            return this;
        }

        public DataRequest build() {
            return new DataRequest(url, headers, params, bodyJson);
        }

    }
}
