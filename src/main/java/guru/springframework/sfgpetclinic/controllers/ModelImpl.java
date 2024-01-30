package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;

import java.util.HashMap;

public class ModelImpl implements Model {

    private HashMap<String, Object> map;

    ModelImpl() {
       map = new HashMap<>();
    }

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key,o);
    }

    @Override
    public void addAttribute(Object o) {
        map.put(o.toString(), o);
    }

    public HashMap<String, Object> getMap() {
        return map;
    }
}
