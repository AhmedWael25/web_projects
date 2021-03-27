package org.util;

import java.util.UUID;

public class UUIDProvider  {
    
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
