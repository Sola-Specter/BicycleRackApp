package com.hopealim.bicyclerackapp.util;

public class Util {

    public static int getUniqueId() {
        String id = Long.toString (System.currentTimeMillis() & 0x00000000FFFFFFFFL);
        id = id.replace("-", "");
        int uniqueId = Integer.parseInt(id);
        return uniqueId;
    }
}
