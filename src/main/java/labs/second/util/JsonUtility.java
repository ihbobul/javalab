package labs.second.util;

import com.google.gson.Gson;

public class JsonUtility {

  private static final Gson gson = new Gson();

  public static <T> String toJson(T object) {
    return gson.toJson(object);
  }

  public static <T> T fromJson(String json, Class<T> clazz) {
    return gson.fromJson(json, clazz);
  }
}
