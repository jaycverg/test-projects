package com.catapult.em.util;

import java.util.Collection;

/**
 *
 * @author jvergara
 */
public class CollectionUtil
{
    public static String join(Collection col, String delimiter)
    {
        StringBuilder builder = new StringBuilder();
        boolean firstItem = true;
        for(Object item : col) {
            if( !firstItem ) 
                builder.append(delimiter);
            else
                firstItem = false;
            
            builder.append(item);
        }
        return builder.toString();
    }
}