package kr.gilju.lombok_ex;

import java.util.List;

import com.google.gson.Gson;

import kr.gilju.helpers.FileHelper;
import kr.gilju.model.Data03;

public class App03 {
   public static void main(String[] args) {
    String json = null;

    try {
      json = FileHelper.getInstance().readString("res/03.json");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }

      // System.out.println(json);

    Gson gson = new Gson();
    Data03 data = gson.fromJson(json, Data03.class);
    // System.out.println(data.getMessage());

    List<String> items = data.getItem();

    // for (int i = 0; i < items.size(); i++) {
    //     System.out.println(items.get(i));
    // }

    for(String item : items) {
      System.out.println(item);
    }
  }
}
