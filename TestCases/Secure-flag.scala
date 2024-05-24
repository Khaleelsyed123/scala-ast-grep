package xml

import org.opensaml.xml.parse.BasicParserPool
import org.opensaml.xml.parse.ParserPool
import org.springframework.context.annotation.Bean


class SAMLIgnoreComments {
  @Bean private[xml] def parserPool = {
    val pool = new BasicParserPool
    // ruleid: secure-flag
    pool.setIgnoreComments(false)
    pool
  }

  @Bean private[xml] def parserPool2(): Unit = {
    val shouldIgnore = false
    val pool = new BasicParserPool
    // ruleid: instance-secure-flag
    pool.setIgnoreComments(shouldIgnore)
  }
}
