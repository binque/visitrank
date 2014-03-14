package com.m3958.visitrank;

import org.vertx.java.core.Handler;
import org.vertx.java.core.MultiMap;
import org.vertx.java.core.eventbus.EventBus;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.platform.Verticle;

import com.m3958.visitrank.httpentry.PageCountProceesor;

/**
 * 
 * @author jianglibo@gmail.com
 * 
 */
public class CounterVerticle extends Verticle {

  public void start() {
    JsonObject config = container.config();
//    final Logger log = container.logger();
    vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
      public void handle(final HttpServerRequest req) {
        MultiMap mm = req.params();
        String out = mm.get("out");
        // out, output,possible values:
        // pagecount(default),sitecount,catcount,sitehotest,cathotest,none
        EventBus eb = vertx.eventBus();
        Logger log = container.logger();
        if ("sitecount".equals(out)) {

        } else if ("catcount".equals(out)) {

        } else if ("sitehotest".equals(out)) {

        } else if ("cathotest".equals(out)) {

        } else {
          new PageCountProceesor(eb, req, log).process();
        }
      }
    }).listen(config.getInteger("port"));
    
    container.logger().info("CounterVerticle started");
  }
}


// public String getClientIpAddr(HttpServerRequest req) {
// MultiMap mm = req.headers();
// String ip = mm.get("X-Forwarded-For");
// if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
// ip = mm.get("Proxy-Client-IP");
// }
// if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
// ip = mm.get("WL-Proxy-Client-IP");
// }
// if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
// ip = mm.get("HTTP_CLIENT_IP");
// }
// if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
// ip = mm.get("HTTP_X_FORWARDED_FOR");
// }
// if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
// ip = req.remoteAddress().getAddress().getHostAddress();
// }
// return ip;
// }

// vertx runmod com.m3958~visitrank~0.0.1-SNAPSHOT
// office fa5f2e1d-092a-4c8c-9518-f5b7600f8f80
// curl --referer http://www.example.com
// http://localhost:8333?siteid=fa5f2e1d-092a-4c8c-9518-f5b7600f8f80
// vertx runzip target/visitrank-0.0.1-SNAPSHOT-mod.zip
// vertx runmod com.m3958~visitrank~0.0.1-SNAPSHOT -conf conf.json

