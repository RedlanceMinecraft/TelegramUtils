package org.redlance.tgutils.tribute.requester;

import com.github.mizosoft.methanol.MutableRequest;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import io.github.kosmx.emotes.server.config.Serializer;
import org.redlance.common.utils.requester.Requester;
import org.redlance.tgutils.tribute.requester.obj.TributeDashboard;
import org.redlance.tgutils.tribute.requester.obj.TributeDonationRequest;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

public class TributeRequester {
    public static TributeDashboard requestDashboard(String token, String mode) throws IOException, InterruptedException {
        HttpRequest request = MutableRequest.create()
                .uri("https://tribute.tg/api/v4/dashboard?mode=" + mode)
                .header("authorization", "TgAuth " + token)
                .build();

        return Requester.sendRequest(request, TributeDashboard.class);
    }

    @SuppressWarnings("unchecked")
    public static List<TributeDonationRequest> requestDonationRequests(String token) throws IOException, InterruptedException {
        HttpRequest request = MutableRequest.create()
                .uri("https://tribute.tg/api/v4/donation_requests")
                .header("authorization", "TgAuth " + token)
                .build();

        JsonObject response = Requester.sendRequest(request, JsonObject.class);
        if (!response.has("donationRequests")) {
            throw new NullPointerException(response.toString());
        }

        return (List<TributeDonationRequest>) Serializer.serializer.fromJson(
                response.getAsJsonArray("donationRequests"),
                TypeToken.getParameterized(List.class, TributeDonationRequest.class)
        );
    }
}
