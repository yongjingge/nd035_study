package com.udacity.course2.consuming.consumingREST.entity;

/**
 * matches the JSON response returned from API
 */
public class Film {
    private Integer id;
    private String title;
    private String description;
    private String director;
    private String producer;
    private String release_date; // release year of film
    private String rt_score; // Rotten Tomato score of film
    private String people; // People found in film
    private String species; // Species found in film
    private String locations; // Locations found in film
    private String url; // URL of film


    @Override
    public String toString() {
        return "Film " + title + " fetched successfully!";
    }

    public Film() {
    }

    public Film(Integer id, String title, String description, String director, String producer, String release_date, String rt_score, String people, String species, String locations, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
        this.rt_score = rt_score;
        this.people = people;
        this.species = species;
        this.locations = locations;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRt_score() {
        return rt_score;
    }

    public void setRt_score(String rt_score) {
        this.rt_score = rt_score;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
