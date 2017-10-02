package com.example.dragonsage.listview;

/**
 * Created by DragonSage on 5/30/2017.
 */

public class AdapterItem {

    public int ID;
    public String JobTitle;
    public String Description;

    AdapterItem(int ID, String JobTitle, String Description){

        this.ID = ID;
        this.JobTitle = JobTitle;
        this.Description = Description;

    }
}
