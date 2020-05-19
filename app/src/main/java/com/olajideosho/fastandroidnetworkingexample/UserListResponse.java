package com.olajideosho.fastandroidnetworkingexample;

import java.util.List;

public class UserListResponse {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<UserObject> data;
    public AdvertObject ad;

    public UserListResponse() {
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<UserObject> getData() {
        return data;
    }

    public AdvertObject getAd() {
        return ad;
    }
}
