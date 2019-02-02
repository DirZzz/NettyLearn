package zjc.learn.HelloNetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.time.LocalDateTime;

/**
 * @author Sandu
 * @ClassName EchoServiceHandler
 * @date 2019/2/1
 */

@ChannelHandler.Sharable
public class EchoServiceHandler extends ChannelInboundHandlerAdapter {


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		String s = buf.toString(CharsetUtil.UTF_8);
		System.out.println(s);
		String reback = "reback msg " + LocalDateTime.now().toString() + ": res_ " + s;
		ctx.writeAndFlush(Unpooled.copiedBuffer(reback,CharsetUtil.UTF_8));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("Eexeption :"+cause.getLocalizedMessage()+" remote address:"+ctx.channel().remoteAddress().toString());
	}
}
