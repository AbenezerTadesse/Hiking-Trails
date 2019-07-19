package com.Hiking.Trails.controller;

import com.Hiking.Trails.model.Trail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrailStub {
    private static Map<Long, Trail> trailMap = new HashMap<Long, Trail>();
    private static Long idIndex = 3L;


    //seed data for Trails
    static {
        Trail Seed1 = new Trail(1L,"Emerals Lake",3.1,"Moderate",
                "Rocky Mountain National Park",
                "Heavily trafficked trail offering views of Glacier Gorge");
        Trail Seed2 = new Trail(2L,"Hanging Lake",1.2,"Moderate",
                "Glenwood Springs, CO",
                " A natural National Landmark popular for its awe-inspiring beauty and gentle Colorado waterfalls!");
        Trail Seed3 = new Trail(3L,"Royal Arch Trail",3.5,"Hard",
                "Rocky Mountain National Park",
                "Not as grand as some of the arches in Utah but still a really a beautiful sight,");

        trailMap.put(1L, Seed1);
        trailMap.put(2L, Seed2);
        trailMap.put(3L, Seed3);
    }

    public static List<Trail> list(){
        return new ArrayList<Trail>(trailMap.values());
    }

    public static Trail create(Trail trail){
        idIndex ++;
        trail.setId(idIndex);
        trailMap.put(idIndex, trail);
        return trail;
    }

    public static Trail get(Long id){
        return trailMap.get(id);
    }

    public static Trail update(Long id, Trail trail){
        trailMap.put(id,trail);
        return trail;
    }

    public static Trail delete (Long id){
        return trailMap.remove(id);
    }
}
