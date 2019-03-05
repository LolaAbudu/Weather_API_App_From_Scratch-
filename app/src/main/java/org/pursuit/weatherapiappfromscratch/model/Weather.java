package org.pursuit.weatherapiappfromscratch.model;

import java.util.List;

public class Weather {

    private List<Response> response;

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }
}
