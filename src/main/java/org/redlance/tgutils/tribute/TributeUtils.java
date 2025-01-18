package org.redlance.tgutils.tribute;

import org.redlance.common.utils.ServerUtils;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class TributeUtils {
    private static final String TG_WEB_APP_DATA_KEY = "tgWebAppData=";

    public static String formatTokenFromUrl(String url) {
        return TributeUtils.formatTokenFromWebAppData(url.substring(
                url.lastIndexOf(TG_WEB_APP_DATA_KEY) + TG_WEB_APP_DATA_KEY.length()
        ));
    }

    public static String formatTokenFromWebAppData(String webAppData) {
        Map<String, String> query = ServerUtils.getQuery(
                URLDecoder.decode(URLDecoder.decode(webAppData, StandardCharsets.UTF_8), StandardCharsets.UTF_8)
        );

        byte[] re = ("auth_date=" + query.get("auth_date") + "\nquery_id=" + query.get("query_id") + "\nsignature=" + query.get("signature") + "\nuser=" + query.get("user").replace("\\/", "/"))
                .getBytes(StandardCharsets.UTF_8);

        String rawToken = "1;" + Base64.getEncoder().encodeToString(re) + ";" + query.get("hash");
        return Base64.getEncoder().encodeToString(rawToken.getBytes(StandardCharsets.UTF_8));
    }
}
