package jp.empressia.message.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

import jp.empressia.message.DefaultMessageProvider;
import jp.empressia.message.MessageProvider;

/**
 * メッセージの展開に関するユーティリティです。
 * @author すふぃあ
 */
public class MessageUtilities {

	/** メッセージ用の文字列を提供するProvider。 */
	private static MessageProvider MessageProvider = loadMessageProvider();

	/** メッセージ用の文字列を提供するProviderを読み込みします。 */
	public static MessageProvider loadMessageProvider() {
		ServiceLoader<MessageProvider> loader = ServiceLoader.loadInstalled(MessageProvider.class);
		MessageProvider provider = loader.findFirst().orElse(new DefaultMessageProvider());
		MessageFormats.clear();
		return provider;
	}

	/**
	 * メッセージ用の文字列をフォーマットとして、再利用するために維持します。
	 * 同じメッセージが同時に大量アクセスされない想定でいるので、ThreadLocalは使っていません。
	 * ThreadLocalするくらいなら、MessageFormatがスレッドセーフであるべきだと思っています。
	 */
	private static ConcurrentHashMap<String, MessageFormat> MessageFormats = new ConcurrentHashMap<String, MessageFormat>();

	/** フォーマットされたメッセージを返します。 */
	public static String format(String ID, Object[] args, Locale locale) {
		String result = MessageProvider.get(ID, locale);
		if(args.length > 0) {
			MessageFormat formatter = MessageFormats.computeIfAbsent(result, MessageFormat::new);
			// 同じFormatterが同時に呼ばれる可能性は高くないと思うから、
			// ThreadLocalではなく、synchronizedにしています。
			synchronized(formatter) {
				result = formatter.format(args);
			}
		}
		return result;
	}

}
