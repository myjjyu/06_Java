package kr.gilju.model;


public class Data04 {
  private Rss rss;

    public Rss getRss() {
        return rss;
    }

    public void setRss(Rss rss) {
        this.rss = rss;
    }

    @Override
    public String toString() {
      return "Data04 [rss=" + rss + "]";
    }

    public class Rss {
      private Item item;

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        @Override
        public String toString() {
          return "Rss [item=" + item + "]";
        }
    

    public class Item {
      private String title;
      private String description;
      private String pubDate;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


    @Override
    public String toString() {
      return "Item [title=" + title + ", description=" + description + ", pubDate=" + pubDate + "]";
    }
    }
}
}