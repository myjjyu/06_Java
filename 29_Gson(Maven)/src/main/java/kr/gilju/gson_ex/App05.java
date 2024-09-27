package kr.gilju.gson_ex;

import com.google.gson.Gson;

import kr.gilju.helpers.FileHelper;
import kr.gilju.model.Data05;

public class App05 {
  
     public static void main(String[] args) {
    String json = null;

    try {
      json = FileHelper.getInstance().readString("res/05.json");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }

  // System.out.println(json);

    Gson gson = new Gson();
    Data05 data = gson.fromJson(json, Data05.class);
    // System.out.println(data.toString());

    for(Data05.Rss.Item item : data.getRss().getItem()) {
      System.out.println(item);
    }
  }
}
