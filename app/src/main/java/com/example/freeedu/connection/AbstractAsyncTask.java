package com.example.freeedu.connection;

import android.os.AsyncTask;

import com.example.freeedu.presenters.BasePresenter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


public class AbstractAsyncTask extends AsyncTask<Request, Void, String> {

    BasePresenter presenter;

    public AbstractAsyncTask(BasePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected String doInBackground(Request... requests) {
        HttpEntity<String> response = null;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        switch (requests[0].getMethod()) {
            case GET: {
                UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(requests[0].getUrl().getUrl())
                        .queryParam("id", requests[0].getParamId());
                System.out.println(builder.build().toUriString());
                HttpEntity<?> request = new HttpEntity<>(headers);

                response = restTemplate.exchange(
                        builder.build().toUriString(),
                        HttpMethod.GET,
                        request,
                        String.class);

                break;
            }
            case POST: {
                HttpEntity<String> request = new HttpEntity<String>(requests[0].getBodyJson(), headers);
                response = restTemplate.exchange(requests[0].getUrl().getUrl(), HttpMethod.POST, request, String.class);
                break;
            }

        }

        return response.getBody();
    }

    @Override
    protected void onPostExecute(String json) {
        presenter.updateModel(json);
    }
}
