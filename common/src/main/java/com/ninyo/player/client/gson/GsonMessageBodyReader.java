package com.ninyo.player.client.gson;

import com.google.common.base.Charsets;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.ninyo.player.client.gson.GsonService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class GsonMessageBodyReader implements MessageBodyReader<Object> {

    @Override
    public boolean isReadable(final Class<?> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType) {
        return true;
    }

    @Override
    public Object readFrom(final Class<Object> type,
                           final Type genericType,
                           final Annotation[] annotations,
                           final MediaType mediaType,
                           final MultivaluedMap<String, String> httpHeaders,
                           final InputStream entityStream) throws IOException {

        final String json = IOUtils.toString(entityStream, Charsets.UTF_8);
        return new GsonService().fromJson(json, genericType);
    }

}
