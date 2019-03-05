package zjc.learn.httpProtocol.protocol;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Sandu
 * @ClassName HttpRequest
 * @date 2019/2/22-16:07$
 */
@Data
public class HttpRequest implements Serializable {
	private RequestLine line;

	private RequestHeader header;

	private RequestPayload payload;

}

/**
 * 请求行
 */
@Data
class RequestLine implements Serializable {
	private String requestMethod;
	private String url;
	private String protocolVersion;
}

/**
 * 请求头
 */
@EqualsAndHashCode(callSuper = true)
@Data
class RequestHeader extends HashMap {

}


/**
 * 请求负载
 */
@Data
class RequestPayload implements Serializable {

}