package zjc.learn.HelloNetty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author Sandu
 * @ClassName EchoClientHandler
 * @date 2019/2/1-17:30$
 */

@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {



	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		System.out.println("client recive msg: "+msg.toString(CharsetUtil.UTF_8));
}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
//		ctx.writeAndFlush(Unpooled.copiedBuffer("hello netty", CharsetUtil.UTF_8));
		ctx.writeAndFlush(new UserBean("timer",123));
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
		System.out.println("client write done....");
	}
}
