package geocode.geo;

import geocode.GeoName;
import geocode.ReverseGeoCode;

import java.io.InputStream;
import java.util.Optional;


public class ReverseGeo {
    private static ReverseGeo instance = new ReverseGeo();
    private final InputStream inputStream;
    private ReverseGeoCode reverseGeoCode;

    public ReverseGeo() {
        inputStream = this.getClass().getResourceAsStream("/cities1000.txt");
        try {
            reverseGeoCode = new ReverseGeoCode(inputStream, false);
        } catch (Exception ex) {
            //todo

        }
    }

    public static Optional<String> queryCountryNameByGeo(double latitude, double longitude) {
        if (latitude > 90.0 || latitude < -90.0) {
            return Optional.empty();
        }
        if (longitude > 180.0 || longitude < -180.0) {
            return Optional.empty();
        }

        if (instance != null && instance.reverseGeoCode != null) {
            GeoName geoName = instance.reverseGeoCode.nearestPlace(latitude, longitude);
            if (geoName != null && geoName.country != null) {
                return Optional.of(geoName.country);
            }
        }

        return Optional.empty();
    }
}
