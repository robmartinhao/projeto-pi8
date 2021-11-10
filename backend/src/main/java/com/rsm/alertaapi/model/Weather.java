package com.rsm.alertaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private Current current;
    private Location location;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Current {" +
                "temperatura_c= " + current.getTemp_c() +
                ", precipitação= " + current.getPrecip_mm() +
                ", wind_kph" + current.getWind_kph() +
                '}' + '\n' +
                "Location {" +
                "name= " + location.getName() +
                ", region= " + location.getRegion() +
                ", lat= " + location.getLat() +
                ", lon= " + location.getLon();
    }
}
