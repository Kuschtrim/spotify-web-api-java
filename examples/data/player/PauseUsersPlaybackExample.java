package data.player;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.player.PauseUsersPlaybackRequest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class PauseUsersPlaybackExample {
  private static final String accessToken = "taHZ2SdB-bPA3FsK3D7ZN5npZS47cMy-IEySVEGttOhXmqaVAIo0ESvTCLjLBifhHOHOIuhFUKPW1WMDP7w6dj3MAZdWT8CLI2MkZaXbYLTeoDvXesf2eeiLYPBGdx8tIwQJKgV8XdnzH_DONk";

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setAccessToken(accessToken)
          .build();
  private static final PauseUsersPlaybackRequest pauseUsersPlaybackRequest = spotifyApi.pauseUsersPlayback()
          .device_id("5fbb3ba6aa454b5534c4ba43a8c7e8e45a63ad0e")
          .build();

  public static void pauseUsersPlayback_Sync() {
    try {
      final String string = pauseUsersPlaybackRequest.execute();

      System.out.println("Null: " + string);
    } catch (IOException | SpotifyWebApiException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void pauseUsersPlayback_Async() {
    try {
      final Future<String> stringFuture = pauseUsersPlaybackRequest.executeAsync();

      // ...

      final String string = stringFuture.get();

      System.out.println("Null: " + string);
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("Error: " + e.getCause().getMessage());
    }
  }
}