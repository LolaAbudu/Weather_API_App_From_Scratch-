package org.pursuit.weatherapiappfromscratch.model;

import java.time.Period;
import java.util.List;

public class Response {

    private List<Periods> periods;

    public List<Periods> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Periods> periods) {
        this.periods = periods;
    }
}
