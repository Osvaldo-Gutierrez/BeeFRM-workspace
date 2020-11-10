/*
 *   Copyright (c) 2019 by agustinlarrea@sapientiasoft.cl All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF agustinlarrea@sapientiasoft.cl
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.util;


import java.io.*;

import java.util.*;
import java.util.regex.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2016).
 *
 */
public class Util {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(Util.class);

    /******************************************************************************
     * findFile
     ******************************************************************************/
    /**
     *
     * @param path TODO_javadoc
     * @param filename TODO_javadoc
     *
     */
    public static String findFile(String path, String filename) {

      //logger.debug("entrando a 'findFile(" + path + "," + filename + ")' ...");

        if (!(new File(path)).exists()) {

          //logger.debug("'" + path + "' no existe.");

            return null;
        }

        //

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < filename.length(); i++) {

            if (filename.charAt(i) == '.') {
                sb.append('\\');
            }

            sb.append(filename.charAt(i));
        }

        //

        Pattern pattern = Pattern.compile("^" + sb.toString() + "[_;]([0-9]+)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = null;

        //

        File[]  list = (new File(path)).listFiles(new IncludeFileFilter(pattern));

        String result = null;
        int    max    = Integer.MIN_VALUE;
        int    ver;

        for (int i = 0; i < list.length; i++) {

            if (list[i].isFile()) {

                matcher = pattern.matcher(list[i].getName());

                if (matcher.find()) {

                    ver = Integer.parseInt(list[i].getName().substring(matcher.start(1), matcher.end(1)));

                    if (ver > max) {

                        result = path + "/" + list[i].getName(); // list[i].getAbsolutePath();
                        max    = ver;
                    }
                }
            }
        }

        return result;
    }

}
