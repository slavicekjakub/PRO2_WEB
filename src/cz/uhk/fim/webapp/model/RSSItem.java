package cz.uhk.fim.webapp.model;

public class RSSItem {
    private String title;
    private String description;
    private String link;
    private String pubDate;
    private String autor;

    public RSSItem() {
    }

    public RSSItem(String title, String description, String link, String pubDate, String autor) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.pubDate = pubDate;
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public RSSItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
