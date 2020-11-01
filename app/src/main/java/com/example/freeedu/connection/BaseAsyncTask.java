package com.example.freeedu.connection;

import android.os.AsyncTask;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;


public class BaseAsyncTask extends AsyncTask<DataRequest, Void, String> {

    BaseRequestResultListener listener;

    public BaseAsyncTask(BaseRequestResultListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(DataRequest... dataRequests) {
        //HttpEntity<String> response = null;
        String response = null;
        try {

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

            HttpEntity<?> request = new HttpEntity<>(dataRequests[0].getBodyJson(), dataRequests[0].getHeaders());
            System.out.println(dataRequests[0].getUrl().getUrl() + dataRequests[0].getParams());

            response = restTemplate.getForObject(
                    dataRequests[0].getUrl().getUrl() + dataRequests[0].getParams(),
                    String.class);

        } catch (Exception e) {
            listener.notifyAboutError(e.getMessage());
        }

        return response;
    }

    @Override
    protected void onPostExecute(String json) {
        listener.notifyAboutSuccess(json);
    }
}
