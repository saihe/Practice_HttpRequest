package ksaito.practice.httpRequest;

import java.io.IOException;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.testing.json.MockJsonFactory;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

/**
 * HttpRequestを投げるアプリケーション.
 */
@Slf4j
public class Application {

  /**
   * メイン.
   * @param args 引数　１：プロパティファイルのパス
   */
  public static void main (String[] args) {
    // HTTP Request
    HttpRequestFactory httpRequestFactory = new NetHttpTransport.Builder()
      .build()
      .createRequestFactory();
    try {
      val response = httpRequestFactory
        .buildPostRequest(
          new GenericUrl("https://leben01.webhook.office.com/webhookb2/59523e37-d403-47e7-b24d-a2bc3ee282b4@bd159a5c-bd99-430a-91da-e170f3d1edaa/IncomingWebhook/57f71409b4ca47eaaea3d754c1d98371/e5b3d776-7d3d-4867-93e1-22ededd6f22f")
          , new JsonHttpContent(
            new MockJsonFactory()
            , "{'text': 'WebHookのテスト'}"
          )
        )
        .execute();
      log.info(response.parseAsString());
    } catch (IOException e) {
      log.error("リクエストエラー", e);
    }
  }
}
