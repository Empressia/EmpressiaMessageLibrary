package jp.empressia.message;

import java.util.Locale;

import jp.empressia.message.util.MessageUtilities;

/**
 * メッセージ、および、メッセージのテンプレートを表現します。
 * @author すふぃあ
 */
public class MessageTemplate {

	/** 指定なしの引数用の定義。 */
	private static final Object[] EMPTY_ARGS = new Object[] {};

	/** メッセージ、および、メッセージのテンプレートのID。 */
	private String ID;

	/** メッセージ、および、メッセージのテンプレートのID。 */
	public String getID() { return this.ID; }

	/**
	 * コンストラクタ。
	 * @param ID メッセージ、および、メッセージのテンプレートのID。
	 */
	protected MessageTemplate(String ID) { this.ID = ID; }

	/** メッセージを構築して提供します。 */
	protected String format(String location, Object[] args) {
		String result = MessageUtilities.format(location, this.getID(), args, Locale.getDefault());
		return result;
	}

	/** メッセージを構築して提供します。 */
	protected String format(String location, Object[] args, Locale locale) {
		String result = MessageUtilities.format(location, this.getID(), args, locale);
		return result;
	}

	/** メッセージを構築して提供します。 */
	protected String format(String location) {
		return this.format(location, EMPTY_ARGS);
	}

	/** メッセージを構築して提供します。 */
	protected String format(String location, Locale locale) {
		return this.format(location, EMPTY_ARGS, locale);
	}

}
