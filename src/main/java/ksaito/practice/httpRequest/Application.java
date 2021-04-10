package ksaito.practice.httpRequest;

import java.io.IOException;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
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
        .buildGetRequest(new GenericUrl("https://google.co.jp"))
        .execute();
      log.info(response.parseAsString());
    } catch (IOException e) {
      log.error("リクエストエラー", e);
    }
  }
}
