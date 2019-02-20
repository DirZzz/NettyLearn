package zjc.learn.HelloNetty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author Sandu
 * @ClassName POJODecoder
 * @date 2019/2/2-11:45$
 */
@ChannelHandler.Sharable
public class POJODecoder extends ChannelInboundHandlerAdapter {
	private final Gson gson = new GsonBuilder().create();

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("it's pojoDecoder");
		ByteBuf buf = (ByteBuf) msg;
		byte[] bytes = new byte[buf.readableBytes()];
		buf.readBytes(bytes);

		System.out.println(new String(bytes, CharsetUtil.UTF_8));
		msg = gson.fromJson(new String(bytes), UserBean.class);
		System.out.println(msg);
		ctx.fireExceptionCaught(new RuntimeException("make error"));
		ctx.fireChannelRead(msg);
	}
}
