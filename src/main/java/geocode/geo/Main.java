package geocode.geo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Main {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ssss");

    public static void main(String[] args) {

        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())));
        System.out.println(ReverseGeo.queryCountryNameByGeo(30.5728, 104.0668));
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())));
        System.out.println(ReverseGeo.queryCountryNameByGeo(30.5728, 104.0668));
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())));
        System.out.println(ReverseGeo.queryCountryNameByGeo(30.5728, 104.0668));
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())));
        System.out.println(ReverseGeo.queryCountryNameByGeo(30.5728, 104.0668));
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())));
        System.out.println(ReverseGeo.queryCountryNameByGeo(30.5728, 104.0668));
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())));
        System.out.println(ReverseGeo.queryCountryNameByGeo(30.5728, 104.0668));
    }
}
