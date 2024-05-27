package cookie

import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse


class CookieInsecure {
  def danger(res: HttpServletResponse): Unit = {
    // ruleid: scala_cookie_rule-CookieInsecure
    val cookie = new Cookie("key", "value")
    cookie.setHttpOnly(true)
    cookie.setMaxAge(60)
    // ruleid: scala_cookie_rule-CookieInsecure
    cookie.setSecure(true) // danger

    res.addCookie(cookie)
  }

  // cookie.setSecure(true); is missing
  def danger2(res: HttpServletResponse): Unit = {
    // ruleid: scala_cookie_rule-CookieInsecure
    val cookie = new Cookie("key", "value")
    cookie.setHttpOnly(true)
    cookie.setMaxAge(60)
    res.addCookie(cookie)
  }

  def ok(res: HttpServletResponse): Unit = {
    val cookie = new Cookie("key", "value")
    cookie.setHttpOnly(true)
    cookie.setMaxAge(60)
    cookie.setSecure(true) // safe

    res.addCookie(cookie)
  }
}
