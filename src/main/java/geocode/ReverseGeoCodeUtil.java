package geocode;

import geocode.kdtree.KDTree;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;

@Slf4j
public class ReverseGeoCodeUtil {
  private static KDTree<GeoName> kdTree;

  private final String filePath = "/cities1000.txt";

  private static InputStream inputStream;


  public static ReverseGeoCodeUtil reverseGeoCodeUtil;

  static {
    reverseGeoCodeUtil = new ReverseGeoCodeUtil();
  }

  public ReverseGeoCodeUtil(){
    try {
      inputStream=this.getClass().getResourceAsStream(filePath);
      ReverseGeoCode(inputStream, true);
      log.info("ReverseGeoCodeUtil init ! ....");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void ReverseGeoCode(InputStream placenames, boolean majorOnly) throws IOException {
    createKdTree(inputStream, majorOnly);
  }

  private static void createKdTree(InputStream placenames, boolean majorOnly) throws IOException {
    ArrayList<GeoName> arPlaceNames;
    arPlaceNames = new ArrayList<GeoName>();
    // Read the geonames file in the directory.
    BufferedReader in = new BufferedReader(new InputStreamReader(placenames));
    String str;
    try {
      while ((str = in.readLine()) != null) {
        GeoName newPlace = new GeoName(str);
        if (!majorOnly || newPlace.majorPlace) {
          arPlaceNames.add(newPlace);
        }
      }
    } catch (IOException ex) {
      throw ex;
    } finally {
      in.close();
    }
    kdTree = new KDTree<GeoName>(arPlaceNames);
  }

  public static GeoName nearestPlace(double latitude, double longitude) {
    log.info("NearestPlace method is called.");
    return kdTree.findNearest(new GeoName(latitude, longitude));
  }


}
