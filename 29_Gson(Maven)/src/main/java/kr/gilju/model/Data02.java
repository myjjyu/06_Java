package kr.gilju.model;

public class Data02 {
  private String tiile;
  private String description;
  private String pubDate;

    public String getTiile() {
        return tiile;
    }

    public void setTiile(String tiile) {
        this.tiile = tiile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
      return "Data02 [tiile=" + tiile + ", description=" + description + ", pubDate=" + pubDate + "]";
    }  
}
