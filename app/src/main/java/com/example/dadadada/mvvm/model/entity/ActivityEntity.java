package com.example.dadadada.mvvm.model.entity;

import java.util.List;

public class ActivityEntity {


        private int id;
        private int activetypeid;
        private String activename;
        private int lon;
        private int lat;
        private String locationname;
        private String starttime;
        private String activedesc;
        private String owner;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getActivetypeid() {
            return activetypeid;
        }

        public void setActivetypeid(int activetypeid) {
            this.activetypeid = activetypeid;
        }

        public String getActivename() {
            return activename;
        }

        public void setActivename(String activename) {
            this.activename = activename;
        }

        public int getLon() {
            return lon;
        }

        public void setLon(int lon) {
            this.lon = lon;
        }

        public int getLat() {
            return lat;
        }

        public void setLat(int lat) {
            this.lat = lat;
        }

        public String getLocationname() {
            return locationname;
        }

        public void setLocationname(String locationname) {
            this.locationname = locationname;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getActivedesc() {
            return activedesc;
        }

        public void setActivedesc(String activedesc) {
            this.activedesc = activedesc;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

}
