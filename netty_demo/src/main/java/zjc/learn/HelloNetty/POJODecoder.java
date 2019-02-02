package zjc.learn.HelloNetty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author Sandu
 * @ClassName POJODecoder
 * @date 2019/2/2-11:45$
 */
@ChannelHandler.Sharable
public class POJODecoder extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

	}
}
