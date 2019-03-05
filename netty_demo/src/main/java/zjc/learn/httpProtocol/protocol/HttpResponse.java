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
public class HttpResponse implements Serializable {
	private ResponseLine responseLine;

	private ResponseHeader header;

	private ResponsePayload payload;
}

@Data
class ResponseLine implements Serializable {
	private String responseStatus;
	private Integer responseCode;
	private String protocolVersion;
}

@EqualsAndHashCode(callSuper = true)
@Data
class ResponseHeader extends HashMap {

}

@Data
class ResponsePayload implements Serializable {

}