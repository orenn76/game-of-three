package com.ninyo.player.client.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import org.springframework.stereotype.Service;

@Service
    public class GsonService
{
    private static final Gson GSON = new GsonBuilder().serializeNulls().create();

    public String toJson(Object src)
    {
        return GSON.toJson(src);
    }

    public void toJson(Object src, Type typeOfSrc, Appendable writer)
    {
        GSON.toJson(src, typeOfSrc, writer);
    }

    public <T> T fromJson(String json, Type typeOfT)
    {
        return (T)GSON.fromJson(json, typeOfT);
    }
}
