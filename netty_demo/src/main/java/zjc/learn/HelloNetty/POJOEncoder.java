package zjc.learn.HelloNetty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author Sandu
 * @ClassName POJOEncoder
 * @date 2019/2/2-11:32$
 */
@ChannelHandler.Sharable
public class POJOEncoder extends ChannelOutboundHandlerAdapter {
	private final Gson gson = new GsonBuilder().create();

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
//		ByteBuf byteBuf = ctx.alloc().directBuffer();
//		byteBuf.writeCharSequence(gson.toJson(msg), CharsetUtil.UTF_8);
		ctx.writeAndFlush(msg, promise);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

		System.out.println(cause.getMessage());
	}
}
