package zjc.learn.HelloNetty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.netty.buffer.Unpooled;
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
		System.out.println("it's POJOEncoder;");
		String s;
		if (msg instanceof UserBean) {
			UserBean userBean = (UserBean) msg;
			s = gson.toJson(userBean);
		}else{
			s = msg.toString();
		}
		ctx.write(Unpooled.copiedBuffer(s.getBytes()),promise);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println(cause.getMessage());
	}
}
