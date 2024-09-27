package kr.gilju.gson_ex;

import com.google.gson.Gson;

import kr.gilju.helpers.FileHelper;
import kr.gilju.model.Data02;

public class App02 {

  public static void main(String[] args) {
    String json = null;

    try {
      json = FileHelper.getInstance().readString("res/02.json");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }

    Gson gson = new Gson();
    Data02 data = gson.fromJson(json, Data02.class);
    System.out.println(data.toString());
  }

}
