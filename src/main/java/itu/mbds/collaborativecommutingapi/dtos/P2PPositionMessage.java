package itu.mbds.collaborativecommutingapi.dtos;

public class P2PPositionMessage {
    private String conducteurId;
    private String rideId;
    private double latitude;
    private double longitude;

    public String getConducteurId() {
        return conducteurId;
    }

    public void setConducteurId(String conducteurId) {
        this.conducteurId = conducteurId;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
